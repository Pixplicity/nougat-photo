package com.pixplicity.nougatphoto;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

public class PermissionUtils {

    public static void requestIfNeeded(Activity activity, String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> requestPermissions = new ArrayList<>();
            for (String permission : permissions) {
                if (ContextCompat.checkSelfPermission(activity, permission)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions.add(permission);
                }
            }
            if (!requestPermissions.isEmpty()) {
                activity.requestPermissions(
                        requestPermissions.toArray(new String[requestPermissions.size()]),
                        requestCode);
            }
        }
    }

}
