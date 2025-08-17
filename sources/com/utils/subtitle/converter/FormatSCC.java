package com.utils.subtitle.converter;

import com.startapp.ae;
import com.startapp.ea;
import java.util.ArrayList;

public class FormatSCC implements TimedTextFileFormat {
    private String c(char[] cArr) {
        String str = "";
        int i2 = 0;
        while (i2 < cArr.length) {
            char c2 = cArr[i2];
            if (c2 == '|') {
                str = str + "7f";
            } else if (c2 != 65533) {
                switch (c2) {
                    case ' ':
                        str = str + "20";
                        break;
                    case '!':
                        str = str + "a1";
                        break;
                    case '\"':
                        str = str + "a2";
                        break;
                    case '#':
                        str = str + "23";
                        break;
                    case '$':
                        str = str + "a4";
                        break;
                    case '%':
                        str = str + "25";
                        break;
                    case '&':
                        str = str + "26";
                        break;
                    case '\'':
                        str = str + "a7";
                        break;
                    case '(':
                        str = str + "a8";
                        break;
                    case ')':
                        str = str + "29";
                        break;
                    default:
                        switch (c2) {
                            case '+':
                                str = str + "ab";
                                break;
                            case ',':
                                str = str + "2c";
                                break;
                            case '-':
                                str = str + "ad";
                                break;
                            case '.':
                                str = str + ae.f34224a;
                                break;
                            case '/':
                                str = str + "2f";
                                break;
                            case '0':
                                str = str + "b0";
                                break;
                            case '1':
                                str = str + "31";
                                break;
                            case '2':
                                str = str + "32";
                                break;
                            case '3':
                                str = str + "b3";
                                break;
                            case '4':
                                str = str + "34";
                                break;
                            case '5':
                                str = str + "b5";
                                break;
                            case '6':
                                str = str + "b6";
                                break;
                            case '7':
                                str = str + "37";
                                break;
                            case '8':
                                str = str + "38";
                                break;
                            case '9':
                                str = str + "b9";
                                break;
                            case ':':
                                str = str + "ba";
                                break;
                            case ';':
                                str = str + "3b";
                                break;
                            case '<':
                                str = str + "bc";
                                break;
                            case '=':
                                str = str + "3d";
                                break;
                            case '>':
                                str = str + "3e";
                                break;
                            case '?':
                                str = str + "bf";
                                break;
                            case '@':
                                str = str + "40";
                                break;
                            case 'A':
                                str = str + "c1";
                                break;
                            case 'B':
                                str = str + "c2";
                                break;
                            case 'C':
                                str = str + "43";
                                break;
                            case 'D':
                                str = str + "c4";
                                break;
                            case 'E':
                                str = str + "45";
                                break;
                            case 'F':
                                str = str + "46";
                                break;
                            case 'G':
                                str = str + "c7";
                                break;
                            case 'H':
                                str = str + "c8";
                                break;
                            case 'I':
                                str = str + "49";
                                break;
                            case 'J':
                                str = str + "4a";
                                break;
                            case 'K':
                                str = str + "cb";
                                break;
                            case 'L':
                                str = str + "4c";
                                break;
                            case 'M':
                                str = str + "cd";
                                break;
                            case 'N':
                                str = str + "ce";
                                break;
                            case 'O':
                                str = str + "4f";
                                break;
                            case 'P':
                                str = str + "d0";
                                break;
                            case 'Q':
                                str = str + "51";
                                break;
                            case 'R':
                                str = str + "52";
                                break;
                            case 'S':
                                str = str + "d3";
                                break;
                            case 'T':
                                str = str + "54";
                                break;
                            case 'U':
                                str = str + "d5";
                                break;
                            case 'V':
                                str = str + "d6";
                                break;
                            case 'W':
                                str = str + "57";
                                break;
                            case 'X':
                                str = str + "58";
                                break;
                            case 'Y':
                                str = str + "d9";
                                break;
                            case 'Z':
                                str = str + "da";
                                break;
                            case '[':
                                str = str + "5b";
                                break;
                            default:
                                switch (c2) {
                                    case 'a':
                                        str = str + "61";
                                        break;
                                    case 'b':
                                        str = str + "62";
                                        break;
                                    case 'c':
                                        str = str + "e3";
                                        break;
                                    case 'd':
                                        str = str + "64";
                                        break;
                                    case 'e':
                                        str = str + "e5";
                                        break;
                                    case 'f':
                                        str = str + "e6";
                                        break;
                                    case 'g':
                                        str = str + "67";
                                        break;
                                    case 'h':
                                        str = str + "68";
                                        break;
                                    case 'i':
                                        str = str + "e9";
                                        break;
                                    case 'j':
                                        str = str + ea.LOG_TAG;
                                        break;
                                    case 'k':
                                        str = str + "6b";
                                        break;
                                    case 'l':
                                        str = str + "ec";
                                        break;
                                    case 'm':
                                        str = str + "6d";
                                        break;
                                    case 'n':
                                        str = str + "6e";
                                        break;
                                    case 'o':
                                        str = str + "ef";
                                        break;
                                    case 'p':
                                        str = str + "70";
                                        break;
                                    case 'q':
                                        str = str + "f1";
                                        break;
                                    case 'r':
                                        str = str + "f2";
                                        break;
                                    case 's':
                                        str = str + "73";
                                        break;
                                    case 't':
                                        str = str + "f4";
                                        break;
                                    case 'u':
                                        str = str + "75";
                                        break;
                                    case 'v':
                                        str = str + "76";
                                        break;
                                    case 'w':
                                        str = str + "f7";
                                        break;
                                    case 'x':
                                        str = str + "f8";
                                        break;
                                    case 'y':
                                        str = str + "79";
                                        break;
                                    case 'z':
                                        str = str + "7a";
                                        break;
                                    default:
                                        str = str + "7f";
                                        break;
                                }
                        }
                }
            } else {
                str = str + "2a";
            }
            if (i2 % 2 == 1) {
                str = str + " ";
            }
            i2++;
        }
        if (i2 % 2 != 1) {
            return str;
        }
        return str + "80 ";
    }

    private String d(Caption caption) {
        String[] split = caption.f37720d.split("<br />");
        if (split[0].length() > 32) {
            split[0] = split[0].substring(0, 32);
        }
        int length = ((32 - split[0].length()) / 2) % 4;
        String str = ("" + "1340 1340 ") + c(split[0].toCharArray());
        if (split.length <= 1) {
            return str;
        }
        if (split[1].length() > 32) {
            split[1] = split[1].substring(0, 32);
        }
        int length2 = ((32 - split[1].length()) / 2) % 4;
        String str2 = (str + "13e0 13e0 ") + c(split[1].toCharArray());
        if (split.length <= 2) {
            return str2;
        }
        if (split[2].length() > 32) {
            split[2] = split[2].substring(0, 32);
        }
        int length3 = ((32 - split[2].length()) / 2) % 4;
        String str3 = (str2 + "9440 9440 ") + c(split[2].toCharArray());
        if (split.length <= 3) {
            return str3;
        }
        if (split[3].length() > 32) {
            split[3] = split[3].substring(0, 32);
        }
        String str4 = str3 + "94e0 94e0 ";
        int length4 = ((32 - split[3].length()) / 2) % 4;
        return str4 + c(split[3].toCharArray());
    }

    private void e(TimedTextObject timedTextObject) {
        Style style = new Style("white");
        timedTextObject.f37739g.put(style.f37723a, style);
        Style style2 = new Style("whiteU", style);
        style2.f37731i = true;
        timedTextObject.f37739g.put(style2.f37723a, style2);
        Style style3 = new Style("whiteUI", style2);
        style3.f37729g = true;
        timedTextObject.f37739g.put(style3.f37723a, style3);
        Style style4 = new Style("whiteI", style3);
        style4.f37731i = false;
        timedTextObject.f37739g.put(style4.f37723a, style4);
        Style style5 = new Style("green");
        style5.f37726d = Style.b("name", "green");
        timedTextObject.f37739g.put(style5.f37723a, style5);
        Style style6 = new Style("greenU", style5);
        style6.f37731i = true;
        timedTextObject.f37739g.put(style6.f37723a, style6);
        Style style7 = new Style("greenUI", style6);
        style7.f37729g = true;
        timedTextObject.f37739g.put(style7.f37723a, style7);
        Style style8 = new Style("greenI", style7);
        style8.f37731i = false;
        timedTextObject.f37739g.put(style8.f37723a, style8);
        Style style9 = new Style("blue");
        style9.f37726d = Style.b("name", "blue");
        timedTextObject.f37739g.put(style9.f37723a, style9);
        Style style10 = new Style("blueU", style9);
        style10.f37731i = true;
        timedTextObject.f37739g.put(style10.f37723a, style10);
        Style style11 = new Style("blueUI", style10);
        style11.f37729g = true;
        timedTextObject.f37739g.put(style11.f37723a, style11);
        Style style12 = new Style("blueI", style11);
        style12.f37731i = false;
        timedTextObject.f37739g.put(style12.f37723a, style12);
        Style style13 = new Style("cyan");
        style13.f37726d = Style.b("name", "cyan");
        timedTextObject.f37739g.put(style13.f37723a, style13);
        Style style14 = new Style("cyanU", style13);
        style14.f37731i = true;
        timedTextObject.f37739g.put(style14.f37723a, style14);
        Style style15 = new Style("cyanUI", style14);
        style15.f37729g = true;
        timedTextObject.f37739g.put(style15.f37723a, style15);
        Style style16 = new Style("cyanI", style15);
        style16.f37731i = false;
        timedTextObject.f37739g.put(style16.f37723a, style16);
        Style style17 = new Style("red");
        style17.f37726d = Style.b("name", "red");
        timedTextObject.f37739g.put(style17.f37723a, style17);
        Style style18 = new Style("redU", style17);
        style18.f37731i = true;
        timedTextObject.f37739g.put(style18.f37723a, style18);
        Style style19 = new Style("redUI", style18);
        style19.f37729g = true;
        timedTextObject.f37739g.put(style19.f37723a, style19);
        Style style20 = new Style("redI", style19);
        style20.f37731i = false;
        timedTextObject.f37739g.put(style20.f37723a, style20);
        Style style21 = new Style("yellow");
        style21.f37726d = Style.b("name", "yellow");
        timedTextObject.f37739g.put(style21.f37723a, style21);
        Style style22 = new Style("yellowU", style21);
        style22.f37731i = true;
        timedTextObject.f37739g.put(style22.f37723a, style22);
        Style style23 = new Style("yellowUI", style22);
        style23.f37729g = true;
        timedTextObject.f37739g.put(style23.f37723a, style23);
        Style style24 = new Style("yellowI", style23);
        style24.f37731i = false;
        timedTextObject.f37739g.put(style24.f37723a, style24);
        Style style25 = new Style("magenta");
        style25.f37726d = Style.b("name", "magenta");
        timedTextObject.f37739g.put(style25.f37723a, style25);
        Style style26 = new Style("magentaU", style25);
        style26.f37731i = true;
        timedTextObject.f37739g.put(style26.f37723a, style26);
        Style style27 = new Style("magentaUI", style26);
        style27.f37729g = true;
        timedTextObject.f37739g.put(style27.f37723a, style27);
        Style style28 = new Style("magentaI", style27);
        style28.f37731i = false;
        timedTextObject.f37739g.put(style28.f37723a, style28);
    }

    private String f(byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (b2 == 42) {
            return "�";
        }
        if (b2 == 92) {
            return "é";
        }
        switch (b2) {
            case 94:
                return "í";
            case 95:
                return "ó";
            case 96:
                return "ú";
            default:
                switch (b2) {
                    case 123:
                        return "ç";
                    case 124:
                        return "�";
                    case 125:
                        return "Ñ";
                    case 126:
                        return "ñ";
                    case Byte.MAX_VALUE:
                        return "|";
                    default:
                        return "" + ((char) b2);
                }
        }
    }

    private String g(int i2) {
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return "�";
            case 7:
                return "♪";
            case 8:
                return "�";
            case 9:
                return " ";
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return "�";
            default:
                return "";
        }
    }

    private void h(String str, int i2) {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:153|152|171|172|173|174) */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02c8, code lost:
        r14 = r0;
        r9 = "magenta";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02cb, code lost:
        r14 = r0;
        r9 = "yellow";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02cd, code lost:
        r11 = r12;
        r12 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02d1, code lost:
        r14 = r0;
        r11 = r12;
        r12 = r19;
        r9 = "red";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02d8, code lost:
        r14 = r0;
        r11 = r12;
        r12 = r19;
        r9 = "cyan";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02df, code lost:
        r14 = r0;
        r11 = r12;
        r12 = r19;
        r9 = "blue";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02e6, code lost:
        r14 = r0;
        r11 = r12;
        r12 = r19;
        r9 = "green";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03b4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03db, code lost:
        r28.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03de, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:171:0x03b7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.utils.subtitle.converter.TimedTextObject a(java.lang.String r27, java.io.InputStream r28, java.lang.String r29) throws java.io.IOException, com.utils.subtitle.converter.FatalParsingException {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            com.utils.subtitle.converter.TimedTextObject r2 = new com.utils.subtitle.converter.TimedTextObject
            r2.<init>()
            java.io.BufferedReader r3 = new java.io.BufferedReader
            java.io.InputStreamReader r4 = new java.io.InputStreamReader
            r5 = r28
            r6 = r29
            r4.<init>(r5, r6)
            r3.<init>(r4)
            r2.f37737e = r0
            r2.f37733a = r0
            java.lang.String r4 = r3.readLine()     // Catch:{ NullPointerException -> 0x03b6 }
            java.lang.String r4 = r4.trim()     // Catch:{ NullPointerException -> 0x03b6 }
            java.lang.String r6 = "Scenarist_SCC V1.0"
            boolean r4 = r4.equalsIgnoreCase(r6)     // Catch:{ NullPointerException -> 0x03b6 }
            if (r4 == 0) goto L_0x03ac
            r1.e(r2)     // Catch:{ NullPointerException -> 0x03b6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x03b6 }
            r4.<init>()     // Catch:{ NullPointerException -> 0x03b6 }
            java.lang.String r6 = r2.f37742j     // Catch:{ NullPointerException -> 0x03b6 }
            r4.append(r6)     // Catch:{ NullPointerException -> 0x03b6 }
            java.lang.String r6 = "Only data from CC channel 1 will be extracted.\n\n"
            r4.append(r6)     // Catch:{ NullPointerException -> 0x03b6 }
            java.lang.String r4 = r4.toString()     // Catch:{ NullPointerException -> 0x03b6 }
            r2.f37742j = r4     // Catch:{ NullPointerException -> 0x03b6 }
            java.lang.String r4 = r3.readLine()     // Catch:{ NullPointerException -> 0x03b6 }
            r6 = 0
            java.lang.String r7 = ""
            r9 = r6
            r13 = r7
            r10 = 1
            r11 = 0
            r12 = 1
            r14 = 0
            r15 = 0
        L_0x0051:
            java.lang.String r0 = "h:m:s:f/fps"
            if (r4 == 0) goto L_0x037d
            java.lang.String r4 = r4.trim()     // Catch:{ NullPointerException -> 0x03b7 }
            int r10 = r10 + 1
            boolean r16 = r4.isEmpty()     // Catch:{ NullPointerException -> 0x037a }
            if (r16 != 0) goto L_0x0363
            java.lang.String r8 = "\t"
            java.lang.String[] r4 = r4.split(r8)     // Catch:{ NullPointerException -> 0x037a }
            com.utils.subtitle.converter.Time r8 = new com.utils.subtitle.converter.Time     // Catch:{ NullPointerException -> 0x037a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x037a }
            r5.<init>()     // Catch:{ NullPointerException -> 0x037a }
            r29 = r9
            r16 = 0
            r9 = r4[r16]     // Catch:{ NullPointerException -> 0x037a }
            r5.append(r9)     // Catch:{ NullPointerException -> 0x037a }
            java.lang.String r9 = "/29.97"
            r5.append(r9)     // Catch:{ NullPointerException -> 0x037a }
            java.lang.String r5 = r5.toString()     // Catch:{ NullPointerException -> 0x037a }
            r8.<init>(r0, r5)     // Catch:{ NullPointerException -> 0x037a }
            r0 = 1
            r4 = r4[r0]     // Catch:{ NullPointerException -> 0x037a }
            java.lang.String r0 = " "
            java.lang.String[] r0 = r4.split(r0)     // Catch:{ NullPointerException -> 0x037a }
            r9 = r29
            r4 = 0
        L_0x008f:
            int r5 = r0.length     // Catch:{ NullPointerException -> 0x037a }
            if (r4 >= r5) goto L_0x0359
            r5 = r0[r4]     // Catch:{ NullPointerException -> 0x037a }
            r17 = r10
            r10 = 16
            int r5 = java.lang.Integer.parseInt(r5, r10)     // Catch:{ NullPointerException -> 0x0377 }
            r5 = r5 & 32639(0x7f7f, float:4.5737E-41)
            r10 = r5 & 24576(0x6000, float:3.4438E-41)
            if (r10 == 0) goto L_0x0116
            if (r11 == 0) goto L_0x0110
            r10 = 65280(0xff00, float:9.1477E-41)
            r10 = r10 & r5
            int r10 = r10 >>> 8
            byte r10 = (byte) r10     // Catch:{ NullPointerException -> 0x0377 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5     // Catch:{ NullPointerException -> 0x0377 }
            if (r12 == 0) goto L_0x00db
            r18 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0377 }
            r3.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r13)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r10 = r1.f(r10)     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r10)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r3 = r3.toString()     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0377 }
            r10.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            r10.append(r3)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r3 = r1.f(r5)     // Catch:{ NullPointerException -> 0x0377 }
            r10.append(r3)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r13 = r10.toString()     // Catch:{ NullPointerException -> 0x0377 }
            r19 = r12
            goto L_0x010d
        L_0x00db:
            r18 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0377 }
            r3.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            r19 = r12
            java.lang.String r12 = r6.f37720d     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r12)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r10 = r1.f(r10)     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r10)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r3 = r3.toString()     // Catch:{ NullPointerException -> 0x0377 }
            r6.f37720d = r3     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0377 }
            r3.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r10 = r6.f37720d     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r10)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r5 = r1.f(r5)     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r5)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r3 = r3.toString()     // Catch:{ NullPointerException -> 0x0377 }
            r6.f37720d = r3     // Catch:{ NullPointerException -> 0x0377 }
        L_0x010d:
            r24 = r0
            goto L_0x012d
        L_0x0110:
            r18 = r3
            r19 = r12
            r12 = r11
            goto L_0x012a
        L_0x0116:
            r18 = r3
            r19 = r12
            if (r5 != 0) goto L_0x0132
            int r3 = r8.f37732a     // Catch:{ NullPointerException -> 0x0377 }
            r12 = r11
            double r10 = (double) r3     // Catch:{ NullPointerException -> 0x0377 }
            r20 = 4629892762866901061(0x4040aef006d56045, double:33.366700033366705)
            double r10 = r10 + r20
            int r3 = (int) r10     // Catch:{ NullPointerException -> 0x0377 }
            r8.f37732a = r3     // Catch:{ NullPointerException -> 0x0377 }
        L_0x012a:
            r24 = r0
        L_0x012c:
            r11 = r12
        L_0x012d:
            r12 = r19
            r0 = 1
            goto L_0x0350
        L_0x0132:
            r12 = r11
            int r3 = r4 + 1
            int r10 = r0.length     // Catch:{ NullPointerException -> 0x0377 }
            if (r3 >= r10) goto L_0x0143
            r10 = r0[r4]     // Catch:{ NullPointerException -> 0x0377 }
            r11 = r0[r3]     // Catch:{ NullPointerException -> 0x0377 }
            boolean r10 = r10.equals(r11)     // Catch:{ NullPointerException -> 0x0377 }
            if (r10 == 0) goto L_0x0143
            r4 = r3
        L_0x0143:
            r3 = r5 & 2048(0x800, float:2.87E-42)
            if (r3 != 0) goto L_0x034a
            r3 = r5 & 5744(0x1670, float:8.049E-42)
            r10 = 5152(0x1420, float:7.22E-42)
            if (r3 != r10) goto L_0x023c
            r3 = r5 & 256(0x100, float:3.59E-43)
            if (r3 != 0) goto L_0x034a
            r3 = r5 & 15
            if (r3 == 0) goto L_0x0234
            r5 = 9
            if (r3 == r5) goto L_0x0225
            r5 = 12
            if (r3 == r5) goto L_0x01f0
            r5 = 5
            if (r3 == r5) goto L_0x0194
            r5 = 6
            if (r3 == r5) goto L_0x0194
            r5 = 7
            if (r3 == r5) goto L_0x0194
            r5 = 14
            if (r3 == r5) goto L_0x018f
            r5 = 15
            if (r3 == r5) goto L_0x0170
            goto L_0x021d
        L_0x0170:
            com.utils.subtitle.converter.Caption r3 = new com.utils.subtitle.converter.Caption     // Catch:{ NullPointerException -> 0x0377 }
            r3.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            r3.f37718b = r8     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0377 }
            r5.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r6 = r3.f37720d     // Catch:{ NullPointerException -> 0x0377 }
            r5.append(r6)     // Catch:{ NullPointerException -> 0x0377 }
            r5.append(r13)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r5 = r5.toString()     // Catch:{ NullPointerException -> 0x0377 }
            r3.f37720d = r5     // Catch:{ NullPointerException -> 0x0377 }
        L_0x018a:
            r24 = r0
            r6 = r3
            goto L_0x021f
        L_0x018f:
            r24 = r0
            r13 = r7
            goto L_0x021f
        L_0x0194:
            if (r6 == 0) goto L_0x01e4
            r6.f37719c = r8     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0377 }
            r3.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r7)     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r9)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r3 = r3.toString()     // Catch:{ NullPointerException -> 0x0377 }
            if (r14 == 0) goto L_0x01ba
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0377 }
            r5.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            r5.append(r3)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r3 = "U"
            r5.append(r3)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r3 = r5.toString()     // Catch:{ NullPointerException -> 0x0377 }
        L_0x01ba:
            if (r15 == 0) goto L_0x01cd
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0377 }
            r5.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            r5.append(r3)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r3 = "I"
            r5.append(r3)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r3 = r5.toString()     // Catch:{ NullPointerException -> 0x0377 }
        L_0x01cd:
            java.util.Hashtable<java.lang.String, com.utils.subtitle.converter.Style> r5 = r2.f37739g     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.Object r3 = r5.get(r3)     // Catch:{ NullPointerException -> 0x0377 }
            com.utils.subtitle.converter.Style r3 = (com.utils.subtitle.converter.Style) r3     // Catch:{ NullPointerException -> 0x0377 }
            r6.f37717a = r3     // Catch:{ NullPointerException -> 0x0377 }
            java.util.TreeMap<java.lang.Integer, com.utils.subtitle.converter.Caption> r3 = r2.f37741i     // Catch:{ NullPointerException -> 0x0377 }
            com.utils.subtitle.converter.Time r5 = r6.f37718b     // Catch:{ NullPointerException -> 0x0377 }
            int r5 = r5.f37732a     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ NullPointerException -> 0x0377 }
            r3.put(r5, r6)     // Catch:{ NullPointerException -> 0x0377 }
        L_0x01e4:
            com.utils.subtitle.converter.Caption r3 = new com.utils.subtitle.converter.Caption     // Catch:{ NullPointerException -> 0x0377 }
            r3.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            r3.f37718b = r8     // Catch:{ NullPointerException -> 0x0377 }
            r24 = r0
            r6 = r3
            r13 = r7
            goto L_0x022f
        L_0x01f0:
            if (r6 == 0) goto L_0x021d
            r6.f37719c = r8     // Catch:{ NullPointerException -> 0x0377 }
            com.utils.subtitle.converter.Time r3 = r6.f37718b     // Catch:{ NullPointerException -> 0x0377 }
            if (r3 == 0) goto L_0x021d
            int r3 = r3.f37732a     // Catch:{ NullPointerException -> 0x0377 }
        L_0x01fa:
            java.util.TreeMap<java.lang.Integer, com.utils.subtitle.converter.Caption> r5 = r2.f37741i     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)     // Catch:{ NullPointerException -> 0x0377 }
            boolean r5 = r5.containsKey(r10)     // Catch:{ NullPointerException -> 0x0377 }
            if (r5 == 0) goto L_0x0209
            int r3 = r3 + 1
            goto L_0x01fa
        L_0x0209:
            java.util.TreeMap<java.lang.Integer, com.utils.subtitle.converter.Caption> r3 = r2.f37741i     // Catch:{ NullPointerException -> 0x0377 }
            com.utils.subtitle.converter.Time r5 = r6.f37718b     // Catch:{ NullPointerException -> 0x0377 }
            int r5 = r5.f37732a     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ NullPointerException -> 0x0377 }
            r3.put(r5, r6)     // Catch:{ NullPointerException -> 0x0377 }
            com.utils.subtitle.converter.Caption r3 = new com.utils.subtitle.converter.Caption     // Catch:{ NullPointerException -> 0x0377 }
            r3.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            goto L_0x018a
        L_0x021d:
            r24 = r0
        L_0x021f:
            r12 = r19
            r0 = 1
            r11 = 1
            goto L_0x0350
        L_0x0225:
            com.utils.subtitle.converter.Caption r3 = new com.utils.subtitle.converter.Caption     // Catch:{ NullPointerException -> 0x0377 }
            r3.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            r3.f37718b = r8     // Catch:{ NullPointerException -> 0x0377 }
            r24 = r0
            r6 = r3
        L_0x022f:
            r0 = 1
            r11 = 1
            r12 = 0
            goto L_0x0350
        L_0x0234:
            r24 = r0
            r13 = r7
            r0 = 1
            r11 = 1
            r12 = 1
            goto L_0x0350
        L_0x023c:
            if (r12 == 0) goto L_0x012a
            r3 = r5 & 4160(0x1040, float:5.83E-42)
            java.lang.String r10 = "magenta"
            java.lang.String r11 = "yellow"
            java.lang.String r20 = "red"
            java.lang.String r21 = "cyan"
            java.lang.String r22 = "blue"
            java.lang.String r23 = "green"
            r24 = r0
            r0 = 4160(0x1040, float:5.83E-42)
            java.lang.String r25 = "white"
            if (r3 != r0) goto L_0x02a8
            java.lang.String r0 = "<br />"
            if (r19 == 0) goto L_0x026d
            boolean r3 = r13.isEmpty()     // Catch:{ NullPointerException -> 0x0377 }
            if (r3 != 0) goto L_0x026d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0377 }
            r3.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r13)     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r0)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r13 = r3.toString()     // Catch:{ NullPointerException -> 0x0377 }
        L_0x026d:
            if (r19 != 0) goto L_0x028a
            java.lang.String r3 = r6.f37720d     // Catch:{ NullPointerException -> 0x0377 }
            boolean r3 = r3.isEmpty()     // Catch:{ NullPointerException -> 0x0377 }
            if (r3 != 0) goto L_0x028a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0377 }
            r3.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r9 = r6.f37720d     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r9)     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r0)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r0 = r3.toString()     // Catch:{ NullPointerException -> 0x0377 }
            r6.f37720d = r0     // Catch:{ NullPointerException -> 0x0377 }
        L_0x028a:
            r0 = r5 & 1
            r3 = 1
            if (r0 != r3) goto L_0x0291
            r0 = 1
            goto L_0x0292
        L_0x0291:
            r0 = 0
        L_0x0292:
            r9 = r5 & 16
            r14 = 16
            if (r9 == r14) goto L_0x02ed
            r5 = r5 & 14
            int r5 = r5 >> r3
            short r3 = (short) r5     // Catch:{ NullPointerException -> 0x0377 }
            switch(r3) {
                case 0: goto L_0x02ed;
                case 1: goto L_0x02e6;
                case 2: goto L_0x02df;
                case 3: goto L_0x02d8;
                case 4: goto L_0x02d1;
                case 5: goto L_0x02cb;
                case 6: goto L_0x02c8;
                case 7: goto L_0x02a1;
                default: goto L_0x029f;
            }     // Catch:{ NullPointerException -> 0x0377 }
        L_0x029f:
            goto L_0x02ed
        L_0x02a1:
            r14 = r0
            r11 = r12
            r12 = r19
            r9 = r25
            goto L_0x02c4
        L_0x02a8:
            r0 = r5 & 6000(0x1770, float:8.408E-42)
            r3 = 4384(0x1120, float:6.143E-42)
            if (r0 != r3) goto L_0x02f6
            r0 = r5 & 1
            r3 = 1
            if (r0 != r3) goto L_0x02b5
            r0 = 1
            goto L_0x02b6
        L_0x02b5:
            r0 = 0
        L_0x02b6:
            r5 = r5 & 14
            int r5 = r5 >> r3
            short r3 = (short) r5     // Catch:{ NullPointerException -> 0x0377 }
            switch(r3) {
                case 0: goto L_0x02ed;
                case 1: goto L_0x02e6;
                case 2: goto L_0x02df;
                case 3: goto L_0x02d8;
                case 4: goto L_0x02d1;
                case 5: goto L_0x02cb;
                case 6: goto L_0x02c8;
                case 7: goto L_0x02c0;
                default: goto L_0x02bd;
            }     // Catch:{ NullPointerException -> 0x0377 }
        L_0x02bd:
            r14 = r0
            goto L_0x012c
        L_0x02c0:
            r14 = r0
            r11 = r12
            r12 = r19
        L_0x02c4:
            r0 = 1
            r15 = 1
            goto L_0x0350
        L_0x02c8:
            r14 = r0
            r9 = r10
            goto L_0x02cd
        L_0x02cb:
            r14 = r0
            r9 = r11
        L_0x02cd:
            r11 = r12
            r12 = r19
            goto L_0x02f3
        L_0x02d1:
            r14 = r0
            r11 = r12
            r12 = r19
            r9 = r20
            goto L_0x02f3
        L_0x02d8:
            r14 = r0
            r11 = r12
            r12 = r19
            r9 = r21
            goto L_0x02f3
        L_0x02df:
            r14 = r0
            r11 = r12
            r12 = r19
            r9 = r22
            goto L_0x02f3
        L_0x02e6:
            r14 = r0
            r11 = r12
            r12 = r19
            r9 = r23
            goto L_0x02f3
        L_0x02ed:
            r14 = r0
            r11 = r12
            r12 = r19
            r9 = r25
        L_0x02f3:
            r0 = 1
            r15 = 0
            goto L_0x0350
        L_0x02f6:
            r3 = r5 & 6012(0x177c, float:8.425E-42)
            r10 = 5920(0x1720, float:8.296E-42)
            if (r3 != r10) goto L_0x02fe
            goto L_0x012c
        L_0x02fe:
            r3 = 4400(0x1130, float:6.166E-42)
            if (r0 != r3) goto L_0x0334
            r0 = r5 & 15
            if (r19 == 0) goto L_0x031b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0377 }
            r3.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r13)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r0 = r1.g(r0)     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r0)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r13 = r3.toString()     // Catch:{ NullPointerException -> 0x0377 }
            goto L_0x012c
        L_0x031b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0377 }
            r3.<init>()     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r5 = r6.f37720d     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r5)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r0 = r1.g(r0)     // Catch:{ NullPointerException -> 0x0377 }
            r3.append(r0)     // Catch:{ NullPointerException -> 0x0377 }
            java.lang.String r0 = r3.toString()     // Catch:{ NullPointerException -> 0x0377 }
            r6.f37720d = r0     // Catch:{ NullPointerException -> 0x0377 }
            goto L_0x012c
        L_0x0334:
            r0 = r5 & 5728(0x1660, float:8.027E-42)
            r3 = 4640(0x1220, float:6.502E-42)
            if (r0 != r3) goto L_0x012c
            r0 = r5 & 287(0x11f, float:4.02E-43)
            if (r19 == 0) goto L_0x0343
            r1.h(r13, r0)     // Catch:{ NullPointerException -> 0x0377 }
            goto L_0x012c
        L_0x0343:
            java.lang.String r3 = r6.f37720d     // Catch:{ NullPointerException -> 0x0377 }
            r1.h(r3, r0)     // Catch:{ NullPointerException -> 0x0377 }
            goto L_0x012c
        L_0x034a:
            r24 = r0
            r12 = r19
            r0 = 1
            r11 = 0
        L_0x0350:
            int r4 = r4 + r0
            r10 = r17
            r3 = r18
            r0 = r24
            goto L_0x008f
        L_0x0359:
            r18 = r3
            r17 = r10
            r19 = r12
            r12 = r11
            r12 = r19
            goto L_0x036b
        L_0x0363:
            r18 = r3
            r29 = r9
            r17 = r10
            r16 = 0
        L_0x036b:
            java.lang.String r4 = r18.readLine()     // Catch:{ NullPointerException -> 0x0377 }
            r5 = r28
            r10 = r17
            r3 = r18
            goto L_0x0051
        L_0x0377:
            r10 = r17
            goto L_0x03b7
        L_0x037a:
            r17 = r10
            goto L_0x03b7
        L_0x037d:
            com.utils.subtitle.converter.Time r3 = new com.utils.subtitle.converter.Time     // Catch:{ NullPointerException -> 0x03b7 }
            java.lang.String r4 = "99:59:59:29/29.97"
            r3.<init>(r0, r4)     // Catch:{ NullPointerException -> 0x03b7 }
            r6.f37719c = r3     // Catch:{ NullPointerException -> 0x03b7 }
            com.utils.subtitle.converter.Time r0 = r6.f37718b     // Catch:{ NullPointerException -> 0x03b7 }
            if (r0 == 0) goto L_0x03a8
            int r0 = r0.f37732a     // Catch:{ NullPointerException -> 0x03b7 }
        L_0x038c:
            java.util.TreeMap<java.lang.Integer, com.utils.subtitle.converter.Caption> r3 = r2.f37741i     // Catch:{ NullPointerException -> 0x03b7 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch:{ NullPointerException -> 0x03b7 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ NullPointerException -> 0x03b7 }
            if (r3 == 0) goto L_0x039b
            int r0 = r0 + 1
            goto L_0x038c
        L_0x039b:
            java.util.TreeMap<java.lang.Integer, com.utils.subtitle.converter.Caption> r0 = r2.f37741i     // Catch:{ NullPointerException -> 0x03b7 }
            com.utils.subtitle.converter.Time r3 = r6.f37718b     // Catch:{ NullPointerException -> 0x03b7 }
            int r3 = r3.f37732a     // Catch:{ NullPointerException -> 0x03b7 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ NullPointerException -> 0x03b7 }
            r0.put(r3, r6)     // Catch:{ NullPointerException -> 0x03b7 }
        L_0x03a8:
            r2.a()     // Catch:{ NullPointerException -> 0x03b7 }
            goto L_0x03d4
        L_0x03ac:
            com.utils.subtitle.converter.FatalParsingException r0 = new com.utils.subtitle.converter.FatalParsingException     // Catch:{ NullPointerException -> 0x03b6 }
            java.lang.String r3 = "The fist line should define the file type: \"Scenarist_SCC V1.0\""
            r0.<init>(r3)     // Catch:{ NullPointerException -> 0x03b6 }
            throw r0     // Catch:{ NullPointerException -> 0x03b6 }
        L_0x03b4:
            r0 = move-exception
            goto L_0x03db
        L_0x03b6:
            r10 = 1
        L_0x03b7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03b4 }
            r0.<init>()     // Catch:{ all -> 0x03b4 }
            java.lang.String r3 = r2.f37742j     // Catch:{ all -> 0x03b4 }
            r0.append(r3)     // Catch:{ all -> 0x03b4 }
            java.lang.String r3 = "unexpected end of file at line "
            r0.append(r3)     // Catch:{ all -> 0x03b4 }
            r0.append(r10)     // Catch:{ all -> 0x03b4 }
            java.lang.String r3 = ", maybe last caption is not complete.\n\n"
            r0.append(r3)     // Catch:{ all -> 0x03b4 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03b4 }
            r2.f37742j = r0     // Catch:{ all -> 0x03b4 }
        L_0x03d4:
            r28.close()
            r0 = 1
            r2.f37745m = r0
            return r2
        L_0x03db:
            r28.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.subtitle.converter.FormatSCC.a(java.lang.String, java.io.InputStream, java.lang.String):com.utils.subtitle.converter.TimedTextObject");
    }

    /* renamed from: i */
    public String[] b(TimedTextObject timedTextObject) {
        String str;
        if (!timedTextObject.f37745m) {
            return null;
        }
        ArrayList arrayList = new ArrayList((timedTextObject.f37741i.size() * 2) + 20);
        arrayList.add(0, "Scenarist_SCC V1.0\n");
        Caption caption = new Caption();
        caption.f37720d = "";
        caption.f37719c = new Time("h:mm:ss.cs", "0:00:00.00");
        int i2 = 1;
        for (Caption next : timedTextObject.f37741i.values()) {
            int i3 = caption.f37719c.f37732a;
            Time time = next.f37718b;
            int i4 = time.f37732a;
            if (i3 > i4) {
                next.f37720d += "<br />" + caption.f37720d;
                Time time2 = next.f37718b;
                time2.f37732a = (int) (((double) time2.f37732a) - 33.366700033366705d);
                Time time3 = next.f37718b;
                time3.f37732a = (int) (((double) time3.f37732a) + 33.366700033366705d);
                str = ("" + next.f37718b.a("hh:mm:ss:ff/29.97") + "\t942c 942c ") + "94ae 94ae 9420 9420 ";
            } else if (i3 < i4) {
                Time time4 = next.f37718b;
                time4.f37732a = (int) (((double) time4.f37732a) - 33.366700033366705d);
                str = ("" + caption.f37719c.a("hh:mm:ss:ff/29.97") + "\t942c 942c\n\n") + next.f37718b.a("hh:mm:ss:ff/29.97") + "\t94ae 94ae 9420 9420 ";
                Time time5 = next.f37718b;
                time5.f37732a = (int) (((double) time5.f37732a) + 33.366700033366705d);
            } else {
                time.f37732a = (int) (((double) i4) - 33.366700033366705d);
                str = "" + next.f37718b.a("hh:mm:ss:ff/29.97") + "\t942c 942c 94ae 94ae 9420 9420 ";
                Time time6 = next.f37718b;
                time6.f37732a = (int) (((double) time6.f37732a) + 33.366700033366705d);
            }
            arrayList.add(i2, (str + d(next)) + "8080 8080 942f 942f\n");
            caption = next;
            i2++;
        }
        arrayList.add(i2, "");
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i5 = 0; i5 < size; i5++) {
            strArr[i5] = (String) arrayList.get(i5);
        }
        return strArr;
    }
}
