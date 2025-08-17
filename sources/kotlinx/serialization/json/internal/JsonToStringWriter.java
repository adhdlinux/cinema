package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

public final class JsonToStringWriter implements JsonWriter {

    /* renamed from: a  reason: collision with root package name */
    private char[] f41223a = CharArrayPool.f41199a.b();

    /* renamed from: b  reason: collision with root package name */
    private int f41224b;

    private final void d(int i2, int i3, String str) {
        int i4;
        int length = str.length();
        while (i2 < length) {
            int f2 = f(i3, 2);
            char charAt = str.charAt(i2);
            if (charAt < StringOpsKt.a().length) {
                byte b2 = StringOpsKt.a()[charAt];
                if (b2 == 0) {
                    i4 = f2 + 1;
                    this.f41223a[f2] = (char) charAt;
                } else {
                    if (b2 == 1) {
                        String str2 = StringOpsKt.b()[charAt];
                        Intrinsics.c(str2);
                        int f3 = f(f2, str2.length());
                        str2.getChars(0, str2.length(), this.f41223a, f3);
                        i3 = f3 + str2.length();
                        this.f41224b = i3;
                    } else {
                        char[] cArr = this.f41223a;
                        cArr[f2] = '\\';
                        cArr[f2 + 1] = (char) b2;
                        i3 = f2 + 2;
                        this.f41224b = i3;
                    }
                    i2++;
                }
            } else {
                i4 = f2 + 1;
                this.f41223a[f2] = (char) charAt;
            }
            i3 = i4;
            i2++;
        }
        int f4 = f(i3, 1);
        this.f41223a[f4] = '\"';
        this.f41224b = f4 + 1;
    }

    private final void e(int i2) {
        f(this.f41224b, i2);
    }

    private final int f(int i2, int i3) {
        int i4 = i3 + i2;
        char[] cArr = this.f41223a;
        if (cArr.length <= i4) {
            char[] copyOf = Arrays.copyOf(cArr, RangesKt___RangesKt.b(i4, i2 * 2));
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f41223a = copyOf;
        }
        return i2;
    }

    public void a(char c2) {
        e(1);
        char[] cArr = this.f41223a;
        int i2 = this.f41224b;
        this.f41224b = i2 + 1;
        cArr[i2] = c2;
    }

    public void b(String str) {
        Intrinsics.f(str, "text");
        e(str.length() + 2);
        char[] cArr = this.f41223a;
        int i2 = this.f41224b;
        int i3 = i2 + 1;
        cArr[i2] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i3);
        int i4 = length + i3;
        int i5 = i3;
        while (i5 < i4) {
            char c2 = cArr[i5];
            if (c2 >= StringOpsKt.a().length || StringOpsKt.a()[c2] == 0) {
                i5++;
            } else {
                d(i5 - i3, i5, str);
                return;
            }
        }
        cArr[i4] = '\"';
        this.f41224b = i4 + 1;
    }

    public void c(String str) {
        Intrinsics.f(str, "text");
        int length = str.length();
        if (length != 0) {
            e(length);
            str.getChars(0, str.length(), this.f41223a, this.f41224b);
            this.f41224b += length;
        }
    }

    public void g() {
        CharArrayPool.f41199a.a(this.f41223a);
    }

    public String toString() {
        return new String(this.f41223a, 0, this.f41224b);
    }

    public void writeLong(long j2) {
        c(String.valueOf(j2));
    }
}
