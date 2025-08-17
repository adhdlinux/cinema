package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.reflect.KDeclarationContainer;

public class AdaptedFunctionReference implements FunctionBase, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int i2, Class cls, String str, String str2, int i3) {
        this(i2, CallableReference.NO_RECEIVER, cls, str, str2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        if (this.isTopLevel != adaptedFunctionReference.isTopLevel || this.arity != adaptedFunctionReference.arity || this.flags != adaptedFunctionReference.flags || !Intrinsics.a(this.receiver, adaptedFunctionReference.receiver) || !Intrinsics.a(this.owner, adaptedFunctionReference.owner) || !this.name.equals(adaptedFunctionReference.name) || !this.signature.equals(adaptedFunctionReference.signature)) {
            return false;
        }
        return true;
    }

    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            return Reflection.c(cls);
        }
        return Reflection.b(cls);
    }

    public int hashCode() {
        int i2;
        int i3;
        Object obj = this.receiver;
        int i4 = 0;
        if (obj != null) {
            i2 = obj.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = i2 * 31;
        Class cls = this.owner;
        if (cls != null) {
            i4 = cls.hashCode();
        }
        int hashCode = (((((i5 + i4) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31;
        if (this.isTopLevel) {
            i3 = 1231;
        } else {
            i3 = 1237;
        }
        return ((((hashCode + i3) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        return Reflection.f(this);
    }

    public AdaptedFunctionReference(int i2, Object obj, Class cls, String str, String str2, int i3) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = (i3 & 1) == 1;
        this.arity = i2;
        this.flags = i3 >> 1;
    }
}
