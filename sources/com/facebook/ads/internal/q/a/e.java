package com.facebook.ads.internal.q.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.IOException;
import java.util.concurrent.Executors;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f20613a = a.NOT_INITIALIZED;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static int f20614b = -1;

    enum a {
        NOT_INITIALIZED,
        INITIALIZING,
        INITIALIZED
    }

    public static int a(XmlPullParser xmlPullParser) {
        while (true) {
            if (xmlPullParser.next() == 1) {
                return 0;
            }
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("uses-sdk")) {
                for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
                    if (xmlPullParser.getAttributeName(i2).equals("minSdkVersion")) {
                        return Integer.parseInt(xmlPullParser.getAttributeValue(i2));
                    }
                }
                continue;
            }
        }
    }

    public static void a(Context context) {
        if (!a()) {
            e(context);
        }
    }

    public static boolean a() {
        return f20613a == a.INITIALIZED;
    }

    public static int b(Context context) {
        if (f20613a == a.NOT_INITIALIZED) {
            a(context);
        }
        return f20614b;
    }

    public static int c(Context context) {
        try {
            return a((XmlPullParser) context.getAssets().openXmlResourceParser("AndroidManifest.xml"));
        } catch (IOException | XmlPullParserException unused) {
            return 0;
        }
    }

    private static void e(final Context context) {
        if (f20613a == a.NOT_INITIALIZED) {
            f20613a = a.INITIALIZING;
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                public void run() {
                    a aVar = e.f20613a;
                    a aVar2 = a.INITIALIZED;
                    if (aVar != aVar2) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("FBAdPrefs", 0);
                        int i2 = sharedPreferences.getInt("AppMinSdkVersion", -1);
                        if (i2 != -1) {
                            int unused = e.f20614b = i2;
                        } else {
                            int d2 = Build.VERSION.SDK_INT >= 24 ? e.f(context) : e.c(context);
                            int unused2 = e.f20614b = d2;
                            sharedPreferences.edit().putInt("AppMinSdkVersion", d2).commit();
                        }
                        e.f20613a = aVar2;
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static int f(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).minSdkVersion;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }
}
