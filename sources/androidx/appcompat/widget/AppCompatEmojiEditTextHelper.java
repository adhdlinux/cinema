package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R$styleable;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

class AppCompatEmojiEditTextHelper {

    /* renamed from: a  reason: collision with root package name */
    private final EditText f1132a;

    /* renamed from: b  reason: collision with root package name */
    private final EmojiEditTextHelper f1133b;

    AppCompatEmojiEditTextHelper(EditText editText) {
        this.f1132a = editText;
        this.f1133b = new EmojiEditTextHelper(editText, false);
    }

    /* access modifiers changed from: package-private */
    public KeyListener a(KeyListener keyListener) {
        if (b(keyListener)) {
            return this.f1133b.a(keyListener);
        }
        return keyListener;
    }

    /* access modifiers changed from: package-private */
    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f1133b.b();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void d(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = this.f1132a.getContext().obtainStyledAttributes(attributeSet, R$styleable.f260i0, i2, 0);
        try {
            int i3 = R$styleable.f299w0;
            boolean z2 = true;
            if (obtainStyledAttributes.hasValue(i3)) {
                z2 = obtainStyledAttributes.getBoolean(i3, true);
            }
            obtainStyledAttributes.recycle();
            f(z2);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public InputConnection e(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f1133b.c(inputConnection, editorInfo);
    }

    /* access modifiers changed from: package-private */
    public void f(boolean z2) {
        this.f1133b.d(z2);
    }
}
