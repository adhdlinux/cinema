package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;

public final class JsonPath {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f41217a = new Object[8];

    /* renamed from: b  reason: collision with root package name */
    private int[] f41218b;

    /* renamed from: c  reason: collision with root package name */
    private int f41219c;

    private static final class Tombstone {

        /* renamed from: a  reason: collision with root package name */
        public static final Tombstone f41220a = new Tombstone();

        private Tombstone() {
        }
    }

    public JsonPath() {
        int[] iArr = new int[8];
        for (int i2 = 0; i2 < 8; i2++) {
            iArr[i2] = -1;
        }
        this.f41218b = iArr;
        this.f41219c = -1;
    }

    private final void e() {
        int i2 = this.f41219c * 2;
        Object[] copyOf = Arrays.copyOf(this.f41217a, i2);
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        this.f41217a = copyOf;
        int[] copyOf2 = Arrays.copyOf(this.f41218b, i2);
        Intrinsics.e(copyOf2, "copyOf(this, newSize)");
        this.f41218b = copyOf2;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        int i2 = this.f41219c + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = this.f41217a[i3];
            if (obj instanceof SerialDescriptor) {
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                if (!Intrinsics.a(serialDescriptor.d(), StructureKind.LIST.f40940a)) {
                    int i4 = this.f41218b[i3];
                    if (i4 >= 0) {
                        sb.append(".");
                        sb.append(serialDescriptor.f(i4));
                    }
                } else if (this.f41218b[i3] != -1) {
                    sb.append("[");
                    sb.append(this.f41218b[i3]);
                    sb.append("]");
                }
            } else if (obj != Tombstone.f41220a) {
                sb.append("[");
                sb.append("'");
                sb.append(obj);
                sb.append("'");
                sb.append("]");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final void b() {
        int i2 = this.f41219c;
        int[] iArr = this.f41218b;
        if (iArr[i2] == -2) {
            iArr[i2] = -1;
            this.f41219c = i2 - 1;
        }
        int i3 = this.f41219c;
        if (i3 != -1) {
            this.f41219c = i3 - 1;
        }
    }

    public final void c(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "sd");
        int i2 = this.f41219c + 1;
        this.f41219c = i2;
        if (i2 == this.f41217a.length) {
            e();
        }
        this.f41217a[i2] = serialDescriptor;
    }

    public final void d() {
        int[] iArr = this.f41218b;
        int i2 = this.f41219c;
        if (iArr[i2] == -2) {
            this.f41217a[i2] = Tombstone.f41220a;
        }
    }

    public final void f(Object obj) {
        int[] iArr = this.f41218b;
        int i2 = this.f41219c;
        if (iArr[i2] != -2) {
            int i3 = i2 + 1;
            this.f41219c = i3;
            if (i3 == this.f41217a.length) {
                e();
            }
        }
        Object[] objArr = this.f41217a;
        int i4 = this.f41219c;
        objArr[i4] = obj;
        this.f41218b[i4] = -2;
    }

    public final void g(int i2) {
        this.f41218b[this.f41219c] = i2;
    }

    public String toString() {
        return a();
    }
}
