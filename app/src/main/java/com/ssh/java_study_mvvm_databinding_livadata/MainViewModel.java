package com.ssh.java_study_mvvm_databinding_livadata;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public MutableLiveData<Integer> score = new MutableLiveData<>();

    public MainViewModel() {
        Log.d("MainViewModel", "MainViewModel 생성");
        score.setValue(0);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("MainViewModel", "MainViewModel 종료");
    }

    public void scorePlus() {
        Integer currentValue = score.getValue();
        if (currentValue != null) {
            score.setValue(currentValue + 1);
        }
    }

    public void scoreMinus() {
        Integer currentValue = score.getValue();
        if (currentValue != null) {
            score.setValue(currentValue - 1);

        }
    }
}
