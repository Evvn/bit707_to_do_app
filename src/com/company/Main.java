package com.company;

import java.sql.*;

public class Main {

    private Connection connect() {
        String url = "jdbc:sqlite:ToDo.db";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll() {
        String sql = "SELECT * FROM ToDo";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("taskNumber") + "\t" + rs.getString("taskName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        Main app = new Main();
        app.selectAll();
    }
}
