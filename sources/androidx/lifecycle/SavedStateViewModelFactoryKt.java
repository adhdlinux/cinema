package androidx.lifecycle;

import android.app.Application;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class SavedStateViewModelFactoryKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final List<Class<?>> f3746a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final List<Class<?>> f3747b;

    static {
        Class<SavedStateHandle> cls = SavedStateHandle.class;
        f3746a = CollectionsKt__CollectionsKt.i(Application.class, cls);
        f3747b = CollectionsKt__CollectionsJVMKt.b(cls);
    }

    public static final <T> Constructor<T> c(Class<T> cls, List<? extends Class<?>> list) {
        Intrinsics.f(cls, "modelClass");
        Intrinsics.f(list, InAppPurchaseMetaData.KEY_SIGNATURE);
        Constructor<T>[] constructors = cls.getConstructors();
        Intrinsics.e(constructors, "modelClass.constructors");
        int length = constructors.length;
        int i2 = 0;
        while (i2 < length) {
            Constructor<T> constructor = constructors[i2];
            Class[] parameterTypes = constructor.getParameterTypes();
            Intrinsics.e(parameterTypes, "constructor.parameterTypes");
            List Q = ArraysKt___ArraysKt.Q(parameterTypes);
            if (Intrinsics.a(list, Q)) {
                return constructor;
            }
            if (list.size() != Q.size() || !Q.containsAll(list)) {
                i2++;
            } else {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T d(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        Intrinsics.f(cls, "modelClass");
        Intrinsics.f(constructor, "constructor");
        Intrinsics.f(objArr, "params");
        try {
            return (ViewModel) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Failed to access " + cls, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
        }
    }
}
