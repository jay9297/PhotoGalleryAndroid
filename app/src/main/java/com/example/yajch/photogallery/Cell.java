package com.example.yajch.photogallery;

public class Cell
{
    private String title;
    private Integer img;

    /**** Getters (Accessors) ****/

    public String getTitle()
    {
        return title;
    }

    public Integer getImg()
    {
        return img;
    }

    /**** Setter (Mutators) ****/

    public void setImg(Integer img)
    {
        this.img = img;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
