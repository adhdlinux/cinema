package com.facebook.react.devsupport;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.google.protobuf.CodedOutputStream;

class DebugOverlayController {
    /* access modifiers changed from: private */
    public FrameLayout mFPSDebugViewContainer;
    /* access modifiers changed from: private */
    public final ReactContext mReactContext;
    /* access modifiers changed from: private */
    public final WindowManager mWindowManager;

    public DebugOverlayController(ReactContext reactContext) {
        this.mReactContext = reactContext;
        this.mWindowManager = (WindowManager) reactContext.getSystemService("window");
    }

    private static boolean canHandleIntent(Context context, Intent intent) {
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return true;
        }
        return false;
    }

    private static boolean hasPermission(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), CodedOutputStream.DEFAULT_BUFFER_SIZE).requestedPermissions;
            if (strArr != null) {
                for (String equals : strArr) {
                    if (equals.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            FLog.e(ReactConstants.TAG, "Error while retrieving package info", (Throwable) e2);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean permissionCheck(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return hasPermission(context, "android.permission.SYSTEM_ALERT_WINDOW");
        }
        if (!Settings.canDrawOverlays(context)) {
            return false;
        }
        return true;
    }

    public static void requestPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(context)) {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
            intent.setFlags(268435456);
            FLog.w(ReactConstants.TAG, "Overlay permissions needs to be granted in order for react native apps to run in dev mode");
            if (canHandleIntent(context, intent)) {
                context.startActivity(intent);
            }
        }
    }

    public void setFpsDebugViewVisible(final boolean z2) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (!z2 || DebugOverlayController.this.mFPSDebugViewContainer != null) {
                    if (!z2 && DebugOverlayController.this.mFPSDebugViewContainer != null) {
                        DebugOverlayController.this.mFPSDebugViewContainer.removeAllViews();
                        DebugOverlayController.this.mWindowManager.removeView(DebugOverlayController.this.mFPSDebugViewContainer);
                        FrameLayout unused = DebugOverlayController.this.mFPSDebugViewContainer = null;
                    }
                } else if (!DebugOverlayController.permissionCheck(DebugOverlayController.this.mReactContext)) {
                    FLog.d(ReactConstants.TAG, "Wait for overlay permission to be set");
                } else {
                    FrameLayout unused2 = DebugOverlayController.this.mFPSDebugViewContainer = new FpsView(DebugOverlayController.this.mReactContext);
                    DebugOverlayController.this.mWindowManager.addView(DebugOverlayController.this.mFPSDebugViewContainer, new WindowManager.LayoutParams(-1, -1, WindowOverlayCompat.TYPE_SYSTEM_OVERLAY, 24, -3));
                }
            }
        });
    }
}
