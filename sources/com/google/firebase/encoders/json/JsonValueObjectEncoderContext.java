package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {

    /* renamed from: a  reason: collision with root package name */
    private JsonValueObjectEncoderContext f30787a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f30788b = true;

    /* renamed from: c  reason: collision with root package name */
    private final JsonWriter f30789c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, ObjectEncoder<?>> f30790d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, ValueEncoder<?>> f30791e;

    /* renamed from: f  reason: collision with root package name */
    private final ObjectEncoder<Object> f30792f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f30793g;

    JsonValueObjectEncoderContext(Writer writer, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder, boolean z2) {
        this.f30789c = new JsonWriter(writer);
        this.f30790d = map;
        this.f30791e = map2;
        this.f30792f = objectEncoder;
        this.f30793g = z2;
    }

    private boolean l(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    private JsonValueObjectEncoderContext o(String str, Object obj) throws IOException, EncodingException {
        q();
        this.f30789c.name(str);
        if (obj != null) {
            return f(obj, false);
        }
        this.f30789c.nullValue();
        return this;
    }

    private JsonValueObjectEncoderContext p(String str, Object obj) throws IOException, EncodingException {
        if (obj == null) {
            return this;
        }
        q();
        this.f30789c.name(str);
        return f(obj, false);
    }

    private void q() throws IOException {
        if (this.f30788b) {
            JsonValueObjectEncoderContext jsonValueObjectEncoderContext = this.f30787a;
            if (jsonValueObjectEncoderContext != null) {
                jsonValueObjectEncoderContext.q();
                this.f30787a.f30788b = false;
                this.f30787a = null;
                this.f30789c.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    public ObjectEncoderContext a(FieldDescriptor fieldDescriptor, long j2) throws IOException {
        return h(fieldDescriptor.b(), j2);
    }

    public ObjectEncoderContext c(FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        return i(fieldDescriptor.b(), obj);
    }

    public JsonValueObjectEncoderContext e(long j2) throws IOException {
        q();
        this.f30789c.value(j2);
        return this;
    }

    /* access modifiers changed from: package-private */
    public JsonValueObjectEncoderContext f(Object obj, boolean z2) throws IOException {
        Class<?> cls;
        int i2 = 0;
        if (z2 && l(obj)) {
            Object[] objArr = new Object[1];
            if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            objArr[0] = cls;
            throw new EncodingException(String.format("%s cannot be encoded inline", objArr));
        } else if (obj == null) {
            this.f30789c.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.f30789c.value((Number) obj);
            return this;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                return k((byte[]) obj);
            }
            this.f30789c.beginArray();
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length = iArr.length;
                while (i2 < length) {
                    this.f30789c.value((long) iArr[i2]);
                    i2++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i2 < length2) {
                    e(jArr[i2]);
                    i2++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i2 < length3) {
                    this.f30789c.value(dArr[i2]);
                    i2++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i2 < length4) {
                    this.f30789c.value(zArr[i2]);
                    i2++;
                }
            } else if (obj instanceof Number[]) {
                for (Number f2 : (Number[]) obj) {
                    f(f2, false);
                }
            } else {
                for (Object f3 : (Object[]) obj) {
                    f(f3, false);
                }
            }
            this.f30789c.endArray();
            return this;
        } else if (obj instanceof Collection) {
            this.f30789c.beginArray();
            for (Object f4 : (Collection) obj) {
                f(f4, false);
            }
            this.f30789c.endArray();
            return this;
        } else if (obj instanceof Map) {
            this.f30789c.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    i((String) key, entry.getValue());
                } catch (ClassCastException e2) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[]{key, key.getClass()}), e2);
                }
            }
            this.f30789c.endObject();
            return this;
        } else {
            ObjectEncoder objectEncoder = this.f30790d.get(obj.getClass());
            if (objectEncoder != null) {
                return n(objectEncoder, obj, z2);
            }
            ValueEncoder valueEncoder = this.f30791e.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.a(obj, this);
                return this;
            } else if (!(obj instanceof Enum)) {
                return n(this.f30792f, obj, z2);
            } else {
                b(((Enum) obj).name());
                return this;
            }
        }
    }

    /* renamed from: g */
    public JsonValueObjectEncoderContext b(String str) throws IOException {
        q();
        this.f30789c.value(str);
        return this;
    }

    public JsonValueObjectEncoderContext h(String str, long j2) throws IOException {
        q();
        this.f30789c.name(str);
        return e(j2);
    }

    public JsonValueObjectEncoderContext i(String str, Object obj) throws IOException {
        if (this.f30793g) {
            return p(str, obj);
        }
        return o(str, obj);
    }

    /* renamed from: j */
    public JsonValueObjectEncoderContext d(boolean z2) throws IOException {
        q();
        this.f30789c.value(z2);
        return this;
    }

    public JsonValueObjectEncoderContext k(byte[] bArr) throws IOException {
        q();
        if (bArr == null) {
            this.f30789c.nullValue();
        } else {
            this.f30789c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void m() throws IOException {
        q();
        this.f30789c.flush();
    }

    /* access modifiers changed from: package-private */
    public JsonValueObjectEncoderContext n(ObjectEncoder<Object> objectEncoder, Object obj, boolean z2) throws IOException {
        if (!z2) {
            this.f30789c.beginObject();
        }
        objectEncoder.a(obj, this);
        if (!z2) {
            this.f30789c.endObject();
        }
        return this;
    }
}
