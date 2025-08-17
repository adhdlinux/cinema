package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R$id;

public class ViewTreeViewModelStoreOwner {
    private ViewTreeViewModelStoreOwner() {
    }

    public static void a(View view, ViewModelStoreOwner viewModelStoreOwner) {
        view.setTag(R$id.f3777a, viewModelStoreOwner);
    }
}
