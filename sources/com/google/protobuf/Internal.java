package com.google.protobuf;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

public final class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;
    static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset US_ASCII = Charset.forName("US-ASCII");
    static final Charset UTF_8 = Charset.forName("UTF-8");

    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean z2);

        boolean getBoolean(int i2);

        /* synthetic */ boolean isModifiable();

        /* synthetic */ void makeImmutable();

        BooleanList mutableCopyWithCapacity(int i2);

        /* synthetic */ ProtobufList mutableCopyWithCapacity(int i2);

        boolean setBoolean(int i2, boolean z2);
    }

    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double d2);

        double getDouble(int i2);

        /* synthetic */ boolean isModifiable();

        /* synthetic */ void makeImmutable();

        DoubleList mutableCopyWithCapacity(int i2);

        /* synthetic */ ProtobufList mutableCopyWithCapacity(int i2);

        double setDouble(int i2, double d2);
    }

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i2);
    }

    public interface EnumVerifier {
        boolean isInRange(int i2);
    }

    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float f2);

        float getFloat(int i2);

        /* synthetic */ boolean isModifiable();

        /* synthetic */ void makeImmutable();

        FloatList mutableCopyWithCapacity(int i2);

        /* synthetic */ ProtobufList mutableCopyWithCapacity(int i2);

        float setFloat(int i2, float f2);
    }

    public interface IntList extends ProtobufList<Integer> {
        void addInt(int i2);

        int getInt(int i2);

        /* synthetic */ boolean isModifiable();

        /* synthetic */ void makeImmutable();

        IntList mutableCopyWithCapacity(int i2);

        /* synthetic */ ProtobufList mutableCopyWithCapacity(int i2);

        int setInt(int i2, int i3);
    }

    public interface LongList extends ProtobufList<Long> {
        void addLong(long j2);

        long getLong(int i2);

        /* synthetic */ boolean isModifiable();

        /* synthetic */ void makeImmutable();

        LongList mutableCopyWithCapacity(int i2);

        /* synthetic */ ProtobufList mutableCopyWithCapacity(int i2);

        long setLong(int i2, long j2);
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int i2);
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(bArr);
    }

    private Internal() {
    }

    public static byte[] byteArrayDefaultValue(String str) {
        return str.getBytes(ISO_8859_1);
    }

    public static ByteBuffer byteBufferDefaultValue(String str) {
        return ByteBuffer.wrap(byteArrayDefaultValue(str));
    }

    public static ByteString bytesDefaultValue(String str) {
        return ByteString.copyFrom(str.getBytes(ISO_8859_1));
    }

    static <T> T checkNotNull(T t2) {
        t2.getClass();
        return t2;
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        ByteBuffer allocate = ByteBuffer.allocate(duplicate.capacity());
        allocate.put(duplicate);
        allocate.clear();
        return allocate;
    }

    public static boolean equals(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() != byteBuffer2.capacity()) {
            return false;
        }
        return ((ByteBuffer) byteBuffer.duplicate().clear()).equals((ByteBuffer) byteBuffer2.duplicate().clear());
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> cls) {
        try {
            Method method = cls.getMethod("getDefaultInstance", new Class[0]);
            return (MessageLite) method.invoke(method, new Object[0]);
        } catch (Exception e2) {
            throw new RuntimeException("Failed to get default instance for " + cls, e2);
        }
    }

    public static int hashBoolean(boolean z2) {
        return z2 ? 1231 : 1237;
    }

    public static int hashCode(List<byte[]> list) {
        int i2 = 1;
        for (byte[] hashCode : list) {
            i2 = (i2 * 31) + hashCode(hashCode);
        }
        return i2;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        int i2 = 1;
        for (ByteBuffer hashCodeByteBuffer : list) {
            i2 = (i2 * 31) + hashCodeByteBuffer(hashCodeByteBuffer);
        }
        return i2;
    }

    public static int hashEnum(EnumLite enumLite) {
        return enumLite.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> list) {
        int i2 = 1;
        for (EnumLite hashEnum : list) {
            i2 = (i2 * 31) + hashEnum(hashEnum);
        }
        return i2;
    }

    public static int hashLong(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    static Object mergeMessage(Object obj, Object obj2) {
        return ((MessageLite) obj).toBuilder().mergeFrom((MessageLite) obj2).buildPartial();
    }

    static int partialHash(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    public static String stringDefaultValue(String str) {
        return new String(str.getBytes(ISO_8859_1), UTF_8);
    }

    public static byte[] toByteArray(String str) {
        return str.getBytes(UTF_8);
    }

    public static String toStringUtf8(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    static <T> T checkNotNull(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.isValidUtf8(bArr);
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> list, List<ByteBuffer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!equalsByteBuffer(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCode(byte[] bArr) {
        return hashCode(bArr, 0, bArr.length);
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int partialHash = partialHash(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (partialHash == 0) {
                return 1;
            }
            return partialHash;
        }
        int i2 = 4096;
        if (byteBuffer.capacity() <= 4096) {
            i2 = byteBuffer.capacity();
        }
        byte[] bArr = new byte[i2];
        ByteBuffer duplicate = byteBuffer.duplicate();
        ByteBuffer byteBuffer2 = (ByteBuffer) duplicate.clear();
        int capacity = byteBuffer.capacity();
        while (duplicate.remaining() > 0) {
            int remaining = duplicate.remaining() <= i2 ? duplicate.remaining() : i2;
            duplicate.get(bArr, 0, remaining);
            capacity = partialHash(capacity, bArr, 0, remaining);
        }
        if (capacity == 0) {
            return 1;
        }
        return capacity;
    }

    static int hashCode(byte[] bArr, int i2, int i3) {
        int partialHash = partialHash(i3, bArr, i2, i3);
        if (partialHash == 0) {
            return 1;
        }
        return partialHash;
    }
}
