package Database;

public class DBConnection {

    /* Code provided in class by @apont*/
    DBConnection () {

    try{
        // Load the database driver
        Class.forName("com.mysql.jdbc.Driver").newInstance() ;

        String dbServer = "jdbc:mysql://52.50.23.197:3306/world";
        String user = "cctstudent";
        String password = "Pass1234!";
        String query = "SELECT * FROM user";

        // Get a connection to the database
        Connection conn = DriverManager.getConnection(dbServer, user, password) ;

        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;

        // Execute the query
        ResultSet rs = stmt.executeQuery(query) ;


        // Loop through the result set
        while(rs.next()) {
            System.out.println( rs.getInt("Code") + "\t" + rs.getString("Name") + "\t" + rs.getString("Continent") + "\t" + rs.getDouble("SurfaceArea") + "\t" + rs.getString("HeadOfState")) ;
        }

        // Close the result set, statement and the connection
        rs.close() ;
        stmt.close() ;
        conn.close() ;
    }
		catch( SQLException se ){
        System.out.println( "SQL Exception:" ) ;

        // Loop through the SQL Exceptions
        while( se != null ){
            System.out.println( "State  : " + se.getSQLState()  ) ;
            System.out.println( "Message: " + se.getMessage()   ) ;
            System.out.println( "Error  : " + se.getErrorCode() ) ;

            se = se.getNextException() ;
        }
    }
		catch( Exception e ){
        System.out.println( e ) ;
    }
}