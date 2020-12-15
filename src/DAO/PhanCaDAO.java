/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDonDTO;
import DTO.PhanCaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CHINH
 */
public class PhanCaDAO {
    ConnectSQL.Connect db=new ConnectSQL.Connect();
    Connection con=db.getCon();
    public boolean addPhanCa(PhanCaDTO s){
        String sql="insert into PhanCa(MaNV,HeSoLuong,SoGio)"+"values(?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,s.getMaNV());
            ps.setInt(2,s.getHeSoLuong());
            ps.setInt(3,s.getSoGio());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }    
        return false;
    }
    public boolean updatePhanCa(PhanCaDTO s){
        String sql="UPDATE PhanCa SET HeSoLuong=?,SoGio=? WHERE MaNV=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,s.getHeSoLuong());
            ps.setInt(2,s.getSoGio());
            ps.setString(3,s.getMaNV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }    
        return false;
    }
     public boolean deletePhanCa(PhanCaDTO s){
        String sql="delete from PhanCa where MaNV=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,s.getMaNV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }    
        return false;
    }
    public ArrayList<PhanCaDTO> getListPhanCa(){
        ArrayList<PhanCaDTO> list=new ArrayList<>();
        String sql="select * from PhanCa";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                PhanCaDTO s=new PhanCaDTO();
                s.setMaNV(rs.getString("MaNV"));
                s.setHeSoLuong(rs.getInt("HeSoLuong"));
                s.setSoGio(rs.getInt("SoGio"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
