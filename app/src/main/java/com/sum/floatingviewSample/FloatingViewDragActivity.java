package com.sum.floatingviewSample;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sum.floatingviewSample.databinding.ActivityFloatingViewDragBinding;
import com.sum.floatingviewSample.databinding.ItemListBinding;
import com.sum.simpleadapter.BaseAdapter;
import com.sum.simpleadapter.base.ViewHolder;

import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author liujiang
 * created at: 2021/9/30 13:25
 * Desc: 仿知乎可拖拽悬浮窗
 */
public class FloatingViewDragActivity extends AppCompatActivity {
    private final String Tag = "green";
    private ActivityFloatingViewDragBinding viewBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityFloatingViewDragBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        List<String> data = Arrays.asList(new String[30]);
        viewBinding.recyclerView.setNestedScrollingEnabled(false);
        viewBinding.recyclerView.setAdapter(new BaseAdapter<ItemListBinding, String>(FloatingViewDragActivity.this, data) {

            @Override
            protected ItemListBinding getViewBinding(int viewType, LayoutInflater layoutInflater, ViewGroup parent) {
                return ItemListBinding.inflate(layoutInflater, parent, false);
            }

            @Override
            protected void onBind(Context context, ViewHolder<ItemListBinding> holder, String item, int position) {
                holder.binding.tvTitle.setText(position + "、满汉全席一家亲");
                holder.binding.tvDescribe.setText("清朝时期宫廷盛宴。既有宫廷菜肴之特色，又有地方风味之精华；突出满族与汉族菜的特殊风味，烧烤、火锅、涮涮锅几乎不可缺少的菜点.");
            }
        });

        viewBinding.floatingViewDrag.setParent(viewBinding.parentLayout);
        viewBinding.floatingViewDrag.attachToRecyclerView(viewBinding.recyclerView);


        viewBinding.drag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] location = new int[2];
                v.getLocationInWindow(location);
                Log.i(Tag, "X：" + location[0] + "   Y:" + location[1]);
            }
        });
    }
}
