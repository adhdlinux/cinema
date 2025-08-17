package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

public final class EmojiTextViewHelper {

    /* renamed from: a  reason: collision with root package name */
    private final HelperInternal f3164a;

    static class HelperInternal {
        HelperInternal() {
        }

        /* access modifiers changed from: package-private */
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        public boolean b() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z2) {
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z2) {
        }

        /* access modifiers changed from: package-private */
        public TransformationMethod e(TransformationMethod transformationMethod) {
            return transformationMethod;
        }
    }

    private static class HelperInternal19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f3165a;

        /* renamed from: b  reason: collision with root package name */
        private final EmojiInputFilter f3166b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3167c = true;

        HelperInternal19(TextView textView) {
            this.f3165a = textView;
            this.f3166b = new EmojiInputFilter(textView);
        }

        private InputFilter[] f(InputFilter[] inputFilterArr) {
            for (EmojiInputFilter emojiInputFilter : inputFilterArr) {
                if (emojiInputFilter == this.f3166b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, r0);
            inputFilterArr2[r0] = this.f3166b;
            return inputFilterArr2;
        }

        private SparseArray<InputFilter> g(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
                InputFilter inputFilter = inputFilterArr[i2];
                if (inputFilter instanceof EmojiInputFilter) {
                    sparseArray.put(i2, inputFilter);
                }
            }
            return sparseArray;
        }

        private InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> g2 = g(inputFilterArr);
            if (g2.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length - g2.size())];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (g2.indexOfKey(i3) < 0) {
                    inputFilterArr2[i2] = inputFilterArr[i3];
                    i2++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod j(TransformationMethod transformationMethod) {
            if (transformationMethod instanceof EmojiTransformationMethod) {
                return ((EmojiTransformationMethod) transformationMethod).a();
            }
            return transformationMethod;
        }

        private void k() {
            this.f3165a.setFilters(a(this.f3165a.getFilters()));
        }

        private TransformationMethod m(TransformationMethod transformationMethod) {
            if (!(transformationMethod instanceof EmojiTransformationMethod) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                return new EmojiTransformationMethod(transformationMethod);
            }
            return transformationMethod;
        }

        /* access modifiers changed from: package-private */
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            if (!this.f3167c) {
                return h(inputFilterArr);
            }
            return f(inputFilterArr);
        }

        public boolean b() {
            return this.f3167c;
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z2) {
            if (z2) {
                l();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z2) {
            this.f3167c = z2;
            l();
            k();
        }

        /* access modifiers changed from: package-private */
        public TransformationMethod e(TransformationMethod transformationMethod) {
            if (this.f3167c) {
                return m(transformationMethod);
            }
            return j(transformationMethod);
        }

        /* access modifiers changed from: package-private */
        public void i(boolean z2) {
            this.f3167c = z2;
        }

        /* access modifiers changed from: package-private */
        public void l() {
            this.f3165a.setTransformationMethod(e(this.f3165a.getTransformationMethod()));
        }
    }

    private static class SkippingHelper19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final HelperInternal19 f3168a;

        SkippingHelper19(TextView textView) {
            this.f3168a = new HelperInternal19(textView);
        }

        private boolean f() {
            return !EmojiCompat.h();
        }

        /* access modifiers changed from: package-private */
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            if (f()) {
                return inputFilterArr;
            }
            return this.f3168a.a(inputFilterArr);
        }

        public boolean b() {
            return this.f3168a.b();
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z2) {
            if (!f()) {
                this.f3168a.c(z2);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z2) {
            if (f()) {
                this.f3168a.i(z2);
            } else {
                this.f3168a.d(z2);
            }
        }

        /* access modifiers changed from: package-private */
        public TransformationMethod e(TransformationMethod transformationMethod) {
            if (f()) {
                return transformationMethod;
            }
            return this.f3168a.e(transformationMethod);
        }
    }

    public EmojiTextViewHelper(TextView textView, boolean z2) {
        Preconditions.h(textView, "textView cannot be null");
        if (!z2) {
            this.f3164a = new SkippingHelper19(textView);
        } else {
            this.f3164a = new HelperInternal19(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f3164a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f3164a.b();
    }

    public void c(boolean z2) {
        this.f3164a.c(z2);
    }

    public void d(boolean z2) {
        this.f3164a.d(z2);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f3164a.e(transformationMethod);
    }
}
