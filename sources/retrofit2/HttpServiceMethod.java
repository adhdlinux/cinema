package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.coroutines.Continuation;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Utils;

abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    private final Call.Factory callFactory;
    private final RequestFactory requestFactory;
    private final Converter<ResponseBody, ResponseT> responseConverter;

    static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> callAdapter;

        CallAdapted(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, ReturnT> callAdapter2) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter2;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [retrofit2.Call, retrofit2.Call<ResponseT>] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ReturnT adapt(retrofit2.Call<ResponseT> r1, java.lang.Object[] r2) {
            /*
                r0 = this;
                retrofit2.CallAdapter<ResponseT, ReturnT> r2 = r0.callAdapter
                java.lang.Object r1 = r2.adapt(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit2.HttpServiceMethod.CallAdapted.adapt(retrofit2.Call, java.lang.Object[]):java.lang.Object");
        }
    }

    static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        private final boolean isNullable;
        private final boolean isUnit;

        SuspendForBody(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter2, boolean z2, boolean z3) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter2;
            this.isNullable = z2;
            this.isUnit = z3;
        }

        /* access modifiers changed from: protected */
        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call call2 = (Call) this.callAdapter.adapt(call);
            Continuation continuation = objArr[objArr.length - 1];
            try {
                if (this.isUnit) {
                    return KotlinExtensions.awaitUnit(call2, continuation);
                }
                if (this.isNullable) {
                    return KotlinExtensions.awaitNullable(call2, continuation);
                }
                return KotlinExtensions.await(call2, continuation);
            } catch (LinkageError | ThreadDeath | VirtualMachineError e2) {
                throw e2;
            } catch (Throwable th) {
                return KotlinExtensions.suspendAndThrow(th, continuation);
            }
        }
    }

    static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        SuspendForResponse(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter2) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter2;
        }

        /* access modifiers changed from: protected */
        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call call2 = (Call) this.callAdapter.adapt(call);
            Continuation continuation = objArr[objArr.length - 1];
            try {
                return KotlinExtensions.awaitResponse(call2, continuation);
            } catch (Exception e2) {
                return KotlinExtensions.suspendAndThrow(e2, continuation);
            }
        }
    }

    HttpServiceMethod(RequestFactory requestFactory2, Call.Factory factory, Converter<ResponseBody, ResponseT> converter) {
        this.requestFactory = requestFactory2;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit retrofit, Method method, Type type, Annotation[] annotationArr) {
        try {
            return retrofit.callAdapter(type, annotationArr);
        } catch (RuntimeException e2) {
            throw Utils.methodError(method, e2, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> Converter<ResponseBody, ResponseT> createResponseConverter(Retrofit retrofit, Method method, Type type) {
        try {
            return retrofit.responseBodyConverter(type, method.getAnnotations());
        } catch (RuntimeException e2) {
            throw Utils.methodError(method, e2, "Unable to create converter for %s", type);
        }
    }

    static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit retrofit, Method method, RequestFactory requestFactory2) {
        Type type;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = requestFactory2.isKotlinSuspendFunction;
        Annotation[] annotations = method.getAnnotations();
        Class<Response> cls = Response.class;
        if (z5) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type parameterLowerBound = Utils.getParameterLowerBound(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            Class<Call> cls2 = Call.class;
            if (Utils.getRawType(parameterLowerBound) == cls && (parameterLowerBound instanceof ParameterizedType)) {
                parameterLowerBound = Utils.getParameterUpperBound(0, (ParameterizedType) parameterLowerBound);
                z4 = false;
                z2 = true;
            } else if (Utils.getRawType(parameterLowerBound) != cls2) {
                z4 = Utils.isUnit(parameterLowerBound);
                z2 = false;
            } else {
                throw Utils.methodError(method, "Suspend functions should not return Call, as they already execute asynchronously.\nChange its return type to %s", Utils.getParameterUpperBound(0, (ParameterizedType) parameterLowerBound));
            }
            type = new Utils.ParameterizedTypeImpl((Type) null, cls2, parameterLowerBound);
            annotations = SkipCallbackExecutorImpl.ensurePresent(annotations);
            z3 = z4;
        } else {
            type = method.getGenericReturnType();
            z3 = false;
            z2 = false;
        }
        CallAdapter createCallAdapter = createCallAdapter(retrofit, method, type, annotations);
        Type responseType = createCallAdapter.responseType();
        if (responseType == Response.class) {
            throw Utils.methodError(method, "'" + Utils.getRawType(responseType).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        } else if (responseType == cls) {
            throw Utils.methodError(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        } else if (!requestFactory2.httpMethod.equals("HEAD") || Void.class.equals(responseType) || Utils.isUnit(responseType)) {
            Converter createResponseConverter = createResponseConverter(retrofit, method, responseType);
            Call.Factory factory = retrofit.callFactory;
            if (!z5) {
                return new CallAdapted(requestFactory2, factory, createResponseConverter, createCallAdapter);
            }
            if (z2) {
                return new SuspendForResponse(requestFactory2, factory, createResponseConverter, createCallAdapter);
            }
            return new SuspendForBody(requestFactory2, factory, createResponseConverter, createCallAdapter, false, z3);
        } else {
            throw Utils.methodError(method, "HEAD method must use Void or Unit as response type.", new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public abstract ReturnT adapt(Call<ResponseT> call, Object[] objArr);

    /* access modifiers changed from: package-private */
    public final ReturnT invoke(Object obj, Object[] objArr) {
        return adapt(new OkHttpCall(this.requestFactory, obj, objArr, this.callFactory, this.responseConverter), objArr);
    }
}
