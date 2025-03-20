package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDemo {
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
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE
            );

            //Create query
            String query = "select * from batch1";
            ResultSet resultSet = statement.executeQuery(query);

            // Before update Get last raw
            resultSet.last();
            System.out.println("Fetching last raw: ");
            System.out.println("ID: "+resultSet.getInt("ide"));
            System.out.println("Name: "+resultSet.getString("name"));
            System.out.println("Course: "+resultSet.getString("course"));

            // Update Data set
            resultSet.updateString("name","Anubav");
            resultSet.updateString("course","ECE");
            resultSet.updateRow();

            //get first raw
            resultSet.first();
            System.out.println("Fetching First raw: ");
            System.out.println("ID: "+resultSet.getInt("ide"));
            System.out.println("Name: "+resultSet.getString("name"));
            System.out.println("Course: "+resultSet.getString("course"));

            // Insert new raw in dataset

            resultSet.moveToInsertRow();
            resultSet.updateInt("ide",5);
            resultSet.updateString("name","Saimon");
            resultSet.updateString("course","BSC Math");
            resultSet.insertRow();

            // After update last raw
            resultSet.last();
            System.out.println("Fetching last raw: ");
            System.out.println("ID: "+resultSet.getInt("ide"));
            System.out.println("Name: "+resultSet.getString("name"));
            System.out.println("Course: "+resultSet.getString("course"));


            //Close EveryThing
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
