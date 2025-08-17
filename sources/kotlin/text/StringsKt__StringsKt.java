package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static /* synthetic */ boolean A0(CharSequence charSequence, char c2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return y0(charSequence, c2, z2);
    }

    public static /* synthetic */ boolean B0(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return z0(charSequence, charSequence2, z2);
    }

    public static final String C0(CharSequence charSequence, IntRange intRange) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(intRange, "range");
        return charSequence.subSequence(intRange.i().intValue(), intRange.h().intValue() + 1).toString();
    }

    public static final String D0(String str, char c2, String str2) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "missingDelimiterValue");
        int V = V(str, c2, 0, false, 6, (Object) null);
        if (V == -1) {
            return str2;
        }
        String substring = str.substring(V + 1, str.length());
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String E0(String str, String str2, String str3) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "delimiter");
        Intrinsics.f(str3, "missingDelimiterValue");
        int W = W(str, str2, 0, false, 6, (Object) null);
        if (W == -1) {
            return str3;
        }
        String substring = str.substring(W + str2.length(), str.length());
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String F0(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return D0(str, c2, str2);
    }

    public static /* synthetic */ String G0(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return E0(str, str2, str3);
    }

    public static String H0(String str, char c2, String str2) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "missingDelimiterValue");
        int a02 = a0(str, c2, 0, false, 6, (Object) null);
        if (a02 == -1) {
            return str2;
        }
        String substring = str.substring(a02 + 1, str.length());
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean I(CharSequence charSequence, char c2, boolean z2) {
        Intrinsics.f(charSequence, "<this>");
        if (V(charSequence, c2, 0, z2, 2, (Object) null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ String I0(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return H0(str, c2, str2);
    }

    public static boolean J(CharSequence charSequence, CharSequence charSequence2, boolean z2) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (W(charSequence, (String) charSequence2, 0, z2, 2, (Object) null) >= 0) {
                return true;
            }
        } else {
            if (U(charSequence, charSequence2, 0, charSequence.length(), z2, false, 16, (Object) null) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static final String J0(String str, char c2, String str2) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "missingDelimiterValue");
        int V = V(str, c2, 0, false, 6, (Object) null);
        if (V == -1) {
            return str2;
        }
        String substring = str.substring(0, V);
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean K(CharSequence charSequence, char c2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return I(charSequence, c2, z2);
    }

    public static final String K0(String str, String str2, String str3) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "delimiter");
        Intrinsics.f(str3, "missingDelimiterValue");
        int W = W(str, str2, 0, false, 6, (Object) null);
        if (W == -1) {
            return str3;
        }
        String substring = str.substring(0, W);
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean L(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return J(charSequence, charSequence2, z2);
    }

    public static /* synthetic */ String L0(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return J0(str, c2, str2);
    }

    public static final boolean M(CharSequence charSequence, CharSequence charSequence2, boolean z2) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(charSequence2, "suffix");
        if (!z2 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.s((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return l0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z2);
    }

    public static /* synthetic */ String M0(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return K0(str, str2, str3);
    }

    public static /* synthetic */ boolean N(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return M(charSequence, charSequence2, z2);
    }

    public static CharSequence N0(CharSequence charSequence) {
        int i2;
        Intrinsics.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i3 = 0;
        boolean z2 = false;
        while (i3 <= length) {
            if (!z2) {
                i2 = i3;
            } else {
                i2 = length;
            }
            boolean c2 = CharsKt__CharJVMKt.c(charSequence.charAt(i2));
            if (!z2) {
                if (!c2) {
                    z2 = true;
                } else {
                    i3++;
                }
            } else if (!c2) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i3, length + 1);
    }

    /* access modifiers changed from: private */
    public static final Pair<Integer, String> O(CharSequence charSequence, Collection<String> collection, int i2, boolean z2, boolean z3) {
        IntProgression intProgression;
        Object obj;
        Object obj2;
        int i3;
        if (z2 || collection.size() != 1) {
            if (!z3) {
                intProgression = new IntRange(RangesKt___RangesKt.b(i2, 0), charSequence.length());
            } else {
                intProgression = RangesKt___RangesKt.h(RangesKt___RangesKt.d(i2, Q(charSequence)), 0);
            }
            if (charSequence instanceof String) {
                int a2 = intProgression.a();
                int b2 = intProgression.b();
                int d2 = intProgression.d();
                if ((d2 > 0 && a2 <= b2) || (d2 < 0 && b2 <= a2)) {
                    while (true) {
                        Iterator it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it2.next();
                            String str = (String) obj2;
                            if (StringsKt__StringsJVMKt.w(str, 0, (String) charSequence, a2, str.length(), z2)) {
                                break;
                            }
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            if (a2 == b2) {
                                break;
                            }
                            a2 += d2;
                        } else {
                            return TuplesKt.a(Integer.valueOf(a2), str2);
                        }
                    }
                }
            } else {
                int a3 = intProgression.a();
                int b3 = intProgression.b();
                int d3 = intProgression.d();
                if ((d3 > 0 && a3 <= b3) || (d3 < 0 && b3 <= a3)) {
                    while (true) {
                        Iterator it3 = collection.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it3.next();
                            String str3 = (String) obj;
                            if (l0(str3, 0, charSequence, a3, str3.length(), z2)) {
                                break;
                            }
                        }
                        String str4 = (String) obj;
                        if (str4 == null) {
                            if (a3 == b3) {
                                break;
                            }
                            a3 += d3;
                        } else {
                            return TuplesKt.a(Integer.valueOf(a3), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) CollectionsKt___CollectionsKt.Q(collection);
        CharSequence charSequence2 = charSequence;
        String str6 = str5;
        int i4 = i2;
        if (!z3) {
            i3 = W(charSequence2, str6, i4, false, 4, (Object) null);
        } else {
            i3 = b0(charSequence2, str6, i4, false, 4, (Object) null);
        }
        if (i3 < 0) {
            return null;
        }
        return TuplesKt.a(Integer.valueOf(i3), str5);
    }

    public static String O0(String str, char... cArr) {
        int i2;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(cArr, "chars");
        int length = str.length() - 1;
        int i3 = 0;
        boolean z2 = false;
        while (i3 <= length) {
            if (!z2) {
                i2 = i3;
            } else {
                i2 = length;
            }
            boolean p2 = ArraysKt___ArraysKt.p(cArr, str.charAt(i2));
            if (!z2) {
                if (!p2) {
                    z2 = true;
                } else {
                    i3++;
                }
            } else if (!p2) {
                break;
            } else {
                length--;
            }
        }
        return str.subSequence(i3, length + 1).toString();
    }

    public static final IntRange P(CharSequence charSequence) {
        Intrinsics.f(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static CharSequence P0(CharSequence charSequence) {
        Intrinsics.f(charSequence, "<this>");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!CharsKt__CharJVMKt.c(charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    public static int Q(CharSequence charSequence) {
        Intrinsics.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int R(CharSequence charSequence, char c2, int i2, boolean z2) {
        Intrinsics.f(charSequence, "<this>");
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i2);
        }
        return X(charSequence, new char[]{c2}, i2, z2);
    }

    public static final int S(CharSequence charSequence, String str, int i2, boolean z2) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(str, "string");
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i2);
        }
        return U(charSequence, str, i2, charSequence.length(), z2, false, 16, (Object) null);
    }

    private static final int T(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z2, boolean z3) {
        IntProgression intProgression;
        if (!z3) {
            intProgression = new IntRange(RangesKt___RangesKt.b(i2, 0), RangesKt___RangesKt.d(i3, charSequence.length()));
        } else {
            intProgression = RangesKt___RangesKt.h(RangesKt___RangesKt.d(i2, Q(charSequence)), RangesKt___RangesKt.b(i3, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a2 = intProgression.a();
            int b2 = intProgression.b();
            int d2 = intProgression.d();
            if ((d2 <= 0 || a2 > b2) && (d2 >= 0 || b2 > a2)) {
                return -1;
            }
            while (true) {
                if (l0(charSequence2, 0, charSequence, a2, charSequence2.length(), z2)) {
                    return a2;
                }
                if (a2 == b2) {
                    return -1;
                }
                a2 += d2;
            }
        } else {
            int a3 = intProgression.a();
            int b3 = intProgression.b();
            int d3 = intProgression.d();
            if ((d3 <= 0 || a3 > b3) && (d3 >= 0 || b3 > a3)) {
                return -1;
            }
            while (true) {
                if (StringsKt__StringsJVMKt.w((String) charSequence2, 0, (String) charSequence, a3, charSequence2.length(), z2)) {
                    return a3;
                }
                if (a3 == b3) {
                    return -1;
                }
                a3 += d3;
            }
        }
    }

    static /* synthetic */ int U(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z2, boolean z3, int i4, Object obj) {
        return T(charSequence, charSequence2, i2, i3, z2, (i4 & 16) != 0 ? false : z3);
    }

    public static /* synthetic */ int V(CharSequence charSequence, char c2, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return R(charSequence, c2, i2, z2);
    }

    public static /* synthetic */ int W(CharSequence charSequence, String str, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return S(charSequence, str, i2, z2);
    }

    public static final int X(CharSequence charSequence, char[] cArr, int i2, boolean z2) {
        boolean z3;
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(cArr, "chars");
        if (z2 || cArr.length != 1 || !(charSequence instanceof String)) {
            IntIterator e2 = new IntRange(RangesKt___RangesKt.b(i2, 0), Q(charSequence)).iterator();
            while (e2.hasNext()) {
                int nextInt = e2.nextInt();
                char charAt = charSequence.charAt(nextInt);
                int length = cArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z3 = false;
                        continue;
                        break;
                    } else if (CharsKt__CharKt.e(cArr[i3], charAt, z2)) {
                        z3 = true;
                        continue;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z3) {
                    return nextInt;
                }
            }
            return -1;
        }
        return ((String) charSequence).indexOf(ArraysKt___ArraysKt.N(cArr), i2);
    }

    public static final int Y(CharSequence charSequence, char c2, int i2, boolean z2) {
        Intrinsics.f(charSequence, "<this>");
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i2);
        }
        return c0(charSequence, new char[]{c2}, i2, z2);
    }

    public static final int Z(CharSequence charSequence, String str, int i2, boolean z2) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(str, "string");
        if (z2 || !(charSequence instanceof String)) {
            return T(charSequence, str, i2, 0, z2, true);
        }
        return ((String) charSequence).lastIndexOf(str, i2);
    }

    public static /* synthetic */ int a0(CharSequence charSequence, char c2, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = Q(charSequence);
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return Y(charSequence, c2, i2, z2);
    }

    public static /* synthetic */ int b0(CharSequence charSequence, String str, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = Q(charSequence);
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return Z(charSequence, str, i2, z2);
    }

    public static final int c0(CharSequence charSequence, char[] cArr, int i2, boolean z2) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(cArr, "chars");
        if (z2 || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int d2 = RangesKt___RangesKt.d(i2, Q(charSequence)); -1 < d2; d2--) {
                char charAt = charSequence.charAt(d2);
                int length = cArr.length;
                boolean z3 = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (CharsKt__CharKt.e(cArr[i3], charAt, z2)) {
                        z3 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z3) {
                    return d2;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(ArraysKt___ArraysKt.N(cArr), i2);
    }

    public static final Sequence<String> d0(CharSequence charSequence) {
        Intrinsics.f(charSequence, "<this>");
        return x0(charSequence, new String[]{"\r\n", ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "\r"}, false, 0, 6, (Object) null);
    }

    public static final List<String> e0(CharSequence charSequence) {
        Intrinsics.f(charSequence, "<this>");
        return SequencesKt___SequencesKt.l(d0(charSequence));
    }

    public static final CharSequence f0(CharSequence charSequence, int i2, char c2) {
        Intrinsics.f(charSequence, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
        } else if (i2 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i2);
            IntIterator e2 = new IntRange(1, i2 - charSequence.length()).iterator();
            while (e2.hasNext()) {
                e2.nextInt();
                sb.append(c2);
            }
            sb.append(charSequence);
            return sb;
        }
    }

    public static String g0(String str, int i2, char c2) {
        Intrinsics.f(str, "<this>");
        return f0(str, i2, c2).toString();
    }

    private static final Sequence<IntRange> h0(CharSequence charSequence, char[] cArr, int i2, boolean z2, int i3) {
        q0(i3);
        return new DelimitedRangesSequence(charSequence, i2, i3, new StringsKt__StringsKt$rangesDelimitedBy$1(cArr, z2));
    }

    private static final Sequence<IntRange> i0(CharSequence charSequence, String[] strArr, int i2, boolean z2, int i3) {
        q0(i3);
        return new DelimitedRangesSequence(charSequence, i2, i3, new StringsKt__StringsKt$rangesDelimitedBy$2(ArraysKt___ArraysJvmKt.d(strArr), z2));
    }

    static /* synthetic */ Sequence j0(CharSequence charSequence, char[] cArr, int i2, boolean z2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return h0(charSequence, cArr, i2, z2, i3);
    }

    static /* synthetic */ Sequence k0(CharSequence charSequence, String[] strArr, int i2, boolean z2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return i0(charSequence, strArr, i2, z2, i3);
    }

    public static final boolean l0(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z2) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(charSequence2, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!CharsKt__CharKt.e(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z2)) {
                return false;
            }
        }
        return true;
    }

    public static String m0(String str, CharSequence charSequence) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(charSequence, "prefix");
        if (!B0(str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static String n0(String str, CharSequence charSequence) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(charSequence, "suffix");
        if (!N(str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static String o0(String str, CharSequence charSequence) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(charSequence, "delimiter");
        return p0(str, charSequence, charSequence);
    }

    public static String p0(String str, CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(charSequence, "prefix");
        Intrinsics.f(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length() || !B0(str, charSequence, false, 2, (Object) null) || !N(str, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final void q0(int i2) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2).toString());
        }
    }

    public static final List<String> r0(CharSequence charSequence, char[] cArr, boolean z2, int i2) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(cArr, "delimiters");
        if (cArr.length == 1) {
            return t0(charSequence, String.valueOf(cArr[0]), z2, i2);
        }
        Iterable<IntRange> f2 = SequencesKt___SequencesKt.f(j0(charSequence, cArr, 0, z2, i2, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(f2, 10));
        for (IntRange C0 : f2) {
            arrayList.add(C0(charSequence, C0));
        }
        return arrayList;
    }

    public static final List<String> s0(CharSequence charSequence, String[] strArr, boolean z2, int i2) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(strArr, "delimiters");
        boolean z3 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                z3 = false;
            }
            if (!z3) {
                return t0(charSequence, str, z2, i2);
            }
        }
        Iterable<IntRange> f2 = SequencesKt___SequencesKt.f(k0(charSequence, strArr, 0, z2, i2, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(f2, 10));
        for (IntRange C0 : f2) {
            arrayList.add(C0(charSequence, C0));
        }
        return arrayList;
    }

    private static final List<String> t0(CharSequence charSequence, String str, boolean z2, int i2) {
        boolean z3;
        q0(i2);
        int i3 = 0;
        int S = S(charSequence, str, 0, z2);
        if (S == -1 || i2 == 1) {
            return CollectionsKt__CollectionsJVMKt.b(charSequence.toString());
        }
        if (i2 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i4 = 10;
        if (z3) {
            i4 = RangesKt___RangesKt.d(i2, 10);
        }
        ArrayList arrayList = new ArrayList(i4);
        do {
            arrayList.add(charSequence.subSequence(i3, S).toString());
            i3 = str.length() + S;
            if ((z3 && arrayList.size() == i2 - 1) || (S = S(charSequence, str, i3, z2)) == -1) {
                arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i3, S).toString());
            i3 = str.length() + S;
            break;
        } while ((S = S(charSequence, str, i3, z2)) == -1);
        arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List u0(CharSequence charSequence, char[] cArr, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return r0(charSequence, cArr, z2, i2);
    }

    public static /* synthetic */ List v0(CharSequence charSequence, String[] strArr, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return s0(charSequence, strArr, z2, i2);
    }

    public static final Sequence<String> w0(CharSequence charSequence, String[] strArr, boolean z2, int i2) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(strArr, "delimiters");
        return SequencesKt___SequencesKt.k(k0(charSequence, strArr, 0, z2, i2, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    public static /* synthetic */ Sequence x0(CharSequence charSequence, String[] strArr, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return w0(charSequence, strArr, z2, i2);
    }

    public static final boolean y0(CharSequence charSequence, char c2, boolean z2) {
        Intrinsics.f(charSequence, "<this>");
        if (charSequence.length() <= 0 || !CharsKt__CharKt.e(charSequence.charAt(0), c2, z2)) {
            return false;
        }
        return true;
    }

    public static final boolean z0(CharSequence charSequence, CharSequence charSequence2, boolean z2) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(charSequence2, "prefix");
        if (!z2 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.G((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return l0(charSequence, 0, charSequence2, 0, charSequence2.length(), z2);
    }
}
