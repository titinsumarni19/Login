package com.titinsumarni202102246.login;

import com.google.gson.annotations.SerializedName;

public class RootModel {
    @SerializedName("rates")
    private RatesModel ratesModel;

    public  RootModel() {}

    public RatesModel getRatesModel() {
        return ratesModel;
    }

    public void setRatesModel(RatesModel ratesModel) {
        this.ratesModel = ratesModel;
    }
}
