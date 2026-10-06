package com.example.openappmanage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TARGET_PACKAGE = "com.yunpan.appmanage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler(Looper.getMainLooper()).postDelayed(this::openTargetApp, 300);
    }

    private void openTargetApp() {
        PackageManager pm = getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage(TARGET_PACKAGE);
        if (intent != null) {
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "無法啟動目標 App", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "未安裝 com.yunpan.appmanage", Toast.LENGTH_LONG).show();
        }
        finish();
    }
}
