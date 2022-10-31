package com.example.lakes;

public class trees {
private String tree;
private String distance;

    public trees(String tree,String distance) {
        this.tree=tree;
        this.distance=distance;

    }

    public String getTree() {
        return tree;
    }
    public String getDistance() {
        return distance;

    }

    public void setDistance(String distance) {
        this.distance= distance;
    }

}
