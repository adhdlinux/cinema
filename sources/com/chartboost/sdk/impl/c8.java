package com.chartboost.sdk.impl;

import android.content.ActivityNotFoundException;
import android.util.Log;
import com.google.android.gms.common.internal.ImagesContract;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c8 {

    /* renamed from: a  reason: collision with root package name */
    public final bc f17331a;

    /* renamed from: b  reason: collision with root package name */
    public final gc f17332b;

    /* renamed from: c  reason: collision with root package name */
    public d6 f17333c;

    /* renamed from: d  reason: collision with root package name */
    public float f17334d;

    /* renamed from: e  reason: collision with root package name */
    public d7 f17335e;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17336a;

        /* JADX WARNING: Can't wrap try/catch for region: R(82:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(83:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|83) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0104 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x010e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0118 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0122 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0136 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0140 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x014a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0154 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x015e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0168 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0172 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x017c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x0186 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.chartboost.sdk.impl.d8[] r0 = com.chartboost.sdk.impl.d8.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.GET_PARAMETERS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.GET_MAX_SIZE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.GET_SCREEN_SIZE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.GET_CURRENT_POSITION     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.GET_DEFAULT_POSITION     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.GET_ORIENTATION_PROPERTIES     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.CLICK     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.CLOSE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.SKIPPED     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.VIDEO_COMPLETED     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.VIDEO_RESUMED     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.VIDEO_PAUSED     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.VIDEO_REPLAY     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.CURRENT_VIDEO_DURATION     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.TOTAL_VIDEO_DURATION     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.SHOW     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.ERROR     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.WARNING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.DEBUG     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.TRACKING     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.OPEN_URL     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.SET_ORIENTATION_PROPERTIES     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.REWARD     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.REWARDED_VIDEO_COMPLETED     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.PLAY_VIDEO     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.PAUSE_VIDEO     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.CLOSE_VIDEO     // Catch:{ NoSuchFieldError -> 0x010e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010e }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010e }
            L_0x010e:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.MUTE_VIDEO     // Catch:{ NoSuchFieldError -> 0x0118 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0118 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0118 }
            L_0x0118:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.UNMUTE_VIDEO     // Catch:{ NoSuchFieldError -> 0x0122 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0122 }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0122 }
            L_0x0122:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.OM_MEASUREMENT_RESOURCES     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 30
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.START     // Catch:{ NoSuchFieldError -> 0x0136 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0136 }
                r2 = 31
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0136 }
            L_0x0136:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.BUFFER_START     // Catch:{ NoSuchFieldError -> 0x0140 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0140 }
                r2 = 32
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0140 }
            L_0x0140:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.BUFFER_END     // Catch:{ NoSuchFieldError -> 0x014a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x014a }
                r2 = 33
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x014a }
            L_0x014a:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.VIDEO_FINISHED     // Catch:{ NoSuchFieldError -> 0x0154 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0154 }
                r2 = 34
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0154 }
            L_0x0154:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.VIDEO_STARTED     // Catch:{ NoSuchFieldError -> 0x015e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015e }
                r2 = 35
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015e }
            L_0x015e:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.ON_FOREGROUND     // Catch:{ NoSuchFieldError -> 0x0168 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0168 }
                r2 = 36
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0168 }
            L_0x0168:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.VIDEO_ENDED     // Catch:{ NoSuchFieldError -> 0x0172 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0172 }
                r2 = 37
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0172 }
            L_0x0172:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.VIDEO_FAILED     // Catch:{ NoSuchFieldError -> 0x017c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x017c }
                r2 = 38
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x017c }
            L_0x017c:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.PLAYBACK_TIME     // Catch:{ NoSuchFieldError -> 0x0186 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0186 }
                r2 = 39
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0186 }
            L_0x0186:
                com.chartboost.sdk.impl.d8 r1 = com.chartboost.sdk.impl.d8.ON_BACKGROUND     // Catch:{ NoSuchFieldError -> 0x0190 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0190 }
                r2 = 40
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0190 }
            L_0x0190:
                f17336a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.c8.a.<clinit>():void");
        }
    }

    public static final class a0 extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a0 f17337b = new a0();

        public a0() {
            super(0);
        }

        public final void a() {
            w7.b("NativeBridgeCommand", "Video replay command is run");
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17338b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c8 c8Var) {
            super(0);
            this.f17338b = c8Var;
        }

        public final void a() {
            Unit unit;
            d7 a2 = this.f17338b.f17335e;
            if (a2 != null) {
                a2.g();
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                w7.a("NativeBridgeCommand", "Impression interface is missing in template show");
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class b0 extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17339b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f17340c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(c8 c8Var, JSONObject jSONObject) {
            super(0);
            this.f17339b = c8Var;
            this.f17340c = jSONObject;
        }

        public final void a() {
            this.f17339b.a(this.f17340c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class c extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17341b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f17342c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(c8 c8Var, JSONObject jSONObject) {
            super(0);
            this.f17341b = c8Var;
            this.f17342c = jSONObject;
        }

        public final void a() {
            this.f17341b.c(this.f17342c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class c0 extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17343b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f17344c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c0(c8 c8Var, JSONObject jSONObject) {
            super(0);
            this.f17343b = c8Var;
            this.f17344c = jSONObject;
        }

        public final void a() {
            this.f17343b.i(this.f17344c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class d extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17345b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f17346c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(c8 c8Var, JSONObject jSONObject) {
            super(0);
            this.f17345b = c8Var;
            this.f17346c = jSONObject;
        }

        public final void a() {
            this.f17345b.k(this.f17346c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class e extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17347b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f17348c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(c8 c8Var, JSONObject jSONObject) {
            super(0);
            this.f17347b = c8Var;
            this.f17348c = jSONObject;
        }

        public final void a() {
            this.f17347b.b(this.f17348c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class f extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17349b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f17350c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(c8 c8Var, JSONObject jSONObject) {
            super(0);
            this.f17349b = c8Var;
            this.f17350c = jSONObject;
        }

        public final void a() {
            this.f17349b.j(this.f17350c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class g extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17351b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f17352c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(c8 c8Var, JSONObject jSONObject) {
            super(0);
            this.f17351b = c8Var;
            this.f17352c = jSONObject;
        }

        public final void a() {
            this.f17351b.e(this.f17352c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class h extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17353b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f17354c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(c8 c8Var, JSONObject jSONObject) {
            super(0);
            this.f17353b = c8Var;
            this.f17354c = jSONObject;
        }

        public final void a() {
            this.f17353b.h(this.f17354c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class i extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17355b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(c8 c8Var) {
            super(0);
            this.f17355b = c8Var;
        }

        public final void a() {
            d7 a2 = this.f17355b.f17335e;
            if (a2 != null) {
                a2.u();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class j extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17356b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(c8 c8Var) {
            super(0);
            this.f17356b = c8Var;
        }

        public final void a() {
            Unit unit;
            d7 a2 = this.f17356b.f17335e;
            if (a2 != null) {
                a2.z();
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                w7.a("NativeBridgeCommand", "Impression interface is missing in template rewarded video completed");
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class k extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17357b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(c8 c8Var) {
            super(0);
            this.f17357b = c8Var;
        }

        public final void a() {
            Unit unit;
            d7 a2 = this.f17357b.f17335e;
            if (a2 != null) {
                a2.k();
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                w7.a("NativeBridgeCommand", "Impression interface is missing in template play video");
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class l extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17358b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f17359c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(c8 c8Var, JSONObject jSONObject) {
            super(0);
            this.f17358b = c8Var;
            this.f17359c = jSONObject;
        }

        public final void a() {
            d7 a2 = this.f17358b.f17335e;
            if (a2 != null) {
                a2.b(this.f17358b.f17332b.b(this.f17359c));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class m extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17360b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(c8 c8Var) {
            super(0);
            this.f17360b = c8Var;
        }

        public final void a() {
            Unit unit;
            d7 a2 = this.f17360b.f17335e;
            if (a2 != null) {
                a2.m();
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                w7.a("NativeBridgeCommand", "Impression interface is missing in template pause video");
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class n extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17361b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(c8 c8Var) {
            super(0);
            this.f17361b = c8Var;
        }

        public final void a() {
            Unit unit;
            d7 a2 = this.f17361b.f17335e;
            if (a2 != null) {
                a2.t();
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                w7.a("NativeBridgeCommand", "Impression interface is missing in template close video");
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class o extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17362b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(c8 c8Var) {
            super(0);
            this.f17362b = c8Var;
        }

        public final void a() {
            Unit unit;
            d7 a2 = this.f17362b.f17335e;
            if (a2 != null) {
                a2.f();
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                w7.a("NativeBridgeCommand", "Impression interface is missing in template mute video");
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class p extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17363b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(c8 c8Var) {
            super(0);
            this.f17363b = c8Var;
        }

        public final void a() {
            Unit unit;
            d7 a2 = this.f17363b.f17335e;
            if (a2 != null) {
                a2.b();
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                w7.a("NativeBridgeCommand", "Impression interface is missing in template unmute video");
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class q extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17364b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f17365c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(c8 c8Var, JSONObject jSONObject) {
            super(0);
            this.f17364b = c8Var;
            this.f17365c = jSONObject;
        }

        public final void a() {
            this.f17364b.f(this.f17365c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class r extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17366b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f17367c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(c8 c8Var, JSONObject jSONObject) {
            super(0);
            this.f17366b = c8Var;
            this.f17367c = jSONObject;
        }

        public final void a() {
            this.f17366b.g(this.f17367c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class s extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17368b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(c8 c8Var) {
            super(0);
            this.f17368b = c8Var;
        }

        public final void a() {
            this.f17368b.c();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class t extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17369b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(c8 c8Var) {
            super(0);
            this.f17369b = c8Var;
        }

        public final void a() {
            this.f17369b.b();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class u extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17370b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(c8 c8Var) {
            super(0);
            this.f17370b = c8Var;
        }

        public final void a() {
            this.f17370b.d();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class v extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17371b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(c8 c8Var) {
            super(0);
            this.f17371b = c8Var;
        }

        public final void a() {
            Unit unit;
            d7 a2 = this.f17371b.f17335e;
            if (a2 != null) {
                a2.D();
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                w7.a("NativeBridgeCommand", "Impression interface is missing in template close");
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class w extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17372b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(c8 c8Var) {
            super(0);
            this.f17372b = c8Var;
        }

        public final void a() {
            d7 a2 = this.f17372b.f17335e;
            if (a2 != null) {
                a2.a(oc.SKIP);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class x extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17373b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x(c8 c8Var) {
            super(0);
            this.f17373b = c8Var;
        }

        public final void a() {
            this.f17373b.g();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class y extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17374b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(c8 c8Var) {
            super(0);
            this.f17374b = c8Var;
        }

        public final void a() {
            this.f17374b.f();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class z extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17375b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(c8 c8Var) {
            super(0);
            this.f17375b = c8Var;
        }

        public final void a() {
            this.f17375b.e();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public c8(bc bcVar, gc gcVar) {
        Intrinsics.f(bcVar, "uiPost");
        Intrinsics.f(gcVar, "urlParser");
        this.f17331a = bcVar;
        this.f17332b = gcVar;
    }

    public final void k(JSONObject jSONObject) {
        String str;
        Log.d("NativeBridgeCommand", "Javascript warning occurred");
        if (jSONObject != null) {
            try {
                str = jSONObject.getString("message");
            } catch (Exception unused) {
                d7 d7Var = this.f17335e;
                if (d7Var != null) {
                    d7Var.e("Warning message is empty");
                    return;
                }
                return;
            }
        } else {
            str = null;
        }
        if (str == null) {
            str = "Missing message argument";
        }
        Log.d("NativeBridgeCommand", "JS->Native Warning message: " + str);
        d7 d7Var2 = this.f17335e;
        if (d7Var2 != null) {
            d7Var2.e(str);
        }
    }

    public final void i(JSONObject jSONObject) {
        float f2;
        Unit unit;
        if (jSONObject != null) {
            try {
                f2 = (float) jSONObject.optDouble("duration", 0.0d);
            } catch (Exception e2) {
                JSONObject jSONObject2 = new JSONObject();
                k(jSONObject2.put("message", "Parsing exception unknown field for total player duration: " + e2));
                return;
            }
        } else {
            f2 = 0.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("######### JS->Native Video total player duration");
        float f3 = f2 * ((float) 1000);
        sb.append(f3);
        w7.a("NativeBridgeCommand", sb.toString());
        this.f17334d = f3;
        d7 d7Var = this.f17335e;
        if (d7Var != null) {
            d7Var.b(f3);
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            w7.a("NativeBridgeCommand", "Impression interface is missing in totalVideoDuration");
        }
    }

    public final void j(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString("event");
                if (string != null) {
                    d7 d7Var = this.f17335e;
                    if (d7Var != null) {
                        d7Var.d(string);
                        return;
                    }
                    Log.d("NativeBridgeCommand", "JS->Native Track VAST event message: " + string);
                    return;
                }
            } catch (Exception e2) {
                w7.b("NativeBridgeCommand", "Exception occured while parsing the message for webview tracking VAST: " + e2);
                return;
            }
        }
        w7.b("NativeBridgeCommand", "Tracking command received but event is missing!");
    }

    public final void a(d6 d6Var) {
        this.f17333c = d6Var;
    }

    public final void b(JSONObject jSONObject) {
        try {
            String b2 = b(jSONObject, "JS->Native Debug message: ");
            w7.a("NativeBridgeCommand", "Debug message: " + b2);
        } catch (Exception e2) {
            w7.b("NativeBridgeCommand", "Exception occurred while parsing the message for webview debug track event: " + e2);
        }
    }

    public final void c(JSONObject jSONObject) {
        Log.d("NativeBridgeCommand", "Javascript Error occurred " + jSONObject);
        d(jSONObject);
        try {
            d7 d7Var = this.f17335e;
            if (d7Var != null) {
                d7Var.j();
                if (d7Var.c(b(jSONObject, "JS->Native Error message: ")) != null) {
                    return;
                }
            }
            w7.a("NativeBridgeCommand", "Impression interface is missing in error");
            Unit unit = Unit.f40298a;
        } catch (Exception unused) {
            w7.b("NativeBridgeCommand", "Error message is empty");
            d7 d7Var2 = this.f17335e;
            if (d7Var2 != null) {
                d7Var2.c("");
            }
        }
    }

    public final void d(JSONObject jSONObject) {
        String optString;
        if (la.f18112a.g() && jSONObject != null && (optString = jSONObject.optString("msg")) != null && Intrinsics.a(optString, "crash sdk")) {
            throw new RuntimeException("test crash");
        }
    }

    public final void e() {
        Unit unit;
        d7 d7Var = this.f17335e;
        if (d7Var != null) {
            d7Var.a(g9.PAUSED);
            d7Var.a(oc.PAUSE);
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            w7.a("NativeBridgeCommand", "Impression interface is missing in runVideoResumedCommand");
        }
    }

    public final void f() {
        Unit unit;
        d7 d7Var = this.f17335e;
        if (d7Var != null) {
            d7Var.a(oc.RESUME);
            d7Var.a(g9.PLAYING);
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            w7.a("NativeBridgeCommand", "Impression interface is missing in runVideoResumedCommand");
        }
    }

    public final void g() {
        Unit unit;
        d6 d6Var = this.f17333c;
        if (d6Var != null) {
            d6Var.onHideCustomView();
        }
        d7 d7Var = this.f17335e;
        if (d7Var != null) {
            d7Var.a(g9.IDLE);
            d7Var.o();
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            w7.a("NativeBridgeCommand", "Impression interface is missing in videoCompleted");
        }
    }

    public final void h(JSONObject jSONObject) {
        boolean z2 = true;
        if (jSONObject != null) {
            try {
                z2 = jSONObject.optBoolean("allowOrientationChange", true);
            } catch (Exception unused) {
                w7.b("NativeBridgeCommand", "Invalid set orientation command");
                return;
            }
        }
        String str = "none";
        Unit unit = null;
        String optString = jSONObject != null ? jSONObject.optString("forceOrientation", str) : null;
        if (optString != null) {
            str = optString;
        }
        d7 d7Var = this.f17335e;
        if (d7Var != null) {
            d7Var.a(z2, str);
            unit = Unit.f40298a;
        }
        if (unit == null) {
            w7.a("NativeBridgeCommand", "Impression interface is missing in setOrientation");
        }
    }

    public final void a(d7 d7Var) {
        Intrinsics.f(d7Var, "impressionInterface");
        this.f17335e = d7Var;
    }

    public final void a() {
        this.f17335e = null;
    }

    public final String a(JSONObject jSONObject, String str) {
        Intrinsics.f(str, "functionName");
        d8 a2 = d8.f17423c.a(str);
        if (a2 == null) {
            Log.w("NativeBridgeCommand", "Native event unknown: " + str);
            return "Function name not recognized.";
        }
        w7.a("NativeBridgeCommand", "TEMPLATE EVENT: " + a2.c());
        return a(jSONObject, a2);
    }

    public final void b() {
        Unit unit;
        try {
            d7 d7Var = this.f17335e;
            if (d7Var != null) {
                d7Var.a(oc.BUFFER_END);
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                w7.a("NativeBridgeCommand", "Impression interface is missing in runBufferEnd");
            }
        } catch (Exception e2) {
            w7.b("NativeBridgeCommand", "Invalid buffer end command: " + e2);
        }
    }

    public final void d() {
        Unit unit;
        try {
            d7 d7Var = this.f17335e;
            if (d7Var != null) {
                d7Var.a(oc.COMPLETED);
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                w7.a("NativeBridgeCommand", "Impression interface is missing in runVideoFinished");
            }
        } catch (Exception e2) {
            w7.b("NativeBridgeCommand", "Invalid buffer end command: " + e2);
        }
    }

    public final void e(JSONObject jSONObject) {
        Unit unit;
        try {
            d7 d7Var = this.f17335e;
            if (d7Var != null) {
                d7Var.c(this.f17332b.b(jSONObject));
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                w7.a("NativeBridgeCommand", "Impression interface is missing in openUrl");
            }
        } catch (ActivityNotFoundException e2) {
            w7.b("NativeBridgeCommand", "ActivityNotFoundException occured when opening a url in a browser: " + e2);
        } catch (Exception e3) {
            w7.b("NativeBridgeCommand", "Exception while opening a browser view with MRAID url: " + e3);
        }
    }

    public final void f(JSONObject jSONObject) {
        List list;
        Unit unit = null;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString("resources");
                if (string != null) {
                    if (string.length() == 0) {
                        list = CollectionsKt__CollectionsKt.f();
                    } else {
                        List<JSONObject> asList = r5.asList(new JSONArray(string));
                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(asList, 10));
                        for (JSONObject jSONObject2 : asList) {
                            arrayList.add(qc.a(jSONObject2.getString("vendorKey"), new URL(jSONObject2.getString(ImagesContract.URL)), jSONObject2.getString("params")));
                        }
                        list = CollectionsKt___CollectionsKt.a0(arrayList);
                    }
                    d7 d7Var = this.f17335e;
                    if (d7Var != null) {
                        d7Var.a(list);
                        unit = Unit.f40298a;
                    }
                    if (unit == null) {
                        w7.a("NativeBridgeCommand", "Impression interface is missing in runOmResources");
                    }
                    unit = Unit.f40298a;
                }
            } catch (Exception e2) {
                w7.b("NativeBridgeCommand", "Invalid om resources command: " + e2);
                return;
            }
        }
        if (unit == null) {
            w7.b("NativeBridgeCommand", "Invalid om resources command: missing json");
        }
    }

    public final String b(JSONObject jSONObject, String str) {
        String string = jSONObject != null ? jSONObject.getString("message") : null;
        if (string == null) {
            string = "";
        }
        Log.d("NativeBridgeCommand", str + string);
        return string;
    }

    public final void g(JSONObject jSONObject) {
        Unit unit;
        double d2 = 0.0d;
        if (jSONObject != null) {
            try {
                d2 = jSONObject.optDouble("duration", 0.0d);
            } catch (Exception e2) {
                w7.b("NativeBridgeCommand", "Invalid start command: " + e2);
                return;
            }
        }
        this.f17334d = (float) d2;
        d7 d7Var = this.f17335e;
        if (d7Var != null) {
            d7Var.a(oc.START);
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            w7.a("NativeBridgeCommand", "Impression interface is missing in runStart");
        }
    }

    public final String a(JSONObject jSONObject, d8 d8Var) {
        String l2;
        String i2;
        String w2;
        String C;
        String n2;
        String x2;
        switch (a.f17336a[d8Var.ordinal()]) {
            case 1:
                Log.d("NativeBridgeCommand", "JavaScript to native " + d8Var.c() + " callback triggered.");
                d7 d7Var = this.f17335e;
                if (d7Var == null || (l2 = d7Var.l()) == null) {
                    return "";
                }
                return l2;
            case 2:
                Log.d("NativeBridgeCommand", "JavaScript to native " + d8Var.c() + " callback triggered.");
                d7 d7Var2 = this.f17335e;
                if (d7Var2 == null || (i2 = d7Var2.i()) == null) {
                    return "";
                }
                return i2;
            case 3:
                Log.d("NativeBridgeCommand", "JavaScript to native " + d8Var.c() + " callback triggered.");
                d7 d7Var3 = this.f17335e;
                if (d7Var3 == null || (w2 = d7Var3.w()) == null) {
                    return "";
                }
                return w2;
            case 4:
                Log.d("NativeBridgeCommand", "JavaScript to native " + d8Var.c() + " callback triggered.");
                d7 d7Var4 = this.f17335e;
                if (d7Var4 == null || (C = d7Var4.C()) == null) {
                    return "";
                }
                return C;
            case 5:
                Log.d("NativeBridgeCommand", "JavaScript to native " + d8Var.c() + " callback triggered.");
                d7 d7Var5 = this.f17335e;
                if (d7Var5 == null || (n2 = d7Var5.n()) == null) {
                    return "";
                }
                return n2;
            case 6:
                Log.d("NativeBridgeCommand", "JavaScript to native " + d8Var.c() + " callback triggered.");
                d7 d7Var6 = this.f17335e;
                if (d7Var6 == null || (x2 = d7Var6.x()) == null) {
                    return "";
                }
                return x2;
            case 7:
                this.f17331a.a(new l(this, jSONObject));
                return "Native function successfully called.";
            case 8:
                this.f17331a.a(new v(this));
                return "Native function successfully called.";
            case 9:
                this.f17331a.a(new w(this));
                return "Native function successfully called.";
            case 10:
                this.f17331a.a(new x(this));
                return "Native function successfully called.";
            case 11:
                this.f17331a.a(new y(this));
                return "Native function successfully called.";
            case 12:
                this.f17331a.a(new z(this));
                return "Native function successfully called.";
            case 13:
                this.f17331a.a(a0.f17337b);
                return "Native function successfully called.";
            case 14:
                this.f17331a.a(new b0(this, jSONObject));
                return "Native function successfully called.";
            case 15:
                this.f17331a.a(new c0(this, jSONObject));
                return "Native function successfully called.";
            case 16:
                this.f17331a.a(new b(this));
                return "Native function successfully called.";
            case 17:
                this.f17331a.a(new c(this, jSONObject));
                return "Native function successfully called.";
            case 18:
                this.f17331a.a(new d(this, jSONObject));
                return "Native function successfully called.";
            case 19:
                this.f17331a.a(new e(this, jSONObject));
                return "Native function successfully called.";
            case 20:
                this.f17331a.a(new f(this, jSONObject));
                return "Native function successfully called.";
            case 21:
                this.f17331a.a(new g(this, jSONObject));
                return "Native function successfully called.";
            case 22:
                this.f17331a.a(new h(this, jSONObject));
                return "Native function successfully called.";
            case 23:
                this.f17331a.a(new i(this));
                return "Native function successfully called.";
            case 24:
                this.f17331a.a(new j(this));
                return "Native function successfully called.";
            case 25:
                this.f17331a.a(new k(this));
                return "Native function successfully called.";
            case 26:
                this.f17331a.a(new m(this));
                return "Native function successfully called.";
            case 27:
                this.f17331a.a(new n(this));
                return "Native function successfully called.";
            case 28:
                this.f17331a.a(new o(this));
                return "Native function successfully called.";
            case 29:
                this.f17331a.a(new p(this));
                return "Native function successfully called.";
            case 30:
                this.f17331a.a(new q(this, jSONObject));
                return "Native function successfully called.";
            case 31:
                this.f17331a.a(new r(this, jSONObject));
                return "Native function successfully called.";
            case 32:
                this.f17331a.a(new s(this));
                return "Native function successfully called.";
            case 33:
                this.f17331a.a(new t(this));
                return "Native function successfully called.";
            case 34:
                this.f17331a.a(new u(this));
                return "Native function successfully called.";
            default:
                return "Native function successfully called.";
        }
    }

    public final void c() {
        Unit unit;
        try {
            d7 d7Var = this.f17335e;
            if (d7Var != null) {
                d7Var.a(oc.BUFFER_START);
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                w7.a("NativeBridgeCommand", "Impression interface is missing in runBufferStart");
            }
        } catch (Exception e2) {
            w7.b("NativeBridgeCommand", "Invalid bufer start command: " + e2);
        }
    }

    public final void a(JSONObject jSONObject) {
        float f2;
        Unit unit;
        if (jSONObject != null) {
            try {
                f2 = (float) jSONObject.getDouble("duration");
            } catch (Exception e2) {
                JSONObject jSONObject2 = new JSONObject();
                k(jSONObject2.put("message", "Parsing exception unknown field for current player duration: " + e2));
                return;
            }
        } else {
            f2 = 0.0f;
        }
        if (f2 > 0.0f) {
            float f3 = f2 * ((float) 1000);
            w7.a("NativeBridgeCommand", "######### JS->Native Video current player duration: " + f3);
            d7 d7Var = this.f17335e;
            if (d7Var != null) {
                d7Var.a(f3);
                d7Var.a(this.f17334d, f3);
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                w7.a("NativeBridgeCommand", "Impression interface is missing in currentVideoDuration");
            }
        }
    }
}
