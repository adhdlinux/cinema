package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.cursoradapter.widget.CursorFilter;

public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {

    /* renamed from: b  reason: collision with root package name */
    protected boolean f2974b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f2975c;

    /* renamed from: d  reason: collision with root package name */
    protected Cursor f2976d;

    /* renamed from: e  reason: collision with root package name */
    protected Context f2977e;

    /* renamed from: f  reason: collision with root package name */
    protected int f2978f;

    /* renamed from: g  reason: collision with root package name */
    protected ChangeObserver f2979g;

    /* renamed from: h  reason: collision with root package name */
    protected DataSetObserver f2980h;

    /* renamed from: i  reason: collision with root package name */
    protected CursorFilter f2981i;

    /* renamed from: j  reason: collision with root package name */
    protected FilterQueryProvider f2982j;

    private class ChangeObserver extends ContentObserver {
        ChangeObserver() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z2) {
            CursorAdapter.this.h();
        }
    }

    private class MyDataSetObserver extends DataSetObserver {
        MyDataSetObserver() {
        }

        public void onChanged() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f2974b = true;
            cursorAdapter.notifyDataSetChanged();
        }

        public void onInvalidated() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f2974b = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z2) {
        e(context, cursor, z2 ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor i2 = i(cursor);
        if (i2 != null) {
            i2.close();
        }
    }

    public Cursor b(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.f2982j;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.f2976d;
    }

    public Cursor c() {
        return this.f2976d;
    }

    public CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return "";
        }
        return cursor.toString();
    }

    public abstract void d(View view, Context context, Cursor cursor);

    /* access modifiers changed from: package-private */
    public void e(Context context, Cursor cursor, int i2) {
        int i3;
        boolean z2 = false;
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.f2975c = true;
        } else {
            this.f2975c = false;
        }
        if (cursor != null) {
            z2 = true;
        }
        this.f2976d = cursor;
        this.f2974b = z2;
        this.f2977e = context;
        if (z2) {
            i3 = cursor.getColumnIndexOrThrow("_id");
        } else {
            i3 = -1;
        }
        this.f2978f = i3;
        if ((i2 & 2) == 2) {
            this.f2979g = new ChangeObserver();
            this.f2980h = new MyDataSetObserver();
        } else {
            this.f2979g = null;
            this.f2980h = null;
        }
        if (z2) {
            ChangeObserver changeObserver = this.f2979g;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.f2980h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View f(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    public int getCount() {
        Cursor cursor;
        if (!this.f2974b || (cursor = this.f2976d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f2974b) {
            return null;
        }
        this.f2976d.moveToPosition(i2);
        if (view == null) {
            view = f(this.f2977e, this.f2976d, viewGroup);
        }
        d(view, this.f2977e, this.f2976d);
        return view;
    }

    public Filter getFilter() {
        if (this.f2981i == null) {
            this.f2981i = new CursorFilter(this);
        }
        return this.f2981i;
    }

    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.f2974b || (cursor = this.f2976d) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f2976d;
    }

    public long getItemId(int i2) {
        Cursor cursor;
        if (!this.f2974b || (cursor = this.f2976d) == null || !cursor.moveToPosition(i2)) {
            return 0;
        }
        return this.f2976d.getLong(this.f2978f);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f2974b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f2976d.moveToPosition(i2)) {
            if (view == null) {
                view = g(this.f2977e, this.f2976d, viewGroup);
            }
            d(view, this.f2977e, this.f2976d);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i2);
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
        Cursor cursor;
        if (this.f2975c && (cursor = this.f2976d) != null && !cursor.isClosed()) {
            this.f2974b = this.f2976d.requery();
        }
    }

    public boolean hasStableIds() {
        return true;
    }

    public Cursor i(Cursor cursor) {
        Cursor cursor2 = this.f2976d;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ChangeObserver changeObserver = this.f2979g;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.f2980h;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2976d = cursor;
        if (cursor != null) {
            ChangeObserver changeObserver2 = this.f2979g;
            if (changeObserver2 != null) {
                cursor.registerContentObserver(changeObserver2);
            }
            DataSetObserver dataSetObserver2 = this.f2980h;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f2978f = cursor.getColumnIndexOrThrow("_id");
            this.f2974b = true;
            notifyDataSetChanged();
        } else {
            this.f2978f = -1;
            this.f2974b = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public CursorAdapter(Context context, Cursor cursor, int i2) {
        e(context, cursor, i2);
    }
}
