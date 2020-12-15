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
public class MenuDTO {
    String MaMon,TenMon,MaLoai;
    Integer DonGia,SoLuongTon;

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public Integer getDonGia() {
        return DonGia;
    }

    public void setDonGia(Integer DonGia) {
        this.DonGia = DonGia;
    }

    public Integer getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(Integer SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }

   
    
}
