package com.google.firebase.encoders.json;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import x0.a;
import x0.b;
import x0.c;

public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {

    /* renamed from: e  reason: collision with root package name */
    private static final ObjectEncoder<Object> f30777e = new a();

    /* renamed from: f  reason: collision with root package name */
    private static final ValueEncoder<String> f30778f = new b();

    /* renamed from: g  reason: collision with root package name */
    private static final ValueEncoder<Boolean> f30779g = new c();

    /* renamed from: h  reason: collision with root package name */
    private static final TimestampEncoder f30780h = new TimestampEncoder();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, ObjectEncoder<?>> f30781a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<?>, ValueEncoder<?>> f30782b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ObjectEncoder<Object> f30783c = f30777e;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f30784d = false;

    private static final class TimestampEncoder implements ValueEncoder<Date> {

        /* renamed from: a  reason: collision with root package name */
        private static final DateFormat f30786a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f30786a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private TimestampEncoder() {
        }

        /* renamed from: b */
        public void a(Date date, ValueEncoderContext valueEncoderContext) throws IOException {
            valueEncoderContext.b(f30786a.format(date));
        }
    }

    public JsonDataEncoderBuilder() {
        p(String.class, f30778f);
        p(Boolean.class, f30779g);
        p(Date.class, f30780h);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void l(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public DataEncoder i() {
        return new DataEncoder() {
            public void a(Object obj, Writer writer) throws IOException {
                JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, JsonDataEncoderBuilder.this.f30781a, JsonDataEncoderBuilder.this.f30782b, JsonDataEncoderBuilder.this.f30783c, JsonDataEncoderBuilder.this.f30784d);
                jsonValueObjectEncoderContext.f(obj, false);
                jsonValueObjectEncoderContext.m();
            }
        };
    }

    public JsonDataEncoderBuilder j(Configurator configurator) {
        configurator.a(this);
        return this;
    }

    public JsonDataEncoderBuilder k(boolean z2) {
        this.f30784d = z2;
        return this;
    }

    /* renamed from: o */
    public <T> JsonDataEncoderBuilder a(Class<T> cls, ObjectEncoder<? super T> objectEncoder) {
        this.f30781a.put(cls, objectEncoder);
        this.f30782b.remove(cls);
        return this;
    }

    public <T> JsonDataEncoderBuilder p(Class<T> cls, ValueEncoder<? super T> valueEncoder) {
        this.f30782b.put(cls, valueEncoder);
        this.f30781a.remove(cls);
        return this;
    }
}
