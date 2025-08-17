package com.google.android.datatransport.cct;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedDestination;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class CCTDestination implements EncodedDestination {

    /* renamed from: c  reason: collision with root package name */
    static final String f22266c;

    /* renamed from: d  reason: collision with root package name */
    static final String f22267d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f22268e;

    /* renamed from: f  reason: collision with root package name */
    private static final Set<Encoding> f22269f = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Encoding[]{Encoding.b("proto"), Encoding.b("json")})));

    /* renamed from: g  reason: collision with root package name */
    public static final CCTDestination f22270g;

    /* renamed from: h  reason: collision with root package name */
    public static final CCTDestination f22271h;

    /* renamed from: a  reason: collision with root package name */
    private final String f22272a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22273b;

    static {
        String a2 = StringMerger.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f22266c = a2;
        String a3 = StringMerger.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f22267d = a3;
        String a4 = StringMerger.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f22268e = a4;
        f22270g = new CCTDestination(a2, (String) null);
        f22271h = new CCTDestination(a3, a4);
    }

    public CCTDestination(String str, String str2) {
        this.f22272a = str;
        this.f22273b = str2;
    }

    public static CCTDestination c(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new CCTDestination(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    public Set<Encoding> a() {
        return f22269f;
    }

    public byte[] b() {
        String str = this.f22273b;
        if (str == null && this.f22272a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f22272a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    public String d() {
        return this.f22273b;
    }

    public String e() {
        return this.f22272a;
    }

    public byte[] getExtras() {
        return b();
    }

    public String getName() {
        return "cct";
    }
}
