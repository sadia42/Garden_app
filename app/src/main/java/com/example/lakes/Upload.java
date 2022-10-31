package com.example.lakes;

public class Upload {
    private int J;
    private String imagename;
    private String imuri;

    public Upload() {
    }

    public Upload(int J,String imagename,String imuri) {
        this.J=J;
        this.imagename = imagename;
        this.imuri=imuri;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getImuri() {
        return imuri;
    }

    public void setImuri(String imuri) {
        this.imuri = imuri;
    }

    public int getJ() {
        return J;
    }

    public void setJ(int j) {
        J = j;
    }
}
