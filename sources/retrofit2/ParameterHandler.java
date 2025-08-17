package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

abstract class ParameterHandler<T> {

    static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f42047p;

        Body(Method method2, int i2, Converter<T, RequestBody> converter2) {
            this.method = method2;
            this.f42047p = i2;
            this.converter = converter2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, T t2) {
            if (t2 != null) {
                try {
                    requestBuilder.setBody(this.converter.convert(t2));
                } catch (IOException e2) {
                    Method method2 = this.method;
                    int i2 = this.f42047p;
                    throw Utils.parameterError(method2, e2, i2, "Unable to convert " + t2 + " to RequestBody", new Object[0]);
                }
            } else {
                throw Utils.parameterError(this.method, this.f42047p, "Body parameter value must not be null.", new Object[0]);
            }
        }
    }

    static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        Field(String str, Converter<T, String> converter, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, T t2) throws IOException {
            String convert;
            if (t2 != null && (convert = this.valueConverter.convert(t2)) != null) {
                requestBuilder.addFormField(this.name, convert, this.encoded);
            }
        }
    }

    static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f42048p;
        private final Converter<T, String> valueConverter;

        FieldMap(Method method2, int i2, Converter<T, String> converter, boolean z2) {
            this.method = method2;
            this.f42048p = i2;
            this.valueConverter = converter;
            this.encoded = z2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            String convert = this.valueConverter.convert(value);
                            if (convert != null) {
                                requestBuilder.addFormField(str, convert, this.encoded);
                            } else {
                                Method method2 = this.method;
                                int i2 = this.f42048p;
                                throw Utils.parameterError(method2, i2, "Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                            }
                        } else {
                            Method method3 = this.method;
                            int i3 = this.f42048p;
                            throw Utils.parameterError(method3, i3, "Field map contained null value for key '" + str + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f42048p, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f42048p, "Field map was null.", new Object[0]);
        }
    }

    static final class Header<T> extends ParameterHandler<T> {
        private final boolean allowUnsafeNonAsciiValues;
        private final String name;
        private final Converter<T, String> valueConverter;

        Header(String str, Converter<T, String> converter, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.allowUnsafeNonAsciiValues = z2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, T t2) throws IOException {
            String convert;
            if (t2 != null && (convert = this.valueConverter.convert(t2)) != null) {
                requestBuilder.addHeader(this.name, convert, this.allowUnsafeNonAsciiValues);
            }
        }
    }

    static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean allowUnsafeNonAsciiValues;
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f42049p;
        private final Converter<T, String> valueConverter;

        HeaderMap(Method method2, int i2, Converter<T, String> converter, boolean z2) {
            this.method = method2;
            this.f42049p = i2;
            this.valueConverter = converter;
            this.allowUnsafeNonAsciiValues = z2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            requestBuilder.addHeader(str, this.valueConverter.convert(value), this.allowUnsafeNonAsciiValues);
                        } else {
                            Method method2 = this.method;
                            int i2 = this.f42049p;
                            throw Utils.parameterError(method2, i2, "Header map contained null value for key '" + str + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f42049p, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f42049p, "Header map was null.", new Object[0]);
        }
    }

    static final class Headers extends ParameterHandler<okhttp3.Headers> {
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f42050p;

        Headers(Method method2, int i2) {
            this.method = method2;
            this.f42050p = i2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, okhttp3.Headers headers) {
            if (headers != null) {
                requestBuilder.addHeaders(headers);
                return;
            }
            throw Utils.parameterError(this.method, this.f42050p, "Headers parameter must not be null.", new Object[0]);
        }
    }

    static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final okhttp3.Headers headers;
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f42051p;

        Part(Method method2, int i2, okhttp3.Headers headers2, Converter<T, RequestBody> converter2) {
            this.method = method2;
            this.f42051p = i2;
            this.headers = headers2;
            this.converter = converter2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, T t2) {
            if (t2 != null) {
                try {
                    requestBuilder.addPart(this.headers, this.converter.convert(t2));
                } catch (IOException e2) {
                    Method method2 = this.method;
                    int i2 = this.f42051p;
                    throw Utils.parameterError(method2, i2, "Unable to convert " + t2 + " to RequestBody", e2);
                }
            }
        }
    }

    static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f42052p;
        private final String transferEncoding;
        private final Converter<T, RequestBody> valueConverter;

        PartMap(Method method2, int i2, Converter<T, RequestBody> converter, String str) {
            this.method = method2;
            this.f42052p = i2;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            requestBuilder.addPart(okhttp3.Headers.of("Content-Disposition", "form-data; name=\"" + str + "\"", "Content-Transfer-Encoding", this.transferEncoding), this.valueConverter.convert(value));
                        } else {
                            Method method2 = this.method;
                            int i2 = this.f42052p;
                            throw Utils.parameterError(method2, i2, "Part map contained null value for key '" + str + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f42052p, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f42052p, "Part map was null.", new Object[0]);
        }
    }

    static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Method method;
        private final String name;

        /* renamed from: p  reason: collision with root package name */
        private final int f42053p;
        private final Converter<T, String> valueConverter;

        Path(Method method2, int i2, String str, Converter<T, String> converter, boolean z2) {
            this.method = method2;
            this.f42053p = i2;
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, T t2) throws IOException {
            if (t2 != null) {
                requestBuilder.addPathParam(this.name, this.valueConverter.convert(t2), this.encoded);
                return;
            }
            Method method2 = this.method;
            int i2 = this.f42053p;
            throw Utils.parameterError(method2, i2, "Path parameter \"" + this.name + "\" value must not be null.", new Object[0]);
        }
    }

    static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        Query(String str, Converter<T, String> converter, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, T t2) throws IOException {
            String convert;
            if (t2 != null && (convert = this.valueConverter.convert(t2)) != null) {
                requestBuilder.addQueryParam(this.name, convert, this.encoded);
            }
        }
    }

    static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f42054p;
        private final Converter<T, String> valueConverter;

        QueryMap(Method method2, int i2, Converter<T, String> converter, boolean z2) {
            this.method = method2;
            this.f42054p = i2;
            this.valueConverter = converter;
            this.encoded = z2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            String convert = this.valueConverter.convert(value);
                            if (convert != null) {
                                requestBuilder.addQueryParam(str, convert, this.encoded);
                            } else {
                                Method method2 = this.method;
                                int i2 = this.f42054p;
                                throw Utils.parameterError(method2, i2, "Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                            }
                        } else {
                            Method method3 = this.method;
                            int i3 = this.f42054p;
                            throw Utils.parameterError(method3, i3, "Query map contained null value for key '" + str + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f42054p, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f42054p, "Query map was null", new Object[0]);
        }
    }

    static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        QueryName(Converter<T, String> converter, boolean z2) {
            this.nameConverter = converter;
            this.encoded = z2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, T t2) throws IOException {
            if (t2 != null) {
                requestBuilder.addQueryParam(this.nameConverter.convert(t2), (String) null, this.encoded);
            }
        }
    }

    static final class RawPart extends ParameterHandler<MultipartBody.Part> {
        static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, MultipartBody.Part part) {
            if (part != null) {
                requestBuilder.addPart(part);
            }
        }
    }

    static final class RelativeUrl extends ParameterHandler<Object> {
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f42055p;

        RelativeUrl(Method method2, int i2) {
            this.method = method2;
            this.f42055p = i2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj != null) {
                requestBuilder.setRelativeUrl(obj);
                return;
            }
            throw Utils.parameterError(this.method, this.f42055p, "@Url parameter is null.", new Object[0]);
        }
    }

    static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> cls;

        Tag(Class<T> cls2) {
            this.cls = cls2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, T t2) {
            requestBuilder.addTag(this.cls, t2);
        }
    }

    ParameterHandler() {
    }

    /* access modifiers changed from: package-private */
    public abstract void apply(RequestBuilder requestBuilder, T t2) throws IOException;

    /* access modifiers changed from: package-private */
    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() {
            /* access modifiers changed from: package-private */
            public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i2 = 0; i2 < length; i2++) {
                        ParameterHandler.this.apply(requestBuilder, Array.get(obj, i2));
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() {
            /* access modifiers changed from: package-private */
            public void apply(RequestBuilder requestBuilder, Iterable<T> iterable) throws IOException {
                if (iterable != null) {
                    for (T apply : iterable) {
                        ParameterHandler.this.apply(requestBuilder, apply);
                    }
                }
            }
        };
    }
}
