package com.example.myapplication1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<State> states = new ArrayList<>(); // Список состояний
    private RecyclerView recyclerView; // RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Устанавливаем разметку

        // Инициализируем RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Устанавливаем LayoutManager

        // Инициализация данных
        setInitialData();

        // Создаем адаптер и устанавливаем его для RecyclerView
        StateAdapter adapter = new StateAdapter(this, states);
        recyclerView.setAdapter(adapter);
    }

    // Метод для начальной инициализации списка
    private void setInitialData() {
        states.add(new State("Бабузянина", "Классическая", R.drawable.babuzyana));
        states.add(new State("Горилоза", "Круэс", R.drawable.kruzhka));
        states.add(new State("ГОЙДА", "Московская", R.drawable.babuzyana));

    }

}
