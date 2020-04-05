package database;

import java.sql.*;

/**
 * Referencing: Code modified from DataSource.java given in class by @apont
 * Some Comments were kept fro the original Code.
 * Singleton Pattern implemented here.
 * @author celsoM_2017216
 */

// Singleton Class with Lazy Implementation method
public class DataSourceSingleton {
    
    // Singleton only instance
    private static DataSourceSingleton instance;
    // Global information for external Database connection
    private String db = "jdbc:mysql://52.50.23.197:3306/world";
    private String un = "cctstudent";
    private String pw = "Pass1234!";
    private Connection conn;
    private Statement stmt;

    private DataSourceSingleton() {
        
        // NOW THE CONSTRUCTOR ONLY HAS TO CREATE THE CONNECTION 
        // AND THE STATEMENT
        try {
            // Get a connection to the database
            conn = DriverManager.getConnection(db, un, pw);

            // Get a statement from the connection
            stmt = conn.createStatement();

        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Singleton Lazy implamentation method
    public static DataSourceSingleton getIntance() {
        // initialize Instance if null
        if (instance == null) {
            instance = new DataSourceSingleton();
        }

        return instance;
    }

    // THIS IS GOING TO BE A GENERIC METHOD TO DO
    // ANY SELECT STATEMENT THAT WE PASS IN USING THE
    // QUERY VARIABLE
    public ResultSet select(String query) {
        // Execute the query
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        }

        return rs;
    }

    // THIS IS GOING TO BE A GENERIC METHOD TO DO
    // ANY INSERT STATEMENT THAT WE PASS IN USING THE 
    // QUERY VARIABLE
    public boolean save(String query) {

        try {

            // NOTE THAT HERE WE WON'T NEED
            // ANY RESULT SET, AS AN INSERT STATEMENT
            // DOES NOT RETURN VALUES
            stmt.execute(query);
            return true;
        } catch (SQLException e) {

            return false;
        }

    }

    // AND FINALLY WE HAVE A SEPARATE METHOD TO 
    // CLOSE THE STATEMENT AND THE CONNECTION
    public void closing() {
        try {
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
        }
    }
}
