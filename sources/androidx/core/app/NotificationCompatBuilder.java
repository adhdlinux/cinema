package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2428a;

    /* renamed from: b  reason: collision with root package name */
    private final Notification.Builder f2429b;

    /* renamed from: c  reason: collision with root package name */
    private final NotificationCompat.Builder f2430c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f2431d;

    /* renamed from: e  reason: collision with root package name */
    private RemoteViews f2432e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Bundle> f2433f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f2434g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    private int f2435h;

    /* renamed from: i  reason: collision with root package name */
    private RemoteViews f2436i;

    static class Api16Impl {
        private Api16Impl() {
        }

        static Notification a(Notification.Builder builder) {
            return builder.build();
        }

        static Notification.Builder b(Notification.Builder builder, int i2) {
            return builder.setPriority(i2);
        }

        static Notification.Builder c(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSubText(charSequence);
        }

        static Notification.Builder d(Notification.Builder builder, boolean z2) {
            return builder.setUsesChronometer(z2);
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Notification.Builder a(Notification.Builder builder, boolean z2) {
            return builder.setShowWhen(z2);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static Notification.Builder a(Notification.Builder builder, Bundle bundle) {
            return builder.setExtras(bundle);
        }
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Action.Builder e(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i2, charSequence, pendingIntent);
        }

        static String f(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder h(Notification.Builder builder, boolean z2) {
            return builder.setGroupSummary(z2);
        }

        static Notification.Builder i(Notification.Builder builder, boolean z2) {
            return builder.setLocalOnly(z2);
        }

        static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder c(Notification.Builder builder, int i2) {
            return builder.setColor(i2);
        }

        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder f(Notification.Builder builder, int i2) {
            return builder.setVisibility(i2);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder b(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z2) {
            return builder.setAllowGeneratedReplies(z2);
        }

        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder b(Notification.Builder builder, int i2) {
            return builder.setBadgeIconType(i2);
        }

        static Notification.Builder c(Notification.Builder builder, boolean z2) {
            return builder.setColorized(z2);
        }

        static Notification.Builder d(Notification.Builder builder, int i2) {
            return builder.setGroupAlertBehavior(i2);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        static Notification.Builder g(Notification.Builder builder, long j2) {
            return builder.setTimeoutAfter(j2);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, int i2) {
            return builder.setSemanticAction(i2);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static Notification.Builder a(Notification.Builder builder, boolean z2) {
            return builder.setAllowSystemGeneratedContextualActions(z2);
        }

        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z2) {
            return builder.setContextual(z2);
        }

        static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z2) {
            return builder.setAuthenticationRequired(z2);
        }

        static Notification.Builder b(Notification.Builder builder, int i2) {
            return builder.setForegroundServiceBehavior(i2);
        }
    }

    NotificationCompatBuilder(NotificationCompat.Builder builder) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        List<String> list;
        int i2;
        Object obj;
        this.f2430c = builder;
        Context context = builder.f2398a;
        this.f2428a = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2429b = Api26Impl.a(context, builder.K);
        } else {
            this.f2429b = new Notification.Builder(builder.f2398a);
        }
        Notification notification = builder.R;
        Notification.Builder lights = this.f2429b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.f2406i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z2);
        if ((notification.flags & 8) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z3);
        if ((notification.flags & 16) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z4).setDefaults(notification.defaults).setContentTitle(builder.f2402e).setContentText(builder.f2403f).setContentInfo(builder.f2408k).setContentIntent(builder.f2404g).setDeleteIntent(notification.deleteIntent);
        PendingIntent pendingIntent = builder.f2405h;
        if ((notification.flags & 128) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        deleteIntent.setFullScreenIntent(pendingIntent, z5).setLargeIcon(builder.f2407j).setNumber(builder.f2409l).setProgress(builder.f2417t, builder.f2418u, builder.f2419v);
        Api16Impl.b(Api16Impl.d(Api16Impl.c(this.f2429b, builder.f2414q), builder.f2412o), builder.f2410m);
        Iterator<NotificationCompat.Action> it2 = builder.f2399b.iterator();
        while (it2.hasNext()) {
            b(it2.next());
        }
        Bundle bundle = builder.D;
        if (bundle != null) {
            this.f2434g.putAll(bundle);
        }
        int i3 = Build.VERSION.SDK_INT;
        this.f2431d = builder.H;
        this.f2432e = builder.I;
        Api17Impl.a(this.f2429b, builder.f2411n);
        Api20Impl.i(this.f2429b, builder.f2423z);
        Api20Impl.g(this.f2429b, builder.f2420w);
        Api20Impl.j(this.f2429b, builder.f2422y);
        Api20Impl.h(this.f2429b, builder.f2421x);
        this.f2435h = builder.O;
        Api21Impl.b(this.f2429b, builder.C);
        Api21Impl.c(this.f2429b, builder.E);
        Api21Impl.f(this.f2429b, builder.F);
        Api21Impl.d(this.f2429b, builder.G);
        Api21Impl.e(this.f2429b, notification.sound, notification.audioAttributes);
        if (i3 < 28) {
            list = e(f(builder.f2400c), builder.U);
        } else {
            list = builder.U;
        }
        if (list != null && !list.isEmpty()) {
            for (String a2 : list) {
                Api21Impl.a(this.f2429b, a2);
            }
        }
        this.f2436i = builder.J;
        if (builder.f2401d.size() > 0) {
            Bundle bundle2 = builder.d().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i4 = 0; i4 < builder.f2401d.size(); i4++) {
                bundle4.putBundle(Integer.toString(i4), NotificationCompatJellybean.a(builder.f2401d.get(i4)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            builder.d().putBundle("android.car.EXTENSIONS", bundle2);
            this.f2434g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 23 && (obj = builder.T) != null) {
            Api23Impl.b(this.f2429b, obj);
        }
        if (i5 >= 24) {
            Api19Impl.a(this.f2429b, builder.D);
            Api24Impl.e(this.f2429b, builder.f2416s);
            RemoteViews remoteViews = builder.H;
            if (remoteViews != null) {
                Api24Impl.c(this.f2429b, remoteViews);
            }
            RemoteViews remoteViews2 = builder.I;
            if (remoteViews2 != null) {
                Api24Impl.b(this.f2429b, remoteViews2);
            }
            RemoteViews remoteViews3 = builder.J;
            if (remoteViews3 != null) {
                Api24Impl.d(this.f2429b, remoteViews3);
            }
        }
        if (i5 >= 26) {
            Api26Impl.b(this.f2429b, builder.L);
            Api26Impl.e(this.f2429b, builder.f2415r);
            Api26Impl.f(this.f2429b, builder.M);
            Api26Impl.g(this.f2429b, builder.N);
            Api26Impl.d(this.f2429b, builder.O);
            if (builder.B) {
                Api26Impl.c(this.f2429b, builder.A);
            }
            if (!TextUtils.isEmpty(builder.K)) {
                this.f2429b.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (i5 >= 28) {
            Iterator<Person> it3 = builder.f2400c.iterator();
            while (it3.hasNext()) {
                Api28Impl.a(this.f2429b, it3.next().h());
            }
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            Api29Impl.a(this.f2429b, builder.Q);
            Api29Impl.b(this.f2429b, NotificationCompat.BubbleMetadata.a((NotificationCompat.BubbleMetadata) null));
        }
        if (i6 >= 31 && (i2 = builder.P) != 0) {
            Api31Impl.b(this.f2429b, i2);
        }
        if (builder.S) {
            if (this.f2430c.f2421x) {
                this.f2435h = 2;
            } else {
                this.f2435h = 1;
            }
            this.f2429b.setVibrate((long[]) null);
            this.f2429b.setSound((Uri) null);
            int i7 = notification.defaults & -2 & -3;
            notification.defaults = i7;
            this.f2429b.setDefaults(i7);
            if (i6 >= 26) {
                if (TextUtils.isEmpty(this.f2430c.f2420w)) {
                    Api20Impl.g(this.f2429b, "silent");
                }
                Api26Impl.d(this.f2429b, this.f2435h);
            }
        }
    }

    private void b(NotificationCompat.Action action) {
        Notification.Action.Builder builder;
        Bundle bundle;
        int i2;
        Icon icon;
        int i3 = Build.VERSION.SDK_INT;
        IconCompat d2 = action.d();
        if (i3 >= 23) {
            if (d2 != null) {
                icon = d2.p();
            } else {
                icon = null;
            }
            builder = Api23Impl.a(icon, action.h(), action.a());
        } else {
            if (d2 != null) {
                i2 = d2.i();
            } else {
                i2 = 0;
            }
            builder = Api20Impl.e(i2, action.h(), action.a());
        }
        if (action.e() != null) {
            for (RemoteInput c2 : RemoteInput.b(action.e())) {
                Api20Impl.c(builder, c2);
            }
        }
        if (action.c() != null) {
            bundle = new Bundle(action.c());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.b());
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            Api24Impl.a(builder, action.b());
        }
        bundle.putInt("android.support.action.semanticAction", action.f());
        if (i4 >= 28) {
            Api28Impl.b(builder, action.f());
        }
        if (i4 >= 29) {
            Api29Impl.c(builder, action.j());
        }
        if (i4 >= 31) {
            Api31Impl.a(builder, action.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.g());
        Api20Impl.b(builder, bundle);
        Api20Impl.a(this.f2429b, Api20Impl.d(builder));
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    private static List<String> f(List<Person> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Person g2 : list) {
            arrayList.add(g2.g());
        }
        return arrayList;
    }

    private void g(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & -2 & -3;
    }

    public Notification.Builder a() {
        return this.f2429b;
    }

    public Notification c() {
        RemoteViews remoteViews;
        Bundle a2;
        RemoteViews f2;
        RemoteViews d2;
        NotificationCompat.Style style = this.f2430c.f2413p;
        if (style != null) {
            style.b(this);
        }
        if (style != null) {
            remoteViews = style.e(this);
        } else {
            remoteViews = null;
        }
        Notification d3 = d();
        if (remoteViews != null) {
            d3.contentView = remoteViews;
        } else {
            RemoteViews remoteViews2 = this.f2430c.H;
            if (remoteViews2 != null) {
                d3.contentView = remoteViews2;
            }
        }
        if (!(style == null || (d2 = style.d(this)) == null)) {
            d3.bigContentView = d2;
        }
        if (!(style == null || (f2 = this.f2430c.f2413p.f(this)) == null)) {
            d3.headsUpContentView = f2;
        }
        if (!(style == null || (a2 = NotificationCompat.a(d3)) == null)) {
            style.a(a2);
        }
        return d3;
    }

    /* access modifiers changed from: protected */
    public Notification d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return Api16Impl.a(this.f2429b);
        }
        if (i2 >= 24) {
            Notification a2 = Api16Impl.a(this.f2429b);
            if (this.f2435h != 0) {
                if (!(Api20Impl.f(a2) == null || (a2.flags & 512) == 0 || this.f2435h != 2)) {
                    g(a2);
                }
                if (Api20Impl.f(a2) != null && (a2.flags & 512) == 0 && this.f2435h == 1) {
                    g(a2);
                }
            }
            return a2;
        }
        Api19Impl.a(this.f2429b, this.f2434g);
        Notification a3 = Api16Impl.a(this.f2429b);
        RemoteViews remoteViews = this.f2431d;
        if (remoteViews != null) {
            a3.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f2432e;
        if (remoteViews2 != null) {
            a3.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f2436i;
        if (remoteViews3 != null) {
            a3.headsUpContentView = remoteViews3;
        }
        if (this.f2435h != 0) {
            if (!(Api20Impl.f(a3) == null || (a3.flags & 512) == 0 || this.f2435h != 2)) {
                g(a3);
            }
            if (Api20Impl.f(a3) != null && (a3.flags & 512) == 0 && this.f2435h == 1) {
                g(a3);
            }
        }
        return a3;
    }
}
