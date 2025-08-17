package kotlin.text;

import com.facebook.react.uimanager.ViewProps;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

public final class Regex implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f40540c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final Pattern f40541b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final int b(int i2) {
            return (i2 & 2) != 0 ? i2 | 64 : i2;
        }
    }

    public Regex(Pattern pattern) {
        Intrinsics.f(pattern, "nativePattern");
        this.f40541b = pattern;
    }

    public static /* synthetic */ MatchResult c(Regex regex, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.b(charSequence, i2);
    }

    public static /* synthetic */ Sequence e(Regex regex, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.d(charSequence, i2);
    }

    public final boolean a(CharSequence charSequence) {
        Intrinsics.f(charSequence, "input");
        return this.f40541b.matcher(charSequence).find();
    }

    public final MatchResult b(CharSequence charSequence, int i2) {
        Intrinsics.f(charSequence, "input");
        Matcher matcher = this.f40541b.matcher(charSequence);
        Intrinsics.e(matcher, "nativePattern.matcher(input)");
        return RegexKt.e(matcher, i2, charSequence);
    }

    public final Sequence<MatchResult> d(CharSequence charSequence, int i2) {
        Intrinsics.f(charSequence, "input");
        if (i2 >= 0 && i2 <= charSequence.length()) {
            return SequencesKt__SequencesKt.e(new Regex$findAll$1(this, charSequence, i2), Regex$findAll$2.f40545c);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i2 + ", input length: " + charSequence.length());
    }

    public final MatchResult f(CharSequence charSequence) {
        Intrinsics.f(charSequence, "input");
        Matcher matcher = this.f40541b.matcher(charSequence);
        Intrinsics.e(matcher, "nativePattern.matcher(input)");
        return RegexKt.f(matcher, charSequence);
    }

    public final boolean g(CharSequence charSequence) {
        Intrinsics.f(charSequence, "input");
        return this.f40541b.matcher(charSequence).matches();
    }

    public final String h(CharSequence charSequence, String str) {
        Intrinsics.f(charSequence, "input");
        Intrinsics.f(str, "replacement");
        String replaceAll = this.f40541b.matcher(charSequence).replaceAll(str);
        Intrinsics.e(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String i(CharSequence charSequence, Function1<? super MatchResult, ? extends CharSequence> function1) {
        Intrinsics.f(charSequence, "input");
        Intrinsics.f(function1, ViewProps.TRANSFORM);
        int i2 = 0;
        MatchResult c2 = c(this, charSequence, 0, 2, (Object) null);
        if (c2 == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(charSequence, i2, c2.b().i().intValue());
            sb.append((CharSequence) function1.invoke(c2));
            i2 = c2.b().h().intValue() + 1;
            c2 = c2.next();
            if (i2 >= length) {
                break;
            }
        } while (c2 != null);
        if (i2 < length) {
            sb.append(charSequence, i2, length);
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "sb.toString()");
        return sb2;
    }

    public final String j(CharSequence charSequence, String str) {
        Intrinsics.f(charSequence, "input");
        Intrinsics.f(str, "replacement");
        String replaceFirst = this.f40541b.matcher(charSequence).replaceFirst(str);
        Intrinsics.e(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public final List<String> k(CharSequence charSequence, int i2) {
        Intrinsics.f(charSequence, "input");
        StringsKt__StringsKt.q0(i2);
        Matcher matcher = this.f40541b.matcher(charSequence);
        if (i2 == 1 || !matcher.find()) {
            return CollectionsKt__CollectionsJVMKt.b(charSequence.toString());
        }
        int i3 = 10;
        if (i2 > 0) {
            i3 = RangesKt___RangesKt.d(i2, 10);
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = i2 - 1;
        int i5 = 0;
        do {
            arrayList.add(charSequence.subSequence(i5, matcher.start()).toString());
            i5 = matcher.end();
            if ((i4 >= 0 && arrayList.size() == i4) || !matcher.find()) {
                arrayList.add(charSequence.subSequence(i5, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i5, matcher.start()).toString());
            i5 = matcher.end();
            break;
        } while (!matcher.find());
        arrayList.add(charSequence.subSequence(i5, charSequence.length()).toString());
        return arrayList;
    }

    public String toString() {
        String pattern = this.f40541b.toString();
        Intrinsics.e(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Regex(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(pattern)"
            kotlin.jvm.internal.Intrinsics.e(r2, r0)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Regex(java.lang.String r2, kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            kotlin.text.Regex$Companion r0 = f40540c
            int r3 = r3.b()
            int r3 = r0.b(r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureUnicodeCase(option.value))"
            kotlin.jvm.internal.Intrinsics.e(r2, r3)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }
}
