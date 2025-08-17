package com.chartboost.sdk.impl;

import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.ClickError;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.internal.Model.CBError;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class j {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17964a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f17965b;

        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|(2:47|48)|49|51|52|(2:53|54)|55|57) */
        /* JADX WARNING: Can't wrap try/catch for region: R(53:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|51|52|(2:53|54)|55|57) */
        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|51|52|53|54|55|57) */
        /* JADX WARNING: Can't wrap try/catch for region: R(55:0|1|2|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|51|52|53|54|55|57) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00f7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
        static {
            /*
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError[] r0 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r2 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.INTERNET_UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.TOO_MANY_CONNECTIONS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.NETWORK_FAILURE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r4 = 3
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.NO_AD_FOUND     // Catch:{ NoSuchFieldError -> 0x002b }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r4 = 4
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.SESSION_NOT_STARTED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r4 = 5
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.INVALID_RESPONSE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r4 = 6
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r4 = 7
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.ASSET_PREFETCH_IN_PROGRESS     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r4 = 8
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.ASSET_MISSING     // Catch:{ NoSuchFieldError -> 0x005a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r4 = 9
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.INTERNET_UNAVAILABLE_AT_CACHE     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r4 = 10
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r4 = 11
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.NO_HOST_ACTIVITY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r4 = 12
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.USER_CANCELLATION     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r4 = 13
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.VIDEO_UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x008c }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r4 = 14
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.VIDEO_ID_MISSING     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r4 = 15
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.ERROR_PLAYING_VIDEO     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r4 = 16
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.ERROR_CREATING_VIEW     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r4 = 17
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.ERROR_DISPLAYING_VIEW     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r4 = 18
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW     // Catch:{ NoSuchFieldError -> 0x00be }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r4 = 19
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.PENDING_IMPRESSION_ERROR     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r4 = 20
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.WEB_VIEW_PAGE_LOAD_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r4 = 21
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.WEB_VIEW_CLIENT_RECEIVED_ERROR     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r4 = 22
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r3 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.INTERNET_UNAVAILABLE_AT_SHOW     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r4 = 23
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                f17964a = r0
                com.chartboost.sdk.internal.Model.CBError$CBClickError[] r0 = com.chartboost.sdk.internal.Model.CBError.CBClickError.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.chartboost.sdk.internal.Model.CBError$CBClickError r3 = com.chartboost.sdk.internal.Model.CBError.CBClickError.URI_INVALID     // Catch:{ NoSuchFieldError -> 0x00f7 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f7 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x00f7 }
            L_0x00f7:
                com.chartboost.sdk.internal.Model.CBError$CBClickError r1 = com.chartboost.sdk.internal.Model.CBError.CBClickError.URI_UNRECOGNIZED     // Catch:{ NoSuchFieldError -> 0x00ff }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ff }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ff }
            L_0x00ff:
                f17965b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.j.a.<clinit>():void");
        }
    }

    public static final CacheError a(CBError.CBImpressionError cBImpressionError) {
        CacheError.Code code;
        Intrinsics.f(cBImpressionError, MRAIDPresenter.ERROR);
        switch (a.f17964a[cBImpressionError.ordinal()]) {
            case 1:
                code = CacheError.Code.INTERNET_UNAVAILABLE;
                break;
            case 2:
                code = CacheError.Code.NETWORK_FAILURE;
                break;
            case 3:
                code = CacheError.Code.NETWORK_FAILURE;
                break;
            case 4:
                code = CacheError.Code.NO_AD_FOUND;
                break;
            case 5:
                code = CacheError.Code.SESSION_NOT_STARTED;
                break;
            case 6:
                code = CacheError.Code.SERVER_ERROR;
                break;
            case 7:
                code = CacheError.Code.ASSET_DOWNLOAD_FAILURE;
                break;
            case 8:
                code = CacheError.Code.ASSET_DOWNLOAD_FAILURE;
                break;
            case 9:
                code = CacheError.Code.ASSET_DOWNLOAD_FAILURE;
                break;
            case 10:
                code = CacheError.Code.INTERNET_UNAVAILABLE;
                break;
            default:
                code = CacheError.Code.INTERNAL;
                break;
        }
        return new CacheError(code, (Exception) null, 2, (DefaultConstructorMarker) null);
    }

    public static final ShowError b(CBError.CBImpressionError cBImpressionError) {
        ShowError.Code code;
        Intrinsics.f(cBImpressionError, MRAIDPresenter.ERROR);
        int i2 = a.f17964a[cBImpressionError.ordinal()];
        if (i2 == 1) {
            code = ShowError.Code.INTERNET_UNAVAILABLE;
        } else if (i2 == 4) {
            code = ShowError.Code.NO_CACHED_AD;
        } else if (i2 != 5) {
            switch (i2) {
                case 11:
                    code = ShowError.Code.AD_ALREADY_VISIBLE;
                    break;
                case 12:
                    code = ShowError.Code.PRESENTATION_FAILURE;
                    break;
                case 13:
                    code = ShowError.Code.PRESENTATION_FAILURE;
                    break;
                case 14:
                    code = ShowError.Code.PRESENTATION_FAILURE;
                    break;
                case 15:
                    code = ShowError.Code.PRESENTATION_FAILURE;
                    break;
                case 16:
                    code = ShowError.Code.PRESENTATION_FAILURE;
                    break;
                case 17:
                    code = ShowError.Code.PRESENTATION_FAILURE;
                    break;
                case 18:
                    code = ShowError.Code.PRESENTATION_FAILURE;
                    break;
                case 19:
                    code = ShowError.Code.PRESENTATION_FAILURE;
                    break;
                case 20:
                    code = ShowError.Code.PRESENTATION_FAILURE;
                    break;
                case 21:
                    code = ShowError.Code.PRESENTATION_FAILURE;
                    break;
                case 22:
                    code = ShowError.Code.PRESENTATION_FAILURE;
                    break;
                case 23:
                    code = ShowError.Code.INTERNET_UNAVAILABLE;
                    break;
                default:
                    code = ShowError.Code.INTERNAL;
                    break;
            }
        } else {
            code = ShowError.Code.SESSION_NOT_STARTED;
        }
        return new ShowError(code, (Exception) null, 2, (DefaultConstructorMarker) null);
    }

    public static final ClickError a(CBError.CBClickError cBClickError, String str) {
        ClickError.Code code;
        Intrinsics.f(cBClickError, MRAIDPresenter.ERROR);
        Intrinsics.f(str, "errorMsg");
        int i2 = a.f17965b[cBClickError.ordinal()];
        if (i2 == 1) {
            code = ClickError.Code.URI_INVALID;
        } else if (i2 != 2) {
            code = ClickError.Code.INTERNAL;
        } else {
            code = ClickError.Code.URI_UNRECOGNIZED;
        }
        return new ClickError(code, new Exception(str));
    }
}
