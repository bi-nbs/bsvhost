package API.Backend;

import Properties.PropertiesShop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public abstract class Database {

    private static Logger logger = LogManager.getLogger();

    private final String hostname;
    private final String port;
    private final String username;
    private final String password;
    private final String database;

    public Database() {
        this.hostname = PropertiesShop.getProperties().getProperty("mysqlhostname");
        this.port = PropertiesShop.getProperties().getProperty("mysqlport");
        this.username = PropertiesShop.getProperties().getProperty("mysqlusername");
        this.password = PropertiesShop.getProperties().getProperty("mysqlpassword");
        this.database = PropertiesShop.getProperties().getProperty("mysqldatabase");
    }

    private Connection makeConnection() throws SQLException {
        String connectionString = "jdbc:mysql://" + this.hostname + ":" + this.port + "/" + this.database +
                "?" + "useSSL=false" + "&serverTimezone=Europe/Copenhagen";
        logger.debug("Connection to database with following JDBC string: " + connectionString);
        return DriverManager.getConnection(connectionString, this.username, this.password);
    }

    protected ResultSet executeQuery(String queryString){
        logger.debug("Executing following string: " + queryString);
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = this.makeConnection();
            statement = conn.prepareStatement(queryString, ResultSet.TYPE_FORWARD_ONLY , ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery();

            // if (!conn.isClosed()) conn.close();

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return resultSet;
    }

    protected void executeUpdate(String queryString){
        logger.debug("Executing following string: " + queryString);
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = this.makeConnection();
            statement = conn.prepareStatement(queryString);
            statement.executeUpdate();

            // if (!conn.isClosed()) conn.close();

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Database{" +
                "hostname='" + hostname + '\'' +
                ", port='" + port + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", database='" + database + '\'' +
                '}';
    }
}
