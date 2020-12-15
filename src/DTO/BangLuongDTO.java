/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author CHINH
 */
public class BangLuongDTO {
    String MaCong,MaNV;
    Integer TamUng,TienThuong,Luong;

    public String getMaCong() {
        return MaCong;
    }

    public void setMaCong(String MaCong) {
        this.MaCong = MaCong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Integer getTamUng() {
        return TamUng;
    }

    public void setTamUng(Integer TamUng) {
        this.TamUng = TamUng;
    }

    public Integer getTienThuong() {
        return TienThuong;
    }

    public void setTienThuong(Integer TienThuong) {
        this.TienThuong = TienThuong;
    }

    public Integer getLuong() {
        return Luong;
    }

    public void setLuong(Integer Luong) {
        this.Luong = Luong;
    }

   
}
