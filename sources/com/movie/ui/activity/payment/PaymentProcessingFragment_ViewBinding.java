package com.movie.ui.activity.payment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public class PaymentProcessingFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private PaymentProcessingFragment f32289a;

    /* renamed from: b  reason: collision with root package name */
    private View f32290b;

    /* renamed from: c  reason: collision with root package name */
    private View f32291c;

    /* renamed from: d  reason: collision with root package name */
    private View f32292d;

    public PaymentProcessingFragment_ViewBinding(final PaymentProcessingFragment paymentProcessingFragment, View view) {
        this.f32289a = paymentProcessingFragment;
        Class cls = TextView.class;
        paymentProcessingFragment.tvaddress = (TextView) Utils.findRequiredViewAsType(view, R.id.tvaddress, "field 'tvaddress'", cls);
        paymentProcessingFragment.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTitlte, "field 'tvTitle'", cls);
        paymentProcessingFragment.imgAddressQR = (ImageView) Utils.findRequiredViewAsType(view, R.id.imgAddressQR, "field 'imgAddressQR'", ImageView.class);
        Class cls2 = ProgressBar.class;
        paymentProcessingFragment.progressBarCircle = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progressBarCircle, "field 'progressBarCircle'", cls2);
        paymentProcessingFragment.textViewTime = (TextView) Utils.findRequiredViewAsType(view, R.id.textViewTime, "field 'textViewTime'", cls);
        paymentProcessingFragment.tvBTC = (TextView) Utils.findRequiredViewAsType(view, R.id.tvBTC, "field 'tvBTC'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.btnCancelPayment, "field 'btnCancelPayment' and method 'onBtnCancelPaymentClick'");
        Class cls3 = Button.class;
        paymentProcessingFragment.btnCancelPayment = (Button) Utils.castView(findRequiredView, R.id.btnCancelPayment, "field 'btnCancelPayment'", cls3);
        this.f32290b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                paymentProcessingFragment.onBtnCancelPaymentClick();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btnCopy, "field 'btnCopyAddress' and method 'onBtnCopyClick'");
        paymentProcessingFragment.btnCopyAddress = (Button) Utils.castView(findRequiredView2, R.id.btnCopy, "field 'btnCopyAddress'", cls3);
        this.f32291c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                paymentProcessingFragment.onBtnCopyClick();
            }
        });
        paymentProcessingFragment.progressbar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progressbar, "field 'progressbar'", cls2);
        paymentProcessingFragment.layout_address_content = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.layout_address_content, "field 'layout_address_content'", ConstraintLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.btnCopyBTC, "method 'onBtnCopyBTCClick' and method 'onBtnCopyBTCLongClick'");
        this.f32292d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                paymentProcessingFragment.onBtnCopyBTCClick();
            }
        });
        findRequiredView3.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                paymentProcessingFragment.onBtnCopyBTCLongClick();
                return true;
            }
        });
    }

    public void unbind() {
        PaymentProcessingFragment paymentProcessingFragment = this.f32289a;
        if (paymentProcessingFragment != null) {
            this.f32289a = null;
            paymentProcessingFragment.tvaddress = null;
            paymentProcessingFragment.tvTitle = null;
            paymentProcessingFragment.imgAddressQR = null;
            paymentProcessingFragment.progressBarCircle = null;
            paymentProcessingFragment.textViewTime = null;
            paymentProcessingFragment.tvBTC = null;
            paymentProcessingFragment.btnCancelPayment = null;
            paymentProcessingFragment.btnCopyAddress = null;
            paymentProcessingFragment.progressbar = null;
            paymentProcessingFragment.layout_address_content = null;
            this.f32290b.setOnClickListener((View.OnClickListener) null);
            this.f32290b = null;
            this.f32291c.setOnClickListener((View.OnClickListener) null);
            this.f32291c = null;
            this.f32292d.setOnClickListener((View.OnClickListener) null);
            this.f32292d.setOnLongClickListener((View.OnLongClickListener) null);
            this.f32292d = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
