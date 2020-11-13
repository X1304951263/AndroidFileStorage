package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String SharedPreferencesFileName="config";
    private final static String Key_UserName="UserName";//用户名
    private final static String Key_UserId="UserId";//登录时间
    private final static String Key_UserType="UserType";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences=getSharedPreferences(SharedPreferencesFileName, MODE_PRIVATE);
        editor=preferences.edit();
        Button btnWrite=(Button)findViewById(R.id.btn1);
        Button btnRead=(Button)findViewById(R.id.btn2);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(Key_UserName, "何问英雄千古梦");
                editor.putString(Key_UserId,"2018011351");
                editor.putInt(Key_UserType, 1);
                editor.apply();	}
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = preferences.getString(Key_UserName, null);
                String strUserId= preferences.getString(Key_UserId, null);
                int nUserType=preferences.getInt(Key_UserType,0);
                if (strUserName != null && strUserId != null)
                    Toast.makeText(MainActivity.this, "用户名:" + strUserName + "学号:"+strUserId, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "无数据", Toast.LENGTH_LONG).show();
            }
        });
    }
}