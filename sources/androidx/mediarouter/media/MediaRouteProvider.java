package androidx.mediarouter.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

public abstract class MediaRouteProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10507a;

    /* renamed from: b  reason: collision with root package name */
    private final ProviderMetadata f10508b;

    /* renamed from: c  reason: collision with root package name */
    private final ProviderHandler f10509c;

    /* renamed from: d  reason: collision with root package name */
    private Callback f10510d;

    /* renamed from: e  reason: collision with root package name */
    private MediaRouteDiscoveryRequest f10511e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10512f;

    /* renamed from: g  reason: collision with root package name */
    private MediaRouteProviderDescriptor f10513g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10514h;

    public static abstract class Callback {
        public void a(MediaRouteProvider mediaRouteProvider, MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
        }
    }

    public static abstract class DynamicGroupRouteController extends RouteController {

        /* renamed from: a  reason: collision with root package name */
        private final Object f10515a = new Object();

        /* renamed from: b  reason: collision with root package name */
        Executor f10516b;

        /* renamed from: c  reason: collision with root package name */
        OnDynamicRoutesChangedListener f10517c;

        /* renamed from: d  reason: collision with root package name */
        MediaRouteDescriptor f10518d;

        /* renamed from: e  reason: collision with root package name */
        Collection<DynamicRouteDescriptor> f10519e;

        public static final class DynamicRouteDescriptor {

            /* renamed from: a  reason: collision with root package name */
            final MediaRouteDescriptor f10528a;

            /* renamed from: b  reason: collision with root package name */
            final int f10529b;

            /* renamed from: c  reason: collision with root package name */
            final boolean f10530c;

            /* renamed from: d  reason: collision with root package name */
            final boolean f10531d;

            /* renamed from: e  reason: collision with root package name */
            final boolean f10532e;

            public static final class Builder {

                /* renamed from: a  reason: collision with root package name */
                private final MediaRouteDescriptor f10533a;

                /* renamed from: b  reason: collision with root package name */
                private int f10534b = 1;

                /* renamed from: c  reason: collision with root package name */
                private boolean f10535c = false;

                /* renamed from: d  reason: collision with root package name */
                private boolean f10536d = false;

                /* renamed from: e  reason: collision with root package name */
                private boolean f10537e = false;

                public Builder(MediaRouteDescriptor mediaRouteDescriptor) {
                    if (mediaRouteDescriptor != null) {
                        this.f10533a = mediaRouteDescriptor;
                        return;
                    }
                    throw new NullPointerException("descriptor must not be null");
                }

                public DynamicRouteDescriptor a() {
                    return new DynamicRouteDescriptor(this.f10533a, this.f10534b, this.f10535c, this.f10536d, this.f10537e);
                }

                public Builder b(boolean z2) {
                    this.f10536d = z2;
                    return this;
                }

                public Builder c(boolean z2) {
                    this.f10537e = z2;
                    return this;
                }

                public Builder d(boolean z2) {
                    this.f10535c = z2;
                    return this;
                }

                public Builder e(int i2) {
                    this.f10534b = i2;
                    return this;
                }
            }

            DynamicRouteDescriptor(MediaRouteDescriptor mediaRouteDescriptor, int i2, boolean z2, boolean z3, boolean z4) {
                this.f10528a = mediaRouteDescriptor;
                this.f10529b = i2;
                this.f10530c = z2;
                this.f10531d = z3;
                this.f10532e = z4;
            }

            static DynamicRouteDescriptor a(Bundle bundle) {
                if (bundle == null) {
                    return null;
                }
                return new DynamicRouteDescriptor(MediaRouteDescriptor.d(bundle.getBundle("mrDescriptor")), bundle.getInt("selectionState", 1), bundle.getBoolean("isUnselectable", false), bundle.getBoolean("isGroupable", false), bundle.getBoolean("isTransferable", false));
            }

            public MediaRouteDescriptor b() {
                return this.f10528a;
            }

            public int c() {
                return this.f10529b;
            }

            public boolean d() {
                return this.f10531d;
            }

            public boolean e() {
                return this.f10532e;
            }

            public boolean f() {
                return this.f10530c;
            }
        }

        interface OnDynamicRoutesChangedListener {
            void a(DynamicGroupRouteController dynamicGroupRouteController, MediaRouteDescriptor mediaRouteDescriptor, Collection<DynamicRouteDescriptor> collection);
        }

        public String j() {
            return null;
        }

        public String k() {
            return null;
        }

        public final void l(final MediaRouteDescriptor mediaRouteDescriptor, final Collection<DynamicRouteDescriptor> collection) {
            if (mediaRouteDescriptor == null) {
                throw new NullPointerException("groupRoute must not be null");
            } else if (collection != null) {
                synchronized (this.f10515a) {
                    Executor executor = this.f10516b;
                    if (executor != null) {
                        final OnDynamicRoutesChangedListener onDynamicRoutesChangedListener = this.f10517c;
                        executor.execute(new Runnable() {
                            public void run() {
                                onDynamicRoutesChangedListener.a(DynamicGroupRouteController.this, mediaRouteDescriptor, collection);
                            }
                        });
                    } else {
                        this.f10518d = mediaRouteDescriptor;
                        this.f10519e = new ArrayList(collection);
                    }
                }
            } else {
                throw new NullPointerException("dynamicRoutes must not be null");
            }
        }

        public abstract void m(String str);

        public abstract void n(String str);

        public abstract void o(List<String> list);

        /* access modifiers changed from: package-private */
        public void p(Executor executor, final OnDynamicRoutesChangedListener onDynamicRoutesChangedListener) {
            synchronized (this.f10515a) {
                if (executor == null) {
                    throw new NullPointerException("Executor shouldn't be null");
                } else if (onDynamicRoutesChangedListener != null) {
                    this.f10516b = executor;
                    this.f10517c = onDynamicRoutesChangedListener;
                    Collection<DynamicRouteDescriptor> collection = this.f10519e;
                    if (collection != null && !collection.isEmpty()) {
                        final MediaRouteDescriptor mediaRouteDescriptor = this.f10518d;
                        final Collection<DynamicRouteDescriptor> collection2 = this.f10519e;
                        this.f10518d = null;
                        this.f10519e = null;
                        this.f10516b.execute(new Runnable() {
                            public void run() {
                                onDynamicRoutesChangedListener.a(DynamicGroupRouteController.this, mediaRouteDescriptor, collection2);
                            }
                        });
                    }
                } else {
                    throw new NullPointerException("Listener shouldn't be null");
                }
            }
        }
    }

    private final class ProviderHandler extends Handler {
        ProviderHandler() {
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                MediaRouteProvider.this.l();
            } else if (i2 == 2) {
                MediaRouteProvider.this.m();
            }
        }
    }

    public static final class ProviderMetadata {

        /* renamed from: a  reason: collision with root package name */
        private final ComponentName f10539a;

        ProviderMetadata(ComponentName componentName) {
            if (componentName != null) {
                this.f10539a = componentName;
                return;
            }
            throw new IllegalArgumentException("componentName must not be null");
        }

        public ComponentName a() {
            return this.f10539a;
        }

        public String b() {
            return this.f10539a.getPackageName();
        }

        public String toString() {
            return "ProviderMetadata{ componentName=" + this.f10539a.flattenToShortString() + " }";
        }
    }

    public static abstract class RouteController {
        public void d() {
        }

        public void e() {
        }

        public void f(int i2) {
        }

        @Deprecated
        public void g() {
        }

        public void h(int i2) {
            g();
        }

        public void i(int i2) {
        }
    }

    public MediaRouteProvider(Context context) {
        this(context, (ProviderMetadata) null);
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f10514h = false;
        Callback callback = this.f10510d;
        if (callback != null) {
            callback.a(this, this.f10513g);
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        this.f10512f = false;
        u(this.f10511e);
    }

    public final Context n() {
        return this.f10507a;
    }

    public final MediaRouteProviderDescriptor o() {
        return this.f10513g;
    }

    public final MediaRouteDiscoveryRequest p() {
        return this.f10511e;
    }

    public final ProviderMetadata q() {
        return this.f10508b;
    }

    public DynamicGroupRouteController r(String str) {
        if (str != null) {
            return null;
        }
        throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
    }

    public RouteController s(String str) {
        if (str != null) {
            return null;
        }
        throw new IllegalArgumentException("routeId cannot be null");
    }

    public RouteController t(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        } else if (str2 != null) {
            return s(str);
        } else {
            throw new IllegalArgumentException("routeGroupId cannot be null");
        }
    }

    public void u(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
    }

    public final void v(Callback callback) {
        MediaRouter.d();
        this.f10510d = callback;
    }

    public final void w(MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
        MediaRouter.d();
        if (this.f10513g != mediaRouteProviderDescriptor) {
            this.f10513g = mediaRouteProviderDescriptor;
            if (!this.f10514h) {
                this.f10514h = true;
                this.f10509c.sendEmptyMessage(1);
            }
        }
    }

    public final void x(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
        MediaRouter.d();
        if (!ObjectsCompat.a(this.f10511e, mediaRouteDiscoveryRequest)) {
            y(mediaRouteDiscoveryRequest);
        }
    }

    /* access modifiers changed from: package-private */
    public final void y(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
        this.f10511e = mediaRouteDiscoveryRequest;
        if (!this.f10512f) {
            this.f10512f = true;
            this.f10509c.sendEmptyMessage(2);
        }
    }

    MediaRouteProvider(Context context, ProviderMetadata providerMetadata) {
        this.f10509c = new ProviderHandler();
        if (context != null) {
            this.f10507a = context;
            if (providerMetadata == null) {
                this.f10508b = new ProviderMetadata(new ComponentName(context, getClass()));
            } else {
                this.f10508b = providerMetadata;
            }
        } else {
            throw new IllegalArgumentException("context must not be null");
        }
    }
}
