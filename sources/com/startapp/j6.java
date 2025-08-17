package com.startapp;

import android.text.TextUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class j6 {

    /* renamed from: a  reason: collision with root package name */
    public final Node f34738a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f34739b = true;

    public j6(Node node) {
        this.f34738a = node;
    }

    public final List<j6> a(String str, String str2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = ((ArrayList) p.a(this.f34738a, str, str2, list)).iterator();
        while (it2.hasNext()) {
            arrayList.add(new j6((Node) it2.next()));
        }
        return arrayList;
    }

    public final j6 b(String str, String str2, List<String> list) {
        ArrayList arrayList = (ArrayList) p.a(this.f34738a, str, str2, (List<String>) null);
        Node node = arrayList.isEmpty() ? null : (Node) arrayList.get(0);
        if (node != null) {
            return new j6(node);
        }
        return null;
    }

    public final List<String> c(String str) {
        List<j6> a2 = a(str, (String) null, (List<String>) null);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = ((ArrayList) a2).iterator();
        while (it2.hasNext()) {
            String d2 = ((j6) it2.next()).d();
            if (!TextUtils.isEmpty(d2)) {
                arrayList.add(d2);
            }
        }
        return arrayList;
    }

    public final String d() {
        Node node = this.f34738a;
        if (node.getFirstChild() == null || node.getFirstChild().getNodeValue() == null) {
            return null;
        }
        return node.getFirstChild().getNodeValue().trim();
    }

    public List<String> e(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = ((ArrayList) d(str)).iterator();
        while (it2.hasNext()) {
            String d2 = ((j6) it2.next()).d();
            if (!TextUtils.isEmpty(d2)) {
                arrayList.add(d2);
            }
        }
        return arrayList;
    }

    public final String f(String str) {
        j6 b2 = b(str, (String) null, (List<String>) null);
        if (b2 == null) {
            return null;
        }
        return b2.d();
    }

    public j6(String str) throws ParserConfigurationException, SAXException, IOException {
        String replaceFirst = str.replaceFirst("<\\?.*\\?>", "");
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setCoalescing(true);
        newInstance.setExpandEntityReferences(false);
        this.f34738a = newInstance.newDocumentBuilder().parse(new InputSource(new StringReader(replaceFirst))).getFirstChild();
    }

    public final List<j6> d(String str) {
        return a("Tracking", "TrackingEvents", "event", Collections.singletonList(str));
    }

    public final List<j6> a(String str, String str2, String str3, List<String> list) {
        ArrayList arrayList = new ArrayList();
        j6 b2 = b(str2, (String) null, (List<String>) null);
        if (b2 == null) {
            return arrayList;
        }
        return b2.a(str, str3, list);
    }

    public final Integer b(String str) {
        try {
            String a2 = a(str);
            if (a2 != null) {
                return Integer.valueOf(Integer.parseInt(a2));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public final List<String> b(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = ((ArrayList) a(str, str2, (String) null, (List<String>) null)).iterator();
        while (it2.hasNext()) {
            String d2 = ((j6) it2.next()).d();
            if (!TextUtils.isEmpty(d2)) {
                arrayList.add(d2);
            }
        }
        return arrayList;
    }

    public List<j6> c() {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = ((ArrayList) a("Creative", "Creatives", (String) null, (List<String>) null)).iterator();
        while (it2.hasNext()) {
            j6 b2 = ((j6) it2.next()).b("Linear", (String) null, (List<String>) null);
            if (b2 != null) {
                arrayList.add(b2);
            }
        }
        return arrayList;
    }

    public final String a(String str) {
        Node namedItem = this.f34738a.getAttributes().getNamedItem(str);
        if (namedItem != null) {
            return namedItem.getNodeValue();
        }
        return null;
    }

    public final String a(String str, String str2) {
        j6 b2;
        j6 b3 = b(str2, (String) null, (List<String>) null);
        if (b3 == null || (b2 = b3.b(str, (String) null, (List<String>) null)) == null) {
            return null;
        }
        return b2.d();
    }

    public List<String> b() {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = ((ArrayList) d("creativeView")).iterator();
        while (it2.hasNext()) {
            String d2 = ((j6) it2.next()).d();
            if (!TextUtils.isEmpty(d2)) {
                arrayList.add(d2);
            }
        }
        return arrayList;
    }

    public List<j6> a() {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = ((ArrayList) a("Creative", "Creatives", (String) null, (List<String>) null)).iterator();
        while (it2.hasNext()) {
            arrayList.addAll(((j6) it2.next()).a("Companion", "CompanionAds", (String) null, (List<String>) null));
        }
        return arrayList;
    }
}
