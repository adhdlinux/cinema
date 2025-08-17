package com.unity3d.services.ads.adunit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import java.util.ArrayList;
import java.util.Map;

public class AdUnitActivity extends Activity implements IAdUnitActivity {
    public static final String EXTRA_ACTIVITY_ID = "activityId";
    public static final String EXTRA_DISPLAY_CUTOUT_MODE = "displayCutoutMode";
    public static final String EXTRA_KEEP_SCREEN_ON = "keepScreenOn";
    public static final String EXTRA_KEY_EVENT_LIST = "keyEvents";
    public static final String EXTRA_ORIENTATION = "orientation";
    public static final String EXTRA_SYSTEM_UI_VISIBILITY = "systemUiVisibility";
    public static final String EXTRA_VIEWS = "views";
    protected AdUnitActivityController _controller;

    /* access modifiers changed from: protected */
    public AdUnitActivityController createController() {
        return new AdUnitActivityController(this, SharedInstances.INSTANCE.getWebViewEventSender(), new AdUnitViewHandlerFactory());
    }

    public Activity getActivity() {
        return this;
    }

    public Context getContext() {
        return this;
    }

    public AdUnitRelativeLayout getLayout() {
        return this._controller.getLayout();
    }

    public Map<String, Integer> getViewFrame(String str) {
        return this._controller.getViewFrame(str);
    }

    public IAdUnitViewHandler getViewHandler(String str) {
        return this._controller.getViewHandler(str);
    }

    public String[] getViews() {
        return this._controller.getViews();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AdUnitActivityController createController = createController();
        this._controller = createController;
        createController.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this._controller.onDestroy();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return this._controller.onKeyDown(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this._controller.onPause();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this._controller.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this._controller.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this._controller.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this._controller.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this._controller.onStop();
    }

    public void onWindowFocusChanged(boolean z2) {
        this._controller.onWindowFocusChanged(z2);
        super.onWindowFocusChanged(z2);
    }

    public boolean setKeepScreenOn(boolean z2) {
        return this._controller.setKeepScreenOn(z2);
    }

    public void setKeyEventList(ArrayList<Integer> arrayList) {
        this._controller.setKeyEventList(arrayList);
    }

    public void setLayoutInDisplayCutoutMode(int i2) {
        this._controller.setLayoutInDisplayCutoutMode(i2);
    }

    public void setOrientation(int i2) {
        this._controller.setOrientation(i2);
    }

    public boolean setSystemUiVisibility(int i2) {
        return this._controller.setSystemUiVisibility(i2);
    }

    public void setViewFrame(String str, int i2, int i3, int i4, int i5) {
        this._controller.setViewFrame(str, i2, i3, i4, i5);
    }

    public void setViews(String[] strArr) {
        this._controller.setViews(strArr);
    }
}
