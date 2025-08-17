package org.apache.commons.lang3;

import java.lang.reflect.Array;

public class ArrayUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Object[] f41394a = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?>[] f41395b = new Class[0];

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f41396c = new String[0];

    /* renamed from: d  reason: collision with root package name */
    public static final long[] f41397d = new long[0];

    /* renamed from: e  reason: collision with root package name */
    public static final Long[] f41398e = new Long[0];

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f41399f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public static final Integer[] f41400g = new Integer[0];

    /* renamed from: h  reason: collision with root package name */
    public static final short[] f41401h = new short[0];

    /* renamed from: i  reason: collision with root package name */
    public static final Short[] f41402i = new Short[0];

    /* renamed from: j  reason: collision with root package name */
    public static final byte[] f41403j = new byte[0];

    /* renamed from: k  reason: collision with root package name */
    public static final Byte[] f41404k = new Byte[0];

    /* renamed from: l  reason: collision with root package name */
    public static final double[] f41405l = new double[0];

    /* renamed from: m  reason: collision with root package name */
    public static final Double[] f41406m = new Double[0];

    /* renamed from: n  reason: collision with root package name */
    public static final float[] f41407n = new float[0];

    /* renamed from: o  reason: collision with root package name */
    public static final Float[] f41408o = new Float[0];

    /* renamed from: p  reason: collision with root package name */
    public static final boolean[] f41409p = new boolean[0];

    /* renamed from: q  reason: collision with root package name */
    public static final Boolean[] f41410q = new Boolean[0];

    /* renamed from: r  reason: collision with root package name */
    public static final char[] f41411r = new char[0];

    /* renamed from: s  reason: collision with root package name */
    public static final Character[] f41412s = new Character[0];

    public static <T> T[] a(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (Object[]) tArr.clone();
    }

    public static int b(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    public static boolean c(char[] cArr) {
        return b(cArr) == 0;
    }
}
