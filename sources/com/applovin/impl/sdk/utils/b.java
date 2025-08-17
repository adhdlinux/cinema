package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.applovin.adview.AppLovinAdView;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdkUtils;

public class b {
    public static MaxAdFormat a(Context context) {
        return (AppLovinSdkUtils.isTablet(context) || AppLovinSdkUtils.isTv(context)) ? MaxAdFormat.LEADER : MaxAdFormat.BANNER;
    }

    public static AppLovinAdSize a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(AppLovinAdView.NAMESPACE, "size");
        if (StringUtils.isValidString(attributeValue)) {
            return AppLovinAdSize.fromString(attributeValue);
        }
        return null;
    }

    public static String a(Context context, AttributeSet attributeSet, String str, String str2) {
        if (context == null || attributeSet == null || str == null || str2 == null) {
            return null;
        }
        int attributeResourceValue = attributeSet.getAttributeResourceValue(str, str2, 0);
        return attributeResourceValue == 0 ? attributeSet.getAttributeValue(str, str2) : context.getResources().getString(attributeResourceValue);
    }

    public static void a(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            int indexOfChild = viewGroup.indexOfChild(view);
            if (indexOfChild == -1) {
                viewGroup.removeAllViews();
                return;
            }
            viewGroup.removeViews(0, indexOfChild);
            viewGroup.removeViews(1, viewGroup.getChildCount() - 1);
        }
    }

    public static boolean a(View view) {
        if (view == null || view.getRootView() == null || !(view.getRootView().getLayoutParams() instanceof WindowManager.LayoutParams)) {
            return false;
        }
        int i2 = ((WindowManager.LayoutParams) view.getRootView().getLayoutParams()).type;
        return i2 == 2002 || i2 == 2007 || i2 == 2003 || i2 == 2010 || i2 == 2006 || (Build.VERSION.SDK_INT >= 26 && i2 == 2038);
    }

    public static boolean b(AttributeSet attributeSet) {
        return attributeSet != null && attributeSet.getAttributeBooleanValue(AppLovinAdView.NAMESPACE, "loadAdOnCreate", false);
    }
}
