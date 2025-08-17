package com.facebook.ads.internal.q.c;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.applovin.impl.sdk.utils.Utils;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.settings.a;
import com.facebook.common.util.UriUtil;

public class g {
    private Intent a(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setComponent((ComponentName) null);
        intent.setSelector((Intent) null);
        return intent;
    }

    public static void a(g gVar, Context context, Uri uri, String str) {
        boolean z2 = a(uri.getScheme()) && uri.getHost().equals("play.google.com");
        if (uri.getScheme().equals(Utils.PLAY_STORE_SCHEME) || z2) {
            try {
                gVar.a(context, uri);
                return;
            } catch (c unused) {
            }
        }
        gVar.a(context, uri, str);
    }

    private boolean a(Context context) {
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/")), 0)) {
            if (resolveInfo.activityInfo.applicationInfo.packageName.equals("com.android.vending")) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(String str) {
        return UriUtil.HTTP_SCHEME.equalsIgnoreCase(str) || UriUtil.HTTPS_SCHEME.equalsIgnoreCase(str);
    }

    private void b(Context context, Uri uri) {
        context.startActivity(c(context, uri));
    }

    private void b(Context context, Uri uri, String str) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.facebook.ads.AudienceNetworkActivity");
        intent.addFlags(268435456);
        intent.putExtra(AudienceNetworkActivity.VIEW_TYPE, a.C0036a.BROWSER);
        intent.putExtra(AudienceNetworkActivity.BROWSER_URL, uri.toString());
        intent.putExtra(AudienceNetworkActivity.CLIENT_TOKEN, str);
        intent.putExtra(AudienceNetworkActivity.HANDLER_TIME, System.currentTimeMillis());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            intent.setClassName(context.getPackageName(), "com.facebook.ads.InterstitialAdActivity");
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException unused2) {
                b(context, uri);
            }
        }
    }

    private Intent c(Context context, Uri uri) {
        Intent a2 = a(uri);
        a2.addCategory("android.intent.category.BROWSABLE");
        a2.addFlags(268435456);
        a2.putExtra("com.android.browser.application_id", context.getPackageName());
        a2.putExtra("create_new_tab", false);
        return a2;
    }

    public void a(Context context, Uri uri) {
        if (a(context)) {
            Intent c2 = c(context, uri);
            c2.setPackage("com.android.vending");
            context.startActivity(c2);
            return;
        }
        throw new c();
    }

    public void a(Context context, Uri uri, String str) {
        if (!a(uri.getScheme()) || !com.facebook.ads.internal.l.a.g(context)) {
            b(context, uri);
        } else {
            b(context, uri, str);
        }
    }
}
