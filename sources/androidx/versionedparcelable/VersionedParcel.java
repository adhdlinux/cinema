package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class VersionedParcel {

    /* renamed from: a  reason: collision with root package name */
    protected final ArrayMap<String, Method> f11927a;

    /* renamed from: b  reason: collision with root package name */
    protected final ArrayMap<String, Method> f11928b;

    /* renamed from: c  reason: collision with root package name */
    protected final ArrayMap<String, Class> f11929c;

    public static class ParcelException extends RuntimeException {
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.f11927a = arrayMap;
        this.f11928b = arrayMap2;
        this.f11929c = arrayMap3;
    }

    private void N(VersionedParcelable versionedParcelable) {
        try {
            I(c(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    private Class c(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.f11929c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f11929c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f11927a.get(str);
        if (method != null) {
            return method;
        }
        Class<VersionedParcel> cls = VersionedParcel.class;
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        this.f11927a.put(str, declaredMethod);
        return declaredMethod;
    }

    private Method e(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f11928b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Method declaredMethod = c(cls).getDeclaredMethod("write", new Class[]{cls, VersionedParcel.class});
        this.f11928b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* access modifiers changed from: protected */
    public abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i2) {
        w(i2);
        A(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i2) {
        w(i2);
        C(charSequence);
    }

    /* access modifiers changed from: protected */
    public abstract void E(int i2);

    public void F(int i2, int i3) {
        w(i3);
        E(i2);
    }

    /* access modifiers changed from: protected */
    public abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i2) {
        w(i2);
        G(parcelable);
    }

    /* access modifiers changed from: protected */
    public abstract void I(String str);

    public void J(String str, int i2) {
        w(i2);
        I(str);
    }

    /* access modifiers changed from: protected */
    public <T extends VersionedParcelable> void K(T t2, VersionedParcel versionedParcel) {
        try {
            e(t2.getClass()).invoke((Object) null, new Object[]{t2, versionedParcel});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    /* access modifiers changed from: protected */
    public void L(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            I((String) null);
            return;
        }
        N(versionedParcelable);
        VersionedParcel b2 = b();
        K(versionedParcelable, b2);
        b2.a();
    }

    public void M(VersionedParcelable versionedParcelable, int i2) {
        w(i2);
        L(versionedParcelable);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract VersionedParcel b();

    public boolean f() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean g();

    public boolean h(boolean z2, int i2) {
        if (!m(i2)) {
            return z2;
        }
        return g();
    }

    /* access modifiers changed from: protected */
    public abstract byte[] i();

    public byte[] j(byte[] bArr, int i2) {
        if (!m(i2)) {
            return bArr;
        }
        return i();
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i2) {
        if (!m(i2)) {
            return charSequence;
        }
        return k();
    }

    /* access modifiers changed from: protected */
    public abstract boolean m(int i2);

    /* access modifiers changed from: protected */
    public <T extends VersionedParcelable> T n(String str, VersionedParcel versionedParcel) {
        try {
            return (VersionedParcelable) d(str).invoke((Object) null, new Object[]{versionedParcel});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    /* access modifiers changed from: protected */
    public abstract int o();

    public int p(int i2, int i3) {
        if (!m(i3)) {
            return i2;
        }
        return o();
    }

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t2, int i2) {
        if (!m(i2)) {
            return t2;
        }
        return q();
    }

    /* access modifiers changed from: protected */
    public abstract String s();

    public String t(String str, int i2) {
        if (!m(i2)) {
            return str;
        }
        return s();
    }

    /* access modifiers changed from: protected */
    public <T extends VersionedParcelable> T u() {
        String s2 = s();
        if (s2 == null) {
            return null;
        }
        return n(s2, b());
    }

    public <T extends VersionedParcelable> T v(T t2, int i2) {
        if (!m(i2)) {
            return t2;
        }
        return u();
    }

    /* access modifiers changed from: protected */
    public abstract void w(int i2);

    public void x(boolean z2, boolean z3) {
    }

    /* access modifiers changed from: protected */
    public abstract void y(boolean z2);

    public void z(boolean z2, int i2) {
        w(i2);
        y(z2);
    }
}
