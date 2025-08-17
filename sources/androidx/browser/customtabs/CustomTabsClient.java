package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;

public class CustomTabsClient {

    /* renamed from: a  reason: collision with root package name */
    private final ICustomTabsService f1593a;

    /* renamed from: b  reason: collision with root package name */
    private final ComponentName f1594b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1595c;

    CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.f1593a = iCustomTabsService;
        this.f1594b = componentName;
        this.f1595c = context;
    }

    public static boolean a(Context context, String str, CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }

    private ICustomTabsCallback.Stub b(final CustomTabsCallback customTabsCallback) {
        return new ICustomTabsCallback.Stub() {

            /* renamed from: b  reason: collision with root package name */
            private Handler f1596b = new Handler(Looper.getMainLooper());

            public void B(final String str, final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.f1596b.post(new Runnable() {
                        public void run() {
                            customTabsCallback.e(str, bundle);
                        }
                    });
                }
            }

            public void C(final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.f1596b.post(new Runnable() {
                        public void run() {
                            customTabsCallback.c(bundle);
                        }
                    });
                }
            }

            public void D(int i2, Uri uri, boolean z2, Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    final int i3 = i2;
                    final Uri uri2 = uri;
                    final boolean z3 = z2;
                    final Bundle bundle2 = bundle;
                    this.f1596b.post(new Runnable() {
                        public void run() {
                            customTabsCallback.f(i3, uri2, z3, bundle2);
                        }
                    });
                }
            }

            public Bundle e(String str, Bundle bundle) throws RemoteException {
                CustomTabsCallback customTabsCallback = customTabsCallback;
                if (customTabsCallback == null) {
                    return null;
                }
                return customTabsCallback.b(str, bundle);
            }

            public void j(final String str, final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.f1596b.post(new Runnable() {
                        public void run() {
                            customTabsCallback.a(str, bundle);
                        }
                    });
                }
            }

            public void z(final int i2, final Bundle bundle) {
                if (customTabsCallback != null) {
                    this.f1596b.post(new Runnable() {
                        public void run() {
                            customTabsCallback.d(i2, bundle);
                        }
                    });
                }
            }
        };
    }

    private CustomTabsSession d(CustomTabsCallback customTabsCallback, PendingIntent pendingIntent) {
        boolean z2;
        ICustomTabsCallback.Stub b2 = b(customTabsCallback);
        if (pendingIntent != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                z2 = this.f1593a.i(b2, bundle);
            } catch (RemoteException unused) {
                return null;
            }
        } else {
            z2 = this.f1593a.x(b2);
        }
        if (!z2) {
            return null;
        }
        return new CustomTabsSession(this.f1593a, b2, this.f1594b, pendingIntent);
    }

    public CustomTabsSession c(CustomTabsCallback customTabsCallback) {
        return d(customTabsCallback, (PendingIntent) null);
    }

    public boolean e(long j2) {
        try {
            return this.f1593a.t(j2);
        } catch (RemoteException unused) {
            return false;
        }
    }
}
