package com.heroku.demoapp;

public class Author {

    private String id;
    private String name;
    private String personalName;

    public Author(String id, String name, String personalName){
        this.id = id;
        this.name = name;
        this.personalName = personalName;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getPersonalName(){
        return this.personalName;
    }

}
