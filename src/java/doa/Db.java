/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author khk
 */
public class Db {
    private Connection cnx;
    private PreparedStatement pstm;
    private int ok;
    private ResultSet rs;
    
    private void getConnection(){
        String url = "jdbc:mysql://localhost:3306/jee_parc_info";
        String user = "root";
        String password = "";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url,user,password);
            System.out.print("ok");
        } catch (Exception e) {
            System.out.print("non ok");
            e.printStackTrace();
        }
    }
    
    public void initPrepar(String sql){
        try {
            getConnection();
            pstm = cnx.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int executeMaj(){
        
        try {
            ok = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }
    
    public ResultSet executeSelect(){
        try {
            rs = pstm.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public PreparedStatement getPstm(){
        return this.pstm;
    }
}
