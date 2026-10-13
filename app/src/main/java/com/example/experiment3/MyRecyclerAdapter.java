package com.example.experiment3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private List<Animal> dataList;

    public MyRecyclerAdapter(List<Animal> dataList) {
        this.dataList = dataList;
    }

    // 1. 创建 ViewHolder，并加载 item 布局
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        return new MyViewHolder(view);
    }

    // 2. 绑定数据到 ViewHolder 上
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Animal animal = dataList.get(position);
        holder.tvName.setText(animal.getName());
        holder.ivImage.setImageResource(animal.getImageResId());

        // 3. 在 ViewHolder 上设置点击事件
        // 把点击事件写在 ViewHolder 内部，可以避免滚动时的错位问题[reference:4][reference:5]
        holder.itemView.setOnClickListener(v -> {
            // 使用 getBindingAdapterPosition() 获取当前正确的位置[reference:6]
            int currentPos = holder.getBindingAdapterPosition();
            if (currentPos != RecyclerView.NO_POSITION) {
                String name = dataList.get(currentPos).getName();
                Toast.makeText(v.getContext(), "点击了: " + name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 4. 返回列表项的数量
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    // 自定义 ViewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_recycler_name);
            ivImage = itemView.findViewById(R.id.iv_recycler_image);
        }
    }
}