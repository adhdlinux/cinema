package okhttp3.internal.cache;

import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.AdActivity;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

public final class CacheStrategy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Response cacheResponse;
    private final Request networkRequest;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isCacheable(Response response, Request request) {
            Intrinsics.f(response, "response");
            Intrinsics.f(request, AdActivity.REQUEST_KEY_EXTRA);
            int code = response.code();
            if (!(code == 200 || code == 410 || code == 414 || code == 501 || code == 203 || code == 204)) {
                if (code != 307) {
                    if (!(code == 308 || code == 404 || code == 405)) {
                        switch (code) {
                            case 300:
                            case 301:
                                break;
                            case INVALID_IFA_STATUS_VALUE:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (Response.header$default(response, "Expires", (String) null, 2, (Object) null) == null && response.cacheControl().maxAgeSeconds() == -1 && !response.cacheControl().isPublic() && !response.cacheControl().isPrivate()) {
                    return false;
                }
            }
            if (response.cacheControl().noStore() || request.cacheControl().noStore()) {
                return false;
            }
            return true;
        }
    }

    public static final class Factory {
        private int ageSeconds = -1;
        private final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private final long nowMillis;
        private long receivedResponseMillis;
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long j2, Request request2, Response response) {
            Intrinsics.f(request2, AdActivity.REQUEST_KEY_EXTRA);
            this.nowMillis = j2;
            this.request = request2;
            this.cacheResponse = response;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String name = headers.name(i2);
                    String value = headers.value(i2);
                    if (StringsKt__StringsJVMKt.t(name, "Date", true)) {
                        this.servedDate = DatesKt.toHttpDateOrNull(value);
                        this.servedDateString = value;
                    } else if (StringsKt__StringsJVMKt.t(name, "Expires", true)) {
                        this.expires = DatesKt.toHttpDateOrNull(value);
                    } else if (StringsKt__StringsJVMKt.t(name, "Last-Modified", true)) {
                        this.lastModified = DatesKt.toHttpDateOrNull(value);
                        this.lastModifiedString = value;
                    } else if (StringsKt__StringsJVMKt.t(name, "ETag", true)) {
                        this.etag = value;
                    } else if (StringsKt__StringsJVMKt.t(name, "Age", true)) {
                        this.ageSeconds = Util.toNonNegativeInt(value, -1);
                    }
                }
            }
        }

        private final long cacheResponseAge() {
            Date date = this.servedDate;
            long j2 = 0;
            if (date != null) {
                j2 = Math.max(0, this.receivedResponseMillis - date.getTime());
            }
            int i2 = this.ageSeconds;
            if (i2 != -1) {
                j2 = Math.max(j2, TimeUnit.SECONDS.toMillis((long) i2));
            }
            long j3 = this.receivedResponseMillis;
            return j2 + (j3 - this.sentRequestMillis) + (this.nowMillis - j3);
        }

        private final CacheStrategy computeCandidate() {
            long j2;
            String str;
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, (Response) null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, (Response) null);
            }
            if (!CacheStrategy.Companion.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, (Response) null);
            }
            CacheControl cacheControl = this.request.cacheControl();
            if (cacheControl.noCache() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, (Response) null);
            }
            CacheControl cacheControl2 = this.cacheResponse.cacheControl();
            long cacheResponseAge = cacheResponseAge();
            long computeFreshnessLifetime = computeFreshnessLifetime();
            if (cacheControl.maxAgeSeconds() != -1) {
                computeFreshnessLifetime = Math.min(computeFreshnessLifetime, TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds()));
            }
            long j3 = 0;
            if (cacheControl.minFreshSeconds() != -1) {
                j2 = TimeUnit.SECONDS.toMillis((long) cacheControl.minFreshSeconds());
            } else {
                j2 = 0;
            }
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                j3 = TimeUnit.SECONDS.toMillis((long) cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j4 = j2 + cacheResponseAge;
                if (j4 < j3 + computeFreshnessLifetime) {
                    Response.Builder newBuilder = this.cacheResponse.newBuilder();
                    if (j4 >= computeFreshnessLifetime) {
                        newBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (cacheResponseAge > SignalManager.TWENTY_FOUR_HOURS_MILLIS && isFreshnessLifetimeHeuristic()) {
                        newBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy((Request) null, newBuilder.build());
                }
            }
            String str2 = this.etag;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.lastModified != null) {
                    str2 = this.lastModifiedString;
                } else if (this.servedDate == null) {
                    return new CacheStrategy(this.request, (Response) null);
                } else {
                    str2 = this.servedDateString;
                }
                str = "If-Modified-Since";
            }
            Headers.Builder newBuilder2 = this.request.headers().newBuilder();
            Intrinsics.c(str2);
            newBuilder2.addLenient$okhttp(str, str2);
            return new CacheStrategy(this.request.newBuilder().headers(newBuilder2.build()).build(), this.cacheResponse);
        }

        private final long computeFreshnessLifetime() {
            long j2;
            long j3;
            Response response = this.cacheResponse;
            Intrinsics.c(response);
            CacheControl cacheControl = response.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds());
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                if (date2 != null) {
                    j3 = date2.getTime();
                } else {
                    j3 = this.receivedResponseMillis;
                }
                long time = date.getTime() - j3;
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.lastModified == null || this.cacheResponse.request().url().query() != null) {
                return 0;
            } else {
                Date date3 = this.servedDate;
                if (date3 != null) {
                    j2 = date3.getTime();
                } else {
                    j2 = this.sentRequestMillis;
                }
                Date date4 = this.lastModified;
                Intrinsics.c(date4);
                long time2 = j2 - date4.getTime();
                if (time2 > 0) {
                    return time2 / ((long) 10);
                }
                return 0;
            }
        }

        private final boolean hasConditions(Request request2) {
            if (request2.header("If-Modified-Since") == null && request2.header("If-None-Match") == null) {
                return false;
            }
            return true;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            Response response = this.cacheResponse;
            Intrinsics.c(response);
            return response.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        public final CacheStrategy compute() {
            CacheStrategy computeCandidate = computeCandidate();
            if (computeCandidate.getNetworkRequest() == null || !this.request.cacheControl().onlyIfCached()) {
                return computeCandidate;
            }
            return new CacheStrategy((Request) null, (Response) null);
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }
    }

    public CacheStrategy(Request request, Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    public final Request getNetworkRequest() {
        return this.networkRequest;
    }
}
