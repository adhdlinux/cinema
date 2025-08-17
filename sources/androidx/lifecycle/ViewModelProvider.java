package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public class ViewModelProvider {

    /* renamed from: a  reason: collision with root package name */
    private final ViewModelStore f3758a;

    /* renamed from: b  reason: collision with root package name */
    private final Factory f3759b;

    /* renamed from: c  reason: collision with root package name */
    private final CreationExtras f3760c;

    public interface Factory {
        <T extends ViewModel> T a(Class<T> cls, CreationExtras creationExtras);

        <T extends ViewModel> T b(Class<T> cls);
    }

    public static class NewInstanceFactory implements Factory {

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f3766a = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static NewInstanceFactory f3767b;

        /* renamed from: c  reason: collision with root package name */
        public static final CreationExtras.Key<String> f3768c = Companion.ViewModelKeyImpl.f3769a;

        public static final class Companion {

            private static final class ViewModelKeyImpl implements CreationExtras.Key<String> {

                /* renamed from: a  reason: collision with root package name */
                public static final ViewModelKeyImpl f3769a = new ViewModelKeyImpl();

                private ViewModelKeyImpl() {
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final NewInstanceFactory a() {
                if (NewInstanceFactory.f3767b == null) {
                    NewInstanceFactory.f3767b = new NewInstanceFactory();
                }
                NewInstanceFactory c2 = NewInstanceFactory.f3767b;
                Intrinsics.c(c2);
                return c2;
            }
        }

        public /* synthetic */ ViewModel a(Class cls, CreationExtras creationExtras) {
            return e.b(this, cls, creationExtras);
        }

        public <T extends ViewModel> T b(Class<T> cls) {
            Intrinsics.f(cls, "modelClass");
            try {
                T newInstance = cls.newInstance();
                Intrinsics.e(newInstance, "{\n                modelC…wInstance()\n            }");
                return (ViewModel) newInstance;
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    public static class OnRequeryFactory {
        public void c(ViewModel viewModel) {
            Intrinsics.f(viewModel, "viewModel");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        this(viewModelStore, factory, (CreationExtras) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.f(viewModelStore, "store");
        Intrinsics.f(factory, "factory");
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras) {
        Intrinsics.f(viewModelStore, "store");
        Intrinsics.f(factory, "factory");
        Intrinsics.f(creationExtras, "defaultCreationExtras");
        this.f3758a = viewModelStore;
        this.f3759b = factory;
        this.f3760c = creationExtras;
    }

    public <T extends ViewModel> T a(Class<T> cls) {
        Intrinsics.f(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends ViewModel> T b(String str, Class<T> cls) {
        T t2;
        OnRequeryFactory onRequeryFactory;
        Intrinsics.f(str, "key");
        Intrinsics.f(cls, "modelClass");
        T b2 = this.f3758a.b(str);
        if (cls.isInstance(b2)) {
            Factory factory = this.f3759b;
            if (factory instanceof OnRequeryFactory) {
                onRequeryFactory = (OnRequeryFactory) factory;
            } else {
                onRequeryFactory = null;
            }
            if (onRequeryFactory != null) {
                Intrinsics.e(b2, "viewModel");
                onRequeryFactory.c(b2);
            }
            if (b2 != null) {
                return b2;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.f3760c);
        mutableCreationExtras.c(NewInstanceFactory.f3768c, str);
        try {
            t2 = this.f3759b.a(cls, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            t2 = this.f3759b.b(cls);
        }
        this.f3758a.d(str, t2);
        return t2;
    }

    public static class AndroidViewModelFactory extends NewInstanceFactory {

        /* renamed from: e  reason: collision with root package name */
        public static final Companion f3761e = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static AndroidViewModelFactory f3762f;

        /* renamed from: g  reason: collision with root package name */
        public static final CreationExtras.Key<Application> f3763g = Companion.ApplicationKeyImpl.f3765a;

        /* renamed from: d  reason: collision with root package name */
        private final Application f3764d;

        public static final class Companion {

            private static final class ApplicationKeyImpl implements CreationExtras.Key<Application> {

                /* renamed from: a  reason: collision with root package name */
                public static final ApplicationKeyImpl f3765a = new ApplicationKeyImpl();

                private ApplicationKeyImpl() {
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final AndroidViewModelFactory a(Application application) {
                Intrinsics.f(application, "application");
                if (AndroidViewModelFactory.f3762f == null) {
                    AndroidViewModelFactory.f3762f = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory e2 = AndroidViewModelFactory.f3762f;
                Intrinsics.c(e2);
                return e2;
            }
        }

        private AndroidViewModelFactory(Application application, int i2) {
            this.f3764d = application;
        }

        private final <T extends ViewModel> T g(Class<T> cls, Application application) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.b(cls);
            }
            try {
                T t2 = (ViewModel) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{application});
                Intrinsics.e(t2, "{\n                try {\n…          }\n            }");
                return t2;
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            }
        }

        public <T extends ViewModel> T a(Class<T> cls, CreationExtras creationExtras) {
            Intrinsics.f(cls, "modelClass");
            Intrinsics.f(creationExtras, "extras");
            if (this.f3764d != null) {
                return b(cls);
            }
            Application application = (Application) creationExtras.a(f3763g);
            if (application != null) {
                return g(cls, application);
            }
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.b(cls);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        public <T extends ViewModel> T b(Class<T> cls) {
            Intrinsics.f(cls, "modelClass");
            Application application = this.f3764d;
            if (application != null) {
                return g(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        public AndroidViewModelFactory() {
            this((Application) null, 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(Application application) {
            this(application, 0);
            Intrinsics.f(application, "application");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewModelStore, factory, (i2 & 4) != 0 ? CreationExtras.Empty.f3774b : creationExtras);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ViewModelProvider(androidx.lifecycle.ViewModelStoreOwner r3, androidx.lifecycle.ViewModelProvider.Factory r4) {
        /*
            r2 = this;
            java.lang.String r0 = "owner"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            androidx.lifecycle.ViewModelStore r0 = r3.getViewModelStore()
            java.lang.String r1 = "owner.viewModelStore"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            androidx.lifecycle.viewmodel.CreationExtras r3 = androidx.lifecycle.ViewModelProviderGetKt.a(r3)
            r2.<init>(r0, r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelProvider.<init>(androidx.lifecycle.ViewModelStoreOwner, androidx.lifecycle.ViewModelProvider$Factory):void");
    }
}
