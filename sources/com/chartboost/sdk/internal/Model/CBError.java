package com.chartboost.sdk.internal.Model;

import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

public final class CBError {

    /* renamed from: a  reason: collision with root package name */
    public final a f19141a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19142b;

    public enum CBClickError {
        URI_INVALID,
        URI_UNRECOGNIZED,
        AGE_GATE_FAILURE,
        NO_HOST_ACTIVITY,
        LOAD_NOT_FINISHED,
        INTERNAL
    }

    public enum CBImpressionError {
        INTERNAL,
        INTERNET_UNAVAILABLE,
        TOO_MANY_CONNECTIONS,
        WRONG_ORIENTATION,
        FIRST_SESSION_INTERSTITIALS_DISABLED,
        NETWORK_FAILURE,
        NO_AD_FOUND,
        SESSION_NOT_STARTED,
        IMPRESSION_ALREADY_VISIBLE,
        NO_HOST_ACTIVITY,
        USER_CANCELLATION,
        INVALID_LOCATION,
        VIDEO_UNAVAILABLE,
        VIDEO_ID_MISSING,
        ERROR_PLAYING_VIDEO,
        INVALID_RESPONSE,
        ASSETS_DOWNLOAD_FAILURE,
        ERROR_CREATING_VIEW,
        ERROR_DISPLAYING_VIEW,
        INCOMPATIBLE_API_VERSION,
        ERROR_LOADING_WEB_VIEW,
        ASSET_PREFETCH_IN_PROGRESS,
        ACTIVITY_MISSING_IN_MANIFEST,
        EMPTY_LOCAL_VIDEO_LIST,
        END_POINT_DISABLED,
        HARDWARE_ACCELERATION_DISABLED,
        PENDING_IMPRESSION_ERROR,
        VIDEO_UNAVAILABLE_FOR_CURRENT_ORIENTATION,
        ASSET_MISSING,
        WEB_VIEW_PAGE_LOAD_TIMEOUT,
        WEB_VIEW_CLIENT_RECEIVED_ERROR,
        INTERNET_UNAVAILABLE_AT_SHOW,
        INTERNET_UNAVAILABLE_AT_CACHE
    }

    public enum a {
        MISCELLANEOUS,
        INTERNET_UNAVAILABLE,
        INVALID_RESPONSE,
        UNEXPECTED_RESPONSE,
        NETWORK_FAILURE,
        PUBLIC_KEY_MISSING,
        HTTP_NOT_FOUND,
        HTTP_NOT_OK,
        UNSUPPORTED_OS_VERSION
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19154a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.chartboost.sdk.internal.Model.CBError$a[] r0 = com.chartboost.sdk.internal.Model.CBError.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.chartboost.sdk.internal.Model.CBError$a r1 = com.chartboost.sdk.internal.Model.CBError.a.MISCELLANEOUS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.chartboost.sdk.internal.Model.CBError$a r1 = com.chartboost.sdk.internal.Model.CBError.a.UNEXPECTED_RESPONSE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.chartboost.sdk.internal.Model.CBError$a r1 = com.chartboost.sdk.internal.Model.CBError.a.HTTP_NOT_OK     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.chartboost.sdk.internal.Model.CBError$a r1 = com.chartboost.sdk.internal.Model.CBError.a.UNSUPPORTED_OS_VERSION     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.chartboost.sdk.internal.Model.CBError$a r1 = com.chartboost.sdk.internal.Model.CBError.a.PUBLIC_KEY_MISSING     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.chartboost.sdk.internal.Model.CBError$a r1 = com.chartboost.sdk.internal.Model.CBError.a.INTERNET_UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.chartboost.sdk.internal.Model.CBError$a r1 = com.chartboost.sdk.internal.Model.CBError.a.HTTP_NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.chartboost.sdk.internal.Model.CBError$a r1 = com.chartboost.sdk.internal.Model.CBError.a.INVALID_RESPONSE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.chartboost.sdk.internal.Model.CBError$a r1 = com.chartboost.sdk.internal.Model.CBError.a.NETWORK_FAILURE     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                f19154a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.internal.Model.CBError.b.<clinit>():void");
        }
    }

    public CBError(a aVar, String str) {
        Intrinsics.f(aVar, MRAIDPresenter.ERROR);
        Intrinsics.f(str, "errorDesc");
        this.f19141a = aVar;
        this.f19142b = str;
    }

    public final a getError() {
        return this.f19141a;
    }

    public final String getErrorDesc() {
        return this.f19142b;
    }

    public final CBImpressionError getImpressionError() {
        switch (b.f19154a[this.f19141a.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return CBImpressionError.INTERNAL;
            case 6:
                return CBImpressionError.INTERNET_UNAVAILABLE;
            case 7:
                return CBImpressionError.NO_AD_FOUND;
            case 8:
                return CBImpressionError.INVALID_RESPONSE;
            case 9:
                return CBImpressionError.NETWORK_FAILURE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
