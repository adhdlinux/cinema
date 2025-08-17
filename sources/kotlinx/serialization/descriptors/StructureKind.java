package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class StructureKind extends SerialKind {

    public static final class CLASS extends StructureKind {

        /* renamed from: a  reason: collision with root package name */
        public static final CLASS f40939a = new CLASS();

        private CLASS() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class LIST extends StructureKind {

        /* renamed from: a  reason: collision with root package name */
        public static final LIST f40940a = new LIST();

        private LIST() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class MAP extends StructureKind {

        /* renamed from: a  reason: collision with root package name */
        public static final MAP f40941a = new MAP();

        private MAP() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class OBJECT extends StructureKind {

        /* renamed from: a  reason: collision with root package name */
        public static final OBJECT f40942a = new OBJECT();

        private OBJECT() {
            super((DefaultConstructorMarker) null);
        }
    }

    private StructureKind() {
        super((DefaultConstructorMarker) null);
    }

    public /* synthetic */ StructureKind(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
