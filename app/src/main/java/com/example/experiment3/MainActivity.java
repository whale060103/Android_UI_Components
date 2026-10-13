package com.example.experiment3;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 拿到主界面的 ListView
        ListView listView = findViewById(R.id.list_view);

        // 2. 准备数据源
        List<Map<String, Object>> dataList = new ArrayList<>();

        // 添加第一行：Lion
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "Lion");
        map1.put("image", R.drawable.lion);
        dataList.add(map1);

        // 添加第二行：Tiger
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "Tiger");
        map2.put("image", R.drawable.tiger);
        dataList.add(map2);

        // 添加第三行：Monkey（注意这里改成了 map3）
        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "Monkey");
        map3.put("image", R.drawable.monkey);
        dataList.add(map3);

        // 添加第四行：Dog（注意这里改成了 map4）
        Map<String, Object> map4 = new HashMap<>();
        map4.put("name", "Dog");
        map4.put("image", R.drawable.dog);
        dataList.add(map4);

        // 添加第五行：Cat（注意这里改成了 map5）
        Map<String, Object> map5 = new HashMap<>();
        map5.put("name", "Cat");
        map5.put("image", R.drawable.cat);
        dataList.add(map5);

        // 添加第六行：Elephant（注意这里改成了 map6）
        Map<String, Object> map6 = new HashMap<>();
        map6.put("name", "Elephant");
        map6.put("image", R.drawable.elephant);
        dataList.add(map6);

        // 3. 创建适配器，把数据和模具连起来
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                dataList,
                R.layout.item_animal,
                new String[]{"name", "image"},
                new int[]{R.id.tv_name, R.id.iv_image}
        );

        // 4. 把适配器给 ListView
        listView.setAdapter(adapter);

        // 5. 点击事件（目前只做 Toast）
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Map<String, Object> clickedItem = (Map<String, Object>) parent.getItemAtPosition(position);
            String name = (String) clickedItem.get("name");
            Toast.makeText(MainActivity.this, "点击了: " + name, Toast.LENGTH_SHORT).show();
        });
    }
}