package com.movie.ui.activity.payment;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public class ChooseProductFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ChooseProductFragment f32265a;

    /* renamed from: b  reason: collision with root package name */
    private View f32266b;

    public ChooseProductFragment_ViewBinding(final ChooseProductFragment chooseProductFragment, View view) {
        this.f32265a = chooseProductFragment;
        chooseProductFragment.radioGroupProducts = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.radioGroupProducts, "field 'radioGroupProducts'", RadioGroup.class);
        chooseProductFragment.edtEmail = (EditText) Utils.findRequiredViewAsType(view, R.id.tvEmail, "field 'edtEmail'", EditText.class);
        chooseProductFragment.tvValidate = (TextView) Utils.findRequiredViewAsType(view, R.id.tvValidate, "field 'tvValidate'", TextView.class);
        chooseProductFragment.progressBarloading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progressBarloading, "field 'progressBarloading'", ProgressBar.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.btnNext, "field 'btnNext' and method 'onBtnNextClick'");
        chooseProductFragment.btnNext = (Button) Utils.castView(findRequiredView, R.id.btnNext, "field 'btnNext'", Button.class);
        this.f32266b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                chooseProductFragment.onBtnNextClick();
            }
        });
        chooseProductFragment.imgbtnDetails = (ImageButton) Utils.findRequiredViewAsType(view, R.id.imgbtnDetails, "field 'imgbtnDetails'", ImageButton.class);
        chooseProductFragment.cbSplitKey = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cbSplitKey, "field 'cbSplitKey'", CheckBox.class);
    }

    public void unbind() {
        ChooseProductFragment chooseProductFragment = this.f32265a;
        if (chooseProductFragment != null) {
            this.f32265a = null;
            chooseProductFragment.radioGroupProducts = null;
            chooseProductFragment.edtEmail = null;
            chooseProductFragment.tvValidate = null;
            chooseProductFragment.progressBarloading = null;
            chooseProductFragment.btnNext = null;
            chooseProductFragment.imgbtnDetails = null;
            chooseProductFragment.cbSplitKey = null;
            this.f32266b.setOnClickListener((View.OnClickListener) null);
            this.f32266b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
