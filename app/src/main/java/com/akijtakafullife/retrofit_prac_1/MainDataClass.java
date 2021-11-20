package com.akijtakafullife.retrofit_prac_1;

import java.util.List;

public class MainDataClass {
    private List<ObjectDataClass> data;

    public MainDataClass() {
    }

    public MainDataClass(List<ObjectDataClass> data) {
        this.data = data;
    }

    public List<ObjectDataClass> getData() {
        return data;
    }

    public void setData(List<ObjectDataClass> data) {
        this.data = data;
    }
}
