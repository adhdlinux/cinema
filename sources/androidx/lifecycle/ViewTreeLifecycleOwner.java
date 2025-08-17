package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R$id;

public class ViewTreeLifecycleOwner {
    private ViewTreeLifecycleOwner() {
    }

    public static void a(View view, LifecycleOwner lifecycleOwner) {
        view.setTag(R$id.f3772a, lifecycleOwner);
    }
}
