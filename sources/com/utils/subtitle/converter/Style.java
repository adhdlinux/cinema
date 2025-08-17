package com.utils.subtitle.converter;

import com.facebook.hermes.intl.Constants;

public class Style {

    /* renamed from: j  reason: collision with root package name */
    private static int f37722j;

    /* renamed from: a  reason: collision with root package name */
    protected String f37723a;

    /* renamed from: b  reason: collision with root package name */
    protected String f37724b;

    /* renamed from: c  reason: collision with root package name */
    protected String f37725c;

    /* renamed from: d  reason: collision with root package name */
    protected String f37726d;

    /* renamed from: e  reason: collision with root package name */
    protected String f37727e;

    /* renamed from: f  reason: collision with root package name */
    protected String f37728f = "";

    /* renamed from: g  reason: collision with root package name */
    protected boolean f37729g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f37730h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f37731i;

    protected Style(String str) {
        this.f37723a = str;
    }

    protected static String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.COLLATION_DEFAULT);
        int i2 = f37722j;
        f37722j = i2 + 1;
        sb.append(i2);
        return sb.toString();
    }

    protected static String b(String str, String str2) {
        if (str.equalsIgnoreCase("name")) {
            if (str2.equals("transparent")) {
                return "00000000";
            }
            if (str2.equals("black")) {
                return "000000ff";
            }
            if (str2.equals("silver")) {
                return "c0c0c0ff";
            }
            if (str2.equals("gray")) {
                return "808080ff";
            }
            if (str2.equals("white")) {
                return "ffffffff";
            }
            if (str2.equals("maroon")) {
                return "800000ff";
            }
            if (str2.equals("red")) {
                return "ff0000ff";
            }
            if (str2.equals("purple")) {
                return "800080ff";
            }
            if (str2.equals("fuchsia")) {
                return "ff00ffff";
            }
            if (str2.equals("magenta")) {
                return "ff00ffff ";
            }
            if (str2.equals("green")) {
                return "008000ff";
            }
            if (str2.equals("lime")) {
                return "00ff00ff";
            }
            if (str2.equals("olive")) {
                return "808000ff";
            }
            if (str2.equals("yellow")) {
                return "ffff00ff";
            }
            if (str2.equals("navy")) {
                return "000080ff";
            }
            if (str2.equals("blue")) {
                return "0000ffff";
            }
            if (str2.equals("teal")) {
                return "008080ff";
            }
            if (str2.equals("aqua")) {
                return "00ffffff";
            }
            if (str2.equals("cyan")) {
                return "00ffffff ";
            }
        } else if (str.equalsIgnoreCase("&HBBGGRR")) {
            return str2.substring(6) + str2.substring(4, 5) + str2.substring(2, 3) + "ff";
        } else if (str.equalsIgnoreCase("&HAABBGGRR")) {
            return str2.substring(8) + str2.substring(6, 7) + str2.substring(4, 5) + str2.substring(2, 3);
        } else if (str.equalsIgnoreCase("decimalCodedBBGGRR")) {
            String hexString = Integer.toHexString(Integer.parseInt(str2));
            while (hexString.length() < 6) {
                hexString = "0" + hexString;
            }
            return hexString.substring(4) + hexString.substring(2, 4) + hexString.substring(0, 2) + "ff";
        } else if (str.equalsIgnoreCase("decimalCodedAABBGGRR")) {
            String hexString2 = Long.toHexString(Long.parseLong(str2));
            while (hexString2.length() < 8) {
                hexString2 = "0" + hexString2;
            }
            return hexString2.substring(6) + hexString2.substring(4, 6) + hexString2.substring(2, 4) + hexString2.substring(0, 2);
        }
        return null;
    }

    protected Style(String str, Style style) {
        this.f37723a = str;
        this.f37724b = style.f37724b;
        this.f37725c = style.f37725c;
        this.f37726d = style.f37726d;
        this.f37727e = style.f37727e;
        this.f37728f = style.f37728f;
        this.f37729g = style.f37729g;
        this.f37731i = style.f37731i;
        this.f37730h = style.f37730h;
    }
}
