package com.michael.customers.HelperClass;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.michael.customers.R;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<User> android;
    private Context context;

    public DataAdapter(Context context, ArrayList<User> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.username.setText(android.get(i).getUserName());
        viewHolder.image.setImageResource(R.drawable.ic_launcher_background);

    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView username;
        private ImageView image;

        public ViewHolder(View view) {
            super(view);

            username = (TextView) view.findViewById(R.id.tv_android);
            image = (ImageView) view.findViewById(R.id.img_android);
        }
    }

}