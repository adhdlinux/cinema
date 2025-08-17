package com.original.tase.utils;

import com.original.tase.Logger;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static String a(String str, String str2, int i2) {
        if (str != null && !str.isEmpty()) {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            if (matcher.find()) {
                return matcher.group(i2);
            }
        }
        return "";
    }

    public static String b(String str, String str2, int i2, int i3) {
        if (str != null && !str.isEmpty()) {
            Matcher matcher = Pattern.compile(str2, i3).matcher(str);
            if (matcher.find()) {
                return matcher.group(i2);
            }
        }
        return "";
    }

    public static String c(String str, String str2, int i2, boolean z2) {
        Matcher matcher;
        if (str != null && !str.isEmpty()) {
            if (z2) {
                matcher = Pattern.compile(str2, 32).matcher(str);
            } else {
                matcher = Pattern.compile(str2).matcher(str);
            }
            if (matcher.find()) {
                return matcher.group(i2);
            }
        }
        return "";
    }

    public static ArrayList<ArrayList<String>> d(String str, String str2, int i2) {
        Matcher matcher;
        int i3;
        if (str == null) {
            matcher = null;
        } else {
            matcher = Pattern.compile(str2).matcher(str);
        }
        if (matcher == null) {
            i3 = i2;
        } else {
            i3 = Math.max(matcher.groupCount(), i2);
        }
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        if (i3 == 0) {
            arrayList.add(0, new ArrayList());
        } else {
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList.add(i4, new ArrayList());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new ArrayList());
        }
        if (matcher != null && !str.isEmpty()) {
            while (matcher.find()) {
                if (i2 == 0) {
                    try {
                        arrayList.get(0).add(matcher.group(0));
                    } catch (Throwable th) {
                        Logger.d(th, new boolean[0]);
                    }
                } else {
                    int i5 = 0;
                    while (i5 < i2) {
                        i5++;
                        arrayList.get(i5).add(matcher.group(i5));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new ArrayList());
            }
        }
        return arrayList;
    }

    public static ArrayList<ArrayList<String>> e(String str, String str2, int i2, int i3) {
        Matcher matcher;
        int i4;
        if (str == null) {
            matcher = null;
        } else {
            matcher = Pattern.compile(str2, i3).matcher(str);
        }
        if (matcher == null) {
            i4 = i2;
        } else {
            i4 = Math.max(matcher.groupCount(), i2);
        }
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        if (i4 == 0) {
            arrayList.add(0, new ArrayList());
        } else {
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList.add(i5, new ArrayList());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new ArrayList());
        }
        if (matcher != null && !str.isEmpty()) {
            while (matcher.find()) {
                if (i2 == 0) {
                    try {
                        arrayList.get(0).add(matcher.group(0));
                    } catch (Throwable th) {
                        Logger.d(th, new boolean[0]);
                    }
                } else {
                    int i6 = 0;
                    while (i6 < i2) {
                        i6++;
                        arrayList.get(i6).add(matcher.group(i6));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new ArrayList());
            }
        }
        return arrayList;
    }

    public static ArrayList<ArrayList<String>> f(String str, String str2, int i2, boolean z2) {
        Matcher matcher;
        int i3;
        if (str == null) {
            matcher = null;
        } else if (z2) {
            matcher = Pattern.compile(str2, 32).matcher(str);
        } else {
            matcher = Pattern.compile(str2).matcher(str);
        }
        if (matcher == null) {
            i3 = i2;
        } else {
            i3 = Math.max(matcher.groupCount(), i2);
        }
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        if (i3 == 0) {
            arrayList.add(0, new ArrayList());
        } else {
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList.add(i4, new ArrayList());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new ArrayList());
        }
        if (matcher != null && !str.isEmpty()) {
            while (matcher.find()) {
                if (i2 == 0) {
                    try {
                        arrayList.get(0).add(matcher.group(0));
                    } catch (Throwable th) {
                        Logger.d(th, new boolean[0]);
                    }
                } else {
                    int i5 = 0;
                    while (i5 < i2) {
                        i5++;
                        arrayList.get(i5).add(matcher.group(i5));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new ArrayList());
            }
        }
        return arrayList;
    }

    public static ArrayList<String> g(String str, String str2, int i2, boolean z2) {
        Matcher matcher;
        ArrayList<String> arrayList = new ArrayList<>();
        if (str != null && !str.isEmpty()) {
            if (z2) {
                matcher = Pattern.compile(str2, 32).matcher(str);
            } else {
                matcher = Pattern.compile(str2).matcher(str);
            }
            while (matcher.find()) {
                if (!arrayList.contains(matcher.group(i2))) {
                    arrayList.add(matcher.group(i2));
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<String> h(String str, String str2, boolean z2) {
        Matcher matcher;
        ArrayList<String> arrayList = new ArrayList<>();
        if (str != null && !str.isEmpty()) {
            if (z2) {
                matcher = Pattern.compile(str2, 32).matcher(str);
            } else {
                matcher = Pattern.compile(str2).matcher(str);
            }
            while (matcher.find()) {
                if (!arrayList.contains(matcher.group())) {
                    arrayList.add(matcher.group());
                }
            }
        }
        return arrayList;
    }
}
