package com.example.ale_j.xyz_4.Collection;

/**
 * Created by ale_j on 21/12/2017.
 */

public class Item {


    public String title;
    public String description;
    public String url;
    public int id;
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String descripcion){
        this.description = description;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public  void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public String getUrl(){
        return this.url;
    }
}