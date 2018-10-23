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

    public Vhost getVhostByID() {
        return null;
    }

    public List<Vhost> getAllVhosts() {
        List<Vhost> vhostsToReturn = new ArrayList<>();
        ResultSet resultSet = this.executeQuery("SELECT * FROM `vhosts` LIMIT 1000;");


        try{
            while (resultSet.next()){
                vhostsToReturn.add(new Vhost(
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        new ArrayList<Directive>()
                ));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return vhostsToReturn;
    }

    @Override
    public Vhost getVhostById(int id) {
        return null;
    }

    public void addVhost(Vhost vhost) {
        this.executeUpdate("INSERT INTO `vhosts` (`port`, `serverName`, `serverAlias`) VALUES ('"+ vhost.getPort() +"', '"+ vhost.getServerName() +"', '"+ vhost.getServerAlias() +"');");
    }


}
