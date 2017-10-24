/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw.ecommerce.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bruno Dutra
 */
public class ConnectionFactory {
    
    public Connection getConnection() throws ClassNotFoundException{
        try {
            Class.forName("org.postgresql.Driver");  
            return DriverManager.getConnection("jdbc:postgresql://localhost:5433/ecommerce?useUnicode=true&characterEncoding=UTF-8", "postgres", "123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
