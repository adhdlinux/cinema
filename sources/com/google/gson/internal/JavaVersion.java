package com.google.gson.internal;

public final class JavaVersion {

    /* renamed from: a  reason: collision with root package name */
    private static final int f30953a = a();

    private JavaVersion() {
    }

    private static int a() {
        return e(System.getProperty("java.version"));
    }

    private static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb.append(charAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean c() {
        return f30953a >= 9;
    }

    private static int d(String str) {
        try {
            String[] split = str.split("[._]", 3);
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt != 1 || split.length <= 1) {
                return parseInt;
            }
            return Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    static int e(String str) {
        int d2 = d(str);
        if (d2 == -1) {
            d2 = b(str);
        }
        if (d2 == -1) {
            return 6;
        }
        return d2;
    }
}
