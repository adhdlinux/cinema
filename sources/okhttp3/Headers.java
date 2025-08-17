package okhttp3;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String[] namesAndValues;

    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String str) {
            Intrinsics.f(str, "line");
            int V = StringsKt__StringsKt.V(str, ':', 0, false, 6, (Object) null);
            if (V != -1) {
                String substring = str.substring(0, V);
                Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String obj = StringsKt__StringsKt.N0(substring).toString();
                String substring2 = str.substring(V + 1);
                Intrinsics.e(substring2, "this as java.lang.String).substring(startIndex)");
                add(obj, substring2);
                return this;
            }
            throw new IllegalArgumentException(("Unexpected header: " + str).toString());
        }

        public final Builder addAll(Headers headers) {
            Intrinsics.f(headers, "headers");
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                addLenient$okhttp(headers.name(i2), headers.value(i2));
            }
            return this;
        }

        public final Builder addLenient$okhttp(String str) {
            Intrinsics.f(str, "line");
            int V = StringsKt__StringsKt.V(str, ':', 1, false, 4, (Object) null);
            if (V != -1) {
                String substring = str.substring(0, V);
                Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring2 = str.substring(V + 1);
                Intrinsics.e(substring2, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(substring, substring2);
            } else if (str.charAt(0) == ':') {
                String substring3 = str.substring(1);
                Intrinsics.e(substring3, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp("", substring3);
            } else {
                addLenient$okhttp("", str);
            }
            return this;
        }

        public final Builder addUnsafeNonAscii(String str, String str2) {
            Intrinsics.f(str, "name");
            Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            Headers.Companion.checkName(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Headers build() {
            return new Headers((String[]) this.namesAndValues.toArray(new String[0]), (DefaultConstructorMarker) null);
        }

        public final String get(String str) {
            Intrinsics.f(str, "name");
            int size = this.namesAndValues.size() - 2;
            int c2 = ProgressionUtilKt.c(size, 0, -2);
            if (c2 > size) {
                return null;
            }
            while (!StringsKt__StringsJVMKt.t(str, this.namesAndValues.get(size), true)) {
                if (size == c2) {
                    return null;
                }
                size -= 2;
            }
            return this.namesAndValues.get(size + 1);
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String str) {
            Intrinsics.f(str, "name");
            int i2 = 0;
            while (i2 < this.namesAndValues.size()) {
                if (StringsKt__StringsJVMKt.t(str, this.namesAndValues.get(i2), true)) {
                    this.namesAndValues.remove(i2);
                    this.namesAndValues.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        public final Builder set(String str, Date date) {
            Intrinsics.f(str, "name");
            Intrinsics.f(date, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            set(str, DatesKt.toHttpDateString(date));
            return this;
        }

        @IgnoreJRERequirement
        public final Builder set(String str, Instant instant) {
            Intrinsics.f(str, "name");
            Intrinsics.f(instant, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            return set(str, new Date(instant.toEpochMilli()));
        }

        public final Builder set(String str, String str2) {
            Intrinsics.f(str, "name");
            Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            removeAll(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder add(String str, String str2) {
            Intrinsics.f(str, "name");
            Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder addLenient$okhttp(String str, String str2) {
            Intrinsics.f(str, "name");
            Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            this.namesAndValues.add(str);
            this.namesAndValues.add(StringsKt__StringsKt.N0(str2).toString());
            return this;
        }

        public final Builder add(String str, Date date) {
            Intrinsics.f(str, "name");
            Intrinsics.f(date, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            add(str, DatesKt.toHttpDateString(date));
            return this;
        }

        @IgnoreJRERequirement
        public final Builder add(String str, Instant instant) {
            Intrinsics.f(str, "name");
            Intrinsics.f(instant, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            add(str, new Date(instant.toEpochMilli()));
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final void checkName(String str) {
            boolean z2;
            boolean z3;
            if (str.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                int length = str.length();
                int i2 = 0;
                while (i2 < length) {
                    char charAt = str.charAt(i2);
                    if ('!' > charAt || charAt >= 127) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        i2++;
                    } else {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty".toString());
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x006f A[LOOP:0: B:1:0x0006->B:20:0x006f, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0024 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void checkValue(java.lang.String r7, java.lang.String r8) {
            /*
                r6 = this;
                int r0 = r7.length()
                r1 = 0
                r2 = 0
            L_0x0006:
                if (r2 >= r0) goto L_0x0072
                char r3 = r7.charAt(r2)
                r4 = 9
                r5 = 1
                if (r3 == r4) goto L_0x0021
                r4 = 32
                if (r4 > r3) goto L_0x001b
                r4 = 127(0x7f, float:1.78E-43)
                if (r3 >= r4) goto L_0x001b
                r4 = 1
                goto L_0x001c
            L_0x001b:
                r4 = 0
            L_0x001c:
                if (r4 == 0) goto L_0x001f
                goto L_0x0021
            L_0x001f:
                r4 = 0
                goto L_0x0022
            L_0x0021:
                r4 = 1
            L_0x0022:
                if (r4 != 0) goto L_0x006f
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r4 = 3
                java.lang.Object[] r4 = new java.lang.Object[r4]
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r4[r1] = r3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r4[r5] = r1
                r1 = 2
                r4[r1] = r8
                java.lang.String r1 = "Unexpected char %#04x at %d in %s value"
                java.lang.String r1 = okhttp3.internal.Util.format(r1, r4)
                r0.append(r1)
                boolean r8 = okhttp3.internal.Util.isSensitiveHeader(r8)
                if (r8 == 0) goto L_0x004d
                java.lang.String r7 = ""
                goto L_0x005e
            L_0x004d:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r1 = ": "
                r8.append(r1)
                r8.append(r7)
                java.lang.String r7 = r8.toString()
            L_0x005e:
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.String r7 = r7.toString()
                r8.<init>(r7)
                throw r8
            L_0x006f:
                int r2 = r2 + 1
                goto L_0x0006
            L_0x0072:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Headers.Companion.checkValue(java.lang.String, java.lang.String):void");
        }

        /* access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            int length = strArr.length - 2;
            int c2 = ProgressionUtilKt.c(length, 0, -2);
            if (c2 > length) {
                return null;
            }
            while (!StringsKt__StringsJVMKt.t(str, strArr[length], true)) {
                if (length == c2) {
                    return null;
                }
                length -= 2;
            }
            return strArr[length + 1];
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m274deprecated_of(String... strArr) {
            Intrinsics.f(strArr, "namesAndValues");
            return of((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final Headers of(String... strArr) {
            Intrinsics.f(strArr, "namesAndValues");
            int i2 = 0;
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                int length = strArr2.length;
                int i3 = 0;
                while (i3 < length) {
                    String str = strArr2[i3];
                    if (str != null) {
                        strArr2[i3] = StringsKt__StringsKt.N0(str).toString();
                        i3++;
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null".toString());
                    }
                }
                int c2 = ProgressionUtilKt.c(0, strArr2.length - 1, 2);
                if (c2 >= 0) {
                    while (true) {
                        String str2 = strArr2[i2];
                        String str3 = strArr2[i2 + 1];
                        checkName(str2);
                        checkValue(str3, str2);
                        if (i2 == c2) {
                            break;
                        }
                        i2 += 2;
                    }
                }
                return new Headers(strArr2, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m273deprecated_of(Map<String, String> map) {
            Intrinsics.f(map, "headers");
            return of(map);
        }

        public final Headers of(Map<String, String> map) {
            Intrinsics.f(map, "<this>");
            String[] strArr = new String[(map.size() * 2)];
            int i2 = 0;
            for (Map.Entry next : map.entrySet()) {
                String obj = StringsKt__StringsKt.N0((String) next.getKey()).toString();
                String obj2 = StringsKt__StringsKt.N0((String) next.getValue()).toString();
                checkName(obj);
                checkValue(obj2, obj);
                strArr[i2] = obj;
                strArr[i2 + 1] = obj2;
                i2 += 2;
            }
            return new Headers(strArr, (DefaultConstructorMarker) null);
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public /* synthetic */ Headers(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr);
    }

    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }

    public static final Headers of(String... strArr) {
        return Companion.of(strArr);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m272deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = (long) (strArr.length * 2);
        int length2 = strArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            length += (long) this.namesAndValues[i2].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    public final String get(String str) {
        Intrinsics.f(str, "name");
        return Companion.get(this.namesAndValues, str);
    }

    public final Date getDate(String str) {
        Intrinsics.f(str, "name");
        String str2 = get(str);
        if (str2 != null) {
            return DatesKt.toHttpDateOrNull(str2);
        }
        return null;
    }

    @IgnoreJRERequirement
    public final Instant getInstant(String str) {
        Intrinsics.f(str, "name");
        Date date = getDate(str);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public Iterator<Pair<String, String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i2 = 0; i2 < size; i2++) {
            pairArr[i2] = TuplesKt.a(name(i2), value(i2));
        }
        return ArrayIteratorKt.a(pairArr);
    }

    public final String name(int i2) {
        return this.namesAndValues[i2 * 2];
    }

    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(StringsKt__StringsJVMKt.u(StringCompanionObject.f40434a));
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            treeSet.add(name(i2));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        Intrinsics.e(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.v(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(StringsKt__StringsJVMKt.u(StringCompanionObject.f40434a));
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            String name = name(i2);
            Locale locale = Locale.US;
            Intrinsics.e(locale, "US");
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i2));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            String name = name(i2);
            String value = value(i2);
            sb.append(name);
            sb.append(": ");
            if (Util.isSensitiveHeader(name)) {
                value = "██";
            }
            sb.append(value);
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String value(int i2) {
        return this.namesAndValues[(i2 * 2) + 1];
    }

    public final List<String> values(String str) {
        Intrinsics.f(str, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            if (StringsKt__StringsJVMKt.t(str, name(i2), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i2));
            }
        }
        if (arrayList == null) {
            return CollectionsKt__CollectionsKt.f();
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.e(unmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return unmodifiableList;
    }
}
