package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class EmojiInputFilter implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f3158a;

    /* renamed from: b  reason: collision with root package name */
    private EmojiCompat.InitCallback f3159b;

    private static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<TextView> f3160a;

        /* renamed from: b  reason: collision with root package name */
        private final Reference<EmojiInputFilter> f3161b;

        InitCallbackImpl(TextView textView, EmojiInputFilter emojiInputFilter) {
            this.f3160a = new WeakReference(textView);
            this.f3161b = new WeakReference(emojiInputFilter);
        }

        private boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        public void b() {
            CharSequence text;
            CharSequence o2;
            super.b();
            TextView textView = this.f3160a.get();
            if (c(textView, this.f3161b.get()) && textView.isAttachedToWindow() && (text = textView.getText()) != (o2 = EmojiCompat.b().o(text))) {
                int selectionStart = Selection.getSelectionStart(o2);
                int selectionEnd = Selection.getSelectionEnd(o2);
                textView.setText(o2);
                if (o2 instanceof Spannable) {
                    EmojiInputFilter.b((Spannable) o2, selectionStart, selectionEnd);
                }
            }
        }
    }

    EmojiInputFilter(TextView textView) {
        this.f3158a = textView;
    }

    private EmojiCompat.InitCallback a() {
        if (this.f3159b == null) {
            this.f3159b = new InitCallbackImpl(this.f3158a, this);
        }
        return this.f3159b;
    }

    static void b(Spannable spannable, int i2, int i3) {
        if (i2 >= 0 && i3 >= 0) {
            Selection.setSelection(spannable, i2, i3);
        } else if (i2 >= 0) {
            Selection.setSelection(spannable, i2);
        } else if (i3 >= 0) {
            Selection.setSelection(spannable, i3);
        }
    }

    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        if (this.f3158a.isInEditMode()) {
            return charSequence;
        }
        int d2 = EmojiCompat.b().d();
        if (d2 != 0) {
            boolean z2 = true;
            if (d2 == 1) {
                if (i5 == 0 && i4 == 0 && spanned.length() == 0 && charSequence == this.f3158a.getText()) {
                    z2 = false;
                }
                if (!z2 || charSequence == null) {
                    return charSequence;
                }
                if (!(i2 == 0 && i3 == charSequence.length())) {
                    charSequence = charSequence.subSequence(i2, i3);
                }
                return EmojiCompat.b().p(charSequence, 0, charSequence.length());
            } else if (d2 != 3) {
                return charSequence;
            }
        }
        EmojiCompat.b().s(a());
        return charSequence;
    }
}
