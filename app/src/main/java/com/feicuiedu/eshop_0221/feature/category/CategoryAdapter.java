package com.feicuiedu.eshop_0221.feature.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.feicuiedu.eshop_0221.R;
import com.feicuiedu.eshop_0221.network.entity.CategoryPrimary;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gqq on 2017/2/24.
 */

// 一级分类的适配器
public class CategoryAdapter extends BaseAdapter {

    private List<CategoryPrimary> mData = new ArrayList<>();

    // 对外提供一个方法
    public void reset(List<CategoryPrimary> data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public CategoryPrimary getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_primary_category, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.mTextCategory.setText(mData.get(position).getName());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.text_category)
        TextView mTextCategory;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
