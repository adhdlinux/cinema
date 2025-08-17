package com.original.tase.helper;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.original.tase.utils.Utils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringEscapeUtils;

public class GoogleVideoHelper {
    /* JADX WARNING: Can't wrap try/catch for region: R(2:24|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0 = java.net.URLDecoder.decode(r0);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x007c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.String> a(java.lang.String r7) {
        /*
            java.lang.String r0 = ","
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00a5 }
            r2.<init>()     // Catch:{ all -> 0x00a5 }
            boolean r3 = r7.contains(r0)     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = "|"
            if (r3 == 0) goto L_0x0025
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00a5 }
            java.lang.String[] r7 = r7.split(r0)     // Catch:{ all -> 0x00a5 }
            java.util.List r7 = java.util.Arrays.asList(r7)     // Catch:{ all -> 0x00a5 }
            r3.<init>(r7)     // Catch:{ all -> 0x00a5 }
            r2.addAll(r3)     // Catch:{ all -> 0x00a5 }
            goto L_0x002f
        L_0x0025:
            boolean r0 = r7.contains(r4)     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x002c
            return r1
        L_0x002c:
            r2.add(r7)     // Catch:{ all -> 0x00a5 }
        L_0x002f:
            java.util.Iterator r7 = r2.iterator()     // Catch:{ all -> 0x00a5 }
        L_0x0033:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x00a5
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x00a5 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00a5 }
            boolean r2 = r0.contains(r4)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x0033
            java.lang.String r2 = "\\|"
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ all -> 0x0033 }
            r2 = 0
            r2 = r0[r2]     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = "\\\\"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.replace(r3, r5)     // Catch:{ all -> 0x0033 }
            r3 = 1
            r0 = r0[r3]     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = r0.trim()     // Catch:{ all -> 0x0033 }
            java.lang.String r5 = "http"
            boolean r3 = r3.startsWith(r5)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x0033
            java.lang.String r3 = "\\u003d"
            java.lang.String r5 = "="
            java.lang.String r3 = r0.replace(r3, r5)     // Catch:{ UnsupportedEncodingException -> 0x007c }
            java.lang.String r5 = "\\u0026"
            java.lang.String r6 = "&"
            java.lang.String r3 = r3.replace(r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x007c }
            java.lang.String r5 = "UTF-8"
            java.lang.String r0 = java.net.URLDecoder.decode(r3, r5)     // Catch:{ UnsupportedEncodingException -> 0x007c }
            goto L_0x0080
        L_0x007c:
            java.lang.String r0 = java.net.URLDecoder.decode(r0)     // Catch:{ all -> 0x0033 }
        L_0x0080:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0033 }
            r3.<init>()     // Catch:{ all -> 0x0033 }
            java.lang.String r5 = "=m"
            r3.append(r5)     // Catch:{ all -> 0x0033 }
            r3.append(r2)     // Catch:{ all -> 0x0033 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0033 }
            java.lang.String r2 = h(r2)     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = "HQ"
            boolean r3 = r2.equals(r3)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x00a1
            java.lang.String r2 = h(r0)     // Catch:{ all -> 0x0033 }
        L_0x00a1:
            r1.put(r0, r2)     // Catch:{ all -> 0x0033 }
            goto L_0x0033
        L_0x00a5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.GoogleVideoHelper.a(java.lang.String):java.util.HashMap");
    }

    public static boolean b(String str) {
        String str2;
        if (str != null && !str.isEmpty()) {
            String replace = str.replace("/preview", "/edit");
            if ((replace.contains("drive.google") || replace.contains("docs.google")) && !replace.contains("/open?") && !replace.contains("/uc?")) {
                str2 = j(replace);
            } else if (replace.contains("youtube") || replace.contains("youtu.be") || ((replace.contains(".google.") && replace.contains("/open?")) || ((replace.contains(".google.") && replace.contains("/uc?")) || (replace.contains(".google.") && replace.contains("/get_player") && replace.contains("docid"))))) {
                str2 = Regex.a(replace, "docid=(.*?)(?:&|$)", 1);
                String trim = replace.trim();
                if (str2.isEmpty() && trim.contains("v=")) {
                    str2 = Regex.a(trim, "v=(.*?)(?:&|$)", 1);
                }
                if (str2.isEmpty() && trim.contains("cid")) {
                    str2 = Regex.a(trim, "cid=([\\w]+)", 1);
                }
                if (str2.isEmpty() && trim.contains("/open?")) {
                    str2 = Regex.a(trim, "/open\\?.*?id=(.*?)\\s*(?:&|$)", 1);
                }
                if (str2.isEmpty() && trim.contains("/uc?")) {
                    str2 = Regex.a(trim, "/uc\\?.*?id=(.*?)\\s*(?:&|$)", 1);
                }
                if (str2.isEmpty()) {
                    return false;
                }
                replace = String.format("https://drive.google.com/file/d/%s/edit", new Object[]{str2});
            } else {
                replace = "";
                str2 = replace;
            }
            if (!replace.isEmpty() && !str2.isEmpty()) {
                String m2 = HttpHelper.i().m(replace, new Map[0]);
                String a2 = Regex.a(m2, "['\"]hl['\"]\\s*,\\s*['\"]([^'\"]+)", 1);
                if (a2.isEmpty()) {
                    a2 = "en";
                }
                String a3 = Regex.a(m2, "['\"]ttsurl['\"]\\s*,\\s*['\"]([^'\"]+)", 1);
                if (a3.isEmpty() || Regex.b(StringEscapeUtils.a(a3), "vid(?:=|\\\\u003d)(.*)", 1, 2).isEmpty()) {
                    return false;
                }
                return HttpHelper.i().o(String.format("https://drive.google.com/timedtext?id=%s&vid=%s&hl=%s&type=list&tlangs=1&v=%s&fmts=1&vssids=1", new Object[]{str2, Regex.b(StringEscapeUtils.a(a3), "vid(?:=|\\\\u003d)(.*)", 1, 2), a2, str2}), replace).trim().toLowerCase().contains("<track");
            }
        }
        return false;
    }

    public static String c(String str) {
        try {
            String format = String.format("https://drive.google.com/file/d/%s/edit", new Object[]{str});
            String format2 = String.format("https://drive.google.com/uc?export=download&id=%s", new Object[]{str});
            String s2 = HttpHelper.i().s(format2, false, format);
            if (!HttpHelper.i().n(format2, s2)) {
                return s2;
            }
            String str2 = format2 + "&confirm=" + Regex.c(HttpHelper.i().o(format2, format).replace("\\/", "/").replace("&amp;", "&"), "(?:\\?|&)confirm=(.*?)(?:&|'|\"|>|$)", 1, true);
            String s3 = HttpHelper.i().s(str2, false, format2);
            if (HttpHelper.i().n(format2, s3) || HttpHelper.i().n(str2, s3)) {
                return "";
            }
            return s3;
        } catch (Throwable unused) {
        }
    }

    public static boolean d(String str) {
        String lowerCase = str.trim().toLowerCase();
        if (!n(lowerCase) || (!lowerCase.contains("redirector.") && !lowerCase.contains("googleusercontent") && !lowerCase.contains(".bp.blogspot.com"))) {
            return false;
        }
        return true;
    }

    public static boolean e(String str) {
        String lowerCase = str.trim().toLowerCase();
        if (!lowerCase.contains("-apidata.") || !lowerCase.contains("google")) {
            return false;
        }
        return true;
    }

    public static boolean f(String str) {
        return !Regex.c(str, ".*?-apidata\\..*?google.*?\\.com/.*?storage/v1/b/(.*?)/o/(.*?)(?:$|\\?)", 1, true).isEmpty();
    }

    public static HashMap<String, String> g(String str) {
        if (str == null || str.isEmpty()) {
            return new HashMap<>();
        }
        String replace = str.replace("/preview", "/edit");
        String m2 = HttpHelper.i().m(replace, new Map[0]);
        if ((replace.contains("drive.google") || replace.contains("docs.google")) && !replace.contains("/open?") && !replace.contains("/uc?")) {
            return i(replace, m2);
        }
        if (replace.contains("youtube") || replace.contains("youtu.be") || ((replace.contains(".google.") && replace.contains("/open?")) || ((replace.contains(".google.") && replace.contains("/uc?")) || (replace.contains(".google.") && replace.contains("/get_player") && replace.contains("docid"))))) {
            String a2 = Regex.a(replace, "docid=(.*?)(?:&|$)", 1);
            String trim = replace.trim();
            if (a2.isEmpty() && trim.contains("v=")) {
                a2 = Regex.a(trim, "v=(.*?)(?:&|$)", 1);
            }
            if (a2.isEmpty() && trim.contains("cid")) {
                a2 = Regex.a(trim, "cid=([\\w]+)", 1);
            }
            if (a2.isEmpty() && trim.contains("/open?")) {
                a2 = Regex.a(trim, "/open\\?.*?id=(.*?)\\s*(?:&|$)", 1);
            }
            if (a2.isEmpty() && trim.contains("/uc?")) {
                a2 = Regex.a(trim, "/uc\\?.*?id=(.*?)\\s*(?:&|$)", 1);
            }
            if (a2.isEmpty()) {
                return new HashMap<>();
            }
            String format = String.format("https://drive.google.com/file/d/%s/edit", new Object[]{a2});
            return i(format, HttpHelper.i().m(format, new Map[0]));
        }
        replace.contains("picasaweb");
        return new HashMap<>();
    }

    public static String h(String str) {
        if (str == null || str.isEmpty()) {
            return "HQ";
        }
        String o2 = o(str);
        o2.hashCode();
        char c2 = 65535;
        switch (o2.hashCode()) {
            case 53:
                if (o2.equals("5")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1572:
                if (o2.equals("15")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1574:
                if (o2.equals("17")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1575:
                if (o2.equals("18")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1600:
                if (o2.equals("22")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1633:
                if (o2.equals("34")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1634:
                if (o2.equals("35")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1636:
                if (o2.equals("37")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1637:
                if (o2.equals("38")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1663:
                if (o2.equals("43")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1664:
                if (o2.equals("44")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1665:
                if (o2.equals("45")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1666:
                if (o2.equals("46")) {
                    c2 = 12;
                    break;
                }
                break;
            case 1700:
                if (o2.equals("59")) {
                    c2 = 13;
                    break;
                }
                break;
            case 1761:
                if (o2.equals("78")) {
                    c2 = 14;
                    break;
                }
                break;
            case 1786:
                if (o2.equals("82")) {
                    c2 = 15;
                    break;
                }
                break;
            case 1787:
                if (o2.equals("83")) {
                    c2 = 16;
                    break;
                }
                break;
            case 1788:
                if (o2.equals("84")) {
                    c2 = 17;
                    break;
                }
                break;
            case 1789:
                if (o2.equals("85")) {
                    c2 = 18;
                    break;
                }
                break;
            case 1816:
                if (o2.equals("91")) {
                    c2 = 19;
                    break;
                }
                break;
            case 1817:
                if (o2.equals("92")) {
                    c2 = 20;
                    break;
                }
                break;
            case 1818:
                if (o2.equals("93")) {
                    c2 = 21;
                    break;
                }
                break;
            case 1819:
                if (o2.equals("94")) {
                    c2 = 22;
                    break;
                }
                break;
            case 1820:
                if (o2.equals("95")) {
                    c2 = 23;
                    break;
                }
                break;
            case 1821:
                if (o2.equals("96")) {
                    c2 = 24;
                    break;
                }
                break;
            case 48625:
                if (o2.equals("100")) {
                    c2 = 25;
                    break;
                }
                break;
            case 48626:
                if (o2.equals("101")) {
                    c2 = 26;
                    break;
                }
                break;
            case 48627:
                if (o2.equals("102")) {
                    c2 = 27;
                    break;
                }
                break;
            case 48687:
                if (o2.equals("120")) {
                    c2 = 28;
                    break;
                }
                break;
            case 48688:
                if (o2.equals("121")) {
                    c2 = 29;
                    break;
                }
                break;
            case 48720:
                if (o2.equals("132")) {
                    c2 = 30;
                    break;
                }
                break;
            case 48721:
                if (o2.equals("133")) {
                    c2 = 31;
                    break;
                }
                break;
            case 48722:
                if (o2.equals("134")) {
                    c2 = ' ';
                    break;
                }
                break;
            case 48723:
                if (o2.equals("135")) {
                    c2 = '!';
                    break;
                }
                break;
            case 48724:
                if (o2.equals("136")) {
                    c2 = '\"';
                    break;
                }
                break;
            case 48725:
                if (o2.equals("137")) {
                    c2 = '#';
                    break;
                }
                break;
            case 48781:
                if (o2.equals("151")) {
                    c2 = '$';
                    break;
                }
                break;
            case 48811:
                if (o2.equals("160")) {
                    c2 = '%';
                    break;
                }
                break;
            case 48818:
                if (o2.equals("167")) {
                    c2 = '&';
                    break;
                }
                break;
            case 48819:
                if (o2.equals("168")) {
                    c2 = '\'';
                    break;
                }
                break;
            case 48820:
                if (o2.equals("169")) {
                    c2 = '(';
                    break;
                }
                break;
            case 48842:
                if (o2.equals("170")) {
                    c2 = ')';
                    break;
                }
                break;
            case 49619:
                if (o2.equals("212")) {
                    c2 = '*';
                    break;
                }
                break;
            case 49625:
                if (o2.equals("218")) {
                    c2 = '+';
                    break;
                }
                break;
            case 49626:
                if (o2.equals("219")) {
                    c2 = ',';
                    break;
                }
                break;
            case 49712:
                if (o2.equals("242")) {
                    c2 = '-';
                    break;
                }
                break;
            case 49713:
                if (o2.equals("243")) {
                    c2 = '.';
                    break;
                }
                break;
            case 49714:
                if (o2.equals("244")) {
                    c2 = '/';
                    break;
                }
                break;
            case 49715:
                if (o2.equals("245")) {
                    c2 = '0';
                    break;
                }
                break;
            case 49716:
                if (o2.equals("246")) {
                    c2 = '1';
                    break;
                }
                break;
            case 49717:
                if (o2.equals("247")) {
                    c2 = '2';
                    break;
                }
                break;
            case 49718:
                if (o2.equals("248")) {
                    c2 = '3';
                    break;
                }
                break;
            case 49776:
                if (o2.equals("264")) {
                    c2 = '4';
                    break;
                }
                break;
            case 49778:
                if (o2.equals("266")) {
                    c2 = '5';
                    break;
                }
                break;
            case 49804:
                if (o2.equals("271")) {
                    c2 = '6';
                    break;
                }
                break;
            case 49805:
                if (o2.equals("272")) {
                    c2 = '7';
                    break;
                }
                break;
            case 49811:
                if (o2.equals("278")) {
                    c2 = '8';
                    break;
                }
                break;
            case 49873:
                if (o2.equals("298")) {
                    c2 = '9';
                    break;
                }
                break;
            case 49874:
                if (o2.equals("299")) {
                    c2 = ':';
                    break;
                }
                break;
            case 50549:
                if (o2.equals("302")) {
                    c2 = ';';
                    break;
                }
                break;
            case 50550:
                if (o2.equals("303")) {
                    c2 = '<';
                    break;
                }
                break;
            case 50555:
                if (o2.equals("308")) {
                    c2 = '=';
                    break;
                }
                break;
            case 50581:
                if (o2.equals("313")) {
                    c2 = '>';
                    break;
                }
                break;
            case 50583:
                if (o2.equals("315")) {
                    c2 = '?';
                    break;
                }
                break;
            case 54395385:
                if (o2.equals("99999")) {
                    c2 = '@';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 20:
            case 30:
            case 31:
            case '-':
                return "240p";
            case 1:
            case 4:
            case 11:
            case 17:
            case 23:
            case 27:
            case 28:
            case '\"':
            case '(':
            case '2':
            case '9':
            case ';':
                return "720p";
            case 2:
            case 19:
            case '%':
            case '8':
                return "144p";
            case 3:
            case 5:
            case 9:
            case 15:
            case 21:
            case 25:
            case ' ':
            case '&':
            case '.':
                return "360p";
            case 6:
            case 10:
            case 13:
            case 14:
            case 16:
            case 22:
            case 26:
            case '!':
            case '\'':
            case '*':
            case '+':
            case ',':
            case '/':
            case '0':
            case '1':
                return "480p";
            case 7:
            case 12:
            case 18:
            case 24:
            case 29:
            case '#':
            case ')':
            case '3':
            case ':':
            case '<':
                return "1080p";
            case 8:
            case '5':
            case '7':
            case '>':
            case '?':
                return "4K";
            case '$':
                return "72p";
            case '4':
            case '6':
            case '=':
                return "2K";
            case '@':
                return "HD";
            default:
                return "HQ";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r8 = java.net.URLDecoder.decode(r8);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00b0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.String> i(java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = ""
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            java.lang.String r0 = r8.trim()
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "http"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x0022
            goto L_0x0033
        L_0x0022:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "https://"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L_0x0033:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = 0
            r2 = 1
            java.lang.String r3 = "\\[\\s*\"([^\"]+)\"\\s*,\\s*\"([^\"]+)\"\\s*\\]"
            r4 = 2
            java.util.ArrayList r9 = com.original.tase.utils.Regex.d(r9, r3, r4)     // Catch:{ all -> 0x0082 }
            java.lang.Object r3 = r9.get(r1)     // Catch:{ all -> 0x0082 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0082 }
            java.lang.Object r9 = r9.get(r2)     // Catch:{ all -> 0x0082 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ all -> 0x0082 }
            r4 = 0
        L_0x004e:
            int r5 = r3.size()     // Catch:{ all -> 0x0082 }
            if (r4 >= r5) goto L_0x0083
            java.lang.Object r5 = r3.get(r4)     // Catch:{ all -> 0x007f }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x007f }
            int r6 = r9.size()     // Catch:{ all -> 0x007f }
            if (r4 >= r6) goto L_0x0067
            java.lang.Object r6 = r9.get(r4)     // Catch:{ all -> 0x007f }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x007f }
            goto L_0x0068
        L_0x0067:
            r6 = 0
        L_0x0068:
            if (r6 == 0) goto L_0x007f
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x007f }
            if (r7 != 0) goto L_0x007f
            java.lang.String r7 = "fmt_stream_map"
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x007f }
            if (r5 == 0) goto L_0x007f
            java.util.HashMap r5 = a(r6)     // Catch:{ all -> 0x007f }
            r0.putAll(r5)     // Catch:{ all -> 0x007f }
        L_0x007f:
            int r4 = r4 + 1
            goto L_0x004e
        L_0x0082:
        L_0x0083:
            java.lang.String r9 = j(r8)
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x00cb
            boolean r3 = r9.isEmpty()
            if (r3 != 0) goto L_0x00cb
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ all -> 0x00ca }
            java.lang.String r4 = "https://docs.google.com/get_video_info?docid={docId}&authuser=2&eurl=https://www.youtube.com/embed%2F?status=ok&allow_embed=1&controls=0&ps=docs&partnerid=30&autoplay=0&showinfo=0&public=false&enab&playerretry=2"
            java.lang.String r5 = "{docId}"
            java.lang.String r4 = r4.replace(r5, r9)     // Catch:{ all -> 0x00ca }
            java.lang.String r8 = r3.o(r4, r8)     // Catch:{ all -> 0x00ca }
            boolean r3 = r8.isEmpty()     // Catch:{ all -> 0x00ca }
            if (r3 != 0) goto L_0x00cb
            java.lang.String r3 = "UTF-8"
            java.lang.String r8 = java.net.URLDecoder.decode(r8, r3)     // Catch:{ all -> 0x00b0 }
            goto L_0x00b4
        L_0x00b0:
            java.lang.String r8 = java.net.URLDecoder.decode(r8)     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            java.lang.String r3 = "fmt_stream_map=(.*?)&url_encoded_fmt_stream_map"
            r4 = 34
            java.lang.String r8 = com.original.tase.utils.Regex.b(r8, r3, r2, r4)     // Catch:{ all -> 0x00ca }
            boolean r3 = r8.isEmpty()     // Catch:{ all -> 0x00ca }
            if (r3 != 0) goto L_0x00cb
            java.util.HashMap r8 = a(r8)     // Catch:{ all -> 0x00ca }
            r0.putAll(r8)     // Catch:{ all -> 0x00ca }
            goto L_0x00cb
        L_0x00ca:
        L_0x00cb:
            boolean r8 = r9.isEmpty()
            java.lang.String r3 = "HD"
            if (r8 != 0) goto L_0x00e2
            java.lang.String r8 = c(r9)     // Catch:{ all -> 0x00e1 }
            boolean r4 = r8.isEmpty()     // Catch:{ all -> 0x00e1 }
            if (r4 != 0) goto L_0x00e2
            r0.put(r8, r3)     // Catch:{ all -> 0x00e1 }
            goto L_0x00e2
        L_0x00e1:
        L_0x00e2:
            boolean r8 = r9.isEmpty()
            if (r8 != 0) goto L_0x0102
            java.lang.String r8 = "https://www.googleapis.com/drive/v3/files/%s?alt=media&key=AIzaSyBXV3qGJ2rwDaxvUmAzaVpZMmn1t6PyU0E"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0102 }
            r4[r1] = r9     // Catch:{ all -> 0x0102 }
            java.lang.String r8 = java.lang.String.format(r8, r4)     // Catch:{ all -> 0x0102 }
            r0.put(r8, r3)     // Catch:{ all -> 0x0102 }
            java.lang.String r8 = "https://www.googleapis.com/drive/v3/files/%s?alt=media&key=AIzaSyDPBU51cTvGzh8k8OwUxOS8D_fibFDoNAI"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0102 }
            r2[r1] = r9     // Catch:{ all -> 0x0102 }
            java.lang.String r8 = java.lang.String.format(r8, r2)     // Catch:{ all -> 0x0102 }
            r0.put(r8, r3)     // Catch:{ all -> 0x0102 }
        L_0x0102:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.GoogleVideoHelper.i(java.lang.String, java.lang.String):java.util.HashMap");
    }

    public static String j(String str) {
        String str2;
        if (str != null && !str.isEmpty()) {
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            try {
                Map<String, String> m2 = Utils.m(new URL(str));
                if (m2.containsKey("id") && (str2 = m2.get("id")) != null && !str2.isEmpty()) {
                    return str2;
                }
                String a2 = Regex.a(str, "/d/([^/]{20,40})/", 1);
                if (a2.isEmpty()) {
                    a2 = Regex.a(str, "/d/([^/]+)/", 1);
                }
                if (a2.isEmpty()) {
                    return Regex.a(str, "google.+?([a-zA-Z0-9-_]{25,})", 1);
                }
                return a2;
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static List<MediaSource> k(String str, String str2) {
        HashMap<String, String> g2;
        String str3;
        ArrayList arrayList = new ArrayList();
        if (n(str) && str.contains("docs") && str.contains("*/")) {
            try {
                if (Regex.a(str, "\\*/(.*?)(?:$|\\?)", 1).isEmpty()) {
                    return arrayList;
                }
                String format = String.format("https://drive.google.com/file/d/%s/edit", new Object[]{Regex.a(str, "\\*/(.*?)(?:$|\\?)", 1)});
                if (l(format) && (g2 = g(format)) != null) {
                    if (!g2.isEmpty()) {
                        for (Map.Entry next : g2.entrySet()) {
                            MediaSource mediaSource = new MediaSource(str2, "GoogleVideo", false);
                            mediaSource.setStreamLink((String) next.getKey());
                            if (((String) next.getValue()).isEmpty()) {
                                str3 = "HD";
                            } else {
                                str3 = (String) next.getValue();
                            }
                            mediaSource.setQuality(str3);
                            HashMap hashMap = new HashMap();
                            hashMap.put("User-Agent", Constants.C);
                            hashMap.put("Cookie", m(format, (String) next.getKey()));
                            mediaSource.setPlayHeader(hashMap);
                            arrayList.add(mediaSource);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public static boolean l(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String replace = str.trim().toLowerCase().replace(" ", "");
        if (replace.contains("drive.google") && replace.contains("/file/d/")) {
            return true;
        }
        if (replace.contains("docs.google") && replace.contains("/file/d/")) {
            return true;
        }
        if (replace.contains(".google.") && replace.contains("/open?")) {
            return true;
        }
        if ((replace.contains(".google.") && replace.contains("/uc?")) || replace.contains("youtube.googleapis")) {
            return true;
        }
        if (!replace.contains("youtube") && !replace.contains("youtu.be")) {
            return false;
        }
        if (replace.contains("type=docs") || replace.contains("docid")) {
            return true;
        }
        return false;
    }

    public static String m(String str, String str2) {
        String str3;
        String g2 = HttpHelper.i().g(str);
        if (str2 != null) {
            str3 = HttpHelper.i().g(str2);
        } else {
            str3 = null;
        }
        String str4 = "";
        if (g2.isEmpty()) {
            if (str3 == null || str3.isEmpty()) {
                g2 = str4;
                str3 = g2;
            } else {
                String str5 = str3;
                str3 = g2;
                g2 = str5;
            }
        }
        if (!g2.isEmpty()) {
            str4 = g2 + "; " + str3;
        }
        String g3 = HttpHelper.i().g("docs.google.com");
        if (!g3.isEmpty()) {
            if (!str4.isEmpty()) {
                g3 = "; " + g3;
            }
            str4 = str4 + g3;
        }
        if (str4.contains(";;")) {
            return str4.replace(";;", ";");
        }
        return str4;
    }

    public static boolean n(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String lowerCase = str.trim().toLowerCase();
        if (lowerCase.contains("google") || lowerCase.contains("picasa") || lowerCase.contains("blogspot") || lowerCase.contains("youtube.com/videoplayback") || lowerCase.contains("youtu.be/videoplayback")) {
            return true;
        }
        return false;
    }

    private static String o(String str) {
        if (str == null || str.isEmpty()) {
            return "-1";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Regex.a(str, "itag=(\\d+)", 1));
        arrayList.add(Regex.a(str, "itag%3D(\\d+)", 1));
        arrayList.add(Regex.a(str, "=m(\\d+)$", 1));
        arrayList.add(Regex.a(str, "%3Dm(\\d+)$", 1));
        arrayList.add(Regex.a(str, "=m(\\d+)", 1));
        arrayList.add(Regex.a(str, "%3Dm(\\d+)", 1));
        arrayList.add(Regex.a(str, "\\/m(\\d+?)\\/", 1));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("");
        arrayList.removeAll(arrayList2);
        if (arrayList.isEmpty() && n(str)) {
            return "99999";
        }
        if (arrayList.isEmpty()) {
            return "-1";
        }
        return (String) arrayList.get(0);
    }
}
