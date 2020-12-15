/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CTHDDAO;
import DTO.CTHDDTO;
import DTO.HoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author CHINH
 */
public class CTHDBUS {
    CTHDDAO cthd = new CTHDDAO();
    public boolean addCTHD(CTHDDTO s){
        if (cthd.addCTHD(s))
            return true;
        return false;
    }
    public boolean updateCTHD(CTHDDTO s){
        if (cthd.addCTHD(s))
            return true;
        return false;
    }
    public boolean deleteCTHD(CTHDDTO s){
        if (cthd.addCTHD(s))
            return true;
        return false;
    }
    public ArrayList<CTHDDTO> getListCTHD(){
        return cthd.getListCTHD();
    }
}
