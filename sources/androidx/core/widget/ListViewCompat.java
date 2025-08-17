package androidx.core.widget;

import android.widget.ListView;

public final class ListViewCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static boolean a(ListView listView, int i2) {
            return listView.canScrollList(i2);
        }

        static void b(ListView listView, int i2) {
            listView.scrollListBy(i2);
        }
    }

    private ListViewCompat() {
    }

    public static boolean a(ListView listView, int i2) {
        return Api19Impl.a(listView, i2);
    }

    public static void b(ListView listView, int i2) {
        Api19Impl.b(listView, i2);
    }
}
