package com.example.experiment3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Task3Activity extends AppCompatActivity {

    // 1. 把测试文本定义成全局变量，方便在菜单点击时修改它
    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        // 绑定控件
        tvTest = findViewById(R.id.tv_test);
    }

    // 2. 创建菜单（这个方法会在页面加载时自动运行，把 XML 菜单显示在右上角）
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 加载菜单资源
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // 3. 处理菜单的点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // 下面这几个 if 对应的是子菜单里的实际选项
        if (id == R.id.font_small) {
            tvTest.setTextSize(10);
            return true;
        } else if (id == R.id.font_medium) {
            tvTest.setTextSize(16);
            return true;
        } else if (id == R.id.font_large) {
            tvTest.setTextSize(20);
            return true;
        } else if (id == R.id.normal_item) {
            Toast.makeText(this, "你点击了普通菜单项", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.color_red) {
            tvTest.setTextColor(Color.RED);
            return true;
        } else if (id == R.id.color_black) {
            tvTest.setTextColor(Color.BLACK);
            return true;
        }

        // 注意：对于 menu_font_size 和 menu_font_color，我们不在这里处理。
        // 交给系统默认逻辑，它会自动展开子菜单。
        return super.onOptionsItemSelected(item);
    }
}