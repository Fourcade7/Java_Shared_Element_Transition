package com.pr.java_shared_element_transition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<String > namearraylist;
    ArrayList<Integer> imagearraylist;

    public MyAdapter(Context context, ArrayList<String> namearraylist, ArrayList<Integer> imagearraylist) {
        this.context = context;
        this.namearraylist = namearraylist;
        this.imagearraylist = imagearraylist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(imagearraylist.get(position));
        holder.textView.setText(namearraylist.get(position));

        holder.itemView.setOnClickListener(view -> {




            Intent intent = new Intent(context, MainActivity2.class);
            // create the transition animation - the images in the layouts
            // of both activities are defined with android:transitionName="robot"
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation((Activity) context, holder.imageView, "profile");
            intent.putExtra("img",imagearraylist.get(position));
            // start the new activity
            context.startActivity(intent, options.toBundle());
        });
    }

    @Override
    public int getItemCount() {
        return imagearraylist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview1);
            textView=itemView.findViewById(R.id.textview1);
        }
    }
}
