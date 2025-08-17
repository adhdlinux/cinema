package com.movie.ui.customdialog;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public class AddMagnetDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private AddMagnetDialog f33189a;

    /* renamed from: b  reason: collision with root package name */
    private View f33190b;

    /* renamed from: c  reason: collision with root package name */
    private View f33191c;

    public AddMagnetDialog_ViewBinding(final AddMagnetDialog addMagnetDialog, View view) {
        this.f33189a = addMagnetDialog;
        addMagnetDialog.edtAddMagnet = (EditText) Utils.findRequiredViewAsType(view, R.id.edt_add_magnet, "field 'edtAddMagnet'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.btn_add_magnet, "field 'btnAddMagnet' and method 'onAddMagnetBtnClick'");
        Class cls = ImageButton.class;
        addMagnetDialog.btnAddMagnet = (ImageButton) Utils.castView(findRequiredView, R.id.btn_add_magnet, "field 'btnAddMagnet'", cls);
        this.f33190b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                addMagnetDialog.onAddMagnetBtnClick();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.imgbtncopy, "field 'imgbtncopy' and method 'onCopyTitleToClipBoard'");
        addMagnetDialog.imgbtncopy = (ImageButton) Utils.castView(findRequiredView2, R.id.imgbtncopy, "field 'imgbtncopy'", cls);
        this.f33191c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                addMagnetDialog.onCopyTitleToClipBoard();
            }
        });
        addMagnetDialog.rvMagnet = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rvMagnet, "field 'rvMagnet'", RecyclerView.class);
        addMagnetDialog.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.prgbar, "field 'progressBar'", ProgressBar.class);
        Class cls2 = CheckBox.class;
        addMagnetDialog.cbRD = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cbRD, "field 'cbRD'", cls2);
        addMagnetDialog.cbAD = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cbAD, "field 'cbAD'", cls2);
        addMagnetDialog.cbPM = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cbPM, "field 'cbPM'", cls2);
    }

    public void unbind() {
        AddMagnetDialog addMagnetDialog = this.f33189a;
        if (addMagnetDialog != null) {
            this.f33189a = null;
            addMagnetDialog.edtAddMagnet = null;
            addMagnetDialog.btnAddMagnet = null;
            addMagnetDialog.imgbtncopy = null;
            addMagnetDialog.rvMagnet = null;
            addMagnetDialog.progressBar = null;
            addMagnetDialog.cbRD = null;
            addMagnetDialog.cbAD = null;
            addMagnetDialog.cbPM = null;
            this.f33190b.setOnClickListener((View.OnClickListener) null);
            this.f33190b = null;
            this.f33191c.setOnClickListener((View.OnClickListener) null);
            this.f33191c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
