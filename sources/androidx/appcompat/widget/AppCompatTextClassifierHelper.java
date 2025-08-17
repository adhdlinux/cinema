package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.Preconditions;

final class AppCompatTextClassifierHelper {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1191a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f1192b;

    private static final class Api26Impl {
        private Api26Impl() {
        }

        static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
    }

    AppCompatTextClassifierHelper(TextView textView) {
        this.f1191a = (TextView) Preconditions.g(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f1192b;
        if (textClassifier == null) {
            return Api26Impl.a(this.f1191a);
        }
        return textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f1192b = textClassifier;
    }
}
