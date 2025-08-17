package androidx.core.graphics;

import android.graphics.Color;
import com.facebook.imageutils.JfifUtil;

public final class ColorUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<double[]> f2540a = new ThreadLocal<>();

    private ColorUtils() {
    }

    public static void a(int i2, int i3, int i4, float[] fArr) {
        float f2;
        float f3;
        float f4 = ((float) i2) / 255.0f;
        float f5 = ((float) i3) / 255.0f;
        float f6 = ((float) i4) / 255.0f;
        float max = Math.max(f4, Math.max(f5, f6));
        float min = Math.min(f4, Math.min(f5, f6));
        float f7 = max - min;
        float f8 = (max + min) / 2.0f;
        if (max == min) {
            f2 = 0.0f;
            f3 = 0.0f;
        } else {
            if (max == f4) {
                f2 = ((f5 - f6) / f7) % 6.0f;
            } else if (max == f5) {
                f2 = ((f6 - f4) / f7) + 2.0f;
            } else {
                f2 = 4.0f + ((f4 - f5) / f7);
            }
            f3 = f7 / (1.0f - Math.abs((2.0f * f8) - 1.0f));
        }
        float f9 = (f2 * 60.0f) % 360.0f;
        if (f9 < 0.0f) {
            f9 += 360.0f;
        }
        fArr[0] = m(f9, 0.0f, 360.0f);
        fArr[1] = m(f3, 0.0f, 1.0f);
        fArr[2] = m(f8, 0.0f, 1.0f);
    }

    public static void b(int i2, int i3, int i4, double[] dArr) {
        double d2;
        double d3;
        double d4;
        double[] dArr2 = dArr;
        if (dArr2.length == 3) {
            double d5 = ((double) i2) / 255.0d;
            if (d5 < 0.04045d) {
                d2 = d5 / 12.92d;
            } else {
                d2 = Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
            }
            double d6 = ((double) i3) / 255.0d;
            if (d6 < 0.04045d) {
                d3 = d6 / 12.92d;
            } else {
                d3 = Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
            }
            double d7 = ((double) i4) / 255.0d;
            if (d7 < 0.04045d) {
                d4 = d7 / 12.92d;
            } else {
                d4 = Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
            }
            dArr2[0] = ((0.4124d * d2) + (0.3576d * d3) + (0.1805d * d4)) * 100.0d;
            dArr2[1] = ((0.2126d * d2) + (0.7152d * d3) + (0.0722d * d4)) * 100.0d;
            dArr2[2] = ((d2 * 0.0193d) + (d3 * 0.1192d) + (d4 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static int c(double d2, double d3, double d4) {
        double d5;
        double d6;
        double d7;
        double d8 = (((3.2406d * d2) + (-1.5372d * d3)) + (-0.4986d * d4)) / 100.0d;
        double d9 = (((-0.9689d * d2) + (1.8758d * d3)) + (0.0415d * d4)) / 100.0d;
        double d10 = (((0.0557d * d2) + (-0.204d * d3)) + (1.057d * d4)) / 100.0d;
        if (d8 > 0.0031308d) {
            d5 = (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d5 = d8 * 12.92d;
        }
        if (d9 > 0.0031308d) {
            d6 = (Math.pow(d9, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d6 = d9 * 12.92d;
        }
        if (d10 > 0.0031308d) {
            d7 = (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d7 = d10 * 12.92d;
        }
        return Color.rgb(n((int) Math.round(d5 * 255.0d), 0, JfifUtil.MARKER_FIRST_BYTE), n((int) Math.round(d6 * 255.0d), 0, JfifUtil.MARKER_FIRST_BYTE), n((int) Math.round(d7 * 255.0d), 0, JfifUtil.MARKER_FIRST_BYTE));
    }

    public static int d(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((((float) Color.blue(i2)) * f3) + (((float) Color.blue(i3)) * f2)));
    }

    public static double e(int i2, int i3) {
        if (Color.alpha(i3) == 255) {
            if (Color.alpha(i2) < 255) {
                i2 = k(i2, i3);
            }
            double f2 = f(i2) + 0.05d;
            double f3 = f(i3) + 0.05d;
            return Math.max(f2, f3) / Math.min(f2, f3);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i3));
    }

    public static double f(int i2) {
        double[] o2 = o();
        i(i2, o2);
        return o2[1] / 100.0d;
    }

    public static int g(int i2, int i3, float f2) {
        int alpha = Color.alpha(i3);
        int i4 = JfifUtil.MARKER_FIRST_BYTE;
        if (alpha == 255) {
            double d2 = (double) f2;
            if (e(p(i2, JfifUtil.MARKER_FIRST_BYTE), i3) < d2) {
                return -1;
            }
            int i5 = 0;
            for (int i6 = 0; i6 <= 10 && i4 - i5 > 1; i6++) {
                int i7 = (i5 + i4) / 2;
                if (e(p(i2, i7), i3) < d2) {
                    i5 = i7;
                } else {
                    i4 = i7;
                }
            }
            return i4;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i3));
    }

    public static void h(int i2, float[] fArr) {
        a(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
    }

    public static void i(int i2, double[] dArr) {
        b(Color.red(i2), Color.green(i2), Color.blue(i2), dArr);
    }

    private static int j(int i2, int i3) {
        return 255 - (((255 - i3) * (255 - i2)) / JfifUtil.MARKER_FIRST_BYTE);
    }

    public static int k(int i2, int i3) {
        int alpha = Color.alpha(i3);
        int alpha2 = Color.alpha(i2);
        int j2 = j(alpha2, alpha);
        return Color.argb(j2, l(Color.red(i2), alpha2, Color.red(i3), alpha, j2), l(Color.green(i2), alpha2, Color.green(i3), alpha, j2), l(Color.blue(i2), alpha2, Color.blue(i3), alpha, j2));
    }

    private static int l(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return (((i2 * JfifUtil.MARKER_FIRST_BYTE) * i3) + ((i4 * i5) * (255 - i3))) / (i6 * JfifUtil.MARKER_FIRST_BYTE);
    }

    private static float m(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : Math.min(f2, f4);
    }

    private static int n(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : Math.min(i2, i4);
    }

    private static double[] o() {
        ThreadLocal<double[]> threadLocal = f2540a;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    public static int p(int i2, int i3) {
        if (i3 >= 0 && i3 <= 255) {
            return (i2 & 16777215) | (i3 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
