package it.gmariotti.changelibs.library.parser;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import it.gmariotti.changelibs.library.Constants;
import it.gmariotti.changelibs.library.Util;
import it.gmariotti.changelibs.library.internal.ChangeLog;
import it.gmariotti.changelibs.library.internal.ChangeLogException;
import it.gmariotti.changelibs.library.internal.ChangeLogRow;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XmlParser extends BaseParser {

    /* renamed from: e  reason: collision with root package name */
    private static String f40216e = "XmlParser";

    /* renamed from: f  reason: collision with root package name */
    private static List<String> f40217f = new ArrayList<String>() {
        {
            add("changelogbug");
            add("changelogimprovement");
            add("changelogtext");
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private int f40218c;

    /* renamed from: d  reason: collision with root package name */
    private String f40219d;

    public XmlParser(Context context, int i2) {
        super(context);
        int i3 = Constants.f40183a;
        this.f40219d = null;
        this.f40218c = i2;
    }

    private void c(XmlPullParser xmlPullParser, ChangeLog changeLog, String str, int i2) throws Exception {
        if (xmlPullParser != null) {
            String name = xmlPullParser.getName();
            ChangeLogRow changeLogRow = new ChangeLogRow();
            changeLogRow.m(str);
            changeLogRow.l(i2);
            String attributeValue = xmlPullParser.getAttributeValue((String) null, "changeTextTitle");
            if (attributeValue != null) {
                changeLogRow.i(attributeValue);
            }
            String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "bulletedList");
            int i3 = 1;
            if (attributeValue2 == null) {
                changeLogRow.f(this.f40215b);
            } else if (attributeValue2.equals("true")) {
                changeLogRow.f(true);
            } else {
                changeLogRow.f(false);
            }
            if (xmlPullParser.next() == 4) {
                String text = xmlPullParser.getText();
                if (text != null) {
                    changeLogRow.e(text);
                    if (!name.equalsIgnoreCase("changelogbug")) {
                        if (name.equalsIgnoreCase("changelogimprovement")) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                    }
                    changeLogRow.k(i3);
                    xmlPullParser.nextTag();
                } else {
                    throw new ChangeLogException("ChangeLogText required in changeLogText node");
                }
            }
            changeLog.a(changeLogRow);
        }
    }

    public ChangeLog a() throws Exception {
        InputStream inputStream;
        try {
            if (this.f40219d == null) {
                inputStream = this.f40214a.getResources().openRawResource(this.f40218c);
            } else if (Util.a(this.f40214a)) {
                inputStream = new URL(this.f40219d).openStream();
            } else {
                inputStream = null;
            }
            if (inputStream != null) {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                newPullParser.setInput(inputStream, (String) null);
                newPullParser.nextTag();
                ChangeLog changeLog = new ChangeLog();
                b(newPullParser, changeLog);
                inputStream.close();
                return changeLog;
            }
            Log.d(f40216e, "Changelog.xml not found");
            throw new ChangeLogException("Changelog.xml not found");
        } catch (XmlPullParserException e2) {
            Log.d(f40216e, "XmlPullParseException while parsing changelog file", e2);
            throw e2;
        } catch (IOException e3) {
            Log.d(f40216e, "Error i/o with changelog.xml", e3);
            throw e3;
        }
    }

    /* access modifiers changed from: protected */
    public void b(XmlPullParser xmlPullParser, ChangeLog changeLog) throws Exception {
        if (xmlPullParser != null && changeLog != null) {
            xmlPullParser.require(2, (String) null, "changelog");
            String attributeValue = xmlPullParser.getAttributeValue((String) null, "bulletedList");
            if (attributeValue == null || attributeValue.equals("true")) {
                changeLog.c(true);
                this.f40215b = true;
            } else {
                changeLog.c(false);
                this.f40215b = false;
            }
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("changelogversion")) {
                    d(xmlPullParser, changeLog);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(org.xmlpull.v1.XmlPullParser r6, it.gmariotti.changelibs.library.internal.ChangeLog r7) throws java.lang.Exception {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "changelogversion"
            r1 = 2
            r2 = 0
            r6.require(r1, r2, r0)
            java.lang.String r0 = "versionName"
            java.lang.String r0 = r6.getAttributeValue(r2, r0)
            java.lang.String r3 = "versionCode"
            java.lang.String r3 = r6.getAttributeValue(r2, r3)
            if (r3 == 0) goto L_0x0024
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x001d }
            goto L_0x0025
        L_0x001d:
            java.lang.String r3 = f40216e
            java.lang.String r4 = "Error while parsing versionCode.It must be a numeric value. Check you file."
            android.util.Log.w(r3, r4)
        L_0x0024:
            r3 = 0
        L_0x0025:
            java.lang.String r4 = "changeDate"
            java.lang.String r2 = r6.getAttributeValue(r2, r4)
            if (r0 == 0) goto L_0x005a
            it.gmariotti.changelibs.library.internal.ChangeLogRowHeader r4 = new it.gmariotti.changelibs.library.internal.ChangeLogRowHeader
            r4.<init>()
            r4.m(r0)
            r4.g(r2)
            r7.a(r4)
        L_0x003b:
            int r2 = r6.next()
            r4 = 3
            if (r2 == r4) goto L_0x0059
            int r2 = r6.getEventType()
            if (r2 == r1) goto L_0x0049
            goto L_0x003b
        L_0x0049:
            java.lang.String r2 = r6.getName()
            java.util.List<java.lang.String> r4 = f40217f
            boolean r2 = r4.contains(r2)
            if (r2 == 0) goto L_0x003b
            r5.c(r6, r7, r0, r3)
            goto L_0x003b
        L_0x0059:
            return
        L_0x005a:
            it.gmariotti.changelibs.library.internal.ChangeLogException r6 = new it.gmariotti.changelibs.library.internal.ChangeLogException
            java.lang.String r7 = "VersionName required in changeLogVersion node"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: it.gmariotti.changelibs.library.parser.XmlParser.d(org.xmlpull.v1.XmlPullParser, it.gmariotti.changelibs.library.internal.ChangeLog):void");
    }

    public XmlParser(Context context, String str) {
        super(context);
        this.f40218c = Constants.f40183a;
        this.f40219d = str;
    }
}
