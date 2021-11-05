package bot;

import java.net.URL;
import java.sql.*;
import java.sql.Driver;


public class BasedQuestions {
  public static final String USERNAME = "root";
  public static final String PASSWORD = "root";
  public static final String URL = "jdbc:mysql://localhost:3306/mydb";
  public static Statement statement;
  public static  Connection connection;

  static {
    try {
      connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
    catch (SQLException throwables) {
      throwables.printStackTrace();
      throw new RuntimeException();
    }
  }
  static {
    try {
      statement = connection.createStatement();
    }
    catch (SQLException throwables) {
      throwables.printStackTrace();
      throw new RuntimeException();
    }
  }

  public static Connection getConnection() {
    return connection;
  }
}
