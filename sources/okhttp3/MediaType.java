package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class MediaType {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    /* access modifiers changed from: private */
    public static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final MediaType m300deprecated_get(String str) {
            Intrinsics.f(str, "mediaType");
            return get(str);
        }

        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final MediaType m301deprecated_parse(String str) {
            Intrinsics.f(str, "mediaType");
            return parse(str);
        }

        public final MediaType get(String str) {
            Intrinsics.f(str, "<this>");
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(str);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                Intrinsics.e(group, "typeSubtype.group(1)");
                Locale locale = Locale.US;
                Intrinsics.e(locale, "US");
                String lowerCase = group.toLowerCase(locale);
                Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                String group2 = matcher.group(2);
                Intrinsics.e(group2, "typeSubtype.group(2)");
                Intrinsics.e(locale, "US");
                String lowerCase2 = group2.toLowerCase(locale);
                Intrinsics.e(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                ArrayList arrayList = new ArrayList();
                Matcher matcher2 = MediaType.PARAMETER.matcher(str);
                int end = matcher.end();
                while (end < str.length()) {
                    matcher2.region(end, str.length());
                    if (matcher2.lookingAt()) {
                        String group3 = matcher2.group(1);
                        if (group3 == null) {
                            end = matcher2.end();
                        } else {
                            String group4 = matcher2.group(2);
                            if (group4 == null) {
                                group4 = matcher2.group(3);
                            } else if (StringsKt__StringsJVMKt.G(group4, "'", false, 2, (Object) null) && StringsKt__StringsJVMKt.s(group4, "'", false, 2, (Object) null) && group4.length() > 2) {
                                group4 = group4.substring(1, group4.length() - 1);
                                Intrinsics.e(group4, "this as java.lang.String…ing(startIndex, endIndex)");
                            }
                            arrayList.add(group3);
                            arrayList.add(group4);
                            end = matcher2.end();
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Parameter is not formatted correctly: \"");
                        String substring = str.substring(end);
                        Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
                        sb.append(substring);
                        sb.append("\" for: \"");
                        sb.append(str);
                        sb.append('\"');
                        throw new IllegalArgumentException(sb.toString().toString());
                    }
                }
                return new MediaType(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]), (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
        }

        public final MediaType parse(String str) {
            Intrinsics.f(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    private MediaType(String str, String str2, String str3, String[] strArr) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    public /* synthetic */ MediaType(String str, String str2, String str3, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, strArr);
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType2, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = null;
        }
        return mediaType2.charset(charset);
    }

    public static final MediaType get(String str) {
        return Companion.get(str);
    }

    public static final MediaType parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_subtype  reason: not valid java name */
    public final String m298deprecated_subtype() {
        return this.subtype;
    }

    /* renamed from: -deprecated_type  reason: not valid java name */
    public final String m299deprecated_type() {
        return this.type;
    }

    public final Charset charset() {
        return charset$default(this, (Charset) null, 1, (Object) null);
    }

    public final Charset charset(Charset charset) {
        String parameter = parameter("charset");
        if (parameter == null) {
            return charset;
        }
        try {
            return Charset.forName(parameter);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && Intrinsics.a(((MediaType) obj).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String parameter(String str) {
        Intrinsics.f(str, "name");
        int i2 = 0;
        int c2 = ProgressionUtilKt.c(0, this.parameterNamesAndValues.length - 1, 2);
        if (c2 < 0) {
            return null;
        }
        while (!StringsKt__StringsJVMKt.t(this.parameterNamesAndValues[i2], str, true)) {
            if (i2 == c2) {
                return null;
            }
            i2 += 2;
        }
        return this.parameterNamesAndValues[i2 + 1];
    }

    public final String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }
}
