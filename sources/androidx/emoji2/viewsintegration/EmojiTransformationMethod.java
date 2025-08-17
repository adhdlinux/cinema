package androidx.emoji2.viewsintegration;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

class EmojiTransformationMethod implements TransformationMethod {

    /* renamed from: b  reason: collision with root package name */
    private final TransformationMethod f3176b;

    EmojiTransformationMethod(TransformationMethod transformationMethod) {
        this.f3176b = transformationMethod;
    }

    public TransformationMethod a() {
        return this.f3176b;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f3176b;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence == null || EmojiCompat.b().d() != 1) {
            return charSequence;
        }
        return EmojiCompat.b().o(charSequence);
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z2, int i2, Rect rect) {
        TransformationMethod transformationMethod = this.f3176b;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z2, i2, rect);
        }
    }
}
