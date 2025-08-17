package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;

public abstract class PropertyReference0 extends PropertyReference implements KProperty0 {
    public PropertyReference0() {
    }

    public KProperty0.Getter c() {
        ((KProperty0) getReflected()).c();
        return null;
    }

    /* access modifiers changed from: protected */
    public KCallable computeReflected() {
        return Reflection.e(this);
    }

    public Object invoke() {
        return get();
    }

    public PropertyReference0(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
