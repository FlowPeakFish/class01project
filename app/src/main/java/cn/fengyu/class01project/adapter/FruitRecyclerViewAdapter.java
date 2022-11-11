package cn.fengyu.class01project.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.fengyu.class01project.R;
import cn.fengyu.class01project.entity.Fruit;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FruitRecyclerViewAdapter extends RecyclerView.Adapter<FruitRecyclerViewAdapter.ViewHolder> {

    private List<Fruit> mFruits;

    public FruitRecyclerViewAdapter(List<Fruit> mFruits) {
        this.mFruits = mFruits;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView price;

        // 从布局中分别获取图片、名称、价格的对象(控件)
        // 保存到ViewHolder中
        public ViewHolder(@NonNull @NotNull View view) {
            super(view);
            image = view.findViewById(R.id.fruit_id);
            name = view.findViewById(R.id.fruit_name);
            price = view.findViewById(R.id.fruit_price);
        }
    }

    // parent = RecyclerView
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup recyclerView, int viewType) {
        View view = LayoutInflater.from(recyclerView.getContext())
                .inflate(R.layout.fruit_item,
                        recyclerView, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder viewHolder,
                                 int position) {
        Fruit fruit = mFruits.get(position);
        viewHolder.image.setImageResource(fruit.getImageId());
        viewHolder.name.setText(fruit.getName());
        viewHolder.price.setText(fruit.getPrice());
    }

    @Override
    public int getItemCount() {
        return mFruits.size();
    }
}
