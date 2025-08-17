package com.applovin.impl.sdk.utils;

import android.util.Xml;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final v f15926a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Stack<a> f15927b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public StringBuilder f15928c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f15929d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f15930e;

    private static class a extends r {
        a(String str, Map<String, String> map, r rVar) {
            super(str, map, rVar);
        }

        /* access modifiers changed from: package-private */
        public void a(r rVar) {
            if (rVar != null) {
                this.f15922c.add(rVar);
                return;
            }
            throw new IllegalArgumentException("None specified.");
        }

        /* access modifiers changed from: package-private */
        public void d(String str) {
            this.f15921b = str;
        }
    }

    s(m mVar) {
        if (mVar != null) {
            this.f15926a = mVar.A();
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    public static r a(String str, m mVar) throws SAXException {
        return new s(mVar).a(str);
    }

    /* access modifiers changed from: private */
    public Map<String, String> a(Attributes attributes) {
        if (attributes == null) {
            return Collections.emptyMap();
        }
        int length = attributes.getLength();
        HashMap hashMap = new HashMap(length);
        for (int i2 = 0; i2 < length; i2++) {
            hashMap.put(attributes.getQName(i2), attributes.getValue(i2));
        }
        return hashMap;
    }

    public r a(String str) throws SAXException {
        if (str != null) {
            this.f15928c = new StringBuilder();
            this.f15927b = new Stack<>();
            this.f15930e = null;
            Xml.parse(str, new ContentHandler() {
                public void characters(char[] cArr, int i2, int i3) {
                    String trim = new String(Arrays.copyOfRange(cArr, i2, i3)).trim();
                    if (StringUtils.isValidString(trim)) {
                        s.this.f15928c.append(trim);
                    }
                }

                public void endDocument() {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - s.this.f15929d;
                    if (v.a()) {
                        v a2 = s.this.f15926a;
                        a2.b("XmlParser", "Finished parsing in " + seconds + " seconds");
                    }
                }

                public void endElement(String str, String str2, String str3) {
                    s sVar = s.this;
                    a unused = sVar.f15930e = (a) sVar.f15927b.pop();
                    s.this.f15930e.d(s.this.f15928c.toString().trim());
                    s.this.f15928c.setLength(0);
                }

                public void endPrefixMapping(String str) {
                }

                public void ignorableWhitespace(char[] cArr, int i2, int i3) {
                }

                public void processingInstruction(String str, String str2) {
                }

                public void setDocumentLocator(Locator locator) {
                }

                public void skippedEntity(String str) {
                }

                public void startDocument() {
                    if (v.a()) {
                        s.this.f15926a.b("XmlParser", "Begin parsing...");
                    }
                    long unused = s.this.f15929d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                }

                public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
                    try {
                        a aVar = !s.this.f15927b.isEmpty() ? (a) s.this.f15927b.peek() : null;
                        a aVar2 = new a(str2, s.this.a(attributes), aVar);
                        if (aVar != null) {
                            aVar.a(aVar2);
                        }
                        s.this.f15927b.push(aVar2);
                    } catch (Exception e2) {
                        if (v.a()) {
                            v a2 = s.this.f15926a;
                            a2.b("XmlParser", "Unable to process element <" + str2 + ">", e2);
                        }
                        throw new SAXException("Failed to start element", e2);
                    }
                }

                public void startPrefixMapping(String str, String str2) {
                }
            });
            a aVar = this.f15930e;
            if (aVar != null) {
                return aVar;
            }
            throw new SAXException("Unable to parse XML into node");
        }
        throw new IllegalArgumentException("Unable to parse. No XML specified.");
    }
}
