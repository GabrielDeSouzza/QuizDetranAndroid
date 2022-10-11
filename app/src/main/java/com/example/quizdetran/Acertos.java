package com.example.quizdetran;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Acertos {
    private int acertos;
    private String data;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        data = dateFormat.format(date.getTime());
        return data;
    }
}
