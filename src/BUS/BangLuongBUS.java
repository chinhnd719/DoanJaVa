/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.BangLuongDAO;
import DTO.BangLuongDTO;
import java.util.ArrayList;

/**
 *
 * @author CHINH
 */
public class BangLuongBUS {
    BangLuongDAO bangluong=new BangLuongDAO();
    public boolean updateBangLuong(BangLuongDTO s){
        if (bangluong.updateBangLuong(s))
            return true;
        return false;
    }
    public boolean addBangLuong(BangLuongDTO s){
        if (bangluong.addBangLuong(s))
            return true;
        return false;
    }
    public ArrayList<BangLuongDTO> getListBangLuong(){
        return bangluong.getListBangLuong();
    }
    
}
