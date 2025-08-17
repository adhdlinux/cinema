package androidx.emoji2.viewsintegration;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.emoji2.text.SpannableBuilder;

final class EmojiEditableFactory extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f3153a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile Editable.Factory f3154b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f3155c;

    @SuppressLint({"PrivateApi"})
    private EmojiEditableFactory() {
        try {
            f3155c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, EmojiEditableFactory.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f3154b == null) {
            synchronized (f3153a) {
                if (f3154b == null) {
                    f3154b = new EmojiEditableFactory();
                }
            }
        }
        return f3154b;
    }

    public Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f3155c;
        if (cls != null) {
            return SpannableBuilder.c(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
