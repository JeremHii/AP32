package fr.ap.apjavafx.controller;

import java.util.HashMap;

public abstract class ControllerBase {
    private HashMap<String, Object> params = new HashMap<String, Object>();

    private String title = "Titre";

    public void setParams(HashMap<String, Object> params){
        this.params = params;
    }

    public void putParam(String param, Object value){
        params.put(param, value);
    }

    public Object getParam(String param){
        return params.get(param);
    }

    public HashMap<String, Object> getParams(){
        return params;
    }

    public String getTitle() {
        return "MeetingsBooker - " + title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void loaded(){

    }
}
