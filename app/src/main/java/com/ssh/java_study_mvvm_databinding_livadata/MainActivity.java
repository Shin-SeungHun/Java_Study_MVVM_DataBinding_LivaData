package com.ssh.java_study_mvvm_databinding_livadata;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.ssh.java_study_mvvm_databinding_livadata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 초기화
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // viewModel 초기화
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        Log.d("MainActivitry", "onCreate");

        // 기본값 지정
        binding.scoreText.setText(String.valueOf(viewModel.score));

        // 생명주기 셋팅(안하면 데이터 업데이트 안됨)
        binding.setLifecycleOwner(this);

        // 변수에 viewModel 초기화
        binding.setViewModel(viewModel);

    } // onCreate
} // MainActivity