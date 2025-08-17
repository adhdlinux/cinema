package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f2056b = {0, 4, 8};

    /* renamed from: c  reason: collision with root package name */
    private static SparseIntArray f2057c;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Integer, Constraint> f2058a = new HashMap<>();

    private static class Constraint {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public float Q;
        public float R;
        public int S;
        public int T;
        public float U;
        public boolean V;
        public float W;
        public float X;
        public float Y;
        public float Z;

        /* renamed from: a  reason: collision with root package name */
        boolean f2059a;

        /* renamed from: a0  reason: collision with root package name */
        public float f2060a0;

        /* renamed from: b  reason: collision with root package name */
        public int f2061b;

        /* renamed from: b0  reason: collision with root package name */
        public float f2062b0;

        /* renamed from: c  reason: collision with root package name */
        public int f2063c;

        /* renamed from: c0  reason: collision with root package name */
        public float f2064c0;

        /* renamed from: d  reason: collision with root package name */
        int f2065d;

        /* renamed from: d0  reason: collision with root package name */
        public float f2066d0;

        /* renamed from: e  reason: collision with root package name */
        public int f2067e;

        /* renamed from: e0  reason: collision with root package name */
        public float f2068e0;

        /* renamed from: f  reason: collision with root package name */
        public int f2069f;

        /* renamed from: f0  reason: collision with root package name */
        public float f2070f0;

        /* renamed from: g  reason: collision with root package name */
        public float f2071g;

        /* renamed from: g0  reason: collision with root package name */
        public float f2072g0;

        /* renamed from: h  reason: collision with root package name */
        public int f2073h;

        /* renamed from: h0  reason: collision with root package name */
        public boolean f2074h0;

        /* renamed from: i  reason: collision with root package name */
        public int f2075i;

        /* renamed from: i0  reason: collision with root package name */
        public boolean f2076i0;

        /* renamed from: j  reason: collision with root package name */
        public int f2077j;

        /* renamed from: j0  reason: collision with root package name */
        public int f2078j0;

        /* renamed from: k  reason: collision with root package name */
        public int f2079k;

        /* renamed from: k0  reason: collision with root package name */
        public int f2080k0;

        /* renamed from: l  reason: collision with root package name */
        public int f2081l;

        /* renamed from: l0  reason: collision with root package name */
        public int f2082l0;

        /* renamed from: m  reason: collision with root package name */
        public int f2083m;

        /* renamed from: m0  reason: collision with root package name */
        public int f2084m0;

        /* renamed from: n  reason: collision with root package name */
        public int f2085n;

        /* renamed from: n0  reason: collision with root package name */
        public int f2086n0;

        /* renamed from: o  reason: collision with root package name */
        public int f2087o;

        /* renamed from: o0  reason: collision with root package name */
        public int f2088o0;

        /* renamed from: p  reason: collision with root package name */
        public int f2089p;

        /* renamed from: p0  reason: collision with root package name */
        public float f2090p0;

        /* renamed from: q  reason: collision with root package name */
        public int f2091q;

        /* renamed from: q0  reason: collision with root package name */
        public float f2092q0;

        /* renamed from: r  reason: collision with root package name */
        public int f2093r;

        /* renamed from: r0  reason: collision with root package name */
        public boolean f2094r0;

        /* renamed from: s  reason: collision with root package name */
        public int f2095s;

        /* renamed from: s0  reason: collision with root package name */
        public int f2096s0;

        /* renamed from: t  reason: collision with root package name */
        public int f2097t;

        /* renamed from: t0  reason: collision with root package name */
        public int f2098t0;

        /* renamed from: u  reason: collision with root package name */
        public float f2099u;

        /* renamed from: u0  reason: collision with root package name */
        public int[] f2100u0;

        /* renamed from: v  reason: collision with root package name */
        public float f2101v;

        /* renamed from: v0  reason: collision with root package name */
        public String f2102v0;

        /* renamed from: w  reason: collision with root package name */
        public String f2103w;

        /* renamed from: x  reason: collision with root package name */
        public int f2104x;

        /* renamed from: y  reason: collision with root package name */
        public int f2105y;

        /* renamed from: z  reason: collision with root package name */
        public float f2106z;

        private Constraint() {
            this.f2059a = false;
            this.f2067e = -1;
            this.f2069f = -1;
            this.f2071g = -1.0f;
            this.f2073h = -1;
            this.f2075i = -1;
            this.f2077j = -1;
            this.f2079k = -1;
            this.f2081l = -1;
            this.f2083m = -1;
            this.f2085n = -1;
            this.f2087o = -1;
            this.f2089p = -1;
            this.f2091q = -1;
            this.f2093r = -1;
            this.f2095s = -1;
            this.f2097t = -1;
            this.f2099u = 0.5f;
            this.f2101v = 0.5f;
            this.f2103w = null;
            this.f2104x = -1;
            this.f2105y = 0;
            this.f2106z = 0.0f;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = -1;
            this.I = -1;
            this.J = 0;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = -1;
            this.O = -1;
            this.P = -1;
            this.Q = 0.0f;
            this.R = 0.0f;
            this.S = 0;
            this.T = 0;
            this.U = 1.0f;
            this.V = false;
            this.W = 0.0f;
            this.X = 0.0f;
            this.Y = 0.0f;
            this.Z = 0.0f;
            this.f2060a0 = 1.0f;
            this.f2062b0 = 1.0f;
            this.f2064c0 = Float.NaN;
            this.f2066d0 = Float.NaN;
            this.f2068e0 = 0.0f;
            this.f2070f0 = 0.0f;
            this.f2072g0 = 0.0f;
            this.f2074h0 = false;
            this.f2076i0 = false;
            this.f2078j0 = 0;
            this.f2080k0 = 0;
            this.f2082l0 = -1;
            this.f2084m0 = -1;
            this.f2086n0 = -1;
            this.f2088o0 = -1;
            this.f2090p0 = 1.0f;
            this.f2092q0 = 1.0f;
            this.f2094r0 = false;
            this.f2096s0 = -1;
            this.f2098t0 = -1;
        }

        private void e(int i2, ConstraintLayout.LayoutParams layoutParams) {
            this.f2065d = i2;
            this.f2073h = layoutParams.f2022d;
            this.f2075i = layoutParams.f2024e;
            this.f2077j = layoutParams.f2026f;
            this.f2079k = layoutParams.f2028g;
            this.f2081l = layoutParams.f2030h;
            this.f2083m = layoutParams.f2032i;
            this.f2085n = layoutParams.f2034j;
            this.f2087o = layoutParams.f2036k;
            this.f2089p = layoutParams.f2038l;
            this.f2091q = layoutParams.f2044p;
            this.f2093r = layoutParams.f2045q;
            this.f2095s = layoutParams.f2046r;
            this.f2097t = layoutParams.f2047s;
            this.f2099u = layoutParams.f2054z;
            this.f2101v = layoutParams.A;
            this.f2103w = layoutParams.B;
            this.f2104x = layoutParams.f2040m;
            this.f2105y = layoutParams.f2042n;
            this.f2106z = layoutParams.f2043o;
            this.A = layoutParams.Q;
            this.B = layoutParams.R;
            this.C = layoutParams.S;
            this.f2071g = layoutParams.f2020c;
            this.f2067e = layoutParams.f2016a;
            this.f2069f = layoutParams.f2018b;
            this.f2061b = layoutParams.width;
            this.f2063c = layoutParams.height;
            this.D = layoutParams.leftMargin;
            this.E = layoutParams.rightMargin;
            this.F = layoutParams.topMargin;
            this.G = layoutParams.bottomMargin;
            this.Q = layoutParams.F;
            this.R = layoutParams.E;
            this.T = layoutParams.H;
            this.S = layoutParams.G;
            boolean z2 = layoutParams.T;
            this.f2076i0 = layoutParams.U;
            this.f2078j0 = layoutParams.I;
            this.f2080k0 = layoutParams.J;
            this.f2074h0 = z2;
            this.f2082l0 = layoutParams.M;
            this.f2084m0 = layoutParams.N;
            this.f2086n0 = layoutParams.K;
            this.f2088o0 = layoutParams.L;
            this.f2090p0 = layoutParams.O;
            this.f2092q0 = layoutParams.P;
            this.H = layoutParams.getMarginEnd();
            this.I = layoutParams.getMarginStart();
        }

        /* access modifiers changed from: private */
        public void f(int i2, Constraints.LayoutParams layoutParams) {
            e(i2, layoutParams);
            this.U = layoutParams.f2108n0;
            this.X = layoutParams.f2111q0;
            this.Y = layoutParams.f2112r0;
            this.Z = layoutParams.f2113s0;
            this.f2060a0 = layoutParams.f2114t0;
            this.f2062b0 = layoutParams.f2115u0;
            this.f2064c0 = layoutParams.f2116v0;
            this.f2066d0 = layoutParams.f2117w0;
            this.f2068e0 = layoutParams.f2118x0;
            this.f2070f0 = layoutParams.f2119y0;
            this.f2072g0 = layoutParams.f2120z0;
            this.W = layoutParams.f2110p0;
            this.V = layoutParams.f2109o0;
        }

        /* access modifiers changed from: private */
        public void g(ConstraintHelper constraintHelper, int i2, Constraints.LayoutParams layoutParams) {
            f(i2, layoutParams);
            if (constraintHelper instanceof Barrier) {
                this.f2098t0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                this.f2096s0 = barrier.getType();
                this.f2100u0 = barrier.getReferencedIds();
            }
        }

        public void c(ConstraintLayout.LayoutParams layoutParams) {
            layoutParams.f2022d = this.f2073h;
            layoutParams.f2024e = this.f2075i;
            layoutParams.f2026f = this.f2077j;
            layoutParams.f2028g = this.f2079k;
            layoutParams.f2030h = this.f2081l;
            layoutParams.f2032i = this.f2083m;
            layoutParams.f2034j = this.f2085n;
            layoutParams.f2036k = this.f2087o;
            layoutParams.f2038l = this.f2089p;
            layoutParams.f2044p = this.f2091q;
            layoutParams.f2045q = this.f2093r;
            layoutParams.f2046r = this.f2095s;
            layoutParams.f2047s = this.f2097t;
            layoutParams.leftMargin = this.D;
            layoutParams.rightMargin = this.E;
            layoutParams.topMargin = this.F;
            layoutParams.bottomMargin = this.G;
            layoutParams.f2052x = this.P;
            layoutParams.f2053y = this.O;
            layoutParams.f2054z = this.f2099u;
            layoutParams.A = this.f2101v;
            layoutParams.f2040m = this.f2104x;
            layoutParams.f2042n = this.f2105y;
            layoutParams.f2043o = this.f2106z;
            layoutParams.B = this.f2103w;
            layoutParams.Q = this.A;
            layoutParams.R = this.B;
            layoutParams.F = this.Q;
            layoutParams.E = this.R;
            layoutParams.H = this.T;
            layoutParams.G = this.S;
            layoutParams.T = this.f2074h0;
            layoutParams.U = this.f2076i0;
            layoutParams.I = this.f2078j0;
            layoutParams.J = this.f2080k0;
            layoutParams.M = this.f2082l0;
            layoutParams.N = this.f2084m0;
            layoutParams.K = this.f2086n0;
            layoutParams.L = this.f2088o0;
            layoutParams.O = this.f2090p0;
            layoutParams.P = this.f2092q0;
            layoutParams.S = this.C;
            layoutParams.f2020c = this.f2071g;
            layoutParams.f2016a = this.f2067e;
            layoutParams.f2018b = this.f2069f;
            layoutParams.width = this.f2061b;
            layoutParams.height = this.f2063c;
            layoutParams.setMarginStart(this.I);
            layoutParams.setMarginEnd(this.H);
            layoutParams.a();
        }

        /* renamed from: d */
        public Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.f2059a = this.f2059a;
            constraint.f2061b = this.f2061b;
            constraint.f2063c = this.f2063c;
            constraint.f2067e = this.f2067e;
            constraint.f2069f = this.f2069f;
            constraint.f2071g = this.f2071g;
            constraint.f2073h = this.f2073h;
            constraint.f2075i = this.f2075i;
            constraint.f2077j = this.f2077j;
            constraint.f2079k = this.f2079k;
            constraint.f2081l = this.f2081l;
            constraint.f2083m = this.f2083m;
            constraint.f2085n = this.f2085n;
            constraint.f2087o = this.f2087o;
            constraint.f2089p = this.f2089p;
            constraint.f2091q = this.f2091q;
            constraint.f2093r = this.f2093r;
            constraint.f2095s = this.f2095s;
            constraint.f2097t = this.f2097t;
            constraint.f2099u = this.f2099u;
            constraint.f2101v = this.f2101v;
            constraint.f2103w = this.f2103w;
            constraint.A = this.A;
            constraint.B = this.B;
            constraint.f2099u = this.f2099u;
            constraint.f2099u = this.f2099u;
            constraint.f2099u = this.f2099u;
            constraint.f2099u = this.f2099u;
            constraint.f2099u = this.f2099u;
            constraint.C = this.C;
            constraint.D = this.D;
            constraint.E = this.E;
            constraint.F = this.F;
            constraint.G = this.G;
            constraint.H = this.H;
            constraint.I = this.I;
            constraint.J = this.J;
            constraint.K = this.K;
            constraint.L = this.L;
            constraint.M = this.M;
            constraint.N = this.N;
            constraint.O = this.O;
            constraint.P = this.P;
            constraint.Q = this.Q;
            constraint.R = this.R;
            constraint.S = this.S;
            constraint.T = this.T;
            constraint.U = this.U;
            constraint.V = this.V;
            constraint.W = this.W;
            constraint.X = this.X;
            constraint.Y = this.Y;
            constraint.Z = this.Z;
            constraint.f2060a0 = this.f2060a0;
            constraint.f2062b0 = this.f2062b0;
            constraint.f2064c0 = this.f2064c0;
            constraint.f2066d0 = this.f2066d0;
            constraint.f2068e0 = this.f2068e0;
            constraint.f2070f0 = this.f2070f0;
            constraint.f2072g0 = this.f2072g0;
            constraint.f2074h0 = this.f2074h0;
            constraint.f2076i0 = this.f2076i0;
            constraint.f2078j0 = this.f2078j0;
            constraint.f2080k0 = this.f2080k0;
            constraint.f2082l0 = this.f2082l0;
            constraint.f2084m0 = this.f2084m0;
            constraint.f2086n0 = this.f2086n0;
            constraint.f2088o0 = this.f2088o0;
            constraint.f2090p0 = this.f2090p0;
            constraint.f2092q0 = this.f2092q0;
            constraint.f2096s0 = this.f2096s0;
            constraint.f2098t0 = this.f2098t0;
            int[] iArr = this.f2100u0;
            if (iArr != null) {
                constraint.f2100u0 = Arrays.copyOf(iArr, iArr.length);
            }
            constraint.f2104x = this.f2104x;
            constraint.f2105y = this.f2105y;
            constraint.f2106z = this.f2106z;
            constraint.f2094r0 = this.f2094r0;
            return constraint;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2057c = sparseIntArray;
        sparseIntArray.append(R$styleable.f2153j1, 25);
        f2057c.append(R$styleable.f2156k1, 26);
        f2057c.append(R$styleable.f2162m1, 29);
        f2057c.append(R$styleable.f2165n1, 30);
        f2057c.append(R$styleable.f2180s1, 36);
        f2057c.append(R$styleable.f2177r1, 35);
        f2057c.append(R$styleable.R0, 4);
        f2057c.append(R$styleable.Q0, 3);
        f2057c.append(R$styleable.O0, 1);
        f2057c.append(R$styleable.A1, 6);
        f2057c.append(R$styleable.B1, 7);
        f2057c.append(R$styleable.Y0, 17);
        f2057c.append(R$styleable.Z0, 18);
        f2057c.append(R$styleable.f2126a1, 19);
        f2057c.append(R$styleable.f2161m0, 27);
        f2057c.append(R$styleable.f2168o1, 32);
        f2057c.append(R$styleable.f2171p1, 33);
        f2057c.append(R$styleable.X0, 10);
        f2057c.append(R$styleable.W0, 9);
        f2057c.append(R$styleable.E1, 13);
        f2057c.append(R$styleable.H1, 16);
        f2057c.append(R$styleable.F1, 14);
        f2057c.append(R$styleable.C1, 11);
        f2057c.append(R$styleable.G1, 15);
        f2057c.append(R$styleable.D1, 12);
        f2057c.append(R$styleable.v1, 40);
        f2057c.append(R$styleable.f2147h1, 39);
        f2057c.append(R$styleable.f2144g1, 41);
        f2057c.append(R$styleable.u1, 42);
        f2057c.append(R$styleable.f2141f1, 20);
        f2057c.append(R$styleable.t1, 37);
        f2057c.append(R$styleable.V0, 5);
        f2057c.append(R$styleable.f2150i1, 75);
        f2057c.append(R$styleable.f2174q1, 75);
        f2057c.append(R$styleable.f2159l1, 75);
        f2057c.append(R$styleable.P0, 75);
        f2057c.append(R$styleable.N0, 75);
        f2057c.append(R$styleable.f2176r0, 24);
        f2057c.append(R$styleable.f2182t0, 28);
        f2057c.append(R$styleable.F0, 31);
        f2057c.append(R$styleable.G0, 8);
        f2057c.append(R$styleable.f2179s0, 34);
        f2057c.append(R$styleable.f2184u0, 2);
        f2057c.append(R$styleable.f2170p0, 23);
        f2057c.append(R$styleable.f2173q0, 21);
        f2057c.append(R$styleable.f2167o0, 22);
        f2057c.append(R$styleable.f2186v0, 43);
        f2057c.append(R$styleable.I0, 44);
        f2057c.append(R$styleable.D0, 45);
        f2057c.append(R$styleable.E0, 46);
        f2057c.append(R$styleable.C0, 60);
        f2057c.append(R$styleable.A0, 47);
        f2057c.append(R$styleable.B0, 48);
        f2057c.append(R$styleable.f2188w0, 49);
        f2057c.append(R$styleable.f2190x0, 50);
        f2057c.append(R$styleable.f2192y0, 51);
        f2057c.append(R$styleable.f2194z0, 52);
        f2057c.append(R$styleable.H0, 53);
        f2057c.append(R$styleable.w1, 54);
        f2057c.append(R$styleable.f2129b1, 55);
        f2057c.append(R$styleable.x1, 56);
        f2057c.append(R$styleable.f2132c1, 57);
        f2057c.append(R$styleable.y1, 58);
        f2057c.append(R$styleable.f2135d1, 59);
        f2057c.append(R$styleable.S0, 61);
        f2057c.append(R$styleable.U0, 62);
        f2057c.append(R$styleable.T0, 63);
        f2057c.append(R$styleable.f2164n0, 38);
        f2057c.append(R$styleable.z1, 69);
        f2057c.append(R$styleable.f2138e1, 70);
        f2057c.append(R$styleable.L0, 71);
        f2057c.append(R$styleable.K0, 72);
        f2057c.append(R$styleable.M0, 73);
        f2057c.append(R$styleable.J0, 74);
    }

    private int[] c(View view, String str) {
        int i2;
        Object c2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < split.length) {
            String trim = split[i3].trim();
            try {
                i2 = R$id.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i2 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (c2 = ((ConstraintLayout) view.getParent()).c(0, trim)) != null && (c2 instanceof Integer)) {
                i2 = ((Integer) c2).intValue();
            }
            iArr[i4] = i2;
            i3++;
            i4++;
        }
        if (i4 != split.length) {
            return Arrays.copyOf(iArr, i4);
        }
        return iArr;
    }

    private Constraint d(Context context, AttributeSet attributeSet) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f2158l0);
        g(constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private static int f(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        if (resourceId == -1) {
            return typedArray.getInt(i2, -1);
        }
        return resourceId;
    }

    private void g(Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            int i3 = f2057c.get(index);
            switch (i3) {
                case 1:
                    constraint.f2089p = f(typedArray, index, constraint.f2089p);
                    break;
                case 2:
                    constraint.G = typedArray.getDimensionPixelSize(index, constraint.G);
                    break;
                case 3:
                    constraint.f2087o = f(typedArray, index, constraint.f2087o);
                    break;
                case 4:
                    constraint.f2085n = f(typedArray, index, constraint.f2085n);
                    break;
                case 5:
                    constraint.f2103w = typedArray.getString(index);
                    break;
                case 6:
                    constraint.A = typedArray.getDimensionPixelOffset(index, constraint.A);
                    break;
                case 7:
                    constraint.B = typedArray.getDimensionPixelOffset(index, constraint.B);
                    break;
                case 8:
                    constraint.H = typedArray.getDimensionPixelSize(index, constraint.H);
                    break;
                case 9:
                    constraint.f2097t = f(typedArray, index, constraint.f2097t);
                    break;
                case 10:
                    constraint.f2095s = f(typedArray, index, constraint.f2095s);
                    break;
                case 11:
                    constraint.N = typedArray.getDimensionPixelSize(index, constraint.N);
                    break;
                case 12:
                    constraint.O = typedArray.getDimensionPixelSize(index, constraint.O);
                    break;
                case 13:
                    constraint.K = typedArray.getDimensionPixelSize(index, constraint.K);
                    break;
                case 14:
                    constraint.M = typedArray.getDimensionPixelSize(index, constraint.M);
                    break;
                case 15:
                    constraint.P = typedArray.getDimensionPixelSize(index, constraint.P);
                    break;
                case 16:
                    constraint.L = typedArray.getDimensionPixelSize(index, constraint.L);
                    break;
                case 17:
                    constraint.f2067e = typedArray.getDimensionPixelOffset(index, constraint.f2067e);
                    break;
                case 18:
                    constraint.f2069f = typedArray.getDimensionPixelOffset(index, constraint.f2069f);
                    break;
                case 19:
                    constraint.f2071g = typedArray.getFloat(index, constraint.f2071g);
                    break;
                case 20:
                    constraint.f2099u = typedArray.getFloat(index, constraint.f2099u);
                    break;
                case 21:
                    constraint.f2063c = typedArray.getLayoutDimension(index, constraint.f2063c);
                    break;
                case 22:
                    constraint.J = f2056b[typedArray.getInt(index, constraint.J)];
                    break;
                case 23:
                    constraint.f2061b = typedArray.getLayoutDimension(index, constraint.f2061b);
                    break;
                case 24:
                    constraint.D = typedArray.getDimensionPixelSize(index, constraint.D);
                    break;
                case 25:
                    constraint.f2073h = f(typedArray, index, constraint.f2073h);
                    break;
                case 26:
                    constraint.f2075i = f(typedArray, index, constraint.f2075i);
                    break;
                case 27:
                    constraint.C = typedArray.getInt(index, constraint.C);
                    break;
                case 28:
                    constraint.E = typedArray.getDimensionPixelSize(index, constraint.E);
                    break;
                case 29:
                    constraint.f2077j = f(typedArray, index, constraint.f2077j);
                    break;
                case 30:
                    constraint.f2079k = f(typedArray, index, constraint.f2079k);
                    break;
                case 31:
                    constraint.I = typedArray.getDimensionPixelSize(index, constraint.I);
                    break;
                case 32:
                    constraint.f2091q = f(typedArray, index, constraint.f2091q);
                    break;
                case 33:
                    constraint.f2093r = f(typedArray, index, constraint.f2093r);
                    break;
                case 34:
                    constraint.F = typedArray.getDimensionPixelSize(index, constraint.F);
                    break;
                case 35:
                    constraint.f2083m = f(typedArray, index, constraint.f2083m);
                    break;
                case 36:
                    constraint.f2081l = f(typedArray, index, constraint.f2081l);
                    break;
                case 37:
                    constraint.f2101v = typedArray.getFloat(index, constraint.f2101v);
                    break;
                case 38:
                    constraint.f2065d = typedArray.getResourceId(index, constraint.f2065d);
                    break;
                case 39:
                    constraint.R = typedArray.getFloat(index, constraint.R);
                    break;
                case 40:
                    constraint.Q = typedArray.getFloat(index, constraint.Q);
                    break;
                case 41:
                    constraint.S = typedArray.getInt(index, constraint.S);
                    break;
                case 42:
                    constraint.T = typedArray.getInt(index, constraint.T);
                    break;
                case 43:
                    constraint.U = typedArray.getFloat(index, constraint.U);
                    break;
                case 44:
                    constraint.V = true;
                    constraint.W = typedArray.getDimension(index, constraint.W);
                    break;
                case 45:
                    constraint.Y = typedArray.getFloat(index, constraint.Y);
                    break;
                case 46:
                    constraint.Z = typedArray.getFloat(index, constraint.Z);
                    break;
                case 47:
                    constraint.f2060a0 = typedArray.getFloat(index, constraint.f2060a0);
                    break;
                case 48:
                    constraint.f2062b0 = typedArray.getFloat(index, constraint.f2062b0);
                    break;
                case 49:
                    constraint.f2064c0 = typedArray.getFloat(index, constraint.f2064c0);
                    break;
                case 50:
                    constraint.f2066d0 = typedArray.getFloat(index, constraint.f2066d0);
                    break;
                case 51:
                    constraint.f2068e0 = typedArray.getDimension(index, constraint.f2068e0);
                    break;
                case 52:
                    constraint.f2070f0 = typedArray.getDimension(index, constraint.f2070f0);
                    break;
                case 53:
                    constraint.f2072g0 = typedArray.getDimension(index, constraint.f2072g0);
                    break;
                default:
                    switch (i3) {
                        case 60:
                            constraint.X = typedArray.getFloat(index, constraint.X);
                            break;
                        case 61:
                            constraint.f2104x = f(typedArray, index, constraint.f2104x);
                            break;
                        case 62:
                            constraint.f2105y = typedArray.getDimensionPixelSize(index, constraint.f2105y);
                            break;
                        case 63:
                            constraint.f2106z = typedArray.getFloat(index, constraint.f2106z);
                            break;
                        default:
                            switch (i3) {
                                case 69:
                                    constraint.f2090p0 = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    constraint.f2092q0 = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    constraint.f2096s0 = typedArray.getInt(index, constraint.f2096s0);
                                    break;
                                case 73:
                                    constraint.f2102v0 = typedArray.getString(index);
                                    break;
                                case 74:
                                    constraint.f2094r0 = typedArray.getBoolean(index, constraint.f2094r0);
                                    break;
                                case 75:
                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f2057c.get(index));
                                    break;
                                default:
                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f2057c.get(index));
                                    break;
                            }
                    }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f2058a.keySet());
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (id != -1) {
                if (this.f2058a.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    Constraint constraint = this.f2058a.get(Integer.valueOf(id));
                    if (childAt instanceof Barrier) {
                        constraint.f2098t0 = 1;
                    }
                    int i3 = constraint.f2098t0;
                    if (i3 != -1 && i3 == 1) {
                        Barrier barrier = (Barrier) childAt;
                        barrier.setId(id);
                        barrier.setType(constraint.f2096s0);
                        barrier.setAllowsGoneWidget(constraint.f2094r0);
                        int[] iArr = constraint.f2100u0;
                        if (iArr != null) {
                            barrier.setReferencedIds(iArr);
                        } else {
                            String str = constraint.f2102v0;
                            if (str != null) {
                                int[] c2 = c(barrier, str);
                                constraint.f2100u0 = c2;
                                barrier.setReferencedIds(c2);
                            }
                        }
                    }
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                    constraint.c(layoutParams);
                    childAt.setLayoutParams(layoutParams);
                    childAt.setVisibility(constraint.J);
                    childAt.setAlpha(constraint.U);
                    childAt.setRotation(constraint.X);
                    childAt.setRotationX(constraint.Y);
                    childAt.setRotationY(constraint.Z);
                    childAt.setScaleX(constraint.f2060a0);
                    childAt.setScaleY(constraint.f2062b0);
                    if (!Float.isNaN(constraint.f2064c0)) {
                        childAt.setPivotX(constraint.f2064c0);
                    }
                    if (!Float.isNaN(constraint.f2066d0)) {
                        childAt.setPivotY(constraint.f2066d0);
                    }
                    childAt.setTranslationX(constraint.f2068e0);
                    childAt.setTranslationY(constraint.f2070f0);
                    childAt.setTranslationZ(constraint.f2072g0);
                    if (constraint.V) {
                        childAt.setElevation(constraint.W);
                    }
                }
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            Integer num = (Integer) it2.next();
            Constraint constraint2 = this.f2058a.get(num);
            int i4 = constraint2.f2098t0;
            if (i4 != -1 && i4 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                int[] iArr2 = constraint2.f2100u0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = constraint2.f2102v0;
                    if (str2 != null) {
                        int[] c3 = c(barrier2, str2);
                        constraint2.f2100u0 = c3;
                        barrier2.setReferencedIds(c3);
                    }
                }
                barrier2.setType(constraint2.f2096s0);
                ConstraintLayout.LayoutParams a2 = constraintLayout.generateDefaultLayoutParams();
                barrier2.f();
                constraint2.c(a2);
                constraintLayout.addView(barrier2, a2);
            }
            if (constraint2.f2059a) {
                Guideline guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams a3 = constraintLayout.generateDefaultLayoutParams();
                constraint2.c(a3);
                constraintLayout.addView(guideline, a3);
            }
        }
    }

    public void b(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f2058a.clear();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraints.getChildAt(i2);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id != -1) {
                if (!this.f2058a.containsKey(Integer.valueOf(id))) {
                    this.f2058a.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.f2058a.get(Integer.valueOf(id));
                if (childAt instanceof ConstraintHelper) {
                    constraint.g((ConstraintHelper) childAt, id, layoutParams);
                }
                constraint.f(id, layoutParams);
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void e(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint d2 = d(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        d2.f2059a = true;
                    }
                    this.f2058a.put(Integer.valueOf(d2.f2065d), d2);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
