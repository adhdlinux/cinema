package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R$styleable;
import androidx.core.provider.FontRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class FontResourcesParserCompat {

    static class Api21Impl {
        private Api21Impl() {
        }

        static int a(TypedArray typedArray, int i2) {
            return typedArray.getType(i2);
        }
    }

    public interface FamilyResourceEntry {
    }

    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {

        /* renamed from: a  reason: collision with root package name */
        private final FontFileResourceEntry[] f2501a;

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.f2501a = fontFileResourceEntryArr;
        }

        public FontFileResourceEntry[] a() {
            return this.f2501a;
        }
    }

    public static final class FontFileResourceEntry {

        /* renamed from: a  reason: collision with root package name */
        private final String f2502a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2503b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f2504c;

        /* renamed from: d  reason: collision with root package name */
        private final String f2505d;

        /* renamed from: e  reason: collision with root package name */
        private final int f2506e;

        /* renamed from: f  reason: collision with root package name */
        private final int f2507f;

        public FontFileResourceEntry(String str, int i2, boolean z2, String str2, int i3, int i4) {
            this.f2502a = str;
            this.f2503b = i2;
            this.f2504c = z2;
            this.f2505d = str2;
            this.f2506e = i3;
            this.f2507f = i4;
        }

        public String a() {
            return this.f2502a;
        }

        public int b() {
            return this.f2507f;
        }

        public int c() {
            return this.f2506e;
        }

        public String d() {
            return this.f2505d;
        }

        public int e() {
            return this.f2503b;
        }

        public boolean f() {
            return this.f2504c;
        }
    }

    public static final class ProviderResourceEntry implements FamilyResourceEntry {

        /* renamed from: a  reason: collision with root package name */
        private final FontRequest f2508a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2509b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2510c;

        /* renamed from: d  reason: collision with root package name */
        private final String f2511d;

        public ProviderResourceEntry(FontRequest fontRequest, int i2, int i3, String str) {
            this.f2508a = fontRequest;
            this.f2510c = i2;
            this.f2509b = i3;
            this.f2511d = str;
        }

        public int a() {
            return this.f2510c;
        }

        public FontRequest b() {
            return this.f2508a;
        }

        public String c() {
            return this.f2511d;
        }

        public int d() {
            return this.f2509b;
        }
    }

    private FontResourcesParserCompat() {
    }

    private static int a(TypedArray typedArray, int i2) {
        return Api21Impl.a(typedArray, i2);
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry b(org.xmlpull.v1.XmlPullParser r3, android.content.res.Resources r4) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        L_0x0000:
            int r0 = r3.next()
            r1 = 2
            if (r0 == r1) goto L_0x000b
            r2 = 1
            if (r0 == r2) goto L_0x000b
            goto L_0x0000
        L_0x000b:
            if (r0 != r1) goto L_0x0012
            androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r3 = d(r3, r4)
            return r3
        L_0x0012:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r4 = "No start tag found"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.FontResourcesParserCompat.b(org.xmlpull.v1.XmlPullParser, android.content.res.Resources):androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry");
    }

    public static List<List<byte[]>> c(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i2)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static FamilyResourceEntry d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, (String) null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static FamilyResourceEntry e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.f2303h);
        String string = obtainAttributes.getString(R$styleable.f2304i);
        String string2 = obtainAttributes.getString(R$styleable.f2308m);
        String string3 = obtainAttributes.getString(R$styleable.f2309n);
        int resourceId = obtainAttributes.getResourceId(R$styleable.f2305j, 0);
        int integer = obtainAttributes.getInteger(R$styleable.f2306k, 1);
        int integer2 = obtainAttributes.getInteger(R$styleable.f2307l, 500);
        String string4 = obtainAttributes.getString(R$styleable.f2310o);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(f(xmlPullParser, resources));
                    } else {
                        g(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[0]));
        }
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new ProviderResourceEntry(new FontRequest(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
    }

    private static FontFileResourceEntry f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        boolean z2;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.f2311p);
        int i2 = R$styleable.f2320y;
        if (!obtainAttributes.hasValue(i2)) {
            i2 = R$styleable.f2313r;
        }
        int i3 = obtainAttributes.getInt(i2, 400);
        int i4 = R$styleable.f2318w;
        if (!obtainAttributes.hasValue(i4)) {
            i4 = R$styleable.f2314s;
        }
        if (1 == obtainAttributes.getInt(i4, 0)) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i5 = R$styleable.f2321z;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = R$styleable.f2315t;
        }
        int i6 = R$styleable.f2319x;
        if (!obtainAttributes.hasValue(i6)) {
            i6 = R$styleable.f2316u;
        }
        String string = obtainAttributes.getString(i6);
        int i7 = obtainAttributes.getInt(i5, 0);
        int i8 = R$styleable.f2317v;
        if (!obtainAttributes.hasValue(i8)) {
            i8 = R$styleable.f2312q;
        }
        int resourceId = obtainAttributes.getResourceId(i8, 0);
        String string2 = obtainAttributes.getString(i8);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new FontFileResourceEntry(string2, i3, z2, string, i7, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }
}
