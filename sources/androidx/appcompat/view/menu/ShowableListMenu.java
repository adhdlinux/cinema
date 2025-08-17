package androidx.appcompat.view.menu;

import android.widget.ListView;

public interface ShowableListMenu {
    void dismiss();

    boolean isShowing();

    ListView n();

    void show();
}
