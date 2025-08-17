package com.utils.subtitle.converter;

import org.joda.time.DateTimeConstants;

public class Time {

    /* renamed from: a  reason: collision with root package name */
    public int f37732a;

    protected Time(String str, String str2) {
        if (str.equalsIgnoreCase("hh:mm:ss,ms")) {
            int parseInt = Integer.parseInt(str2.substring(0, 2));
            int parseInt2 = Integer.parseInt(str2.substring(3, 5));
            this.f37732a = Integer.parseInt(str2.substring(9, 12)) + (Integer.parseInt(str2.substring(6, 8)) * 1000) + (parseInt2 * DateTimeConstants.MILLIS_PER_MINUTE) + (parseInt * DateTimeConstants.MILLIS_PER_HOUR);
        } else if (str.equalsIgnoreCase("h:mm:ss.cs")) {
            int parseInt3 = Integer.parseInt(str2.substring(0, 1));
            int parseInt4 = Integer.parseInt(str2.substring(2, 4));
            this.f37732a = (Integer.parseInt(str2.substring(8, 10)) * 10) + (Integer.parseInt(str2.substring(5, 7)) * 1000) + (parseInt4 * DateTimeConstants.MILLIS_PER_MINUTE) + (parseInt3 * DateTimeConstants.MILLIS_PER_HOUR);
        } else if (str.equalsIgnoreCase("h:m:s:f/fps")) {
            String[] split = str2.split("/");
            float parseFloat = Float.parseFloat(split[1]);
            String[] split2 = split[0].split(":");
            int parseInt5 = Integer.parseInt(split2[0]);
            int parseInt6 = Integer.parseInt(split2[1]);
            this.f37732a = ((int) (((float) (Integer.parseInt(split2[3]) * 1000)) / parseFloat)) + (Integer.parseInt(split2[2]) * 1000) + (parseInt6 * DateTimeConstants.MILLIS_PER_MINUTE) + (parseInt5 * DateTimeConstants.MILLIS_PER_HOUR);
        }
    }

    /* access modifiers changed from: protected */
    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        if (str.equalsIgnoreCase("hh:mm:ss,ms")) {
            String valueOf = String.valueOf(this.f37732a / DateTimeConstants.MILLIS_PER_HOUR);
            if (valueOf.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf);
            sb.append(':');
            String valueOf2 = String.valueOf((this.f37732a / DateTimeConstants.MILLIS_PER_MINUTE) % 60);
            if (valueOf2.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf2);
            sb.append(':');
            String valueOf3 = String.valueOf((this.f37732a / 1000) % 60);
            if (valueOf3.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf3);
            sb.append(',');
            String valueOf4 = String.valueOf(this.f37732a % 1000);
            if (valueOf4.length() == 1) {
                sb.append("00");
            } else if (valueOf4.length() == 2) {
                sb.append('0');
            }
            sb.append(valueOf4);
        } else if (str.equalsIgnoreCase("h:mm:ss.cs")) {
            String valueOf5 = String.valueOf(this.f37732a / DateTimeConstants.MILLIS_PER_HOUR);
            if (valueOf5.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf5);
            sb.append(':');
            String valueOf6 = String.valueOf((this.f37732a / DateTimeConstants.MILLIS_PER_MINUTE) % 60);
            if (valueOf6.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf6);
            sb.append(':');
            String valueOf7 = String.valueOf((this.f37732a / 1000) % 60);
            if (valueOf7.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf7);
            sb.append('.');
            String valueOf8 = String.valueOf((this.f37732a / 10) % 100);
            if (valueOf8.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf8);
        } else if (str.startsWith("hhmmssff/")) {
            float parseFloat = Float.parseFloat(str.split("/")[1]);
            String valueOf9 = String.valueOf(this.f37732a / DateTimeConstants.MILLIS_PER_HOUR);
            if (valueOf9.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf9);
            String valueOf10 = String.valueOf((this.f37732a / DateTimeConstants.MILLIS_PER_MINUTE) % 60);
            if (valueOf10.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf10);
            String valueOf11 = String.valueOf((this.f37732a / 1000) % 60);
            if (valueOf11.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf11);
            String valueOf12 = String.valueOf(((this.f37732a % 1000) * ((int) parseFloat)) / 1000);
            if (valueOf12.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf12);
        } else if (str.startsWith("h:m:s:f/")) {
            float parseFloat2 = Float.parseFloat(str.split("/")[1]);
            sb.append(String.valueOf(this.f37732a / DateTimeConstants.MILLIS_PER_HOUR));
            sb.append(':');
            sb.append(String.valueOf((this.f37732a / DateTimeConstants.MILLIS_PER_MINUTE) % 60));
            sb.append(':');
            sb.append(String.valueOf((this.f37732a / 1000) % 60));
            sb.append(':');
            sb.append(String.valueOf(((this.f37732a % 1000) * ((int) parseFloat2)) / 1000));
        } else if (str.startsWith("hh:mm:ss:ff/")) {
            float parseFloat3 = Float.parseFloat(str.split("/")[1]);
            String valueOf13 = String.valueOf(this.f37732a / DateTimeConstants.MILLIS_PER_HOUR);
            if (valueOf13.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf13);
            sb.append(':');
            String valueOf14 = String.valueOf((this.f37732a / DateTimeConstants.MILLIS_PER_MINUTE) % 60);
            if (valueOf14.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf14);
            sb.append(':');
            String valueOf15 = String.valueOf((this.f37732a / 1000) % 60);
            if (valueOf15.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf15);
            sb.append(':');
            String valueOf16 = String.valueOf(((this.f37732a % 1000) * ((int) parseFloat3)) / 1000);
            if (valueOf16.length() == 1) {
                sb.append('0');
            }
            sb.append(valueOf16);
        }
        return sb.toString();
    }
}
