/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhanVienDAO;
import DAO.TaiKhoanDAO;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author CHINH
 */
public class NhanVienBUS {
   NhanVienDAO nhanvien=new NhanVienDAO();
    public boolean addNhanVien(NhanVienDTO s){
        if (nhanvien.addNhanVien(s))
            return true;
        return false;
    }
    public boolean updateNhanVien(NhanVienDTO s){
        if (nhanvien.updateNhanVien(s))
            return true;
        return false;
    }
    public boolean deleteNhanVien(NhanVienDTO s){
        if (nhanvien.deleteNhanVien(s))
            return true;
        return false;
    }
      public ArrayList<NhanVienDTO> getListNhanVien(){
        return nhanvien.getListNhanVien();
      }
}
