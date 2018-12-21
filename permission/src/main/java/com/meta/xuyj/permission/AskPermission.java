package com.meta.xuyj.permission;

import android.app.Activity;
import android.support.annotation.NonNull;

public class AskPermission {

    private PermissionHelper permissionHelper;

    private Activity mActivity;

    public AskPermission(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public static AskPermission init(@NonNull Activity activity) {
        return new AskPermission(activity);
    }
    public PermissionHelper request(PermissionInterface callback){
        permissionHelper=new PermissionHelper(mActivity,callback);
        permissionHelper.requestPermissions();
        return permissionHelper;
    }
}
