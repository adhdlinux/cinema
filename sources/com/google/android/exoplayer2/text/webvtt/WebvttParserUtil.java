package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttParserUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f27620a = Pattern.compile("^NOTE([ \t].*)?$");

    private WebvttParserUtil() {
    }

    public static Matcher a(ParsableByteArray parsableByteArray) {
        String s2;
        while (true) {
            String s3 = parsableByteArray.s();
            if (s3 == null) {
                return null;
            }
            if (f27620a.matcher(s3).matches()) {
                do {
                    s2 = parsableByteArray.s();
                    if (s2 == null) {
                        break;
                    }
                } while (s2.isEmpty());
            } else {
                Matcher matcher = WebvttCueParser.f27594a.matcher(s3);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(ParsableByteArray parsableByteArray) {
        String s2 = parsableByteArray.s();
        if (s2 == null || !s2.startsWith("WEBVTT")) {
            return false;
        }
        return true;
    }

    public static float c(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) throws NumberFormatException {
        String[] X0 = Util.X0(str, "\\.");
        long j2 = 0;
        for (String parseLong : Util.W0(X0[0], ":")) {
            j2 = (j2 * 60) + Long.parseLong(parseLong);
        }
        long j3 = j2 * 1000;
        if (X0.length == 2) {
            j3 += Long.parseLong(X0[1]);
        }
        return j3 * 1000;
    }

    public static void e(ParsableByteArray parsableByteArray) throws ParserException {
        int f2 = parsableByteArray.f();
        if (!b(parsableByteArray)) {
            parsableByteArray.U(f2);
            throw ParserException.a("Expected WEBVTT. Got " + parsableByteArray.s(), (Throwable) null);
        }
    }
}
