import java.sql.*;
import java.util.Properties;
import org.postgresql.Driver;

public class PostgresDB {
  public static void main(String[] args) {
    // Investigate whether the postgres driver is properly accessible.
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.out.println("Postgres driver not configured correctly.");
    }

    String url = "jdbc:postgresql://localhost:5432/music";
    Properties props = new Properties();
    // use these properties if you need to provide a username or password.
    //props.setProperty("user","fred");
    //props.setProperty("password","secret");
    //props.setProperty("ssl","true");

    try {
      Connection conn = DriverManager.getConnection(url, props);
      ResultSet results = conn.createStatement().executeQuery("SELECT * FROM artists");
      while (results.next()) {
        int id = results.getInt("id");
        String name = results.getString("name");
        Date createdAt = results.getDate("createdAt");
        Date updatedAt = results.getDate("updatedAt");

        System.out.println("id: " + id + " artist: " + name);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("DB error.");
    }
  }
}
