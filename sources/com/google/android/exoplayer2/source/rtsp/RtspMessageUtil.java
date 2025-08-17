package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class RtspMessageUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f26899a = Pattern.compile("([A-Z_]+) (.*) RTSP/1\\.0");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f26900b = Pattern.compile("RTSP/1\\.0 (\\d+) (.+)");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f26901c = Pattern.compile("Content-Length:\\s?(\\d+)", 2);

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f26902d = Pattern.compile("([\\w$\\-_.+]+)(?:;\\s?timeout=(\\d+))?");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f26903e = Pattern.compile("Digest realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\",\\s?(?:domain=\"(.+)\",\\s?)?nonce=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"(?:,\\s?opaque=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\")?");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f26904f = Pattern.compile("Basic realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"");

    /* renamed from: g  reason: collision with root package name */
    private static final String f26905g = new String(new byte[]{10});

    /* renamed from: h  reason: collision with root package name */
    private static final String f26906h = new String(new byte[]{13, 10});

    public static final class RtspAuthUserInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f26907a;

        /* renamed from: b  reason: collision with root package name */
        public final String f26908b;

        public RtspAuthUserInfo(String str, String str2) {
            this.f26907a = str;
            this.f26908b = str2;
        }
    }

    public static final class RtspSessionHeader {

        /* renamed from: a  reason: collision with root package name */
        public final String f26909a;

        /* renamed from: b  reason: collision with root package name */
        public final long f26910b;

        public RtspSessionHeader(String str, long j2) {
            this.f26909a = str;
            this.f26910b = j2;
        }
    }

    private RtspMessageUtil() {
    }

    public static void a(boolean z2, String str) throws ParserException {
        if (!z2) {
            throw ParserException.c(str, (Throwable) null);
        }
    }

    public static byte[] b(List<String> list) {
        return Joiner.on(f26906h).join((Iterable<? extends Object>) list).getBytes(RtspMessageChannel.f26880h);
    }

    private static String c(int i2) {
        if (i2 == 200) {
            return "OK";
        }
        if (i2 == 461) {
            return "Unsupported Transport";
        }
        if (i2 == 500) {
            return "Internal Server Error";
        }
        if (i2 == 505) {
            return "RTSP Version Not Supported";
        }
        if (i2 == 301) {
            return "Move Permanently";
        }
        if (i2 == 302) {
            return "Move Temporarily";
        }
        if (i2 == 400) {
            return "Bad Request";
        }
        if (i2 == 401) {
            return "Unauthorized";
        }
        if (i2 == 404) {
            return "Not Found";
        }
        if (i2 == 405) {
            return "Method Not Allowed";
        }
        switch (i2) {
            case 454:
                return "Session Not Found";
            case 455:
                return "Method Not Valid In This State";
            case 456:
                return "Header Field Not Valid";
            case 457:
                return "Invalid Range";
            default:
                throw new IllegalArgumentException();
        }
    }

    public static byte[] d(String str) {
        return str.getBytes(RtspMessageChannel.f26880h);
    }

    public static boolean e(List<String> list) {
        return f26900b.matcher(list.get(0)).matches();
    }

    public static boolean f(String str) {
        if (f26899a.matcher(str).matches() || f26900b.matcher(str).matches()) {
            return true;
        }
        return false;
    }

    public static long g(String str) throws ParserException {
        try {
            Matcher matcher = f26901c.matcher(str);
            if (matcher.find()) {
                return Long.parseLong((String) Assertions.e(matcher.group(1)));
            }
            return -1;
        } catch (NumberFormatException e2) {
            throw ParserException.c(str, e2);
        }
    }

    public static int h(String str) throws ParserException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            throw ParserException.c(str, e2);
        }
    }

    private static int i(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1881579439:
                if (str.equals("RECORD")) {
                    c2 = 0;
                    break;
                }
                break;
            case -880847356:
                if (str.equals("TEARDOWN")) {
                    c2 = 1;
                    break;
                }
                break;
            case -702888512:
                if (str.equals("GET_PARAMETER")) {
                    c2 = 2;
                    break;
                }
                break;
            case -531492226:
                if (str.equals("OPTIONS")) {
                    c2 = 3;
                    break;
                }
                break;
            case -84360524:
                if (str.equals("PLAY_NOTIFY")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2458420:
                if (str.equals("PLAY")) {
                    c2 = 5;
                    break;
                }
                break;
            case 6481884:
                if (str.equals("REDIRECT")) {
                    c2 = 6;
                    break;
                }
                break;
            case 71242700:
                if (str.equals("SET_PARAMETER")) {
                    c2 = 7;
                    break;
                }
                break;
            case 75902422:
                if (str.equals("PAUSE")) {
                    c2 = 8;
                    break;
                }
                break;
            case 78791261:
                if (str.equals("SETUP")) {
                    c2 = 9;
                    break;
                }
                break;
            case 133006441:
                if (str.equals("ANNOUNCE")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1800840907:
                if (str.equals("DESCRIBE")) {
                    c2 = 11;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 8;
            case 1:
                return 12;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 7;
            case 5:
                return 6;
            case 6:
                return 9;
            case 7:
                return 11;
            case 8:
                return 5;
            case 9:
                return 10;
            case 10:
                return 1;
            case 11:
                return 2;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static ImmutableList<Integer> j(String str) {
        if (str == null) {
            return ImmutableList.r();
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (String i2 : Util.W0(str, ",\\s?")) {
            builder.d(Integer.valueOf(i(i2)));
        }
        return builder.k();
    }

    public static RtspRequest k(List<String> list) {
        boolean z2 = false;
        Matcher matcher = f26899a.matcher(list.get(0));
        Assertions.a(matcher.matches());
        int i2 = i((String) Assertions.e(matcher.group(1)));
        Uri parse = Uri.parse((String) Assertions.e(matcher.group(2)));
        int indexOf = list.indexOf("");
        if (indexOf > 0) {
            z2 = true;
        }
        Assertions.a(z2);
        return new RtspRequest(parse, i2, new RtspHeaders.Builder().c(list.subList(1, indexOf)).e(), Joiner.on(f26906h).join((Iterable<? extends Object>) list.subList(indexOf + 1, list.size())));
    }

    public static RtspResponse l(List<String> list) {
        boolean z2 = false;
        Matcher matcher = f26900b.matcher(list.get(0));
        Assertions.a(matcher.matches());
        int parseInt = Integer.parseInt((String) Assertions.e(matcher.group(1)));
        int indexOf = list.indexOf("");
        if (indexOf > 0) {
            z2 = true;
        }
        Assertions.a(z2);
        return new RtspResponse(parseInt, new RtspHeaders.Builder().c(list.subList(1, indexOf)).e(), Joiner.on(f26906h).join((Iterable<? extends Object>) list.subList(indexOf + 1, list.size())));
    }

    public static RtspSessionHeader m(String str) throws ParserException {
        long j2;
        Matcher matcher = f26902d.matcher(str);
        if (matcher.matches()) {
            String str2 = (String) Assertions.e(matcher.group(1));
            String group = matcher.group(2);
            if (group != null) {
                try {
                    j2 = ((long) Integer.parseInt(group)) * 1000;
                } catch (NumberFormatException e2) {
                    throw ParserException.c(str, e2);
                }
            } else {
                j2 = 60000;
            }
            return new RtspSessionHeader(str2, j2);
        }
        throw ParserException.c(str, (Throwable) null);
    }

    public static RtspAuthUserInfo n(Uri uri) {
        String userInfo = uri.getUserInfo();
        if (userInfo == null || !userInfo.contains(":")) {
            return null;
        }
        String[] X0 = Util.X0(userInfo, ":");
        return new RtspAuthUserInfo(X0[0], X0[1]);
    }

    public static RtspAuthenticationInfo o(String str) throws ParserException {
        Matcher matcher = f26903e.matcher(str);
        if (matcher.find()) {
            return new RtspAuthenticationInfo(2, (String) Assertions.e(matcher.group(1)), (String) Assertions.e(matcher.group(3)), Strings.d(matcher.group(4)));
        }
        Matcher matcher2 = f26904f.matcher(str);
        if (matcher2.matches()) {
            return new RtspAuthenticationInfo(1, (String) Assertions.e(matcher2.group(1)), "", "");
        }
        throw ParserException.c("Invalid WWW-Authenticate header " + str, (Throwable) null);
    }

    public static Uri p(Uri uri) {
        if (uri.getUserInfo() == null) {
            return uri;
        }
        String str = (String) Assertions.e(uri.getAuthority());
        Assertions.a(str.contains("@"));
        return uri.buildUpon().encodedAuthority(Util.W0(str, "@")[1]).build();
    }

    public static ImmutableList<String> q(RtspRequest rtspRequest) {
        boolean z2;
        if (rtspRequest.f26918c.d("CSeq") != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        ImmutableList.Builder builder = new ImmutableList.Builder();
        builder.d(Util.C("%s %s %s", t(rtspRequest.f26917b), rtspRequest.f26916a, "RTSP/1.0"));
        ImmutableListMultimap<String, String> b2 = rtspRequest.f26918c.b();
        UnmodifiableIterator<String> h2 = b2.keySet().iterator();
        while (h2.hasNext()) {
            String next = h2.next();
            ImmutableList<String> t2 = b2.o(next);
            for (int i2 = 0; i2 < t2.size(); i2++) {
                builder.d(Util.C("%s: %s", next, t2.get(i2)));
            }
        }
        builder.d("");
        builder.d(rtspRequest.f26919d);
        return builder.k();
    }

    public static ImmutableList<String> r(RtspResponse rtspResponse) {
        boolean z2;
        if (rtspResponse.f26921b.d("CSeq") != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        ImmutableList.Builder builder = new ImmutableList.Builder();
        builder.d(Util.C("%s %s %s", "RTSP/1.0", Integer.valueOf(rtspResponse.f26920a), c(rtspResponse.f26920a)));
        ImmutableListMultimap<String, String> b2 = rtspResponse.f26921b.b();
        UnmodifiableIterator<String> h2 = b2.keySet().iterator();
        while (h2.hasNext()) {
            String next = h2.next();
            ImmutableList<String> t2 = b2.o(next);
            for (int i2 = 0; i2 < t2.size(); i2++) {
                builder.d(Util.C("%s: %s", next, t2.get(i2)));
            }
        }
        builder.d("");
        builder.d(rtspResponse.f26922c);
        return builder.k();
    }

    public static String[] s(String str) {
        String str2 = f26906h;
        if (!str.contains(str2)) {
            str2 = f26905g;
        }
        return Util.W0(str, str2);
    }

    public static String t(int i2) {
        switch (i2) {
            case 1:
                return "ANNOUNCE";
            case 2:
                return "DESCRIBE";
            case 3:
                return "GET_PARAMETER";
            case 4:
                return "OPTIONS";
            case 5:
                return "PAUSE";
            case 6:
                return "PLAY";
            case 7:
                return "PLAY_NOTIFY";
            case 8:
                return "RECORD";
            case 9:
                return "REDIRECT";
            case 10:
                return "SETUP";
            case 11:
                return "SET_PARAMETER";
            case 12:
                return "TEARDOWN";
            default:
                throw new IllegalStateException();
        }
    }
}
