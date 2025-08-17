package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class EmojiTextWatcher implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    private final EditText f3169b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3170c;

    /* renamed from: d  reason: collision with root package name */
    private EmojiCompat.InitCallback f3171d;

    /* renamed from: e  reason: collision with root package name */
    private int f3172e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    private int f3173f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3174g;

    private static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<EditText> f3175a;

        InitCallbackImpl(EditText editText) {
            this.f3175a = new WeakReference(editText);
        }

        public void b() {
            super.b();
            EmojiTextWatcher.c(this.f3175a.get(), 1);
        }
    }

    EmojiTextWatcher(EditText editText, boolean z2) {
        this.f3169b = editText;
        this.f3170c = z2;
        this.f3174g = true;
    }

    private EmojiCompat.InitCallback a() {
        if (this.f3171d == null) {
            this.f3171d = new InitCallbackImpl(this.f3169b);
        }
        return this.f3171d;
    }

    static void c(EditText editText, int i2) {
        if (i2 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.b().o(editableText);
            EmojiInputFilter.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean e() {
        return !this.f3174g || (!this.f3170c && !EmojiCompat.h());
    }

    public void afterTextChanged(Editable editable) {
    }

    public boolean b() {
        return this.f3174g;
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void d(boolean z2) {
        if (this.f3174g != z2) {
            if (this.f3171d != null) {
                EmojiCompat.b().t(this.f3171d);
            }
            this.f3174g = z2;
            if (z2) {
                c(this.f3169b, EmojiCompat.b().d());
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (!this.f3169b.isInEditMode() && !e() && i3 <= i4 && (charSequence instanceof Spannable)) {
            int d2 = EmojiCompat.b().d();
            if (d2 != 0) {
                if (d2 == 1) {
                    EmojiCompat.b().r((Spannable) charSequence, i2, i2 + i4, this.f3172e, this.f3173f);
                    return;
                } else if (d2 != 3) {
                    return;
                }
            }
            EmojiCompat.b().s(a());
        }
    }
}
