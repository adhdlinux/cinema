package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.core.app.BundleCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;

public final class CustomTabsIntent {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f1615a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f1616b;

    CustomTabsIntent(Intent intent, Bundle bundle) {
        this.f1615a = intent;
        this.f1616b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f1615a.setData(uri);
        ContextCompat.startActivity(context, this.f1615a, this.f1616b);
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Intent f1617a = new Intent("android.intent.action.VIEW");

        /* renamed from: b  reason: collision with root package name */
        private final CustomTabColorSchemeParams.Builder f1618b = new CustomTabColorSchemeParams.Builder();

        /* renamed from: c  reason: collision with root package name */
        private ArrayList<Bundle> f1619c;

        /* renamed from: d  reason: collision with root package name */
        private Bundle f1620d;

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<Bundle> f1621e;

        /* renamed from: f  reason: collision with root package name */
        private SparseArray<Bundle> f1622f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f1623g;

        /* renamed from: h  reason: collision with root package name */
        private int f1624h = 0;

        /* renamed from: i  reason: collision with root package name */
        private boolean f1625i = true;

        public Builder() {
        }

        private void c(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            BundleCompat.b(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f1617a.putExtras(bundle);
        }

        public CustomTabsIntent a() {
            if (!this.f1617a.hasExtra("android.support.customtabs.extra.SESSION")) {
                c((IBinder) null, (PendingIntent) null);
            }
            ArrayList<Bundle> arrayList = this.f1619c;
            if (arrayList != null) {
                this.f1617a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f1621e;
            if (arrayList2 != null) {
                this.f1617a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f1617a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f1625i);
            this.f1617a.putExtras(this.f1618b.a().a());
            Bundle bundle = this.f1623g;
            if (bundle != null) {
                this.f1617a.putExtras(bundle);
            }
            if (this.f1622f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f1622f);
                this.f1617a.putExtras(bundle2);
            }
            this.f1617a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f1624h);
            return new CustomTabsIntent(this.f1617a, this.f1620d);
        }

        public Builder b(CustomTabsSession customTabsSession) {
            this.f1617a.setPackage(customTabsSession.b().getPackageName());
            c(customTabsSession.a(), customTabsSession.c());
            return this;
        }

        public Builder(CustomTabsSession customTabsSession) {
            if (customTabsSession != null) {
                b(customTabsSession);
            }
        }
    }
}
