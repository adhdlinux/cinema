package com.nononsenseapps.filepicker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;

public abstract class NewItemFragment extends DialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public OnNewFolderListener f33733b = null;

    public interface OnNewFolderListener {
        void E(String str);
    }

    public void G(OnNewFolderListener onNewFolderListener) {
        this.f33733b = onNewFolderListener;
    }

    /* access modifiers changed from: protected */
    public abstract boolean H(String str);

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(R$layout.nnf_dialog_folder_name).setTitle(R$string.nnf_new_folder).setNegativeButton(R$string.nnf_new_folder_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R$string.nnf_new_folder_ok, (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                final AlertDialog alertDialog = (AlertDialog) dialogInterface;
                final EditText editText = (EditText) alertDialog.findViewById(R$id.edit_text);
                if (editText != null) {
                    alertDialog.getButton(-2).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            alertDialog.cancel();
                        }
                    });
                    final Button button = alertDialog.getButton(-1);
                    button.setEnabled(false);
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            String obj = editText.getText().toString();
                            if (NewItemFragment.this.H(obj)) {
                                if (NewItemFragment.this.f33733b != null) {
                                    NewItemFragment.this.f33733b.E(obj);
                                }
                                alertDialog.dismiss();
                            }
                        }
                    });
                    editText.addTextChangedListener(new TextWatcher() {
                        public void afterTextChanged(Editable editable) {
                            button.setEnabled(NewItemFragment.this.H(editable.toString()));
                        }

                        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }
                    });
                    return;
                }
                throw new NullPointerException("Could not find an edit text in the dialog");
            }
        });
        return create;
    }
}
