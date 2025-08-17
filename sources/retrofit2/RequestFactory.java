package retrofit2;

import com.uwetrottmann.trakt5.TraktV2;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.Continuation;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import retrofit2.ParameterHandler;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Tag;
import retrofit2.http.Url;

final class RequestFactory {
    private final HttpUrl baseUrl;
    private final MediaType contentType;
    private final boolean hasBody;
    private final Headers headers;
    final String httpMethod;
    private final boolean isFormEncoded;
    final boolean isKotlinSuspendFunction;
    private final boolean isMultipart;
    private final Method method;
    private final ParameterHandler<?>[] parameterHandlers;
    private final String relativeUrl;
    private final Class<?> service;

    static final class Builder {
        private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
        private static final Pattern PARAM_NAME_REGEX = Pattern.compile(PARAM);
        private static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        MediaType contentType;
        boolean gotBody;
        boolean gotField;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotQueryMap;
        boolean gotQueryName;
        boolean gotUrl;
        boolean hasBody;
        Headers headers;
        String httpMethod;
        boolean isFormEncoded;
        boolean isKotlinSuspendFunction;
        boolean isMultipart;
        final Method method;
        final Annotation[] methodAnnotations;
        final Annotation[][] parameterAnnotationsArray;
        ParameterHandler<?>[] parameterHandlers;
        final Type[] parameterTypes;
        String relativeUrl;
        Set<String> relativeUrlParamNames;
        final Retrofit retrofit;
        final Class<?> service;

        Builder(Retrofit retrofit3, Class<?> cls, Method method2) {
            this.retrofit = retrofit3;
            this.service = cls;
            this.method = method2;
            this.methodAnnotations = method2.getAnnotations();
            this.parameterTypes = method2.getGenericParameterTypes();
            this.parameterAnnotationsArray = method2.getParameterAnnotations();
        }

        private static Class<?> boxIfPrimitive(Class<?> cls) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            if (Short.TYPE == cls) {
                return Short.class;
            }
            return cls;
        }

        private Headers parseHeaders(String[] strArr, boolean z2) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw Utils.methodError(this.method, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if (TraktV2.HEADER_CONTENT_TYPE.equalsIgnoreCase(substring)) {
                    try {
                        this.contentType = MediaType.get(trim);
                    } catch (IllegalArgumentException e2) {
                        throw Utils.methodError(this.method, e2, "Malformed content type: %s", trim);
                    }
                } else if (z2) {
                    builder.addUnsafeNonAscii(substring, trim);
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        private void parseHttpMethodAndPath(String str, String str2, boolean z2) {
            String str3 = this.httpMethod;
            if (str3 == null) {
                this.httpMethod = str;
                this.hasBody = z2;
                if (!str2.isEmpty()) {
                    int indexOf = str2.indexOf(63);
                    if (indexOf != -1 && indexOf < str2.length() - 1) {
                        String substring = str2.substring(indexOf + 1);
                        if (PARAM_URL_REGEX.matcher(substring).find()) {
                            throw Utils.methodError(this.method, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                        }
                    }
                    this.relativeUrl = str2;
                    this.relativeUrlParamNames = parsePathParameters(str2);
                    return;
                }
                return;
            }
            throw Utils.methodError(this.method, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        private void parseMethodAnnotation(Annotation annotation) {
            if (annotation instanceof DELETE) {
                parseHttpMethodAndPath("DELETE", ((DELETE) annotation).value(), false);
            } else if (annotation instanceof GET) {
                parseHttpMethodAndPath("GET", ((GET) annotation).value(), false);
            } else if (annotation instanceof HEAD) {
                parseHttpMethodAndPath("HEAD", ((HEAD) annotation).value(), false);
            } else if (annotation instanceof PATCH) {
                parseHttpMethodAndPath("PATCH", ((PATCH) annotation).value(), true);
            } else if (annotation instanceof POST) {
                parseHttpMethodAndPath("POST", ((POST) annotation).value(), true);
            } else if (annotation instanceof PUT) {
                parseHttpMethodAndPath("PUT", ((PUT) annotation).value(), true);
            } else if (annotation instanceof OPTIONS) {
                parseHttpMethodAndPath("OPTIONS", ((OPTIONS) annotation).value(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                parseHttpMethodAndPath(http.method(), http.path(), http.hasBody());
            } else if (annotation instanceof retrofit2.http.Headers) {
                retrofit2.http.Headers headers2 = (retrofit2.http.Headers) annotation;
                String[] value = headers2.value();
                if (value.length != 0) {
                    this.headers = parseHeaders(value, headers2.allowUnsafeNonAsciiValues());
                    return;
                }
                throw Utils.methodError(this.method, "@Headers annotation is empty.", new Object[0]);
            } else if (annotation instanceof Multipart) {
                if (!this.isFormEncoded) {
                    this.isMultipart = true;
                    return;
                }
                throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
            } else if (!(annotation instanceof FormUrlEncoded)) {
            } else {
                if (!this.isMultipart) {
                    this.isFormEncoded = true;
                    return;
                }
                throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        private ParameterHandler<?> parseParameter(int i2, Type type, Annotation[] annotationArr, boolean z2) {
            ParameterHandler<?> parameterHandler;
            if (annotationArr != null) {
                parameterHandler = null;
                for (Annotation parseParameterAnnotation : annotationArr) {
                    ParameterHandler<?> parseParameterAnnotation2 = parseParameterAnnotation(i2, type, annotationArr, parseParameterAnnotation);
                    if (parseParameterAnnotation2 != null) {
                        if (parameterHandler == null) {
                            parameterHandler = parseParameterAnnotation2;
                        } else {
                            throw Utils.parameterError(this.method, i2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                    }
                }
            } else {
                parameterHandler = null;
            }
            if (parameterHandler != null) {
                return parameterHandler;
            }
            if (z2) {
                try {
                    if (Utils.getRawType(type) == Continuation.class) {
                        this.isKotlinSuspendFunction = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw Utils.parameterError(this.method, i2, "No Retrofit annotation found.", new Object[0]);
        }

        private ParameterHandler<?> parseParameterAnnotation(int i2, Type type, Annotation[] annotationArr, Annotation annotation) {
            Class<String> cls = String.class;
            if (annotation instanceof Url) {
                validateResolvableType(i2, type);
                if (this.gotUrl) {
                    throw Utils.parameterError(this.method, i2, "Multiple @Url method annotations found.", new Object[0]);
                } else if (this.gotPath) {
                    throw Utils.parameterError(this.method, i2, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.gotQuery) {
                    throw Utils.parameterError(this.method, i2, "A @Url parameter must not come after a @Query.", new Object[0]);
                } else if (this.gotQueryName) {
                    throw Utils.parameterError(this.method, i2, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                } else if (this.gotQueryMap) {
                    throw Utils.parameterError(this.method, i2, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                } else if (this.relativeUrl == null) {
                    this.gotUrl = true;
                    if (type == HttpUrl.class || type == cls || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                        return new ParameterHandler.RelativeUrl(this.method, i2);
                    }
                    throw Utils.parameterError(this.method, i2, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                } else {
                    throw Utils.parameterError(this.method, i2, "@Url cannot be used with @%s URL", this.httpMethod);
                }
            } else if (annotation instanceof Path) {
                validateResolvableType(i2, type);
                if (this.gotQuery) {
                    throw Utils.parameterError(this.method, i2, "A @Path parameter must not come after a @Query.", new Object[0]);
                } else if (this.gotQueryName) {
                    throw Utils.parameterError(this.method, i2, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                } else if (this.gotQueryMap) {
                    throw Utils.parameterError(this.method, i2, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                } else if (this.gotUrl) {
                    throw Utils.parameterError(this.method, i2, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.relativeUrl != null) {
                    this.gotPath = true;
                    Path path = (Path) annotation;
                    String value = path.value();
                    validatePathName(i2, value);
                    return new ParameterHandler.Path(this.method, i2, value, this.retrofit.stringConverter(type, annotationArr), path.encoded());
                } else {
                    throw Utils.parameterError(this.method, i2, "@Path can only be used with relative url on @%s", this.httpMethod);
                }
            } else {
                Class<Iterable> cls2 = Iterable.class;
                if (annotation instanceof Query) {
                    validateResolvableType(i2, type);
                    Query query = (Query) annotation;
                    String value2 = query.value();
                    boolean encoded = query.encoded();
                    Class<?> rawType = Utils.getRawType(type);
                    this.gotQuery = true;
                    if (cls2.isAssignableFrom(rawType)) {
                        if (type instanceof ParameterizedType) {
                            return new ParameterHandler.Query(value2, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded).iterable();
                        }
                        throw Utils.parameterError(this.method, i2, rawType.getSimpleName() + " must include generic type (e.g., " + rawType.getSimpleName() + "<String>)", new Object[0]);
                    } else if (!rawType.isArray()) {
                        return new ParameterHandler.Query(value2, this.retrofit.stringConverter(type, annotationArr), encoded);
                    } else {
                        return new ParameterHandler.Query(value2, this.retrofit.stringConverter(boxIfPrimitive(rawType.getComponentType()), annotationArr), encoded).array();
                    }
                } else if (annotation instanceof QueryName) {
                    validateResolvableType(i2, type);
                    boolean encoded2 = ((QueryName) annotation).encoded();
                    Class<?> rawType2 = Utils.getRawType(type);
                    this.gotQueryName = true;
                    if (cls2.isAssignableFrom(rawType2)) {
                        if (type instanceof ParameterizedType) {
                            return new ParameterHandler.QueryName(this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded2).iterable();
                        }
                        throw Utils.parameterError(this.method, i2, rawType2.getSimpleName() + " must include generic type (e.g., " + rawType2.getSimpleName() + "<String>)", new Object[0]);
                    } else if (!rawType2.isArray()) {
                        return new ParameterHandler.QueryName(this.retrofit.stringConverter(type, annotationArr), encoded2);
                    } else {
                        return new ParameterHandler.QueryName(this.retrofit.stringConverter(boxIfPrimitive(rawType2.getComponentType()), annotationArr), encoded2).array();
                    }
                } else {
                    Class<Map> cls3 = Map.class;
                    if (annotation instanceof QueryMap) {
                        validateResolvableType(i2, type);
                        Class<?> rawType3 = Utils.getRawType(type);
                        this.gotQueryMap = true;
                        if (cls3.isAssignableFrom(rawType3)) {
                            Type supertype = Utils.getSupertype(type, rawType3, cls3);
                            if (supertype instanceof ParameterizedType) {
                                ParameterizedType parameterizedType = (ParameterizedType) supertype;
                                Type parameterUpperBound = Utils.getParameterUpperBound(0, parameterizedType);
                                if (cls == parameterUpperBound) {
                                    return new ParameterHandler.QueryMap(this.method, i2, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType), annotationArr), ((QueryMap) annotation).encoded());
                                }
                                throw Utils.parameterError(this.method, i2, "@QueryMap keys must be of type String: " + parameterUpperBound, new Object[0]);
                            }
                            throw Utils.parameterError(this.method, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                        }
                        throw Utils.parameterError(this.method, i2, "@QueryMap parameter type must be Map.", new Object[0]);
                    } else if (annotation instanceof Header) {
                        validateResolvableType(i2, type);
                        Header header = (Header) annotation;
                        String value3 = header.value();
                        Class<?> rawType4 = Utils.getRawType(type);
                        if (cls2.isAssignableFrom(rawType4)) {
                            if (type instanceof ParameterizedType) {
                                return new ParameterHandler.Header(value3, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), header.allowUnsafeNonAsciiValues()).iterable();
                            }
                            throw Utils.parameterError(this.method, i2, rawType4.getSimpleName() + " must include generic type (e.g., " + rawType4.getSimpleName() + "<String>)", new Object[0]);
                        } else if (!rawType4.isArray()) {
                            return new ParameterHandler.Header(value3, this.retrofit.stringConverter(type, annotationArr), header.allowUnsafeNonAsciiValues());
                        } else {
                            return new ParameterHandler.Header(value3, this.retrofit.stringConverter(boxIfPrimitive(rawType4.getComponentType()), annotationArr), header.allowUnsafeNonAsciiValues()).array();
                        }
                    } else if (annotation instanceof HeaderMap) {
                        if (type == Headers.class) {
                            return new ParameterHandler.Headers(this.method, i2);
                        }
                        validateResolvableType(i2, type);
                        Class<?> rawType5 = Utils.getRawType(type);
                        if (cls3.isAssignableFrom(rawType5)) {
                            Type supertype2 = Utils.getSupertype(type, rawType5, cls3);
                            if (supertype2 instanceof ParameterizedType) {
                                ParameterizedType parameterizedType2 = (ParameterizedType) supertype2;
                                Type parameterUpperBound2 = Utils.getParameterUpperBound(0, parameterizedType2);
                                if (cls == parameterUpperBound2) {
                                    return new ParameterHandler.HeaderMap(this.method, i2, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType2), annotationArr), ((HeaderMap) annotation).allowUnsafeNonAsciiValues());
                                }
                                throw Utils.parameterError(this.method, i2, "@HeaderMap keys must be of type String: " + parameterUpperBound2, new Object[0]);
                            }
                            throw Utils.parameterError(this.method, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                        }
                        throw Utils.parameterError(this.method, i2, "@HeaderMap parameter type must be Map or Headers.", new Object[0]);
                    } else if (annotation instanceof Field) {
                        validateResolvableType(i2, type);
                        if (this.isFormEncoded) {
                            Field field = (Field) annotation;
                            String value4 = field.value();
                            boolean encoded3 = field.encoded();
                            this.gotField = true;
                            Class<?> rawType6 = Utils.getRawType(type);
                            if (cls2.isAssignableFrom(rawType6)) {
                                if (type instanceof ParameterizedType) {
                                    return new ParameterHandler.Field(value4, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded3).iterable();
                                }
                                throw Utils.parameterError(this.method, i2, rawType6.getSimpleName() + " must include generic type (e.g., " + rawType6.getSimpleName() + "<String>)", new Object[0]);
                            } else if (!rawType6.isArray()) {
                                return new ParameterHandler.Field(value4, this.retrofit.stringConverter(type, annotationArr), encoded3);
                            } else {
                                return new ParameterHandler.Field(value4, this.retrofit.stringConverter(boxIfPrimitive(rawType6.getComponentType()), annotationArr), encoded3).array();
                            }
                        } else {
                            throw Utils.parameterError(this.method, i2, "@Field parameters can only be used with form encoding.", new Object[0]);
                        }
                    } else if (annotation instanceof FieldMap) {
                        validateResolvableType(i2, type);
                        if (this.isFormEncoded) {
                            Class<?> rawType7 = Utils.getRawType(type);
                            if (cls3.isAssignableFrom(rawType7)) {
                                Type supertype3 = Utils.getSupertype(type, rawType7, cls3);
                                if (supertype3 instanceof ParameterizedType) {
                                    ParameterizedType parameterizedType3 = (ParameterizedType) supertype3;
                                    Type parameterUpperBound3 = Utils.getParameterUpperBound(0, parameterizedType3);
                                    if (cls == parameterUpperBound3) {
                                        Converter stringConverter = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType3), annotationArr);
                                        this.gotField = true;
                                        return new ParameterHandler.FieldMap(this.method, i2, stringConverter, ((FieldMap) annotation).encoded());
                                    }
                                    throw Utils.parameterError(this.method, i2, "@FieldMap keys must be of type String: " + parameterUpperBound3, new Object[0]);
                                }
                                throw Utils.parameterError(this.method, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                            }
                            throw Utils.parameterError(this.method, i2, "@FieldMap parameter type must be Map.", new Object[0]);
                        }
                        throw Utils.parameterError(this.method, i2, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                    } else {
                        Class<MultipartBody.Part> cls4 = MultipartBody.Part.class;
                        if (annotation instanceof Part) {
                            validateResolvableType(i2, type);
                            if (this.isMultipart) {
                                Part part = (Part) annotation;
                                this.gotPart = true;
                                String value5 = part.value();
                                Class<?> rawType8 = Utils.getRawType(type);
                                if (!value5.isEmpty()) {
                                    Headers of = Headers.of("Content-Disposition", "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", part.encoding());
                                    if (cls2.isAssignableFrom(rawType8)) {
                                        if (type instanceof ParameterizedType) {
                                            Type parameterUpperBound4 = Utils.getParameterUpperBound(0, (ParameterizedType) type);
                                            if (!cls4.isAssignableFrom(Utils.getRawType(parameterUpperBound4))) {
                                                return new ParameterHandler.Part(this.method, i2, of, this.retrofit.requestBodyConverter(parameterUpperBound4, annotationArr, this.methodAnnotations)).iterable();
                                            }
                                            throw Utils.parameterError(this.method, i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                        }
                                        throw Utils.parameterError(this.method, i2, rawType8.getSimpleName() + " must include generic type (e.g., " + rawType8.getSimpleName() + "<String>)", new Object[0]);
                                    } else if (rawType8.isArray()) {
                                        Class<?> boxIfPrimitive = boxIfPrimitive(rawType8.getComponentType());
                                        if (!cls4.isAssignableFrom(boxIfPrimitive)) {
                                            return new ParameterHandler.Part(this.method, i2, of, this.retrofit.requestBodyConverter(boxIfPrimitive, annotationArr, this.methodAnnotations)).array();
                                        }
                                        throw Utils.parameterError(this.method, i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                    } else if (!cls4.isAssignableFrom(rawType8)) {
                                        return new ParameterHandler.Part(this.method, i2, of, this.retrofit.requestBodyConverter(type, annotationArr, this.methodAnnotations));
                                    } else {
                                        throw Utils.parameterError(this.method, i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                    }
                                } else if (cls2.isAssignableFrom(rawType8)) {
                                    if (!(type instanceof ParameterizedType)) {
                                        throw Utils.parameterError(this.method, i2, rawType8.getSimpleName() + " must include generic type (e.g., " + rawType8.getSimpleName() + "<String>)", new Object[0]);
                                    } else if (cls4.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) type)))) {
                                        return ParameterHandler.RawPart.INSTANCE.iterable();
                                    } else {
                                        throw Utils.parameterError(this.method, i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                    }
                                } else if (rawType8.isArray()) {
                                    if (cls4.isAssignableFrom(rawType8.getComponentType())) {
                                        return ParameterHandler.RawPart.INSTANCE.array();
                                    }
                                    throw Utils.parameterError(this.method, i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                } else if (cls4.isAssignableFrom(rawType8)) {
                                    return ParameterHandler.RawPart.INSTANCE;
                                } else {
                                    throw Utils.parameterError(this.method, i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                }
                            } else {
                                throw Utils.parameterError(this.method, i2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                            }
                        } else if (annotation instanceof PartMap) {
                            validateResolvableType(i2, type);
                            if (this.isMultipart) {
                                this.gotPart = true;
                                Class<?> rawType9 = Utils.getRawType(type);
                                if (cls3.isAssignableFrom(rawType9)) {
                                    Type supertype4 = Utils.getSupertype(type, rawType9, cls3);
                                    if (supertype4 instanceof ParameterizedType) {
                                        ParameterizedType parameterizedType4 = (ParameterizedType) supertype4;
                                        Type parameterUpperBound5 = Utils.getParameterUpperBound(0, parameterizedType4);
                                        if (cls == parameterUpperBound5) {
                                            Type parameterUpperBound6 = Utils.getParameterUpperBound(1, parameterizedType4);
                                            if (!cls4.isAssignableFrom(Utils.getRawType(parameterUpperBound6))) {
                                                return new ParameterHandler.PartMap(this.method, i2, this.retrofit.requestBodyConverter(parameterUpperBound6, annotationArr, this.methodAnnotations), ((PartMap) annotation).encoding());
                                            }
                                            throw Utils.parameterError(this.method, i2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                                        }
                                        throw Utils.parameterError(this.method, i2, "@PartMap keys must be of type String: " + parameterUpperBound5, new Object[0]);
                                    }
                                    throw Utils.parameterError(this.method, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                }
                                throw Utils.parameterError(this.method, i2, "@PartMap parameter type must be Map.", new Object[0]);
                            }
                            throw Utils.parameterError(this.method, i2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                        } else if (annotation instanceof Body) {
                            validateResolvableType(i2, type);
                            if (this.isFormEncoded || this.isMultipart) {
                                throw Utils.parameterError(this.method, i2, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                            } else if (!this.gotBody) {
                                try {
                                    Converter requestBodyConverter = this.retrofit.requestBodyConverter(type, annotationArr, this.methodAnnotations);
                                    this.gotBody = true;
                                    return new ParameterHandler.Body(this.method, i2, requestBodyConverter);
                                } catch (RuntimeException e2) {
                                    throw Utils.parameterError(this.method, e2, i2, "Unable to create @Body converter for %s", type);
                                }
                            } else {
                                throw Utils.parameterError(this.method, i2, "Multiple @Body method annotations found.", new Object[0]);
                            }
                        } else if (!(annotation instanceof Tag)) {
                            return null;
                        } else {
                            validateResolvableType(i2, type);
                            Class<?> rawType10 = Utils.getRawType(type);
                            int i3 = i2 - 1;
                            while (i3 >= 0) {
                                ParameterHandler<?> parameterHandler = this.parameterHandlers[i3];
                                if (!(parameterHandler instanceof ParameterHandler.Tag) || !((ParameterHandler.Tag) parameterHandler).cls.equals(rawType10)) {
                                    i3--;
                                } else {
                                    throw Utils.parameterError(this.method, i2, "@Tag type " + rawType10.getName() + " is duplicate of " + Platform.reflection.describeMethodParameter(this.method, i3) + " and would always overwrite its value.", new Object[0]);
                                }
                            }
                            return new ParameterHandler.Tag(rawType10);
                        }
                    }
                }
            }
        }

        static Set<String> parsePathParameters(String str) {
            Matcher matcher = PARAM_URL_REGEX.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void validatePathName(int i2, String str) {
            if (!PARAM_NAME_REGEX.matcher(str).matches()) {
                throw Utils.parameterError(this.method, i2, "@Path parameter name must match %s. Found: %s", PARAM_URL_REGEX.pattern(), str);
            } else if (!this.relativeUrlParamNames.contains(str)) {
                throw Utils.parameterError(this.method, i2, "URL \"%s\" does not contain \"{%s}\".", this.relativeUrl, str);
            }
        }

        private void validateResolvableType(int i2, Type type) {
            if (Utils.hasUnresolvableType(type)) {
                throw Utils.parameterError(this.method, i2, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        /* access modifiers changed from: package-private */
        public RequestFactory build() {
            for (Annotation parseMethodAnnotation : this.methodAnnotations) {
                parseMethodAnnotation(parseMethodAnnotation);
            }
            if (this.httpMethod != null) {
                if (!this.hasBody) {
                    if (this.isMultipart) {
                        throw Utils.methodError(this.method, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.isFormEncoded) {
                        throw Utils.methodError(this.method, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.parameterAnnotationsArray.length;
                this.parameterHandlers = new ParameterHandler[length];
                int i2 = length - 1;
                int i3 = 0;
                while (true) {
                    boolean z2 = true;
                    if (i3 >= length) {
                        break;
                    }
                    ParameterHandler<?>[] parameterHandlerArr = this.parameterHandlers;
                    Type type = this.parameterTypes[i3];
                    Annotation[] annotationArr = this.parameterAnnotationsArray[i3];
                    if (i3 != i2) {
                        z2 = false;
                    }
                    parameterHandlerArr[i3] = parseParameter(i3, type, annotationArr, z2);
                    i3++;
                }
                if (this.relativeUrl != null || this.gotUrl) {
                    boolean z3 = this.isFormEncoded;
                    if (!z3 && !this.isMultipart && !this.hasBody && this.gotBody) {
                        throw Utils.methodError(this.method, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                    } else if (z3 && !this.gotField) {
                        throw Utils.methodError(this.method, "Form-encoded method must contain at least one @Field.", new Object[0]);
                    } else if (!this.isMultipart || this.gotPart) {
                        return new RequestFactory(this);
                    } else {
                        throw Utils.methodError(this.method, "Multipart method must contain at least one @Part.", new Object[0]);
                    }
                } else {
                    throw Utils.methodError(this.method, "Missing either @%s URL or @Url parameter.", this.httpMethod);
                }
            } else {
                throw Utils.methodError(this.method, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }
    }

    RequestFactory(Builder builder) {
        this.service = builder.service;
        this.method = builder.method;
        this.baseUrl = builder.retrofit.baseUrl;
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.hasBody = builder.hasBody;
        this.isFormEncoded = builder.isFormEncoded;
        this.isMultipart = builder.isMultipart;
        this.parameterHandlers = builder.parameterHandlers;
        this.isKotlinSuspendFunction = builder.isKotlinSuspendFunction;
    }

    static RequestFactory parseAnnotations(Retrofit retrofit, Class<?> cls, Method method2) {
        return new Builder(retrofit, cls, method2).build();
    }

    /* access modifiers changed from: package-private */
    public Request create(Object obj, Object[] objArr) throws IOException {
        ParameterHandler<?>[] parameterHandlerArr = this.parameterHandlers;
        int length = objArr.length;
        if (length == parameterHandlerArr.length) {
            RequestBuilder requestBuilder = new RequestBuilder(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
            if (this.isKotlinSuspendFunction) {
                length--;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(objArr[i2]);
                parameterHandlerArr[i2].apply(requestBuilder, objArr[i2]);
            }
            return requestBuilder.get().tag(Invocation.class, new Invocation(this.service, obj, this.method, arrayList)).build();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + parameterHandlerArr.length + ")");
    }
}
