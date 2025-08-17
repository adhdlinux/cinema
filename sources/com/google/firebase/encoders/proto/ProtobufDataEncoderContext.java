package com.google.firebase.encoders.proto;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;

final class ProtobufDataEncoderContext implements ObjectEncoderContext {

    /* renamed from: f  reason: collision with root package name */
    private static final Charset f30803f = Charset.forName("UTF-8");

    /* renamed from: g  reason: collision with root package name */
    private static final FieldDescriptor f30804g = FieldDescriptor.a("key").b(AtProtobuf.b().c(1).a()).a();

    /* renamed from: h  reason: collision with root package name */
    private static final FieldDescriptor f30805h = FieldDescriptor.a(AppMeasurementSdk.ConditionalUserProperty.VALUE).b(AtProtobuf.b().c(2).a()).a();

    /* renamed from: i  reason: collision with root package name */
    private static final ObjectEncoder<Map.Entry<Object, Object>> f30806i = new a();

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f30807a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, ObjectEncoder<?>> f30808b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, ValueEncoder<?>> f30809c;

    /* renamed from: d  reason: collision with root package name */
    private final ObjectEncoder<Object> f30810d;

    /* renamed from: e  reason: collision with root package name */
    private final ProtobufValueEncoderContext f30811e = new ProtobufValueEncoderContext(this);

    /* renamed from: com.google.firebase.encoders.proto.ProtobufDataEncoderContext$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30812a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.firebase.encoders.proto.Protobuf$IntEncoding[] r0 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30812a = r0
                com.google.firebase.encoders.proto.Protobuf$IntEncoding r1 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30812a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.encoders.proto.Protobuf$IntEncoding r1 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.SIGNED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f30812a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.encoders.proto.Protobuf$IntEncoding r1 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.FIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.encoders.proto.ProtobufDataEncoderContext.AnonymousClass1.<clinit>():void");
        }
    }

    ProtobufDataEncoderContext(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.f30807a = outputStream;
        this.f30808b = map;
        this.f30809c = map2;
        this.f30810d = objectEncoder;
    }

    private static ByteBuffer l(int i2) {
        return ByteBuffer.allocate(i2).order(ByteOrder.LITTLE_ENDIAN);
    }

    private <T> long m(ObjectEncoder<T> objectEncoder, T t2) throws IOException {
        OutputStream outputStream;
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        try {
            outputStream = this.f30807a;
            this.f30807a = lengthCountingOutputStream;
            objectEncoder.a(t2, this);
            this.f30807a = outputStream;
            long a2 = lengthCountingOutputStream.a();
            lengthCountingOutputStream.close();
            return a2;
        } catch (Throwable th) {
            try {
                lengthCountingOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private <T> ProtobufDataEncoderContext n(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor, T t2, boolean z2) throws IOException {
        long m2 = m(objectEncoder, t2);
        if (z2 && m2 == 0) {
            return this;
        }
        t((r(fieldDescriptor) << 3) | 2);
        u(m2);
        objectEncoder.a(t2, this);
        return this;
    }

    private <T> ProtobufDataEncoderContext o(ValueEncoder<T> valueEncoder, FieldDescriptor fieldDescriptor, T t2, boolean z2) throws IOException {
        this.f30811e.c(fieldDescriptor, z2);
        valueEncoder.a(t2, this.f30811e);
        return this;
    }

    private static Protobuf q(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static int r(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void s(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.c(f30804g, entry.getKey());
        objectEncoderContext.c(f30805h, entry.getValue());
    }

    private void t(int i2) throws IOException {
        while (((long) (i2 & -128)) != 0) {
            this.f30807a.write((i2 & 127) | 128);
            i2 >>>= 7;
        }
        this.f30807a.write(i2 & 127);
    }

    private void u(long j2) throws IOException {
        while ((-128 & j2) != 0) {
            this.f30807a.write((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        this.f30807a.write(((int) j2) & 127);
    }

    public ObjectEncoderContext c(FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        return f(fieldDescriptor, obj, true);
    }

    /* access modifiers changed from: package-private */
    public ObjectEncoderContext d(FieldDescriptor fieldDescriptor, double d2, boolean z2) throws IOException {
        if (z2 && d2 == 0.0d) {
            return this;
        }
        t((r(fieldDescriptor) << 3) | 1);
        this.f30807a.write(l(8).putDouble(d2).array());
        return this;
    }

    /* access modifiers changed from: package-private */
    public ObjectEncoderContext e(FieldDescriptor fieldDescriptor, float f2, boolean z2) throws IOException {
        if (z2 && f2 == 0.0f) {
            return this;
        }
        t((r(fieldDescriptor) << 3) | 5);
        this.f30807a.write(l(4).putFloat(f2).array());
        return this;
    }

    /* access modifiers changed from: package-private */
    public ObjectEncoderContext f(FieldDescriptor fieldDescriptor, Object obj, boolean z2) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z2 && charSequence.length() == 0) {
                return this;
            }
            t((r(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f30803f);
            t(bytes.length);
            this.f30807a.write(bytes);
            return this;
        } else if (obj instanceof Collection) {
            for (Object f2 : (Collection) obj) {
                f(fieldDescriptor, f2, false);
            }
            return this;
        } else if (obj instanceof Map) {
            for (Map.Entry n2 : ((Map) obj).entrySet()) {
                n(f30806i, fieldDescriptor, n2, false);
            }
            return this;
        } else if (obj instanceof Double) {
            return d(fieldDescriptor, ((Double) obj).doubleValue(), z2);
        } else {
            if (obj instanceof Float) {
                return e(fieldDescriptor, ((Float) obj).floatValue(), z2);
            }
            if (obj instanceof Number) {
                return j(fieldDescriptor, ((Number) obj).longValue(), z2);
            }
            if (obj instanceof Boolean) {
                return k(fieldDescriptor, ((Boolean) obj).booleanValue(), z2);
            }
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (z2 && bArr.length == 0) {
                    return this;
                }
                t((r(fieldDescriptor) << 3) | 2);
                t(bArr.length);
                this.f30807a.write(bArr);
                return this;
            }
            ObjectEncoder objectEncoder = this.f30808b.get(obj.getClass());
            if (objectEncoder != null) {
                return n(objectEncoder, fieldDescriptor, obj, z2);
            }
            ValueEncoder valueEncoder = this.f30809c.get(obj.getClass());
            if (valueEncoder != null) {
                return o(valueEncoder, fieldDescriptor, obj, z2);
            }
            if (obj instanceof ProtoEnum) {
                return g(fieldDescriptor, ((ProtoEnum) obj).getNumber());
            }
            if (obj instanceof Enum) {
                return g(fieldDescriptor, ((Enum) obj).ordinal());
            }
            return n(this.f30810d, fieldDescriptor, obj, z2);
        }
    }

    public ProtobufDataEncoderContext g(FieldDescriptor fieldDescriptor, int i2) throws IOException {
        return h(fieldDescriptor, i2, true);
    }

    /* access modifiers changed from: package-private */
    public ProtobufDataEncoderContext h(FieldDescriptor fieldDescriptor, int i2, boolean z2) throws IOException {
        if (z2 && i2 == 0) {
            return this;
        }
        Protobuf q2 = q(fieldDescriptor);
        int i3 = AnonymousClass1.f30812a[q2.intEncoding().ordinal()];
        if (i3 == 1) {
            t(q2.tag() << 3);
            t(i2);
        } else if (i3 == 2) {
            t(q2.tag() << 3);
            t((i2 << 1) ^ (i2 >> 31));
        } else if (i3 == 3) {
            t((q2.tag() << 3) | 5);
            this.f30807a.write(l(4).putInt(i2).array());
        }
        return this;
    }

    /* renamed from: i */
    public ProtobufDataEncoderContext a(FieldDescriptor fieldDescriptor, long j2) throws IOException {
        return j(fieldDescriptor, j2, true);
    }

    /* access modifiers changed from: package-private */
    public ProtobufDataEncoderContext j(FieldDescriptor fieldDescriptor, long j2, boolean z2) throws IOException {
        if (z2 && j2 == 0) {
            return this;
        }
        Protobuf q2 = q(fieldDescriptor);
        int i2 = AnonymousClass1.f30812a[q2.intEncoding().ordinal()];
        if (i2 == 1) {
            t(q2.tag() << 3);
            u(j2);
        } else if (i2 == 2) {
            t(q2.tag() << 3);
            u((j2 >> 63) ^ (j2 << 1));
        } else if (i2 == 3) {
            t((q2.tag() << 3) | 1);
            this.f30807a.write(l(8).putLong(j2).array());
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public ProtobufDataEncoderContext k(FieldDescriptor fieldDescriptor, boolean z2, boolean z3) throws IOException {
        return h(fieldDescriptor, z2 ? 1 : 0, z3);
    }

    /* access modifiers changed from: package-private */
    public ProtobufDataEncoderContext p(Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder objectEncoder = this.f30808b.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.a(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }
}
