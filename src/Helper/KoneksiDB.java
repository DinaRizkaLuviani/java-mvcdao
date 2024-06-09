/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akuuu
 */
public class KoneksiDB {
     static Connection con;
  
    public static Connection getConnection(){
        if(con == null){
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_toko", "root", "");
            System.out.print("Berhasil");
            
        } catch (ClassNotFoundException ex) {
                System.out.println("Error");
        } catch (SQLException ex) {
                System.out.println("Error DB");
        }
        }
        return con;
    }
}