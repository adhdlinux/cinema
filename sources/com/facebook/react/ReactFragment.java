package com.facebook.react;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;

public class ReactFragment extends Fragment implements PermissionAwareActivity {
    protected static final String ARG_COMPONENT_NAME = "arg_component_name";
    protected static final String ARG_LAUNCH_OPTIONS = "arg_launch_options";
    private PermissionListener mPermissionListener;
    private ReactDelegate mReactDelegate;

    public static class Builder {
        String mComponentName = null;
        Bundle mLaunchOptions = null;

        public ReactFragment build() {
            return ReactFragment.newInstance(this.mComponentName, this.mLaunchOptions);
        }

        public Builder setComponentName(String str) {
            this.mComponentName = str;
            return this;
        }

        public Builder setLaunchOptions(Bundle bundle) {
            this.mLaunchOptions = bundle;
            return this;
        }
    }

    /* access modifiers changed from: private */
    public static ReactFragment newInstance(String str, Bundle bundle) {
        ReactFragment reactFragment = new ReactFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString(ARG_COMPONENT_NAME, str);
        bundle2.putBundle(ARG_LAUNCH_OPTIONS, bundle);
        reactFragment.setArguments(bundle2);
        return reactFragment;
    }

    public int checkPermission(String str, int i2, int i3) {
        return getActivity().checkPermission(str, i2, i3);
    }

    @TargetApi(23)
    public int checkSelfPermission(String str) {
        return getActivity().checkSelfPermission(str);
    }

    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    /* access modifiers changed from: protected */
    public ReactDelegate getReactDelegate() {
        return this.mReactDelegate;
    }

    /* access modifiers changed from: protected */
    public ReactNativeHost getReactNativeHost() {
        return ((ReactApplication) getActivity().getApplication()).getReactNativeHost();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.mReactDelegate.onActivityResult(i2, i3, intent, false);
    }

    public boolean onBackPressed() {
        return this.mReactDelegate.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        String str;
        Bundle bundle2;
        super.onCreate(bundle);
        if (getArguments() != null) {
            str = getArguments().getString(ARG_COMPONENT_NAME);
            bundle2 = getArguments().getBundle(ARG_LAUNCH_OPTIONS);
        } else {
            str = null;
            bundle2 = null;
        }
        if (str != null) {
            this.mReactDelegate = new ReactDelegate(getActivity(), getReactNativeHost(), str, bundle2);
            return;
        }
        throw new IllegalStateException("Cannot loadApp if component name is null");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mReactDelegate.loadApp();
        return this.mReactDelegate.getReactRootView();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mReactDelegate.onHostDestroy();
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return this.mReactDelegate.shouldShowDevMenuOrReload(i2, keyEvent);
    }

    public void onPause() {
        super.onPause();
        this.mReactDelegate.onHostPause();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        PermissionListener permissionListener = this.mPermissionListener;
        if (permissionListener != null && permissionListener.onRequestPermissionsResult(i2, strArr, iArr)) {
            this.mPermissionListener = null;
        }
    }

    public void onResume() {
        super.onResume();
        this.mReactDelegate.onHostResume();
    }

    @TargetApi(23)
    public void requestPermissions(String[] strArr, int i2, PermissionListener permissionListener) {
        this.mPermissionListener = permissionListener;
        requestPermissions(strArr, i2);
    }
}
