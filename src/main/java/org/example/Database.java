package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

        public static Connection DbConn() {
            //Declare the connection outside try/catch block to allow you

            Connection connection = null;
            try {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://babar.db.elephantsql.com/syzwbhbt",
                        "syzwbhbt",
                        "rp_CzsSWpkDjMkl3mD2SOaNTii62UjmZ");



            }catch (SQLException e){
                System.out.println(e.getMessage());

            }
            return connection;
        }

    }

