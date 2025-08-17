package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class RtspSessionTiming {

    /* renamed from: c  reason: collision with root package name */
    public static final RtspSessionTiming f26923c = new RtspSessionTiming(0, -9223372036854775807L);

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f26924d = Pattern.compile("npt[:=]([.\\d]+|now)\\s?-\\s?([.\\d]+)?");

    /* renamed from: a  reason: collision with root package name */
    public final long f26925a;

    /* renamed from: b  reason: collision with root package name */
    public final long f26926b;

    private RtspSessionTiming(long j2, long j3) {
        this.f26925a = j2;
        this.f26926b = j3;
    }

    public static String b(long j2) {
        return Util.C("npt=%.3f-", Double.valueOf(((double) j2) / 1000.0d));
    }

    public static RtspSessionTiming d(String str) throws ParserException {
        boolean z2;
        long j2;
        long j3;
        Matcher matcher = f26924d.matcher(str);
        RtspMessageUtil.a(matcher.matches(), str);
        boolean z3 = true;
        String group = matcher.group(1);
        if (group != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        RtspMessageUtil.a(z2, str);
        if (((String) Util.j(group)).equals("now")) {
            j2 = 0;
        } else {
            j2 = (long) (Float.parseFloat(group) * 1000.0f);
        }
        String group2 = matcher.group(2);
        if (group2 != null) {
            try {
                j3 = (long) (Float.parseFloat(group2) * 1000.0f);
                if (j3 < j2) {
                    z3 = false;
                }
                RtspMessageUtil.a(z3, str);
            } catch (NumberFormatException e2) {
                throw ParserException.c(group2, e2);
            }
        } else {
            j3 = -9223372036854775807L;
        }
        return new RtspSessionTiming(j2, j3);
    }

    public long a() {
        return this.f26926b - this.f26925a;
    }

    public boolean c() {
        return this.f26926b == -9223372036854775807L;
    }
}
