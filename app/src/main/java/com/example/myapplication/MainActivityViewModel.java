package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private final MutableLiveData<Data> data = new MutableLiveData<>(new Data());

    public LiveData<Data> getData() {
        return data;
    }

    public void incrementCount() {
        Data currentData = data.getValue();
        if (currentData != null) {
            currentData.count += 1;
            data.setValue(currentData);
        }
    }
}