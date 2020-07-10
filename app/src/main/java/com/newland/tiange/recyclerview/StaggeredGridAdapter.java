package com.newland.tiange.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.newland.tiange.R;

import java.util.List;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    private List<String> list;

    public StaggeredGridAdapter(Context context, OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
//        this.list = list;
    }

    @NonNull
    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_grid_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.LinearViewHolder holder, final int position) {
        if(position % 2 == 0){
            holder.imageView.setImageResource(R.drawable.xinyuanjieyi);
        }else {
            holder.imageView.setImageResource(R.drawable.genie);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //方法一
//                Toast.makeText(mContext,"click...."+position,Toast.LENGTH_SHORT).show();
                //方法二
                mListener.onclick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 80;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener{
        void onclick(int pos);
    }
}
