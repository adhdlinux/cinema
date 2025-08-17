package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ResourceCursorAdapter extends CursorAdapter {

    /* renamed from: k  reason: collision with root package name */
    private int f2986k;

    /* renamed from: l  reason: collision with root package name */
    private int f2987l;

    /* renamed from: m  reason: collision with root package name */
    private LayoutInflater f2988m;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i2, Cursor cursor, boolean z2) {
        super(context, cursor, z2);
        this.f2987l = i2;
        this.f2986k = i2;
        this.f2988m = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2988m.inflate(this.f2987l, viewGroup, false);
    }

    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2988m.inflate(this.f2986k, viewGroup, false);
    }

    public ResourceCursorAdapter(Context context, int i2, Cursor cursor, int i3) {
        super(context, cursor, i3);
        this.f2987l = i2;
        this.f2986k = i2;
        this.f2988m = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
