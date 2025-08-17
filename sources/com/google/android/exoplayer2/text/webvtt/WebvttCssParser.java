package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class WebvttCssParser {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f27570c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f27571d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f27572a = new ParsableByteArray();

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f27573b = new StringBuilder();

    private void a(WebvttCssStyle webvttCssStyle, String str) {
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = f27570c.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    webvttCssStyle.z((String) Assertions.e(matcher.group(1)));
                }
                str = str.substring(0, indexOf);
            }
            String[] W0 = Util.W0(str, "\\.");
            String str2 = W0[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                webvttCssStyle.y(str2.substring(0, indexOf2));
                webvttCssStyle.x(str2.substring(indexOf2 + 1));
            } else {
                webvttCssStyle.y(str2);
            }
            if (W0.length > 1) {
                webvttCssStyle.w((String[]) Util.L0(W0, 1, W0.length));
            }
        }
    }

    private static boolean b(ParsableByteArray parsableByteArray) {
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        byte[] e2 = parsableByteArray.e();
        if (f2 + 2 > g2) {
            return false;
        }
        int i2 = f2 + 1;
        if (e2[f2] != 47) {
            return false;
        }
        int i3 = i2 + 1;
        if (e2[i2] != 42) {
            return false;
        }
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= g2) {
                parsableByteArray.V(g2 - parsableByteArray.f());
                return true;
            } else if (((char) e2[i3]) == '*' && ((char) e2[i4]) == '/') {
                i3 = i4 + 1;
                g2 = i3;
            } else {
                i3 = i4;
            }
        }
    }

    private static boolean c(ParsableByteArray parsableByteArray) {
        char k2 = k(parsableByteArray, parsableByteArray.f());
        if (k2 != 9 && k2 != 10 && k2 != 12 && k2 != 13 && k2 != ' ') {
            return false;
        }
        parsableByteArray.V(1);
        return true;
    }

    private static void e(String str, WebvttCssStyle webvttCssStyle) {
        Matcher matcher = f27571d.matcher(Ascii.e(str));
        if (!matcher.matches()) {
            Log.i("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) Assertions.e(matcher.group(2));
        str2.hashCode();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case 37:
                if (str2.equals("%")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3240:
                if (str2.equals("em")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3592:
                if (str2.equals("px")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                webvttCssStyle.t(3);
                break;
            case 1:
                webvttCssStyle.t(2);
                break;
            case 2:
                webvttCssStyle.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        webvttCssStyle.s(Float.parseFloat((String) Assertions.e(matcher.group(1))));
    }

    private static String f(ParsableByteArray parsableByteArray, StringBuilder sb) {
        boolean z2 = false;
        sb.setLength(0);
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        while (f2 < g2 && !z2) {
            char c2 = (char) parsableByteArray.e()[f2];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z2 = true;
            } else {
                f2++;
                sb.append(c2);
            }
        }
        parsableByteArray.V(f2 - parsableByteArray.f());
        return sb.toString();
    }

    static String g(ParsableByteArray parsableByteArray, StringBuilder sb) {
        n(parsableByteArray);
        if (parsableByteArray.a() == 0) {
            return null;
        }
        String f2 = f(parsableByteArray, sb);
        if (!"".equals(f2)) {
            return f2;
        }
        return "" + ((char) parsableByteArray.H());
    }

    private static String h(ParsableByteArray parsableByteArray, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        while (!z2) {
            int f2 = parsableByteArray.f();
            String g2 = g(parsableByteArray, sb);
            if (g2 == null) {
                return null;
            }
            if ("}".equals(g2) || ";".equals(g2)) {
                parsableByteArray.U(f2);
                z2 = true;
            } else {
                sb2.append(g2);
            }
        }
        return sb2.toString();
    }

    private static String i(ParsableByteArray parsableByteArray, StringBuilder sb) {
        String str;
        n(parsableByteArray);
        if (parsableByteArray.a() < 5 || !"::cue".equals(parsableByteArray.E(5))) {
            return null;
        }
        int f2 = parsableByteArray.f();
        String g2 = g(parsableByteArray, sb);
        if (g2 == null) {
            return null;
        }
        if ("{".equals(g2)) {
            parsableByteArray.U(f2);
            return "";
        }
        if ("(".equals(g2)) {
            str = l(parsableByteArray);
        } else {
            str = null;
        }
        if (!")".equals(g(parsableByteArray, sb))) {
            return null;
        }
        return str;
    }

    private static void j(ParsableByteArray parsableByteArray, WebvttCssStyle webvttCssStyle, StringBuilder sb) {
        n(parsableByteArray);
        String f2 = f(parsableByteArray, sb);
        if (!"".equals(f2) && ":".equals(g(parsableByteArray, sb))) {
            n(parsableByteArray);
            String h2 = h(parsableByteArray, sb);
            if (h2 != null && !"".equals(h2)) {
                int f3 = parsableByteArray.f();
                String g2 = g(parsableByteArray, sb);
                if (!";".equals(g2)) {
                    if ("}".equals(g2)) {
                        parsableByteArray.U(f3);
                    } else {
                        return;
                    }
                }
                if (ViewProps.COLOR.equals(f2)) {
                    webvttCssStyle.q(ColorParser.b(h2));
                } else if ("background-color".equals(f2)) {
                    webvttCssStyle.n(ColorParser.b(h2));
                } else {
                    boolean z2 = true;
                    if ("ruby-position".equals(f2)) {
                        if ("over".equals(h2)) {
                            webvttCssStyle.v(1);
                        } else if ("under".equals(h2)) {
                            webvttCssStyle.v(2);
                        }
                    } else if ("text-combine-upright".equals(f2)) {
                        if (!"all".equals(h2) && !h2.startsWith("digits")) {
                            z2 = false;
                        }
                        webvttCssStyle.p(z2);
                    } else if ("text-decoration".equals(f2)) {
                        if ("underline".equals(h2)) {
                            webvttCssStyle.A(true);
                        }
                    } else if ("font-family".equals(f2)) {
                        webvttCssStyle.r(h2);
                    } else if ("font-weight".equals(f2)) {
                        if ("bold".equals(h2)) {
                            webvttCssStyle.o(true);
                        }
                    } else if ("font-style".equals(f2)) {
                        if ("italic".equals(h2)) {
                            webvttCssStyle.u(true);
                        }
                    } else if ("font-size".equals(f2)) {
                        e(h2, webvttCssStyle);
                    }
                }
            }
        }
    }

    private static char k(ParsableByteArray parsableByteArray, int i2) {
        return (char) parsableByteArray.e()[i2];
    }

    private static String l(ParsableByteArray parsableByteArray) {
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        boolean z2 = false;
        while (f2 < g2 && !z2) {
            int i2 = f2 + 1;
            if (((char) parsableByteArray.e()[f2]) == ')') {
                z2 = true;
            } else {
                z2 = false;
            }
            f2 = i2;
        }
        return parsableByteArray.E((f2 - 1) - parsableByteArray.f()).trim();
    }

    static void m(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.s()));
    }

    static void n(ParsableByteArray parsableByteArray) {
        while (true) {
            boolean z2 = true;
            while (parsableByteArray.a() > 0 && z2) {
                if (!c(parsableByteArray) && !b(parsableByteArray)) {
                    z2 = false;
                }
            }
            return;
        }
    }

    public List<WebvttCssStyle> d(ParsableByteArray parsableByteArray) {
        boolean z2;
        this.f27573b.setLength(0);
        int f2 = parsableByteArray.f();
        m(parsableByteArray);
        this.f27572a.S(parsableByteArray.e(), parsableByteArray.f());
        this.f27572a.U(f2);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String i2 = i(this.f27572a, this.f27573b);
            if (i2 == null || !"{".equals(g(this.f27572a, this.f27573b))) {
                return arrayList;
            }
            WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
            a(webvttCssStyle, i2);
            String str = null;
            boolean z3 = false;
            while (!z3) {
                int f3 = this.f27572a.f();
                String g2 = g(this.f27572a, this.f27573b);
                if (g2 == null || "}".equals(g2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    this.f27572a.U(f3);
                    j(this.f27572a, webvttCssStyle, this.f27573b);
                }
                str = g2;
                z3 = z2;
            }
            if ("}".equals(str)) {
                arrayList.add(webvttCssStyle);
            }
        }
    }
}
