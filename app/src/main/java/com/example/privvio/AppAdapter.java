package com.example.privvio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppViewHolder> {
    private Context mcontext;
    private List<AppItem> appItemList;
    String pk;

    public AppAdapter(Context mcontext, List<AppItem> appItemList) {
        this.mcontext = mcontext;
        this.appItemList = appItemList;
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.layout_app,parent,false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position) {
        holder.name.setText(appItemList.get(position).getName());
        holder.appPackage.setText(appItemList.get(position).getPackageName());
        holder.icon.setImageDrawable(appItemList.get(position).getIcon());

        pk= appItemList.get(position).getPackageName();
    }

    @Override
    public int getItemCount() {
        return appItemList.size();
    }
}
