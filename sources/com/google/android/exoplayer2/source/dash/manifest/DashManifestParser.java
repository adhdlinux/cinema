package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import com.applovin.sdk.AppLovinMediationProvider;
import com.facebook.common.time.Clock;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Http2;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f26291b = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f26292c = Pattern.compile("CC([1-4])=.*");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f26293d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f26294e = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* renamed from: a  reason: collision with root package name */
    private final XmlPullParserFactory f26295a;

    protected static final class RepresentationInfo {

        /* renamed from: a  reason: collision with root package name */
        public final Format f26296a;

        /* renamed from: b  reason: collision with root package name */
        public final ImmutableList<BaseUrl> f26297b;

        /* renamed from: c  reason: collision with root package name */
        public final SegmentBase f26298c;

        /* renamed from: d  reason: collision with root package name */
        public final String f26299d;

        /* renamed from: e  reason: collision with root package name */
        public final ArrayList<DrmInitData.SchemeData> f26300e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayList<Descriptor> f26301f;

        /* renamed from: g  reason: collision with root package name */
        public final long f26302g;

        /* renamed from: h  reason: collision with root package name */
        public final List<Descriptor> f26303h;

        /* renamed from: i  reason: collision with root package name */
        public final List<Descriptor> f26304i;

        public RepresentationInfo(Format format, List<BaseUrl> list, SegmentBase segmentBase, String str, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2, List<Descriptor> list2, List<Descriptor> list3, long j2) {
            this.f26296a = format;
            this.f26297b = ImmutableList.n(list);
            this.f26298c = segmentBase;
            this.f26299d = str;
            this.f26300e = arrayList;
            this.f26301f = arrayList2;
            this.f26303h = list2;
            this.f26304i = list3;
            this.f26302g = j2;
        }
    }

    public DashManifestParser() {
        try {
            this.f26295a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    protected static int D(List<Descriptor> list) {
        String str;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.f26305a) && (str = descriptor.f26306b) != null) {
                Matcher matcher = f26292c.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.i("MpdParser", "Unable to parse CEA-608 channel number from: " + descriptor.f26306b);
            }
        }
        return -1;
    }

    protected static int E(List<Descriptor> list) {
        String str;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.f26305a) && (str = descriptor.f26306b) != null) {
                Matcher matcher = f26293d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.i("MpdParser", "Unable to parse CEA-708 service block number from: " + descriptor.f26306b);
            }
        }
        return -1;
    }

    protected static long H(XmlPullParser xmlPullParser, String str, long j2) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j2;
        }
        return Util.M0(attributeValue);
    }

    protected static Descriptor I(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String r02 = r0(xmlPullParser, "schemeIdUri", "");
        String r03 = r0(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, (String) null);
        String r04 = r0(xmlPullParser, "id", (String) null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.d(xmlPullParser, str));
        return new Descriptor(r02, r03, r04);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static int J(org.xmlpull.v1.XmlPullParser r4) {
        /*
            r0 = 0
            java.lang.String r1 = "value"
            java.lang.String r4 = r4.getAttributeValue(r0, r1)
            r0 = -1
            if (r4 != 0) goto L_0x000b
            return r0
        L_0x000b:
            java.lang.String r4 = com.google.common.base.Ascii.e(r4)
            r4.hashCode()
            int r1 = r4.hashCode()
            r2 = 2
            r3 = 1
            switch(r1) {
                case 1596796: goto L_0x003e;
                case 2937391: goto L_0x0033;
                case 3094035: goto L_0x0028;
                case 3133436: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            r4 = -1
            goto L_0x0048
        L_0x001d:
            java.lang.String r1 = "fa01"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0026
            goto L_0x001b
        L_0x0026:
            r4 = 3
            goto L_0x0048
        L_0x0028:
            java.lang.String r1 = "f801"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0031
            goto L_0x001b
        L_0x0031:
            r4 = 2
            goto L_0x0048
        L_0x0033:
            java.lang.String r1 = "a000"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x003c
            goto L_0x001b
        L_0x003c:
            r4 = 1
            goto L_0x0048
        L_0x003e:
            java.lang.String r1 = "4000"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0047
            goto L_0x001b
        L_0x0047:
            r4 = 0
        L_0x0048:
            switch(r4) {
                case 0: goto L_0x0052;
                case 1: goto L_0x0051;
                case 2: goto L_0x004f;
                case 3: goto L_0x004c;
                default: goto L_0x004b;
            }
        L_0x004b:
            return r0
        L_0x004c:
            r4 = 8
            return r4
        L_0x004f:
            r4 = 6
            return r4
        L_0x0051:
            return r2
        L_0x0052:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.J(org.xmlpull.v1.XmlPullParser):int");
    }

    protected static int K(XmlPullParser xmlPullParser) {
        int U = U(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, -1);
        if (U <= 0 || U >= 33) {
            return -1;
        }
        return U;
    }

    protected static int L(XmlPullParser xmlPullParser) {
        int bitCount;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (attributeValue == null || (bitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return bitCount;
    }

    protected static long M(XmlPullParser xmlPullParser, String str, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j2;
        }
        return Util.N0(attributeValue);
    }

    protected static String N(List<Descriptor> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            String str = descriptor.f26305a;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(descriptor.f26306b)) {
                return "audio/eac3-joc";
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(descriptor.f26306b)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    protected static float R(XmlPullParser xmlPullParser, String str, float f2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return f2;
        }
        return Float.parseFloat(attributeValue);
    }

    protected static float S(XmlPullParser xmlPullParser, float f2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "frameRate");
        if (attributeValue == null) {
            return f2;
        }
        Matcher matcher = f26291b.matcher(attributeValue);
        if (!matcher.matches()) {
            return f2;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        String group = matcher.group(2);
        if (!TextUtils.isEmpty(group)) {
            return ((float) parseInt) / ((float) Integer.parseInt(group));
        }
        return (float) parseInt;
    }

    protected static int U(XmlPullParser xmlPullParser, String str, int i2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return i2;
        }
        return Integer.parseInt(attributeValue);
    }

    protected static long W(List<Descriptor> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if (Ascii.a("http://dashif.org/guidelines/last-segment-number", descriptor.f26305a)) {
                return Long.parseLong(descriptor.f26306b);
            }
        }
        return -1;
    }

    protected static long X(XmlPullParser xmlPullParser, String str, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j2;
        }
        return Long.parseLong(attributeValue);
    }

    protected static int Z(XmlPullParser xmlPullParser) {
        int U = U(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, -1);
        if (U < 0) {
            return -1;
        }
        int[] iArr = f26294e;
        if (U < iArr.length) {
            return iArr[U];
        }
        return -1;
    }

    private long b(List<SegmentBase.SegmentTimelineElement> list, long j2, long j3, int i2, long j4) {
        int i3;
        if (i2 >= 0) {
            i3 = i2 + 1;
        } else {
            i3 = (int) Util.m(j4 - j2, j3);
        }
        for (int i4 = 0; i4 < i3; i4++) {
            list.add(m(j2, j3));
            j2 += j3;
        }
        return j2;
    }

    private static int p(int i2, int i3) {
        if (i2 == -1) {
            return i3;
        }
        if (i3 == -1) {
            return i2;
        }
        Assertions.g(i2 == i3);
        return i2;
    }

    private static String q(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        Assertions.g(str.equals(str2));
        return str;
    }

    private static void r(ArrayList<DrmInitData.SchemeData> arrayList) {
        String str;
        int i2 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                str = null;
                break;
            }
            DrmInitData.SchemeData schemeData = arrayList.get(i2);
            if (C.f22818c.equals(schemeData.f24080c) && (str = schemeData.f24081d) != null) {
                arrayList.remove(i2);
                break;
            }
            i2++;
        }
        if (str != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                DrmInitData.SchemeData schemeData2 = arrayList.get(i3);
                if (C.f22817b.equals(schemeData2.f24080c) && schemeData2.f24081d == null) {
                    arrayList.set(i3, new DrmInitData.SchemeData(C.f22818c, str, schemeData2.f24082e, schemeData2.f24083f));
                }
            }
        }
    }

    protected static String r0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    private static void s(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.d()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= arrayList.size()) {
                        break;
                    } else if (arrayList.get(i2).b(schemeData)) {
                        arrayList.remove(size);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
    }

    protected static String s0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                w(xmlPullParser);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, str));
        return str2;
    }

    private static long t(long j2, long j3) {
        if (j3 != -9223372036854775807L) {
            j2 = j3;
        }
        if (j2 == Clock.MAX_TIME) {
            return -9223372036854775807L;
        }
        return j2;
    }

    private static String u(String str, String str2) {
        if (MimeTypes.o(str)) {
            return MimeTypes.c(str2);
        }
        if (MimeTypes.s(str)) {
            return MimeTypes.n(str2);
        }
        if (MimeTypes.r(str) || MimeTypes.p(str)) {
            return str;
        }
        if (!"application/mp4".equals(str)) {
            return null;
        }
        String g2 = MimeTypes.g(str2);
        if ("text/vtt".equals(g2)) {
            return "application/x-mp4-vtt";
        }
        return g2;
    }

    private boolean v(String[] strArr) {
        for (String startsWith : strArr) {
            if (startsWith.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

    public static void w(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (XmlPullParserUtil.e(xmlPullParser)) {
            int i2 = 1;
            while (i2 != 0) {
                xmlPullParser.next();
                if (XmlPullParserUtil.e(xmlPullParser)) {
                    i2++;
                } else if (XmlPullParserUtil.c(xmlPullParser)) {
                    i2--;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int A(org.xmlpull.v1.XmlPullParser r4) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "schemeIdUri"
            r1 = 0
            java.lang.String r0 = r0(r4, r0, r1)
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = -1
            switch(r1) {
                case -2128649360: goto L_0x0056;
                case -1352850286: goto L_0x004b;
                case -1138141449: goto L_0x0040;
                case -986633423: goto L_0x0035;
                case -79006963: goto L_0x002a;
                case 312179081: goto L_0x001f;
                case 2036691300: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            r0 = -1
            goto L_0x0060
        L_0x0014:
            java.lang.String r1 = "urn:dolby:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001d
            goto L_0x0012
        L_0x001d:
            r0 = 6
            goto L_0x0060
        L_0x001f:
            java.lang.String r1 = "tag:dts.com,2018:uhd:audio_channel_configuration"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0028
            goto L_0x0012
        L_0x0028:
            r0 = 5
            goto L_0x0060
        L_0x002a:
            java.lang.String r1 = "tag:dts.com,2014:dash:audio_channel_configuration:2012"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0033
            goto L_0x0012
        L_0x0033:
            r0 = 4
            goto L_0x0060
        L_0x0035:
            java.lang.String r1 = "urn:mpeg:mpegB:cicp:ChannelConfiguration"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003e
            goto L_0x0012
        L_0x003e:
            r0 = 3
            goto L_0x0060
        L_0x0040:
            java.lang.String r1 = "tag:dolby.com,2014:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0049
            goto L_0x0012
        L_0x0049:
            r0 = 2
            goto L_0x0060
        L_0x004b:
            java.lang.String r1 = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0054
            goto L_0x0012
        L_0x0054:
            r0 = 1
            goto L_0x0060
        L_0x0056:
            java.lang.String r1 = "urn:dts:dash:audio_channel_configuration:2012"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x005f
            goto L_0x0012
        L_0x005f:
            r0 = 0
        L_0x0060:
            switch(r0) {
                case 0: goto L_0x007a;
                case 1: goto L_0x0073;
                case 2: goto L_0x006e;
                case 3: goto L_0x0069;
                case 4: goto L_0x007a;
                case 5: goto L_0x0064;
                case 6: goto L_0x006e;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x007e
        L_0x0064:
            int r2 = L(r4)
            goto L_0x007e
        L_0x0069:
            int r2 = Z(r4)
            goto L_0x007e
        L_0x006e:
            int r2 = J(r4)
            goto L_0x007e
        L_0x0073:
            java.lang.String r0 = "value"
            int r2 = U(r4, r0, r2)
            goto L_0x007e
        L_0x007a:
            int r2 = K(r4)
        L_0x007e:
            r4.next()
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.d(r4, r0)
            if (r0 == 0) goto L_0x007e
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.A(org.xmlpull.v1.XmlPullParser):int");
    }

    /* access modifiers changed from: protected */
    public long B(XmlPullParser xmlPullParser, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j2;
        }
        if ("INF".equals(attributeValue)) {
            return Clock.MAX_TIME;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    /* access modifiers changed from: protected */
    public List<BaseUrl> C(XmlPullParser xmlPullParser, List<BaseUrl> list, boolean z2) throws XmlPullParserException, IOException {
        int i2;
        int i3;
        String str;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "dvb:priority");
        if (attributeValue != null) {
            i2 = Integer.parseInt(attributeValue);
        } else if (z2) {
            i2 = 1;
        } else {
            i2 = Integer.MIN_VALUE;
        }
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "dvb:weight");
        if (attributeValue2 != null) {
            i3 = Integer.parseInt(attributeValue2);
        } else {
            i3 = 1;
        }
        String attributeValue3 = xmlPullParser.getAttributeValue((String) null, "serviceLocation");
        String s02 = s0(xmlPullParser, "BaseURL");
        if (UriUtil.b(s02)) {
            if (attributeValue3 == null) {
                attributeValue3 = s02;
            }
            return Lists.j(new BaseUrl(s02, attributeValue3, i2, i3));
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            BaseUrl baseUrl = list.get(i4);
            String d2 = UriUtil.d(baseUrl.f26274a, s02);
            if (attributeValue3 == null) {
                str = d2;
            } else {
                str = attributeValue3;
            }
            if (z2) {
                i2 = baseUrl.f26276c;
                i3 = baseUrl.f26277d;
                str = baseUrl.f26275b;
            }
            arrayList.add(new BaseUrl(d2, str, i2, i3));
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.util.UUID} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v31, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008a, code lost:
        r0 = null;
        r4 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> F(org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "schemeIdUri"
            r1 = 0
            java.lang.String r0 = r11.getAttributeValue(r1, r0)
            r2 = 0
            if (r0 == 0) goto L_0x0090
            java.lang.String r0 = com.google.common.base.Ascii.e(r0)
            r0.hashCode()
            int r3 = r0.hashCode()
            r4 = -1
            switch(r3) {
                case -1980789791: goto L_0x003b;
                case 489446379: goto L_0x0030;
                case 755418770: goto L_0x0025;
                case 1812765994: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x0045
        L_0x001a:
            java.lang.String r3 = "urn:mpeg:dash:mp4protection:2011"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0023
            goto L_0x0045
        L_0x0023:
            r4 = 3
            goto L_0x0045
        L_0x0025:
            java.lang.String r3 = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x002e
            goto L_0x0045
        L_0x002e:
            r4 = 2
            goto L_0x0045
        L_0x0030:
            java.lang.String r3 = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0039
            goto L_0x0045
        L_0x0039:
            r4 = 1
            goto L_0x0045
        L_0x003b:
            java.lang.String r3 = "urn:uuid:e2719d58-a985-b3c9-781a-b030af78d30e"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r4 = 0
        L_0x0045:
            switch(r4) {
                case 0: goto L_0x008d;
                case 1: goto L_0x0088;
                case 2: goto L_0x0085;
                case 3: goto L_0x0049;
                default: goto L_0x0048;
            }
        L_0x0048:
            goto L_0x0090
        L_0x0049:
            java.lang.String r0 = "value"
            java.lang.String r0 = r11.getAttributeValue(r1, r0)
            java.lang.String r3 = "default_KID"
            java.lang.String r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.b(r11, r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0083
            java.lang.String r4 = "00000000-0000-0000-0000-000000000000"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0083
            java.lang.String r4 = "\\s+"
            java.lang.String[] r3 = r3.split(r4)
            int r4 = r3.length
            java.util.UUID[] r4 = new java.util.UUID[r4]
            r5 = 0
        L_0x006d:
            int r6 = r3.length
            if (r5 >= r6) goto L_0x007b
            r6 = r3[r5]
            java.util.UUID r6 = java.util.UUID.fromString(r6)
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x006d
        L_0x007b:
            java.util.UUID r3 = com.google.android.exoplayer2.C.f22817b
            byte[] r4 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.b(r3, r4, r1)
            r5 = r1
            goto L_0x0094
        L_0x0083:
            r3 = r1
            goto L_0x0092
        L_0x0085:
            java.util.UUID r3 = com.google.android.exoplayer2.C.f22819d
            goto L_0x008a
        L_0x0088:
            java.util.UUID r3 = com.google.android.exoplayer2.C.f22820e
        L_0x008a:
            r0 = r1
            r4 = r0
            goto L_0x0093
        L_0x008d:
            java.util.UUID r3 = com.google.android.exoplayer2.C.f22818c
            goto L_0x008a
        L_0x0090:
            r0 = r1
            r3 = r0
        L_0x0092:
            r4 = r3
        L_0x0093:
            r5 = r4
        L_0x0094:
            r11.next()
            java.lang.String r6 = "clearkey:Laurl"
            boolean r6 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r11, r6)
            r7 = 4
            if (r6 == 0) goto L_0x00ac
            int r6 = r11.next()
            if (r6 != r7) goto L_0x00ac
            java.lang.String r5 = r11.getText()
            goto L_0x010f
        L_0x00ac:
            java.lang.String r6 = "ms:laurl"
            boolean r6 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r11, r6)
            if (r6 == 0) goto L_0x00bb
            java.lang.String r5 = "licenseUrl"
            java.lang.String r5 = r11.getAttributeValue(r1, r5)
            goto L_0x010f
        L_0x00bb:
            if (r4 != 0) goto L_0x00e7
            java.lang.String r6 = "pssh"
            boolean r6 = com.google.android.exoplayer2.util.XmlPullParserUtil.g(r11, r6)
            if (r6 == 0) goto L_0x00e7
            int r6 = r11.next()
            if (r6 != r7) goto L_0x00e7
            java.lang.String r3 = r11.getText()
            byte[] r3 = android.util.Base64.decode(r3, r2)
            java.util.UUID r4 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.f(r3)
            if (r4 != 0) goto L_0x00e3
            java.lang.String r3 = "MpdParser"
            java.lang.String r6 = "Skipping malformed cenc:pssh data"
            com.google.android.exoplayer2.util.Log.i(r3, r6)
            r3 = r4
            r4 = r1
            goto L_0x010f
        L_0x00e3:
            r9 = r4
            r4 = r3
            r3 = r9
            goto L_0x010f
        L_0x00e7:
            if (r4 != 0) goto L_0x010c
            java.util.UUID r6 = com.google.android.exoplayer2.C.f22820e
            boolean r8 = r6.equals(r3)
            if (r8 == 0) goto L_0x010c
            java.lang.String r8 = "mspr:pro"
            boolean r8 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r11, r8)
            if (r8 == 0) goto L_0x010c
            int r8 = r11.next()
            if (r8 != r7) goto L_0x010c
            java.lang.String r4 = r11.getText()
            byte[] r4 = android.util.Base64.decode(r4, r2)
            byte[] r4 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.a(r6, r4)
            goto L_0x010f
        L_0x010c:
            w(r11)
        L_0x010f:
            java.lang.String r6 = "ContentProtection"
            boolean r6 = com.google.android.exoplayer2.util.XmlPullParserUtil.d(r11, r6)
            if (r6 == 0) goto L_0x0094
            if (r3 == 0) goto L_0x0120
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r1 = new com.google.android.exoplayer2.drm.DrmInitData$SchemeData
            java.lang.String r11 = "video/mp4"
            r1.<init>(r3, r5, r11, r4)
        L_0x0120:
            android.util.Pair r11 = android.util.Pair.create(r0, r1)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.F(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    /* access modifiers changed from: protected */
    public int G(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if (com.unity3d.services.core.device.MimeTypes.BASE_TYPE_AUDIO.equals(attributeValue)) {
            return 1;
        }
        if (com.unity3d.services.core.device.MimeTypes.BASE_TYPE_VIDEO.equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        if ("image".equals(attributeValue)) {
            return 4;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public Pair<Long, EventMessage> O(XmlPullParser xmlPullParser, String str, String str2, long j2, long j3, ByteArrayOutputStream byteArrayOutputStream) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long X = X(xmlPullParser2, "id", 0);
        long X2 = X(xmlPullParser2, "duration", -9223372036854775807L);
        long X3 = X(xmlPullParser2, "presentationTime", 0);
        long R0 = Util.R0(X2, 1000, j2);
        long R02 = Util.R0(X3 - j3, 1000000, j2);
        String r02 = r0(xmlPullParser2, "messageData", (String) null);
        byte[] P = P(xmlPullParser2, byteArrayOutputStream);
        Long valueOf = Long.valueOf(R02);
        if (r02 != null) {
            P = Util.p0(r02);
        }
        return Pair.create(valueOf, d(str, str2, X, R0, P));
    }

    /* access modifiers changed from: protected */
    public byte[] P(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, Charsets.UTF_8.name());
        xmlPullParser.nextToken();
        while (!XmlPullParserUtil.d(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument((String) null, Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i2), xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeValue(i2));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: protected */
    public EventStream Q(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        long j2;
        ByteArrayOutputStream byteArrayOutputStream;
        ArrayList arrayList;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String r02 = r0(xmlPullParser2, "schemeIdUri", "");
        String r03 = r0(xmlPullParser2, AppMeasurementSdk.ConditionalUserProperty.VALUE, "");
        long X = X(xmlPullParser2, "timescale", 1);
        long X2 = X(xmlPullParser2, "presentationTimeOffset", 0);
        ArrayList arrayList2 = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(512);
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, "Event")) {
                byteArrayOutputStream = byteArrayOutputStream2;
                long j3 = X2;
                j2 = X2;
                arrayList = arrayList2;
                arrayList.add(O(xmlPullParser, r02, r03, X, j3, byteArrayOutputStream));
            } else {
                byteArrayOutputStream = byteArrayOutputStream2;
                j2 = X2;
                arrayList = arrayList2;
                w(xmlPullParser);
            }
            if (XmlPullParserUtil.d(xmlPullParser2, "EventStream")) {
                break;
            }
            arrayList2 = arrayList;
            byteArrayOutputStream2 = byteArrayOutputStream;
            X2 = j2;
        }
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Pair pair = (Pair) arrayList.get(i2);
            jArr[i2] = ((Long) pair.first).longValue();
            eventMessageArr[i2] = (EventMessage) pair.second;
        }
        return e(r02, r03, X, jArr, eventMessageArr);
    }

    /* access modifiers changed from: protected */
    public RangedUri T(XmlPullParser xmlPullParser) {
        return d0(xmlPullParser, "sourceURL", "range");
    }

    /* access modifiers changed from: protected */
    public String V(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return s0(xmlPullParser, "Label");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01e6 A[LOOP:0: B:23:0x00a4->B:79:0x01e6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01a2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.manifest.DashManifest Y(org.xmlpull.v1.XmlPullParser r47, android.net.Uri r48) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r46 = this;
            r14 = r46
            r12 = r47
            r0 = 0
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r2 = "profiles"
            java.lang.String[] r1 = r14.b0(r12, r2, r1)
            boolean r13 = r14.v(r1)
            java.lang.String r1 = "availabilityStartTime"
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r15 = H(r12, r1, r9)
            java.lang.String r1 = "mediaPresentationDuration"
            long r17 = M(r12, r1, r9)
            java.lang.String r1 = "minBufferTime"
            long r19 = M(r12, r1, r9)
            java.lang.String r1 = "type"
            r11 = 0
            java.lang.String r1 = r12.getAttributeValue(r11, r1)
            java.lang.String r2 = "dynamic"
            boolean r21 = r2.equals(r1)
            if (r21 == 0) goto L_0x0040
            java.lang.String r1 = "minimumUpdatePeriod"
            long r1 = M(r12, r1, r9)
            r22 = r1
            goto L_0x0042
        L_0x0040:
            r22 = r9
        L_0x0042:
            if (r21 == 0) goto L_0x004d
            java.lang.String r1 = "timeShiftBufferDepth"
            long r1 = M(r12, r1, r9)
            r24 = r1
            goto L_0x004f
        L_0x004d:
            r24 = r9
        L_0x004f:
            if (r21 == 0) goto L_0x005a
            java.lang.String r1 = "suggestedPresentationDelay"
            long r1 = M(r12, r1, r9)
            r26 = r1
            goto L_0x005c
        L_0x005a:
            r26 = r9
        L_0x005c:
            java.lang.String r1 = "publishTime"
            long r28 = H(r12, r1, r9)
            if (r21 == 0) goto L_0x0067
            r3 = 0
            goto L_0x0068
        L_0x0067:
            r3 = r9
        L_0x0068:
            com.google.android.exoplayer2.source.dash.manifest.BaseUrl r5 = new com.google.android.exoplayer2.source.dash.manifest.BaseUrl
            java.lang.String r6 = r48.toString()
            java.lang.String r7 = r48.toString()
            r8 = 1
            if (r13 == 0) goto L_0x0077
            r1 = 1
            goto L_0x007b
        L_0x0077:
            r30 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x007b:
            r5.<init>(r6, r7, r1, r8)
            com.google.android.exoplayer2.source.dash.manifest.BaseUrl[] r1 = new com.google.android.exoplayer2.source.dash.manifest.BaseUrl[r8]
            r1[r0] = r5
            java.util.ArrayList r7 = com.google.common.collect.Lists.j(r1)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            if (r21 == 0) goto L_0x0094
            r1 = r9
            goto L_0x0096
        L_0x0094:
            r1 = 0
        L_0x0096:
            r32 = r1
            r34 = r11
            r35 = r34
            r36 = r35
            r37 = r36
            r30 = 0
            r31 = 0
        L_0x00a4:
            r47.next()
            java.lang.String r0 = "BaseURL"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r12, r0)
            if (r0 == 0) goto L_0x00bf
            if (r30 != 0) goto L_0x00b7
            long r3 = r14.B(r12, r3)
            r30 = 1
        L_0x00b7:
            java.util.List r0 = r14.C(r12, r7, r13)
            r6.addAll(r0)
            goto L_0x00cd
        L_0x00bf:
            java.lang.String r0 = "ProgramInformation"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r12, r0)
            if (r0 == 0) goto L_0x00d9
            com.google.android.exoplayer2.source.dash.manifest.ProgramInformation r0 = r46.c0(r47)
            r34 = r0
        L_0x00cd:
            r41 = r6
            r43 = r7
            r44 = r9
            r14 = r11
            r42 = 1
            r11 = r5
            goto L_0x019a
        L_0x00d9:
            java.lang.String r0 = "UTCTiming"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r12, r0)
            if (r0 == 0) goto L_0x00e8
            com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement r0 = r46.w0(r47)
            r35 = r0
            goto L_0x00cd
        L_0x00e8:
            java.lang.String r0 = "Location"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r12, r0)
            if (r0 == 0) goto L_0x00ff
            java.lang.String r0 = r48.toString()
            java.lang.String r1 = r47.nextText()
            android.net.Uri r0 = com.google.android.exoplayer2.util.UriUtil.e(r0, r1)
            r36 = r0
            goto L_0x00cd
        L_0x00ff:
            java.lang.String r0 = "ServiceDescription"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r12, r0)
            if (r0 == 0) goto L_0x010e
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r0 = r46.q0(r47)
            r37 = r0
            goto L_0x00cd
        L_0x010e:
            java.lang.String r0 = "Period"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r12, r0)
            if (r0 == 0) goto L_0x0189
            if (r31 != 0) goto L_0x0189
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L_0x0120
            r2 = r6
            goto L_0x0121
        L_0x0120:
            r2 = r7
        L_0x0121:
            r0 = r46
            r1 = r47
            r38 = r3
            r3 = r32
            r40 = r5
            r41 = r6
            r5 = r38
            r43 = r7
            r42 = 1
            r7 = r15
            r44 = r9
            r9 = r24
            r14 = r11
            r11 = r13
            android.util.Pair r0 = r0.a0(r1, r2, r3, r5, r7, r9, r11)
            java.lang.Object r1 = r0.first
            com.google.android.exoplayer2.source.dash.manifest.Period r1 = (com.google.android.exoplayer2.source.dash.manifest.Period) r1
            long r2 = r1.f26314b
            int r4 = (r2 > r44 ? 1 : (r2 == r44 ? 0 : -1))
            if (r4 != 0) goto L_0x0168
            if (r21 == 0) goto L_0x014e
            r11 = r40
            r8 = 1
            goto L_0x0186
        L_0x014e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unable to determine start of period "
            r0.append(r1)
            int r1 = r40.size()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.c(r0, r14)
            throw r0
        L_0x0168:
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            int r0 = (r2 > r44 ? 1 : (r2 == r44 ? 0 : -1))
            if (r0 != 0) goto L_0x0179
            r11 = r40
            r9 = r44
            goto L_0x017f
        L_0x0179:
            long r4 = r1.f26314b
            long r9 = r4 + r2
            r11 = r40
        L_0x017f:
            r11.add(r1)
            r32 = r9
            r8 = r31
        L_0x0186:
            r31 = r8
            goto L_0x0198
        L_0x0189:
            r38 = r3
            r41 = r6
            r43 = r7
            r44 = r9
            r14 = r11
            r42 = 1
            r11 = r5
            w(r47)
        L_0x0198:
            r3 = r38
        L_0x019a:
            java.lang.String r0 = "MPD"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.d(r12, r0)
            if (r0 == 0) goto L_0x01e6
            int r0 = (r17 > r44 ? 1 : (r17 == r44 ? 0 : -1))
            if (r0 != 0) goto L_0x01b7
            int r0 = (r32 > r44 ? 1 : (r32 == r44 ? 0 : -1))
            if (r0 == 0) goto L_0x01ad
            r3 = r32
            goto L_0x01b9
        L_0x01ad:
            if (r21 == 0) goto L_0x01b0
            goto L_0x01b7
        L_0x01b0:
            java.lang.String r0 = "Unable to determine duration of static manifest."
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.c(r0, r14)
            throw r0
        L_0x01b7:
            r3 = r17
        L_0x01b9:
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x01df
            r0 = r46
            r1 = r15
            r5 = r19
            r7 = r21
            r8 = r22
            r38 = r11
            r10 = r24
            r12 = r26
            r14 = r28
            r16 = r34
            r17 = r35
            r18 = r37
            r19 = r36
            r20 = r38
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r0 = r0.g(r1, r3, r5, r7, r8, r10, r12, r14, r16, r17, r18, r19, r20)
            return r0
        L_0x01df:
            java.lang.String r0 = "No periods found."
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.c(r0, r14)
            throw r0
        L_0x01e6:
            r5 = r11
            r11 = r14
            r6 = r41
            r7 = r43
            r9 = r44
            r8 = 1
            r14 = r46
            goto L_0x00a4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.Y(org.xmlpull.v1.XmlPullParser, android.net.Uri):com.google.android.exoplayer2.source.dash.manifest.DashManifest");
    }

    /* access modifiers changed from: protected */
    public Pair<Period, Long> a0(XmlPullParser xmlPullParser, List<BaseUrl> list, long j2, long j3, long j4, long j5, boolean z2) throws XmlPullParserException, IOException {
        long j6;
        long j7;
        ArrayList arrayList;
        Object obj;
        ArrayList arrayList2;
        ArrayList arrayList3;
        long j8;
        long j9;
        SegmentBase l02;
        ArrayList arrayList4;
        DashManifestParser dashManifestParser = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue((String) null, "id");
        long M = M(xmlPullParser2, ViewProps.START, j2);
        long j10 = -9223372036854775807L;
        if (j4 != -9223372036854775807L) {
            j6 = j4 + M;
        } else {
            j6 = -9223372036854775807L;
        }
        long M2 = M(xmlPullParser2, "duration", -9223372036854775807L);
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        long j11 = j3;
        long j12 = -9223372036854775807L;
        SegmentBase segmentBase = null;
        Descriptor descriptor = null;
        boolean z3 = false;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, "BaseURL")) {
                if (!z3) {
                    j11 = dashManifestParser.B(xmlPullParser2, j11);
                    z3 = true;
                }
                arrayList7.addAll(dashManifestParser.C(xmlPullParser2, list, z2));
                arrayList = arrayList6;
                arrayList2 = arrayList7;
                j7 = j10;
                obj = obj2;
                arrayList3 = arrayList5;
            } else {
                List<BaseUrl> list2 = list;
                boolean z4 = z2;
                if (XmlPullParserUtil.f(xmlPullParser2, "AdaptationSet")) {
                    if (!arrayList7.isEmpty()) {
                        arrayList4 = arrayList7;
                    } else {
                        arrayList4 = list2;
                    }
                    j8 = j11;
                    arrayList2 = arrayList7;
                    arrayList3 = arrayList5;
                    arrayList3.add(y(xmlPullParser, arrayList4, segmentBase, M2, j11, j12, j6, j5, z2));
                    xmlPullParser2 = xmlPullParser;
                    arrayList = arrayList6;
                } else {
                    j8 = j11;
                    ArrayList arrayList8 = arrayList6;
                    arrayList2 = arrayList7;
                    arrayList3 = arrayList5;
                    xmlPullParser2 = xmlPullParser;
                    if (XmlPullParserUtil.f(xmlPullParser2, "EventStream")) {
                        ArrayList arrayList9 = arrayList8;
                        arrayList9.add(Q(xmlPullParser));
                        arrayList = arrayList9;
                    } else {
                        ArrayList arrayList10 = arrayList8;
                        if (XmlPullParserUtil.f(xmlPullParser2, "SegmentBase")) {
                            arrayList = arrayList10;
                            segmentBase = j0(xmlPullParser2, (SegmentBase.SingleSegmentBase) null);
                            obj = null;
                            j11 = j8;
                            j7 = -9223372036854775807L;
                        } else {
                            arrayList = arrayList10;
                            if (XmlPullParserUtil.f(xmlPullParser2, "SegmentList")) {
                                long B = B(xmlPullParser2, -9223372036854775807L);
                                obj = null;
                                l02 = k0(xmlPullParser, (SegmentBase.SegmentList) null, j6, M2, j8, B, j5);
                                j12 = B;
                                j11 = j8;
                                j7 = -9223372036854775807L;
                            } else {
                                obj = null;
                                if (XmlPullParserUtil.f(xmlPullParser2, "SegmentTemplate")) {
                                    long B2 = B(xmlPullParser2, -9223372036854775807L);
                                    j7 = -9223372036854775807L;
                                    l02 = l0(xmlPullParser, (SegmentBase.SegmentTemplate) null, ImmutableList.r(), j6, M2, j8, B2, j5);
                                    j12 = B2;
                                    j11 = j8;
                                } else {
                                    j9 = -9223372036854775807L;
                                    if (XmlPullParserUtil.f(xmlPullParser2, "AssetIdentifier")) {
                                        descriptor = I(xmlPullParser2, "AssetIdentifier");
                                    } else {
                                        w(xmlPullParser);
                                    }
                                    j11 = j8;
                                }
                            }
                            segmentBase = l02;
                        }
                    }
                }
                obj = null;
                j9 = -9223372036854775807L;
                j11 = j8;
            }
            if (XmlPullParserUtil.d(xmlPullParser2, "Period")) {
                return Pair.create(h(attributeValue, M, arrayList3, arrayList, descriptor), Long.valueOf(M2));
            }
            arrayList5 = arrayList3;
            arrayList7 = arrayList2;
            obj2 = obj;
            arrayList6 = arrayList;
            j10 = j7;
            dashManifestParser = this;
        }
    }

    /* access modifiers changed from: protected */
    public String[] b0(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return strArr;
        }
        return attributeValue.split(",");
    }

    /* access modifiers changed from: protected */
    public AdaptationSet c(int i2, int i3, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        return new AdaptationSet(i2, i3, list, list2, list3, list4);
    }

    /* access modifiers changed from: protected */
    public ProgramInformation c0(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str = null;
        String r02 = r0(xmlPullParser, "moreInformationURL", (String) null);
        String r03 = r0(xmlPullParser, "lang", (String) null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.f(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.f(xmlPullParser, "Copyright")) {
                str3 = xmlPullParser.nextText();
            } else {
                w(xmlPullParser);
            }
            String str4 = str3;
            if (XmlPullParserUtil.d(xmlPullParser, "ProgramInformation")) {
                return new ProgramInformation(str, str2, str4, r02, r03);
            }
            str3 = str4;
        }
    }

    /* access modifiers changed from: protected */
    public EventMessage d(String str, String str2, long j2, long j3, byte[] bArr) {
        return new EventMessage(str, str2, j3, j2, bArr);
    }

    /* access modifiers changed from: protected */
    public RangedUri d0(XmlPullParser xmlPullParser, String str, String str2) {
        long j2;
        long j3;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j3 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j2 = (Long.parseLong(split[1]) - j3) + 1;
                return i(attributeValue, j3, j2);
            }
        } else {
            j3 = 0;
        }
        j2 = -1;
        return i(attributeValue, j3, j2);
    }

    /* access modifiers changed from: protected */
    public EventStream e(String str, String str2, long j2, long[] jArr, EventMessage[] eventMessageArr) {
        return new EventStream(str, str2, j2, jArr, eventMessageArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v0, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v4, resolved type: com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v3, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v4, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v5, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v6, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v7, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v8, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v9, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v10, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r31v1 */
    /* JADX WARNING: type inference failed for: r31v2 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01ee A[LOOP:0: B:1:0x006a->B:53:0x01ee, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0198 A[EDGE_INSN: B:54:0x0198->B:45:0x0198 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo e0(org.xmlpull.v1.XmlPullParser r36, java.util.List<com.google.android.exoplayer2.source.dash.manifest.BaseUrl> r37, java.lang.String r38, java.lang.String r39, int r40, int r41, float r42, int r43, int r44, java.lang.String r45, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r46, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r47, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r48, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r49, com.google.android.exoplayer2.source.dash.manifest.SegmentBase r50, long r51, long r53, long r55, long r57, long r59, boolean r61) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r35 = this;
            r15 = r35
            r14 = r36
            java.lang.String r0 = "id"
            r1 = 0
            java.lang.String r16 = r14.getAttributeValue(r1, r0)
            java.lang.String r0 = "bandwidth"
            r2 = -1
            int r17 = U(r14, r0, r2)
            java.lang.String r0 = "mimeType"
            r2 = r38
            java.lang.String r18 = r0(r14, r0, r2)
            java.lang.String r0 = "codecs"
            r2 = r39
            java.lang.String r19 = r0(r14, r0, r2)
            java.lang.String r0 = "width"
            r2 = r40
            int r20 = U(r14, r0, r2)
            java.lang.String r0 = "height"
            r2 = r41
            int r21 = U(r14, r0, r2)
            r0 = r42
            float r22 = S(r14, r0)
            java.lang.String r0 = "audioSamplingRate"
            r2 = r44
            int r23 = U(r14, r0, r2)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r0 = r48
            r12.<init>(r0)
            java.util.ArrayList r9 = new java.util.ArrayList
            r10 = r49
            r9.<init>(r10)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r0 = 0
            r24 = r43
            r0 = r50
            r5 = r55
            r26 = r1
            r25 = 0
            r1 = r57
        L_0x006a:
            r36.next()
            java.lang.String r3 = "BaseURL"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r3)
            if (r3 == 0) goto L_0x0090
            if (r25 != 0) goto L_0x007d
            long r5 = r15.B(r14, r5)
            r25 = 1
        L_0x007d:
            r8 = r37
            r3 = r61
            java.util.List r4 = r15.C(r14, r8, r3)
            r7.addAll(r4)
        L_0x0088:
            r31 = r7
            r15 = r13
            r7 = r24
            r24 = r0
            goto L_0x00a6
        L_0x0090:
            r8 = r37
            r3 = r61
            java.lang.String r4 = "AudioChannelConfiguration"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r4)
            if (r4 == 0) goto L_0x00aa
            int r4 = r35.A(r36)
            r24 = r0
            r31 = r7
            r15 = r13
            r7 = r4
        L_0x00a6:
            r13 = r11
            r11 = r9
            goto L_0x0190
        L_0x00aa:
            java.lang.String r4 = "SegmentBase"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r4)
            if (r4 == 0) goto L_0x00b9
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) r0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = r15.j0(r14, r0)
            goto L_0x0088
        L_0x00b9:
            java.lang.String r4 = "SegmentList"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r4)
            if (r4 == 0) goto L_0x00f5
            long r27 = r15.B(r14, r1)
            r2 = r0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r2 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList) r2
            r0 = r35
            r1 = r36
            r3 = r51
            r29 = r5
            r5 = r53
            r31 = r7
            r7 = r29
            r32 = r9
            r9 = r27
            r33 = r11
            r34 = r12
            r11 = r59
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r0 = r0.k0(r1, r2, r3, r5, r7, r9, r11)
            r15 = r13
        L_0x00e5:
            r7 = r24
            r1 = r27
        L_0x00e9:
            r5 = r29
            r11 = r32
            r13 = r33
            r12 = r34
        L_0x00f1:
            r24 = r0
            goto L_0x0190
        L_0x00f5:
            r29 = r5
            r31 = r7
            r32 = r9
            r33 = r11
            r34 = r12
            java.lang.String r3 = "SegmentTemplate"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r3)
            if (r3 == 0) goto L_0x0124
            long r27 = r15.B(r14, r1)
            r2 = r0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r2 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate) r2
            r0 = r35
            r1 = r36
            r3 = r49
            r4 = r51
            r6 = r53
            r8 = r29
            r10 = r27
            r15 = r13
            r12 = r59
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r0 = r0.l0(r1, r2, r3, r4, r6, r8, r10, r12)
            goto L_0x00e5
        L_0x0124:
            r15 = r13
            java.lang.String r3 = "ContentProtection"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r3)
            if (r3 == 0) goto L_0x0145
            android.util.Pair r3 = r35.F(r36)
            java.lang.Object r4 = r3.first
            if (r4 == 0) goto L_0x0139
            r26 = r4
            java.lang.String r26 = (java.lang.String) r26
        L_0x0139:
            java.lang.Object r3 = r3.second
            if (r3 == 0) goto L_0x0142
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r3 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData) r3
            r15.add(r3)
        L_0x0142:
            r7 = r24
            goto L_0x00e9
        L_0x0145:
            java.lang.String r3 = "InbandEventStream"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r3)
            if (r4 == 0) goto L_0x015b
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r3 = I(r14, r3)
            r13 = r33
            r13.add(r3)
            r11 = r32
            r12 = r34
            goto L_0x018a
        L_0x015b:
            r13 = r33
            java.lang.String r3 = "EssentialProperty"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r3)
            if (r4 == 0) goto L_0x0171
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r3 = I(r14, r3)
            r12 = r34
            r12.add(r3)
            r11 = r32
            goto L_0x018a
        L_0x0171:
            r12 = r34
            java.lang.String r3 = "SupplementalProperty"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r3)
            if (r4 == 0) goto L_0x0185
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r3 = I(r14, r3)
            r11 = r32
            r11.add(r3)
            goto L_0x018a
        L_0x0185:
            r11 = r32
            w(r36)
        L_0x018a:
            r7 = r24
            r5 = r29
            goto L_0x00f1
        L_0x0190:
            java.lang.String r0 = "Representation"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.d(r14, r0)
            if (r0 == 0) goto L_0x01ee
            r0 = r35
            r1 = r16
            r2 = r18
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r7
            r7 = r23
            r8 = r17
            r9 = r45
            r10 = r46
            r27 = r11
            r11 = r47
            r28 = r12
            r12 = r19
            r29 = r13
            r13 = r28
            r14 = r27
            com.google.android.exoplayer2.Format r0 = r0.f(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            if (r24 == 0) goto L_0x01c2
            goto L_0x01c9
        L_0x01c2:
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r1 = new com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase
            r1.<init>()
            r24 = r1
        L_0x01c9:
            com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo r1 = new com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo
            boolean r2 = r31.isEmpty()
            if (r2 != 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r31 = r37
        L_0x01d4:
            r2 = -1
            r36 = r1
            r37 = r0
            r38 = r31
            r39 = r24
            r40 = r26
            r41 = r15
            r42 = r29
            r43 = r28
            r44 = r27
            r45 = r2
            r36.<init>(r37, r38, r39, r40, r41, r42, r43, r44, r45)
            return r1
        L_0x01ee:
            r10 = r49
            r9 = r11
            r11 = r13
            r13 = r15
            r0 = r24
            r15 = r35
            r24 = r7
            r7 = r31
            goto L_0x006a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.e0(org.xmlpull.v1.XmlPullParser, java.util.List, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, com.google.android.exoplayer2.source.dash.manifest.SegmentBase, long, long, long, long, long, boolean):com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo");
    }

    /* access modifiers changed from: protected */
    public Format f(String str, String str2, int i2, int i3, float f2, int i4, int i5, int i6, String str3, List<Descriptor> list, List<Descriptor> list2, String str4, List<Descriptor> list3, List<Descriptor> list4) {
        int i7;
        int i8;
        String str5 = str2;
        int i9 = i2;
        int i10 = i3;
        List<Descriptor> list5 = list;
        List<Descriptor> list6 = list3;
        String str6 = str4;
        String u2 = u(str2, str6);
        if ("audio/eac3".equals(u2)) {
            u2 = N(list4);
            if ("audio/eac3-joc".equals(u2)) {
                str6 = "ec+3";
            }
        }
        int p02 = p0(list5);
        int i02 = i0(list5) | f0(list2) | h0(list6) | h0(list4);
        Pair<Integer, Integer> t02 = t0(list6);
        String str7 = str;
        Format.Builder X = new Format.Builder().U(str).M(str2).g0(u2).K(str6).b0(i6).i0(p02).e0(i02).X(str3);
        int i11 = -1;
        if (t02 != null) {
            i7 = ((Integer) t02.first).intValue();
        } else {
            i7 = -1;
        }
        Format.Builder l02 = X.l0(i7);
        if (t02 != null) {
            i8 = ((Integer) t02.second).intValue();
        } else {
            i8 = -1;
        }
        Format.Builder m02 = l02.m0(i8);
        if (MimeTypes.s(u2)) {
            m02.n0(i2).S(i10).R(f2);
        } else if (MimeTypes.o(u2)) {
            m02.J(i4).h0(i5);
        } else if (MimeTypes.r(u2)) {
            if ("application/cea-608".equals(u2)) {
                i11 = D(list2);
            } else if ("application/cea-708".equals(u2)) {
                i11 = E(list2);
            }
            m02.H(i11);
        } else if (MimeTypes.p(u2)) {
            m02.n0(i2).S(i10);
        }
        return m02.G();
    }

    /* access modifiers changed from: protected */
    public int f0(List<Descriptor> list) {
        int u02;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Descriptor descriptor = list.get(i3);
            if (Ascii.a("urn:mpeg:dash:role:2011", descriptor.f26305a)) {
                u02 = g0(descriptor.f26306b);
            } else if (Ascii.a("urn:tva:metadata:cs:AudioPurposeCS:2007", descriptor.f26305a)) {
                u02 = u0(descriptor.f26306b);
            }
            i2 |= u02;
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public DashManifest g(long j2, long j3, long j4, boolean z2, long j5, long j6, long j7, long j8, ProgramInformation programInformation, UtcTimingElement utcTimingElement, ServiceDescriptionElement serviceDescriptionElement, Uri uri, List<Period> list) {
        return new DashManifest(j2, j3, j4, z2, j5, j6, j7, j8, programInformation, utcTimingElement, serviceDescriptionElement, uri, list);
    }

    /* access modifiers changed from: protected */
    public int g0(String str) {
        if (str == null) {
            return 0;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals(MediaTrack.ROLE_SUBTITLE)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1724546052:
                if (str.equals(MediaTrack.ROLE_DESCRIPTION)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1574842690:
                if (str.equals(MediaTrack.ROLE_FORCED_SUBTITLE)) {
                    c2 = 3;
                    break;
                }
                break;
            case -1408024454:
                if (str.equals(MediaTrack.ROLE_ALTERNATE)) {
                    c2 = 4;
                    break;
                }
                break;
            case -1396432756:
                if (str.equals("forced-subtitle")) {
                    c2 = 5;
                    break;
                }
                break;
            case 99825:
                if (str.equals(MediaTrack.ROLE_DUB)) {
                    c2 = 6;
                    break;
                }
                break;
            case 3343801:
                if (str.equals(MediaTrack.ROLE_MAIN)) {
                    c2 = 7;
                    break;
                }
                break;
            case 3530173:
                if (str.equals(MediaTrack.ROLE_SIGN)) {
                    c2 = 8;
                    break;
                }
                break;
            case 552573414:
                if (str.equals(MediaTrack.ROLE_CAPTION)) {
                    c2 = 9;
                    break;
                }
                break;
            case 899152809:
                if (str.equals(MediaTrack.ROLE_COMMENTARY)) {
                    c2 = 10;
                    break;
                }
                break;
            case 1629013393:
                if (str.equals(MediaTrack.ROLE_EMERGENCY)) {
                    c2 = 11;
                    break;
                }
                break;
            case 1855372047:
                if (str.equals(MediaTrack.ROLE_SUPPLEMENTARY)) {
                    c2 = 12;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 3:
            case 5:
                return 128;
            case 1:
                return 512;
            case 2:
                return 2048;
            case 4:
                return 2;
            case 6:
                return 16;
            case 7:
                return 1;
            case 8:
                return UserVerificationMethods.USER_VERIFY_HANDPRINT;
            case 9:
                return 64;
            case 10:
                return 8;
            case 11:
                return 32;
            case 12:
                return 4;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: protected */
    public Period h(String str, long j2, List<AdaptationSet> list, List<EventStream> list2, Descriptor descriptor) {
        return new Period(str, j2, list, list2, descriptor);
    }

    /* access modifiers changed from: protected */
    public int h0(List<Descriptor> list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (Ascii.a("http://dashif.org/guidelines/trickmode", list.get(i3).f26305a)) {
                i2 |= Http2.INITIAL_MAX_FRAME_SIZE;
            }
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public RangedUri i(String str, long j2, long j3) {
        return new RangedUri(str, j2, j3);
    }

    /* access modifiers changed from: protected */
    public int i0(List<Descriptor> list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Descriptor descriptor = list.get(i3);
            if (Ascii.a("urn:mpeg:dash:role:2011", descriptor.f26305a)) {
                i2 |= g0(descriptor.f26306b);
            }
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public Representation j(RepresentationInfo representationInfo, String str, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
        Format.Builder b2 = representationInfo.f26296a.b();
        if (str != null) {
            b2.W(str);
        }
        String str3 = representationInfo.f26299d;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = representationInfo.f26300e;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            r(arrayList3);
            s(arrayList3);
            b2.O(new DrmInitData(str2, (List<DrmInitData.SchemeData>) arrayList3));
        }
        ArrayList<Descriptor> arrayList4 = representationInfo.f26301f;
        arrayList4.addAll(arrayList2);
        return Representation.o(representationInfo.f26302g, b2.G(), representationInfo.f26297b, representationInfo.f26298c, arrayList4, representationInfo.f26303h, representationInfo.f26304i, (String) null);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SingleSegmentBase j0(XmlPullParser xmlPullParser, SegmentBase.SingleSegmentBase singleSegmentBase) throws XmlPullParserException, IOException {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SingleSegmentBase singleSegmentBase2 = singleSegmentBase;
        if (singleSegmentBase2 != null) {
            j2 = singleSegmentBase2.f26342b;
        } else {
            j2 = 1;
        }
        long X = X(xmlPullParser2, "timescale", j2);
        long j7 = 0;
        if (singleSegmentBase2 != null) {
            j3 = singleSegmentBase2.f26343c;
        } else {
            j3 = 0;
        }
        long X2 = X(xmlPullParser2, "presentationTimeOffset", j3);
        if (singleSegmentBase2 != null) {
            j4 = singleSegmentBase2.f26356d;
        } else {
            j4 = 0;
        }
        if (singleSegmentBase2 != null) {
            j7 = singleSegmentBase2.f26357e;
        }
        RangedUri rangedUri = null;
        String attributeValue = xmlPullParser2.getAttributeValue((String) null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j6 = Long.parseLong(split[0]);
            j5 = (Long.parseLong(split[1]) - j6) + 1;
        } else {
            j5 = j7;
            j6 = j4;
        }
        if (singleSegmentBase2 != null) {
            rangedUri = singleSegmentBase2.f26341a;
        }
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, "Initialization")) {
                rangedUri = T(xmlPullParser);
            } else {
                w(xmlPullParser);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser2, "SegmentBase"));
        return n(rangedUri, X, X2, j6, j5);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentList k(RangedUri rangedUri, long j2, long j3, long j4, long j5, List<SegmentBase.SegmentTimelineElement> list, long j6, List<RangedUri> list2, long j7, long j8) {
        return new SegmentBase.SegmentList(rangedUri, j2, j3, j4, j5, list, j6, list2, Util.F0(j7), Util.F0(j8));
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentList k0(XmlPullParser xmlPullParser, SegmentBase.SegmentList segmentList, long j2, long j3, long j4, long j5, long j6) throws XmlPullParserException, IOException {
        long j7;
        long j8;
        long j9;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentList segmentList2 = segmentList;
        long j10 = 1;
        if (segmentList2 != null) {
            j7 = segmentList2.f26342b;
        } else {
            j7 = 1;
        }
        long X = X(xmlPullParser2, "timescale", j7);
        if (segmentList2 != null) {
            j8 = segmentList2.f26343c;
        } else {
            j8 = 0;
        }
        long X2 = X(xmlPullParser2, "presentationTimeOffset", j8);
        if (segmentList2 != null) {
            j9 = segmentList2.f26345e;
        } else {
            j9 = -9223372036854775807L;
        }
        long X3 = X(xmlPullParser2, "duration", j9);
        if (segmentList2 != null) {
            j10 = segmentList2.f26344d;
        }
        long X4 = X(xmlPullParser2, "startNumber", j10);
        long t2 = t(j4, j5);
        List<SegmentBase.SegmentTimelineElement> list = null;
        List list2 = null;
        RangedUri rangedUri = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, "Initialization")) {
                rangedUri = T(xmlPullParser);
            } else if (XmlPullParserUtil.f(xmlPullParser2, "SegmentTimeline")) {
                list = m0(xmlPullParser, X, j3);
            } else if (XmlPullParserUtil.f(xmlPullParser2, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(n0(xmlPullParser));
            } else {
                w(xmlPullParser);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser2, "SegmentList"));
        if (segmentList2 != null) {
            if (rangedUri == null) {
                rangedUri = segmentList2.f26341a;
            }
            if (list == null) {
                list = segmentList2.f26346f;
            }
            if (list2 == null) {
                list2 = segmentList2.f26350j;
            }
        }
        return k(rangedUri, X, X2, X4, X3, list, t2, list2, j6, j2);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTemplate l(RangedUri rangedUri, long j2, long j3, long j4, long j5, long j6, List<SegmentBase.SegmentTimelineElement> list, long j7, UrlTemplate urlTemplate, UrlTemplate urlTemplate2, long j8, long j9) {
        return new SegmentBase.SegmentTemplate(rangedUri, j2, j3, j4, j5, j6, list, j7, urlTemplate, urlTemplate2, Util.F0(j8), Util.F0(j9));
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTemplate l0(XmlPullParser xmlPullParser, SegmentBase.SegmentTemplate segmentTemplate, List<Descriptor> list, long j2, long j3, long j4, long j5, long j6) throws XmlPullParserException, IOException {
        long j7;
        long j8;
        long j9;
        UrlTemplate urlTemplate;
        UrlTemplate urlTemplate2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentTemplate segmentTemplate2 = segmentTemplate;
        long j10 = 1;
        if (segmentTemplate2 != null) {
            j7 = segmentTemplate2.f26342b;
        } else {
            j7 = 1;
        }
        long X = X(xmlPullParser2, "timescale", j7);
        if (segmentTemplate2 != null) {
            j8 = segmentTemplate2.f26343c;
        } else {
            j8 = 0;
        }
        long X2 = X(xmlPullParser2, "presentationTimeOffset", j8);
        if (segmentTemplate2 != null) {
            j9 = segmentTemplate2.f26345e;
        } else {
            j9 = -9223372036854775807L;
        }
        long X3 = X(xmlPullParser2, "duration", j9);
        if (segmentTemplate2 != null) {
            j10 = segmentTemplate2.f26344d;
        }
        long X4 = X(xmlPullParser2, "startNumber", j10);
        long W = W(list);
        long t2 = t(j4, j5);
        List<SegmentBase.SegmentTimelineElement> list2 = null;
        if (segmentTemplate2 != null) {
            urlTemplate = segmentTemplate2.f26352k;
        } else {
            urlTemplate = null;
        }
        UrlTemplate v02 = v0(xmlPullParser2, "media", urlTemplate);
        if (segmentTemplate2 != null) {
            urlTemplate2 = segmentTemplate2.f26351j;
        } else {
            urlTemplate2 = null;
        }
        UrlTemplate v03 = v0(xmlPullParser2, "initialization", urlTemplate2);
        RangedUri rangedUri = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, "Initialization")) {
                rangedUri = T(xmlPullParser);
            } else if (XmlPullParserUtil.f(xmlPullParser2, "SegmentTimeline")) {
                list2 = m0(xmlPullParser, X, j3);
            } else {
                w(xmlPullParser);
            }
            if (XmlPullParserUtil.d(xmlPullParser2, "SegmentTemplate")) {
                break;
            }
        }
        if (segmentTemplate2 != null) {
            if (rangedUri == null) {
                rangedUri = segmentTemplate2.f26341a;
            }
            if (list2 == null) {
                list2 = segmentTemplate2.f26346f;
            }
        }
        return l(rangedUri, X, X2, X4, W, X3, list2, t2, v03, v02, j6, j2);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTimelineElement m(long j2, long j3) {
        return new SegmentBase.SegmentTimelineElement(j2, j3);
    }

    /* access modifiers changed from: protected */
    public List<SegmentBase.SegmentTimelineElement> m0(XmlPullParser xmlPullParser, long j2, long j3) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        ArrayList arrayList = new ArrayList();
        long j4 = 0;
        long j5 = -9223372036854775807L;
        boolean z2 = false;
        int i2 = 0;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, "S")) {
                long X = X(xmlPullParser2, "t", -9223372036854775807L);
                if (z2) {
                    j4 = b(arrayList, j4, j5, i2, X);
                }
                if (X == -9223372036854775807L) {
                    X = j4;
                }
                j5 = X(xmlPullParser2, "d", -9223372036854775807L);
                i2 = U(xmlPullParser2, "r", 0);
                j4 = X;
                z2 = true;
            } else {
                w(xmlPullParser);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser2, "SegmentTimeline"));
        if (z2) {
            b(arrayList, j4, j5, i2, Util.R0(j3, j2, 1000));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SingleSegmentBase n(RangedUri rangedUri, long j2, long j3, long j4, long j5) {
        return new SegmentBase.SingleSegmentBase(rangedUri, j2, j3, j4, j5);
    }

    /* access modifiers changed from: protected */
    public RangedUri n0(XmlPullParser xmlPullParser) {
        return d0(xmlPullParser, "media", "mediaRange");
    }

    /* access modifiers changed from: protected */
    public UtcTimingElement o(String str, String str2) {
        return new UtcTimingElement(str, str2);
    }

    /* access modifiers changed from: protected */
    public int o0(String str) {
        if (str == null) {
            return 0;
        }
        if (str.equals(MediaTrack.ROLE_FORCED_SUBTITLE) || str.equals("forced-subtitle")) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int p0(List<Descriptor> list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Descriptor descriptor = list.get(i3);
            if (Ascii.a("urn:mpeg:dash:role:2011", descriptor.f26305a)) {
                i2 |= o0(descriptor.f26306b);
            }
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public ServiceDescriptionElement q0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        float f2 = -3.4028235E38f;
        float f3 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, "Latency")) {
                j2 = X(xmlPullParser2, TouchesHelper.TARGET_KEY, -9223372036854775807L);
                j3 = X(xmlPullParser2, "min", -9223372036854775807L);
                j4 = X(xmlPullParser2, AppLovinMediationProvider.MAX, -9223372036854775807L);
            } else if (XmlPullParserUtil.f(xmlPullParser2, "PlaybackRate")) {
                f2 = R(xmlPullParser2, "min", -3.4028235E38f);
                f3 = R(xmlPullParser2, AppLovinMediationProvider.MAX, -3.4028235E38f);
            }
            long j5 = j2;
            long j6 = j3;
            long j7 = j4;
            float f4 = f2;
            float f5 = f3;
            if (XmlPullParserUtil.d(xmlPullParser2, "ServiceDescription")) {
                return new ServiceDescriptionElement(j5, j6, j7, f4, f5);
            }
            j2 = j5;
            j3 = j6;
            j4 = j7;
            f2 = f4;
            f3 = f5;
        }
    }

    /* access modifiers changed from: protected */
    public Pair<Integer, Integer> t0(List<Descriptor> list) {
        String str;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if ((Ascii.a("http://dashif.org/thumbnail_tile", descriptor.f26305a) || Ascii.a("http://dashif.org/guidelines/thumbnail_tile", descriptor.f26305a)) && (str = descriptor.f26306b) != null) {
                String[] W0 = Util.W0(str, "x");
                if (W0.length != 2) {
                    continue;
                } else {
                    try {
                        return Pair.create(Integer.valueOf(Integer.parseInt(W0[0])), Integer.valueOf(Integer.parseInt(W0[1])));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int u0(String str) {
        if (str == null) {
            return 0;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals(TraktV2.API_VERSION)) {
                    c2 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c2 = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 512;
            case 1:
                return 2048;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: protected */
    public UrlTemplate v0(XmlPullParser xmlPullParser, String str, UrlTemplate urlTemplate) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue != null) {
            return UrlTemplate.b(attributeValue);
        }
        return urlTemplate;
    }

    /* access modifiers changed from: protected */
    public UtcTimingElement w0(XmlPullParser xmlPullParser) {
        return o(xmlPullParser.getAttributeValue((String) null, "schemeIdUri"), xmlPullParser.getAttributeValue((String) null, AppMeasurementSdk.ConditionalUserProperty.VALUE));
    }

    /* renamed from: x */
    public DashManifest a(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.f26295a.newPullParser();
            newPullParser.setInput(inputStream, (String) null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return Y(newPullParser, uri);
            }
            throw ParserException.c("inputStream does not contain a valid media presentation description", (Throwable) null);
        } catch (XmlPullParserException e2) {
            throw ParserException.c((String) null, e2);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x030d A[LOOP:0: B:1:0x007c->B:69:0x030d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02ce A[EDGE_INSN: B:70:0x02ce->B:63:0x02ce ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.manifest.AdaptationSet y(org.xmlpull.v1.XmlPullParser r55, java.util.List<com.google.android.exoplayer2.source.dash.manifest.BaseUrl> r56, com.google.android.exoplayer2.source.dash.manifest.SegmentBase r57, long r58, long r60, long r62, long r64, long r66, boolean r68) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r54 = this;
            r15 = r54
            r14 = r55
            java.lang.String r0 = "id"
            r1 = -1
            int r27 = U(r14, r0, r1)
            int r0 = r54.G(r55)
            java.lang.String r2 = "mimeType"
            r13 = 0
            java.lang.String r28 = r14.getAttributeValue(r13, r2)
            java.lang.String r2 = "codecs"
            java.lang.String r29 = r14.getAttributeValue(r13, r2)
            java.lang.String r2 = "width"
            int r30 = U(r14, r2, r1)
            java.lang.String r2 = "height"
            int r31 = U(r14, r2, r1)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r32 = S(r14, r2)
            java.lang.String r2 = "audioSamplingRate"
            int r33 = U(r14, r2, r1)
            java.lang.String r12 = "lang"
            java.lang.String r2 = r14.getAttributeValue(r13, r12)
            java.lang.String r3 = "label"
            java.lang.String r3 = r14.getAttributeValue(r13, r3)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r34 = 0
            r35 = r57
            r36 = r0
            r38 = r2
            r39 = r3
            r41 = r13
            r37 = -1
            r40 = 0
            r2 = r60
            r0 = r62
        L_0x007c:
            r55.next()
            java.lang.String r13 = "BaseURL"
            boolean r13 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r13)
            if (r13 == 0) goto L_0x00bb
            if (r40 != 0) goto L_0x008f
            long r2 = r15.B(r14, r2)
            r40 = 1
        L_0x008f:
            r13 = r56
            r60 = r0
            r17 = r10
            r10 = r68
            java.util.List r0 = r15.C(r14, r13, r10)
            r4.addAll(r0)
        L_0x009e:
            r0 = r60
            r42 = r2
            r15 = r5
            r45 = r7
            r46 = r8
            r47 = r9
            r49 = r11
            r50 = r12
            r3 = r17
            r51 = r36
            r53 = r38
            r52 = 0
            r36 = r4
            r38 = r6
            goto L_0x02c6
        L_0x00bb:
            r13 = r56
            r60 = r0
            r17 = r10
            r10 = r68
            java.lang.String r0 = "ContentProtection"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r0)
            if (r0 == 0) goto L_0x00e1
            android.util.Pair r0 = r54.F(r55)
            java.lang.Object r1 = r0.first
            if (r1 == 0) goto L_0x00d7
            r41 = r1
            java.lang.String r41 = (java.lang.String) r41
        L_0x00d7:
            java.lang.Object r0 = r0.second
            if (r0 == 0) goto L_0x009e
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r0 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData) r0
            r11.add(r0)
            goto L_0x009e
        L_0x00e1:
            java.lang.String r0 = "ContentComponent"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r0)
            if (r0 == 0) goto L_0x011b
            r1 = 0
            java.lang.String r0 = r14.getAttributeValue(r1, r12)
            r15 = r38
            java.lang.String r0 = q(r15, r0)
            int r15 = r54.G(r55)
            r13 = r36
            int r13 = p(r13, r15)
            r53 = r0
            r52 = r1
            r42 = r2
            r36 = r4
            r15 = r5
            r38 = r6
            r45 = r7
            r46 = r8
            r47 = r9
            r49 = r11
            r50 = r12
            r51 = r13
            r3 = r17
        L_0x0117:
            r0 = r60
            goto L_0x02c6
        L_0x011b:
            r13 = r36
            r15 = r38
            r1 = 0
            java.lang.String r0 = "Role"
            boolean r16 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r0)
            if (r16 == 0) goto L_0x0130
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = I(r14, r0)
            r8.add(r0)
            goto L_0x013e
        L_0x0130:
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r0)
            if (r0 == 0) goto L_0x015b
            int r0 = r54.A(r55)
            r37 = r0
        L_0x013e:
            r52 = r1
            r42 = r2
            r36 = r4
            r38 = r6
            r45 = r7
            r46 = r8
            r47 = r9
            r49 = r11
            r50 = r12
            r51 = r13
            r53 = r15
            r3 = r17
            r0 = r60
            r15 = r5
            goto L_0x02c6
        L_0x015b:
            java.lang.String r0 = "Accessibility"
            boolean r16 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r0)
            if (r16 == 0) goto L_0x016b
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = I(r14, r0)
            r9.add(r0)
            goto L_0x013e
        L_0x016b:
            java.lang.String r0 = "EssentialProperty"
            boolean r16 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r0)
            if (r16 == 0) goto L_0x017b
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = I(r14, r0)
            r7.add(r0)
            goto L_0x013e
        L_0x017b:
            java.lang.String r0 = "SupplementalProperty"
            boolean r16 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r0)
            if (r16 == 0) goto L_0x018b
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = I(r14, r0)
            r6.add(r0)
            goto L_0x013e
        L_0x018b:
            java.lang.String r0 = "Representation"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r0)
            if (r0 == 0) goto L_0x0204
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L_0x019c
            r16 = r4
            goto L_0x019e
        L_0x019c:
            r16 = r56
        L_0x019e:
            r0 = r54
            r18 = r1
            r1 = r55
            r42 = r2
            r2 = r16
            r3 = r28
            r36 = r4
            r4 = r29
            r44 = r5
            r5 = r30
            r38 = r6
            r6 = r31
            r45 = r7
            r7 = r32
            r46 = r8
            r8 = r37
            r47 = r9
            r9 = r33
            r48 = r17
            r10 = r15
            r49 = r11
            r11 = r46
            r50 = r12
            r12 = r47
            r51 = r13
            r52 = r18
            r13 = r45
            r14 = r38
            r53 = r15
            r15 = r35
            r16 = r64
            r18 = r58
            r20 = r42
            r22 = r60
            r24 = r66
            r26 = r68
            com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo r0 = r0.e0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r20, r22, r24, r26)
            com.google.android.exoplayer2.Format r1 = r0.f26296a
            java.lang.String r1 = r1.f23071m
            int r1 = com.google.android.exoplayer2.util.MimeTypes.k(r1)
            r14 = r51
            int r1 = p(r14, r1)
            r15 = r44
            r15.add(r0)
            r14 = r55
            r51 = r1
            r3 = r48
            goto L_0x0117
        L_0x0204:
            r52 = r1
            r42 = r2
            r36 = r4
            r38 = r6
            r45 = r7
            r46 = r8
            r47 = r9
            r49 = r11
            r50 = r12
            r14 = r13
            r53 = r15
            r48 = r17
            r15 = r5
            java.lang.String r0 = "SegmentBase"
            r13 = r55
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r13, r0)
            if (r0 == 0) goto L_0x023b
            r0 = r35
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) r0
            r11 = r54
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = r11.j0(r13, r0)
            r35 = r0
            r51 = r14
            r3 = r48
            r0 = r60
            r14 = r13
            goto L_0x02c6
        L_0x023b:
            r11 = r54
            java.lang.String r0 = "SegmentList"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r13, r0)
            if (r0 == 0) goto L_0x026c
            r0 = r60
            long r16 = r11.B(r13, r0)
            r2 = r35
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r2 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList) r2
            r0 = r54
            r1 = r55
            r3 = r64
            r5 = r58
            r7 = r42
            r9 = r16
            r51 = r14
            r14 = r11
            r11 = r66
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r0 = r0.k0(r1, r2, r3, r5, r7, r9, r11)
            r35 = r0
            r14 = r13
        L_0x0267:
            r0 = r16
            r3 = r48
            goto L_0x02c6
        L_0x026c:
            r0 = r60
            r51 = r14
            r14 = r11
            java.lang.String r2 = "SegmentTemplate"
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r13, r2)
            if (r2 == 0) goto L_0x0299
            long r16 = r14.B(r13, r0)
            r2 = r35
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r2 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate) r2
            r0 = r54
            r1 = r55
            r3 = r38
            r4 = r64
            r6 = r58
            r8 = r42
            r10 = r16
            r14 = r13
            r12 = r66
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r0 = r0.l0(r1, r2, r3, r4, r6, r8, r10, r12)
            r35 = r0
            goto L_0x0267
        L_0x0299:
            r14 = r13
            java.lang.String r2 = "InbandEventStream"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r2)
            if (r3 == 0) goto L_0x02ac
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r2 = I(r14, r2)
            r3 = r48
            r3.add(r2)
            goto L_0x02c6
        L_0x02ac:
            r3 = r48
            java.lang.String r2 = "Label"
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.f(r14, r2)
            if (r2 == 0) goto L_0x02bd
            java.lang.String r2 = r54.V(r55)
            r39 = r2
            goto L_0x02c6
        L_0x02bd:
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.e(r55)
            if (r2 == 0) goto L_0x02c6
            r54.z(r55)
        L_0x02c6:
            java.lang.String r2 = "AdaptationSet"
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.d(r14, r2)
            if (r2 == 0) goto L_0x030d
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            r1 = 0
        L_0x02d8:
            int r2 = r15.size()
            if (r1 >= r2) goto L_0x02fa
            java.lang.Object r2 = r15.get(r1)
            com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo r2 = (com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo) r2
            r55 = r54
            r56 = r2
            r57 = r39
            r58 = r41
            r59 = r49
            r60 = r3
            com.google.android.exoplayer2.source.dash.manifest.Representation r2 = r55.j(r56, r57, r58, r59, r60)
            r0.add(r2)
            int r1 = r1 + 1
            goto L_0x02d8
        L_0x02fa:
            r55 = r54
            r56 = r27
            r57 = r51
            r58 = r0
            r59 = r47
            r60 = r45
            r61 = r38
            com.google.android.exoplayer2.source.dash.manifest.AdaptationSet r0 = r55.c(r56, r57, r58, r59, r60, r61)
            return r0
        L_0x030d:
            r10 = r3
            r5 = r15
            r4 = r36
            r6 = r38
            r2 = r42
            r7 = r45
            r8 = r46
            r9 = r47
            r11 = r49
            r12 = r50
            r36 = r51
            r13 = r52
            r38 = r53
            r15 = r54
            goto L_0x007c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.y(org.xmlpull.v1.XmlPullParser, java.util.List, com.google.android.exoplayer2.source.dash.manifest.SegmentBase, long, long, long, long, long, boolean):com.google.android.exoplayer2.source.dash.manifest.AdaptationSet");
    }

    /* access modifiers changed from: protected */
    public void z(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        w(xmlPullParser);
    }
}
