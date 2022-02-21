package com.example.recyclerview;

public class ModelClass {

    private  int imageView1;
    private String texrView1;
    private String texrView2;
    private String texrView3;

    public ModelClass(int imageView1, String texrView1, String texrView2, String texrView3) {
        this.imageView1 = imageView1;
        this.texrView1 = texrView1;
        this.texrView2 = texrView2;
        this.texrView3 = texrView3;
    }

    public int getImageView1() {
        return imageView1;
    }

    public String getTexrView1() {
        return texrView1;
    }

    public String getTexrView2() {
        return texrView2;
    }

    public String getTexrView3() {
        return texrView3;
    }
}
