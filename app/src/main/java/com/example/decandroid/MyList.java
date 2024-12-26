package com.example.decandroid;

public class MyList {
    String name;
    String des;
    int imageid;

    public MyList(String name, String des, int imageid) {
        this.name = name;
        this.des = des;
        this.imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
