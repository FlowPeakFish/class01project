package cn.fengyu.class01project.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.fengyu.class01project.MusicPlayerActivity;
import cn.fengyu.class01project.R;
import cn.fengyu.class01project.entity.Fruit;
import cn.fengyu.class01project.entity.Music;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MusicRecyclerViewAdapter extends RecyclerView.Adapter<MusicRecyclerViewAdapter.ViewHolder> {

    private List<Music> mMusics;

    public MusicRecyclerViewAdapter(List<Music> mMusics) {
        this.mMusics = mMusics;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView title;
        TextView artist;

        // 从布局中分别获取图片、名称、价格的对象(控件)
        // 保存到ViewHolder中
        public ViewHolder(@NonNull @NotNull View view) {
            super(view);
            this.mView = view;
            title = view.findViewById(R.id.title);
            artist = view.findViewById(R.id.artist);
        }
    }

    // parent = RecyclerView
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup recyclerView, int viewType) {
        View view = LayoutInflater.from(recyclerView.getContext())
                .inflate(R.layout.music_item,
                        recyclerView, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getBindingAdapterPosition();
                Music music = mMusics.get(position);
                Toast.makeText(recyclerView.getContext(),
                                music.getTitle() + " 音乐 被点击了", Toast.LENGTH_SHORT)
                        .show();

                Intent intent = new Intent(recyclerView.getContext(),
                        MusicPlayerActivity.class);
                intent.putExtra("position", position);
                recyclerView.getContext().startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder viewHolder,
                                 int position) {
        Music music = mMusics.get(position);
        viewHolder.title.setText(music.getTitle());
        viewHolder.artist.setText(music.getArtist());
    }

    @Override
    public int getItemCount() {
        return mMusics.size();
    }
}
