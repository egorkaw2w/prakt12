package com.example.myapplication1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {
    private final LayoutInflater inflater;  // Для создания новых представлений
    private final List<State> states;       // Список состояний

    // Конструктор адаптера
    public StateAdapter(Context context, List<State> states) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }

    // Создание нового ViewHolder
    @NonNull
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    // Привязка данных к ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        State state = states.get(position);
        holder.flagView.setImageResource(state.getFlagResource());
        holder.nameView.setText(state.getName());
        holder.capitalView.setText(state.getCapital());

        // Устанавливаем клик-слушатель
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("name", state.getName());
                intent.putExtra("capital", state.getCapital());
                intent.putExtra("flagResource", state.getFlagResource());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    // Получение общего количества элементов
    @Override
    public int getItemCount() {
        return states.size();
    }

    // Внутренний класс ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;       // Изображение флага
        final TextView nameView;        // Название страны
        final TextView capitalView;     // Столица страны

        public ViewHolder(@NonNull View view) {
            super(view);
            flagView = view.findViewById(R.id.flag);
            nameView = view.findViewById(R.id.name);
            capitalView = view.findViewById(R.id.capital);
        }
    }
}
