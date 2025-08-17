package androidx.constraintlayout.solver;

import java.util.Arrays;

public class SolverVariable {

    /* renamed from: k  reason: collision with root package name */
    private static int f1817k = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f1818a;

    /* renamed from: b  reason: collision with root package name */
    public int f1819b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f1820c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f1821d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f1822e;

    /* renamed from: f  reason: collision with root package name */
    float[] f1823f = new float[7];

    /* renamed from: g  reason: collision with root package name */
    Type f1824g;

    /* renamed from: h  reason: collision with root package name */
    ArrayRow[] f1825h = new ArrayRow[8];

    /* renamed from: i  reason: collision with root package name */
    int f1826i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f1827j = 0;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f1824g = type;
    }

    static void b() {
        f1817k++;
    }

    public final void a(ArrayRow arrayRow) {
        int i2 = 0;
        while (true) {
            int i3 = this.f1826i;
            if (i2 >= i3) {
                ArrayRow[] arrayRowArr = this.f1825h;
                if (i3 >= arrayRowArr.length) {
                    this.f1825h = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.f1825h;
                int i4 = this.f1826i;
                arrayRowArr2[i4] = arrayRow;
                this.f1826i = i4 + 1;
                return;
            } else if (this.f1825h[i2] != arrayRow) {
                i2++;
            } else {
                return;
            }
        }
    }

    public final void c(ArrayRow arrayRow) {
        int i2 = this.f1826i;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f1825h[i3] == arrayRow) {
                for (int i4 = 0; i4 < (i2 - i3) - 1; i4++) {
                    ArrayRow[] arrayRowArr = this.f1825h;
                    int i5 = i3 + i4;
                    arrayRowArr[i5] = arrayRowArr[i5 + 1];
                }
                this.f1826i--;
                return;
            }
        }
    }

    public void d() {
        this.f1818a = null;
        this.f1824g = Type.UNKNOWN;
        this.f1821d = 0;
        this.f1819b = -1;
        this.f1820c = -1;
        this.f1822e = 0.0f;
        this.f1826i = 0;
        this.f1827j = 0;
    }

    public void e(Type type, String str) {
        this.f1824g = type;
    }

    public final void f(ArrayRow arrayRow) {
        int i2 = this.f1826i;
        for (int i3 = 0; i3 < i2; i3++) {
            ArrayRow arrayRow2 = this.f1825h[i3];
            arrayRow2.f1766d.n(arrayRow2, arrayRow, false);
        }
        this.f1826i = 0;
    }

    public String toString() {
        return "" + this.f1818a;
    }
}
