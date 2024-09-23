package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity); // Используйте соответствующий файл разметки

        // Получаем данные из Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String capital = intent.getStringExtra("capital");
        int flagResource = intent.getIntExtra("flagResource", 0);

        // Инициализируем TextView и ImageView
        TextView nameTextView = findViewById(R.id.detail_name);
        TextView capitalTextView = findViewById(R.id.detail_capital);
        ImageView flagImageView = findViewById(R.id.detail_flag);

        // Устанавливаем полученные данные
        nameTextView.setText(name);
        capitalTextView.setText(capital);
        flagImageView.setImageResource(flagResource);
    }
}
