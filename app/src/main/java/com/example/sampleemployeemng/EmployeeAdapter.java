package com.example.sampleemployeemng;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder>
        implements OnEmployeeItemClickListener {

    public EmployeeAdapter(ArrayList<Employee> items) {
        this.items = items;
    }

    OnEmployeeItemClickListener listener;
    ArrayList<Employee> items = new ArrayList<>();

    public void setOnEmployeeItemClickListener(OnEmployeeItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View v, int position) {
        if (listener != null) {
            listener.onItemClick(holder, v, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textId,textName, textMobile, textAge;

        public ViewHolder(@NonNull View itemView, final OnEmployeeItemClickListener listener) {
            super(itemView);
            textId = itemView.findViewById(R.id.textId);
            textName = itemView.findViewById(R.id.textName);
            textMobile = itemView.findViewById(R.id.textMobile);
            textAge = itemView.findViewById(R.id.textAge);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, v, position);
                    }
                }
            });
        }

        public void setItem(Employee item) {
            textId.setText(String.valueOf(item.getId()));
            textName.setText(item.getName());
            textAge.setText(""+item.getAge());
            textMobile.setText(item.getMobile());
        }
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.list_row, parent, false);
        return new ViewHolder(itemView, this);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public ArrayList<Employee> addItem() {
        return items;
    }

    public void setItems(ArrayList<Employee> items) {
        this.items = items;
    }
    public Employee getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Employee item) {
        items.set(position, item);
    }

    public void updateData(ArrayList<Employee> viewModels){
        items.clear();
        items.addAll(viewModels);
        notifyDataSetChanged();
    }


}
