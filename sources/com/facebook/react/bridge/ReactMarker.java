package com.facebook.react.bridge;

import android.os.SystemClock;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@DoNotStrip
public class ReactMarker {
    private static final List<FabricMarkerListener> sFabricMarkerListeners = new CopyOnWriteArrayList();
    private static final List<MarkerListener> sListeners = new CopyOnWriteArrayList();

    public interface FabricMarkerListener {
        void logFabricMarker(ReactMarkerConstants reactMarkerConstants, String str, int i2, long j2);
    }

    public interface MarkerListener {
        void logMarker(ReactMarkerConstants reactMarkerConstants, String str, int i2);
    }

    @DoNotStrip
    public static void addFabricListener(FabricMarkerListener fabricMarkerListener) {
        List<FabricMarkerListener> list = sFabricMarkerListeners;
        if (!list.contains(fabricMarkerListener)) {
            list.add(fabricMarkerListener);
        }
    }

    @DoNotStrip
    public static void addListener(MarkerListener markerListener) {
        List<MarkerListener> list = sListeners;
        if (!list.contains(markerListener)) {
            list.add(markerListener);
        }
    }

    @DoNotStrip
    public static void clearFabricMarkerListeners() {
        sFabricMarkerListeners.clear();
    }

    @DoNotStrip
    public static void clearMarkerListeners() {
        sListeners.clear();
    }

    @DoNotStrip
    public static void logFabricMarker(ReactMarkerConstants reactMarkerConstants, String str, int i2, long j2) {
        for (FabricMarkerListener logFabricMarker : sFabricMarkerListeners) {
            logFabricMarker.logFabricMarker(reactMarkerConstants, str, i2, j2);
        }
    }

    @DoNotStrip
    public static void logMarker(String str) {
        logMarker(str, (String) null);
    }

    @DoNotStrip
    public static void removeFabricListener(FabricMarkerListener fabricMarkerListener) {
        sFabricMarkerListeners.remove(fabricMarkerListener);
    }

    @DoNotStrip
    public static void removeListener(MarkerListener markerListener) {
        sListeners.remove(markerListener);
    }

    @DoNotStrip
    public static void logMarker(String str, int i2) {
        logMarker(str, (String) null, i2);
    }

    @DoNotStrip
    public static void logFabricMarker(ReactMarkerConstants reactMarkerConstants, String str, int i2) {
        logFabricMarker(reactMarkerConstants, str, i2, SystemClock.uptimeMillis());
    }

    @DoNotStrip
    public static void logMarker(String str, String str2) {
        logMarker(str, str2, 0);
    }

    @DoNotStrip
    public static void logMarker(String str, String str2, int i2) {
        logMarker(ReactMarkerConstants.valueOf(str), str2, i2);
    }

    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants) {
        logMarker(reactMarkerConstants, (String) null, 0);
    }

    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, int i2) {
        logMarker(reactMarkerConstants, (String) null, i2);
    }

    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, String str) {
        logMarker(reactMarkerConstants, str, 0);
    }

    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, String str, int i2) {
        logFabricMarker(reactMarkerConstants, str, i2);
        for (MarkerListener logMarker : sListeners) {
            logMarker.logMarker(reactMarkerConstants, str, i2);
        }
    }
}
