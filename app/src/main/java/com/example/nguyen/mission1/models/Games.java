package com.example.nguyen.mission1.models;

public class Games {
    private int ivImageBackGround,ivImageIcon;
    private String tvTitle,tvDescripsion;

    public Games(int ivImageBackGround, int ivImageIcon, String tvTitle, String tvDescripsion) {
        this.ivImageBackGround = ivImageBackGround;
        this.ivImageIcon = ivImageIcon;
        this.tvTitle = tvTitle;
        this.tvDescripsion = tvDescripsion;
    }

    public Games(int ivImageBackGround) {
        this.ivImageBackGround = ivImageBackGround;
    }

    public int getIvImageBackGround() {
        return ivImageBackGround;
    }

    public void setIvImageBackGround(int ivImageBackGround) {
        this.ivImageBackGround = ivImageBackGround;
    }

    public int getIvImageIcon() {
        return ivImageIcon;
    }

    public void setIvImageIcon(int ivImageIcon) {
        this.ivImageIcon = ivImageIcon;
    }

    public String getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(String tvTitle) {
        this.tvTitle = tvTitle;
    }

    public String getTvDescripsion() {
        return tvDescripsion;
    }

    public void setTvDescripsion(String tvDescripsion) {
        this.tvDescripsion = tvDescripsion;
    }
}
