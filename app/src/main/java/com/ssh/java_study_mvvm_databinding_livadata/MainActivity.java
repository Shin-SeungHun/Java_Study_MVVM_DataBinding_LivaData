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

        // score값이 변경되면 변경된 score값을 텍스트뷰에 전달
        viewModel.score.observe(this, integer -> binding.scoreText.setText(String.valueOf(viewModel.score.getValue())));


        binding.minusBtn.setOnClickListener(v -> viewModel.scoreMinus());

        binding.plusBtn.setOnClickListener(v -> viewModel.scorePlus());

    } // onCreate
} // MainActivity