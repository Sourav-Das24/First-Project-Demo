package org.example;

//import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App 
{
    public static String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static String URL = "jdbc:mysql://localhost:3306/sourav";

    public static String PASSWORD = "Sourav@2004";

    public static String USERNAME = "root";

    public static void main( String[] args )
    {
       try {
           // load driver
           Class.forName(LOAD_DRIVER);

           //Making connection
           Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

           //Create Statement
           Statement statement = connection.createStatement();

           //Create query
           String query = "select * from batch1";
           ResultSet resultSet = statement.executeQuery(query);
           while (resultSet.next())
           {
               int id = resultSet.getInt("ide");
               String name = resultSet.getString("name");
               String course = resultSet.getString("course");

               System.out.println("id: "+id +" name: "+name +" course: "+course);
           }
           //Close EveryThing
           connection.close();

       }catch (Exception e){
           e.printStackTrace();
       }

    }
}
