package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public class AllCapsTransformationMethod implements TransformationMethod {

    /* renamed from: b  reason: collision with root package name */
    private Locale f661b;

    public AllCapsTransformationMethod(Context context) {
        this.f661b = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f661b);
        }
        return null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z2, int i2, Rect rect) {
    }
}
