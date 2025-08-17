package androidx.emoji2.viewsintegration;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.Preconditions;

public final class EmojiEditTextHelper {

    /* renamed from: a  reason: collision with root package name */
    private final HelperInternal f3148a;

    /* renamed from: b  reason: collision with root package name */
    private int f3149b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private int f3150c = 0;

    static class HelperInternal {
        HelperInternal() {
        }

        /* access modifiers changed from: package-private */
        public KeyListener a(KeyListener keyListener) {
            return keyListener;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection;
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z2) {
        }
    }

    private static class HelperInternal19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final EditText f3151a;

        /* renamed from: b  reason: collision with root package name */
        private final EmojiTextWatcher f3152b;

        HelperInternal19(EditText editText, boolean z2) {
            this.f3151a = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText, z2);
            this.f3152b = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            editText.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        /* access modifiers changed from: package-private */
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            if (keyListener instanceof NumberKeyListener) {
                return keyListener;
            }
            return new EmojiKeyListener(keyListener);
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f3152b.b();
        }

        /* access modifiers changed from: package-private */
        public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            if (inputConnection instanceof EmojiInputConnection) {
                return inputConnection;
            }
            return new EmojiInputConnection(this.f3151a, inputConnection, editorInfo);
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z2) {
            this.f3152b.d(z2);
        }
    }

    public EmojiEditTextHelper(EditText editText, boolean z2) {
        Preconditions.h(editText, "editText cannot be null");
        this.f3148a = new HelperInternal19(editText, z2);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f3148a.a(keyListener);
    }

    public boolean b() {
        return this.f3148a.b();
    }

    public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f3148a.c(inputConnection, editorInfo);
    }

    public void d(boolean z2) {
        this.f3148a.d(z2);
    }
}
