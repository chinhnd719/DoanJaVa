/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author CHINH
 */
public class TaiKhoanDTO {
    String  Usename,Password;
    Integer ID;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    

    public String getUsename() {
        return Usename;
    }

    public void setUsename(String Usename) {
        this.Usename = Usename;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
