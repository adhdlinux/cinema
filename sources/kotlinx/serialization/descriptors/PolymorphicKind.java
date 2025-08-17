package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class PolymorphicKind extends SerialKind {

    public static final class OPEN extends PolymorphicKind {

        /* renamed from: a  reason: collision with root package name */
        public static final OPEN f40905a = new OPEN();

        private OPEN() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class SEALED extends PolymorphicKind {

        /* renamed from: a  reason: collision with root package name */
        public static final SEALED f40906a = new SEALED();

        private SEALED() {
            super((DefaultConstructorMarker) null);
        }
    }

    private PolymorphicKind() {
        super((DefaultConstructorMarker) null);
    }

    public /* synthetic */ PolymorphicKind(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
