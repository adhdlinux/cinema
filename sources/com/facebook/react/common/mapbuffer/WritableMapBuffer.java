package com.facebook.react.common.mapbuffer;

import android.util.SparseArray;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@DoNotStrip
public final class WritableMapBuffer implements MapBuffer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final SparseArray<Object> values = new SparseArray<>();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final class MapBufferEntry implements MapBuffer.Entry {
        private final int index;
        private final int key;
        final /* synthetic */ WritableMapBuffer this$0;
        private final MapBuffer.DataType type;

        public MapBufferEntry(WritableMapBuffer writableMapBuffer, int i2) {
            Intrinsics.f(writableMapBuffer, "this$0");
            this.this$0 = writableMapBuffer;
            this.index = i2;
            this.key = writableMapBuffer.values.keyAt(i2);
            Object valueAt = writableMapBuffer.values.valueAt(i2);
            Intrinsics.e(valueAt, "values.valueAt(index)");
            this.type = writableMapBuffer.dataType(valueAt, getKey());
        }

        public boolean getBooleanValue() {
            boolean z2;
            int key2 = getKey();
            Object valueAt = this.this$0.values.valueAt(this.index);
            if (valueAt != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(key2)).toString());
            } else if (valueAt instanceof Boolean) {
                return ((Boolean) valueAt).booleanValue();
            } else {
                throw new IllegalStateException(("Expected " + Boolean.class + " for key: " + key2 + ", found " + valueAt.getClass() + " instead.").toString());
            }
        }

        public double getDoubleValue() {
            boolean z2;
            int key2 = getKey();
            Object valueAt = this.this$0.values.valueAt(this.index);
            if (valueAt != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(key2)).toString());
            } else if (valueAt instanceof Double) {
                return ((Number) valueAt).doubleValue();
            } else {
                throw new IllegalStateException(("Expected " + Double.class + " for key: " + key2 + ", found " + valueAt.getClass() + " instead.").toString());
            }
        }

        public int getIntValue() {
            boolean z2;
            int key2 = getKey();
            Object valueAt = this.this$0.values.valueAt(this.index);
            if (valueAt != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(key2)).toString());
            } else if (valueAt instanceof Integer) {
                return ((Number) valueAt).intValue();
            } else {
                throw new IllegalStateException(("Expected " + Integer.class + " for key: " + key2 + ", found " + valueAt.getClass() + " instead.").toString());
            }
        }

        public int getKey() {
            return this.key;
        }

        public MapBuffer getMapBufferValue() {
            boolean z2;
            int key2 = getKey();
            Object valueAt = this.this$0.values.valueAt(this.index);
            if (valueAt != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(key2)).toString());
            } else if (valueAt instanceof MapBuffer) {
                return (MapBuffer) valueAt;
            } else {
                throw new IllegalStateException(("Expected " + MapBuffer.class + " for key: " + key2 + ", found " + valueAt.getClass() + " instead.").toString());
            }
        }

        public String getStringValue() {
            boolean z2;
            int key2 = getKey();
            Object valueAt = this.this$0.values.valueAt(this.index);
            if (valueAt != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(key2)).toString());
            } else if (valueAt instanceof String) {
                return (String) valueAt;
            } else {
                throw new IllegalStateException(("Expected " + String.class + " for key: " + key2 + ", found " + valueAt.getClass() + " instead.").toString());
            }
        }

        public MapBuffer.DataType getType() {
            return this.type;
        }
    }

    static {
        MapBufferSoLoader.staticInit();
    }

    /* access modifiers changed from: private */
    public final MapBuffer.DataType dataType(Object obj, int i2) {
        if (obj instanceof Boolean) {
            return MapBuffer.DataType.BOOL;
        }
        if (obj instanceof Integer) {
            return MapBuffer.DataType.INT;
        }
        if (obj instanceof Double) {
            return MapBuffer.DataType.DOUBLE;
        }
        if (obj instanceof String) {
            return MapBuffer.DataType.STRING;
        }
        if (obj instanceof MapBuffer) {
            return MapBuffer.DataType.MAP;
        }
        throw new IllegalStateException("Key " + i2 + " has value of unknown type: " + obj.getClass());
    }

    @DoNotStrip
    private final int[] getKeys() {
        int size = this.values.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = this.values.keyAt(i2);
        }
        return iArr;
    }

    @DoNotStrip
    private final Object[] getValues() {
        int size = this.values.size();
        Object[] objArr = new Object[size];
        for (int i2 = 0; i2 < size; i2++) {
            Object valueAt = this.values.valueAt(i2);
            Intrinsics.e(valueAt, "values.valueAt(it)");
            objArr[i2] = valueAt;
        }
        return objArr;
    }

    private final WritableMapBuffer putInternal(int i2, Object obj) {
        IntRange kEY_RANGE$ReactAndroid_release = MapBuffer.Companion.getKEY_RANGE$ReactAndroid_release();
        int a2 = kEY_RANGE$ReactAndroid_release.a();
        boolean z2 = false;
        if (i2 <= kEY_RANGE$ReactAndroid_release.b() && a2 <= i2) {
            z2 = true;
        }
        if (z2) {
            this.values.put(i2, obj);
            return this;
        }
        throw new IllegalArgumentException("Only integers in [0;65535] range are allowed for keys.".toString());
    }

    private final /* synthetic */ <T> T verifyValue(int i2, Object obj) {
        boolean z2;
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            Intrinsics.l(3, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
            if (obj instanceof Object) {
                return obj;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected ");
            Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
            sb.append(Object.class);
            sb.append(" for key: ");
            sb.append(i2);
            sb.append(", found ");
            sb.append(obj.getClass());
            sb.append(" instead.");
            throw new IllegalStateException(sb.toString().toString());
        }
        throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(i2)).toString());
    }

    public boolean contains(int i2) {
        return this.values.get(i2) != null;
    }

    public MapBuffer.Entry entryAt(int i2) {
        return new MapBufferEntry(this, i2);
    }

    public boolean getBoolean(int i2) {
        boolean z2;
        Object obj = this.values.get(i2);
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(i2)).toString());
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        } else {
            throw new IllegalStateException(("Expected " + Boolean.class + " for key: " + i2 + ", found " + obj.getClass() + " instead.").toString());
        }
    }

    public int getCount() {
        return this.values.size();
    }

    public double getDouble(int i2) {
        boolean z2;
        Object obj = this.values.get(i2);
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(i2)).toString());
        } else if (obj instanceof Double) {
            return ((Number) obj).doubleValue();
        } else {
            throw new IllegalStateException(("Expected " + Double.class + " for key: " + i2 + ", found " + obj.getClass() + " instead.").toString());
        }
    }

    public int getInt(int i2) {
        boolean z2;
        Object obj = this.values.get(i2);
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(i2)).toString());
        } else if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        } else {
            throw new IllegalStateException(("Expected " + Integer.class + " for key: " + i2 + ", found " + obj.getClass() + " instead.").toString());
        }
    }

    public int getKeyOffset(int i2) {
        return this.values.indexOfKey(i2);
    }

    public MapBuffer getMapBuffer(int i2) {
        boolean z2;
        Object obj = this.values.get(i2);
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(i2)).toString());
        } else if (obj instanceof MapBuffer) {
            return (MapBuffer) obj;
        } else {
            throw new IllegalStateException(("Expected " + MapBuffer.class + " for key: " + i2 + ", found " + obj.getClass() + " instead.").toString());
        }
    }

    public String getString(int i2) {
        boolean z2;
        Object obj = this.values.get(i2);
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(i2)).toString());
        } else if (obj instanceof String) {
            return (String) obj;
        } else {
            throw new IllegalStateException(("Expected " + String.class + " for key: " + i2 + ", found " + obj.getClass() + " instead.").toString());
        }
    }

    public MapBuffer.DataType getType(int i2) {
        boolean z2;
        Object obj = this.values.get(i2);
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            Intrinsics.e(obj, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            return dataType(obj, i2);
        }
        throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(i2)).toString());
    }

    public Iterator<MapBuffer.Entry> iterator() {
        return new WritableMapBuffer$iterator$1(this);
    }

    public final WritableMapBuffer put(int i2, boolean z2) {
        return putInternal(i2, Boolean.valueOf(z2));
    }

    public final WritableMapBuffer put(int i2, int i3) {
        return putInternal(i2, Integer.valueOf(i3));
    }

    public final WritableMapBuffer put(int i2, double d2) {
        return putInternal(i2, Double.valueOf(d2));
    }

    public final WritableMapBuffer put(int i2, String str) {
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        return putInternal(i2, str);
    }

    public final WritableMapBuffer put(int i2, MapBuffer mapBuffer) {
        Intrinsics.f(mapBuffer, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        return putInternal(i2, mapBuffer);
    }
}
