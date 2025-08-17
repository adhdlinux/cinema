package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

class CursorFilter extends Filter {

    /* renamed from: a  reason: collision with root package name */
    CursorFilterClient f2985a;

    interface CursorFilterClient {
        void a(Cursor cursor);

        Cursor b(CharSequence charSequence);

        Cursor c();

        CharSequence convertToString(Cursor cursor);
    }

    CursorFilter(CursorFilterClient cursorFilterClient) {
        this.f2985a = cursorFilterClient;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f2985a.convertToString((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor b2 = this.f2985a.b(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (b2 != null) {
            filterResults.count = b2.getCount();
            filterResults.values = b2;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor c2 = this.f2985a.c();
        Object obj = filterResults.values;
        if (obj != null && obj != c2) {
            this.f2985a.a((Cursor) obj);
        }
    }
}
