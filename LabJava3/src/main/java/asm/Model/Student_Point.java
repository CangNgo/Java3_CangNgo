package asm.Model;
public class Student_Point {
    private String tenSV, MaSV; 
    private double tiengAnh, tinHoc, GDTC; 

    public Student_Point(String MaSV, double tiengAnh, double tinHoc, double GDTC) {
        this.MaSV = MaSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
    }

    public Student_Point(String tenSV, String MaSV, double tiengAnh, double tinHoc, double GDTC) {
        this.MaSV = MaSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
    }

    public Student_Point() {
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public double getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(double tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(double tinHoc) {
        this.tinHoc = tinHoc;
    }

    public double getGDTC() {
        return GDTC;
    }

    public void setGDTC(double GDTC) {
        this.GDTC = GDTC;
    }
    
    
}
