package com.startapp;

public class x2 {

    /* renamed from: a  reason: collision with root package name */
    private static final int f36908a = 6371000;

    public static double a(double d2, double d3, double d4, double d5) {
        double radians = Math.toRadians(d5 - d3) * Math.cos(Math.toRadians(d2 + d4) / 2.0d);
        double radians2 = Math.toRadians(d4 - d2);
        return Math.sqrt((radians * radians) + (radians2 * radians2)) * 6371000.0d;
    }

    public static double b(double d2, double d3, double d4, double d5) {
        double radians = Math.toRadians(d4 - d2);
        double d6 = radians / 2.0d;
        double radians2 = Math.toRadians(d5 - d3) / 2.0d;
        double sin = (Math.sin(d6) * Math.sin(d6)) + (Math.cos(Math.toRadians(d2)) * Math.cos(Math.toRadians(d4)) * Math.sin(radians2) * Math.sin(radians2));
        return Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * 6371000.0d;
    }
}
