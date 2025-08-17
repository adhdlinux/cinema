package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.jpeg.MotionPhotoDescription;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

final class XmpMotionPhotoDescriptionParser {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f24412a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f24413b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f24414c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    private XmpMotionPhotoDescriptionParser() {
    }

    public static MotionPhotoDescription a(String str) throws IOException {
        try {
            return b(str);
        } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
            Log.i("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static MotionPhotoDescription b(String str) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        if (XmlPullParserUtil.f(newPullParser, "x:xmpmeta")) {
            ImmutableList<MotionPhotoDescription.ContainerItem> r2 = ImmutableList.r();
            long j2 = -9223372036854775807L;
            do {
                newPullParser.next();
                if (XmlPullParserUtil.f(newPullParser, "rdf:Description")) {
                    if (!d(newPullParser)) {
                        return null;
                    }
                    j2 = e(newPullParser);
                    r2 = c(newPullParser);
                } else if (XmlPullParserUtil.f(newPullParser, "Container:Directory")) {
                    r2 = f(newPullParser, "Container", "Item");
                } else if (XmlPullParserUtil.f(newPullParser, "GContainer:Directory")) {
                    r2 = f(newPullParser, "GContainer", "GContainerItem");
                }
            } while (!XmlPullParserUtil.d(newPullParser, "x:xmpmeta"));
            if (r2.isEmpty()) {
                return null;
            }
            return new MotionPhotoDescription(j2, r2);
        }
        throw ParserException.a("Couldn't find xmp metadata", (Throwable) null);
    }

    private static ImmutableList<MotionPhotoDescription.ContainerItem> c(XmlPullParser xmlPullParser) {
        for (String a2 : f24414c) {
            String a3 = XmlPullParserUtil.a(xmlPullParser, a2);
            if (a3 != null) {
                return ImmutableList.t(new MotionPhotoDescription.ContainerItem("image/jpeg", "Primary", 0, 0), new MotionPhotoDescription.ContainerItem("video/mp4", "MotionPhoto", Long.parseLong(a3), 0));
            }
        }
        return ImmutableList.r();
    }

    private static boolean d(XmlPullParser xmlPullParser) {
        String[] strArr = f24412a;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String a2 = XmlPullParserUtil.a(xmlPullParser, strArr[i2]);
            if (a2 == null) {
                i2++;
            } else if (Integer.parseInt(a2) == 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private static long e(XmlPullParser xmlPullParser) {
        for (String a2 : f24413b) {
            String a3 = XmlPullParserUtil.a(xmlPullParser, a2);
            if (a3 != null) {
                long parseLong = Long.parseLong(a3);
                if (parseLong == -1) {
                    return -9223372036854775807L;
                }
                return parseLong;
            }
        }
        return -9223372036854775807L;
    }

    private static ImmutableList<MotionPhotoDescription.ContainerItem> f(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        long j2;
        long j3;
        ImmutableList.Builder k2 = ImmutableList.k();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, str3)) {
                String a2 = XmlPullParserUtil.a(xmlPullParser, str2 + ":Mime");
                String a3 = XmlPullParserUtil.a(xmlPullParser, str2 + ":Semantic");
                String a4 = XmlPullParserUtil.a(xmlPullParser, str2 + ":Length");
                String a5 = XmlPullParserUtil.a(xmlPullParser, str2 + ":Padding");
                if (a2 == null || a3 == null) {
                    return ImmutableList.r();
                }
                if (a4 != null) {
                    j2 = Long.parseLong(a4);
                } else {
                    j2 = 0;
                }
                if (a5 != null) {
                    j3 = Long.parseLong(a5);
                } else {
                    j3 = 0;
                }
                k2.d(new MotionPhotoDescription.ContainerItem(a2, a3, j2, j3));
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, str4));
        return k2.k();
    }
}
