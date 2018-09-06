package com.gopalkrath.androidroomormsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gopal on 2/2/18.
 */

public class RcvAdapter extends RecyclerView.Adapter<RcvAdapter.MyViewHolder> {

    ArrayList<TaskModel> lstTaskModel;

    public RcvAdapter(ArrayList<TaskModel> lst) {
        this.lstTaskModel = lst;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TaskModel taskModel = lstTaskModel.get(position);
        holder.txtName.setText(taskModel.getmSubject());
    }

    @Override
    public int getItemCount() {
        return lstTaskModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtName = (TextView) itemView.findViewById(R.id.txtName);
        }
    }
}
