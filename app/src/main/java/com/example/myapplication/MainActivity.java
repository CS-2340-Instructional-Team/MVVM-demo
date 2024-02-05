package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // No ViewModel
        Button noVMButton = findViewById(R.id.noVMButton);
        TextView noVMTextView = findViewById(R.id.noVMtextView);
        noVMButton.setOnClickListener(v ->{
            noVMTextView.setText(String.valueOf(++count));
        });

        // With ViewModel
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        Button VMButton = findViewById(R.id.VMButton);
        TextView VMTextView = findViewById(R.id.VMtextView);

        viewModel.getData().observe(this, data -> {
            VMTextView.setText(String.valueOf(data.count));
        });

        VMButton.setOnClickListener(v -> {
            viewModel.incrementCount();
        });

    }
}