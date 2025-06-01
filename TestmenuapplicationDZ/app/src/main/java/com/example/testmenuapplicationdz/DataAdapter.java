package com.example.testmenuapplicationdz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.VeiwHolder> {

    private List<String> dataList;

    public DataAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DataAdapter.VeiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_style, parent, false);
        return new VeiwHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.VeiwHolder holder, int position) {
        holder.textView.setText(dataList.get(position));
        holder.imageView.setOnClickListener(v -> {
            dataList.remove(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class VeiwHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public VeiwHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.deleteIcon);
        }
    }
}
