package fansen.com.permission;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ManiFestPermission {

    private static final String TAG = ManiFestPermission.class.getSimpleName();

    private static final String[] PERMISSIONS = {Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    private static final int REQUEST_PERMISSION_CODE = 110;

    public static boolean checkPermissionGrantedAll(Activity context){

        List<String> list = new ArrayList<String>();

        for(String item : PERMISSIONS){

            if(!(context.checkCallingPermission(item) == PackageManager.PERMISSION_GRANTED)){

                list.add(item);

            }

        }

        if(list.size() > 0){

            String[] noPermissions = new String[list.size()];
            list.toArray(noPermissions);
            for(String item : noPermissions){
                Log.i(TAG, "item : " + item);
            }
            context.requestPermissions(noPermissions, REQUEST_PERMISSION_CODE);
            return false;

        }

        return true;
    }
}
