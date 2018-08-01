package com.wmtbr.entregavel02.model;

import android.content.Context;

public class Receita {


    public String name;
    public String description;
    public String imageName;

    public int getImageResourceId(Context context) {
        try {
            return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
