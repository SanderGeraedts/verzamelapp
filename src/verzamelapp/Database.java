/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sander Geraedts - Code Panda
 */
public class Database {
    private Properties props;
    private Connection conn;

    public Database(Properties props) {
        this.props = props;
        try {
            initConnection();
            System.out.println("Shit worked!!");
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch(SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
    
    private void initConnection() throws SQLException, IOException{
        try {
            //        InputStream input = Verzamelapp.class.getClassLoader().getResourceAsStream("config.properties");
//        this.props.load(input);
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dburl = "jdbc:mysql://localhost:3306/verzamelapp"; //props.getProperty("dburl");
        String user = "root";//props.getProperty("dbuser");
        String password = "";//props.getProperty("dbpassword");
        
        conn = DriverManager.getConnection(dburl, user, password);
    }
    
    private void closeConnection() throws SQLException {
        
    }
    
    public ArrayList<Set> loadSets() throws IOException {
        return null;
    }
    
    public void save(Registry registry) throws IOException {
        
    }
}
