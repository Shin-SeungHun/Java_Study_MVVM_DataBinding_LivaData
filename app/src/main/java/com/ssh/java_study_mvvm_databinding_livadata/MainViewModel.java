package com.ssh.java_study_mvvm_databinding_livadata;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public int score = 0;

    public MainViewModel() {
        Log.d("MainViewModel", "MainViewModel 생성");
        scorePlus();
        scoreMinus();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("MainViewModel", "MainViewModel 종료");
    }

    public void scorePlus() {
        score++;
    }

    public void scoreMinus() {
        score--;
    }
}
