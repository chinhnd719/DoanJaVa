/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author CHINH
 */
public class TaiKhoanBUS {
    TaiKhoanDAO taikhoan = new TaiKhoanDAO();
    public boolean addTaiKhoan(TaiKhoanDTO s){
        if (taikhoan.addTaiKhoan(s))
            return true;
        return false;
    }
    public boolean updateTaiKhoan(TaiKhoanDTO s){
        if (taikhoan.updateTaiKhoan(s))
            return true;
        return false;
    }
    public boolean deleteTaiKhoan(TaiKhoanDTO s){
        if (taikhoan.deleteTaiKhoan(s))
            return true;
        return false;
    }
     public ArrayList<TaiKhoanDTO> getListTaiKhoan(){
        return taikhoan.getListTaiKhoan();
}
}
