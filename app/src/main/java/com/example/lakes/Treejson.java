package com.example.lakes;

public class Treejson {
    String name;
    String info;
    String culti;
    String cultinfo;


    // String coverImage;

    public Treejson(String name, String info,String culti,String cultinfo) {

        this.name = name;
        this.info = info;
        this.culti=culti;
        this.cultinfo=cultinfo;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCulti() {
        return culti;
    }

    public void setCulti(String culti) {
        this.culti = culti;
    }

    public String getCultinfo() {
        return cultinfo;
    }

    public void setCultinfo(String cultinfo) {
        this.cultinfo = cultinfo;
    }
}