package androidx.media3.extractor.text.ttml;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.HorizontalTextInVerticalContextSpan;
import androidx.media3.common.text.RubySpan;
import androidx.media3.common.text.SpanUtil;
import androidx.media3.common.text.TextEmphasisSpan;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import java.util.ArrayDeque;
import java.util.Map;

final class TtmlRenderUtil {
    private TtmlRenderUtil() {
    }

    public static void a(Spannable spannable, int i2, int i3, TtmlStyle ttmlStyle, TtmlNode ttmlNode, Map<String, TtmlStyle> map, int i4) {
        TtmlNode e2;
        int i5;
        TtmlStyle f2;
        int i6;
        if (ttmlStyle.l() != -1) {
            spannable.setSpan(new StyleSpan(ttmlStyle.l()), i2, i3, 33);
        }
        if (ttmlStyle.s()) {
            spannable.setSpan(new StrikethroughSpan(), i2, i3, 33);
        }
        if (ttmlStyle.t()) {
            spannable.setSpan(new UnderlineSpan(), i2, i3, 33);
        }
        if (ttmlStyle.q()) {
            SpanUtil.b(spannable, new ForegroundColorSpan(ttmlStyle.c()), i2, i3, 33);
        }
        if (ttmlStyle.p()) {
            SpanUtil.b(spannable, new BackgroundColorSpan(ttmlStyle.b()), i2, i3, 33);
        }
        if (ttmlStyle.d() != null) {
            SpanUtil.b(spannable, new TypefaceSpan(ttmlStyle.d()), i2, i3, 33);
        }
        if (ttmlStyle.o() != null) {
            TextEmphasis textEmphasis = (TextEmphasis) Assertions.f(ttmlStyle.o());
            int i7 = textEmphasis.f9025a;
            if (i7 == -1) {
                if (i4 == 2 || i4 == 1) {
                    i7 = 3;
                } else {
                    i7 = 1;
                }
                i6 = 1;
            } else {
                i6 = textEmphasis.f9026b;
            }
            int i8 = textEmphasis.f9027c;
            if (i8 == -2) {
                i8 = 1;
            }
            SpanUtil.b(spannable, new TextEmphasisSpan(i7, i6, i8), i2, i3, 33);
        }
        int j2 = ttmlStyle.j();
        if (j2 == 2) {
            TtmlNode d2 = d(ttmlNode, map);
            if (!(d2 == null || (e2 = e(d2, map)) == null)) {
                if (e2.g() != 1 || e2.f(0).f9029b == null) {
                    Log.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) Util.i(e2.f(0).f9029b);
                    TtmlStyle f3 = f(e2.f9033f, e2.l(), map);
                    if (f3 != null) {
                        i5 = f3.i();
                    } else {
                        i5 = -1;
                    }
                    if (i5 == -1 && (f2 = f(d2.f9033f, d2.l(), map)) != null) {
                        i5 = f2.i();
                    }
                    spannable.setSpan(new RubySpan(str, i5), i2, i3, 33);
                }
            }
        } else if (j2 == 3 || j2 == 4) {
            spannable.setSpan(new DeleteTextSpan(), i2, i3, 33);
        }
        if (ttmlStyle.n()) {
            SpanUtil.b(spannable, new HorizontalTextInVerticalContextSpan(), i2, i3, 33);
        }
        int f4 = ttmlStyle.f();
        if (f4 == 1) {
            SpanUtil.b(spannable, new AbsoluteSizeSpan((int) ttmlStyle.e(), true), i2, i3, 33);
        } else if (f4 == 2) {
            SpanUtil.b(spannable, new RelativeSizeSpan(ttmlStyle.e()), i2, i3, 33);
        } else if (f4 == 3) {
            SpanUtil.a(spannable, ttmlStyle.e() / 100.0f, i2, i3, 33);
        }
    }

    static String b(String str) {
        return str.replaceAll("\r\n", ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE).replaceAll(" *\n *", ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE).replaceAll(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != 10) {
            spannableStringBuilder.append(10);
        }
    }

    private static TtmlNode d(TtmlNode ttmlNode, Map<String, TtmlStyle> map) {
        while (ttmlNode != null) {
            TtmlStyle f2 = f(ttmlNode.f9033f, ttmlNode.l(), map);
            if (f2 != null && f2.j() == 1) {
                return ttmlNode;
            }
            ttmlNode = ttmlNode.f9037j;
        }
        return null;
    }

    private static TtmlNode e(TtmlNode ttmlNode, Map<String, TtmlStyle> map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(ttmlNode);
        while (!arrayDeque.isEmpty()) {
            TtmlNode ttmlNode2 = (TtmlNode) arrayDeque.pop();
            TtmlStyle f2 = f(ttmlNode2.f9033f, ttmlNode2.l(), map);
            if (f2 != null && f2.j() == 3) {
                return ttmlNode2;
            }
            for (int g2 = ttmlNode2.g() - 1; g2 >= 0; g2--) {
                arrayDeque.push(ttmlNode2.f(g2));
            }
        }
        return null;
    }

    public static TtmlStyle f(TtmlStyle ttmlStyle, String[] strArr, Map<String, TtmlStyle> map) {
        int i2 = 0;
        if (ttmlStyle == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                TtmlStyle ttmlStyle2 = new TtmlStyle();
                int length = strArr.length;
                while (i2 < length) {
                    ttmlStyle2.a(map.get(strArr[i2]));
                    i2++;
                }
                return ttmlStyle2;
            }
        } else if (strArr != null && strArr.length == 1) {
            return ttmlStyle.a(map.get(strArr[0]));
        } else {
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i2 < length2) {
                    ttmlStyle.a(map.get(strArr[i2]));
                    i2++;
                }
            }
        }
        return ttmlStyle;
    }
}
