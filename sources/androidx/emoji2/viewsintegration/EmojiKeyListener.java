package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

final class EmojiKeyListener implements KeyListener {

    /* renamed from: a  reason: collision with root package name */
    private final KeyListener f3162a;

    /* renamed from: b  reason: collision with root package name */
    private final EmojiCompatHandleKeyDownHelper f3163b;

    public static class EmojiCompatHandleKeyDownHelper {
        public boolean a(Editable editable, int i2, KeyEvent keyEvent) {
            return EmojiCompat.f(editable, i2, keyEvent);
        }
    }

    EmojiKeyListener(KeyListener keyListener) {
        this(keyListener, new EmojiCompatHandleKeyDownHelper());
    }

    public void clearMetaKeyState(View view, Editable editable, int i2) {
        this.f3162a.clearMetaKeyState(view, editable, i2);
    }

    public int getInputType() {
        return this.f3162a.getInputType();
    }

    public boolean onKeyDown(View view, Editable editable, int i2, KeyEvent keyEvent) {
        if (this.f3163b.a(editable, i2, keyEvent) || this.f3162a.onKeyDown(view, editable, i2, keyEvent)) {
            return true;
        }
        return false;
    }

    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f3162a.onKeyOther(view, editable, keyEvent);
    }

    public boolean onKeyUp(View view, Editable editable, int i2, KeyEvent keyEvent) {
        return this.f3162a.onKeyUp(view, editable, i2, keyEvent);
    }

    EmojiKeyListener(KeyListener keyListener, EmojiCompatHandleKeyDownHelper emojiCompatHandleKeyDownHelper) {
        this.f3162a = keyListener;
        this.f3163b = emojiCompatHandleKeyDownHelper;
    }
}
