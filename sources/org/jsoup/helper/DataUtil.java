package org.jsoup.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.internal.ConstrainableInputStream;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.XmlDeclaration;
import org.jsoup.parser.Parser;

public final class DataUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f41500a = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f41501b = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private static class BomCharset {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f41502a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f41503b;

        public BomCharset(String str, int i2) {
            this.f41502a = str;
            this.f41503b = i2;
        }
    }

    private DataUtil() {
    }

    static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[32768];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static BomCharset b(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        byte[] bArr = new byte[4];
        if (byteBuffer.remaining() >= 4) {
            byteBuffer.get(bArr);
            byteBuffer.rewind();
        }
        byte b2 = bArr[0];
        if ((b2 == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) || (b2 == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0)) {
            return new BomCharset("UTF-32", 0);
        }
        if ((b2 == -2 && bArr[1] == -1) || (b2 == -1 && bArr[1] == -2)) {
            return new BomCharset("UTF-16", 0);
        }
        if (b2 == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return new BomCharset("UTF-8", 3);
        }
        return null;
    }

    static ByteBuffer c() {
        return ByteBuffer.allocate(0);
    }

    static String d(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f41500a.matcher(str);
        if (matcher.find()) {
            return h(matcher.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    static String e() {
        StringBuilder sb = new StringBuilder(32);
        Random random = new Random();
        for (int i2 = 0; i2 < 32; i2++) {
            char[] cArr = f41501b;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    static Document f(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        boolean z2;
        if (inputStream == null) {
            return new Document(str2);
        }
        ConstrainableInputStream k2 = ConstrainableInputStream.k(inputStream, 32768, 0);
        k2.mark(5120);
        ByteBuffer g2 = g(k2, 5119);
        if (k2.read() == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        k2.reset();
        BomCharset b2 = b(g2);
        if (b2 != null) {
            str = b2.f41502a;
            k2.skip((long) b2.f41503b);
        }
        String str3 = "UTF-8";
        Document document = null;
        if (str == null) {
            Document e2 = parser.e(Charset.forName(str3).decode(g2).toString(), str2);
            Iterator it2 = e2.q0("meta[http-equiv=content-type], meta[charset]").iterator();
            String str4 = null;
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                if (element.p("http-equiv")) {
                    str4 = d(element.c("content"));
                }
                if (str4 == null && element.p("charset")) {
                    str4 = element.c("charset");
                    continue;
                }
                if (str4 != null) {
                    break;
                }
            }
            if (str4 == null && e2.i() > 0 && (e2.h(0) instanceof XmlDeclaration)) {
                XmlDeclaration xmlDeclaration = (XmlDeclaration) e2.h(0);
                if (xmlDeclaration.R().equals("xml")) {
                    str4 = xmlDeclaration.c("encoding");
                }
            }
            String h2 = h(str4);
            if (h2 != null && !h2.equalsIgnoreCase(str3)) {
                str = h2.trim().replaceAll("[\"']", "");
            } else if (z2) {
                document = e2;
            }
        } else {
            Validate.i(str, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
        }
        if (document == null) {
            if (str != null) {
                str3 = str;
            }
            document = parser.d(new BufferedReader(new InputStreamReader(k2, str3), 32768), str2);
            document.z0().b(str3);
        }
        k2.close();
        return document;
    }

    public static ByteBuffer g(InputStream inputStream, int i2) throws IOException {
        boolean z2;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.e(z2, "maxSize must be 0 (unlimited) or larger");
        return ConstrainableInputStream.k(inputStream, 32768, i2).f(i2);
    }

    private static String h(String str) {
        if (!(str == null || str.length() == 0)) {
            String replaceAll = str.trim().replaceAll("[\"']", "");
            try {
                if (Charset.isSupported(replaceAll)) {
                    return replaceAll;
                }
                String upperCase = replaceAll.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }
}
