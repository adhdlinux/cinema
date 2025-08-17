package androidx.media3.extractor.text.webvtt;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.HorizontalTextInVerticalContextSpan;
import androidx.media3.common.text.RubySpan;
import androidx.media3.common.text.SpanUtil;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttCueParser {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f9121a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f9122b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, Integer> f9123c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, Integer> f9124d;

    private static class Element {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final Comparator<Element> f9125c = new a();
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final StartTag f9126a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f9127b;

        private Element(StartTag startTag, int i2) {
            this.f9126a = startTag;
            this.f9127b = i2;
        }
    }

    private static final class StartTag {

        /* renamed from: a  reason: collision with root package name */
        public final String f9128a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9129b;

        /* renamed from: c  reason: collision with root package name */
        public final String f9130c;

        /* renamed from: d  reason: collision with root package name */
        public final Set<String> f9131d;

        private StartTag(String str, int i2, String str2, Set<String> set) {
            this.f9129b = i2;
            this.f9128a = str;
            this.f9130c = str2;
            this.f9131d = set;
        }

        public static StartTag a(String str, int i2) {
            String str2;
            String trim = str.trim();
            Assertions.a(!trim.isEmpty());
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] k12 = Util.k1(trim, "\\.");
            String str3 = k12[0];
            HashSet hashSet = new HashSet();
            for (int i3 = 1; i3 < k12.length; i3++) {
                hashSet.add(k12[i3]);
            }
            return new StartTag(str3, i2, str2, hashSet);
        }

        public static StartTag b() {
            return new StartTag("", 0, "", Collections.emptySet());
        }
    }

    private static final class StyleMatch implements Comparable<StyleMatch> {

        /* renamed from: b  reason: collision with root package name */
        public final int f9132b;

        /* renamed from: c  reason: collision with root package name */
        public final WebvttCssStyle f9133c;

        public StyleMatch(int i2, WebvttCssStyle webvttCssStyle) {
            this.f9132b = i2;
            this.f9133c = webvttCssStyle;
        }

        /* renamed from: a */
        public int compareTo(StyleMatch styleMatch) {
            return Integer.compare(this.f9132b, styleMatch.f9132b);
        }
    }

    private static final class WebvttCueInfoBuilder {

        /* renamed from: a  reason: collision with root package name */
        public long f9134a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f9135b = 0;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f9136c;

        /* renamed from: d  reason: collision with root package name */
        public int f9137d = 2;

        /* renamed from: e  reason: collision with root package name */
        public float f9138e = -3.4028235E38f;

        /* renamed from: f  reason: collision with root package name */
        public int f9139f = 1;

        /* renamed from: g  reason: collision with root package name */
        public int f9140g = 0;

        /* renamed from: h  reason: collision with root package name */
        public float f9141h = -3.4028235E38f;

        /* renamed from: i  reason: collision with root package name */
        public int f9142i = Integer.MIN_VALUE;

        /* renamed from: j  reason: collision with root package name */
        public float f9143j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public int f9144k = Integer.MIN_VALUE;

        private static float b(float f2, int i2) {
            int i3 = (f2 > -3.4028235E38f ? 1 : (f2 == -3.4028235E38f ? 0 : -1));
            if (i3 == 0 || i2 != 0 || (f2 >= 0.0f && f2 <= 1.0f)) {
                return i3 != 0 ? f2 : i2 == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        private static Layout.Alignment c(int i2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            Log.h("WebvttCueParser", "Unknown textAlignment: " + i2);
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        private static float d(int i2, float f2) {
            if (i2 == 0) {
                return 1.0f - f2;
            }
            if (i2 == 1) {
                return f2 <= 0.5f ? f2 * 2.0f : (1.0f - f2) * 2.0f;
            }
            if (i2 == 2) {
                return f2;
            }
            throw new IllegalStateException(String.valueOf(i2));
        }

        private static float e(int i2) {
            if (i2 != 4) {
                return i2 != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        private static int f(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 3) {
                return 2;
            }
            if (i2 != 4) {
                return i2 != 5 ? 1 : 2;
            }
            return 0;
        }

        public WebvttCueInfo a() {
            return new WebvttCueInfo(g().a(), this.f9134a, this.f9135b);
        }

        public Cue.Builder g() {
            float f2 = this.f9141h;
            if (f2 == -3.4028235E38f) {
                f2 = e(this.f9137d);
            }
            int i2 = this.f9142i;
            if (i2 == Integer.MIN_VALUE) {
                i2 = f(this.f9137d);
            }
            Cue.Builder r2 = new Cue.Builder().p(c(this.f9137d)).h(b(this.f9138e, this.f9139f), this.f9139f).i(this.f9140g).k(f2).l(i2).n(Math.min(this.f9143j, d(i2, f2))).r(this.f9144k);
            CharSequence charSequence = this.f9136c;
            if (charSequence != null) {
                r2.o(charSequence);
            }
            return r2;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, JfifUtil.MARKER_FIRST_BYTE, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE)));
        hashMap.put("red", Integer.valueOf(Color.rgb(JfifUtil.MARKER_FIRST_BYTE, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(JfifUtil.MARKER_FIRST_BYTE, 0, JfifUtil.MARKER_FIRST_BYTE)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, JfifUtil.MARKER_FIRST_BYTE)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f9123c = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, JfifUtil.MARKER_FIRST_BYTE, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(JfifUtil.MARKER_FIRST_BYTE, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(JfifUtil.MARKER_FIRST_BYTE, 0, JfifUtil.MARKER_FIRST_BYTE)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, JfifUtil.MARKER_FIRST_BYTE)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f9124d = Collections.unmodifiableMap(hashMap2);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, Set<String> set, int i2, int i3) {
        for (String next : set) {
            Map<String, Integer> map = f9123c;
            if (map.containsKey(next)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(map.get(next).intValue()), i2, i3, 33);
            } else {
                Map<String, Integer> map2 = f9124d;
                if (map2.containsKey(next)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(map2.get(next).intValue()), i2, i3, 33);
                }
            }
        }
    }

    private static void b(String str, SpannableStringBuilder spannableStringBuilder) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals("gt")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3464:
                if (str.equals("lt")) {
                    c2 = 1;
                    break;
                }
                break;
            case 96708:
                if (str.equals("amp")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3374865:
                if (str.equals("nbsp")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                spannableStringBuilder.append('>');
                return;
            case 1:
                spannableStringBuilder.append('<');
                return;
            case 2:
                spannableStringBuilder.append('&');
                return;
            case 3:
                spannableStringBuilder.append(' ');
                return;
            default:
                Log.h("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
    }

    private static void c(SpannableStringBuilder spannableStringBuilder, String str, StartTag startTag, List<Element> list, List<WebvttCssStyle> list2) {
        int i2 = i(list2, str, startTag);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, Element.f9125c);
        int i3 = startTag.f9129b;
        int i4 = 0;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            if ("rt".equals(((Element) arrayList.get(i5)).f9126a.f9128a)) {
                Element element = (Element) arrayList.get(i5);
                int g2 = g(i(list2, str, element.f9126a), i2, 1);
                int i6 = element.f9126a.f9129b - i4;
                int d2 = element.f9127b - i4;
                CharSequence subSequence = spannableStringBuilder.subSequence(i6, d2);
                spannableStringBuilder.delete(i6, d2);
                spannableStringBuilder.setSpan(new RubySpan(subSequence.toString(), g2), i3, i6, 33);
                i4 += subSequence.length();
                i3 = i6;
            }
        }
    }

    private static void d(String str, StartTag startTag, List<Element> list, SpannableStringBuilder spannableStringBuilder, List<WebvttCssStyle> list2) {
        int i2 = startTag.f9129b;
        int length = spannableStringBuilder.length();
        String str2 = startTag.f9128a;
        str2.hashCode();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    c2 = 0;
                    break;
                }
                break;
            case 98:
                if (str2.equals("b")) {
                    c2 = 1;
                    break;
                }
                break;
            case 99:
                if (str2.equals("c")) {
                    c2 = 2;
                    break;
                }
                break;
            case 105:
                if (str2.equals(ContextChain.TAG_INFRA)) {
                    c2 = 3;
                    break;
                }
                break;
            case 117:
                if (str2.equals("u")) {
                    c2 = 4;
                    break;
                }
                break;
            case 118:
                if (str2.equals("v")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    c2 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str2.equals("ruby")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 5:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i2, length, 33);
                break;
            case 2:
                a(spannableStringBuilder, startTag.f9131d, i2, length);
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i2, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
                break;
            case 7:
                c(spannableStringBuilder, str, startTag, list, list2);
                break;
            default:
                return;
        }
        List<StyleMatch> h2 = h(list2, str, startTag);
        for (int i3 = 0; i3 < h2.size(); i3++) {
            e(spannableStringBuilder, h2.get(i3).f9133c, i2, length);
        }
    }

    private static void e(SpannableStringBuilder spannableStringBuilder, WebvttCssStyle webvttCssStyle, int i2, int i3) {
        if (webvttCssStyle != null) {
            if (webvttCssStyle.i() != -1) {
                SpanUtil.b(spannableStringBuilder, new StyleSpan(webvttCssStyle.i()), i2, i3, 33);
            }
            if (webvttCssStyle.l()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, i3, 33);
            }
            if (webvttCssStyle.m()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
            }
            if (webvttCssStyle.k()) {
                SpanUtil.b(spannableStringBuilder, new ForegroundColorSpan(webvttCssStyle.c()), i2, i3, 33);
            }
            if (webvttCssStyle.j()) {
                SpanUtil.b(spannableStringBuilder, new BackgroundColorSpan(webvttCssStyle.a()), i2, i3, 33);
            }
            if (webvttCssStyle.d() != null) {
                SpanUtil.b(spannableStringBuilder, new TypefaceSpan(webvttCssStyle.d()), i2, i3, 33);
            }
            int f2 = webvttCssStyle.f();
            if (f2 == 1) {
                SpanUtil.b(spannableStringBuilder, new AbsoluteSizeSpan((int) webvttCssStyle.e(), true), i2, i3, 33);
            } else if (f2 == 2) {
                SpanUtil.b(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.e()), i2, i3, 33);
            } else if (f2 == 3) {
                SpanUtil.b(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.e() / 100.0f), i2, i3, 33);
            }
            if (webvttCssStyle.b()) {
                spannableStringBuilder.setSpan(new HorizontalTextInVerticalContextSpan(), i2, i3, 33);
            }
        }
    }

    private static int f(String str, int i2) {
        int indexOf = str.indexOf(62, i2);
        if (indexOf == -1) {
            return str.length();
        }
        return indexOf + 1;
    }

    private static int g(int i2, int i3, int i4) {
        if (i2 != -1) {
            return i2;
        }
        if (i3 != -1) {
            return i3;
        }
        if (i4 != -1) {
            return i4;
        }
        throw new IllegalArgumentException();
    }

    private static List<StyleMatch> h(List<WebvttCssStyle> list, String str, StartTag startTag) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            WebvttCssStyle webvttCssStyle = list.get(i2);
            int h2 = webvttCssStyle.h(str, startTag.f9128a, startTag.f9131d, startTag.f9130c);
            if (h2 > 0) {
                arrayList.add(new StyleMatch(h2, webvttCssStyle));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static int i(List<WebvttCssStyle> list, String str, StartTag startTag) {
        List<StyleMatch> h2 = h(list, str, startTag);
        for (int i2 = 0; i2 < h2.size(); i2++) {
            WebvttCssStyle webvttCssStyle = h2.get(i2).f9133c;
            if (webvttCssStyle.g() != -1) {
                return webvttCssStyle.g();
            }
        }
        return -1;
    }

    private static String j(String str) {
        String trim = str.trim();
        Assertions.a(!trim.isEmpty());
        return Util.l1(trim, "[ \\.]")[0];
    }

    private static boolean k(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 98:
                if (str.equals("b")) {
                    c2 = 0;
                    break;
                }
                break;
            case 99:
                if (str.equals("c")) {
                    c2 = 1;
                    break;
                }
                break;
            case 105:
                if (str.equals(ContextChain.TAG_INFRA)) {
                    c2 = 2;
                    break;
                }
                break;
            case 117:
                if (str.equals("u")) {
                    c2 = 3;
                    break;
                }
                break;
            case 118:
                if (str.equals("v")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3650:
                if (str.equals("rt")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str.equals("lang")) {
                    c2 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str.equals("ruby")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    public static Cue l(CharSequence charSequence) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        webvttCueInfoBuilder.f9136c = charSequence;
        return webvttCueInfoBuilder.g().a();
    }

    public static WebvttCueInfo m(ParsableByteArray parsableByteArray, List<WebvttCssStyle> list) {
        String s2 = parsableByteArray.s();
        if (s2 == null) {
            return null;
        }
        Pattern pattern = f9121a;
        Matcher matcher = pattern.matcher(s2);
        if (matcher.matches()) {
            return n((String) null, matcher, parsableByteArray, list);
        }
        String s3 = parsableByteArray.s();
        if (s3 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(s3);
        if (matcher2.matches()) {
            return n(s2.trim(), matcher2, parsableByteArray, list);
        }
        return null;
    }

    private static WebvttCueInfo n(String str, Matcher matcher, ParsableByteArray parsableByteArray, List<WebvttCssStyle> list) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        try {
            webvttCueInfoBuilder.f9134a = WebvttParserUtil.d((String) Assertions.f(matcher.group(1)));
            webvttCueInfoBuilder.f9135b = WebvttParserUtil.d((String) Assertions.f(matcher.group(2)));
            p((String) Assertions.f(matcher.group(3)), webvttCueInfoBuilder);
            StringBuilder sb = new StringBuilder();
            String s2 = parsableByteArray.s();
            while (!TextUtils.isEmpty(s2)) {
                if (sb.length() > 0) {
                    sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                }
                sb.append(s2.trim());
                s2 = parsableByteArray.s();
            }
            webvttCueInfoBuilder.f9136c = q(str, sb.toString(), list);
            return webvttCueInfoBuilder.a();
        } catch (NumberFormatException unused) {
            Log.h("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    static Cue.Builder o(String str) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        p(str, webvttCueInfoBuilder);
        return webvttCueInfoBuilder.g();
    }

    private static void p(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        Matcher matcher = f9122b.matcher(str);
        while (matcher.find()) {
            String str2 = (String) Assertions.f(matcher.group(1));
            String str3 = (String) Assertions.f(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    s(str3, webvttCueInfoBuilder);
                } else if ("align".equals(str2)) {
                    webvttCueInfoBuilder.f9137d = v(str3);
                } else if (ViewProps.POSITION.equals(str2)) {
                    u(str3, webvttCueInfoBuilder);
                } else if ("size".equals(str2)) {
                    webvttCueInfoBuilder.f9143j = WebvttParserUtil.c(str3);
                } else if ("vertical".equals(str2)) {
                    webvttCueInfoBuilder.f9144k = w(str3);
                } else {
                    Log.h("WebvttCueParser", "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                Log.h("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    static SpannedString q(String str, String str2, List<WebvttCssStyle> list) {
        boolean z2;
        boolean z3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < str2.length()) {
            char charAt = str2.charAt(i2);
            if (charAt == '&') {
                i2++;
                int indexOf = str2.indexOf(59, i2);
                int indexOf2 = str2.indexOf(32, i2);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    b(str2.substring(i2, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i2 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i2++;
            } else {
                int i3 = i2 + 1;
                if (i3 < str2.length()) {
                    int i4 = 1;
                    if (str2.charAt(i3) == '/') {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    i3 = f(str2, i3);
                    int i5 = i3 - 2;
                    if (str2.charAt(i5) == '/') {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2) {
                        i4 = 2;
                    }
                    int i6 = i2 + i4;
                    if (!z3) {
                        i5 = i3 - 1;
                    }
                    String substring = str2.substring(i6, i5);
                    if (!substring.trim().isEmpty()) {
                        String j2 = j(substring);
                        if (k(j2)) {
                            if (z2) {
                                while (!arrayDeque.isEmpty()) {
                                    StartTag startTag = (StartTag) arrayDeque.pop();
                                    d(str, startTag, arrayList, spannableStringBuilder, list);
                                    if (!arrayDeque.isEmpty()) {
                                        arrayList.add(new Element(startTag, spannableStringBuilder.length()));
                                    } else {
                                        arrayList.clear();
                                    }
                                    if (startTag.f9128a.equals(j2)) {
                                        break;
                                    }
                                }
                            } else if (!z3) {
                                arrayDeque.push(StartTag.a(substring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i2 = i3;
            }
        }
        while (!arrayDeque.isEmpty()) {
            d(str, (StartTag) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        d(str, StartTag.b(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    private static int r(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals(ViewProps.END)) {
                    c2 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals(ViewProps.START)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 0;
            default:
                Log.h("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void s(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            webvttCueInfoBuilder.f9140g = r(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            webvttCueInfoBuilder.f9138e = WebvttParserUtil.c(str);
            webvttCueInfoBuilder.f9139f = 0;
            return;
        }
        webvttCueInfoBuilder.f9138e = (float) Integer.parseInt(str);
        webvttCueInfoBuilder.f9139f = 1;
    }

    private static int t(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1842484672:
                if (str.equals("line-left")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1276788989:
                if (str.equals("line-right")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals(ViewProps.END)) {
                    c2 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals(ViewProps.START)) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 5:
                return 0;
            case 1:
            case 3:
                return 1;
            case 2:
            case 4:
                return 2;
            default:
                Log.h("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void u(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            webvttCueInfoBuilder.f9142i = t(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        webvttCueInfoBuilder.f9141h = WebvttParserUtil.c(str);
    }

    private static int v(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals(ViewProps.END)) {
                    c2 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str.equals(ViewProps.LEFT)) {
                    c2 = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(ViewProps.RIGHT)) {
                    c2 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals(ViewProps.START)) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 1;
            default:
                Log.h("WebvttCueParser", "Invalid alignment value: " + str);
                return 2;
        }
    }

    private static int w(String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        Log.h("WebvttCueParser", "Invalid 'vertical' value: " + str);
        return Integer.MIN_VALUE;
    }
}
