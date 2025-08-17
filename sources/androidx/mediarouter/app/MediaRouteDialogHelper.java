package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.mediarouter.R$bool;
import androidx.mediarouter.R$dimen;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class MediaRouteDialogHelper {
    private MediaRouteDialogHelper() {
    }

    public static int a(Context context) {
        return !context.getResources().getBoolean(R$bool.is_tablet) ? -1 : -2;
    }

    public static int b(Context context) {
        boolean z2;
        int i2;
        float fraction;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
            z2 = true;
        } else {
            z2 = false;
        }
        TypedValue typedValue = new TypedValue();
        Resources resources = context.getResources();
        if (z2) {
            i2 = R$dimen.mr_dialog_fixed_width_minor;
        } else {
            i2 = R$dimen.mr_dialog_fixed_width_major;
        }
        resources.getValue(i2, typedValue, true);
        int i3 = typedValue.type;
        if (i3 == 5) {
            fraction = typedValue.getDimension(displayMetrics);
        } else if (i3 != 6) {
            return -2;
        } else {
            int i4 = displayMetrics.widthPixels;
            fraction = typedValue.getFraction((float) i4, (float) i4);
        }
        return (int) fraction;
    }

    public static int c(Context context) {
        if (!context.getResources().getBoolean(R$bool.is_tablet)) {
            return -1;
        }
        return b(context);
    }

    public static <E> HashMap<E, BitmapDrawable> d(Context context, ListView listView, ArrayAdapter<E> arrayAdapter) {
        HashMap<E, BitmapDrawable> hashMap = new HashMap<>();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        for (int i2 = 0; i2 < listView.getChildCount(); i2++) {
            hashMap.put(arrayAdapter.getItem(firstVisiblePosition + i2), h(context, listView.getChildAt(i2)));
        }
        return hashMap;
    }

    public static <E> HashMap<E, Rect> e(ListView listView, ArrayAdapter<E> arrayAdapter) {
        HashMap<E, Rect> hashMap = new HashMap<>();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        for (int i2 = 0; i2 < listView.getChildCount(); i2++) {
            E item = arrayAdapter.getItem(firstVisiblePosition + i2);
            View childAt = listView.getChildAt(i2);
            hashMap.put(item, new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()));
        }
        return hashMap;
    }

    public static <E> Set<E> f(List<E> list, List<E> list2) {
        HashSet hashSet = new HashSet(list2);
        hashSet.removeAll(list);
        return hashSet;
    }

    public static <E> Set<E> g(List<E> list, List<E> list2) {
        HashSet hashSet = new HashSet(list);
        hashSet.removeAll(list2);
        return hashSet;
    }

    private static BitmapDrawable h(Context context, View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return new BitmapDrawable(context.getResources(), createBitmap);
    }

    public static <E> boolean i(List<E> list, List<E> list2) {
        return new HashSet(list).equals(new HashSet(list2));
    }
}
