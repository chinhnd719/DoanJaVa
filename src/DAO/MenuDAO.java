/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietNhapDTO;
import DTO.MenuDTO;
import DTO.TaiKhoanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CHINH
 */
public class MenuDAO {
    ConnectSQL.Connect db=new ConnectSQL.Connect();
    Connection con=db.getCon();
     public boolean updateMenu(MenuDTO s){
         String sql="UPDATE Menu SET TenMon=?,DonGia=?,SoLuongTon=? WHERE MaMon=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
      
            ps.setString(1,s.getTenMon());
            ps.setInt(2,s.getDonGia());
            ps.setInt(3,s.getSoLuongTon());
            ps.setString(4,s.getMaMon());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<MenuDTO> getListMenu(){
        ArrayList<MenuDTO> list=new ArrayList<>();
        String sql="select * from Menu";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                MenuDTO s=new MenuDTO();
                s.setMaMon(rs.getString("MaMon"));
                s.setTenMon(rs.getString("TenMon"));
                s.setDonGia(rs.getInt("DonGia")); 
                s.setSoLuongTon(rs.getInt("SoLuongTon")); 
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
