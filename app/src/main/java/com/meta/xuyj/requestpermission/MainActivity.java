package com.meta.xuyj.requestpermission;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.meta.xuyj.permission.AskPermission;
import com.meta.xuyj.permission.PermissionHelper;
import com.meta.xuyj.permission.PermissionInterface;

public class MainActivity extends AppCompatActivity {


    private PermissionHelper mPermissionHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPermissionHelper=AskPermission.init(this)
                .request(new PermissionInterface() {
                    @Override
                    public int getPermissionsRequestCode() {
                        return 10000;
                    }

                    @Override
                    public String[] getPermissions() {
                        return new String[]{
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_PHONE_STATE,
                                Manifest.permission.CAMERA,
                                Manifest.permission.READ_EXTERNAL_STORAGE
                        };
                    }

                    @Override
                    public void requestPermissionsSuccess() {
                        Toast.makeText(MainActivity.this, "Request Permission Succeed!", Toast
                                .LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void requestPermissionsFail() {
                        Toast.makeText(MainActivity.this, "Request Permission Failed!", Toast
                                .LENGTH_SHORT).show();
                    }
                });
    }
    public void initView(){ }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (mPermissionHelper.requestPermissionsResult(requestCode, permissions, grantResults)) {
            //权限请求结果，并已经处理了该回调
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
