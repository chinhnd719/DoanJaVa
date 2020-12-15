/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDonDAO;
import DAO.TaiKhoanDAO;
import DTO.HoaDonDTO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author CHINH
 */
public class HoaDonBUS {
    HoaDonDAO hoadon = new HoaDonDAO();
    public boolean addHoaDon(HoaDonDTO s){
        if (hoadon.addHoaDon(s))
            return true;
        return false;
    }
    public boolean updateHoaDon(HoaDonDTO s){
        if (hoadon.addHoaDon(s))
            return true;
        return false;
    }
    public boolean deleteHoaDon(HoaDonDTO s){
        if (hoadon.addHoaDon(s))
            return true;
        return false;
    }
     public ArrayList<HoaDonDTO> getListHoaDon(){
        return hoadon.getListHoaDon();
}
}
