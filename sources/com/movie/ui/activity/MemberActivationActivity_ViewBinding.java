package com.movie.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public class MemberActivationActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private MemberActivationActivity f32107b;

    /* renamed from: c  reason: collision with root package name */
    private View f32108c;

    /* renamed from: d  reason: collision with root package name */
    private View f32109d;

    /* renamed from: e  reason: collision with root package name */
    private View f32110e;

    /* renamed from: f  reason: collision with root package name */
    private View f32111f;

    /* renamed from: g  reason: collision with root package name */
    private View f32112g;

    public MemberActivationActivity_ViewBinding(final MemberActivationActivity memberActivationActivity, View view) {
        super(memberActivationActivity, view);
        this.f32107b = memberActivationActivity;
        Class cls = ConstraintLayout.class;
        memberActivationActivity.introLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.intro_layout, "field 'introLayout'", cls);
        memberActivationActivity.activateResult = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.activateResult, "field 'activateResult'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.activenow, "field 'activeNow' and method 'onActivateClick'");
        Class cls2 = Button.class;
        memberActivationActivity.activeNow = (Button) Utils.castView(findRequiredView, R.id.activenow, "field 'activeNow'", cls2);
        this.f32108c = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                memberActivationActivity.onActivateClick();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btn_bitcoin, "field 'btn_bitcoin' and method 'onBtnBitcoinClick'");
        memberActivationActivity.btn_bitcoin = (Button) Utils.castView(findRequiredView2, R.id.btn_bitcoin, "field 'btn_bitcoin'", cls2);
        this.f32109d = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                memberActivationActivity.onBtnBitcoinClick();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.btn_game_challenge, "field 'btn_game_challenge' and method 'onGameChallengeClick'");
        memberActivationActivity.btn_game_challenge = (Button) Utils.castView(findRequiredView3, R.id.btn_game_challenge, "field 'btn_game_challenge'", cls2);
        this.f32110e = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                memberActivationActivity.onGameChallengeClick();
            }
        });
        memberActivationActivity.btn_amz_gift = (Button) Utils.findRequiredViewAsType(view, R.id.btn_amz_gift, "field 'btn_amz_gift'", cls2);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.btnCopy, "field 'btnCopy', method 'onCopyCodeClick', and method 'onCopyCodeLongClick'");
        memberActivationActivity.btnCopy = (Button) Utils.castView(findRequiredView4, R.id.btnCopy, "field 'btnCopy'", cls2);
        this.f32111f = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                memberActivationActivity.onCopyCodeClick();
            }
        });
        findRequiredView4.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                memberActivationActivity.onCopyCodeLongClick();
                return true;
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.btnRemove, "field 'btnRemove' and method 'onRemoveClick'");
        memberActivationActivity.btnRemove = (Button) Utils.castView(findRequiredView5, R.id.btnRemove, "field 'btnRemove'", cls2);
        this.f32112g = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                memberActivationActivity.onRemoveClick();
            }
        });
        memberActivationActivity.code = (TextView) Utils.findRequiredViewAsType(view, R.id.code, "field 'code'", TextView.class);
        Class cls3 = ProgressBar.class;
        memberActivationActivity.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", cls3);
        memberActivationActivity.pbbitcoin = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pbbitcoin, "field 'pbbitcoin'", cls3);
        memberActivationActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    }

    public void unbind() {
        MemberActivationActivity memberActivationActivity = this.f32107b;
        if (memberActivationActivity != null) {
            this.f32107b = null;
            memberActivationActivity.introLayout = null;
            memberActivationActivity.activateResult = null;
            memberActivationActivity.activeNow = null;
            memberActivationActivity.btn_bitcoin = null;
            memberActivationActivity.btn_game_challenge = null;
            memberActivationActivity.btn_amz_gift = null;
            memberActivationActivity.btnCopy = null;
            memberActivationActivity.btnRemove = null;
            memberActivationActivity.code = null;
            memberActivationActivity.loading = null;
            memberActivationActivity.pbbitcoin = null;
            memberActivationActivity.toolbar = null;
            this.f32108c.setOnClickListener((View.OnClickListener) null);
            this.f32108c = null;
            this.f32109d.setOnClickListener((View.OnClickListener) null);
            this.f32109d = null;
            this.f32110e.setOnClickListener((View.OnClickListener) null);
            this.f32110e = null;
            this.f32111f.setOnClickListener((View.OnClickListener) null);
            this.f32111f.setOnLongClickListener((View.OnLongClickListener) null);
            this.f32111f = null;
            this.f32112g.setOnClickListener((View.OnClickListener) null);
            this.f32112g = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
