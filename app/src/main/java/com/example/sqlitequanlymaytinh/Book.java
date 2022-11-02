package com.example.sqlitequanlymaytinh;

public class Book {
    private String ten;
    private String cpu;
    private String ram;
    private String loai;

    public Book() {
    }

    public Book(String ten, String cpu, String ram, String loai) {
        this.ten = ten;
        this.cpu = cpu;
        this.ram = ram;
        this.loai = loai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}
