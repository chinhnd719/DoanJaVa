/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TaiKhoanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author CHINH
 */
public class TaiKhoanDAO {
    ConnectSQL.Connect db=new ConnectSQL.Connect();
    Connection con=db.getCon();
    public boolean addTaiKhoan(TaiKhoanDTO s){
        String sql="insert into TaiKhoan(Username,Password)"+"values(?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,s.getUsename());
            ps.setString(2,s.getPassword());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }    
        return false;
    }
    public boolean updateTaiKhoan(TaiKhoanDTO s){
         String sql="UPDATE TaiKhoan SET Password=? WHERE Username=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1,s.getPassword());
            ps.setString(2,s.getUsename());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteTaiKhoan(TaiKhoanDTO s){
       String sql="delete from TaiKhoan where Username=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1,s.getUsename());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<TaiKhoanDTO> getListTaiKhoan(){
        ArrayList<TaiKhoanDTO> list=new ArrayList<>();
        String sql="select * from TaiKhoan";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                TaiKhoanDTO s=new TaiKhoanDTO();
                s.setUsename(rs.getString("Username"));
                s.setPassword(rs.getString("Password")); 
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
