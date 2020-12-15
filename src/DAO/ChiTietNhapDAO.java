/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietNhapDTO;
import DTO.HoaDonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CHINH
 */
public class ChiTietNhapDAO {
      ConnectSQL.Connect db=new ConnectSQL.Connect();
    Connection con=db.getCon();
    public boolean addPhieuNhap(ChiTietNhapDTO s){
        String sql="insert into ChiTietNhap(MaNhap,DVT,NgayNhap,TongTien,SoLuong,MaMon)"+"values(?,?,?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,s.getMaNhap());
            ps.setString(2,s.getDVT());
            ps.setString(3,s.getNgayNhap());
            ps.setInt(4,s.getTongTien());
            ps.setInt(5,s.getSoLuong());
            ps.setString(6,s.getMaMon());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }    
        return false;
    }
    public boolean updatePhieuNhap(ChiTietNhapDTO s){
         String sql="UPDATE ChiTietNhap SET DVT=?,NgayNhap=?,TongTien=?,SoLuong=?,MaMon=? WHERE MaNhap=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
      
            ps.setString(1,s.getDVT());
            ps.setString(2,s.getNgayNhap());
            ps.setInt(3,s.getTongTien());
            ps.setInt(4,s.getSoLuong());
            ps.setString(5,s.getMaMon());
            ps.setString(6,s.getMaNhap());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deletePhieuNhap(ChiTietNhapDTO s){
       String sql="delete from ChiTietNhap where MaNhap=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1,s.getMaNhap());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<ChiTietNhapDTO> getListPhieuNhap(){
        ArrayList<ChiTietNhapDTO> list=new ArrayList<>();
        String sql="select * from ChiTietNhap";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                ChiTietNhapDTO s=new ChiTietNhapDTO();
                s.setMaNhap(rs.getString("MaNhap"));
                s.setDVT(rs.getString("DVT"));
                s.setNgayNhap(rs.getString("NgayNhap"));
                s.setTongTien(rs.getInt("TongTien"));
                s.setSoLuong(rs.getInt("SoLuong"));
                s.setMaMon(rs.getString("MaMon"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
