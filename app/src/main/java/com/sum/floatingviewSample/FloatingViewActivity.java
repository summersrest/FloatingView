package com.sum.floatingviewSample;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.sum.floatingviewSample.databinding.ActivityFloatingViewBinding;
import com.sum.floatingviewSample.databinding.ItemListBinding;
import com.sum.simpleadapter.BaseAdapter;
import com.sum.simpleadapter.base.ViewHolder;
import java.util.Arrays;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author liujiang
 * created at: 2021/9/30 13:26
 * Desc: 普通悬浮窗
 */
public class FloatingViewActivity extends AppCompatActivity {
    ActivityFloatingViewBinding viewBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityFloatingViewBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        List<String> data = Arrays.asList(new String[30]);
        viewBinding.recyclerView.setNestedScrollingEnabled(false);
        viewBinding.recyclerView.setAdapter(new BaseAdapter<ItemListBinding, String>(FloatingViewActivity.this, data) {

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

        viewBinding.floatingView.attachToNestedScrollView(viewBinding.scrollView);
    }
}
