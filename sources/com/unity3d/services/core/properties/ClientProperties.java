package com.unity3d.services.core.properties;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.unity3d.services.core.log.DeviceLog;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class ClientProperties {
    private static final X500Principal DEBUG_CERT = new X500Principal("CN=Android Debug,O=Android,C=US");
    private static WeakReference<Activity> _activity;
    private static Application _application;
    private static Context _applicationContext;
    private static String _gameId;

    public static Activity getActivity() {
        return _activity.get();
    }

    public static String getAppName() {
        Context context = _applicationContext;
        if (context == null) {
            return "";
        }
        return context.getPackageName();
    }

    public static String getAppVersion() {
        String packageName = getApplicationContext().getPackageName();
        PackageManager packageManager = getApplicationContext().getPackageManager();
        try {
            if (packageManager.getPackageInfo(packageName, 0).versionName == null) {
                return "FakeVersionName";
            }
            return packageManager.getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            DeviceLog.exception("Error getting package info", e2);
            return null;
        }
    }

    public static Application getApplication() {
        return _application;
    }

    public static Context getApplicationContext() {
        return _applicationContext;
    }

    public static String getGameId() {
        return _gameId;
    }

    public static boolean isAppDebuggable() {
        boolean z2;
        if (getApplicationContext() == null) {
            return false;
        }
        PackageManager packageManager = getApplicationContext().getPackageManager();
        String packageName = getApplicationContext().getPackageName();
        boolean z3 = true;
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            int i2 = applicationInfo.flags & 2;
            applicationInfo.flags = i2;
            if (i2 == 0) {
                z3 = false;
            }
            z2 = z3;
            z3 = false;
        } catch (PackageManager.NameNotFoundException e2) {
            DeviceLog.exception("Could not find name", e2);
            z2 = false;
        }
        if (z3) {
            try {
                for (Signature byteArray : packageManager.getPackageInfo(packageName, 64).signatures) {
                    z2 = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray.toByteArray()))).getSubjectX500Principal().equals(DEBUG_CERT);
                    if (z2) {
                        break;
                    }
                }
            } catch (PackageManager.NameNotFoundException e3) {
                DeviceLog.exception("Could not find name", e3);
            } catch (CertificateException e4) {
                DeviceLog.exception("Certificate exception", e4);
            }
        }
        return z2;
    }

    public static void setActivity(Activity activity) {
        _activity = new WeakReference<>(activity);
    }

    public static void setApplication(Application application) {
        _application = application;
    }

    public static void setApplicationContext(Context context) {
        _applicationContext = context;
    }

    public static void setGameId(String str) {
        _gameId = str;
    }
}
