package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

public abstract class SerialKind {

    public static final class CONTEXTUAL extends SerialKind {

        /* renamed from: a  reason: collision with root package name */
        public static final CONTEXTUAL f40937a = new CONTEXTUAL();

        private CONTEXTUAL() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class ENUM extends SerialKind {

        /* renamed from: a  reason: collision with root package name */
        public static final ENUM f40938a = new ENUM();

        private ENUM() {
            super((DefaultConstructorMarker) null);
        }
    }

    private SerialKind() {
    }

    public /* synthetic */ SerialKind(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String e2 = Reflection.b(getClass()).e();
        Intrinsics.c(e2);
        return e2;
    }
}
