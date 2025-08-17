package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttParserUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f9147a = Pattern.compile("^NOTE([ \t].*)?$");

    private WebvttParserUtil() {
    }

    public static Matcher a(ParsableByteArray parsableByteArray) {
        String s2;
        while (true) {
            String s3 = parsableByteArray.s();
            if (s3 == null) {
                return null;
            }
            if (f9147a.matcher(s3).matches()) {
                do {
                    s2 = parsableByteArray.s();
                    if (s2 == null) {
                        break;
                    }
                } while (s2.isEmpty());
            } else {
                Matcher matcher = WebvttCueParser.f9121a.matcher(s3);
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
        String[] l12 = Util.l1(str, "\\.");
        long j2 = 0;
        for (String parseLong : Util.k1(l12[0], ":")) {
            j2 = (j2 * 60) + Long.parseLong(parseLong);
        }
        long j3 = j2 * 1000;
        if (l12.length == 2) {
            j3 += Long.parseLong(l12[1]);
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
