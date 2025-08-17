package com.movie.ui.activity.payment;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public class PaymentResultFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private PaymentResultFragment f32303a;

    /* renamed from: b  reason: collision with root package name */
    private View f32304b;

    public PaymentResultFragment_ViewBinding(final PaymentResultFragment paymentResultFragment, View view) {
        this.f32303a = paymentResultFragment;
        Class cls = TextView.class;
        paymentResultFragment.tvStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tvStatus, "field 'tvStatus'", cls);
        paymentResultFragment.tvTitlte = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTitlte, "field 'tvTitlte'", cls);
        paymentResultFragment.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progressbar, "field 'progressBar'", ProgressBar.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.btnRestart, "field 'btnRestart' and method 'onRestartClick'");
        paymentResultFragment.btnRestart = (Button) Utils.castView(findRequiredView, R.id.btnRestart, "field 'btnRestart'", Button.class);
        this.f32304b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                paymentResultFragment.onRestartClick();
            }
        });
    }

    public void unbind() {
        PaymentResultFragment paymentResultFragment = this.f32303a;
        if (paymentResultFragment != null) {
            this.f32303a = null;
            paymentResultFragment.tvStatus = null;
            paymentResultFragment.tvTitlte = null;
            paymentResultFragment.progressBar = null;
            paymentResultFragment.btnRestart = null;
            this.f32304b.setOnClickListener((View.OnClickListener) null);
            this.f32304b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
