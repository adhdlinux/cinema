package a;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;

public final /* synthetic */ class d implements InputConnectionCompat.OnCommitContentListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f2a;

    public /* synthetic */ d(View view) {
        this.f2a = view;
    }

    public final boolean a(InputContentInfoCompat inputContentInfoCompat, int i2, Bundle bundle) {
        return InputConnectionCompat.f(this.f2a, inputContentInfoCompat, i2, bundle);
    }
}
