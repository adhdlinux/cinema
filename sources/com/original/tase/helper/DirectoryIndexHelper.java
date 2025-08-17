package com.original.tase.helper;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirectoryIndexHelper {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f33824b = {"(.*?){delim}(\\d{4}){delim}.*?(\\d{3,4})p{delim}(.*)", "(.*?){delim}(\\d{3,4})p{delim}.*?(\\d{4}){delim}(.*)", "(.*?){delim}(\\d{4}){delim}(.*)", "(.*?){delim}(\\d{3,4})p{delim}(.*)", "(.*)(\\.[A-Z\\d]{3}$)", "(.*)"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f33825c = {"(.*?){delim}S(\\d+){delim}*E(\\d+)(?:E\\d+)*.*?{delim}(\\d{3,4})p{delim}?(.*)", "(.*?){delim}(\\d+)x(\\d+)(?:-\\d+)*.*?{delim}(\\d{3,4})p{delim}?(.*)", "(.*?){delim}SEASON{delim}*(\\d+){delim}*EPISODE{delim}*(\\d+).*?{delim}(\\d{3,4})p{delim}?(.*)", "(.*?){delim}\\[S(\\d+)\\]{delim}*\\[E(\\d+)(?:E\\d+)*\\].*?{delim}(\\d{3,4})p{delim}?(.*)", "(.*?){delim}S(\\d+){delim}*EP(\\d+)(?:EP\\d+)*.*?{delim}(\\d{3,4})p{delim}?(.*)", "(.*?){delim}S(\\d+){delim}*E(\\d+)(?:E\\d+)*{delim}?(.*)", "(.*?){delim}(\\d+)x(\\d+)(?:-\\d+)*{delim}?(.*)", "(.*?){delim}SEASON{delim}*(\\d+){delim}*EPISODE{delim}*(\\d+){delim}?(.*)", "(.*?){delim}\\[S(\\d+)\\]{delim}*\\[E(\\d+)(?:E\\d+)*\\]{delim}?(.*)", "(.*?){delim}S(\\d+){delim}*EP(\\d+)(?:E\\d+)*{delim}?(.*)", "(.*?){delim}(\\d{3,4})p{delim}?(.*)", "(.*)"};

    /* renamed from: a  reason: collision with root package name */
    private String f33826a;

    public static class ParsedLinkModel {

        /* renamed from: a  reason: collision with root package name */
        private String f33827a = "HQ";

        /* renamed from: b  reason: collision with root package name */
        private String f33828b = "";

        /* renamed from: c  reason: collision with root package name */
        private boolean f33829c = false;

        /* renamed from: d  reason: collision with root package name */
        private int f33830d = -1;

        /* renamed from: e  reason: collision with root package name */
        private final String f33831e;

        /* renamed from: f  reason: collision with root package name */
        private int f33832f = -1;

        /* renamed from: g  reason: collision with root package name */
        private int f33833g = -1;

        /* renamed from: h  reason: collision with root package name */
        private final int f33834h;

        public ParsedLinkModel(int i2, String str) {
            this.f33834h = i2;
            this.f33831e = str;
        }

        public boolean a() {
            return this.f33829c;
        }

        public String b() {
            return this.f33828b;
        }

        public String c() {
            if (this.f33828b != null) {
                if (a()) {
                    this.f33828b += "-3d";
                }
                if (this.f33827a.equalsIgnoreCase("4K") || this.f33827a.equalsIgnoreCase("2160") || this.f33828b.trim().toLowerCase().contains("4k") || this.f33828b.trim().toLowerCase().contains("2160") || this.f33828b.trim().toLowerCase().contains("ultrahd")) {
                    this.f33827a = "4K";
                } else if (this.f33827a.equalsIgnoreCase("1080") || this.f33828b.trim().toLowerCase().contains("1080")) {
                    this.f33827a = "1080";
                } else if (this.f33827a.equalsIgnoreCase("720") || this.f33828b.trim().toLowerCase().contains("720")) {
                    this.f33827a = "720";
                } else if (this.f33827a.equalsIgnoreCase("HQ") && (this.f33828b.trim().toLowerCase().contains("brrip") || this.f33828b.trim().toLowerCase().contains("bdrip") || this.f33828b.trim().toLowerCase().contains("web-dl"))) {
                    this.f33827a = "HD";
                }
            }
            return this.f33827a;
        }

        public void d(int i2) {
            this.f33832f = i2;
        }

        public void e(String str) {
            this.f33828b = str;
        }

        public void f(int i2) {
            this.f33830d = i2;
        }

        public void g(int i2) {
            this.f33833g = i2;
        }

        public void h(String str) {
            this.f33827a = str;
        }

        public void i(boolean z2) {
            this.f33829c = z2;
        }

        public String toString() {
            return "ParsedLinkModel{type=" + this.f33834h + ", title='" + this.f33831e + '\'' + ", year=" + this.f33833g + ", season=" + this.f33832f + ", episode=" + this.f33830d + ", quality='" + this.f33827a + '\'' + ", extra='" + this.f33828b + '\'' + '}';
        }
    }

    public DirectoryIndexHelper() {
        this("\\s*<a\\s+href=\"([^\"]+)\">([^<]+)</a>");
    }

    private boolean a(String str) {
        return str.toLowerCase().contains("3d");
    }

    private ParsedLinkModel b(String str, String[] strArr, int i2) {
        String str2;
        try {
            str2 = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = URLDecoder.decode(str);
        }
        if (str2.contains("/")) {
            String[] split = str2.split("\\/");
            if (split.length > 1) {
                str2 = split[split.length - 1];
            }
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            Matcher matcher = Pattern.compile(strArr[i3].replace("{delim}", "[._ -]"), 34).matcher(str2);
            int groupCount = matcher.groupCount();
            while (matcher.find()) {
                if (matcher.matches()) {
                    if (i2 == 0) {
                        if (groupCount == 5) {
                            String group = matcher.group(1);
                            String group2 = matcher.group(2);
                            String group3 = matcher.group(3);
                            String group4 = matcher.group(4);
                            String group5 = matcher.group(5);
                            ParsedLinkModel parsedLinkModel = new ParsedLinkModel(i2, group);
                            parsedLinkModel.d(Integer.parseInt(group2));
                            parsedLinkModel.f(Integer.parseInt(group3));
                            parsedLinkModel.h(group4);
                            parsedLinkModel.e(group5);
                            parsedLinkModel.i(a(str2));
                            return parsedLinkModel;
                        } else if (groupCount == 4) {
                            String group6 = matcher.group(1);
                            String group7 = matcher.group(2);
                            String group8 = matcher.group(3);
                            String group9 = matcher.group(4);
                            ParsedLinkModel parsedLinkModel2 = new ParsedLinkModel(i2, group6);
                            parsedLinkModel2.d(Integer.parseInt(group7));
                            parsedLinkModel2.f(Integer.parseInt(group8));
                            parsedLinkModel2.i(a(str2));
                            parsedLinkModel2.e(group9);
                            return parsedLinkModel2;
                        } else if (groupCount == 3) {
                            String group10 = matcher.group(1);
                            String group11 = matcher.group(2);
                            String group12 = matcher.group(3);
                            ParsedLinkModel parsedLinkModel3 = new ParsedLinkModel(i2, group10);
                            parsedLinkModel3.h(group11);
                            parsedLinkModel3.e(group12);
                            parsedLinkModel3.i(a(str2));
                            return parsedLinkModel3;
                        } else if (groupCount == 1) {
                            ParsedLinkModel parsedLinkModel4 = new ParsedLinkModel(i2, matcher.group(1));
                            parsedLinkModel4.i(a(str2));
                            return parsedLinkModel4;
                        }
                    } else if (i2 == 1) {
                        if (i3 == 0) {
                            String group13 = matcher.group(1);
                            String group14 = matcher.group(2);
                            String group15 = matcher.group(3);
                            String group16 = matcher.group(4);
                            ParsedLinkModel parsedLinkModel5 = new ParsedLinkModel(i2, group13);
                            parsedLinkModel5.g(Integer.parseInt(group14));
                            parsedLinkModel5.h(group15);
                            parsedLinkModel5.e(group16);
                            parsedLinkModel5.i(a(str2));
                            return parsedLinkModel5;
                        } else if (i3 == 1) {
                            String group17 = matcher.group(1);
                            String group18 = matcher.group(2);
                            String group19 = matcher.group(3);
                            String group20 = matcher.group(4);
                            ParsedLinkModel parsedLinkModel6 = new ParsedLinkModel(i2, group17);
                            parsedLinkModel6.h(group18);
                            parsedLinkModel6.g(Integer.parseInt(group19));
                            parsedLinkModel6.e(group20);
                            parsedLinkModel6.i(a(str2));
                            return parsedLinkModel6;
                        } else if (i3 == 2) {
                            String group21 = matcher.group(1);
                            String group22 = matcher.group(2);
                            String group23 = matcher.group(3);
                            ParsedLinkModel parsedLinkModel7 = new ParsedLinkModel(i2, group21);
                            parsedLinkModel7.g(Integer.parseInt(group22));
                            parsedLinkModel7.e(group23);
                            parsedLinkModel7.i(a(str2));
                            return parsedLinkModel7;
                        } else if (i3 == 3) {
                            String group24 = matcher.group(1);
                            String group25 = matcher.group(2);
                            String group26 = matcher.group(3);
                            ParsedLinkModel parsedLinkModel8 = new ParsedLinkModel(i2, group24);
                            parsedLinkModel8.h(group25);
                            parsedLinkModel8.e(group26);
                            parsedLinkModel8.i(a(str2));
                            return parsedLinkModel8;
                        } else if (i3 >= 4) {
                            ParsedLinkModel parsedLinkModel9 = new ParsedLinkModel(i2, matcher.group(1));
                            parsedLinkModel9.i(a(str2));
                            return parsedLinkModel9;
                        }
                    }
                    return null;
                }
            }
        }
        return null;
    }

    public ParsedLinkModel c(String str) {
        return b(str, f33824b, 1);
    }

    public ParsedLinkModel d(String str) {
        return b(str, f33825c, 0);
    }

    public DirectoryIndexHelper(String str) {
        this.f33826a = str;
    }
}
