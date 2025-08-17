package okhttp3.internal.http;

import com.vungle.ads.internal.ui.AdActivity;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;

public final class RealInterceptorChain implements Interceptor.Chain {
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;
    private final Request request;
    private final int writeTimeoutMillis;

    public RealInterceptorChain(RealCall realCall, List<? extends Interceptor> list, int i2, Exchange exchange2, Request request2, int i3, int i4, int i5) {
        Intrinsics.f(realCall, "call");
        Intrinsics.f(list, "interceptors");
        Intrinsics.f(request2, AdActivity.REQUEST_KEY_EXTRA);
        this.call = realCall;
        this.interceptors = list;
        this.index = i2;
        this.exchange = exchange2;
        this.request = request2;
        this.connectTimeoutMillis = i3;
        this.readTimeoutMillis = i4;
        this.writeTimeoutMillis = i5;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i2, Exchange exchange2, Request request2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = realInterceptorChain.index;
        }
        if ((i6 & 2) != 0) {
            exchange2 = realInterceptorChain.exchange;
        }
        Exchange exchange3 = exchange2;
        if ((i6 & 4) != 0) {
            request2 = realInterceptorChain.request;
        }
        Request request3 = request2;
        if ((i6 & 8) != 0) {
            i3 = realInterceptorChain.connectTimeoutMillis;
        }
        int i7 = i3;
        if ((i6 & 16) != 0) {
            i4 = realInterceptorChain.readTimeoutMillis;
        }
        int i8 = i4;
        if ((i6 & 32) != 0) {
            i5 = realInterceptorChain.writeTimeoutMillis;
        }
        return realInterceptorChain.copy$okhttp(i2, exchange3, request3, i7, i8, i5);
    }

    public Call call() {
        return this.call;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public Connection connection() {
        Exchange exchange2 = this.exchange;
        if (exchange2 != null) {
            return exchange2.getConnection$okhttp();
        }
        return null;
    }

    public final RealInterceptorChain copy$okhttp(int i2, Exchange exchange2, Request request2, int i3, int i4, int i5) {
        Intrinsics.f(request2, AdActivity.REQUEST_KEY_EXTRA);
        return new RealInterceptorChain(this.call, this.interceptors, i2, exchange2, request2, i3, i4, i5);
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    public Response proceed(Request request2) throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.f(request2, AdActivity.REQUEST_KEY_EXTRA);
        boolean z5 = false;
        if (this.index < this.interceptors.size()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.calls++;
            Exchange exchange2 = this.exchange;
            if (exchange2 != null) {
                if (exchange2.getFinder$okhttp().sameHostAndPort(request2.url())) {
                    if (this.calls == 1) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
                    }
                } else {
                    throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
                }
            }
            RealInterceptorChain copy$okhttp$default = copy$okhttp$default(this, this.index + 1, (Exchange) null, request2, 0, 0, 0, 58, (Object) null);
            Interceptor interceptor = this.interceptors.get(this.index);
            Response intercept = interceptor.intercept(copy$okhttp$default);
            if (intercept != null) {
                if (this.exchange != null) {
                    if (this.index + 1 >= this.interceptors.size() || copy$okhttp$default.calls == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
                    }
                }
                if (intercept.body() != null) {
                    z5 = true;
                }
                if (z5) {
                    return intercept;
                }
                throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
            }
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public Request request() {
        return this.request;
    }

    public Interceptor.Chain withConnectTimeout(int i2, TimeUnit timeUnit) {
        boolean z2;
        Intrinsics.f(timeUnit, "unit");
        if (this.exchange == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return copy$okhttp$default(this, 0, (Exchange) null, (Request) null, Util.checkDuration("connectTimeout", (long) i2, timeUnit), 0, 0, 55, (Object) null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    public Interceptor.Chain withReadTimeout(int i2, TimeUnit timeUnit) {
        boolean z2;
        Intrinsics.f(timeUnit, "unit");
        if (this.exchange == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return copy$okhttp$default(this, 0, (Exchange) null, (Request) null, 0, Util.checkDuration("readTimeout", (long) i2, timeUnit), 0, 47, (Object) null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    public Interceptor.Chain withWriteTimeout(int i2, TimeUnit timeUnit) {
        boolean z2;
        Intrinsics.f(timeUnit, "unit");
        if (this.exchange == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return copy$okhttp$default(this, 0, (Exchange) null, (Request) null, 0, 0, Util.checkDuration("writeTimeout", (long) i2, timeUnit), 31, (Object) null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
