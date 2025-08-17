package com.facebook.react.uimanager;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.Map;

public class ReactStylesDiffMap {
    final ReadableMap mBackingMap;

    public ReactStylesDiffMap(ReadableMap readableMap) {
        this.mBackingMap = readableMap;
    }

    public ReadableArray getArray(String str) {
        return this.mBackingMap.getArray(str);
    }

    public boolean getBoolean(String str, boolean z2) {
        return this.mBackingMap.isNull(str) ? z2 : this.mBackingMap.getBoolean(str);
    }

    public double getDouble(String str, double d2) {
        return this.mBackingMap.isNull(str) ? d2 : this.mBackingMap.getDouble(str);
    }

    public Dynamic getDynamic(String str) {
        return this.mBackingMap.getDynamic(str);
    }

    public float getFloat(String str, float f2) {
        if (this.mBackingMap.isNull(str)) {
            return f2;
        }
        return (float) this.mBackingMap.getDouble(str);
    }

    public int getInt(String str, int i2) {
        return this.mBackingMap.isNull(str) ? i2 : this.mBackingMap.getInt(str);
    }

    public ReadableMap getMap(String str) {
        return this.mBackingMap.getMap(str);
    }

    public String getString(String str) {
        return this.mBackingMap.getString(str);
    }

    public boolean hasKey(String str) {
        return this.mBackingMap.hasKey(str);
    }

    public boolean isNull(String str) {
        return this.mBackingMap.isNull(str);
    }

    public Map<String, Object> toMap() {
        return this.mBackingMap.toHashMap();
    }

    public String toString() {
        return "{ " + getClass().getSimpleName() + ": " + this.mBackingMap.toString() + " }";
    }
}
