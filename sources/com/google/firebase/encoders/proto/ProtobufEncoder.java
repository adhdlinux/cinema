package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class ProtobufEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, ObjectEncoder<?>> f30813a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, ValueEncoder<?>> f30814b;

    /* renamed from: c  reason: collision with root package name */
    private final ObjectEncoder<Object> f30815c;

    public static final class Builder implements EncoderConfig<Builder> {

        /* renamed from: d  reason: collision with root package name */
        private static final ObjectEncoder<Object> f30816d = new b();

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, ObjectEncoder<?>> f30817a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<Class<?>, ValueEncoder<?>> f30818b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private ObjectEncoder<Object> f30819c = f30816d;

        /* access modifiers changed from: private */
        public static /* synthetic */ void e(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public ProtobufEncoder c() {
            return new ProtobufEncoder(new HashMap(this.f30817a), new HashMap(this.f30818b), this.f30819c);
        }

        public Builder d(Configurator configurator) {
            configurator.a(this);
            return this;
        }

        /* renamed from: f */
        public <U> Builder a(Class<U> cls, ObjectEncoder<? super U> objectEncoder) {
            this.f30817a.put(cls, objectEncoder);
            this.f30818b.remove(cls);
            return this;
        }
    }

    ProtobufEncoder(Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.f30813a = map;
        this.f30814b = map2;
        this.f30815c = objectEncoder;
    }

    public static Builder a() {
        return new Builder();
    }

    public void b(Object obj, OutputStream outputStream) throws IOException {
        new ProtobufDataEncoderContext(outputStream, this.f30813a, this.f30814b, this.f30815c).p(obj);
    }

    public byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
