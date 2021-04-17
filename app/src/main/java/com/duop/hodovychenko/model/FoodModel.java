package com.duop.hodovychenko.model;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.duop.hodovychenko.R;
import com.github.vivchar.rendererrecyclerviewadapter.ViewModel;

public class FoodModel implements ViewModel {
    private String title;
    private String price;
    private String discount;
    private String barTitle;
    private String time;
    private Drawable image;

    public FoodModel(String title, String price, String discount, String barTitle, String time, Drawable image) {
        this.title = title;
        this.price = price;
        this.discount = discount;
        this.barTitle = barTitle;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public String getBarTitle() {
        return barTitle;
    }

    public String getTime() {
        return time;
    }

    public Drawable getImage() {
        return image;
    }
}
