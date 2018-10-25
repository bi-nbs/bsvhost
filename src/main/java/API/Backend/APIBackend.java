package API.Backend;

import API.Vhost.Directive;
import API.Vhost.Vhost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class APIBackend extends Database implements Backend {

    private static Logger logger = LogManager.getLogger();

    public List<Vhost> getAllVhosts() {
        List<Vhost> vhostsToReturn = new ArrayList<>();
        ResultSet resultSet = this.executeQuery("SELECT `ID`, `port`, `serverName`, `serverAlias` FROM `vhosts` LIMIT 1000;");


        try{
            while (resultSet.next()){
                Vhost tempHost = new Vhost(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        new ArrayList<Directive>());

                this.fillDirectivesInVhost(tempHost);

                vhostsToReturn.add(tempHost);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return vhostsToReturn;
    }

    @Override
    public Vhost getVhost(int id) {
        Vhost tempVhost = null;
        ResultSet resultSet = this.executeQuery("SELECT `ID`, `port`, `serverName`, `serverAlias` FROM `vhosts` WHERE `ID` = '"+ id +"' LIMIT 1;");

        try {
            if(resultSet.next()){
                tempVhost = new Vhost(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        new ArrayList<Directive>()
                );
            }

            this.fillDirectivesInVhost(tempVhost);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tempVhost;
    }

    public void addVhost(Vhost vhost) {
        this.executeUpdate("INSERT INTO `vhosts` (`port`, `serverName`, `serverAlias`) VALUES ('"+ vhost.getPort() +"', '"+ vhost.getServerName() +"', '"+ vhost.getServerAlias() +"');");
    }

    private void fillDirectivesInVhost(Vhost vhost){

        if(vhost != null) {
            logger.debug("Filling this vhost with directives: " + vhost.toString());
            ResultSet resultSet = this.executeQuery("SELECT `ID`, `name`, `value` FROM `directive` WHERE `vhostID` = '" + vhost.getId() + "' LIMIT 1000;");

            try {
                while (resultSet.next()) {
                    vhost.getDirectives().add(new Directive(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
