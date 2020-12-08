/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.to_do_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author evan
 */
public class Main {
    
    private Connection connect() {
        // connect to sqlite db
        String url = "jdbc:sqlite:../../../../../../../ToDo.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    // select all from tables
    public void selectAll() {
        String sql = "SELECT * FROM ToDo";
                
        try (
                Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql))
            {
            // loop through results
            while (rs.next()) {
                    System.out.println(rs.getInt("taskNumber") + "/t" +
                                        rs.getString("taskName"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
                      
        }
          
    
    public static void main(String[] args) {
        System.out.println("--- To Do Application ---");
        Main app = new Main();
        app.selectAll();
    }
}
