package com.facebook.react.common.mapbuffer;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.common.mapbuffer.MapBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;

@DoNotStrip
public final class ReadableMapBuffer implements MapBuffer {
    private static final int ALIGNMENT = 254;
    private static final int BUCKET_SIZE = 12;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int HEADER_SIZE = 8;
    private static final int TYPE_OFFSET = 2;
    private static final int VALUE_OFFSET = 4;
    private final ByteBuffer buffer;
    private int count;
    @DoNotStrip
    private final HybridData mHybridData;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final class MapBufferEntry implements MapBuffer.Entry {
        private final int bucketOffset;
        final /* synthetic */ ReadableMapBuffer this$0;

        public MapBufferEntry(ReadableMapBuffer readableMapBuffer, int i2) {
            Intrinsics.f(readableMapBuffer, "this$0");
            this.this$0 = readableMapBuffer;
            this.bucketOffset = i2;
        }

        private final void assertType(MapBuffer.DataType dataType) {
            boolean z2;
            MapBuffer.DataType type = getType();
            if (dataType == type) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalStateException(("Expected " + dataType + " for key: " + getKey() + " found " + type + " instead.").toString());
            }
        }

        public boolean getBooleanValue() {
            assertType(MapBuffer.DataType.BOOL);
            return this.this$0.readBooleanValue(this.bucketOffset + 4);
        }

        public double getDoubleValue() {
            assertType(MapBuffer.DataType.DOUBLE);
            return this.this$0.readDoubleValue(this.bucketOffset + 4);
        }

        public int getIntValue() {
            assertType(MapBuffer.DataType.INT);
            return this.this$0.readIntValue(this.bucketOffset + 4);
        }

        public int getKey() {
            return this.this$0.m107readUnsignedShortBwKQO78(this.bucketOffset) & 65535;
        }

        public MapBuffer getMapBufferValue() {
            assertType(MapBuffer.DataType.MAP);
            return this.this$0.readMapBufferValue(this.bucketOffset + 4);
        }

        public String getStringValue() {
            assertType(MapBuffer.DataType.STRING);
            return this.this$0.readStringValue(this.bucketOffset + 4);
        }

        public MapBuffer.DataType getType() {
            return MapBuffer.DataType.values()[this.this$0.m107readUnsignedShortBwKQO78(this.bucketOffset + 2) & 65535];
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MapBuffer.DataType.values().length];
            iArr[MapBuffer.DataType.BOOL.ordinal()] = 1;
            iArr[MapBuffer.DataType.INT.ordinal()] = 2;
            iArr[MapBuffer.DataType.DOUBLE.ordinal()] = 3;
            iArr[MapBuffer.DataType.STRING.ordinal()] = 4;
            iArr[MapBuffer.DataType.MAP.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        MapBufferSoLoader.staticInit();
    }

    @DoNotStrip
    private ReadableMapBuffer(HybridData hybridData) {
        this.mHybridData = hybridData;
        this.buffer = importByteBuffer();
        readHeader();
    }

    private final int getBucketIndexForKey(int i2) {
        boolean z2;
        IntRange kEY_RANGE$ReactAndroid_release = MapBuffer.Companion.getKEY_RANGE$ReactAndroid_release();
        int a2 = kEY_RANGE$ReactAndroid_release.a();
        int i3 = 0;
        if (i2 > kEY_RANGE$ReactAndroid_release.b() || a2 > i2) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            return -1;
        }
        short b2 = UShort.b((short) i2);
        int count2 = getCount() - 1;
        while (i3 <= count2) {
            int i4 = (i3 + count2) >>> 1;
            short r5 = m107readUnsignedShortBwKQO78(getKeyOffsetForBucketIndex(i4)) & 65535;
            short s2 = 65535 & b2;
            if (Intrinsics.h(r5, s2) < 0) {
                i3 = i4 + 1;
            } else if (Intrinsics.h(r5, s2) <= 0) {
                return i4;
            } else {
                count2 = i4 - 1;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final int getKeyOffsetForBucketIndex(int i2) {
        return (i2 * 12) + 8;
    }

    private final int getOffsetForDynamicData() {
        return getKeyOffsetForBucketIndex(getCount());
    }

    private final int getTypedValueOffsetForKey(int i2, MapBuffer.DataType dataType) {
        boolean z2;
        int bucketIndexForKey = getBucketIndexForKey(i2);
        boolean z3 = true;
        if (bucketIndexForKey != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            MapBuffer.DataType readDataType = readDataType(bucketIndexForKey);
            if (readDataType != dataType) {
                z3 = false;
            }
            if (z3) {
                return getKeyOffsetForBucketIndex(bucketIndexForKey) + 4;
            }
            throw new IllegalStateException(("Expected " + dataType + " for key: " + i2 + ", found " + readDataType + " instead.").toString());
        }
        throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(i2)).toString());
    }

    private final native ByteBuffer importByteBuffer();

    /* access modifiers changed from: private */
    public final boolean readBooleanValue(int i2) {
        return readIntValue(i2) == 1;
    }

    private final MapBuffer.DataType readDataType(int i2) {
        return MapBuffer.DataType.values()[m107readUnsignedShortBwKQO78(getKeyOffsetForBucketIndex(i2) + 2) & 65535];
    }

    /* access modifiers changed from: private */
    public final double readDoubleValue(int i2) {
        return this.buffer.getDouble(i2);
    }

    private final void readHeader() {
        if (this.buffer.getShort() != ALIGNMENT) {
            this.buffer.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.count = m107readUnsignedShortBwKQO78(this.buffer.position()) & 65535;
    }

    /* access modifiers changed from: private */
    public final int readIntValue(int i2) {
        return this.buffer.getInt(i2);
    }

    /* access modifiers changed from: private */
    public final ReadableMapBuffer readMapBufferValue(int i2) {
        int offsetForDynamicData = getOffsetForDynamicData() + this.buffer.getInt(i2);
        int i3 = this.buffer.getInt(offsetForDynamicData);
        byte[] bArr = new byte[i3];
        this.buffer.position(offsetForDynamicData + 4);
        this.buffer.get(bArr, 0, i3);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.e(wrap, "wrap(newBuffer)");
        return new ReadableMapBuffer(wrap);
    }

    /* access modifiers changed from: private */
    public final String readStringValue(int i2) {
        int offsetForDynamicData = getOffsetForDynamicData() + this.buffer.getInt(i2);
        int i3 = this.buffer.getInt(offsetForDynamicData);
        byte[] bArr = new byte[i3];
        this.buffer.position(offsetForDynamicData + 4);
        this.buffer.get(bArr, 0, i3);
        return new String(bArr, Charsets.f40513b);
    }

    /* access modifiers changed from: private */
    /* renamed from: readUnsignedShort-BwKQO78  reason: not valid java name */
    public final short m107readUnsignedShortBwKQO78(int i2) {
        return UShort.b(this.buffer.getShort(i2));
    }

    public boolean contains(int i2) {
        return getBucketIndexForKey(i2) != -1;
    }

    public MapBuffer.Entry entryAt(int i2) {
        return new MapBufferEntry(this, getKeyOffsetForBucketIndex(i2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ReadableMapBuffer)) {
            return false;
        }
        ByteBuffer byteBuffer = this.buffer;
        ByteBuffer byteBuffer2 = ((ReadableMapBuffer) obj).buffer;
        if (byteBuffer == byteBuffer2) {
            return true;
        }
        byteBuffer.rewind();
        byteBuffer2.rewind();
        return Intrinsics.a(byteBuffer, byteBuffer2);
    }

    public boolean getBoolean(int i2) {
        return readBooleanValue(getTypedValueOffsetForKey(i2, MapBuffer.DataType.BOOL));
    }

    public int getCount() {
        return this.count;
    }

    public double getDouble(int i2) {
        return readDoubleValue(getTypedValueOffsetForKey(i2, MapBuffer.DataType.DOUBLE));
    }

    public int getInt(int i2) {
        return readIntValue(getTypedValueOffsetForKey(i2, MapBuffer.DataType.INT));
    }

    public int getKeyOffset(int i2) {
        return getBucketIndexForKey(i2);
    }

    public String getString(int i2) {
        return readStringValue(getTypedValueOffsetForKey(i2, MapBuffer.DataType.STRING));
    }

    public MapBuffer.DataType getType(int i2) {
        boolean z2;
        int bucketIndexForKey = getBucketIndexForKey(i2);
        if (bucketIndexForKey != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return readDataType(bucketIndexForKey);
        }
        throw new IllegalArgumentException(Intrinsics.o("Key not found: ", Integer.valueOf(i2)).toString());
    }

    public int hashCode() {
        this.buffer.rewind();
        return this.buffer.hashCode();
    }

    public Iterator<MapBuffer.Entry> iterator() {
        return new ReadableMapBuffer$iterator$1(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Iterator<MapBuffer.Entry> it2 = iterator();
        while (it2.hasNext()) {
            MapBuffer.Entry next = it2.next();
            sb.append(next.getKey());
            sb.append('=');
            int i2 = WhenMappings.$EnumSwitchMapping$0[next.getType().ordinal()];
            if (i2 == 1) {
                sb.append(next.getBooleanValue());
            } else if (i2 == 2) {
                sb.append(next.getIntValue());
            } else if (i2 == 3) {
                sb.append(next.getDoubleValue());
            } else if (i2 == 4) {
                sb.append(next.getStringValue());
            } else if (i2 == 5) {
                sb.append(next.getMapBufferValue().toString());
            }
            sb.append(',');
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "builder.toString()");
        return sb2;
    }

    public ReadableMapBuffer getMapBuffer(int i2) {
        return readMapBufferValue(getTypedValueOffsetForKey(i2, MapBuffer.DataType.MAP));
    }

    private ReadableMapBuffer(ByteBuffer byteBuffer) {
        this.mHybridData = null;
        this.buffer = byteBuffer;
        readHeader();
    }
}
