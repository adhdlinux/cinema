package com.unity3d.services.core.network.model;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class HttpRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_SCHEME = "https";
    private static final int DEFAULT_TIMEOUT = 30000;
    private final String baseURL;
    private final Object body;
    private final BodyType bodyType;
    private final int callTimeout;
    private final int connectTimeout;
    private final Map<String, List<String>> headers;
    private final RequestType method;
    private final Map<String, String> parameters;
    private final String path;
    private final Integer port;
    private final int readTimeout;
    private final String scheme;
    private final int writeTimeout;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8190(0x1ffe, float:1.1477E-41)
            r16 = 0
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8188(0x1ffc, float:1.1474E-41)
            r16 = 0
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8184(0x1ff8, float:1.1468E-41)
            r16 = 0
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8176(0x1ff0, float:1.1457E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8160(0x1fe0, float:1.1435E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8128(0x1fc0, float:1.139E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23, com.unity3d.services.core.network.model.BodyType r24) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            java.lang.String r0 = "bodyType"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8064(0x1f80, float:1.13E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23, com.unity3d.services.core.network.model.BodyType r24, java.lang.String r25) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            java.lang.String r0 = "bodyType"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "scheme"
            r9 = r25
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 7936(0x1f00, float:1.1121E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23, com.unity3d.services.core.network.model.BodyType r24, java.lang.String r25, java.lang.Integer r26) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            java.lang.String r0 = "bodyType"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "scheme"
            r9 = r25
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 7680(0x1e00, float:1.0762E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r10 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType, java.lang.String, java.lang.Integer):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23, com.unity3d.services.core.network.model.BodyType r24, java.lang.String r25, java.lang.Integer r26, int r27) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            java.lang.String r0 = "bodyType"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "scheme"
            r9 = r25
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 7168(0x1c00, float:1.0045E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r10 = r26
            r11 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType, java.lang.String, java.lang.Integer, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23, com.unity3d.services.core.network.model.BodyType r24, java.lang.String r25, java.lang.Integer r26, int r27, int r28) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            java.lang.String r0 = "bodyType"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "scheme"
            r9 = r25
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            r13 = 0
            r14 = 0
            r15 = 6144(0x1800, float:8.61E-42)
            r16 = 0
            r1 = r17
            r5 = r21
            r10 = r26
            r11 = r27
            r12 = r28
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType, java.lang.String, java.lang.Integer, int, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23, com.unity3d.services.core.network.model.BodyType r24, java.lang.String r25, java.lang.Integer r26, int r27, int r28, int r29) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            java.lang.String r0 = "bodyType"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "scheme"
            r9 = r25
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            r14 = 0
            r15 = 4096(0x1000, float:5.74E-42)
            r16 = 0
            r1 = r17
            r5 = r21
            r10 = r26
            r11 = r27
            r12 = r28
            r13 = r29
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType, java.lang.String, java.lang.Integer, int, int, int):void");
    }

    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2, String str3, Integer num, int i2, int i3, int i4, int i5) {
        Intrinsics.f(str, "baseURL");
        Intrinsics.f(str2, "path");
        Intrinsics.f(requestType, "method");
        Intrinsics.f(map, "headers");
        Intrinsics.f(map2, "parameters");
        Intrinsics.f(bodyType2, "bodyType");
        Intrinsics.f(str3, "scheme");
        this.baseURL = str;
        this.path = str2;
        this.method = requestType;
        this.body = obj;
        this.headers = map;
        this.parameters = map2;
        this.bodyType = bodyType2;
        this.scheme = str3;
        this.port = num;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
        this.callTimeout = i5;
    }

    public static /* synthetic */ HttpRequest copy$default(HttpRequest httpRequest, String str, String str2, RequestType requestType, Object obj, Map map, Map map2, BodyType bodyType2, String str3, Integer num, int i2, int i3, int i4, int i5, int i6, Object obj2) {
        HttpRequest httpRequest2 = httpRequest;
        int i7 = i6;
        return httpRequest.copy((i7 & 1) != 0 ? httpRequest2.baseURL : str, (i7 & 2) != 0 ? httpRequest2.path : str2, (i7 & 4) != 0 ? httpRequest2.method : requestType, (i7 & 8) != 0 ? httpRequest2.body : obj, (i7 & 16) != 0 ? httpRequest2.headers : map, (i7 & 32) != 0 ? httpRequest2.parameters : map2, (i7 & 64) != 0 ? httpRequest2.bodyType : bodyType2, (i7 & 128) != 0 ? httpRequest2.scheme : str3, (i7 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0 ? httpRequest2.port : num, (i7 & 512) != 0 ? httpRequest2.connectTimeout : i2, (i7 & 1024) != 0 ? httpRequest2.readTimeout : i3, (i7 & 2048) != 0 ? httpRequest2.writeTimeout : i4, (i7 & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0 ? httpRequest2.callTimeout : i5);
    }

    public final String component1() {
        return this.baseURL;
    }

    public final int component10() {
        return this.connectTimeout;
    }

    public final int component11() {
        return this.readTimeout;
    }

    public final int component12() {
        return this.writeTimeout;
    }

    public final int component13() {
        return this.callTimeout;
    }

    public final String component2() {
        return this.path;
    }

    public final RequestType component3() {
        return this.method;
    }

    public final Object component4() {
        return this.body;
    }

    public final Map<String, List<String>> component5() {
        return this.headers;
    }

    public final Map<String, String> component6() {
        return this.parameters;
    }

    public final BodyType component7() {
        return this.bodyType;
    }

    public final String component8() {
        return this.scheme;
    }

    public final Integer component9() {
        return this.port;
    }

    public final HttpRequest copy(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2, String str3, Integer num, int i2, int i3, int i4, int i5) {
        String str4 = str;
        Intrinsics.f(str4, "baseURL");
        String str5 = str2;
        Intrinsics.f(str5, "path");
        RequestType requestType2 = requestType;
        Intrinsics.f(requestType2, "method");
        Map<String, ? extends List<String>> map3 = map;
        Intrinsics.f(map3, "headers");
        Map<String, String> map4 = map2;
        Intrinsics.f(map4, "parameters");
        BodyType bodyType3 = bodyType2;
        Intrinsics.f(bodyType3, "bodyType");
        String str6 = str3;
        Intrinsics.f(str6, "scheme");
        return new HttpRequest(str4, str5, requestType2, obj, map3, map4, bodyType3, str6, num, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRequest)) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        return Intrinsics.a(this.baseURL, httpRequest.baseURL) && Intrinsics.a(this.path, httpRequest.path) && this.method == httpRequest.method && Intrinsics.a(this.body, httpRequest.body) && Intrinsics.a(this.headers, httpRequest.headers) && Intrinsics.a(this.parameters, httpRequest.parameters) && this.bodyType == httpRequest.bodyType && Intrinsics.a(this.scheme, httpRequest.scheme) && Intrinsics.a(this.port, httpRequest.port) && this.connectTimeout == httpRequest.connectTimeout && this.readTimeout == httpRequest.readTimeout && this.writeTimeout == httpRequest.writeTimeout && this.callTimeout == httpRequest.callTimeout;
    }

    public final String getBaseURL() {
        return this.baseURL;
    }

    public final Object getBody() {
        return this.body;
    }

    public final BodyType getBodyType() {
        return this.bodyType;
    }

    public final int getCallTimeout() {
        return this.callTimeout;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public final RequestType getMethod() {
        return this.method;
    }

    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    public final String getPath() {
        return this.path;
    }

    public final Integer getPort() {
        return this.port;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    public int hashCode() {
        int hashCode = ((((this.baseURL.hashCode() * 31) + this.path.hashCode()) * 31) + this.method.hashCode()) * 31;
        Object obj = this.body;
        int i2 = 0;
        int hashCode2 = (((((((((hashCode + (obj == null ? 0 : obj.hashCode())) * 31) + this.headers.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.bodyType.hashCode()) * 31) + this.scheme.hashCode()) * 31;
        Integer num = this.port;
        if (num != null) {
            i2 = num.hashCode();
        }
        return ((((((((hashCode2 + i2) * 31) + this.connectTimeout) * 31) + this.readTimeout) * 31) + this.writeTimeout) * 31) + this.callTimeout;
    }

    public String toString() {
        return "HttpRequest(baseURL=" + this.baseURL + ", path=" + this.path + ", method=" + this.method + ", body=" + this.body + ", headers=" + this.headers + ", parameters=" + this.parameters + ", bodyType=" + this.bodyType + ", scheme=" + this.scheme + ", port=" + this.port + ", connectTimeout=" + this.connectTimeout + ", readTimeout=" + this.readTimeout + ", writeTimeout=" + this.writeTimeout + ", callTimeout=" + this.callTimeout + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HttpRequest(java.lang.String r14, java.lang.String r15, com.unity3d.services.core.network.model.RequestType r16, java.lang.Object r17, java.util.Map r18, java.util.Map r19, com.unity3d.services.core.network.model.BodyType r20, java.lang.String r21, java.lang.Integer r22, int r23, int r24, int r25, int r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r13 = this;
            r0 = r27
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = ""
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0011
            com.unity3d.services.core.network.model.RequestType r2 = com.unity3d.services.core.network.model.RequestType.GET
            goto L_0x0013
        L_0x0011:
            r2 = r16
        L_0x0013:
            r3 = r0 & 8
            r4 = 0
            if (r3 == 0) goto L_0x001a
            r3 = r4
            goto L_0x001c
        L_0x001a:
            r3 = r17
        L_0x001c:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0025
            java.util.Map r5 = kotlin.collections.MapsKt__MapsKt.g()
            goto L_0x0027
        L_0x0025:
            r5 = r18
        L_0x0027:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0030
            java.util.Map r6 = kotlin.collections.MapsKt__MapsKt.g()
            goto L_0x0032
        L_0x0030:
            r6 = r19
        L_0x0032:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0039
            com.unity3d.services.core.network.model.BodyType r7 = com.unity3d.services.core.network.model.BodyType.UNKNOWN
            goto L_0x003b
        L_0x0039:
            r7 = r20
        L_0x003b:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0042
            java.lang.String r8 = "https"
            goto L_0x0044
        L_0x0042:
            r8 = r21
        L_0x0044:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r4 = r22
        L_0x004b:
            r9 = r0 & 512(0x200, float:7.175E-43)
            r10 = 30000(0x7530, float:4.2039E-41)
            if (r9 == 0) goto L_0x0054
            r9 = 30000(0x7530, float:4.2039E-41)
            goto L_0x0056
        L_0x0054:
            r9 = r23
        L_0x0056:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x005d
            r11 = 30000(0x7530, float:4.2039E-41)
            goto L_0x005f
        L_0x005d:
            r11 = r24
        L_0x005f:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0066
            r12 = 30000(0x7530, float:4.2039E-41)
            goto L_0x0068
        L_0x0066:
            r12 = r25
        L_0x0068:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r10 = r26
        L_0x006f:
            r15 = r13
            r16 = r14
            r17 = r1
            r18 = r2
            r19 = r3
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r4
            r25 = r9
            r26 = r11
            r27 = r12
            r28 = r10
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType, java.lang.String, java.lang.Integer, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
