package com.jsr.minimo2_base_api23;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

//RecyclerAdapter for RecycleView

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Repository> values;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView languaje;
        public TextView reponame;

        public View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            languaje = v.findViewById(R.id.repoLanguajeName); //.xml reference format file components
            reponame = v.findViewById(R.id.repoName);
        }
    }

    public void add(int position, Repository item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public RecyclerAdapter (List<Repository> myDataset) {
        values = myDataset;
        LayoutInflater inflater;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.activity_recycler_adapter, parent, false); //Here .xml reference format file
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        final String name = values.get(position).getLanguaje();
        holder.languaje.setText(name);
        final String repository = values.get(position).getRepoName();
        holder.reponame.setText(repository);

        //Context context = holder.avatar.getContext();
        //Picasso.with(context).load(values.get(position).getAvatar_url()).into(holder.avatar);
    }

    @Override
    public int getItemCount() {

        return values.size();
    }
}
