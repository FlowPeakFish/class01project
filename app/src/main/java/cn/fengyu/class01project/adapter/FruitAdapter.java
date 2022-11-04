package cn.fengyu.class01project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.fengyu.class01project.R;
import cn.fengyu.class01project.entity.Fruit;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 得到对应位置的实体
        Fruit fruit = getItem(position);
        // 为每个子项加载设定的布局
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fruit_item,
                parent, false);
        // 从布局中分别获取图片、名称、价格的对象(控件)
        ImageView image = view.findViewById(R.id.fruit_id);
        TextView name = view.findViewById(R.id.fruit_name);
        TextView price = view.findViewById(R.id.fruit_price);
        // 分别设置具体的图片和值
        image.setImageResource(fruit.getImageId());
        name.setText(fruit.getName());
        price.setText(fruit.getPrice());

        return view;
    }
}
