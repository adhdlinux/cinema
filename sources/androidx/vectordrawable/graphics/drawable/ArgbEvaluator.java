package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
import com.facebook.imageutils.JfifUtil;

public class ArgbEvaluator implements TypeEvaluator {

    /* renamed from: a  reason: collision with root package name */
    private static final ArgbEvaluator f11855a = new ArgbEvaluator();

    public static ArgbEvaluator a() {
        return f11855a;
    }

    public Object evaluate(float f2, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        float f3 = ((float) ((intValue >> 24) & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f), 2.2d);
        float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f), 2.2d);
        float pow3 = (float) Math.pow((double) (((float) (intValue & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f), 2.2d);
        float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f), 2.2d);
        float pow5 = pow3 + (f2 * (((float) Math.pow((double) (((float) (intValue2 & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f), 2.2d)) - pow3));
        return Integer.valueOf((Math.round(((float) Math.pow((double) (pow + ((pow4 - pow) * f2)), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round((f3 + (((((float) ((intValue2 >> 24) & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f) - f3) * f2)) * 255.0f) << 24) | (Math.round(((float) Math.pow((double) (pow2 + ((((float) Math.pow((double) (((float) ((intValue2 >> 8) & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f), 2.2d)) - pow2) * f2)), 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow((double) pow5, 0.45454545454545453d)) * 255.0f));
    }
}
