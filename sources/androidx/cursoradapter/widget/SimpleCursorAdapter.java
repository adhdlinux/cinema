package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleCursorAdapter extends ResourceCursorAdapter {

    /* renamed from: n  reason: collision with root package name */
    protected int[] f2989n;

    /* renamed from: o  reason: collision with root package name */
    protected int[] f2990o;

    /* renamed from: p  reason: collision with root package name */
    private int f2991p = -1;

    /* renamed from: q  reason: collision with root package name */
    String[] f2992q;

    public SimpleCursorAdapter(Context context, int i2, Cursor cursor, String[] strArr, int[] iArr, int i3) {
        super(context, i2, cursor, i3);
        this.f2990o = iArr;
        this.f2992q = strArr;
        j(cursor, strArr);
    }

    private void j(Cursor cursor, String[] strArr) {
        if (cursor != null) {
            int length = strArr.length;
            int[] iArr = this.f2989n;
            if (iArr == null || iArr.length != length) {
                this.f2989n = new int[length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f2989n[i2] = cursor.getColumnIndexOrThrow(strArr[i2]);
            }
            return;
        }
        this.f2989n = null;
    }

    public CharSequence convertToString(Cursor cursor) {
        int i2 = this.f2991p;
        if (i2 > -1) {
            return cursor.getString(i2);
        }
        return super.convertToString(cursor);
    }

    public void d(View view, Context context, Cursor cursor) {
        int[] iArr = this.f2990o;
        int length = iArr.length;
        int[] iArr2 = this.f2989n;
        for (int i2 = 0; i2 < length; i2++) {
            View findViewById = view.findViewById(iArr[i2]);
            if (findViewById != null) {
                String string = cursor.getString(iArr2[i2]);
                if (string == null) {
                    string = "";
                }
                if (findViewById instanceof TextView) {
                    l((TextView) findViewById, string);
                } else if (findViewById instanceof ImageView) {
                    k((ImageView) findViewById, string);
                } else {
                    throw new IllegalStateException(findViewById.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
                }
            }
        }
    }

    public Cursor i(Cursor cursor) {
        j(cursor, this.f2992q);
        return super.i(cursor);
    }

    public void k(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void l(TextView textView, String str) {
        textView.setText(str);
    }
}
