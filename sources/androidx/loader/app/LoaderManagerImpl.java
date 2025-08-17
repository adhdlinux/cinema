package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.e;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {

    /* renamed from: c  reason: collision with root package name */
    static boolean f3780c = false;

    /* renamed from: a  reason: collision with root package name */
    private final LifecycleOwner f3781a;

    /* renamed from: b  reason: collision with root package name */
    private final LoaderViewModel f3782b;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {

        /* renamed from: l  reason: collision with root package name */
        private final int f3783l;

        /* renamed from: m  reason: collision with root package name */
        private final Bundle f3784m;

        /* renamed from: n  reason: collision with root package name */
        private final Loader<D> f3785n;

        /* renamed from: o  reason: collision with root package name */
        private LifecycleOwner f3786o;

        /* renamed from: p  reason: collision with root package name */
        private LoaderObserver<D> f3787p;

        /* renamed from: q  reason: collision with root package name */
        private Loader<D> f3788q;

        LoaderInfo(int i2, Bundle bundle, Loader<D> loader, Loader<D> loader2) {
            this.f3783l = i2;
            this.f3784m = bundle;
            this.f3785n = loader;
            this.f3788q = loader2;
            loader.registerListener(i2, this);
        }

        public void a(Loader<D> loader, D d2) {
            if (LoaderManagerImpl.f3780c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                n(d2);
                return;
            }
            if (LoaderManagerImpl.f3780c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            l(d2);
        }

        /* access modifiers changed from: protected */
        public void j() {
            if (LoaderManagerImpl.f3780c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f3785n.startLoading();
        }

        /* access modifiers changed from: protected */
        public void k() {
            if (LoaderManagerImpl.f3780c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f3785n.stopLoading();
        }

        public void m(Observer<? super D> observer) {
            super.m(observer);
            this.f3786o = null;
            this.f3787p = null;
        }

        public void n(D d2) {
            super.n(d2);
            Loader<D> loader = this.f3788q;
            if (loader != null) {
                loader.reset();
                this.f3788q = null;
            }
        }

        /* access modifiers changed from: package-private */
        public Loader<D> o(boolean z2) {
            if (LoaderManagerImpl.f3780c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f3785n.cancelLoad();
            this.f3785n.abandon();
            LoaderObserver<D> loaderObserver = this.f3787p;
            if (loaderObserver != null) {
                m(loaderObserver);
                if (z2) {
                    loaderObserver.d();
                }
            }
            this.f3785n.unregisterListener(this);
            if ((loaderObserver == null || loaderObserver.c()) && !z2) {
                return this.f3785n;
            }
            this.f3785n.reset();
            return this.f3788q;
        }

        public void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f3783l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f3784m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f3785n);
            Loader<D> loader = this.f3785n;
            loader.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f3787p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f3787p);
                LoaderObserver<D> loaderObserver = this.f3787p;
                loaderObserver.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(q().dataToString(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(g());
        }

        /* access modifiers changed from: package-private */
        public Loader<D> q() {
            return this.f3785n;
        }

        /* access modifiers changed from: package-private */
        public void r() {
            LifecycleOwner lifecycleOwner = this.f3786o;
            LoaderObserver<D> loaderObserver = this.f3787p;
            if (lifecycleOwner != null && loaderObserver != null) {
                super.m(loaderObserver);
                h(lifecycleOwner, loaderObserver);
            }
        }

        /* access modifiers changed from: package-private */
        public Loader<D> s(LifecycleOwner lifecycleOwner, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            LoaderObserver<D> loaderObserver = new LoaderObserver<>(this.f3785n, loaderCallbacks);
            h(lifecycleOwner, loaderObserver);
            LoaderObserver<D> loaderObserver2 = this.f3787p;
            if (loaderObserver2 != null) {
                m(loaderObserver2);
            }
            this.f3786o = lifecycleOwner;
            this.f3787p = loaderObserver;
            return this.f3785n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f3783l);
            sb.append(" : ");
            DebugUtils.a(this.f3785n, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    static class LoaderObserver<D> implements Observer<D> {

        /* renamed from: a  reason: collision with root package name */
        private final Loader<D> f3789a;

        /* renamed from: b  reason: collision with root package name */
        private final LoaderManager.LoaderCallbacks<D> f3790b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3791c = false;

        LoaderObserver(Loader<D> loader, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.f3789a = loader;
            this.f3790b = loaderCallbacks;
        }

        public void a(D d2) {
            if (LoaderManagerImpl.f3780c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f3789a + ": " + this.f3789a.dataToString(d2));
            }
            this.f3790b.onLoadFinished(this.f3789a, d2);
            this.f3791c = true;
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f3791c);
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f3791c;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (this.f3791c) {
                if (LoaderManagerImpl.f3780c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f3789a);
                }
                this.f3790b.onLoaderReset(this.f3789a);
            }
        }

        public String toString() {
            return this.f3790b.toString();
        }
    }

    static class LoaderViewModel extends ViewModel {

        /* renamed from: f  reason: collision with root package name */
        private static final ViewModelProvider.Factory f3792f = new ViewModelProvider.Factory() {
            public /* synthetic */ ViewModel a(Class cls, CreationExtras creationExtras) {
                return e.b(this, cls, creationExtras);
            }

            public <T extends ViewModel> T b(Class<T> cls) {
                return new LoaderViewModel();
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private SparseArrayCompat<LoaderInfo> f3793d = new SparseArrayCompat<>();

        /* renamed from: e  reason: collision with root package name */
        private boolean f3794e = false;

        LoaderViewModel() {
        }

        static LoaderViewModel h(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, f3792f).a(LoaderViewModel.class);
        }

        /* access modifiers changed from: protected */
        public void d() {
            super.d();
            int k2 = this.f3793d.k();
            for (int i2 = 0; i2 < k2; i2++) {
                this.f3793d.l(i2).o(true);
            }
            this.f3793d.b();
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3793d.k() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f3793d.k(); i2++) {
                    LoaderInfo l2 = this.f3793d.l(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f3793d.h(i2));
                    printWriter.print(": ");
                    printWriter.println(l2.toString());
                    l2.p(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            this.f3794e = false;
        }

        /* access modifiers changed from: package-private */
        public <D> LoaderInfo<D> i(int i2) {
            return this.f3793d.e(i2);
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return this.f3794e;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            int k2 = this.f3793d.k();
            for (int i2 = 0; i2 < k2; i2++) {
                this.f3793d.l(i2).r();
            }
        }

        /* access modifiers changed from: package-private */
        public void l(int i2, LoaderInfo loaderInfo) {
            this.f3793d.i(i2, loaderInfo);
        }

        /* access modifiers changed from: package-private */
        public void m(int i2) {
            this.f3793d.j(i2);
        }

        /* access modifiers changed from: package-private */
        public void n() {
            this.f3794e = true;
        }
    }

    LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.f3781a = lifecycleOwner;
        this.f3782b = LoaderViewModel.h(viewModelStore);
    }

    /* JADX INFO: finally extract failed */
    private <D> Loader<D> g(int i2, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks, Loader<D> loader) {
        try {
            this.f3782b.n();
            Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(i2, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                    }
                }
                LoaderInfo loaderInfo = new LoaderInfo(i2, bundle, onCreateLoader, loader);
                if (f3780c) {
                    Log.v("LoaderManager", "  Created new loader " + loaderInfo);
                }
                this.f3782b.l(i2, loaderInfo);
                this.f3782b.g();
                return loaderInfo.s(this.f3781a, loaderCallbacks);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f3782b.g();
            throw th;
        }
    }

    public void a(int i2) {
        if (this.f3782b.j()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f3780c) {
                Log.v("LoaderManager", "destroyLoader in " + this + " of " + i2);
            }
            LoaderInfo i3 = this.f3782b.i(i2);
            if (i3 != null) {
                i3.o(true);
                this.f3782b.m(i2);
            }
        } else {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
    }

    @Deprecated
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3782b.f(str, fileDescriptor, printWriter, strArr);
    }

    public <D> Loader<D> d(int i2, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f3782b.j()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            LoaderInfo i3 = this.f3782b.i(i2);
            if (f3780c) {
                Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
            }
            if (i3 == null) {
                return g(i2, bundle, loaderCallbacks, (Loader) null);
            }
            if (f3780c) {
                Log.v("LoaderManager", "  Re-using existing loader " + i3);
            }
            return i3.s(this.f3781a, loaderCallbacks);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    public void e() {
        this.f3782b.k();
    }

    public <D> Loader<D> f(int i2, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        Loader loader;
        if (this.f3782b.j()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f3780c) {
                Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
            }
            LoaderInfo i3 = this.f3782b.i(i2);
            if (i3 != null) {
                loader = i3.o(false);
            } else {
                loader = null;
            }
            return g(i2, bundle, loaderCallbacks, loader);
        } else {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.a(this.f3781a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
