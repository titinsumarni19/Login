package com.titinsumarni202102246.login;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootModelCuaca {
    @SerializedName("list")
    private List<ListModel> listModelList;

    public RootModelCuaca() {
    }

    public List<ListModel> getListModelList() {
        return listModelList;
    }

    public void setListModelList(List<ListModel> listModelList) {
        this.listModelList = listModelList;
    }
}
