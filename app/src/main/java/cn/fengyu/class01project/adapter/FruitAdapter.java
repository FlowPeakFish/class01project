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

        final View view;
        // final ImageView image;
        // final TextView name;
        // final TextView price;
        ViewHolder viewHolder;

        // 为每个子项加载设定的布局
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.fruit_item, parent, false);

            // 从布局中分别获取图片、名称、价格的对象(控件)
            // image = view.findViewById(R.id.fruit_id);
            // name = view.findViewById(R.id.fruit_name);
            // price = view.findViewById(R.id.fruit_price);

            viewHolder = new ViewHolder();
            viewHolder.image = view.findViewById(R.id.fruit_id);
            viewHolder.name = view.findViewById(R.id.fruit_name);
            viewHolder.price = view.findViewById(R.id.fruit_price);

            // view.setTag(R.id.fruit_id,image);
            // view.setTag(R.id.fruit_name,name);
            // view.setTag(R.id.fruit_price,price);

            view.setTag(viewHolder);
        } else {
            view = convertView;

            // image = (ImageView) view.getTag(R.id.fruit_id);
            // name = (TextView) view.getTag(R.id.fruit_name);
            // price = (TextView) view.getTag(R.id.fruit_price);

            viewHolder = (ViewHolder) view.getTag();
        }

        // 得到对应位置的实体
        Fruit fruit = getItem(position);
        // 分别设置具体的图片和值
        // image.setImageResource(fruit.getImageId());
        // name.setText(fruit.getName());
        // price.setText(fruit.getPrice());

        viewHolder.image.setImageResource(fruit.getImageId());
        viewHolder.name.setText(fruit.getName());
        viewHolder.price.setText(fruit.getPrice());

        return view;
    }

    private class ViewHolder {
        ImageView image;
        TextView name;
        TextView price;
    }
}
