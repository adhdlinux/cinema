package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    public static <T> List<T> A(List<? extends T> list, int i2) {
        boolean z2;
        Intrinsics.f(list, "<this>");
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return U(list, RangesKt___RangesKt.b(list.size() - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static <T> T B(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof List) {
            return C((List) iterable);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (it2.hasNext()) {
            return it2.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T C(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T D(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T E(List<? extends T> list, int i2) {
        Intrinsics.f(list, "<this>");
        if (i2 < 0 || i2 > CollectionsKt__CollectionsKt.h(list)) {
            return null;
        }
        return list.get(i2);
    }

    public static <T> int F(Iterable<? extends T> iterable, T t2) {
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t2);
        }
        int i2 = 0;
        for (Object next : iterable) {
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.o();
            }
            if (Intrinsics.a(t2, next)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A G(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(a2, "buffer");
        Intrinsics.f(charSequence, "separator");
        Intrinsics.f(charSequence2, "prefix");
        Intrinsics.f(charSequence3, "postfix");
        Intrinsics.f(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (Object next : iterable) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            StringsKt__AppendableKt.a(a2, next, function1);
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ Appendable H(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i4;
        CharSequence charSequence7;
        Function1 function12;
        if ((i3 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i3 & 4) != 0) {
            charSequence6 = charSequence8;
        } else {
            charSequence6 = charSequence2;
        }
        if ((i3 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i3 & 16) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i3 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return G(iterable, appendable, charSequence5, charSequence6, charSequence8, i4, charSequence7, function12);
    }

    public static final <T> String I(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(charSequence, "separator");
        Intrinsics.f(charSequence2, "prefix");
        Intrinsics.f(charSequence3, "postfix");
        Intrinsics.f(charSequence4, "truncated");
        String sb = ((StringBuilder) G(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.e(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String J(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        int i4;
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i3 & 2) != 0) {
            charSequence5 = charSequence6;
        } else {
            charSequence5 = charSequence2;
        }
        if ((i3 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i3 & 8) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return I(iterable, charSequence, charSequence5, charSequence6, i4, charSequence7, function1);
    }

    public static <T> T K(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(CollectionsKt__CollectionsKt.h(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T L(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T extends Comparable<? super T>> T M(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T t2 = (Comparable) it2.next();
        while (it2.hasNext()) {
            T t3 = (Comparable) it2.next();
            if (t2.compareTo(t3) > 0) {
                t2 = t3;
            }
        }
        return t2;
    }

    public static <T> List<T> N(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        Intrinsics.f(collection, "<this>");
        Intrinsics.f(iterable, "elements");
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        boolean unused = CollectionsKt__MutableCollectionsKt.u(arrayList2, iterable);
        return arrayList2;
    }

    public static <T> List<T> O(Collection<? extends T> collection, T t2) {
        Intrinsics.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t2);
        return arrayList;
    }

    public static <T> List<T> P(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return a0(iterable);
        }
        List<T> b02 = b0(iterable);
        CollectionsKt___CollectionsJvmKt.x(b02);
        return b02;
    }

    public static <T> T Q(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof List) {
            return R((List) iterable);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            if (!it2.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T R(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static <T> T S(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static <T> List<T> T(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return a0(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            ArraysKt___ArraysJvmKt.n(array, comparator);
            return ArraysKt___ArraysJvmKt.d(array);
        }
        List<T> b02 = b0(iterable);
        CollectionsKt__MutableCollectionsJVMKt.t(b02, comparator);
        return b02;
    }

    public static <T> List<T> U(Iterable<? extends T> iterable, int i2) {
        boolean z2;
        Intrinsics.f(iterable, "<this>");
        int i3 = 0;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.f();
        } else {
            if (iterable instanceof Collection) {
                if (i2 >= ((Collection) iterable).size()) {
                    return a0(iterable);
                }
                if (i2 == 1) {
                    return CollectionsKt__CollectionsJVMKt.b(B(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i2);
            for (Object add : iterable) {
                arrayList.add(add);
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return CollectionsKt__CollectionsKt.l(arrayList);
        }
    }

    public static boolean[] V(Collection<Boolean> collection) {
        Intrinsics.f(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        int i2 = 0;
        for (Boolean booleanValue : collection) {
            zArr[i2] = booleanValue.booleanValue();
            i2++;
        }
        return zArr;
    }

    public static byte[] W(Collection<Byte> collection) {
        Intrinsics.f(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        int i2 = 0;
        for (Byte byteValue : collection) {
            bArr[i2] = byteValue.byteValue();
            i2++;
        }
        return bArr;
    }

    public static final <T, C extends Collection<? super T>> C X(Iterable<? extends T> iterable, C c2) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(c2, "destination");
        for (Object add : iterable) {
            c2.add(add);
        }
        return c2;
    }

    public static <T> HashSet<T> Y(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        return (HashSet) X(iterable, new HashSet(MapsKt__MapsJVMKt.d(CollectionsKt__IterablesKt.p(iterable, 12))));
    }

    public static int[] Z(Collection<Integer> collection) {
        Intrinsics.f(collection, "<this>");
        int[] iArr = new int[collection.size()];
        int i2 = 0;
        for (Integer intValue : collection) {
            iArr[i2] = intValue.intValue();
            i2++;
        }
        return iArr;
    }

    public static <T> List<T> a0(Iterable<? extends T> iterable) {
        Object obj;
        Intrinsics.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return CollectionsKt__CollectionsKt.l(b0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return CollectionsKt__CollectionsKt.f();
        }
        if (size != 1) {
            return c0(collection);
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return CollectionsKt__CollectionsJVMKt.b(obj);
    }

    public static final <T> List<T> b0(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return c0((Collection) iterable);
        }
        return (List) X(iterable, new ArrayList());
    }

    public static <T> List<T> c0(Collection<? extends T> collection) {
        Intrinsics.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> d0(Iterable<? extends T> iterable) {
        Object obj;
        Intrinsics.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return SetsKt__SetsKt.c((Set) X(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return SetsKt__SetsKt.b();
        }
        if (size != 1) {
            return (Set) X(iterable, new LinkedHashSet(MapsKt__MapsJVMKt.d(collection.size())));
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return SetsKt__SetsJVMKt.a(obj);
    }

    public static <T, R> List<Pair<T, R>> e0(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(iterable2, "other");
        Iterator<? extends T> it2 = iterable.iterator();
        Iterator<? extends R> it3 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.p(iterable, 10), CollectionsKt__IterablesKt.p(iterable2, 10)));
        while (it2.hasNext() && it3.hasNext()) {
            arrayList.add(TuplesKt.a(it2.next(), it3.next()));
        }
        return arrayList;
    }

    public static <T> Sequence<T> y(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        return new CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(iterable);
    }

    public static <T> boolean z(Iterable<? extends T> iterable, T t2) {
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t2);
        }
        if (F(iterable, t2) >= 0) {
            return true;
        }
        return false;
    }
}
