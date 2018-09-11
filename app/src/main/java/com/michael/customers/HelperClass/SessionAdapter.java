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

public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.ViewHolder> {
    private ArrayList<Session> android;
    private Context context;

    public SessionAdapter(Context context, ArrayList<Session> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public SessionAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout_session, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SessionAdapter.ViewHolder viewHolder, int i) {

        viewHolder.username.setText(android.get(i).getUserName());
        viewHolder.session.setText(android.get(i).getUserImage());

    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView username;
        private TextView session;

        public ViewHolder(View view) {
            super(view);

            username = (TextView) view.findViewById(R.id.user);
            session = (TextView) view.findViewById(R.id.tv_android);
        }
    }

}