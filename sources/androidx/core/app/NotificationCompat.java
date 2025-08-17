package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.R$dimen;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;

public class NotificationCompat {

    public static class Action {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f2375a;

        /* renamed from: b  reason: collision with root package name */
        private IconCompat f2376b;

        /* renamed from: c  reason: collision with root package name */
        private final RemoteInput[] f2377c;

        /* renamed from: d  reason: collision with root package name */
        private final RemoteInput[] f2378d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2379e;

        /* renamed from: f  reason: collision with root package name */
        boolean f2380f;

        /* renamed from: g  reason: collision with root package name */
        private final int f2381g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f2382h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        public int f2383i;

        /* renamed from: j  reason: collision with root package name */
        public CharSequence f2384j;

        /* renamed from: k  reason: collision with root package name */
        public PendingIntent f2385k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f2386l;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private final IconCompat f2387a;

            /* renamed from: b  reason: collision with root package name */
            private final CharSequence f2388b;

            /* renamed from: c  reason: collision with root package name */
            private final PendingIntent f2389c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f2390d;

            /* renamed from: e  reason: collision with root package name */
            private final Bundle f2391e;

            /* renamed from: f  reason: collision with root package name */
            private ArrayList<RemoteInput> f2392f;

            /* renamed from: g  reason: collision with root package name */
            private int f2393g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f2394h;

            /* renamed from: i  reason: collision with root package name */
            private boolean f2395i;

            /* renamed from: j  reason: collision with root package name */
            private boolean f2396j;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public Builder(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i2 != 0 ? IconCompat.h((Resources) null, "", i2) : null, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, true, 0, true, false, false);
            }

            private void b() {
                if (this.f2395i && this.f2389c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            /* JADX WARNING: type inference failed for: r1v5, types: [java.lang.Object[]] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public androidx.core.app.NotificationCompat.Action a() {
                /*
                    r17 = this;
                    r0 = r17
                    r17.b()
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.ArrayList<androidx.core.app.RemoteInput> r3 = r0.f2392f
                    if (r3 == 0) goto L_0x0031
                    java.util.Iterator r3 = r3.iterator()
                L_0x0017:
                    boolean r4 = r3.hasNext()
                    if (r4 == 0) goto L_0x0031
                    java.lang.Object r4 = r3.next()
                    androidx.core.app.RemoteInput r4 = (androidx.core.app.RemoteInput) r4
                    boolean r5 = r4.j()
                    if (r5 == 0) goto L_0x002d
                    r1.add(r4)
                    goto L_0x0017
                L_0x002d:
                    r2.add(r4)
                    goto L_0x0017
                L_0x0031:
                    boolean r3 = r1.isEmpty()
                    r4 = 0
                    if (r3 == 0) goto L_0x003a
                    r11 = r4
                    goto L_0x0047
                L_0x003a:
                    int r3 = r1.size()
                    androidx.core.app.RemoteInput[] r3 = new androidx.core.app.RemoteInput[r3]
                    java.lang.Object[] r1 = r1.toArray(r3)
                    androidx.core.app.RemoteInput[] r1 = (androidx.core.app.RemoteInput[]) r1
                    r11 = r1
                L_0x0047:
                    boolean r1 = r2.isEmpty()
                    if (r1 == 0) goto L_0x004e
                    goto L_0x005b
                L_0x004e:
                    int r1 = r2.size()
                    androidx.core.app.RemoteInput[] r1 = new androidx.core.app.RemoteInput[r1]
                    java.lang.Object[] r1 = r2.toArray(r1)
                    r4 = r1
                    androidx.core.app.RemoteInput[] r4 = (androidx.core.app.RemoteInput[]) r4
                L_0x005b:
                    r10 = r4
                    androidx.core.app.NotificationCompat$Action r1 = new androidx.core.app.NotificationCompat$Action
                    androidx.core.graphics.drawable.IconCompat r6 = r0.f2387a
                    java.lang.CharSequence r7 = r0.f2388b
                    android.app.PendingIntent r8 = r0.f2389c
                    android.os.Bundle r9 = r0.f2391e
                    boolean r12 = r0.f2390d
                    int r13 = r0.f2393g
                    boolean r14 = r0.f2394h
                    boolean r15 = r0.f2395i
                    boolean r2 = r0.f2396j
                    r5 = r1
                    r16 = r2
                    r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Action.Builder.a():androidx.core.app.NotificationCompat$Action");
            }

            private Builder(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z2, int i2, boolean z3, boolean z4, boolean z5) {
                ArrayList<RemoteInput> arrayList;
                this.f2390d = true;
                this.f2394h = true;
                this.f2387a = iconCompat;
                this.f2388b = Builder.e(charSequence);
                this.f2389c = pendingIntent;
                this.f2391e = bundle;
                if (remoteInputArr == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList<>(Arrays.asList(remoteInputArr));
                }
                this.f2392f = arrayList;
                this.f2390d = z2;
                this.f2393g = i2;
                this.f2394h = z3;
                this.f2395i = z4;
                this.f2396j = z5;
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Action(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.h((Resources) null, "", i2) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f2385k;
        }

        public boolean b() {
            return this.f2379e;
        }

        public Bundle c() {
            return this.f2375a;
        }

        public IconCompat d() {
            int i2;
            if (this.f2376b == null && (i2 = this.f2383i) != 0) {
                this.f2376b = IconCompat.h((Resources) null, "", i2);
            }
            return this.f2376b;
        }

        public RemoteInput[] e() {
            return this.f2377c;
        }

        public int f() {
            return this.f2381g;
        }

        public boolean g() {
            return this.f2380f;
        }

        public CharSequence h() {
            return this.f2384j;
        }

        public boolean i() {
            return this.f2386l;
        }

        public boolean j() {
            return this.f2382h;
        }

        public Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, (RemoteInput[]) null, true, 0, true, false, false);
        }

        Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z2, int i2, boolean z3, boolean z4, boolean z5) {
            this.f2380f = true;
            this.f2376b = iconCompat;
            if (iconCompat != null && iconCompat.k() == 2) {
                this.f2383i = iconCompat.i();
            }
            this.f2384j = Builder.e(charSequence);
            this.f2385k = pendingIntent;
            this.f2375a = bundle == null ? new Bundle() : bundle;
            this.f2377c = remoteInputArr;
            this.f2378d = remoteInputArr2;
            this.f2379e = z2;
            this.f2381g = i2;
            this.f2380f = z3;
            this.f2382h = z4;
            this.f2386l = z5;
        }
    }

    public static class BigTextStyle extends Style {

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f2397e;

        static class Api16Impl {
            private Api16Impl() {
            }

            static Notification.BigTextStyle a(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.bigText(charSequence);
            }

            static Notification.BigTextStyle b(Notification.Builder builder) {
                return new Notification.BigTextStyle(builder);
            }

            static Notification.BigTextStyle c(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setBigContentTitle(charSequence);
            }

            static Notification.BigTextStyle d(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setSummaryText(charSequence);
            }
        }

        public void a(Bundle bundle) {
            super.a(bundle);
        }

        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.BigTextStyle a2 = Api16Impl.a(Api16Impl.c(Api16Impl.b(notificationBuilderWithBuilderAccessor.a()), this.f2425b), this.f2397e);
            if (this.f2427d) {
                Api16Impl.d(a2, this.f2426c);
            }
        }

        /* access modifiers changed from: protected */
        public String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public BigTextStyle h(CharSequence charSequence) {
            this.f2397e = Builder.e(charSequence);
            return this;
        }
    }

    public static final class BubbleMetadata {
        public static Notification.BubbleMetadata a(BubbleMetadata bubbleMetadata) {
            return null;
        }
    }

    public static abstract class Style {

        /* renamed from: a  reason: collision with root package name */
        protected Builder f2424a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f2425b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f2426c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2427d = false;

        public void a(Bundle bundle) {
            if (this.f2427d) {
                bundle.putCharSequence("android.summaryText", this.f2426c);
            }
            CharSequence charSequence = this.f2425b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c2 = c();
            if (c2 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c2);
            }
        }

        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        /* access modifiers changed from: protected */
        public String c() {
            return null;
        }

        public RemoteViews d(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews e(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews f(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public void g(Builder builder) {
            if (this.f2424a != builder) {
                this.f2424a = builder;
                if (builder != null) {
                    builder.z(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    public static class Builder {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        int P;
        boolean Q;
        Notification R;
        boolean S;
        Object T;
        @Deprecated
        public ArrayList<String> U;

        /* renamed from: a  reason: collision with root package name */
        public Context f2398a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<Action> f2399b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<Person> f2400c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Action> f2401d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f2402e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f2403f;

        /* renamed from: g  reason: collision with root package name */
        PendingIntent f2404g;

        /* renamed from: h  reason: collision with root package name */
        PendingIntent f2405h;

        /* renamed from: i  reason: collision with root package name */
        RemoteViews f2406i;

        /* renamed from: j  reason: collision with root package name */
        Bitmap f2407j;

        /* renamed from: k  reason: collision with root package name */
        CharSequence f2408k;

        /* renamed from: l  reason: collision with root package name */
        int f2409l;

        /* renamed from: m  reason: collision with root package name */
        int f2410m;

        /* renamed from: n  reason: collision with root package name */
        boolean f2411n;

        /* renamed from: o  reason: collision with root package name */
        boolean f2412o;

        /* renamed from: p  reason: collision with root package name */
        Style f2413p;

        /* renamed from: q  reason: collision with root package name */
        CharSequence f2414q;

        /* renamed from: r  reason: collision with root package name */
        CharSequence f2415r;

        /* renamed from: s  reason: collision with root package name */
        CharSequence[] f2416s;

        /* renamed from: t  reason: collision with root package name */
        int f2417t;

        /* renamed from: u  reason: collision with root package name */
        int f2418u;

        /* renamed from: v  reason: collision with root package name */
        boolean f2419v;

        /* renamed from: w  reason: collision with root package name */
        String f2420w;

        /* renamed from: x  reason: collision with root package name */
        boolean f2421x;

        /* renamed from: y  reason: collision with root package name */
        String f2422y;

        /* renamed from: z  reason: collision with root package name */
        boolean f2423z;

        public Builder(Context context, String str) {
            this.f2399b = new ArrayList<>();
            this.f2400c = new ArrayList<>();
            this.f2401d = new ArrayList<>();
            this.f2411n = true;
            this.f2423z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.R = notification;
            this.f2398a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.f2410m = 0;
            this.U = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence e(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }

        private Bitmap f(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f2398a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.f2269b);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.f2268a);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
        }

        private void o(int i2, boolean z2) {
            if (z2) {
                Notification notification = this.R;
                notification.flags = i2 | notification.flags;
                return;
            }
            Notification notification2 = this.R;
            notification2.flags = (~i2) & notification2.flags;
        }

        public Builder A(CharSequence charSequence) {
            this.R.tickerText = e(charSequence);
            return this;
        }

        public Builder B(int i2) {
            this.F = i2;
            return this;
        }

        public Builder C(long j2) {
            this.R.when = j2;
            return this;
        }

        public Builder a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f2399b.add(new Action(i2, charSequence, pendingIntent));
            return this;
        }

        public Builder b(Action action) {
            if (action != null) {
                this.f2399b.add(action);
            }
            return this;
        }

        public Notification c() {
            return new NotificationCompatBuilder(this).c();
        }

        public Bundle d() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public Builder g(boolean z2) {
            o(16, z2);
            return this;
        }

        public Builder h(String str) {
            this.C = str;
            return this;
        }

        public Builder i(String str) {
            this.K = str;
            return this;
        }

        public Builder j(boolean z2) {
            this.A = z2;
            this.B = true;
            return this;
        }

        public Builder k(PendingIntent pendingIntent) {
            this.f2404g = pendingIntent;
            return this;
        }

        public Builder l(CharSequence charSequence) {
            this.f2403f = e(charSequence);
            return this;
        }

        public Builder m(CharSequence charSequence) {
            this.f2402e = e(charSequence);
            return this;
        }

        public Builder n(PendingIntent pendingIntent) {
            this.R.deleteIntent = pendingIntent;
            return this;
        }

        public Builder p(int i2) {
            this.P = i2;
            return this;
        }

        public Builder q(Bitmap bitmap) {
            this.f2407j = f(bitmap);
            return this;
        }

        public Builder r(boolean z2) {
            this.f2423z = z2;
            return this;
        }

        public Builder s(boolean z2) {
            o(2, z2);
            return this;
        }

        public Builder t(boolean z2) {
            o(8, z2);
            return this;
        }

        public Builder u(int i2) {
            this.f2410m = i2;
            return this;
        }

        public Builder v(int i2, int i3, boolean z2) {
            this.f2417t = i2;
            this.f2418u = i3;
            this.f2419v = z2;
            return this;
        }

        public Builder w(boolean z2) {
            this.f2411n = z2;
            return this;
        }

        public Builder x(boolean z2) {
            this.S = z2;
            return this;
        }

        public Builder y(int i2) {
            this.R.icon = i2;
            return this;
        }

        public Builder z(Style style) {
            if (this.f2413p != style) {
                this.f2413p = style;
                if (style != null) {
                    style.g(this);
                }
            }
            return this;
        }

        @Deprecated
        public Builder(Context context) {
            this(context, (String) null);
        }
    }
}
