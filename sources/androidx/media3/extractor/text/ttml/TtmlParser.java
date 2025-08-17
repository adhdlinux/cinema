package androidx.media3.extractor.text.ttml;

import android.text.Layout;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.XmlPullParserUtil;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.LegacySubtitleUtil;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.f;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class TtmlParser implements SubtitleParser {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f9041b = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f9042c = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f9043d = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: e  reason: collision with root package name */
    static final Pattern f9044e = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: f  reason: collision with root package name */
    static final Pattern f9045f = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f9046g = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f9047h = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: i  reason: collision with root package name */
    private static final FrameAndTickRate f9048i = new FrameAndTickRate(30.0f, 1, 1);

    /* renamed from: a  reason: collision with root package name */
    private final XmlPullParserFactory f9049a;

    private static final class FrameAndTickRate {

        /* renamed from: a  reason: collision with root package name */
        final float f9050a;

        /* renamed from: b  reason: collision with root package name */
        final int f9051b;

        /* renamed from: c  reason: collision with root package name */
        final int f9052c;

        FrameAndTickRate(float f2, int i2, int i3) {
            this.f9050a = f2;
            this.f9051b = i2;
            this.f9052c = i3;
        }
    }

    private static final class TtsExtent {

        /* renamed from: a  reason: collision with root package name */
        final int f9053a;

        /* renamed from: b  reason: collision with root package name */
        final int f9054b;

        TtsExtent(int i2, int i3) {
            this.f9053a = i2;
            this.f9054b = i3;
        }
    }

    public TtmlParser() {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f9049a = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    private static TtmlStyle d(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    private static boolean e(String str) {
        if (str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals(ContextChain.TAG_PRODUCT) || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information")) {
            return true;
        }
        return false;
    }

    private static Layout.Alignment f(String str) {
        String e2 = Ascii.e(str);
        e2.hashCode();
        char c2 = 65535;
        switch (e2.hashCode()) {
            case -1364013995:
                if (e2.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case 100571:
                if (e2.equals(ViewProps.END)) {
                    c2 = 1;
                    break;
                }
                break;
            case 3317767:
                if (e2.equals(ViewProps.LEFT)) {
                    c2 = 2;
                    break;
                }
                break;
            case 108511772:
                if (e2.equals(ViewProps.RIGHT)) {
                    c2 = 3;
                    break;
                }
                break;
            case 109757538:
                if (e2.equals(ViewProps.START)) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return Layout.Alignment.ALIGN_CENTER;
            case 1:
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 2:
            case 4:
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    private static int g(XmlPullParser xmlPullParser, int i2) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return i2;
        }
        Matcher matcher = f9047h.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.h("TtmlParser", "Ignoring malformed cell resolution: " + attributeValue);
            return i2;
        }
        boolean z2 = true;
        try {
            int parseInt = Integer.parseInt((String) Assertions.f(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) Assertions.f(matcher.group(2)));
            if (parseInt == 0 || parseInt2 == 0) {
                z2 = false;
            }
            Assertions.b(z2, "Invalid cell resolution " + parseInt + " " + parseInt2);
            return parseInt2;
        } catch (NumberFormatException unused) {
            Log.h("TtmlParser", "Ignoring malformed cell resolution: " + attributeValue);
            return i2;
        }
    }

    private static void h(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String[] k12 = Util.k1(str, "\\s+");
        if (k12.length == 1) {
            matcher = f9043d.matcher(str);
        } else if (k12.length == 2) {
            matcher = f9043d.matcher(k12[1]);
            Log.h("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + k12.length + ".");
        }
        if (matcher.matches()) {
            String str2 = (String) Assertions.f(matcher.group(3));
            str2.hashCode();
            char c2 = 65535;
            switch (str2.hashCode()) {
                case 37:
                    if (str2.equals("%")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (str2.equals("em")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (str2.equals("px")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    ttmlStyle.z(3);
                    break;
                case 1:
                    ttmlStyle.z(2);
                    break;
                case 2:
                    ttmlStyle.z(1);
                    break;
                default:
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
            }
            ttmlStyle.y(Float.parseFloat((String) Assertions.f(matcher.group(1))));
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    private static FrameAndTickRate i(XmlPullParser xmlPullParser) {
        int i2;
        float f2;
        boolean z2;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        if (attributeValue != null) {
            i2 = Integer.parseInt(attributeValue);
        } else {
            i2 = 30;
        }
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] k12 = Util.k1(attributeValue2, " ");
            if (k12.length == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.b(z2, "frameRateMultiplier doesn't have 2 parts");
            f2 = ((float) Integer.parseInt(k12[0])) / ((float) Integer.parseInt(k12[1]));
        } else {
            f2 = 1.0f;
        }
        FrameAndTickRate frameAndTickRate = f9048i;
        int i3 = frameAndTickRate.f9051b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i3 = Integer.parseInt(attributeValue3);
        }
        int i4 = frameAndTickRate.f9052c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i4 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(((float) i2) * f2, i3, i4);
    }

    private static Map<String, TtmlStyle> j(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, int i2, TtsExtent ttsExtent, Map<String, TtmlRegion> map2, Map<String, String> map3) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "style")) {
                String a2 = XmlPullParserUtil.a(xmlPullParser, "style");
                TtmlStyle o2 = o(xmlPullParser, new TtmlStyle());
                if (a2 != null) {
                    for (String str : p(a2)) {
                        o2.a(map.get(str));
                    }
                }
                String g2 = o2.g();
                if (g2 != null) {
                    map.put(g2, o2);
                }
            } else if (XmlPullParserUtil.f(xmlPullParser, "region")) {
                TtmlRegion m2 = m(xmlPullParser, i2, ttsExtent);
                if (m2 != null) {
                    map2.put(m2.f9055a, m2);
                }
            } else if (XmlPullParserUtil.f(xmlPullParser, "metadata")) {
                k(xmlPullParser, map3);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, "head"));
        return map;
    }

    private static void k(XmlPullParser xmlPullParser, Map<String, String> map) throws IOException, XmlPullParserException {
        String a2;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "image") && (a2 = XmlPullParserUtil.a(xmlPullParser, "id")) != null) {
                map.put(a2, xmlPullParser.nextText());
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, "metadata"));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.extractor.text.ttml.TtmlNode l(org.xmlpull.v1.XmlPullParser r20, androidx.media3.extractor.text.ttml.TtmlNode r21, java.util.Map<java.lang.String, androidx.media3.extractor.text.ttml.TtmlRegion> r22, androidx.media3.extractor.text.ttml.TtmlParser.FrameAndTickRate r23) throws androidx.media3.extractor.text.SubtitleDecoderException {
        /*
            r0 = r20
            r9 = r21
            r1 = r23
            int r2 = r20.getAttributeCount()
            r3 = 0
            androidx.media3.extractor.text.ttml.TtmlStyle r5 = o(r0, r3)
            java.lang.String r4 = ""
            r10 = r3
            r12 = r10
            r11 = r4
            r3 = 0
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0024:
            if (r3 >= r2) goto L_0x00b4
            java.lang.String r4 = r0.getAttributeName(r3)
            java.lang.String r8 = r0.getAttributeValue(r3)
            r4.hashCode()
            int r19 = r4.hashCode()
            r6 = 1
            switch(r19) {
                case -934795532: goto L_0x0072;
                case 99841: goto L_0x0067;
                case 100571: goto L_0x005c;
                case 93616297: goto L_0x0051;
                case 109780401: goto L_0x0046;
                case 1292595405: goto L_0x003b;
                default: goto L_0x0039;
            }
        L_0x0039:
            r7 = -1
            goto L_0x007c
        L_0x003b:
            java.lang.String r7 = "backgroundImage"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0044
            goto L_0x0039
        L_0x0044:
            r7 = 5
            goto L_0x007c
        L_0x0046:
            java.lang.String r7 = "style"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x004f
            goto L_0x0039
        L_0x004f:
            r7 = 4
            goto L_0x007c
        L_0x0051:
            java.lang.String r7 = "begin"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x005a
            goto L_0x0039
        L_0x005a:
            r7 = 3
            goto L_0x007c
        L_0x005c:
            java.lang.String r7 = "end"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0065
            goto L_0x0039
        L_0x0065:
            r7 = 2
            goto L_0x007c
        L_0x0067:
            java.lang.String r7 = "dur"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0070
            goto L_0x0039
        L_0x0070:
            r7 = 1
            goto L_0x007c
        L_0x0072:
            java.lang.String r7 = "region"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x007b
            goto L_0x0039
        L_0x007b:
            r7 = 0
        L_0x007c:
            switch(r7) {
                case 0: goto L_0x00a7;
                case 1: goto L_0x00a2;
                case 2: goto L_0x009d;
                case 3: goto L_0x0096;
                case 4: goto L_0x008d;
                case 5: goto L_0x0080;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x009a
        L_0x0080:
            java.lang.String r4 = "#"
            boolean r4 = r8.startsWith(r4)
            if (r4 == 0) goto L_0x009a
            java.lang.String r12 = r8.substring(r6)
            goto L_0x009a
        L_0x008d:
            java.lang.String[] r4 = p(r8)
            int r6 = r4.length
            if (r6 <= 0) goto L_0x009a
            r10 = r4
            goto L_0x009a
        L_0x0096:
            long r13 = q(r8, r1)
        L_0x009a:
            r4 = r22
            goto L_0x00b0
        L_0x009d:
            long r15 = q(r8, r1)
            goto L_0x009a
        L_0x00a2:
            long r17 = q(r8, r1)
            goto L_0x009a
        L_0x00a7:
            r4 = r22
            boolean r6 = r4.containsKey(r8)
            if (r6 == 0) goto L_0x00b0
            r11 = r8
        L_0x00b0:
            int r3 = r3 + 1
            goto L_0x0024
        L_0x00b4:
            if (r9 == 0) goto L_0x00cc
            long r1 = r9.f9031d
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00d1
            int r6 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00c6
            long r13 = r13 + r1
        L_0x00c6:
            int r6 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00d1
            long r15 = r15 + r1
            goto L_0x00d1
        L_0x00cc:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x00d1:
            r1 = r13
            int r6 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x00e9
            int r6 = (r17 > r3 ? 1 : (r17 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00df
            long r17 = r1 + r17
            r3 = r17
            goto L_0x00ea
        L_0x00df:
            if (r9 == 0) goto L_0x00e9
            long r6 = r9.f9032e
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 == 0) goto L_0x00e9
            r3 = r6
            goto L_0x00ea
        L_0x00e9:
            r3 = r15
        L_0x00ea:
            java.lang.String r0 = r20.getName()
            r6 = r10
            r7 = r11
            r8 = r12
            r9 = r21
            androidx.media3.extractor.text.ttml.TtmlNode r0 = androidx.media3.extractor.text.ttml.TtmlNode.c(r0, r1, r3, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.l(org.xmlpull.v1.XmlPullParser, androidx.media3.extractor.text.ttml.TtmlNode, java.util.Map, androidx.media3.extractor.text.ttml.TtmlParser$FrameAndTickRate):androidx.media3.extractor.text.ttml.TtmlNode");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01a3, code lost:
        if (r0.equals("tb") == false) goto L_0x0185;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0176  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.extractor.text.ttml.TtmlRegion m(org.xmlpull.v1.XmlPullParser r17, int r18, androidx.media3.extractor.text.ttml.TtmlParser.TtsExtent r19) {
        /*
            r0 = r17
            r1 = r19
            java.lang.String r2 = "id"
            java.lang.String r4 = androidx.media3.common.util.XmlPullParserUtil.a(r0, r2)
            r2 = 0
            if (r4 != 0) goto L_0x000e
            return r2
        L_0x000e:
            java.lang.String r3 = "origin"
            java.lang.String r3 = androidx.media3.common.util.XmlPullParserUtil.a(r0, r3)
            java.lang.String r5 = "TtmlParser"
            if (r3 == 0) goto L_0x0214
            java.util.regex.Pattern r6 = f9045f
            java.util.regex.Matcher r7 = r6.matcher(r3)
            java.util.regex.Pattern r8 = f9046g
            java.util.regex.Matcher r9 = r8.matcher(r3)
            boolean r10 = r7.matches()
            java.lang.String r11 = "Ignoring region with malformed origin: "
            java.lang.String r12 = "Ignoring region with missing tts:extent: "
            r13 = 1120403456(0x42c80000, float:100.0)
            r14 = 2
            r15 = 1
            if (r10 == 0) goto L_0x0069
            java.lang.String r9 = r7.group(r15)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.Object r9 = androidx.media3.common.util.Assertions.f(r9)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ NumberFormatException -> 0x0056 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0056 }
            float r9 = r9 / r13
            java.lang.String r7 = r7.group(r14)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.Object r7 = androidx.media3.common.util.Assertions.f(r7)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x0056 }
            float r7 = java.lang.Float.parseFloat(r7)     // Catch:{ NumberFormatException -> 0x0056 }
            float r7 = r7 / r13
            r16 = r9
            r9 = r7
            r7 = r16
            goto L_0x00aa
        L_0x0056:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            androidx.media3.common.util.Log.h(r5, r0)
            return r2
        L_0x0069:
            boolean r7 = r9.matches()
            if (r7 == 0) goto L_0x01ff
            if (r1 != 0) goto L_0x0084
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            androidx.media3.common.util.Log.h(r5, r0)
            return r2
        L_0x0084:
            java.lang.String r7 = r9.group(r15)     // Catch:{ NumberFormatException -> 0x01ec }
            java.lang.Object r7 = androidx.media3.common.util.Assertions.f(r7)     // Catch:{ NumberFormatException -> 0x01ec }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x01ec }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x01ec }
            java.lang.String r9 = r9.group(r14)     // Catch:{ NumberFormatException -> 0x01ec }
            java.lang.Object r9 = androidx.media3.common.util.Assertions.f(r9)     // Catch:{ NumberFormatException -> 0x01ec }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ NumberFormatException -> 0x01ec }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x01ec }
            float r7 = (float) r7     // Catch:{ NumberFormatException -> 0x01ec }
            int r10 = r1.f9053a     // Catch:{ NumberFormatException -> 0x01ec }
            float r10 = (float) r10     // Catch:{ NumberFormatException -> 0x01ec }
            float r7 = r7 / r10
            float r9 = (float) r9     // Catch:{ NumberFormatException -> 0x01ec }
            int r10 = r1.f9054b     // Catch:{ NumberFormatException -> 0x01ec }
            float r10 = (float) r10
            float r9 = r9 / r10
        L_0x00aa:
            java.lang.String r10 = "extent"
            java.lang.String r10 = androidx.media3.common.util.XmlPullParserUtil.a(r0, r10)
            if (r10 == 0) goto L_0x01e6
            java.util.regex.Matcher r6 = r6.matcher(r10)
            java.util.regex.Matcher r8 = r8.matcher(r10)
            boolean r10 = r6.matches()
            java.lang.String r11 = "Ignoring region with malformed extent: "
            if (r10 == 0) goto L_0x00f5
            java.lang.String r1 = r6.group(r15)     // Catch:{ NumberFormatException -> 0x00e2 }
            java.lang.Object r1 = androidx.media3.common.util.Assertions.f(r1)     // Catch:{ NumberFormatException -> 0x00e2 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x00e2 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x00e2 }
            float r1 = r1 / r13
            java.lang.String r6 = r6.group(r14)     // Catch:{ NumberFormatException -> 0x00e2 }
            java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r6)     // Catch:{ NumberFormatException -> 0x00e2 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ NumberFormatException -> 0x00e2 }
            float r2 = java.lang.Float.parseFloat(r6)     // Catch:{ NumberFormatException -> 0x00e2 }
            float r2 = r2 / r13
            r10 = r2
            goto L_0x0138
        L_0x00e2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            androidx.media3.common.util.Log.h(r5, r0)
            return r2
        L_0x00f5:
            boolean r6 = r8.matches()
            if (r6 == 0) goto L_0x01d1
            if (r1 != 0) goto L_0x0110
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            androidx.media3.common.util.Log.h(r5, r0)
            return r2
        L_0x0110:
            java.lang.String r6 = r8.group(r15)     // Catch:{ NumberFormatException -> 0x01be }
            java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r6)     // Catch:{ NumberFormatException -> 0x01be }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ NumberFormatException -> 0x01be }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x01be }
            java.lang.String r8 = r8.group(r14)     // Catch:{ NumberFormatException -> 0x01be }
            java.lang.Object r8 = androidx.media3.common.util.Assertions.f(r8)     // Catch:{ NumberFormatException -> 0x01be }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NumberFormatException -> 0x01be }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x01be }
            float r6 = (float) r6     // Catch:{ NumberFormatException -> 0x01be }
            int r10 = r1.f9053a     // Catch:{ NumberFormatException -> 0x01be }
            float r10 = (float) r10     // Catch:{ NumberFormatException -> 0x01be }
            float r6 = r6 / r10
            float r8 = (float) r8     // Catch:{ NumberFormatException -> 0x01be }
            int r1 = r1.f9054b     // Catch:{ NumberFormatException -> 0x01be }
            float r1 = (float) r1
            float r8 = r8 / r1
            r1 = r6
            r10 = r8
        L_0x0138:
            java.lang.String r2 = "displayAlign"
            java.lang.String r2 = androidx.media3.common.util.XmlPullParserUtil.a(r0, r2)
            r3 = 0
            if (r2 == 0) goto L_0x0165
            java.lang.String r2 = com.google.common.base.Ascii.e(r2)
            r2.hashCode()
            java.lang.String r5 = "center"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x015d
            java.lang.String r5 = "after"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0159
            goto L_0x0165
        L_0x0159:
            float r9 = r9 + r10
            r6 = r9
            r8 = 2
            goto L_0x0167
        L_0x015d:
            r2 = 1073741824(0x40000000, float:2.0)
            float r2 = r10 / r2
            float r9 = r9 + r2
            r6 = r9
            r8 = 1
            goto L_0x0167
        L_0x0165:
            r6 = r9
            r8 = 0
        L_0x0167:
            r2 = 1065353216(0x3f800000, float:1.0)
            r5 = r18
            float r5 = (float) r5
            float r12 = r2 / r5
            java.lang.String r2 = "writingMode"
            java.lang.String r0 = androidx.media3.common.util.XmlPullParserUtil.a(r0, r2)
            if (r0 == 0) goto L_0x01ae
            java.lang.String r0 = com.google.common.base.Ascii.e(r0)
            r0.hashCode()
            int r2 = r0.hashCode()
            r5 = -1
            switch(r2) {
                case 3694: goto L_0x019d;
                case 3553396: goto L_0x0192;
                case 3553576: goto L_0x0187;
                default: goto L_0x0185;
            }
        L_0x0185:
            r3 = -1
            goto L_0x01a6
        L_0x0187:
            java.lang.String r2 = "tbrl"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0190
            goto L_0x0185
        L_0x0190:
            r3 = 2
            goto L_0x01a6
        L_0x0192:
            java.lang.String r2 = "tblr"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x019b
            goto L_0x0185
        L_0x019b:
            r3 = 1
            goto L_0x01a6
        L_0x019d:
            java.lang.String r2 = "tb"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01a6
            goto L_0x0185
        L_0x01a6:
            switch(r3) {
                case 0: goto L_0x01ac;
                case 1: goto L_0x01ac;
                case 2: goto L_0x01aa;
                default: goto L_0x01a9;
            }
        L_0x01a9:
            goto L_0x01ae
        L_0x01aa:
            r13 = 1
            goto L_0x01b2
        L_0x01ac:
            r13 = 2
            goto L_0x01b2
        L_0x01ae:
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x01b2:
            androidx.media3.extractor.text.ttml.TtmlRegion r0 = new androidx.media3.extractor.text.ttml.TtmlRegion
            r2 = 0
            r11 = 1
            r3 = r0
            r5 = r7
            r7 = r2
            r9 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        L_0x01be:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            androidx.media3.common.util.Log.h(r5, r0)
            return r2
        L_0x01d1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Ignoring region with unsupported extent: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            androidx.media3.common.util.Log.h(r5, r0)
            return r2
        L_0x01e6:
            java.lang.String r0 = "Ignoring region without an extent"
            androidx.media3.common.util.Log.h(r5, r0)
            return r2
        L_0x01ec:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            androidx.media3.common.util.Log.h(r5, r0)
            return r2
        L_0x01ff:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Ignoring region with unsupported origin: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            androidx.media3.common.util.Log.h(r5, r0)
            return r2
        L_0x0214:
            java.lang.String r0 = "Ignoring region without an origin"
            androidx.media3.common.util.Log.h(r5, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.m(org.xmlpull.v1.XmlPullParser, int, androidx.media3.extractor.text.ttml.TtmlParser$TtsExtent):androidx.media3.extractor.text.ttml.TtmlRegion");
    }

    private static float n(String str) {
        Matcher matcher = f9044e.matcher(str);
        if (!matcher.matches()) {
            Log.h("TtmlParser", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) Assertions.f(matcher.group(1)))));
        } catch (NumberFormatException e2) {
            Log.i("TtmlParser", "Failed to parse shear: " + str, e2);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01e0, code lost:
        if (r3.equals("text") == false) goto L_0x01d8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.extractor.text.ttml.TtmlStyle o(org.xmlpull.v1.XmlPullParser r12, androidx.media3.extractor.text.ttml.TtmlStyle r13) {
        /*
            int r0 = r12.getAttributeCount()
            r1 = 0
            r2 = 0
        L_0x0006:
            if (r2 >= r0) goto L_0x02f6
            java.lang.String r3 = r12.getAttributeValue(r2)
            java.lang.String r4 = r12.getAttributeName(r2)
            r4.hashCode()
            int r5 = r4.hashCode()
            r6 = 5
            r7 = 4
            r8 = -1
            r9 = 3
            r10 = 2
            r11 = 1
            switch(r5) {
                case -1550943582: goto L_0x00cf;
                case -1224696685: goto L_0x00c3;
                case -1065511464: goto L_0x00b7;
                case -879295043: goto L_0x00ab;
                case -734428249: goto L_0x009f;
                case 3355: goto L_0x0094;
                case 3511770: goto L_0x0089;
                case 94842723: goto L_0x007e;
                case 109403361: goto L_0x0071;
                case 110138194: goto L_0x0064;
                case 365601008: goto L_0x0057;
                case 921125321: goto L_0x004a;
                case 1115953443: goto L_0x003d;
                case 1287124693: goto L_0x0030;
                case 1754920356: goto L_0x0023;
                default: goto L_0x0020;
            }
        L_0x0020:
            r4 = -1
            goto L_0x00da
        L_0x0023:
            java.lang.String r5 = "multiRowAlign"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x002c
            goto L_0x0020
        L_0x002c:
            r4 = 14
            goto L_0x00da
        L_0x0030:
            java.lang.String r5 = "backgroundColor"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0039
            goto L_0x0020
        L_0x0039:
            r4 = 13
            goto L_0x00da
        L_0x003d:
            java.lang.String r5 = "rubyPosition"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0046
            goto L_0x0020
        L_0x0046:
            r4 = 12
            goto L_0x00da
        L_0x004a:
            java.lang.String r5 = "textEmphasis"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0053
            goto L_0x0020
        L_0x0053:
            r4 = 11
            goto L_0x00da
        L_0x0057:
            java.lang.String r5 = "fontSize"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0060
            goto L_0x0020
        L_0x0060:
            r4 = 10
            goto L_0x00da
        L_0x0064:
            java.lang.String r5 = "textCombine"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x006d
            goto L_0x0020
        L_0x006d:
            r4 = 9
            goto L_0x00da
        L_0x0071:
            java.lang.String r5 = "shear"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x007a
            goto L_0x0020
        L_0x007a:
            r4 = 8
            goto L_0x00da
        L_0x007e:
            java.lang.String r5 = "color"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0087
            goto L_0x0020
        L_0x0087:
            r4 = 7
            goto L_0x00da
        L_0x0089:
            java.lang.String r5 = "ruby"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0092
            goto L_0x0020
        L_0x0092:
            r4 = 6
            goto L_0x00da
        L_0x0094:
            java.lang.String r5 = "id"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x009d
            goto L_0x0020
        L_0x009d:
            r4 = 5
            goto L_0x00da
        L_0x009f:
            java.lang.String r5 = "fontWeight"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00a9
            goto L_0x0020
        L_0x00a9:
            r4 = 4
            goto L_0x00da
        L_0x00ab:
            java.lang.String r5 = "textDecoration"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00b5
            goto L_0x0020
        L_0x00b5:
            r4 = 3
            goto L_0x00da
        L_0x00b7:
            java.lang.String r5 = "textAlign"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00c1
            goto L_0x0020
        L_0x00c1:
            r4 = 2
            goto L_0x00da
        L_0x00c3:
            java.lang.String r5 = "fontFamily"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00cd
            goto L_0x0020
        L_0x00cd:
            r4 = 1
            goto L_0x00da
        L_0x00cf:
            java.lang.String r5 = "fontStyle"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00d9
            goto L_0x0020
        L_0x00d9:
            r4 = 0
        L_0x00da:
            java.lang.String r5 = "TtmlParser"
            switch(r4) {
                case 0: goto L_0x02e4;
                case 1: goto L_0x02db;
                case 2: goto L_0x02ce;
                case 3: goto L_0x026c;
                case 4: goto L_0x025c;
                case 5: goto L_0x0246;
                case 6: goto L_0x01ca;
                case 7: goto L_0x01a7;
                case 8: goto L_0x0199;
                case 9: goto L_0x016c;
                case 10: goto L_0x014d;
                case 11: goto L_0x013f;
                case 12: goto L_0x0112;
                case 13: goto L_0x00ef;
                case 14: goto L_0x00e1;
                default: goto L_0x00df;
            }
        L_0x00df:
            goto L_0x02f2
        L_0x00e1:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            android.text.Layout$Alignment r3 = f(r3)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.D(r3)
            goto L_0x02f2
        L_0x00ef:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            int r4 = androidx.media3.common.util.ColorParser.c(r3)     // Catch:{ IllegalArgumentException -> 0x00fc }
            r13.u(r4)     // Catch:{ IllegalArgumentException -> 0x00fc }
            goto L_0x02f2
        L_0x00fc:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Failed parsing background value: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            androidx.media3.common.util.Log.h(r5, r3)
            goto L_0x02f2
        L_0x0112:
            java.lang.String r3 = com.google.common.base.Ascii.e(r3)
            r3.hashCode()
            java.lang.String r4 = "before"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0135
            java.lang.String r4 = "after"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x012b
            goto L_0x02f2
        L_0x012b:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.E(r10)
            goto L_0x02f2
        L_0x0135:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.E(r11)
            goto L_0x02f2
        L_0x013f:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TextEmphasis r3 = androidx.media3.extractor.text.ttml.TextEmphasis.a(r3)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.J(r3)
            goto L_0x02f2
        L_0x014d:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)     // Catch:{ SubtitleDecoderException -> 0x0156 }
            h(r3, r13)     // Catch:{ SubtitleDecoderException -> 0x0156 }
            goto L_0x02f2
        L_0x0156:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Failed parsing fontSize value: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            androidx.media3.common.util.Log.h(r5, r3)
            goto L_0x02f2
        L_0x016c:
            java.lang.String r3 = com.google.common.base.Ascii.e(r3)
            r3.hashCode()
            java.lang.String r4 = "all"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x018f
            java.lang.String r4 = "none"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0185
            goto L_0x02f2
        L_0x0185:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.I(r1)
            goto L_0x02f2
        L_0x018f:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.I(r11)
            goto L_0x02f2
        L_0x0199:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            float r3 = n(r3)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.G(r3)
            goto L_0x02f2
        L_0x01a7:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            int r4 = androidx.media3.common.util.ColorParser.c(r3)     // Catch:{ IllegalArgumentException -> 0x01b4 }
            r13.w(r4)     // Catch:{ IllegalArgumentException -> 0x01b4 }
            goto L_0x02f2
        L_0x01b4:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Failed parsing color value: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            androidx.media3.common.util.Log.h(r5, r3)
            goto L_0x02f2
        L_0x01ca:
            java.lang.String r3 = com.google.common.base.Ascii.e(r3)
            r3.hashCode()
            int r4 = r3.hashCode()
            switch(r4) {
                case -618561360: goto L_0x020f;
                case -410956671: goto L_0x0204;
                case -250518009: goto L_0x01f9;
                case -136074796: goto L_0x01ee;
                case 3016401: goto L_0x01e3;
                case 3556653: goto L_0x01da;
                default: goto L_0x01d8;
            }
        L_0x01d8:
            r6 = -1
            goto L_0x0219
        L_0x01da:
            java.lang.String r4 = "text"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0219
            goto L_0x01d8
        L_0x01e3:
            java.lang.String r4 = "base"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01ec
            goto L_0x01d8
        L_0x01ec:
            r6 = 4
            goto L_0x0219
        L_0x01ee:
            java.lang.String r4 = "textContainer"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01f7
            goto L_0x01d8
        L_0x01f7:
            r6 = 3
            goto L_0x0219
        L_0x01f9:
            java.lang.String r4 = "delimiter"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0202
            goto L_0x01d8
        L_0x0202:
            r6 = 2
            goto L_0x0219
        L_0x0204:
            java.lang.String r4 = "container"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x020d
            goto L_0x01d8
        L_0x020d:
            r6 = 1
            goto L_0x0219
        L_0x020f:
            java.lang.String r4 = "baseContainer"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0218
            goto L_0x01d8
        L_0x0218:
            r6 = 0
        L_0x0219:
            switch(r6) {
                case 0: goto L_0x023c;
                case 1: goto L_0x0232;
                case 2: goto L_0x0228;
                case 3: goto L_0x021e;
                case 4: goto L_0x023c;
                case 5: goto L_0x021e;
                default: goto L_0x021c;
            }
        L_0x021c:
            goto L_0x02f2
        L_0x021e:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.F(r9)
            goto L_0x02f2
        L_0x0228:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.F(r7)
            goto L_0x02f2
        L_0x0232:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.F(r11)
            goto L_0x02f2
        L_0x023c:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.F(r10)
            goto L_0x02f2
        L_0x0246:
            java.lang.String r4 = "style"
            java.lang.String r5 = r12.getName()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x02f2
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.A(r3)
            goto L_0x02f2
        L_0x025c:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            java.lang.String r4 = "bold"
            boolean r3 = r4.equalsIgnoreCase(r3)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.v(r3)
            goto L_0x02f2
        L_0x026c:
            java.lang.String r3 = com.google.common.base.Ascii.e(r3)
            r3.hashCode()
            int r4 = r3.hashCode()
            switch(r4) {
                case -1461280213: goto L_0x029c;
                case -1026963764: goto L_0x0291;
                case 913457136: goto L_0x0286;
                case 1679736913: goto L_0x027b;
                default: goto L_0x027a;
            }
        L_0x027a:
            goto L_0x02a6
        L_0x027b:
            java.lang.String r4 = "linethrough"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0284
            goto L_0x02a6
        L_0x0284:
            r8 = 3
            goto L_0x02a6
        L_0x0286:
            java.lang.String r4 = "nolinethrough"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x028f
            goto L_0x02a6
        L_0x028f:
            r8 = 2
            goto L_0x02a6
        L_0x0291:
            java.lang.String r4 = "underline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x029a
            goto L_0x02a6
        L_0x029a:
            r8 = 1
            goto L_0x02a6
        L_0x029c:
            java.lang.String r4 = "nounderline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02a5
            goto L_0x02a6
        L_0x02a5:
            r8 = 0
        L_0x02a6:
            switch(r8) {
                case 0: goto L_0x02c5;
                case 1: goto L_0x02bc;
                case 2: goto L_0x02b3;
                case 3: goto L_0x02aa;
                default: goto L_0x02a9;
            }
        L_0x02a9:
            goto L_0x02f2
        L_0x02aa:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.C(r11)
            goto L_0x02f2
        L_0x02b3:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.C(r1)
            goto L_0x02f2
        L_0x02bc:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.K(r11)
            goto L_0x02f2
        L_0x02c5:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.K(r1)
            goto L_0x02f2
        L_0x02ce:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            android.text.Layout$Alignment r3 = f(r3)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.H(r3)
            goto L_0x02f2
        L_0x02db:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.x(r3)
            goto L_0x02f2
        L_0x02e4:
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = d(r13)
            java.lang.String r4 = "italic"
            boolean r3 = r4.equalsIgnoreCase(r3)
            androidx.media3.extractor.text.ttml.TtmlStyle r13 = r13.B(r3)
        L_0x02f2:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x02f6:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.o(org.xmlpull.v1.XmlPullParser, androidx.media3.extractor.text.ttml.TtmlStyle):androidx.media3.extractor.text.ttml.TtmlStyle");
    }

    private static String[] p(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return new String[0];
        }
        return Util.k1(trim, "\\s+");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00bf, code lost:
        if (r13.equals("ms") == false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f6, code lost:
        r8 = r8 / r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0104, code lost:
        r8 = r8 * r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long q(java.lang.String r13, androidx.media3.extractor.text.ttml.TtmlParser.FrameAndTickRate r14) throws androidx.media3.extractor.text.SubtitleDecoderException {
        /*
            java.util.regex.Pattern r0 = f9041b
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L_0x0088
            java.lang.String r13 = r0.group(r7)
            java.lang.Object r13 = androidx.media3.common.util.Assertions.f(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r7 = java.lang.Long.parseLong(r13)
            r9 = 3600(0xe10, double:1.7786E-320)
            long r7 = r7 * r9
            double r7 = (double) r7
            java.lang.String r13 = r0.group(r6)
            java.lang.Object r13 = androidx.media3.common.util.Assertions.f(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r9 = java.lang.Long.parseLong(r13)
            r11 = 60
            long r9 = r9 * r11
            double r9 = (double) r9
            double r7 = r7 + r9
            java.lang.String r13 = r0.group(r5)
            java.lang.Object r13 = androidx.media3.common.util.Assertions.f(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r5 = java.lang.Long.parseLong(r13)
            double r5 = (double) r5
            double r7 = r7 + r5
            java.lang.String r13 = r0.group(r4)
            r4 = 0
            if (r13 == 0) goto L_0x0059
            double r9 = java.lang.Double.parseDouble(r13)
            goto L_0x005a
        L_0x0059:
            r9 = r4
        L_0x005a:
            double r7 = r7 + r9
            r13 = 5
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x006c
            long r9 = java.lang.Long.parseLong(r13)
            float r13 = (float) r9
            float r1 = r14.f9050a
            float r13 = r13 / r1
            double r9 = (double) r13
            goto L_0x006d
        L_0x006c:
            r9 = r4
        L_0x006d:
            double r7 = r7 + r9
            r13 = 6
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x0083
            long r0 = java.lang.Long.parseLong(r13)
            double r0 = (double) r0
            int r13 = r14.f9051b
            double r4 = (double) r13
            double r0 = r0 / r4
            float r13 = r14.f9050a
            double r13 = (double) r13
            double r4 = r0 / r13
        L_0x0083:
            double r7 = r7 + r4
            double r7 = r7 * r2
            long r13 = (long) r7
            return r13
        L_0x0088:
            java.util.regex.Pattern r0 = f9042c
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            if (r1 == 0) goto L_0x010f
            java.lang.String r13 = r0.group(r7)
            java.lang.Object r13 = androidx.media3.common.util.Assertions.f(r13)
            java.lang.String r13 = (java.lang.String) r13
            double r8 = java.lang.Double.parseDouble(r13)
            java.lang.String r13 = r0.group(r6)
            java.lang.Object r13 = androidx.media3.common.util.Assertions.f(r13)
            java.lang.String r13 = (java.lang.String) r13
            r13.hashCode()
            int r0 = r13.hashCode()
            r1 = -1
            switch(r0) {
                case 102: goto L_0x00e3;
                case 104: goto L_0x00d8;
                case 109: goto L_0x00cd;
                case 116: goto L_0x00c2;
                case 3494: goto L_0x00b9;
                default: goto L_0x00b7;
            }
        L_0x00b7:
            r4 = -1
            goto L_0x00ed
        L_0x00b9:
            java.lang.String r0 = "ms"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00ed
            goto L_0x00b7
        L_0x00c2:
            java.lang.String r0 = "t"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00cb
            goto L_0x00b7
        L_0x00cb:
            r4 = 3
            goto L_0x00ed
        L_0x00cd:
            java.lang.String r0 = "m"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00d6
            goto L_0x00b7
        L_0x00d6:
            r4 = 2
            goto L_0x00ed
        L_0x00d8:
            java.lang.String r0 = "h"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00e1
            goto L_0x00b7
        L_0x00e1:
            r4 = 1
            goto L_0x00ed
        L_0x00e3:
            java.lang.String r0 = "f"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00ec
            goto L_0x00b7
        L_0x00ec:
            r4 = 0
        L_0x00ed:
            switch(r4) {
                case 0: goto L_0x0107;
                case 1: goto L_0x00ff;
                case 2: goto L_0x00fc;
                case 3: goto L_0x00f8;
                case 4: goto L_0x00f1;
                default: goto L_0x00f0;
            }
        L_0x00f0:
            goto L_0x010b
        L_0x00f1:
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
        L_0x00f6:
            double r8 = r8 / r13
            goto L_0x010b
        L_0x00f8:
            int r13 = r14.f9052c
            double r13 = (double) r13
            goto L_0x00f6
        L_0x00fc:
            r13 = 4633641066610819072(0x404e000000000000, double:60.0)
            goto L_0x0104
        L_0x00ff:
            r13 = 4660134898793709568(0x40ac200000000000, double:3600.0)
        L_0x0104:
            double r8 = r8 * r13
            goto L_0x010b
        L_0x0107:
            float r13 = r14.f9050a
            double r13 = (double) r13
            goto L_0x00f6
        L_0x010b:
            double r8 = r8 * r2
            long r13 = (long) r8
            return r13
        L_0x010f:
            androidx.media3.extractor.text.SubtitleDecoderException r14 = new androidx.media3.extractor.text.SubtitleDecoderException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Malformed time expression: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r14.<init>(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.q(java.lang.String, androidx.media3.extractor.text.ttml.TtmlParser$FrameAndTickRate):long");
    }

    private static TtsExtent r(XmlPullParser xmlPullParser) {
        String a2 = XmlPullParserUtil.a(xmlPullParser, "extent");
        if (a2 == null) {
            return null;
        }
        Matcher matcher = f9046g.matcher(a2);
        if (!matcher.matches()) {
            Log.h("TtmlParser", "Ignoring non-pixel tts extent: " + a2);
            return null;
        }
        try {
            return new TtsExtent(Integer.parseInt((String) Assertions.f(matcher.group(1))), Integer.parseInt((String) Assertions.f(matcher.group(2))));
        } catch (NumberFormatException unused) {
            Log.h("TtmlParser", "Ignoring malformed tts extent: " + a2);
            return null;
        }
    }

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        LegacySubtitleUtil.c(b(bArr, i2, i3), outputOptions, consumer);
    }

    public Subtitle b(byte[] bArr, int i2, int i3) {
        FrameAndTickRate frameAndTickRate;
        try {
            XmlPullParser newPullParser = this.f9049a.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new TtmlRegion(""));
            TtsExtent ttsExtent = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, i2, i3), (String) null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRate2 = f9048i;
            TtmlSubtitle ttmlSubtitle = null;
            int i4 = 15;
            int i5 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i5 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            frameAndTickRate2 = i(newPullParser);
                            i4 = g(newPullParser, 15);
                            ttsExtent = r(newPullParser);
                        }
                        TtsExtent ttsExtent2 = ttsExtent;
                        FrameAndTickRate frameAndTickRate3 = frameAndTickRate2;
                        int i6 = i4;
                        if (!e(name)) {
                            Log.f("TtmlParser", "Ignoring unsupported tag: " + newPullParser.getName());
                            i5++;
                            frameAndTickRate2 = frameAndTickRate3;
                        } else {
                            if ("head".equals(name)) {
                                frameAndTickRate = frameAndTickRate3;
                                j(newPullParser, hashMap, i6, ttsExtent2, hashMap2, hashMap3);
                            } else {
                                frameAndTickRate = frameAndTickRate3;
                                try {
                                    TtmlNode l2 = l(newPullParser, ttmlNode, hashMap2, frameAndTickRate);
                                    arrayDeque.push(l2);
                                    if (ttmlNode != null) {
                                        ttmlNode.a(l2);
                                    }
                                } catch (SubtitleDecoderException e2) {
                                    Log.i("TtmlParser", "Suppressing parser error", e2);
                                    i5++;
                                }
                            }
                            frameAndTickRate2 = frameAndTickRate;
                        }
                        ttsExtent = ttsExtent2;
                        i4 = i6;
                    } else if (eventType == 4) {
                        ((TtmlNode) Assertions.f(ttmlNode)).a(TtmlNode.d(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            ttmlSubtitle = new TtmlSubtitle((TtmlNode) Assertions.f((TtmlNode) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i5++;
                } else if (eventType == 3) {
                    i5--;
                }
                newPullParser.next();
            }
            return (Subtitle) Assertions.f(ttmlSubtitle);
        } catch (XmlPullParserException e3) {
            throw new IllegalStateException("Unable to decode source", e3);
        } catch (IOException e4) {
            throw new IllegalStateException("Unexpected error when reading input.", e4);
        }
    }

    public int c() {
        return 1;
    }

    public /* synthetic */ void reset() {
        f.b(this);
    }
}
