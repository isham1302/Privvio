package com.example.privvio;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AppViewHolder  extends RecyclerView.ViewHolder  {
    public ImageView icon;
    public TextView name,appPackage;

    private AppOnClickListener listener;

    public void setListener(AppOnClickListener listener) {
        this.listener = listener;
    }

    public AppViewHolder(@NonNull View itemView) {
        super(itemView);

        icon= itemView.findViewById(R.id.icon_app);
        name= itemView.findViewById(R.id.name_app);
        appPackage= itemView.findViewById(R.id.app_package);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.selectApp(getAdapterPosition());
            }
        });
    }
}
