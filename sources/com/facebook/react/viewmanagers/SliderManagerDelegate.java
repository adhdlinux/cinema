package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.SliderManagerInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public class SliderManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & SliderManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public SliderManagerDelegate(U u2) {
        super(u2);
    }

    public void setProperty(T t2, String str, Object obj) {
        String str2;
        double d2;
        str.hashCode();
        boolean z2 = true;
        boolean z3 = false;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1900655011:
                if (str.equals("maximumTrackTintColor")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1736983259:
                if (str.equals("thumbImage")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1609594047:
                if (str.equals(ViewProps.ENABLED)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1021497397:
                if (str.equals("minimumTrackTintColor")) {
                    c2 = 3;
                    break;
                }
                break;
            case -981448432:
                if (str.equals("maximumTrackImage")) {
                    c2 = 4;
                    break;
                }
                break;
            case -877170387:
                if (str.equals(ViewProps.TEST_ID)) {
                    c2 = 5;
                    break;
                }
                break;
            case 3540684:
                if (str.equals("step")) {
                    c2 = 6;
                    break;
                }
                break;
            case 111972721:
                if (str.equals(AppMeasurementSdk.ConditionalUserProperty.VALUE)) {
                    c2 = 7;
                    break;
                }
                break;
            case 270940796:
                if (str.equals("disabled")) {
                    c2 = 8;
                    break;
                }
                break;
            case 718061361:
                if (str.equals("maximumValue")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1139400400:
                if (str.equals("trackImage")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1192487427:
                if (str.equals("minimumValue")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1333596542:
                if (str.equals("minimumTrackImage")) {
                    c2 = 12;
                    break;
                }
                break;
            case 1912319986:
                if (str.equals("thumbTintColor")) {
                    c2 = 13;
                    break;
                }
                break;
        }
        double d3 = 0.0d;
        switch (c2) {
            case 0:
                ((SliderManagerInterface) this.mViewManager).setMaximumTrackTintColor(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            case 1:
                ((SliderManagerInterface) this.mViewManager).setThumbImage(t2, (ReadableMap) obj);
                return;
            case 2:
                SliderManagerInterface sliderManagerInterface = (SliderManagerInterface) this.mViewManager;
                if (obj != null) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                sliderManagerInterface.setEnabled(t2, z2);
                return;
            case 3:
                ((SliderManagerInterface) this.mViewManager).setMinimumTrackTintColor(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            case 4:
                ((SliderManagerInterface) this.mViewManager).setMaximumTrackImage(t2, (ReadableMap) obj);
                return;
            case 5:
                SliderManagerInterface sliderManagerInterface2 = (SliderManagerInterface) this.mViewManager;
                if (obj == null) {
                    str2 = "";
                } else {
                    str2 = (String) obj;
                }
                sliderManagerInterface2.setTestID(t2, str2);
                return;
            case 6:
                SliderManagerInterface sliderManagerInterface3 = (SliderManagerInterface) this.mViewManager;
                if (obj != null) {
                    d3 = ((Double) obj).doubleValue();
                }
                sliderManagerInterface3.setStep(t2, d3);
                return;
            case 7:
                SliderManagerInterface sliderManagerInterface4 = (SliderManagerInterface) this.mViewManager;
                if (obj != null) {
                    d3 = ((Double) obj).doubleValue();
                }
                sliderManagerInterface4.setValue(t2, d3);
                return;
            case 8:
                SliderManagerInterface sliderManagerInterface5 = (SliderManagerInterface) this.mViewManager;
                if (obj != null) {
                    z3 = ((Boolean) obj).booleanValue();
                }
                sliderManagerInterface5.setDisabled(t2, z3);
                return;
            case 9:
                SliderManagerInterface sliderManagerInterface6 = (SliderManagerInterface) this.mViewManager;
                if (obj == null) {
                    d2 = 1.0d;
                } else {
                    d2 = ((Double) obj).doubleValue();
                }
                sliderManagerInterface6.setMaximumValue(t2, d2);
                return;
            case 10:
                ((SliderManagerInterface) this.mViewManager).setTrackImage(t2, (ReadableMap) obj);
                return;
            case 11:
                SliderManagerInterface sliderManagerInterface7 = (SliderManagerInterface) this.mViewManager;
                if (obj != null) {
                    d3 = ((Double) obj).doubleValue();
                }
                sliderManagerInterface7.setMinimumValue(t2, d3);
                return;
            case 12:
                ((SliderManagerInterface) this.mViewManager).setMinimumTrackImage(t2, (ReadableMap) obj);
                return;
            case 13:
                ((SliderManagerInterface) this.mViewManager).setThumbTintColor(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            default:
                super.setProperty(t2, str, obj);
                return;
        }
    }
}
