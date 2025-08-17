package com.adcolony.sdk;

import com.facebook.hermes.intl.Constants;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.zip.DataFormatException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class g {

    /* renamed from: e  reason: collision with root package name */
    public static final a f13127e = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final Map<String, String> f13128f = MapsKt__MapsKt.l(TuplesKt.a(Constants.COLLATION_DEFAULT, "truefalse"), TuplesKt.a("la-req-01", "\"iphoneos\"ipados\"cell\"tablet\"{\"carrier_name\":\",\"data_path\":\",\"device_api\":,\"screen_width\":,\"screen_height\":,\"display_dpi\":,\"device_type\":\"phone\",\"locale_language_code\":\",\"ln\":\",\"locale_country_code\":\",\"locale\":\",\"mac_address\":\"\",\"manufacturer\":\",\"device_brand\":\",\"media_path\":\",\"temp_storage_path\":\",\"memory_class\":,\"memory_used_mb\":,\"model\":\",\"device_model\":\",\"sdk_type\":\"android_native\",\"sdk_version\":\"4.\",\"network_type\":\"wifi\",\"os_version\":\",\"os_name\":\"android\",\"platform\":\"android\",\"arch\":\",\"user_id\":\"\",\"app_id\":\",\"app_bundle_name\":\",\"app_bundle_version\":\",\"battery_level\":1,\"cell_service_country_code\":\",\"timezone_ietf\":\",\"timezone_gmt_m\":,\"timezone_dst_m\":,\"controller_version\":\"3.\",\"current_orientation\":0,\"cleartext_permitted\":true,\"density\":,\"dark_mode\":false,\"available_stores\":[],\"advertiser_id\":\",\"limit_tracking\":false,\"adc_alt_id\":\"}"), TuplesKt.a("la-res-01", "{\"controller\":{\"url\":\"https://adc-ad-assets.adtilt.com/launch/__controllers__/4.0.0/controller.js\",\"sha1\":,\"version\":\"3.\"},\"libraries\":[],\"item\":0,\"logging\":{\"log_private\":false,\"send_level\":1,\"enable_crash_reporting\":false,\"print_level\":3,\"report_interval_ms\":5000},\"metadata\":{\"controller_heartbeat_interval\":300000,\"controller_heartbeat_timeout\":15000,\"ad_request_timeout\":20000,\"iab_url\":\"https://adc-ad-assets.adtilt.com/launch/__libs__/omsdk/omsdk-v1.js\",\"odt_config\":{\"version\":,\"streams\":[{\"stream\":\"events\",\"request_types\":[\"start\",\"html5_interaction\",\"in_video_engagement\",\"download\",\"info\",\"viewable_impression\",\"complete\",\"skip\",\"continue\",\"midpoint\",\"first_quartile\",\"third_quartile\",\"reward_v4vc\"configure\"session_start\",\"session_end\",\"session_resume\",\"session_pause\"]\"table_name\"max_rows\": GROUP BY ]},\"calculate_odt_timeout\":500,\"async_odt_query\":false},\"status\":\"success\",\"pie\":\"}"));

    /* renamed from: a  reason: collision with root package name */
    private final String f13129a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13130b;

    /* renamed from: c  reason: collision with root package name */
    private final String f13131c;

    /* renamed from: d  reason: collision with root package name */
    private final String f13132d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a(String str, String str2) {
            g gVar;
            if (str == null || str2 == null) {
                return null;
            }
            synchronized (b()) {
                a aVar = g.f13127e;
                if (!aVar.b().containsKey(str)) {
                    str = Constants.COLLATION_DEFAULT;
                }
                if (!aVar.b().containsKey(str2)) {
                    str2 = Constants.COLLATION_DEFAULT;
                }
                gVar = new g(str, str2, aVar.b().get(str), aVar.b().get(str2));
            }
            return gVar;
        }

        public final Map<String, String> b() {
            return g.f13128f;
        }

        public final void c(Map<String, String> map) {
            synchronized (b()) {
                g.f13127e.b().putAll(map);
                Unit unit = Unit.f40298a;
            }
        }
    }

    public g(String str, String str2, String str3, String str4) {
        this.f13129a = str;
        this.f13130b = str2;
        this.f13131c = str3;
        this.f13132d = str4;
    }

    public static final g a(String str, String str2) {
        return f13127e.a(str, str2);
    }

    public static final void c(Map<String, String> map) {
        f13127e.c(map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        kotlin.io.CloseableKt.a(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final byte[] f(byte[] r4, java.lang.String r5) throws java.io.UnsupportedEncodingException {
        /*
            r3 = this;
            java.util.zip.Deflater r0 = new java.util.zip.Deflater
            r0.<init>()
            java.nio.charset.Charset r1 = com.adcolony.sdk.h.f13158a     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0041
            byte[] r5 = r5.getBytes(r1)     // Catch:{ all -> 0x0049 }
            r0.setDictionary(r5)     // Catch:{ all -> 0x0049 }
            r0.setInput(r4)     // Catch:{ all -> 0x0049 }
            r0.finish()     // Catch:{ all -> 0x0049 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0049 }
            r4.<init>()     // Catch:{ all -> 0x0049 }
            r5 = 512(0x200, float:7.175E-43)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x003a }
        L_0x001f:
            boolean r1 = r0.finished()     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x002e
            int r1 = r0.deflate(r5)     // Catch:{ all -> 0x003a }
            r2 = 0
            r4.write(r5, r2, r1)     // Catch:{ all -> 0x003a }
            goto L_0x001f
        L_0x002e:
            byte[] r5 = r4.toByteArray()     // Catch:{ all -> 0x003a }
            r1 = 0
            kotlin.io.CloseableKt.a(r4, r1)     // Catch:{ all -> 0x0049 }
            r0.end()
            return r5
        L_0x003a:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x003c }
        L_0x003c:
            r1 = move-exception
            kotlin.io.CloseableKt.a(r4, r5)     // Catch:{ all -> 0x0049 }
            throw r1     // Catch:{ all -> 0x0049 }
        L_0x0041:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException     // Catch:{ all -> 0x0049 }
            java.lang.String r5 = "null cannot be cast to non-null type java.lang.String"
            r4.<init>(r5)     // Catch:{ all -> 0x0049 }
            throw r4     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r4 = move-exception
            r0.end()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.g.f(byte[], java.lang.String):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        kotlin.io.CloseableKt.a(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0052, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String i(byte[] r5, java.lang.String r6) throws java.util.zip.DataFormatException, java.io.UnsupportedEncodingException, java.lang.IllegalArgumentException {
        /*
            r4 = this;
            java.util.zip.Inflater r0 = new java.util.zip.Inflater
            r0.<init>()
            r0.setInput(r5)     // Catch:{ all -> 0x0053 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0053 }
            r5.<init>()     // Catch:{ all -> 0x0053 }
            r1 = 512(0x200, float:7.175E-43)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x004c }
        L_0x0011:
            boolean r2 = r0.finished()     // Catch:{ all -> 0x004c }
            if (r2 != 0) goto L_0x0039
            int r2 = r0.inflate(r1)     // Catch:{ all -> 0x004c }
            r3 = 0
            r5.write(r1, r3, r2)     // Catch:{ all -> 0x004c }
            boolean r2 = r0.needsDictionary()     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x0011
            java.nio.charset.Charset r2 = com.adcolony.sdk.h.f13158a     // Catch:{ all -> 0x004c }
            if (r6 == 0) goto L_0x0031
            byte[] r2 = r6.getBytes(r2)     // Catch:{ all -> 0x004c }
            r0.setDictionary(r2)     // Catch:{ all -> 0x004c }
            goto L_0x0011
        L_0x0031:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException     // Catch:{ all -> 0x004c }
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r6.<init>(r1)     // Catch:{ all -> 0x004c }
            throw r6     // Catch:{ all -> 0x004c }
        L_0x0039:
            byte[] r6 = r5.toByteArray()     // Catch:{ all -> 0x004c }
            java.nio.charset.Charset r1 = com.adcolony.sdk.h.f13158a     // Catch:{ all -> 0x004c }
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x004c }
            r2.<init>(r6, r1)     // Catch:{ all -> 0x004c }
            r6 = 0
            kotlin.io.CloseableKt.a(r5, r6)     // Catch:{ all -> 0x0053 }
            r0.end()
            return r2
        L_0x004c:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x004e }
        L_0x004e:
            r1 = move-exception
            kotlin.io.CloseableKt.a(r5, r6)     // Catch:{ all -> 0x0053 }
            throw r1     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r5 = move-exception
            r0.end()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.g.i(byte[], java.lang.String):java.lang.String");
    }

    public final byte[] d(String str) throws UnsupportedEncodingException {
        return e(str.getBytes(h.f13158a));
    }

    public final byte[] e(byte[] bArr) throws UnsupportedEncodingException {
        return f(bArr, this.f13131c);
    }

    public final String g() {
        return this.f13129a;
    }

    public final String h(byte[] bArr) throws DataFormatException, UnsupportedEncodingException, IllegalArgumentException {
        return i(bArr, this.f13132d);
    }

    public final String j() {
        return this.f13130b;
    }
}
