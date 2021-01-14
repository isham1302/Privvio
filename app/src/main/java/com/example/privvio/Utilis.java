package com.example.privvio;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;

import static android.app.AppOpsManager.MODE_ALLOWED;

import androidx.annotation.RequiresApi;

public class Utilis {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static boolean Check_Permission(Context ctx){
        AppOpsManager appOpsManager= (AppOpsManager)ctx.getSystemService(Context.APP_OPS_SERVICE);
        int mode= appOpsManager.checkOpNoThrow(AppOpsManager.OPSTR_SYSTEM_ALERT_WINDOW, Process.myUid(),ctx.getPackageName());
        return mode == MODE_ALLOWED;
    }
}
