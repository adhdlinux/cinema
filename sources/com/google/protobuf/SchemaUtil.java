package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
    private static final UnknownFieldSchema<?, ?> PROTO2_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(false);
    private static final UnknownFieldSchema<?, ?> PROTO3_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(true);
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();

    private SchemaUtil() {
    }

    static int computeSizeBoolList(int i2, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z2) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
        }
        return size * CodedOutputStream.computeBoolSize(i2, true);
    }

    static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    static int computeSizeByteStringList(int i2, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = size * CodedOutputStream.computeTagSize(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            computeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i3));
        }
        return computeTagSize;
    }

    static int computeSizeEnumList(int i2, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeEnumListNoTag);
        }
        return computeSizeEnumListNoTag + (size * CodedOutputStream.computeTagSize(i2));
    }

    static int computeSizeEnumListNoTag(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeEnumSizeNoTag(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int computeSizeFixed32List(int i2, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z2) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 4);
        }
        return size * CodedOutputStream.computeFixed32Size(i2, 0);
    }

    static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    static int computeSizeFixed64List(int i2, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z2) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 8);
        }
        return size * CodedOutputStream.computeFixed64Size(i2, 0);
    }

    static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    static int computeSizeGroupList(int i2, List<MessageLite> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += CodedOutputStream.computeGroupSize(i2, list.get(i4));
        }
        return i3;
    }

    static int computeSizeInt32List(int i2, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt32ListNoTag);
        }
        return computeSizeInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i2));
    }

    static int computeSizeInt32ListNoTag(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeInt32SizeNoTag(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int computeSizeInt64List(int i2, List<Long> list, boolean z2) {
        if (list.size() == 0) {
            return 0;
        }
        int computeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt64ListNoTag);
        }
        return computeSizeInt64ListNoTag + (list.size() * CodedOutputStream.computeTagSize(i2));
    }

    static int computeSizeInt64ListNoTag(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeInt64SizeNoTag(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int computeSizeMessage(int i2, Object obj, Schema schema) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.computeLazyFieldSize(i2, (LazyFieldLite) obj);
        }
        return CodedOutputStream.computeMessageSize(i2, (MessageLite) obj, schema);
    }

    static int computeSizeMessageList(int i2, List<?> list) {
        int i3;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i2) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            if (obj instanceof LazyFieldLite) {
                i3 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                i3 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            }
            computeTagSize += i3;
        }
        return computeTagSize;
    }

    static int computeSizeSInt32List(int i2, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt32ListNoTag);
        }
        return computeSizeSInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i2));
    }

    static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeSInt32SizeNoTag(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int computeSizeSInt64List(int i2, List<Long> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt64ListNoTag);
        }
        return computeSizeSInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i2));
    }

    static int computeSizeSInt64ListNoTag(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeSInt64SizeNoTag(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int computeSizeStringList(int i2, List<?> list) {
        int i3;
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i2) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i5 < size) {
                Object raw = lazyStringList.getRaw(i5);
                if (raw instanceof ByteString) {
                    i4 = CodedOutputStream.computeBytesSizeNoTag((ByteString) raw);
                } else {
                    i4 = CodedOutputStream.computeStringSizeNoTag((String) raw);
                }
                computeTagSize += i4;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof ByteString) {
                    i3 = CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                } else {
                    i3 = CodedOutputStream.computeStringSizeNoTag((String) obj);
                }
                computeTagSize += i3;
                i5++;
            }
        }
        return computeTagSize;
    }

    static int computeSizeUInt32List(int i2, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt32ListNoTag);
        }
        return computeSizeUInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i2));
    }

    static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeUInt32SizeNoTag(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int computeSizeUInt64List(int i2, List<Long> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt64ListNoTag);
        }
        return computeSizeUInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i2));
    }

    static int computeSizeUInt64ListNoTag(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeUInt64SizeNoTag(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    static <UT, UB> UB filterUnknownEnumList(Object obj, int i2, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (enumLiteMap.findValueByNumber(intValue) != null) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = storeUnknownEnum(obj, i2, intValue, ub, unknownFieldSchema);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = it2.next().intValue();
                if (enumLiteMap.findValueByNumber(intValue2) == null) {
                    ub = storeUnknownEnum(obj, i2, intValue2, ub, unknownFieldSchema);
                    it2.remove();
                }
            }
        }
        return ub;
    }

    private static Class<?> getGeneratedMessageClass() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    static Object getMapDefaultEntry(Class<?> cls, String str) {
        try {
            Field[] declaredFields = Class.forName(cls.getName() + "$" + toCamelCase(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return UnsafeUtil.getStaticObject(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema(boolean z2) {
        try {
            Class<?> unknownFieldSetSchemaClass = getUnknownFieldSetSchemaClass();
            if (unknownFieldSetSchemaClass == null) {
                return null;
            }
            return (UnknownFieldSchema) unknownFieldSetSchemaClass.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z2)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t2, T t3) {
        FieldSet<FT> extensions = extensionSchema.getExtensions(t3);
        if (!extensions.isEmpty()) {
            extensionSchema.getMutableExtensions(t2).mergeFrom(extensions);
        }
    }

    static <T> void mergeMap(MapFieldSchema mapFieldSchema, T t2, T t3, long j2) {
        UnsafeUtil.putObject((Object) t2, j2, mapFieldSchema.mergeFrom(UnsafeUtil.getObject((Object) t2, j2), UnsafeUtil.getObject((Object) t3, j2)));
    }

    static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t2, T t3) {
        unknownFieldSchema.setToMessage(t2, unknownFieldSchema.merge(unknownFieldSchema.getFromMessage(t2), unknownFieldSchema.getFromMessage(t3)));
    }

    public static UnknownFieldSchema<?, ?> proto2UnknownFieldSetSchema() {
        return PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> proto3UnknownFieldSetSchema() {
        return PROTO3_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    static boolean safeEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean shouldUseTableSwitch(int i2, int i3, int i4) {
        if (i3 < 40) {
            return true;
        }
        long j2 = (long) i4;
        return ((((long) i3) - ((long) i2)) + 1) + 9 <= ((2 * j2) + 3) + ((j2 + 3) * 3);
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return shouldUseTableSwitch(fieldInfoArr[0].getFieldNumber(), fieldInfoArr[fieldInfoArr.length - 1].getFieldNumber(), fieldInfoArr.length);
    }

    static <UT, UB> UB storeUnknownEnum(Object obj, int i2, int i3, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.getBuilderFromMessage(obj);
        }
        unknownFieldSchema.addVarint(ub, i2, (long) i3);
        return ub;
    }

    static String toCamelCase(String str, boolean z2) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ('a' > charAt || charAt > 'z') {
                if ('A' > charAt || charAt > 'Z') {
                    if ('0' <= charAt && charAt <= '9') {
                        sb.append(charAt);
                    }
                    z2 = true;
                } else if (i2 != 0 || z2) {
                    sb.append(charAt);
                } else {
                    sb.append((char) (charAt + ' '));
                }
            } else if (z2) {
                sb.append((char) (charAt - ' '));
            } else {
                sb.append(charAt);
            }
            z2 = false;
        }
        return sb.toString();
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int i2, boolean z2, Writer writer) throws IOException {
        if (z2) {
            writer.writeBool(i2, true);
        }
    }

    public static void writeBoolList(int i2, List<Boolean> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBoolList(i2, list, z2);
        }
    }

    public static void writeBytes(int i2, ByteString byteString, Writer writer) throws IOException {
        if (byteString != null && !byteString.isEmpty()) {
            writer.writeBytes(i2, byteString);
        }
    }

    public static void writeBytesList(int i2, List<ByteString> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBytesList(i2, list);
        }
    }

    public static void writeDouble(int i2, double d2, Writer writer) throws IOException {
        if (Double.doubleToRawLongBits(d2) != 0) {
            writer.writeDouble(i2, d2);
        }
    }

    public static void writeDoubleList(int i2, List<Double> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeDoubleList(i2, list, z2);
        }
    }

    public static void writeEnum(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.writeEnum(i2, i3);
        }
    }

    public static void writeEnumList(int i2, List<Integer> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeEnumList(i2, list, z2);
        }
    }

    public static void writeFixed32(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.writeFixed32(i2, i3);
        }
    }

    public static void writeFixed32List(int i2, List<Integer> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed32List(i2, list, z2);
        }
    }

    public static void writeFixed64(int i2, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.writeFixed64(i2, j2);
        }
    }

    public static void writeFixed64List(int i2, List<Long> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed64List(i2, list, z2);
        }
    }

    public static void writeFloat(int i2, float f2, Writer writer) throws IOException {
        if (Float.floatToRawIntBits(f2) != 0) {
            writer.writeFloat(i2, f2);
        }
    }

    public static void writeFloatList(int i2, List<Float> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFloatList(i2, list, z2);
        }
    }

    public static void writeGroupList(int i2, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeGroupList(i2, list);
        }
    }

    public static void writeInt32(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.writeInt32(i2, i3);
        }
    }

    public static void writeInt32List(int i2, List<Integer> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt32List(i2, list, z2);
        }
    }

    public static void writeInt64(int i2, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.writeInt64(i2, j2);
        }
    }

    public static void writeInt64List(int i2, List<Long> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt64List(i2, list, z2);
        }
    }

    public static void writeLazyFieldList(int i2, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            Iterator<?> it2 = list.iterator();
            while (it2.hasNext()) {
                ((LazyFieldLite) it2.next()).writeTo(writer, i2);
            }
        }
    }

    public static void writeMessage(int i2, Object obj, Writer writer) throws IOException {
        if (obj != null) {
            writer.writeMessage(i2, obj);
        }
    }

    public static void writeMessageList(int i2, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeMessageList(i2, list);
        }
    }

    public static void writeSFixed32(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.writeSFixed32(i2, i3);
        }
    }

    public static void writeSFixed32List(int i2, List<Integer> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed32List(i2, list, z2);
        }
    }

    public static void writeSFixed64(int i2, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.writeSFixed64(i2, j2);
        }
    }

    public static void writeSFixed64List(int i2, List<Long> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed64List(i2, list, z2);
        }
    }

    public static void writeSInt32(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.writeSInt32(i2, i3);
        }
    }

    public static void writeSInt32List(int i2, List<Integer> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt32List(i2, list, z2);
        }
    }

    public static void writeSInt64(int i2, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.writeSInt64(i2, j2);
        }
    }

    public static void writeSInt64List(int i2, List<Long> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt64List(i2, list, z2);
        }
    }

    public static void writeString(int i2, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writeStringInternal(i2, (String) obj, writer);
        } else {
            writeBytes(i2, (ByteString) obj, writer);
        }
    }

    private static void writeStringInternal(int i2, String str, Writer writer) throws IOException {
        if (str != null && !str.isEmpty()) {
            writer.writeString(i2, str);
        }
    }

    public static void writeStringList(int i2, List<String> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeStringList(i2, list);
        }
    }

    public static void writeUInt32(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.writeUInt32(i2, i3);
        }
    }

    public static void writeUInt32List(int i2, List<Integer> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt32List(i2, list, z2);
        }
    }

    public static void writeUInt64(int i2, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.writeUInt64(i2, j2);
        }
    }

    public static void writeUInt64List(int i2, List<Long> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt64List(i2, list, z2);
        }
    }

    static int computeSizeGroupList(int i2, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += CodedOutputStream.computeGroupSize(i2, list.get(i4), schema);
        }
        return i3;
    }

    public static void writeGroupList(int i2, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeGroupList(i2, list, schema);
        }
    }

    public static void writeMessageList(int i2, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeMessageList(i2, list, schema);
        }
    }

    static int computeSizeMessageList(int i2, List<?> list, Schema schema) {
        int i3;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i2) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            if (obj instanceof LazyFieldLite) {
                i3 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                i3 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj, schema);
            }
            computeTagSize += i3;
        }
        return computeTagSize;
    }

    static <UT, UB> UB filterUnknownEnumList(Object obj, int i2, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = storeUnknownEnum(obj, i2, intValue, ub, unknownFieldSchema);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = it2.next().intValue();
                if (!enumVerifier.isInRange(intValue2)) {
                    ub = storeUnknownEnum(obj, i2, intValue2, ub, unknownFieldSchema);
                    it2.remove();
                }
            }
        }
        return ub;
    }
}
