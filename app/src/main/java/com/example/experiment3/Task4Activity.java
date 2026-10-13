package com.example.experiment3;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Task4Activity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        listView = findViewById(R.id.list_view_action);

        // 1. 准备数据
        dataList = new ArrayList<>();
        dataList.add("One");
        dataList.add("Two");
        dataList.add("Three");
        dataList.add("Four");
        dataList.add("Five");

        // 2. 设置适配器（此处使用系统的 simple_list_item_1 作为简单展示）
        adapter = new ArrayAdapter<>(this, R.layout.item_action_mode, R.id.tv_action_name, dataList);
        listView.setAdapter(adapter);

        // 3. ⭐️ 核心：开启多选模式
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        // 4. ⭐️ 核心：设置多选监听器
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                // 当勾选状态改变时，更新标题中的选中数量
                int count = listView.getCheckedItemCount();
                mode.setTitle(count + " selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // 加载菜单资源
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.menu_action_mode, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // 当点击顶部的删除图标时
                if (item.getItemId() == R.id.action_delete) {
                    // 获取所有被选中的位置
                    SparseBooleanArray checkedPositions = listView.getCheckedItemPositions();
                    // 从后往前遍历并删除（防止索引错位）
                    for (int i = checkedPositions.size() - 1; i >= 0; i--) {
                        if (checkedPositions.valueAt(i)) {
                            dataList.remove(checkedPositions.keyAt(i));
                        }
                    }
                    // 刷新适配器
                    adapter.notifyDataSetChanged();
                    mode.finish(); // 关闭 ActionMode
                    return true;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // ActionMode 结束时，清除列表的所有选中状态
                listView.clearChoices();
                adapter.notifyDataSetChanged();
            }
        });
    }
}