package com.example.experiment3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Task2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        Button btnShow = findViewById(R.id.btn_show_dialog);
        btnShow.setOnClickListener(v -> showCustomDialog());
    }

    private void showCustomDialog() {
        // 1. 创建 AlertDialog 的构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. 把 dialog_sign_in.xml 加载进来（连接 Java 和 XML）
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_sign_in, null);
        builder.setView(dialogView); // ⭐️ 实验要求：调用 setView()

        // 3. 创建对话框对象
        AlertDialog dialog = builder.create();

        // 4. 获取对话框里的控件
        EditText etUsername = dialogView.findViewById(R.id.et_username);
        EditText etPassword = dialogView.findViewById(R.id.et_password);
        Button btnCancel = dialogView.findViewById(R.id.btn_cancel);
        Button btnSignIn = dialogView.findViewById(R.id.btn_sign_in);

        // 5. 设置按钮点击事件
        btnCancel.setOnClickListener(v -> dialog.dismiss()); // 点击取消，关闭对话框

        btnSignIn.setOnClickListener(v -> {
            String user = etUsername.getText().toString();
            String pass = etPassword.getText().toString();
            // 暂时不做真正的登录，用 Toast 提示一下即可
            Toast.makeText(this, "登录中：" + user, Toast.LENGTH_SHORT).show();
            dialog.dismiss(); // 关闭对话框
        });

        // 6. 显示对话框
        dialog.show();
    }
}