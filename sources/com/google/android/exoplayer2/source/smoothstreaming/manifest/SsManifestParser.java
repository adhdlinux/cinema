package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Util;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class SsManifestParser implements ParsingLoadable.Parser<SsManifest> {

    /* renamed from: a  reason: collision with root package name */
    private final XmlPullParserFactory f27161a;

    private static abstract class ElementParser {

        /* renamed from: a  reason: collision with root package name */
        private final String f27162a;

        /* renamed from: b  reason: collision with root package name */
        private final String f27163b;

        /* renamed from: c  reason: collision with root package name */
        private final ElementParser f27164c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Pair<String, Object>> f27165d = new LinkedList();

        public ElementParser(ElementParser elementParser, String str, String str2) {
            this.f27164c = elementParser;
            this.f27162a = str;
            this.f27163b = str2;
        }

        private ElementParser e(ElementParser elementParser, String str, String str2) {
            if ("QualityLevel".equals(str)) {
                return new QualityLevelParser(elementParser, str2);
            }
            if ("Protection".equals(str)) {
                return new ProtectionParser(elementParser, str2);
            }
            if ("StreamIndex".equals(str)) {
                return new StreamIndexParser(elementParser, str2);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void a(Object obj) {
        }

        /* access modifiers changed from: protected */
        public abstract Object b();

        /* access modifiers changed from: protected */
        public final Object c(String str) {
            for (int i2 = 0; i2 < this.f27165d.size(); i2++) {
                Pair pair = this.f27165d.get(i2);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            ElementParser elementParser = this.f27164c;
            if (elementParser == null) {
                return null;
            }
            return elementParser.c(str);
        }

        /* access modifiers changed from: protected */
        public boolean d(String str) {
            return false;
        }

        public final Object f(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f27163b.equals(name)) {
                        n(xmlPullParser);
                        z2 = true;
                    } else if (z2) {
                        if (i2 > 0) {
                            i2++;
                        } else if (d(name)) {
                            n(xmlPullParser);
                        } else {
                            ElementParser e2 = e(this, name, this.f27162a);
                            if (e2 == null) {
                                i2 = 1;
                            } else {
                                a(e2.f(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z2 && i2 == 0) {
                        o(xmlPullParser);
                    }
                } else if (!z2) {
                    continue;
                } else if (i2 > 0) {
                    i2--;
                } else {
                    String name2 = xmlPullParser.getName();
                    h(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        /* access modifiers changed from: protected */
        public final boolean g(XmlPullParser xmlPullParser, String str, boolean z2) {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                return Boolean.parseBoolean(attributeValue);
            }
            return z2;
        }

        /* access modifiers changed from: protected */
        public void h(XmlPullParser xmlPullParser) {
        }

        /* access modifiers changed from: protected */
        public final int i(XmlPullParser xmlPullParser, String str, int i2) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                return i2;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e2) {
                throw ParserException.c((String) null, e2);
            }
        }

        /* access modifiers changed from: protected */
        public final long j(XmlPullParser xmlPullParser, String str, long j2) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                return j2;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e2) {
                throw ParserException.c((String) null, e2);
            }
        }

        /* access modifiers changed from: protected */
        public final int k(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e2) {
                    throw ParserException.c((String) null, e2);
                }
            } else {
                throw new MissingFieldException(str);
            }
        }

        /* access modifiers changed from: protected */
        public final long l(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e2) {
                    throw ParserException.c((String) null, e2);
                }
            } else {
                throw new MissingFieldException(str);
            }
        }

        /* access modifiers changed from: protected */
        public final String m(XmlPullParser xmlPullParser, String str) throws MissingFieldException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(str);
        }

        /* access modifiers changed from: protected */
        public abstract void n(XmlPullParser xmlPullParser) throws ParserException;

        /* access modifiers changed from: protected */
        public void o(XmlPullParser xmlPullParser) {
        }

        /* access modifiers changed from: protected */
        public final void p(String str, Object obj) {
            this.f27165d.add(Pair.create(str, obj));
        }
    }

    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            super("Missing required field: " + str, (Throwable) null, true, 4);
        }
    }

    private static class ProtectionParser extends ElementParser {

        /* renamed from: e  reason: collision with root package name */
        private boolean f27166e;

        /* renamed from: f  reason: collision with root package name */
        private UUID f27167f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f27168g;

        public ProtectionParser(ElementParser elementParser, String str) {
            super(elementParser, str, "Protection");
        }

        private static TrackEncryptionBox[] q(byte[] bArr) {
            return new TrackEncryptionBox[]{new TrackEncryptionBox(true, (String) null, 8, r(bArr), 0, 0, (byte[]) null)};
        }

        private static byte[] r(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < bArr.length; i2 += 2) {
                sb.append((char) bArr[i2]);
            }
            String sb2 = sb.toString();
            byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
            t(decode, 0, 3);
            t(decode, 1, 2);
            t(decode, 4, 5);
            t(decode, 6, 7);
            return decode;
        }

        private static String s(String str) {
            if (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') {
                return str.substring(1, str.length() - 1);
            }
            return str;
        }

        private static void t(byte[] bArr, int i2, int i3) {
            byte b2 = bArr[i2];
            bArr[i2] = bArr[i3];
            bArr[i3] = b2;
        }

        public Object b() {
            UUID uuid = this.f27167f;
            return new SsManifest.ProtectionElement(uuid, PsshAtomUtil.a(uuid, this.f27168g), q(this.f27168g));
        }

        public boolean d(String str) {
            return "ProtectionHeader".equals(str);
        }

        public void h(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f27166e = false;
            }
        }

        public void n(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f27166e = true;
                this.f27167f = UUID.fromString(s(xmlPullParser.getAttributeValue((String) null, "SystemID")));
            }
        }

        public void o(XmlPullParser xmlPullParser) {
            if (this.f27166e) {
                this.f27168g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    private static class QualityLevelParser extends ElementParser {

        /* renamed from: e  reason: collision with root package name */
        private Format f27169e;

        public QualityLevelParser(ElementParser elementParser, String str) {
            super(elementParser, str, "QualityLevel");
        }

        private static List<byte[]> q(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] J = Util.J(str);
                byte[][] j2 = CodecSpecificDataUtil.j(J);
                if (j2 == null) {
                    arrayList.add(J);
                } else {
                    Collections.addAll(arrayList, j2);
                }
            }
            return arrayList;
        }

        private static String r(String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return MimeTypes.VIDEO_H264;
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return "audio/mp4a-latm";
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return "application/ttml+xml";
            }
            if (str.equalsIgnoreCase("ac-3") || str.equalsIgnoreCase("dac3")) {
                return "audio/ac3";
            }
            if (str.equalsIgnoreCase("ec-3") || str.equalsIgnoreCase("dec3")) {
                return "audio/eac3";
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return "audio/vnd.dts";
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (str.equalsIgnoreCase("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (str.equalsIgnoreCase("opus")) {
                return "audio/opus";
            }
            return null;
        }

        public Object b() {
            return this.f27169e;
        }

        public void n(XmlPullParser xmlPullParser) throws ParserException {
            int i2;
            Format.Builder builder = new Format.Builder();
            String r2 = r(m(xmlPullParser, "FourCC"));
            int intValue = ((Integer) c("Type")).intValue();
            if (intValue == 2) {
                builder.M("video/mp4").n0(k(xmlPullParser, "MaxWidth")).S(k(xmlPullParser, "MaxHeight")).V(q(xmlPullParser.getAttributeValue((String) null, "CodecPrivateData")));
            } else if (intValue == 1) {
                if (r2 == null) {
                    r2 = "audio/mp4a-latm";
                }
                int k2 = k(xmlPullParser, "Channels");
                int k3 = k(xmlPullParser, "SamplingRate");
                List<byte[]> q2 = q(xmlPullParser.getAttributeValue((String) null, "CodecPrivateData"));
                if (q2.isEmpty() && "audio/mp4a-latm".equals(r2)) {
                    q2 = Collections.singletonList(AacUtil.a(k3, k2));
                }
                builder.M("audio/mp4").J(k2).h0(k3).V(q2);
            } else if (intValue == 3) {
                String str = (String) c("Subtype");
                if (str != null) {
                    if (str.equals("CAPT")) {
                        i2 = 64;
                    } else if (str.equals("DESC")) {
                        i2 = 1024;
                    }
                    builder.M("application/mp4").e0(i2);
                }
                i2 = 0;
                builder.M("application/mp4").e0(i2);
            } else {
                builder.M("application/mp4");
            }
            this.f27169e = builder.U(xmlPullParser.getAttributeValue((String) null, "Index")).W((String) c("Name")).g0(r2).I(k(xmlPullParser, "Bitrate")).X((String) c("Language")).G();
        }
    }

    private static class SmoothStreamingMediaParser extends ElementParser {

        /* renamed from: e  reason: collision with root package name */
        private final List<SsManifest.StreamElement> f27170e = new LinkedList();

        /* renamed from: f  reason: collision with root package name */
        private int f27171f;

        /* renamed from: g  reason: collision with root package name */
        private int f27172g;

        /* renamed from: h  reason: collision with root package name */
        private long f27173h;

        /* renamed from: i  reason: collision with root package name */
        private long f27174i;

        /* renamed from: j  reason: collision with root package name */
        private long f27175j;

        /* renamed from: k  reason: collision with root package name */
        private int f27176k = -1;

        /* renamed from: l  reason: collision with root package name */
        private boolean f27177l;

        /* renamed from: m  reason: collision with root package name */
        private SsManifest.ProtectionElement f27178m = null;

        public SmoothStreamingMediaParser(ElementParser elementParser, String str) {
            super(elementParser, str, "SmoothStreamingMedia");
        }

        public void a(Object obj) {
            boolean z2;
            if (obj instanceof SsManifest.StreamElement) {
                this.f27170e.add((SsManifest.StreamElement) obj);
            } else if (obj instanceof SsManifest.ProtectionElement) {
                if (this.f27178m == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.g(z2);
                this.f27178m = (SsManifest.ProtectionElement) obj;
            }
        }

        public Object b() {
            int size = this.f27170e.size();
            SsManifest.StreamElement[] streamElementArr = new SsManifest.StreamElement[size];
            this.f27170e.toArray(streamElementArr);
            if (this.f27178m != null) {
                SsManifest.ProtectionElement protectionElement = this.f27178m;
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(protectionElement.f27142a, "video/mp4", protectionElement.f27143b));
                for (int i2 = 0; i2 < size; i2++) {
                    SsManifest.StreamElement streamElement = streamElementArr[i2];
                    int i3 = streamElement.f27145a;
                    if (i3 == 2 || i3 == 1) {
                        Format[] formatArr = streamElement.f27154j;
                        for (int i4 = 0; i4 < formatArr.length; i4++) {
                            formatArr[i4] = formatArr[i4].b().O(drmInitData).G();
                        }
                    }
                }
            }
            return new SsManifest(this.f27171f, this.f27172g, this.f27173h, this.f27174i, this.f27175j, this.f27176k, this.f27177l, this.f27178m, streamElementArr);
        }

        public void n(XmlPullParser xmlPullParser) throws ParserException {
            this.f27171f = k(xmlPullParser, "MajorVersion");
            this.f27172g = k(xmlPullParser, "MinorVersion");
            this.f27173h = j(xmlPullParser, "TimeScale", 10000000);
            this.f27174i = l(xmlPullParser, "Duration");
            this.f27175j = j(xmlPullParser, "DVRWindowLength", 0);
            this.f27176k = i(xmlPullParser, "LookaheadCount", -1);
            this.f27177l = g(xmlPullParser, "IsLive", false);
            p("TimeScale", Long.valueOf(this.f27173h));
        }
    }

    private static class StreamIndexParser extends ElementParser {

        /* renamed from: e  reason: collision with root package name */
        private final String f27179e;

        /* renamed from: f  reason: collision with root package name */
        private final List<Format> f27180f = new LinkedList();

        /* renamed from: g  reason: collision with root package name */
        private int f27181g;

        /* renamed from: h  reason: collision with root package name */
        private String f27182h;

        /* renamed from: i  reason: collision with root package name */
        private long f27183i;

        /* renamed from: j  reason: collision with root package name */
        private String f27184j;

        /* renamed from: k  reason: collision with root package name */
        private String f27185k;

        /* renamed from: l  reason: collision with root package name */
        private int f27186l;

        /* renamed from: m  reason: collision with root package name */
        private int f27187m;

        /* renamed from: n  reason: collision with root package name */
        private int f27188n;

        /* renamed from: o  reason: collision with root package name */
        private int f27189o;

        /* renamed from: p  reason: collision with root package name */
        private String f27190p;

        /* renamed from: q  reason: collision with root package name */
        private ArrayList<Long> f27191q;

        /* renamed from: r  reason: collision with root package name */
        private long f27192r;

        public StreamIndexParser(ElementParser elementParser, String str) {
            super(elementParser, str, "StreamIndex");
            this.f27179e = str;
        }

        private void q(XmlPullParser xmlPullParser) throws ParserException {
            int s2 = s(xmlPullParser);
            this.f27181g = s2;
            p("Type", Integer.valueOf(s2));
            if (this.f27181g == 3) {
                this.f27182h = m(xmlPullParser, "Subtype");
            } else {
                this.f27182h = xmlPullParser.getAttributeValue((String) null, "Subtype");
            }
            p("Subtype", this.f27182h);
            String attributeValue = xmlPullParser.getAttributeValue((String) null, "Name");
            this.f27184j = attributeValue;
            p("Name", attributeValue);
            this.f27185k = m(xmlPullParser, "Url");
            this.f27186l = i(xmlPullParser, "MaxWidth", -1);
            this.f27187m = i(xmlPullParser, "MaxHeight", -1);
            this.f27188n = i(xmlPullParser, "DisplayWidth", -1);
            this.f27189o = i(xmlPullParser, "DisplayHeight", -1);
            String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "Language");
            this.f27190p = attributeValue2;
            p("Language", attributeValue2);
            long i2 = (long) i(xmlPullParser, "TimeScale", -1);
            this.f27183i = i2;
            if (i2 == -1) {
                this.f27183i = ((Long) c("TimeScale")).longValue();
            }
            this.f27191q = new ArrayList<>();
        }

        private void r(XmlPullParser xmlPullParser) throws ParserException {
            int size = this.f27191q.size();
            long j2 = j(xmlPullParser, "t", -9223372036854775807L);
            int i2 = 1;
            if (j2 == -9223372036854775807L) {
                if (size == 0) {
                    j2 = 0;
                } else if (this.f27192r != -1) {
                    j2 = this.f27191q.get(size - 1).longValue() + this.f27192r;
                } else {
                    throw ParserException.c("Unable to infer start time", (Throwable) null);
                }
            }
            this.f27191q.add(Long.valueOf(j2));
            this.f27192r = j(xmlPullParser, "d", -9223372036854775807L);
            long j3 = j(xmlPullParser, "r", 1);
            if (j3 <= 1 || this.f27192r != -9223372036854775807L) {
                while (true) {
                    long j4 = (long) i2;
                    if (j4 < j3) {
                        this.f27191q.add(Long.valueOf((this.f27192r * j4) + j2));
                        i2++;
                    } else {
                        return;
                    }
                }
            } else {
                throw ParserException.c("Repeated chunk with unspecified duration", (Throwable) null);
            }
        }

        private int s(XmlPullParser xmlPullParser) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, "Type");
            if (attributeValue == null) {
                throw new MissingFieldException("Type");
            } else if (MimeTypes.BASE_TYPE_AUDIO.equalsIgnoreCase(attributeValue)) {
                return 1;
            } else {
                if (MimeTypes.BASE_TYPE_VIDEO.equalsIgnoreCase(attributeValue)) {
                    return 2;
                }
                if ("text".equalsIgnoreCase(attributeValue)) {
                    return 3;
                }
                throw ParserException.c("Invalid key value[" + attributeValue + "]", (Throwable) null);
            }
        }

        public void a(Object obj) {
            if (obj instanceof Format) {
                this.f27180f.add((Format) obj);
            }
        }

        public Object b() {
            Format[] formatArr = new Format[this.f27180f.size()];
            this.f27180f.toArray(formatArr);
            SsManifest.StreamElement streamElement = r2;
            SsManifest.StreamElement streamElement2 = new SsManifest.StreamElement(this.f27179e, this.f27185k, this.f27181g, this.f27182h, this.f27183i, this.f27184j, this.f27186l, this.f27187m, this.f27188n, this.f27189o, this.f27190p, formatArr, this.f27191q, this.f27192r);
            return streamElement;
        }

        public boolean d(String str) {
            return "c".equals(str);
        }

        public void n(XmlPullParser xmlPullParser) throws ParserException {
            if ("c".equals(xmlPullParser.getName())) {
                r(xmlPullParser);
            } else {
                q(xmlPullParser);
            }
        }
    }

    public SsManifestParser() {
        try {
            this.f27161a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* renamed from: b */
    public SsManifest a(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.f27161a.newPullParser();
            newPullParser.setInput(inputStream, (String) null);
            return (SsManifest) new SmoothStreamingMediaParser((ElementParser) null, uri.toString()).f(newPullParser);
        } catch (XmlPullParserException e2) {
            throw ParserException.c((String) null, e2);
        }
    }
}
