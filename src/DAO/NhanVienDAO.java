/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CHINH
 */
public class NhanVienDAO {
    ConnectSQL.Connect db=new ConnectSQL.Connect();
    Connection con=db.getCon();
    public boolean addNhanVien(NhanVienDTO s){
        String sql="insert into NhanVien(MaNV,TenNV,HoNV,SDT,GioiTinh)"+"values(?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,s.getMaNV());
            ps.setString(2,s.getTenNV());
            ps.setString(3,s.getHoNV());
            ps.setString(4,s.getSDT());
            ps.setString(5,s.getGioiTinh());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }    
        return false;
    }
    public boolean updateNhanVien(NhanVienDTO s){
         String sql="UPDATE NhanVien SET TenNV=?,HoNV=?,SDT=?,GioiTinh=? WHERE MaNV=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1,s.getTenNV());
            ps.setString(2,s.getHoNV());
            ps.setString(3,s.getSDT());
            ps.setString(4,s.getGioiTinh());
            ps.setString(5,s.getMaNV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteNhanVien(NhanVienDTO s){
       String sql="delete from NhanVien where MaNV=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1,s.getMaNV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<NhanVienDTO> getListNhanVien(){
        ArrayList<NhanVienDTO> list=new ArrayList<>();
        String sql="select * from NhanVien";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                NhanVienDTO s=new NhanVienDTO();
                s.setMaNV(rs.getString("MaNV"));
                s.setTenNV(rs.getString("TenNV"));
                s.setHoNV(rs.getString("HoNV"));
                s.setSDT(rs.getString("SDT"));
                s.setGioiTinh(rs.getString("GioiTinh"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
