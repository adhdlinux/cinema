package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.AndroidSwitchManagerInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public class AndroidSwitchManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidSwitchManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidSwitchManagerDelegate(U u2) {
        super(u2);
    }

    public void receiveCommand(T t2, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeValue")) {
            ((AndroidSwitchManagerInterface) this.mViewManager).setNativeValue(t2, readableArray.getBoolean(0));
        }
    }

    public void setProperty(T t2, String str, Object obj) {
        str.hashCode();
        boolean z2 = true;
        boolean z3 = false;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1742453971:
                if (str.equals("thumbColor")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1609594047:
                if (str.equals(ViewProps.ENABLED)) {
                    c2 = 1;
                    break;
                }
                break;
            case -287374307:
                if (str.equals("trackTintColor")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3551:
                if (str.equals(ViewProps.ON)) {
                    c2 = 3;
                    break;
                }
                break;
            case 111972721:
                if (str.equals(AppMeasurementSdk.ConditionalUserProperty.VALUE)) {
                    c2 = 4;
                    break;
                }
                break;
            case 270940796:
                if (str.equals("disabled")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1084662482:
                if (str.equals("trackColorForFalse")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1912319986:
                if (str.equals("thumbTintColor")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2113632767:
                if (str.equals("trackColorForTrue")) {
                    c2 = 8;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((AndroidSwitchManagerInterface) this.mViewManager).setThumbColor(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            case 1:
                AndroidSwitchManagerInterface androidSwitchManagerInterface = (AndroidSwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                androidSwitchManagerInterface.setEnabled(t2, z2);
                return;
            case 2:
                ((AndroidSwitchManagerInterface) this.mViewManager).setTrackTintColor(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            case 3:
                AndroidSwitchManagerInterface androidSwitchManagerInterface2 = (AndroidSwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    z3 = ((Boolean) obj).booleanValue();
                }
                androidSwitchManagerInterface2.setOn(t2, z3);
                return;
            case 4:
                AndroidSwitchManagerInterface androidSwitchManagerInterface3 = (AndroidSwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    z3 = ((Boolean) obj).booleanValue();
                }
                androidSwitchManagerInterface3.setValue(t2, z3);
                return;
            case 5:
                AndroidSwitchManagerInterface androidSwitchManagerInterface4 = (AndroidSwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    z3 = ((Boolean) obj).booleanValue();
                }
                androidSwitchManagerInterface4.setDisabled(t2, z3);
                return;
            case 6:
                ((AndroidSwitchManagerInterface) this.mViewManager).setTrackColorForFalse(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            case 7:
                ((AndroidSwitchManagerInterface) this.mViewManager).setThumbTintColor(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            case 8:
                ((AndroidSwitchManagerInterface) this.mViewManager).setTrackColorForTrue(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            default:
                super.setProperty(t2, str, obj);
                return;
        }
    }
}
