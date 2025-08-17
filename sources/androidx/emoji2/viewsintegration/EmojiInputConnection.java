package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

final class EmojiInputConnection extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f3156a;

    /* renamed from: b  reason: collision with root package name */
    private final EmojiCompatDeleteHelper f3157b;

    public static class EmojiCompatDeleteHelper {
        public boolean a(InputConnection inputConnection, Editable editable, int i2, int i3, boolean z2) {
            return EmojiCompat.e(inputConnection, editable, i2, i3, z2);
        }

        public void b(EditorInfo editorInfo) {
            if (EmojiCompat.h()) {
                EmojiCompat.b().u(editorInfo);
            }
        }
    }

    EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new EmojiCompatDeleteHelper());
    }

    private Editable a() {
        return this.f3156a.getEditableText();
    }

    public boolean deleteSurroundingText(int i2, int i3) {
        if (this.f3157b.a(this, a(), i2, i3, false) || super.deleteSurroundingText(i2, i3)) {
            return true;
        }
        return false;
    }

    public boolean deleteSurroundingTextInCodePoints(int i2, int i3) {
        if (this.f3157b.a(this, a(), i2, i3, true) || super.deleteSurroundingTextInCodePoints(i2, i3)) {
            return true;
        }
        return false;
    }

    EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, EmojiCompatDeleteHelper emojiCompatDeleteHelper) {
        super(inputConnection, false);
        this.f3156a = textView;
        this.f3157b = emojiCompatDeleteHelper;
        emojiCompatDeleteHelper.b(editorInfo);
    }
}
