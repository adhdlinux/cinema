package org.apache.commons.lang3;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.text.translate.AggregateTranslator;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import org.apache.commons.lang3.text.translate.EntityArrays;
import org.apache.commons.lang3.text.translate.JavaUnicodeEscaper;
import org.apache.commons.lang3.text.translate.LookupTranslator;
import org.apache.commons.lang3.text.translate.NumericEntityEscaper;
import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;
import org.apache.commons.lang3.text.translate.OctalUnescaper;
import org.apache.commons.lang3.text.translate.UnicodeUnescaper;
import org.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover;

@Deprecated
public class StringEscapeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final CharSequenceTranslator f41415a = new LookupTranslator(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}).e(new LookupTranslator(EntityArrays.i())).e(JavaUnicodeEscaper.h(32, 127));

    /* renamed from: b  reason: collision with root package name */
    public static final CharSequenceTranslator f41416b = new AggregateTranslator(new LookupTranslator(new String[]{"'", "\\'"}, new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{"/", "\\/"}), new LookupTranslator(EntityArrays.i()), JavaUnicodeEscaper.h(32, 127));

    /* renamed from: c  reason: collision with root package name */
    public static final CharSequenceTranslator f41417c = new AggregateTranslator(new LookupTranslator(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{"/", "\\/"}), new LookupTranslator(EntityArrays.i()), JavaUnicodeEscaper.h(32, 127));
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final CharSequenceTranslator f41418d = new AggregateTranslator(new LookupTranslator(EntityArrays.c()), new LookupTranslator(EntityArrays.a()));

    /* renamed from: e  reason: collision with root package name */
    public static final CharSequenceTranslator f41419e = new AggregateTranslator(new LookupTranslator(EntityArrays.c()), new LookupTranslator(EntityArrays.a()), new LookupTranslator(new String[]{"\u0000", ""}, new String[]{"\u0001", ""}, new String[]{"\u0002", ""}, new String[]{"\u0003", ""}, new String[]{"\u0004", ""}, new String[]{"\u0005", ""}, new String[]{"\u0006", ""}, new String[]{"\u0007", ""}, new String[]{"\b", ""}, new String[]{"\u000b", ""}, new String[]{"\f", ""}, new String[]{"\u000e", ""}, new String[]{"\u000f", ""}, new String[]{"\u0010", ""}, new String[]{"\u0011", ""}, new String[]{"\u0012", ""}, new String[]{"\u0013", ""}, new String[]{"\u0014", ""}, new String[]{"\u0015", ""}, new String[]{"\u0016", ""}, new String[]{"\u0017", ""}, new String[]{"\u0018", ""}, new String[]{"\u0019", ""}, new String[]{"\u001a", ""}, new String[]{"\u001b", ""}, new String[]{"\u001c", ""}, new String[]{"\u001d", ""}, new String[]{"\u001e", ""}, new String[]{"\u001f", ""}, new String[]{"￾", ""}, new String[]{"￿", ""}), NumericEntityEscaper.g(127, Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE), NumericEntityEscaper.g(Sdk$SDKError.Reason.STORE_REGION_CODE_ERROR_VALUE, 159), new UnicodeUnpairedSurrogateRemover());

    /* renamed from: f  reason: collision with root package name */
    public static final CharSequenceTranslator f41420f = new AggregateTranslator(new LookupTranslator(EntityArrays.c()), new LookupTranslator(EntityArrays.a()), new LookupTranslator(new String[]{"\u0000", ""}, new String[]{"\u000b", "&#11;"}, new String[]{"\f", "&#12;"}, new String[]{"￾", ""}, new String[]{"￿", ""}), NumericEntityEscaper.g(1, 8), NumericEntityEscaper.g(14, 31), NumericEntityEscaper.g(127, Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE), NumericEntityEscaper.g(Sdk$SDKError.Reason.STORE_REGION_CODE_ERROR_VALUE, 159), new UnicodeUnpairedSurrogateRemover());

    /* renamed from: g  reason: collision with root package name */
    public static final CharSequenceTranslator f41421g = new AggregateTranslator(new LookupTranslator(EntityArrays.c()), new LookupTranslator(EntityArrays.g()));

    /* renamed from: h  reason: collision with root package name */
    public static final CharSequenceTranslator f41422h = new AggregateTranslator(new LookupTranslator(EntityArrays.c()), new LookupTranslator(EntityArrays.g()), new LookupTranslator(EntityArrays.e()));

    /* renamed from: i  reason: collision with root package name */
    public static final CharSequenceTranslator f41423i = new CsvEscaper();

    /* renamed from: j  reason: collision with root package name */
    public static final CharSequenceTranslator f41424j;

    /* renamed from: k  reason: collision with root package name */
    public static final CharSequenceTranslator f41425k;

    /* renamed from: l  reason: collision with root package name */
    public static final CharSequenceTranslator f41426l;

    /* renamed from: m  reason: collision with root package name */
    public static final CharSequenceTranslator f41427m = new AggregateTranslator(new LookupTranslator(EntityArrays.d()), new LookupTranslator(EntityArrays.h()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));

    /* renamed from: n  reason: collision with root package name */
    public static final CharSequenceTranslator f41428n = new AggregateTranslator(new LookupTranslator(EntityArrays.d()), new LookupTranslator(EntityArrays.h()), new LookupTranslator(EntityArrays.f()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));

    /* renamed from: o  reason: collision with root package name */
    public static final CharSequenceTranslator f41429o = new AggregateTranslator(new LookupTranslator(EntityArrays.d()), new LookupTranslator(EntityArrays.b()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));

    /* renamed from: p  reason: collision with root package name */
    public static final CharSequenceTranslator f41430p = new CsvUnescaper();

    static class CsvEscaper extends CharSequenceTranslator {

        /* renamed from: b  reason: collision with root package name */
        private static final String f41431b = String.valueOf('\"');

        /* renamed from: c  reason: collision with root package name */
        private static final char[] f41432c = {',', '\"', 13, 10};

        CsvEscaper() {
        }

        public int b(CharSequence charSequence, int i2, Writer writer) throws IOException {
            if (i2 == 0) {
                if (StringUtils.c(charSequence.toString(), f41432c)) {
                    writer.write(charSequence.toString());
                } else {
                    writer.write(34);
                    String charSequence2 = charSequence.toString();
                    String str = f41431b;
                    writer.write(StringUtils.h(charSequence2, str, str + str));
                    writer.write(34);
                }
                return Character.codePointCount(charSequence, 0, charSequence.length());
            }
            throw new IllegalStateException("CsvEscaper should never reach the [1] index");
        }
    }

    static class CsvUnescaper extends CharSequenceTranslator {

        /* renamed from: b  reason: collision with root package name */
        private static final String f41433b = String.valueOf('\"');

        /* renamed from: c  reason: collision with root package name */
        private static final char[] f41434c = {',', '\"', 13, 10};

        CsvUnescaper() {
        }

        public int b(CharSequence charSequence, int i2, Writer writer) throws IOException {
            if (i2 != 0) {
                throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
            } else if (charSequence.charAt(0) == '\"' && charSequence.charAt(charSequence.length() - 1) == '\"') {
                String charSequence2 = charSequence.subSequence(1, charSequence.length() - 1).toString();
                if (StringUtils.b(charSequence2, f41434c)) {
                    StringBuilder sb = new StringBuilder();
                    String str = f41433b;
                    sb.append(str);
                    sb.append(str);
                    writer.write(StringUtils.h(charSequence2, sb.toString(), str));
                } else {
                    writer.write(charSequence.toString());
                }
                return Character.codePointCount(charSequence, 0, charSequence.length());
            } else {
                writer.write(charSequence.toString());
                return Character.codePointCount(charSequence, 0, charSequence.length());
            }
        }
    }

    static {
        AggregateTranslator aggregateTranslator = new AggregateTranslator(new OctalUnescaper(), new UnicodeUnescaper(), new LookupTranslator(EntityArrays.j()), new LookupTranslator(new String[]{"\\\\", "\\"}, new String[]{"\\\"", "\""}, new String[]{"\\'", "'"}, new String[]{"\\", ""}));
        f41424j = aggregateTranslator;
        f41425k = aggregateTranslator;
        f41426l = aggregateTranslator;
    }

    public static final String a(String str) {
        return f41424j.c(str);
    }
}
