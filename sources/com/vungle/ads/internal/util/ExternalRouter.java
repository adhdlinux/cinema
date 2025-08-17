package com.vungle.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import com.vungle.ads.LinkError;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.ui.PresenterAdOpenCallback;
import com.vungle.ads.internal.util.Logger;
import kotlin.jvm.internal.Intrinsics;

public final class ExternalRouter {
    public static final ExternalRouter INSTANCE = new ExternalRouter();
    private static final String TAG = "ExternalRouter";

    private ExternalRouter() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0012 A[Catch:{ URISyntaxException -> 0x000d }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0013 A[Catch:{ URISyntaxException -> 0x000d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.content.Intent getIntentFromUrl(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            if (r4 == 0) goto L_0x000f
            int r2 = r4.length()     // Catch:{ URISyntaxException -> 0x000d }
            if (r2 != 0) goto L_0x000b
            goto L_0x000f
        L_0x000b:
            r2 = 0
            goto L_0x0010
        L_0x000d:
            r4 = move-exception
            goto L_0x0022
        L_0x000f:
            r2 = 1
        L_0x0010:
            if (r2 == 0) goto L_0x0013
            goto L_0x0018
        L_0x0013:
            android.content.Intent r4 = android.content.Intent.parseUri(r4, r0)     // Catch:{ URISyntaxException -> 0x000d }
            r1 = r4
        L_0x0018:
            if (r1 == 0) goto L_0x003e
            if (r5 == 0) goto L_0x003e
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            r1.setFlags(r4)     // Catch:{ URISyntaxException -> 0x000d }
            goto L_0x003e
        L_0x0022:
            com.vungle.ads.internal.util.Logger$Companion r5 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "url format is not correct "
            r0.append(r2)
            java.lang.String r4 = r4.getLocalizedMessage()
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "ExternalRouter"
            r5.e(r0, r4)
        L_0x003e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.util.ExternalRouter.getIntentFromUrl(java.lang.String, boolean):android.content.Intent");
    }

    public static final boolean launch(String str, String str2, Context context, LogEntry logEntry, PresenterAdOpenCallback presenterAdOpenCallback) {
        boolean z2;
        boolean z3;
        Intrinsics.f(context, "context");
        boolean z4 = true;
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (str2 == null || str2.length() == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                return false;
            }
        }
        boolean z5 = !(context instanceof Activity);
        try {
            ExternalRouter externalRouter = INSTANCE;
            return ActivityManager.Companion.startWhenForeground(context, externalRouter.getIntentFromUrl(str, z5), externalRouter.getIntentFromUrl(str2, z5), presenterAdOpenCallback);
        } catch (Exception e2) {
            if (!(str == null || str.length() == 0)) {
                z4 = false;
            }
            if (!z4) {
                new LinkError(Sdk$SDKError.Reason.DEEPLINK_OPEN_FAILED, "Fail to open " + str).setLogEntry$vungle_ads_release(logEntry).logErrorNoReturnValue$vungle_ads_release();
            } else {
                new LinkError(Sdk$SDKError.Reason.LINK_COMMAND_OPEN_FAILED, "Fail to open " + str2).setLogEntry$vungle_ads_release(logEntry).logErrorNoReturnValue$vungle_ads_release();
            }
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "Error while opening url" + e2.getLocalizedMessage());
            companion.d(TAG, "Cannot open url " + str2);
            return false;
        }
    }

    public static /* synthetic */ boolean launch$default(String str, String str2, Context context, LogEntry logEntry, PresenterAdOpenCallback presenterAdOpenCallback, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            logEntry = null;
        }
        if ((i2 & 16) != 0) {
            presenterAdOpenCallback = null;
        }
        return launch(str, str2, context, logEntry, presenterAdOpenCallback);
    }
}
