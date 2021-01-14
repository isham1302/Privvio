package com.example.privvio;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.provider.Settings.ACTION_MANAGE_OVERLAY_PERMISSION;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }
    //Display List of Apps
    private void initView() {
        RecyclerView recyclerView= findViewById(R.id.recycle_View);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AppAdapter appAdapter= new AppAdapter(this,getAllApps());
        recyclerView.setAdapter(appAdapter);

        layoutPermission= findViewById(R.id.layout_permission);

    }
    //Request Permission
    @Override
    protected void onResume() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            if (Utilis.Check_Permission(this)){
                layoutPermission.setVisibility(View.GONE);
            }else {
                layoutPermission.setVisibility(View.VISIBLE);
            }
        }
        super.onResume();
    }
    // List of Apps
    private List<AppItem> getAllApps() {
        List<AppItem> results= new ArrayList<>();
        PackageManager pk= getPackageManager();
        Intent intent= new Intent(Intent.ACTION_MAIN,null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfoList= pk.queryIntentActivities(intent,0);

        for (ResolveInfo resolveInfo : resolveInfoList){
            ActivityInfo activityInfo= resolveInfo.activityInfo;
            results.add(new AppItem(activityInfo.loadIcon(pk),activityInfo.loadLabel(pk).toString(),activityInfo.packageName));
        }

        return results;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setPermission(View view) {
        startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION));
                //ACTION_USAGE_ACCESS_SETTINGS
    }
}