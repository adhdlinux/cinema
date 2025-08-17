package com.facebook.ads;

import android.content.Context;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.Collection;

public class AdSettings {
    public static final boolean DEBUG = false;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f19416a;

    /* renamed from: b  reason: collision with root package name */
    private static TestAdType f19417b = TestAdType.DEFAULT;

    public enum TestAdType {
        DEFAULT("DEFAULT", "Default"),
        IMG_16_9_APP_INSTALL("IMG_16_9_APP_INSTALL", "Image App install"),
        IMG_16_9_LINK("IMG_16_9_LINK", "Image link"),
        VIDEO_HD_16_9_46S_APP_INSTALL("VID_HD_16_9_46S_APP_INSTALL", "Video 46 sec App install"),
        VIDEO_HD_16_9_46S_LINK("VID_HD_16_9_46S_LINK", "Video 46 sec link"),
        VIDEO_HD_16_9_15S_APP_INSTALL("VID_HD_16_9_15S_APP_INSTALL", "Video 15 sec App install"),
        VIDEO_HD_16_9_15S_LINK("VID_HD_16_9_15S_LINK", "Video 15 sec link"),
        VIDEO_HD_9_16_39S_APP_INSTALL("VID_HD_9_16_39S_APP_INSTALL", "Video 39 sec App install"),
        VIDEO_HD_9_16_39S_LINK("VID_HD_9_16_39S_LINK", "Video 39 sec link"),
        CAROUSEL_IMG_SQUARE_APP_INSTALL("CAROUSEL_IMG_SQUARE_APP_INSTALL", "Carousel App install"),
        CAROUSEL_IMG_SQUARE_LINK("CAROUSEL_IMG_SQUARE_LINK", "Carousel link");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f19419a;

        /* renamed from: b  reason: collision with root package name */
        private final String f19420b;

        private TestAdType(String str, String str2) {
            this.f19419a = str;
            this.f19420b = str2;
        }

        public String getAdTypeString() {
            return this.f19419a;
        }

        public String getHumanReadable() {
            return this.f19420b;
        }
    }

    public static void addTestDevice(String str) {
        AdInternalSettings.addTestDevice(str);
    }

    public static void addTestDevices(Collection<String> collection) {
        AdInternalSettings.addTestDevices(collection);
    }

    public static void clearTestDevices() {
        AdInternalSettings.clearTestDevices();
    }

    public static String getMediationService() {
        return AdInternalSettings.getMediationService();
    }

    public static TestAdType getTestAdType() {
        return f19417b;
    }

    public static String getUrlPrefix() {
        return AdInternalSettings.getUrlPrefix();
    }

    public static boolean isChildDirected() {
        return f19416a;
    }

    public static boolean isTestMode(Context context) {
        return AdInternalSettings.isTestMode(context);
    }

    public static boolean isVideoAutoplay() {
        return AdInternalSettings.isVideoAutoplay();
    }

    public static boolean isVideoAutoplayOnMobile() {
        return AdInternalSettings.isVideoAutoplayOnMobile();
    }

    public static void setDebugBuild(boolean z2) {
        AdInternalSettings.setDebugBuild(z2);
    }

    public static void setIsChildDirected(boolean z2) {
        f19416a = z2;
    }

    public static void setMediationService(String str) {
        AdInternalSettings.setMediationService(str);
    }

    public static void setTestAdType(TestAdType testAdType) {
        f19417b = testAdType;
    }

    public static void setUrlPrefix(String str) {
        AdInternalSettings.setUrlPrefix(str);
    }

    public static void setVideoAutoplay(boolean z2) {
        AdInternalSettings.setVideoAutoplay(z2);
    }

    public static void setVideoAutoplayOnMobile(boolean z2) {
        AdInternalSettings.setVideoAutoplayOnMobile(z2);
    }
}
