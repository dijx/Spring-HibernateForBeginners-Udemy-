package org.anyrem.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3366/hb-03-one-to-many?useSSL=false&ServerTimezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";

        try {

            System.out.println("Connecting to: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);

            System.out.println("CONNECTION OK!");


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("CONNECTION FAILED!");
        }
    }
}
