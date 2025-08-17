package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;
import com.facebook.imageutils.JfifUtil;

public class AlertDialog extends AppCompatDialog implements DialogInterface {

    /* renamed from: b  reason: collision with root package name */
    final AlertController f402b = new AlertController(getContext(), this, getWindow());

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.AlertParams f403a;

        /* renamed from: b  reason: collision with root package name */
        private final int f404b;

        public Builder(Context context) {
            this(context, AlertDialog.c(context, 0));
        }

        public Builder a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f403a;
            alertParams.f383w = listAdapter;
            alertParams.f384x = onClickListener;
            return this;
        }

        public Builder b(boolean z2) {
            this.f403a.f378r = z2;
            return this;
        }

        public Builder c(View view) {
            this.f403a.f367g = view;
            return this;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.f403a.f361a, this.f404b);
            this.f403a.a(alertDialog.f402b);
            alertDialog.setCancelable(this.f403a.f378r);
            if (this.f403a.f378r) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f403a.f379s);
            alertDialog.setOnDismissListener(this.f403a.f380t);
            DialogInterface.OnKeyListener onKeyListener = this.f403a.f381u;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        public Builder d(int i2) {
            this.f403a.f363c = i2;
            return this;
        }

        public Builder e(Drawable drawable) {
            this.f403a.f364d = drawable;
            return this;
        }

        public Builder f(int i2) {
            AlertController.AlertParams alertParams = this.f403a;
            alertParams.f368h = alertParams.f361a.getText(i2);
            return this;
        }

        public Builder g(CharSequence charSequence) {
            this.f403a.f368h = charSequence;
            return this;
        }

        public Context getContext() {
            return this.f403a.f361a;
        }

        public Builder h(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.f403a;
            alertParams.f382v = charSequenceArr;
            alertParams.J = onMultiChoiceClickListener;
            alertParams.F = zArr;
            alertParams.G = true;
            return this;
        }

        public Builder i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f403a;
            alertParams.f372l = charSequence;
            alertParams.f374n = onClickListener;
            return this;
        }

        public Builder j(DialogInterface.OnDismissListener onDismissListener) {
            this.f403a.f380t = onDismissListener;
            return this;
        }

        public Builder k(DialogInterface.OnKeyListener onKeyListener) {
            this.f403a.f381u = onKeyListener;
            return this;
        }

        public Builder l(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f403a;
            alertParams.f369i = charSequence;
            alertParams.f371k = onClickListener;
            return this;
        }

        public Builder m(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f403a;
            alertParams.f383w = listAdapter;
            alertParams.f384x = onClickListener;
            alertParams.I = i2;
            alertParams.H = true;
            return this;
        }

        public Builder n(CharSequence[] charSequenceArr, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f403a;
            alertParams.f382v = charSequenceArr;
            alertParams.f384x = onClickListener;
            alertParams.I = i2;
            alertParams.H = true;
            return this;
        }

        public Builder o(int i2) {
            AlertController.AlertParams alertParams = this.f403a;
            alertParams.f366f = alertParams.f361a.getText(i2);
            return this;
        }

        public Builder p(int i2) {
            AlertController.AlertParams alertParams = this.f403a;
            alertParams.f386z = null;
            alertParams.f385y = i2;
            alertParams.E = false;
            return this;
        }

        public AlertDialog q() {
            AlertDialog create = create();
            create.show();
            return create;
        }

        public Builder setNegativeButton(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f403a;
            alertParams.f372l = alertParams.f361a.getText(i2);
            this.f403a.f374n = onClickListener;
            return this;
        }

        public Builder setPositiveButton(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f403a;
            alertParams.f369i = alertParams.f361a.getText(i2);
            this.f403a.f371k = onClickListener;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f403a.f366f = charSequence;
            return this;
        }

        public Builder setView(View view) {
            AlertController.AlertParams alertParams = this.f403a;
            alertParams.f386z = view;
            alertParams.f385y = 0;
            alertParams.E = false;
            return this;
        }

        public Builder(Context context, int i2) {
            this.f403a = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.c(context, i2)));
            this.f404b = i2;
        }
    }

    protected AlertDialog(Context context, int i2) {
        super(context, c(context, i2));
    }

    static int c(Context context, int i2) {
        if (((i2 >>> 24) & JfifUtil.MARKER_FIRST_BYTE) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.f104o, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView b() {
        return this.f402b.d();
    }

    public void d(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f402b.k(i2, charSequence, onClickListener, (Message) null, (Drawable) null);
    }

    public void e(CharSequence charSequence) {
        this.f402b.o(charSequence);
    }

    public void f(View view) {
        this.f402b.s(view);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f402b.e();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.f402b.g(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.f402b.h(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f402b.q(charSequence);
    }
}
