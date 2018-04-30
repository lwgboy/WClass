package com.example.administrator.wclass.classFuture;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.wclass.R;
import com.example.administrator.wclass.base.OnClickerListener;
import com.example.administrator.wclass.data.bean.ClassBean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/29.
 */

public class ClassFragmentAdapter extends RecyclerView.Adapter<ClassFragmentAdapter.ViewHolder> {
    private Context context;
    private List<ClassBean> classBeanList;
    private OnClickerListener onClickerListener;

    public ClassFragmentAdapter(Context context,OnClickerListener onClickerListener) {
        this.context = context;
        this.onClickerListener = onClickerListener;
    }

       @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.class_recycler_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        if (onClickerListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickerListener.click(holder.getLayoutPosition(),holder.itemView);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView classImage;
        TextView classIdNumber;
        TextView classNumber;
        TextView className;
        TextView classUserName;

        public ViewHolder(View itemView) {
            super(itemView);
            classImage = itemView.findViewById(R.id.member_item_avator);
            classIdNumber = itemView.findViewById(R.id.member_item_all_score);
            classNumber = itemView.findViewById(R.id.member_item_name);
            className = itemView.findViewById(R.id.member_item_number);
            classUserName = itemView.findViewById(R.id.class_user_name);
        }

    }

}