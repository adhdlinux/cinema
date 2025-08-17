package com.facebook.react;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;

public abstract class ReactActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler, PermissionAwareActivity {
    private final ReactActivityDelegate mDelegate = createReactActivityDelegate();

    protected ReactActivity() {
    }

    /* access modifiers changed from: protected */
    public ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate(this, getMainComponentName());
    }

    /* access modifiers changed from: protected */
    public String getMainComponentName() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final ReactInstanceManager getReactInstanceManager() {
        return this.mDelegate.getReactInstanceManager();
    }

    /* access modifiers changed from: protected */
    public final ReactNativeHost getReactNativeHost() {
        return this.mDelegate.getReactNativeHost();
    }

    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public final void loadApp(String str) {
        this.mDelegate.loadApp(str);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.mDelegate.onActivityResult(i2, i3, intent);
    }

    public void onBackPressed() {
        if (!this.mDelegate.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mDelegate.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mDelegate.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mDelegate.onDestroy();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return this.mDelegate.onKeyDown(i2, keyEvent) || super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        return this.mDelegate.onKeyLongPress(i2, keyEvent) || super.onKeyLongPress(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return this.mDelegate.onKeyUp(i2, keyEvent) || super.onKeyUp(i2, keyEvent);
    }

    public void onNewIntent(Intent intent) {
        if (!this.mDelegate.onNewIntent(intent)) {
            super.onNewIntent(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mDelegate.onPause();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mDelegate.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mDelegate.onResume();
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        this.mDelegate.onWindowFocusChanged(z2);
    }

    public void requestPermissions(String[] strArr, int i2, PermissionListener permissionListener) {
        this.mDelegate.requestPermissions(strArr, i2, permissionListener);
    }
}
