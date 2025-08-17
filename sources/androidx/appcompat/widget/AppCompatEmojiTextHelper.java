package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

class AppCompatEmojiTextHelper {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f1134a;

    /* renamed from: b  reason: collision with root package name */
    private final EmojiTextViewHelper f1135b;

    AppCompatEmojiTextHelper(TextView textView) {
        this.f1134a = textView;
        this.f1135b = new EmojiTextViewHelper(textView, false);
    }

    /* access modifiers changed from: package-private */
    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f1135b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f1135b.b();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = this.f1134a.getContext().obtainStyledAttributes(attributeSet, R$styleable.f260i0, i2, 0);
        try {
            int i3 = R$styleable.f299w0;
            boolean z2 = true;
            if (obtainStyledAttributes.hasValue(i3)) {
                z2 = obtainStyledAttributes.getBoolean(i3, true);
            }
            obtainStyledAttributes.recycle();
            e(z2);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(boolean z2) {
        this.f1135b.c(z2);
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z2) {
        this.f1135b.d(z2);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f1135b.e(transformationMethod);
    }
}
