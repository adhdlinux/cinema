package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class SpannableBuilder extends SpannableStringBuilder {

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f3129b;

    /* renamed from: c  reason: collision with root package name */
    private final List<WatcherWrapper> f3130c = new ArrayList();

    private static class WatcherWrapper implements TextWatcher, SpanWatcher {

        /* renamed from: b  reason: collision with root package name */
        final Object f3131b;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f3132c = new AtomicInteger(0);

        WatcherWrapper(Object obj) {
            this.f3131b = obj;
        }

        private boolean b(Object obj) {
            return obj instanceof EmojiSpan;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f3132c.incrementAndGet();
        }

        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f3131b).afterTextChanged(editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ((TextWatcher) this.f3131b).beforeTextChanged(charSequence, i2, i3, i4);
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            this.f3132c.decrementAndGet();
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i2, int i3) {
            if (this.f3132c.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f3131b).onSpanAdded(spannable, obj, i2, i3);
            }
        }

        public void onSpanChanged(Spannable spannable, Object obj, int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            if (this.f3132c.get() <= 0 || !b(obj)) {
                if (Build.VERSION.SDK_INT < 28) {
                    if (i2 > i3) {
                        i2 = 0;
                    }
                    if (i4 > i5) {
                        i7 = i2;
                        i6 = 0;
                        ((SpanWatcher) this.f3131b).onSpanChanged(spannable, obj, i7, i3, i6, i5);
                    }
                }
                i7 = i2;
                i6 = i4;
                ((SpanWatcher) this.f3131b).onSpanChanged(spannable, obj, i7, i3, i6, i5);
            }
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
            if (this.f3132c.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f3131b).onSpanRemoved(spannable, obj, i2, i3);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ((TextWatcher) this.f3131b).onTextChanged(charSequence, i2, i3, i4);
        }
    }

    SpannableBuilder(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        Preconditions.h(cls, "watcherClass cannot be null");
        this.f3129b = cls;
    }

    private void b() {
        for (int i2 = 0; i2 < this.f3130c.size(); i2++) {
            this.f3130c.get(i2).a();
        }
    }

    public static SpannableBuilder c(Class<?> cls, CharSequence charSequence) {
        return new SpannableBuilder(cls, charSequence);
    }

    private void e() {
        for (int i2 = 0; i2 < this.f3130c.size(); i2++) {
            this.f3130c.get(i2).onTextChanged(this, 0, length(), length());
        }
    }

    private WatcherWrapper f(Object obj) {
        for (int i2 = 0; i2 < this.f3130c.size(); i2++) {
            WatcherWrapper watcherWrapper = this.f3130c.get(i2);
            if (watcherWrapper.f3131b == obj) {
                return watcherWrapper;
            }
        }
        return null;
    }

    private boolean g(Class<?> cls) {
        return this.f3129b == cls;
    }

    private boolean h(Object obj) {
        return obj != null && g(obj.getClass());
    }

    private void i() {
        for (int i2 = 0; i2 < this.f3130c.size(); i2++) {
            this.f3130c.get(i2).c();
        }
    }

    public void a() {
        b();
    }

    public void d() {
        i();
        e();
    }

    public int getSpanEnd(Object obj) {
        WatcherWrapper f2;
        if (h(obj) && (f2 = f(obj)) != null) {
            obj = f2;
        }
        return super.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        WatcherWrapper f2;
        if (h(obj) && (f2 = f(obj)) != null) {
            obj = f2;
        }
        return super.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        WatcherWrapper f2;
        if (h(obj) && (f2 = f(obj)) != null) {
            obj = f2;
        }
        return super.getSpanStart(obj);
    }

    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        if (!g(cls)) {
            return super.getSpans(i2, i3, cls);
        }
        WatcherWrapper[] watcherWrapperArr = (WatcherWrapper[]) super.getSpans(i2, i3, WatcherWrapper.class);
        T[] tArr = (Object[]) Array.newInstance(cls, watcherWrapperArr.length);
        for (int i4 = 0; i4 < watcherWrapperArr.length; i4++) {
            tArr[i4] = watcherWrapperArr[i4].f3131b;
        }
        return tArr;
    }

    public int nextSpanTransition(int i2, int i3, Class<WatcherWrapper> cls) {
        if (cls == null || g(cls)) {
            cls = WatcherWrapper.class;
        }
        return super.nextSpanTransition(i2, i3, cls);
    }

    public void removeSpan(Object obj) {
        WatcherWrapper watcherWrapper;
        if (h(obj)) {
            watcherWrapper = f(obj);
            if (watcherWrapper != null) {
                obj = watcherWrapper;
            }
        } else {
            watcherWrapper = null;
        }
        super.removeSpan(obj);
        if (watcherWrapper != null) {
            this.f3130c.remove(watcherWrapper);
        }
    }

    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (h(obj)) {
            WatcherWrapper watcherWrapper = new WatcherWrapper(obj);
            this.f3130c.add(watcherWrapper);
            obj = watcherWrapper;
        }
        super.setSpan(obj, i2, i3, i4);
    }

    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int i2, int i3) {
        return new SpannableBuilder(this.f3129b, this, i2, i3);
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int i2, int i3) {
        super.delete(i2, i3);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i2, CharSequence charSequence) {
        super.insert(i2, charSequence);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i2, int i3, CharSequence charSequence) {
        b();
        super.replace(i2, i3, charSequence);
        i();
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i2, CharSequence charSequence, int i3, int i4) {
        super.insert(i2, charSequence, i3, i4);
        return this;
    }

    SpannableBuilder(Class<?> cls, CharSequence charSequence, int i2, int i3) {
        super(charSequence, i2, i3);
        Preconditions.h(cls, "watcherClass cannot be null");
        this.f3129b = cls;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i2, int i3, CharSequence charSequence, int i4, int i5) {
        b();
        super.replace(i2, i3, charSequence, i4, i5);
        i();
        return this;
    }

    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public SpannableStringBuilder append(char c2) {
        super.append(c2);
        return this;
    }

    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i2, int i3) {
        super.append(charSequence, i2, i3);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i2) {
        super.append(charSequence, obj, i2);
        return this;
    }
}
