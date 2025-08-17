package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.text.span.TextEmphasisSpan;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

final class SpannedToHtmlConverter {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f28077a = Pattern.compile("(&#13;)?&#10;");

    public static class HtmlAndCss {

        /* renamed from: a  reason: collision with root package name */
        public final String f28078a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, String> f28079b;

        private HtmlAndCss(String str, Map<String, String> map) {
            this.f28078a = str;
            this.f28079b = map;
        }
    }

    private static final class SpanInfo {
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public static final Comparator<SpanInfo> f28080e = new a();
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static final Comparator<SpanInfo> f28081f = new b();

        /* renamed from: a  reason: collision with root package name */
        public final int f28082a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28083b;

        /* renamed from: c  reason: collision with root package name */
        public final String f28084c;

        /* renamed from: d  reason: collision with root package name */
        public final String f28085d;

        /* access modifiers changed from: private */
        public static /* synthetic */ int e(SpanInfo spanInfo, SpanInfo spanInfo2) {
            int compare = Integer.compare(spanInfo2.f28083b, spanInfo.f28083b);
            if (compare != 0) {
                return compare;
            }
            int compareTo = spanInfo.f28084c.compareTo(spanInfo2.f28084c);
            if (compareTo != 0) {
                return compareTo;
            }
            return spanInfo.f28085d.compareTo(spanInfo2.f28085d);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ int f(SpanInfo spanInfo, SpanInfo spanInfo2) {
            int compare = Integer.compare(spanInfo2.f28082a, spanInfo.f28082a);
            if (compare != 0) {
                return compare;
            }
            int compareTo = spanInfo2.f28084c.compareTo(spanInfo.f28084c);
            if (compareTo != 0) {
                return compareTo;
            }
            return spanInfo2.f28085d.compareTo(spanInfo.f28085d);
        }

        private SpanInfo(int i2, int i3, String str, String str2) {
            this.f28082a = i2;
            this.f28083b = i3;
            this.f28084c = str;
            this.f28085d = str2;
        }
    }

    private static final class Transition {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<SpanInfo> f28086a = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final List<SpanInfo> f28087b = new ArrayList();
    }

    private SpannedToHtmlConverter() {
    }

    public static HtmlAndCss a(CharSequence charSequence, float f2) {
        if (charSequence == null) {
            return new HtmlAndCss("", ImmutableMap.k());
        }
        if (!(charSequence instanceof Spanned)) {
            return new HtmlAndCss(b(charSequence), ImmutableMap.k());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet<Integer> hashSet = new HashSet<>();
        int i2 = 0;
        for (BackgroundColorSpan backgroundColor : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColor.getBackgroundColor()));
        }
        HashMap hashMap = new HashMap();
        for (Integer intValue : hashSet) {
            int intValue2 = intValue.intValue();
            hashMap.put(HtmlUtils.a("bg_" + intValue2), Util.C("background-color:%s;", HtmlUtils.b(intValue2)));
        }
        SparseArray<Transition> c2 = c(spanned, f2);
        StringBuilder sb = new StringBuilder(spanned.length());
        int i3 = 0;
        while (i2 < c2.size()) {
            int keyAt = c2.keyAt(i2);
            sb.append(b(spanned.subSequence(i3, keyAt)));
            Transition transition = c2.get(keyAt);
            Collections.sort(transition.f28087b, SpanInfo.f28081f);
            for (SpanInfo spanInfo : transition.f28087b) {
                sb.append(spanInfo.f28085d);
            }
            Collections.sort(transition.f28086a, SpanInfo.f28080e);
            for (SpanInfo spanInfo2 : transition.f28086a) {
                sb.append(spanInfo2.f28084c);
            }
            i2++;
            i3 = keyAt;
        }
        sb.append(b(spanned.subSequence(i3, spanned.length())));
        return new HtmlAndCss(sb.toString(), hashMap);
    }

    private static String b(CharSequence charSequence) {
        return f28077a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    private static SparseArray<Transition> c(Spanned spanned, float f2) {
        SparseArray<Transition> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String e2 = e(obj, f2);
            String d2 = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (e2 != null) {
                Assertions.e(d2);
                SpanInfo spanInfo = new SpanInfo(spanStart, spanEnd, e2, d2);
                f(sparseArray, spanStart).f28086a.add(spanInfo);
                f(sparseArray, spanEnd).f28087b.add(spanInfo);
            }
        }
        return sparseArray;
    }

    private static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof HorizontalTextInVerticalContextSpan) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof TextEmphasisSpan)) {
            return "</span>";
        }
        if (!(obj instanceof TypefaceSpan)) {
            if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style == 1) {
                    return "</b>";
                }
                if (style == 2) {
                    return "</i>";
                }
                if (style != 3) {
                    return null;
                }
                return "</i></b>";
            } else if (obj instanceof RubySpan) {
                return "<rt>" + b(((RubySpan) obj).f27436a) + "</rt></ruby>";
            } else if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
            return null;
        } else if (((TypefaceSpan) obj).getFamily() != null) {
            return "</span>";
        } else {
            return null;
        }
    }

    private static String e(Object obj, float f2) {
        float f3;
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return Util.C("<span style='color:%s;'>", HtmlUtils.b(((ForegroundColorSpan) obj).getForegroundColor()));
        } else if (obj instanceof BackgroundColorSpan) {
            return Util.C("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        } else if (obj instanceof HorizontalTextInVerticalContextSpan) {
            return "<span style='text-combine-upright:all;'>";
        } else {
            if (obj instanceof AbsoluteSizeSpan) {
                AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
                if (absoluteSizeSpan.getDip()) {
                    f3 = (float) absoluteSizeSpan.getSize();
                } else {
                    f3 = ((float) absoluteSizeSpan.getSize()) / f2;
                }
                return Util.C("<span style='font-size:%.2fpx;'>", Float.valueOf(f3));
            } else if (obj instanceof RelativeSizeSpan) {
                return Util.C("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
            } else if (obj instanceof TypefaceSpan) {
                String family = ((TypefaceSpan) obj).getFamily();
                if (family == null) {
                    return null;
                }
                return Util.C("<span style='font-family:\"%s\";'>", family);
            } else if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style == 1) {
                    return "<b>";
                }
                if (style == 2) {
                    return "<i>";
                }
                if (style != 3) {
                    return null;
                }
                return "<b><i>";
            } else if (obj instanceof RubySpan) {
                int i2 = ((RubySpan) obj).f27437b;
                if (i2 == -1) {
                    return "<ruby style='ruby-position:unset;'>";
                }
                if (i2 == 1) {
                    return "<ruby style='ruby-position:over;'>";
                }
                if (i2 != 2) {
                    return null;
                }
                return "<ruby style='ruby-position:under;'>";
            } else if (obj instanceof UnderlineSpan) {
                return "<u>";
            } else {
                if (!(obj instanceof TextEmphasisSpan)) {
                    return null;
                }
                TextEmphasisSpan textEmphasisSpan = (TextEmphasisSpan) obj;
                return Util.C("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(textEmphasisSpan.f27438a, textEmphasisSpan.f27439b), g(textEmphasisSpan.f27440c));
            }
        }
    }

    private static Transition f(SparseArray<Transition> sparseArray, int i2) {
        Transition transition = sparseArray.get(i2);
        if (transition != null) {
            return transition;
        }
        Transition transition2 = new Transition();
        sparseArray.put(i2, transition2);
        return transition2;
    }

    private static String g(int i2) {
        return i2 != 2 ? "over right" : "under left";
    }

    private static String h(int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        if (i3 == 1) {
            sb.append("filled ");
        } else if (i3 == 2) {
            sb.append("open ");
        }
        if (i2 == 0) {
            sb.append("none");
        } else if (i2 == 1) {
            sb.append("circle");
        } else if (i2 == 2) {
            sb.append("dot");
        } else if (i2 != 3) {
            sb.append("unset");
        } else {
            sb.append("sesame");
        }
        return sb.toString();
    }
}
