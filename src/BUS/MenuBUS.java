/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.MenuDAO;
import DTO.MenuDTO;
import java.util.ArrayList;

/**
 *
 * @author CHINH
 */
public class MenuBUS {
    MenuDAO menu= new MenuDAO();
    public ArrayList<MenuDTO> getListMenu(){
        return menu.getListMenu();
    }
    public boolean updateMenu(MenuDTO s){
        if (menu.updateMenu(s))
            return true;
        return false;
    }
}
