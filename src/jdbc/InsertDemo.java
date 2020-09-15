package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/netflix?serverTimezone=UTC";
        String user = "root";
        String password = "Queen!&(20)";
        Connection connection = null;
        Statement statement = null;


        try{
            //Create a connection
            connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
            Movie mib = new Movie(10, "Men In Black", 2000, "SciFi", "PG-13");
            String query = "insert into movie (id,title,release_year,genre,mpaa_rating)"+ "values(" + mib.getId() + ", '" + mib.getTitle() + "', " + mib.getReleaseYear() +
                    ", '"+mib.getGenre()+" ', '"+mib.getMpaaRating()+"');";
            statement.execute(query);
            System.out.println("It worked");

        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Something might went wrong with connection");
        }
        finally {
            statement.close();
            connection.close();
        }


    }
}
