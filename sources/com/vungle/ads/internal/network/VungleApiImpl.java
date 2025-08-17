package com.vungle.ads.internal.network;

import com.google.android.gms.common.internal.ImagesContract;
import com.uwetrottmann.trakt5.TraktV2;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.network.converters.EmptyResponseConverter;
import com.vungle.ads.internal.network.converters.JsonConverter;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public final class VungleApiImpl implements VungleApi {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String VUNGLE_VERSION = "7.1.0";
    private static final Json json = JsonKt.b((Json) null, VungleApiImpl$Companion$json$1.INSTANCE, 1, (Object) null);
    private String appId;
    private final EmptyResponseConverter emptyResponseConverter = new EmptyResponseConverter();
    private final Call.Factory okHttpClient;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            iArr[HttpMethod.GET.ordinal()] = 1;
            iArr[HttpMethod.POST.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public VungleApiImpl(Call.Factory factory) {
        Intrinsics.f(factory, "okHttpClient");
        this.okHttpClient = factory;
    }

    private final Request.Builder defaultBuilder(String str, String str2, String str3, Map<String, String> map) {
        Request.Builder addHeader = new Request.Builder().url(str2).addHeader("User-Agent", str).addHeader("Vungle-Version", VUNGLE_VERSION).addHeader(TraktV2.HEADER_CONTENT_TYPE, TraktV2.CONTENT_TYPE_JSON);
        String str4 = this.appId;
        if (str4 != null) {
            addHeader.addHeader("X-Vungle-App-Id", str4);
        }
        if (map != null) {
            addHeader.headers(Headers.Companion.of(map));
        }
        if (str3 != null) {
            addHeader.addHeader("X-Vungle-Placement-Ref-Id", str3);
        }
        return addHeader;
    }

    static /* synthetic */ Request.Builder defaultBuilder$default(VungleApiImpl vungleApiImpl, String str, String str2, String str3, Map map, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        if ((i2 & 8) != 0) {
            map = null;
        }
        return vungleApiImpl.defaultBuilder(str, str2, str3, map);
    }

    private final Request.Builder defaultProtoBufBuilder(String str, String str2) {
        Request.Builder addHeader = new Request.Builder().url(str2).addHeader("User-Agent", str).addHeader("Vungle-Version", VUNGLE_VERSION).addHeader(TraktV2.HEADER_CONTENT_TYPE, "application/x-protobuf");
        String str3 = this.appId;
        if (str3 != null) {
            addHeader.addHeader("X-Vungle-App-Id", str3);
        }
        return addHeader;
    }

    public Call<AdPayload> ads(String str, String str2, CommonRequestBody commonRequestBody) {
        String str3;
        List<String> placements;
        Intrinsics.f(str, "ua");
        Intrinsics.f(str2, "path");
        Intrinsics.f(commonRequestBody, "body");
        try {
            Json json2 = json;
            KSerializer<Object> b2 = SerializersKt.b(json2.a(), Reflection.h(CommonRequestBody.class));
            Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            String c2 = json2.c(b2, commonRequestBody);
            CommonRequestBody.RequestParam request = commonRequestBody.getRequest();
            if (request == null || (placements = request.getPlacements()) == null) {
                str3 = null;
            } else {
                str3 = (String) CollectionsKt___CollectionsKt.D(placements);
            }
            return new OkHttpCall(this.okHttpClient.newCall(defaultBuilder$default(this, str, str2, str3, (Map) null, 8, (Object) null).post(RequestBody.Companion.create(c2, (MediaType) null)).build()), new JsonConverter(Reflection.h(AdPayload.class)));
        } catch (Exception unused) {
            return null;
        }
    }

    public Call<ConfigPayload> config(String str, String str2, CommonRequestBody commonRequestBody) {
        Intrinsics.f(str, "ua");
        Intrinsics.f(str2, "path");
        Intrinsics.f(commonRequestBody, "body");
        try {
            Json json2 = json;
            KSerializer<Object> b2 = SerializersKt.b(json2.a(), Reflection.h(CommonRequestBody.class));
            Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return new OkHttpCall(this.okHttpClient.newCall(defaultBuilder$default(this, str, str2, (String) null, (Map) null, 12, (Object) null).post(RequestBody.Companion.create(json2.c(b2, commonRequestBody), (MediaType) null)).build()), new JsonConverter(Reflection.h(ConfigPayload.class)));
        } catch (Exception unused) {
            return null;
        }
    }

    public final Call.Factory getOkHttpClient$vungle_ads_release() {
        return this.okHttpClient;
    }

    public Call<Void> pingTPAT(String str, String str2, HttpMethod httpMethod, Map<String, String> map, RequestBody requestBody) {
        Request request;
        Intrinsics.f(str, "ua");
        Intrinsics.f(str2, ImagesContract.URL);
        Intrinsics.f(httpMethod, "requestType");
        Request.Builder defaultBuilder$default = defaultBuilder$default(this, str, HttpUrl.Companion.get(str2).newBuilder().build().toString(), (String) null, map, 4, (Object) null);
        int i2 = WhenMappings.$EnumSwitchMapping$0[httpMethod.ordinal()];
        if (i2 == 1) {
            request = defaultBuilder$default.get().build();
        } else if (i2 == 2) {
            if (requestBody == null) {
                requestBody = RequestBody.Companion.create$default(RequestBody.Companion, new byte[0], (MediaType) null, 0, 0, 6, (Object) null);
            }
            request = defaultBuilder$default.post(requestBody).build();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new OkHttpCall(this.okHttpClient.newCall(request), this.emptyResponseConverter);
    }

    public Call<Void> ri(String str, String str2, CommonRequestBody commonRequestBody) {
        Intrinsics.f(str, "ua");
        Intrinsics.f(str2, "path");
        Intrinsics.f(commonRequestBody, "body");
        try {
            Json json2 = json;
            KSerializer<Object> b2 = SerializersKt.b(json2.a(), Reflection.h(CommonRequestBody.class));
            Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return new OkHttpCall(this.okHttpClient.newCall(defaultBuilder$default(this, str, str2, (String) null, (Map) null, 12, (Object) null).post(RequestBody.Companion.create(json2.c(b2, commonRequestBody), (MediaType) null)).build()), this.emptyResponseConverter);
        } catch (Exception unused) {
            return null;
        }
    }

    public Call<Void> sendAdMarkup(String str, RequestBody requestBody) {
        Intrinsics.f(str, "path");
        Intrinsics.f(requestBody, "requestBody");
        return new OkHttpCall(this.okHttpClient.newCall(defaultBuilder$default(this, "debug", HttpUrl.Companion.get(str).newBuilder().build().toString(), (String) null, (Map) null, 12, (Object) null).post(requestBody).build()), this.emptyResponseConverter);
    }

    public Call<Void> sendErrors(String str, String str2, RequestBody requestBody) {
        Intrinsics.f(str, "ua");
        Intrinsics.f(str2, "path");
        Intrinsics.f(requestBody, "requestBody");
        return new OkHttpCall(this.okHttpClient.newCall(defaultProtoBufBuilder(str, HttpUrl.Companion.get(str2).newBuilder().build().toString()).post(requestBody).build()), this.emptyResponseConverter);
    }

    public Call<Void> sendMetrics(String str, String str2, RequestBody requestBody) {
        Intrinsics.f(str, "ua");
        Intrinsics.f(str2, "path");
        Intrinsics.f(requestBody, "requestBody");
        return new OkHttpCall(this.okHttpClient.newCall(defaultProtoBufBuilder(str, HttpUrl.Companion.get(str2).newBuilder().build().toString()).post(requestBody).build()), this.emptyResponseConverter);
    }

    public void setAppId(String str) {
        Intrinsics.f(str, "appId");
        this.appId = str;
    }
}
