package com.facebook.react.common.mapbuffer;

import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;

public interface MapBuffer extends Iterable<Entry>, KMappedMarker {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IntRange KEY_RANGE = new IntRange(0, 65535);

        private Companion() {
        }

        public final IntRange getKEY_RANGE$ReactAndroid_release() {
            return KEY_RANGE;
        }
    }

    public enum DataType {
        BOOL,
        INT,
        DOUBLE,
        STRING,
        MAP
    }

    public interface Entry {
        boolean getBooleanValue();

        double getDoubleValue();

        int getIntValue();

        int getKey();

        MapBuffer getMapBufferValue();

        String getStringValue();

        DataType getType();
    }

    boolean contains(int i2);

    Entry entryAt(int i2);

    boolean getBoolean(int i2);

    int getCount();

    double getDouble(int i2);

    int getInt(int i2);

    int getKeyOffset(int i2);

    MapBuffer getMapBuffer(int i2);

    String getString(int i2);

    DataType getType(int i2);
}
