package com.sum.floatingviewSample;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.sum.floatingviewSample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding viewBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        viewBinding.btnFloatView.setOnClickListener(this);
        viewBinding.btnFloatViewDrag.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        if (v == viewBinding.btnFloatView) {
            //普通悬浮窗
            intent = new Intent(MainActivity.this, FloatingViewActivity.class);
        } else if (v == viewBinding.btnFloatViewDrag) {
            //可拖拽悬浮窗
            intent = new Intent(MainActivity.this, FloatingViewDragActivity.class);
        }
        startActivity(intent);
    }
}