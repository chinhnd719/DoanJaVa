/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhanCaDAO;
import DTO.PhanCaDTO;
import java.util.ArrayList;

/**
 *
 * @author CHINH
 */
public class PhanCaBUS {
    PhanCaDAO phanca= new PhanCaDAO();
    public boolean addPhanCa(PhanCaDTO s){
        if (phanca.addPhanCa(s))
            return true;
        return false;
    }
    public boolean updatePhanCa(PhanCaDTO s){
        if (phanca.updatePhanCa(s))
            return true;
        return false;
    }
    public boolean deletePhanCa(PhanCaDTO s){
        if (phanca.deletePhanCa(s))
            return true;
        return false;
    }
    public ArrayList<PhanCaDTO> getListPhanCa(){
        return phanca.getListPhanCa();
    }
}
