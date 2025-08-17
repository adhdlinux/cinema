package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public interface MenuProvider {
    void a(Menu menu);

    void b(Menu menu);

    boolean c(MenuItem menuItem);

    void d(Menu menu, MenuInflater menuInflater);
}
