package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBFunctions {
    public Connection connect_to_db(String dbname, String user, String pass){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if(conn!=null){
                System.out.println("Connected");
            }
            else {
                System.out.println("Failed");
            }
        }catch (Exception e){
            System.out.println("F");
        }
        return conn;
    }
    public void updateRole(Connection con, String table_name, String name, String role){
        Statement statement;
        try {
            String query = String.format("update %s set role='%s' where name='%s'", table_name, role, name);
            statement = con.createStatement();
            statement.executeUpdate(query);
            System.out.println("Updated");
        }catch (Exception e){
            System.out.println("Failed to update");
        }
    }
    public void updateRequest(Connection con, String table_name, String name, String req){
        Statement statement;
        try {
            String query = String.format("update %s set is_requested='%s' where name='%s'", table_name, req, name);
            statement = con.createStatement();
            statement.executeUpdate(query);
            System.out.println("Updated");
        }catch (Exception e){
            System.out.println("Failed to update");
        }
    }
    public void updateBlock(Connection con, String table_name, String name, String block){
        Statement statement;
        try {
            String query = String.format("update %s set is_blocked='%s' where name='%s'", table_name, block, name);
            statement = con.createStatement();
            statement.executeUpdate(query);
            System.out.println("Updated");
        }catch (Exception e){
            System.out.println("Failed to update");
        }
    }
    public ArrayList<User> read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs = null;
        ArrayList<User> userList = new ArrayList<>();
        try{
            String query = String.format("select * from %s", table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()){
                System.out.print(rs.getString("id") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.print(rs.getString("password") + " ");
                System.out.println(rs.getString("role") + " ");
                System.out.println(rs.getString("is_blocked") + " ");
                System.out.println(rs.getString("is_requested") + " ");

                userList.add(new User(
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getBoolean("role"),
                        rs.getBoolean("is_blocked"),
                        rs.getBoolean("is_requested")));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return userList;
    }
    public void delete_data( Connection conn, String table_name, String name){
        Statement statement;
        ResultSet rs = null;
        try{
            String query = String.format("delete from %s where name='%s'", table_name, name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
