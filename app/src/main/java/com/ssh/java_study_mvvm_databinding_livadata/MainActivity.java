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

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        Log.d("MainActivitry","onCreate");



        binding.minusBtn.setOnClickListener(v -> {
            viewModel.scorePlus();
            binding.scoreText.setText(String.valueOf(viewModel.score));
        });

        binding.plusBtn.setOnClickListener(v -> {
            viewModel.scoreMinus();
            binding.scoreText.setText(String.valueOf(viewModel.score));
        });

    } // onCreate
} // MainActivity