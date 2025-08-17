package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

final class AppCompatReceiveContentHelper {

    private static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        /* JADX INFO: finally extract failed */
        static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
            DragAndDropPermissions unused = activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                ViewCompat.h0(textView, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).a());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }

        static boolean b(DragEvent dragEvent, View view, Activity activity) {
            DragAndDropPermissions unused = activity.requestDragAndDropPermissions(dragEvent);
            ViewCompat.h0(view, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).a());
            return true;
        }
    }

    private AppCompatReceiveContentHelper() {
    }

    static boolean a(View view, DragEvent dragEvent) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 31 && i2 >= 24 && dragEvent.getLocalState() == null && ViewCompat.G(view) != null) {
            Activity c2 = c(view);
            if (c2 == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + view);
                return false;
            } else if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            } else {
                if (dragEvent.getAction() == 3) {
                    if (view instanceof TextView) {
                        return OnDropApi24Impl.a(dragEvent, (TextView) view, c2);
                    }
                    return OnDropApi24Impl.b(dragEvent, view, c2);
                }
            }
        }
        return false;
    }

    static boolean b(TextView textView, int i2) {
        ClipData clipData;
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 31 || ViewCompat.G(textView) == null || (i2 != 16908322 && i2 != 16908337)) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            clipData = null;
        } else {
            clipData = clipboardManager.getPrimaryClip();
        }
        if (clipData != null && clipData.getItemCount() > 0) {
            ContentInfoCompat.Builder builder = new ContentInfoCompat.Builder(clipData, 1);
            if (i2 != 16908322) {
                i3 = 1;
            }
            ViewCompat.h0(textView, builder.c(i3).a());
        }
        return true;
    }

    static Activity c(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
