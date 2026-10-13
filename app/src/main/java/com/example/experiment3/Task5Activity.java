package com.example.experiment3;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Task5Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRecyclerAdapter adapter;
    private List<Animal> animalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5);

        recyclerView = findViewById(R.id.recycler_view);

        // 1. 准备数据
        animalList = new ArrayList<>();
        animalList.add(new Animal("Lion", R.drawable.lion));
        animalList.add(new Animal("Tiger", R.drawable.tiger));
        animalList.add(new Animal("Monkey", R.drawable.monkey));
        animalList.add(new Animal("Dog", R.drawable.dog));
        animalList.add(new Animal("Cat", R.drawable.cat));
        animalList.add(new Animal("Elephant", R.drawable.elephant));

        // 2. 创建适配器
        adapter = new MyRecyclerAdapter(animalList);

        // 3. 设置布局管理器（必须设置，否则不显示）
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 4. 设置适配器
        recyclerView.setAdapter(adapter);
    }

    // 5. 提供一个方法来增加数据，实现“增加一条记录后列表立即更新”
    public void addAnimal(Animal animal) {
        animalList.add(animal);
        // 使用 notifyItemInserted 实现局部刷新，这是 RecyclerView 的优势[reference:7]
        adapter.notifyItemInserted(animalList.size() - 1);
    }
}