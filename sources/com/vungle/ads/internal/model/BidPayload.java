package com.vungle.ads.internal.model;

import android.util.Base64;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

@Serializable
public final class BidPayload {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AdPayload ad;
    private final String adunit;
    private final List<String> impression;
    private final Json json;
    private final Integer version;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<BidPayload> serializer() {
            return BidPayload$$serializer.INSTANCE;
        }
    }

    public BidPayload() {
        this((Integer) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ BidPayload(int i2, Integer num, String str, List list, AdPayload adPayload, SerializationConstructorMarker serializationConstructorMarker) {
        String decodedAdsResponse;
        if ((i2 & 0) != 0) {
            PluginExceptionsKt.a(i2, 0, BidPayload$$serializer.INSTANCE.getDescriptor());
        }
        AdPayload adPayload2 = null;
        if ((i2 & 1) == 0) {
            this.version = null;
        } else {
            this.version = num;
        }
        if ((i2 & 2) == 0) {
            this.adunit = null;
        } else {
            this.adunit = str;
        }
        if ((i2 & 4) == 0) {
            this.impression = null;
        } else {
            this.impression = list;
        }
        Json b2 = JsonKt.b((Json) null, AnonymousClass1.INSTANCE, 1, (Object) null);
        this.json = b2;
        if ((i2 & 8) == 0) {
            if (!(this.adunit == null || (decodedAdsResponse = getDecodedAdsResponse()) == null)) {
                KSerializer<Object> b3 = SerializersKt.b(b2.a(), Reflection.h(AdPayload.class));
                Intrinsics.d(b3, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                adPayload2 = (AdPayload) b2.b(b3, decodedAdsResponse);
            }
            this.ad = adPayload2;
            return;
        }
        this.ad = adPayload;
    }

    public static /* synthetic */ BidPayload copy$default(BidPayload bidPayload, Integer num, String str, List<String> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = bidPayload.version;
        }
        if ((i2 & 2) != 0) {
            str = bidPayload.adunit;
        }
        if ((i2 & 4) != 0) {
            list = bidPayload.impression;
        }
        return bidPayload.copy(num, str, list);
    }

    private static /* synthetic */ void getJson$annotations() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        kotlin.io.CloseableKt.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003c, code lost:
        kotlin.io.CloseableKt.a(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003f, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String gzipDecode(byte[] r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r6)
            java.util.zip.GZIPInputStream r6 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0039 }
            r2 = 1024(0x400, float:1.435E-42)
            r6.<init>(r1, r2)     // Catch:{ all -> 0x0039 }
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0032 }
        L_0x0013:
            int r3 = r6.read(r2)     // Catch:{ all -> 0x0032 }
            r4 = -1
            if (r3 == r4) goto L_0x001f
            r4 = 0
            r0.write(r2, r4, r3)     // Catch:{ all -> 0x0032 }
            goto L_0x0013
        L_0x001f:
            kotlin.Unit r2 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0032 }
            r2 = 0
            kotlin.io.CloseableKt.a(r6, r2)     // Catch:{ all -> 0x0039 }
            kotlin.io.CloseableKt.a(r1, r2)
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "result.toString()"
            kotlin.jvm.internal.Intrinsics.e(r6, r0)
            return r6
        L_0x0032:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r6, r0)     // Catch:{ all -> 0x0039 }
            throw r2     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x003b }
        L_0x003b:
            r0 = move-exception
            kotlin.io.CloseableKt.a(r1, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.BidPayload.gzipDecode(byte[]):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0092, code lost:
        if (kotlin.jvm.internal.Intrinsics.a(r3, r5) == false) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void write$Self(com.vungle.ads.internal.model.BidPayload r8, kotlinx.serialization.encoding.CompositeEncoder r9, kotlinx.serialization.descriptors.SerialDescriptor r10) {
        /*
            java.lang.String r0 = "self"
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "output"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            java.lang.String r0 = "serialDesc"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            r0 = 0
            boolean r1 = r9.z(r10, r0)
            r2 = 1
            if (r1 == 0) goto L_0x0019
        L_0x0017:
            r1 = 1
            goto L_0x001f
        L_0x0019:
            java.lang.Integer r1 = r8.version
            if (r1 == 0) goto L_0x001e
            goto L_0x0017
        L_0x001e:
            r1 = 0
        L_0x001f:
            if (r1 == 0) goto L_0x0028
            kotlinx.serialization.internal.IntSerializer r1 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Integer r3 = r8.version
            r9.i(r10, r0, r1, r3)
        L_0x0028:
            boolean r1 = r9.z(r10, r2)
            if (r1 == 0) goto L_0x0030
        L_0x002e:
            r1 = 1
            goto L_0x0036
        L_0x0030:
            java.lang.String r1 = r8.adunit
            if (r1 == 0) goto L_0x0035
            goto L_0x002e
        L_0x0035:
            r1 = 0
        L_0x0036:
            if (r1 == 0) goto L_0x003f
            kotlinx.serialization.internal.StringSerializer r1 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.String r3 = r8.adunit
            r9.i(r10, r2, r1, r3)
        L_0x003f:
            r1 = 2
            boolean r3 = r9.z(r10, r1)
            if (r3 == 0) goto L_0x0048
        L_0x0046:
            r3 = 1
            goto L_0x004e
        L_0x0048:
            java.util.List<java.lang.String> r3 = r8.impression
            if (r3 == 0) goto L_0x004d
            goto L_0x0046
        L_0x004d:
            r3 = 0
        L_0x004e:
            if (r3 == 0) goto L_0x005c
            kotlinx.serialization.internal.ArrayListSerializer r3 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.f41077a
            r3.<init>(r4)
            java.util.List<java.lang.String> r4 = r8.impression
            r9.i(r10, r1, r3, r4)
        L_0x005c:
            r1 = 3
            boolean r3 = r9.z(r10, r1)
            if (r3 == 0) goto L_0x0065
        L_0x0063:
            r0 = 1
            goto L_0x0095
        L_0x0065:
            com.vungle.ads.internal.model.AdPayload r3 = r8.ad
            java.lang.String r4 = r8.adunit
            r5 = 0
            if (r4 == 0) goto L_0x008e
            java.lang.String r4 = r8.getDecodedAdsResponse()
            if (r4 == 0) goto L_0x008e
            kotlinx.serialization.json.Json r5 = r8.json
            kotlinx.serialization.modules.SerializersModule r6 = r5.a()
            java.lang.Class<com.vungle.ads.internal.model.AdPayload> r7 = com.vungle.ads.internal.model.AdPayload.class
            kotlin.reflect.KType r7 = kotlin.jvm.internal.Reflection.h(r7)
            kotlinx.serialization.KSerializer r6 = kotlinx.serialization.SerializersKt.b(r6, r7)
            java.lang.String r7 = "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>"
            kotlin.jvm.internal.Intrinsics.d(r6, r7)
            java.lang.Object r4 = r5.b(r6, r4)
            com.vungle.ads.internal.model.AdPayload r4 = (com.vungle.ads.internal.model.AdPayload) r4
            r5 = r4
        L_0x008e:
            boolean r3 = kotlin.jvm.internal.Intrinsics.a(r3, r5)
            if (r3 != 0) goto L_0x0095
            goto L_0x0063
        L_0x0095:
            if (r0 == 0) goto L_0x009e
            com.vungle.ads.internal.model.AdPayload$$serializer r0 = com.vungle.ads.internal.model.AdPayload$$serializer.INSTANCE
            com.vungle.ads.internal.model.AdPayload r8 = r8.ad
            r9.i(r10, r1, r0, r8)
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.BidPayload.write$Self(com.vungle.ads.internal.model.BidPayload, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    public final Integer component1() {
        return this.version;
    }

    public final String component2() {
        return this.adunit;
    }

    public final List<String> component3() {
        return this.impression;
    }

    public final BidPayload copy(Integer num, String str, List<String> list) {
        return new BidPayload(num, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BidPayload)) {
            return false;
        }
        BidPayload bidPayload = (BidPayload) obj;
        return Intrinsics.a(this.version, bidPayload.version) && Intrinsics.a(this.adunit, bidPayload.adunit) && Intrinsics.a(this.impression, bidPayload.impression);
    }

    public final AdPayload getAdPayload() {
        return this.ad;
    }

    public final String getAdunit() {
        return this.adunit;
    }

    public final String getCreativeId() {
        AdPayload adPayload = this.ad;
        if (adPayload != null) {
            return adPayload.getCreativeId();
        }
        return null;
    }

    public final String getDecodedAdsResponse() throws Throwable {
        byte[] decode = Base64.decode(this.adunit, 0);
        if (decode != null) {
            return gzipDecode(decode);
        }
        return null;
    }

    public final String getEventId() {
        AdPayload adPayload = this.ad;
        if (adPayload != null) {
            return adPayload.eventId();
        }
        return null;
    }

    public final List<String> getImpression() {
        return this.impression;
    }

    public final String getPlacementId() {
        AdPayload adPayload = this.ad;
        if (adPayload != null) {
            return adPayload.placementId();
        }
        return null;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        Integer num = this.version;
        int i2 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.adunit;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.impression;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "BidPayload(version=" + this.version + ", adunit=" + this.adunit + ", impression=" + this.impression + ')';
    }

    public BidPayload(Integer num, String str, List<String> list) {
        String decodedAdsResponse;
        this.version = num;
        this.adunit = str;
        this.impression = list;
        AdPayload adPayload = null;
        Json b2 = JsonKt.b((Json) null, BidPayload$json$1.INSTANCE, 1, (Object) null);
        this.json = b2;
        if (!(str == null || (decodedAdsResponse = getDecodedAdsResponse()) == null)) {
            KSerializer<Object> b3 = SerializersKt.b(b2.a(), Reflection.h(AdPayload.class));
            Intrinsics.d(b3, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            adPayload = (AdPayload) b2.b(b3, decodedAdsResponse);
        }
        this.ad = adPayload;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BidPayload(Integer num, String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : list);
    }
}
