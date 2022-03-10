package com.example.retrofit230112021.demo5;

public class Demo5 {
    private String khoahoc;
    private String hocphi;
    private String hinhanh;

    public String getKhoahoc() {
        return khoahoc;
    }

    public void setKhoahoc(String khoahoc) {
        this.khoahoc = khoahoc;
    }

    public String getHocphi() {
        return hocphi;
    }

    public void setHocphi(String hocphi) {
        this.hocphi = hocphi;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    @Override
    public String toString() {
        return "Demo5{" +
                "khoahoc='" + khoahoc + '\'' +
                ", hocphi='" + hocphi + '\'' +
                ", hinhanh='" + hinhanh + '\'' +
                '}';
    }
}
