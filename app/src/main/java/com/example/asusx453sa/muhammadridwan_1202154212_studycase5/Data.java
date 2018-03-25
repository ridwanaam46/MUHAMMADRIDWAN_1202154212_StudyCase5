package com.example.asusx453sa.muhammadridwan_1202154212_studycase5;

/**
 * Created by ASUS X453SA on 3/24/2018.
 */

public class Data {
    private String id,name, deskripsi, jumlah;

    public Data() {
    }

    public Data(String id,String name, String deskripsi, String jumlah) {
        this.id = id;
        this.name = name;
        this.deskripsi = deskripsi;
        this.jumlah = jumlah;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
