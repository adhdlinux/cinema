package retrofit2;

import java.io.IOException;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Timeout;

final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final Call.Factory callFactory;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private final Object instance;
    private Call rawCall;
    private final RequestFactory requestFactory;
    private final Converter<ResponseBody, T> responseConverter;

    static final class ExceptionCatchingResponseBody extends ResponseBody {
        private final ResponseBody delegate;
        private final BufferedSource delegateSource;
        IOException thrownException;

        ExceptionCatchingResponseBody(ResponseBody responseBody) {
            this.delegate = responseBody;
            this.delegateSource = Okio.d(new ForwardingSource(responseBody.source()) {
                public long read(Buffer buffer, long j2) throws IOException {
                    try {
                        return super.read(buffer, j2);
                    } catch (IOException e2) {
                        ExceptionCatchingResponseBody.this.thrownException = e2;
                        throw e2;
                    }
                }
            });
        }

        public void close() {
            this.delegate.close();
        }

        public long contentLength() {
            return this.delegate.contentLength();
        }

        public MediaType contentType() {
            return this.delegate.contentType();
        }

        public BufferedSource source() {
            return this.delegateSource;
        }

        /* access modifiers changed from: package-private */
        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    static final class NoContentResponseBody extends ResponseBody {
        private final long contentLength;
        private final MediaType contentType;

        NoContentResponseBody(MediaType mediaType, long j2) {
            this.contentType = mediaType;
            this.contentLength = j2;
        }

        public long contentLength() {
            return this.contentLength;
        }

        public MediaType contentType() {
            return this.contentType;
        }

        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    OkHttpCall(RequestFactory requestFactory2, Object obj, Object[] objArr, Call.Factory factory, Converter<ResponseBody, T> converter) {
        this.requestFactory = requestFactory2;
        this.instance = obj;
        this.args = objArr;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    private Call createRawCall() throws IOException {
        Call newCall = this.callFactory.newCall(this.requestFactory.create(this.instance, this.args));
        if (newCall != null) {
            return newCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    private Call getRawCall() throws IOException {
        Call call = this.rawCall;
        if (call != null) {
            return call;
        }
        Throwable th = this.creationFailure;
        if (th == null) {
            try {
                Call createRawCall = createRawCall();
                this.rawCall = createRawCall;
                return createRawCall;
            } catch (IOException | Error | RuntimeException e2) {
                Utils.throwIfFatal(e2);
                this.creationFailure = e2;
                throw e2;
            }
        } else if (th instanceof IOException) {
            throw ((IOException) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw ((Error) th);
        }
    }

    public void cancel() {
        Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public void enqueue(final Callback<T> callback) {
        Call call;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                call = this.rawCall;
                th = this.creationFailure;
                if (call == null && th == null) {
                    try {
                        Call createRawCall = createRawCall();
                        this.rawCall = createRawCall;
                        call = createRawCall;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.throwIfFatal(th);
                        this.creationFailure = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            call.cancel();
        }
        call.enqueue(new Callback() {
            private void callFailure(Throwable th) {
                try {
                    callback.onFailure(OkHttpCall.this, th);
                } catch (Throwable th2) {
                    Utils.throwIfFatal(th2);
                    th2.printStackTrace();
                }
            }

            public void onFailure(Call call, IOException iOException) {
                callFailure(iOException);
            }

            public void onResponse(Call call, Response response) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(response));
                    } catch (Throwable th) {
                        Utils.throwIfFatal(th);
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    Utils.throwIfFatal(th2);
                    callFailure(th2);
                }
            }
        });
    }

    public Response<T> execute() throws IOException {
        Call rawCall2;
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                rawCall2 = getRawCall();
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.canceled) {
            rawCall2.cancel();
        }
        return parseResponse(rawCall2.execute());
    }

    public boolean isCanceled() {
        boolean z2 = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            Call call = this.rawCall;
            if (call == null || !call.isCanceled()) {
                z2 = false;
            }
        }
        return z2;
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    /* access modifiers changed from: package-private */
    public Response<T> parseResponse(Response response) throws IOException {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new NoContentResponseBody(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return Response.error(Utils.buffer(body), build);
            } finally {
                body.close();
            }
        } else if (code == 204 || code == 205) {
            body.close();
            return Response.success(null, build);
        } else {
            ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(body);
            try {
                return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), build);
            } catch (RuntimeException e2) {
                exceptionCatchingResponseBody.throwIfCaught();
                throw e2;
            }
        }
    }

    public synchronized Request request() {
        try {
        } catch (IOException e2) {
            throw new RuntimeException("Unable to create request.", e2);
        }
        return getRawCall().request();
    }

    public synchronized Timeout timeout() {
        try {
        } catch (IOException e2) {
            throw new RuntimeException("Unable to create call.", e2);
        }
        return getRawCall().timeout();
    }

    public OkHttpCall<T> clone() {
        return new OkHttpCall(this.requestFactory, this.instance, this.args, this.callFactory, this.responseConverter);
    }
}
