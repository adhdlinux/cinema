package kotlin.sequences;

import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {
    public static <T> Iterable<T> f(Sequence<? extends T> sequence) {
        Intrinsics.f(sequence, "<this>");
        return new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(sequence);
    }

    public static <T> Sequence<T> g(Sequence<? extends T> sequence, int i2) {
        boolean z2;
        Intrinsics.f(sequence, "<this>");
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        } else if (i2 == 0) {
            return sequence;
        } else {
            if (sequence instanceof DropTakeSequence) {
                return ((DropTakeSequence) sequence).a(i2);
            }
            return new DropSequence(sequence, i2);
        }
    }

    public static final <T, A extends Appendable> A h(Sequence<? extends T> sequence, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(a2, "buffer");
        Intrinsics.f(charSequence, "separator");
        Intrinsics.f(charSequence2, "prefix");
        Intrinsics.f(charSequence3, "postfix");
        Intrinsics.f(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (Object next : sequence) {
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

    public static final <T> String i(Sequence<? extends T> sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(charSequence, "separator");
        Intrinsics.f(charSequence2, "prefix");
        Intrinsics.f(charSequence3, "postfix");
        Intrinsics.f(charSequence4, "truncated");
        String sb = ((StringBuilder) h(sequence, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.e(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String j(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
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
        return i(sequence, charSequence, charSequence5, charSequence6, i4, charSequence7, function1);
    }

    public static <T, R> Sequence<R> k(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(function1, ViewProps.TRANSFORM);
        return new TransformingSequence(sequence, function1);
    }

    public static <T> List<T> l(Sequence<? extends T> sequence) {
        Intrinsics.f(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return CollectionsKt__CollectionsKt.f();
        }
        Object next = it2.next();
        if (!it2.hasNext()) {
            return CollectionsKt__CollectionsJVMKt.b(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        return arrayList;
    }
}
