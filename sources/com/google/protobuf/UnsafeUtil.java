package com.google.protobuf;

import com.facebook.imageutils.JfifUtil;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class UnsafeUtil {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE;
    private static final long BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
    private static final int BYTE_ARRAY_ALIGNMENT;
    static final long BYTE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_INDEX_SCALE;
    private static final long FLOAT_ARRAY_BASE_OFFSET;
    private static final long FLOAT_ARRAY_INDEX_SCALE;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    private static final boolean IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
    private static final boolean IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
    static final boolean IS_BIG_ENDIAN;
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final MemoryAccessor MEMORY_ACCESSOR = getMemoryAccessor();
    private static final Class<?> MEMORY_CLASS = Android.getMemoryClass();
    private static final long OBJECT_ARRAY_BASE_OFFSET;
    private static final long OBJECT_ARRAY_INDEX_SCALE;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Unsafe UNSAFE = getUnsafe();

    private static final class Android32MemoryAccessor extends MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        private static int smallAddress(long j2) {
            return (int) (j2 & -1);
        }

        public void copyMemory(long j2, byte[] bArr, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(Object obj, long j2) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getBooleanBigEndian(obj, j2);
            }
            return UnsafeUtil.getBooleanLittleEndian(obj, j2);
        }

        public byte getByte(Object obj, long j2) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(obj, j2);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j2);
        }

        public double getDouble(Object obj, long j2) {
            return Double.longBitsToDouble(getLong(obj, j2));
        }

        public float getFloat(Object obj, long j2) {
            return Float.intBitsToFloat(getInt(obj, j2));
        }

        public int getInt(long j2) {
            throw new UnsupportedOperationException();
        }

        public long getLong(long j2) {
            throw new UnsupportedOperationException();
        }

        public Object getStaticObject(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void putBoolean(Object obj, long j2, boolean z2) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j2, z2);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j2, z2);
            }
        }

        public void putByte(Object obj, long j2, byte b2) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j2, b2);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j2, b2);
            }
        }

        public void putDouble(Object obj, long j2, double d2) {
            putLong(obj, j2, Double.doubleToLongBits(d2));
        }

        public void putFloat(Object obj, long j2, float f2) {
            putInt(obj, j2, Float.floatToIntBits(f2));
        }

        public void putInt(long j2, int i2) {
            throw new UnsupportedOperationException();
        }

        public void putLong(long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        public void copyMemory(byte[] bArr, long j2, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(long j2) {
            throw new UnsupportedOperationException();
        }

        public void putByte(long j2, byte b2) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class Android64MemoryAccessor extends MemoryAccessor {
        Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void copyMemory(long j2, byte[] bArr, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(Object obj, long j2) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getBooleanBigEndian(obj, j2);
            }
            return UnsafeUtil.getBooleanLittleEndian(obj, j2);
        }

        public byte getByte(Object obj, long j2) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(obj, j2);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j2);
        }

        public double getDouble(Object obj, long j2) {
            return Double.longBitsToDouble(getLong(obj, j2));
        }

        public float getFloat(Object obj, long j2) {
            return Float.intBitsToFloat(getInt(obj, j2));
        }

        public int getInt(long j2) {
            throw new UnsupportedOperationException();
        }

        public long getLong(long j2) {
            throw new UnsupportedOperationException();
        }

        public Object getStaticObject(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void putBoolean(Object obj, long j2, boolean z2) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j2, z2);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j2, z2);
            }
        }

        public void putByte(Object obj, long j2, byte b2) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j2, b2);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j2, b2);
            }
        }

        public void putDouble(Object obj, long j2, double d2) {
            putLong(obj, j2, Double.doubleToLongBits(d2));
        }

        public void putFloat(Object obj, long j2, float f2) {
            putInt(obj, j2, Float.floatToIntBits(f2));
        }

        public void putInt(long j2, int i2) {
            throw new UnsupportedOperationException();
        }

        public void putLong(long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        public void copyMemory(byte[] bArr, long j2, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(long j2) {
            throw new UnsupportedOperationException();
        }

        public void putByte(long j2, byte b2) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void copyMemory(long j2, byte[] bArr, long j3, long j4) {
            this.unsafe.copyMemory((Object) null, j2, bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j3, j4);
        }

        public boolean getBoolean(Object obj, long j2) {
            return this.unsafe.getBoolean(obj, j2);
        }

        public byte getByte(Object obj, long j2) {
            return this.unsafe.getByte(obj, j2);
        }

        public double getDouble(Object obj, long j2) {
            return this.unsafe.getDouble(obj, j2);
        }

        public float getFloat(Object obj, long j2) {
            return this.unsafe.getFloat(obj, j2);
        }

        public int getInt(long j2) {
            return this.unsafe.getInt(j2);
        }

        public long getLong(long j2) {
            return this.unsafe.getLong(j2);
        }

        public Object getStaticObject(Field field) {
            return getObject(this.unsafe.staticFieldBase(field), this.unsafe.staticFieldOffset(field));
        }

        public void putBoolean(Object obj, long j2, boolean z2) {
            this.unsafe.putBoolean(obj, j2, z2);
        }

        public void putByte(Object obj, long j2, byte b2) {
            this.unsafe.putByte(obj, j2, b2);
        }

        public void putDouble(Object obj, long j2, double d2) {
            this.unsafe.putDouble(obj, j2, d2);
        }

        public void putFloat(Object obj, long j2, float f2) {
            this.unsafe.putFloat(obj, j2, f2);
        }

        public void putInt(long j2, int i2) {
            this.unsafe.putInt(j2, i2);
        }

        public void putLong(long j2, long j3) {
            this.unsafe.putLong(j2, j3);
        }

        public boolean supportsUnsafeArrayOperations() {
            Class<Object> cls = Object.class;
            if (!super.supportsUnsafeArrayOperations()) {
                return false;
            }
            try {
                Class<?> cls2 = this.unsafe.getClass();
                Class cls3 = Long.TYPE;
                cls2.getMethod("getByte", new Class[]{cls, cls3});
                cls2.getMethod("putByte", new Class[]{cls, cls3, Byte.TYPE});
                cls2.getMethod("getBoolean", new Class[]{cls, cls3});
                cls2.getMethod("putBoolean", new Class[]{cls, cls3, Boolean.TYPE});
                cls2.getMethod("getFloat", new Class[]{cls, cls3});
                cls2.getMethod("putFloat", new Class[]{cls, cls3, Float.TYPE});
                cls2.getMethod("getDouble", new Class[]{cls, cls3});
                cls2.getMethod("putDouble", new Class[]{cls, cls3, Double.TYPE});
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Class<Object> cls = Object.class;
            if (!super.supportsUnsafeByteBufferOperations()) {
                return false;
            }
            try {
                Class<?> cls2 = this.unsafe.getClass();
                Class cls3 = Long.TYPE;
                cls2.getMethod("getByte", new Class[]{cls3});
                cls2.getMethod("putByte", new Class[]{cls3, Byte.TYPE});
                cls2.getMethod("getInt", new Class[]{cls3});
                cls2.getMethod("putInt", new Class[]{cls3, Integer.TYPE});
                cls2.getMethod("getLong", new Class[]{cls3});
                cls2.getMethod("putLong", new Class[]{cls3, cls3});
                cls2.getMethod("copyMemory", new Class[]{cls3, cls3, cls3});
                cls2.getMethod("copyMemory", new Class[]{cls, cls3, cls, cls3, cls3});
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }

        public void copyMemory(byte[] bArr, long j2, long j3, long j4) {
            this.unsafe.copyMemory(bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j2, (Object) null, j3, j4);
        }

        public byte getByte(long j2) {
            return this.unsafe.getByte(j2);
        }

        public void putByte(long j2, byte b2) {
            this.unsafe.putByte(j2, b2);
        }
    }

    private static abstract class MemoryAccessor {
        Unsafe unsafe;

        MemoryAccessor(Unsafe unsafe2) {
            this.unsafe = unsafe2;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.unsafe.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.unsafe.arrayIndexScale(cls);
        }

        public abstract void copyMemory(long j2, byte[] bArr, long j3, long j4);

        public abstract void copyMemory(byte[] bArr, long j2, long j3, long j4);

        public abstract boolean getBoolean(Object obj, long j2);

        public abstract byte getByte(long j2);

        public abstract byte getByte(Object obj, long j2);

        public abstract double getDouble(Object obj, long j2);

        public abstract float getFloat(Object obj, long j2);

        public abstract int getInt(long j2);

        public final int getInt(Object obj, long j2) {
            return this.unsafe.getInt(obj, j2);
        }

        public abstract long getLong(long j2);

        public final long getLong(Object obj, long j2) {
            return this.unsafe.getLong(obj, j2);
        }

        public final Object getObject(Object obj, long j2) {
            return this.unsafe.getObject(obj, j2);
        }

        public abstract Object getStaticObject(Field field);

        public final long objectFieldOffset(Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j2, boolean z2);

        public abstract void putByte(long j2, byte b2);

        public abstract void putByte(Object obj, long j2, byte b2);

        public abstract void putDouble(Object obj, long j2, double d2);

        public abstract void putFloat(Object obj, long j2, float f2);

        public abstract void putInt(long j2, int i2);

        public final void putInt(Object obj, long j2, int i2) {
            this.unsafe.putInt(obj, j2, i2);
        }

        public abstract void putLong(long j2, long j3);

        public final void putLong(Object obj, long j2, long j3) {
            this.unsafe.putLong(obj, j2, j3);
        }

        public final void putObject(Object obj, long j2, Object obj2) {
            this.unsafe.putObject(obj, j2, obj2);
        }

        public boolean supportsUnsafeArrayOperations() {
            Class<Class> cls = Class.class;
            Class<Object> cls2 = Object.class;
            Unsafe unsafe2 = this.unsafe;
            if (unsafe2 == null) {
                return false;
            }
            try {
                Class<?> cls3 = unsafe2.getClass();
                cls3.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls3.getMethod("arrayBaseOffset", new Class[]{cls});
                cls3.getMethod("arrayIndexScale", new Class[]{cls});
                Class cls4 = Long.TYPE;
                cls3.getMethod("getInt", new Class[]{cls2, cls4});
                cls3.getMethod("putInt", new Class[]{cls2, cls4, Integer.TYPE});
                cls3.getMethod("getLong", new Class[]{cls2, cls4});
                cls3.getMethod("putLong", new Class[]{cls2, cls4, cls4});
                cls3.getMethod("getObject", new Class[]{cls2, cls4});
                cls3.getMethod("putObject", new Class[]{cls2, cls4, cls2});
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Unsafe unsafe2 = this.unsafe;
            if (unsafe2 == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe2.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                if (UnsafeUtil.bufferAddressField() == null) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }
    }

    static {
        boolean z2;
        long arrayBaseOffset = (long) arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
        Class<boolean[]> cls = boolean[].class;
        BOOLEAN_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls);
        BOOLEAN_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls);
        Class<int[]> cls2 = int[].class;
        INT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls2);
        INT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls2);
        Class<long[]> cls3 = long[].class;
        LONG_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls3);
        LONG_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls3);
        Class<float[]> cls4 = float[].class;
        FLOAT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls4);
        FLOAT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls4);
        Class<double[]> cls5 = double[].class;
        DOUBLE_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls5);
        DOUBLE_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls5);
        Class<Object[]> cls6 = Object[].class;
        OBJECT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls6);
        OBJECT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls6);
        BYTE_ARRAY_ALIGNMENT = (int) (arrayBaseOffset & 7);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z2 = true;
        } else {
            z2 = false;
        }
        IS_BIG_ENDIAN = z2;
    }

    private UnsafeUtil() {
    }

    static long addressOffset(ByteBuffer byteBuffer) {
        return MEMORY_ACCESSOR.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    static <T> T allocateInstance(Class<T> cls) {
        try {
            return UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int arrayBaseOffset(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int arrayIndexScale(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static Field bufferAddressField() {
        Field field;
        Class<Buffer> cls = Buffer.class;
        if (Android.isOnAndroidDevice() && (field = field(cls, "effectiveDirectAddress")) != null) {
            return field;
        }
        Field field2 = field(cls, "address");
        if (field2 == null || field2.getType() != Long.TYPE) {
            return null;
        }
        return field2;
    }

    static void copyMemory(byte[] bArr, long j2, long j3, long j4) {
        MEMORY_ACCESSOR.copyMemory(bArr, j2, j3, j4);
    }

    static boolean determineAndroidSupportByAddressSize(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!Android.isOnAndroidDevice()) {
            return false;
        }
        try {
            Class<?> cls3 = MEMORY_CLASS;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field field(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long fieldOffset(Field field) {
        MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = MEMORY_ACCESSOR) == null) {
            return -1;
        }
        return memoryAccessor.objectFieldOffset(field);
    }

    private static int firstDifferingByteIndexNativeEndian(long j2, long j3) {
        int i2;
        if (IS_BIG_ENDIAN) {
            i2 = Long.numberOfLeadingZeros(j2 ^ j3);
        } else {
            i2 = Long.numberOfTrailingZeros(j2 ^ j3);
        }
        return i2 >> 3;
    }

    static boolean getBoolean(Object obj, long j2) {
        return MEMORY_ACCESSOR.getBoolean(obj, j2);
    }

    /* access modifiers changed from: private */
    public static boolean getBooleanBigEndian(Object obj, long j2) {
        return getByteBigEndian(obj, j2) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean getBooleanLittleEndian(Object obj, long j2) {
        return getByteLittleEndian(obj, j2) != 0;
    }

    static byte getByte(Object obj, long j2) {
        return MEMORY_ACCESSOR.getByte(obj, j2);
    }

    /* access modifiers changed from: private */
    public static byte getByteBigEndian(Object obj, long j2) {
        return (byte) ((getInt(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3))) & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* access modifiers changed from: private */
    public static byte getByteLittleEndian(Object obj, long j2) {
        return (byte) ((getInt(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3))) & JfifUtil.MARKER_FIRST_BYTE);
    }

    static double getDouble(Object obj, long j2) {
        return MEMORY_ACCESSOR.getDouble(obj, j2);
    }

    static float getFloat(Object obj, long j2) {
        return MEMORY_ACCESSOR.getFloat(obj, j2);
    }

    static int getInt(Object obj, long j2) {
        return MEMORY_ACCESSOR.getInt(obj, j2);
    }

    static long getLong(Object obj, long j2) {
        return MEMORY_ACCESSOR.getLong(obj, j2);
    }

    private static MemoryAccessor getMemoryAccessor() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return null;
        }
        if (!Android.isOnAndroidDevice()) {
            return new JvmMemoryAccessor(unsafe);
        }
        if (IS_ANDROID_64) {
            return new Android64MemoryAccessor(unsafe);
        }
        if (IS_ANDROID_32) {
            return new Android32MemoryAccessor(unsafe);
        }
        return null;
    }

    static Object getObject(Object obj, long j2) {
        return MEMORY_ACCESSOR.getObject(obj, j2);
    }

    static Object getStaticObject(Field field) {
        return MEMORY_ACCESSOR.getStaticObject(field);
    }

    static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe run() throws Exception {
                    Class<Unsafe> cls = Unsafe.class;
                    for (Field field : cls.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get((Object) null);
                        if (cls.isInstance(obj)) {
                            return cls.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    static boolean isAndroid64() {
        return IS_ANDROID_64;
    }

    /* access modifiers changed from: private */
    public static void logMissingMethod(Throwable th) {
        Logger logger = Logger.getLogger(UnsafeUtil.class.getName());
        Level level = Level.WARNING;
        logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    static int mismatch(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        if (i2 < 0 || i3 < 0 || i4 < 0 || i2 + i4 > bArr.length || i3 + i4 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i5 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            int i6 = (BYTE_ARRAY_ALIGNMENT + i2) & 7;
            while (i5 < i4 && (i6 & 7) != 0) {
                if (bArr[i2 + i5] != bArr2[i3 + i5]) {
                    return i5;
                }
                i5++;
                i6++;
            }
            int i7 = ((i4 - i5) & -8) + i5;
            while (i5 < i7) {
                long j2 = BYTE_ARRAY_BASE_OFFSET;
                long j3 = (long) i5;
                long j4 = getLong((Object) bArr, ((long) i2) + j2 + j3);
                long j5 = getLong((Object) bArr2, j2 + ((long) i3) + j3);
                if (j4 != j5) {
                    return i5 + firstDifferingByteIndexNativeEndian(j4, j5);
                }
                i5 += 8;
            }
        }
        while (i5 < i4) {
            if (bArr[i2 + i5] != bArr2[i3 + i5]) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    static long objectFieldOffset(Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    static void putBoolean(Object obj, long j2, boolean z2) {
        MEMORY_ACCESSOR.putBoolean(obj, j2, z2);
    }

    /* access modifiers changed from: private */
    public static void putBooleanBigEndian(Object obj, long j2, boolean z2) {
        putByteBigEndian(obj, j2, z2 ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void putBooleanLittleEndian(Object obj, long j2, boolean z2) {
        putByteLittleEndian(obj, j2, z2 ? (byte) 1 : 0);
    }

    static void putByte(Object obj, long j2, byte b2) {
        MEMORY_ACCESSOR.putByte(obj, j2, b2);
    }

    /* access modifiers changed from: private */
    public static void putByteBigEndian(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = getInt(obj, j3);
        int i3 = ((~((int) j2)) & 3) << 3;
        putInt(obj, j3, ((255 & b2) << i3) | (i2 & (~(JfifUtil.MARKER_FIRST_BYTE << i3))));
    }

    /* access modifiers changed from: private */
    public static void putByteLittleEndian(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        putInt(obj, j3, ((255 & b2) << i2) | (getInt(obj, j3) & (~(JfifUtil.MARKER_FIRST_BYTE << i2))));
    }

    static void putDouble(Object obj, long j2, double d2) {
        MEMORY_ACCESSOR.putDouble(obj, j2, d2);
    }

    static void putFloat(Object obj, long j2, float f2) {
        MEMORY_ACCESSOR.putFloat(obj, j2, f2);
    }

    static void putInt(Object obj, long j2, int i2) {
        MEMORY_ACCESSOR.putInt(obj, j2, i2);
    }

    static void putLong(Object obj, long j2, long j3) {
        MEMORY_ACCESSOR.putLong(obj, j2, j3);
    }

    static void putObject(Object obj, long j2, Object obj2) {
        MEMORY_ACCESSOR.putObject(obj, j2, obj2);
    }

    private static boolean supportsUnsafeArrayOperations() {
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeArrayOperations();
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeByteBufferOperations();
    }

    static void copyMemory(long j2, byte[] bArr, long j3, long j4) {
        MEMORY_ACCESSOR.copyMemory(j2, bArr, j3, j4);
    }

    static boolean getBoolean(boolean[] zArr, long j2) {
        return MEMORY_ACCESSOR.getBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j2 * BOOLEAN_ARRAY_INDEX_SCALE));
    }

    static byte getByte(byte[] bArr, long j2) {
        return MEMORY_ACCESSOR.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + j2);
    }

    static double getDouble(double[] dArr, long j2) {
        return MEMORY_ACCESSOR.getDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j2 * DOUBLE_ARRAY_INDEX_SCALE));
    }

    static float getFloat(float[] fArr, long j2) {
        return MEMORY_ACCESSOR.getFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j2 * FLOAT_ARRAY_INDEX_SCALE));
    }

    static int getInt(int[] iArr, long j2) {
        return MEMORY_ACCESSOR.getInt(iArr, INT_ARRAY_BASE_OFFSET + (j2 * INT_ARRAY_INDEX_SCALE));
    }

    static long getLong(long[] jArr, long j2) {
        return MEMORY_ACCESSOR.getLong(jArr, LONG_ARRAY_BASE_OFFSET + (j2 * LONG_ARRAY_INDEX_SCALE));
    }

    static Object getObject(Object[] objArr, long j2) {
        return MEMORY_ACCESSOR.getObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j2 * OBJECT_ARRAY_INDEX_SCALE));
    }

    static void putBoolean(boolean[] zArr, long j2, boolean z2) {
        MEMORY_ACCESSOR.putBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j2 * BOOLEAN_ARRAY_INDEX_SCALE), z2);
    }

    static void putByte(byte[] bArr, long j2, byte b2) {
        MEMORY_ACCESSOR.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + j2, b2);
    }

    static void putDouble(double[] dArr, long j2, double d2) {
        MEMORY_ACCESSOR.putDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j2 * DOUBLE_ARRAY_INDEX_SCALE), d2);
    }

    static void putFloat(float[] fArr, long j2, float f2) {
        MEMORY_ACCESSOR.putFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j2 * FLOAT_ARRAY_INDEX_SCALE), f2);
    }

    static void putInt(int[] iArr, long j2, int i2) {
        MEMORY_ACCESSOR.putInt(iArr, INT_ARRAY_BASE_OFFSET + (j2 * INT_ARRAY_INDEX_SCALE), i2);
    }

    static void putLong(long[] jArr, long j2, long j3) {
        MEMORY_ACCESSOR.putLong(jArr, LONG_ARRAY_BASE_OFFSET + (j2 * LONG_ARRAY_INDEX_SCALE), j3);
    }

    static void putObject(Object[] objArr, long j2, Object obj) {
        MEMORY_ACCESSOR.putObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j2 * OBJECT_ARRAY_INDEX_SCALE), obj);
    }

    static void copyMemory(byte[] bArr, long j2, byte[] bArr2, long j3, long j4) {
        System.arraycopy(bArr, (int) j2, bArr2, (int) j3, (int) j4);
    }

    static byte getByte(long j2) {
        return MEMORY_ACCESSOR.getByte(j2);
    }

    static int getInt(long j2) {
        return MEMORY_ACCESSOR.getInt(j2);
    }

    static long getLong(long j2) {
        return MEMORY_ACCESSOR.getLong(j2);
    }

    static void putByte(long j2, byte b2) {
        MEMORY_ACCESSOR.putByte(j2, b2);
    }

    static void putInt(long j2, int i2) {
        MEMORY_ACCESSOR.putInt(j2, i2);
    }

    static void putLong(long j2, long j3) {
        MEMORY_ACCESSOR.putLong(j2, j3);
    }
}
