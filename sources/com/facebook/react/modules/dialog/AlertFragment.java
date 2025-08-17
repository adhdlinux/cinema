package com.facebook.react.modules.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.react.modules.dialog.DialogModule;

public class AlertFragment extends DialogFragment implements DialogInterface.OnClickListener {
    static final String ARG_BUTTON_NEGATIVE = "button_negative";
    static final String ARG_BUTTON_NEUTRAL = "button_neutral";
    static final String ARG_BUTTON_POSITIVE = "button_positive";
    static final String ARG_ITEMS = "items";
    static final String ARG_MESSAGE = "message";
    static final String ARG_TITLE = "title";
    private final DialogModule.AlertFragmentListener mListener;

    public AlertFragment() {
        this.mListener = null;
    }

    public static Dialog createDialog(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle(bundle.getString(ARG_TITLE));
        if (bundle.containsKey(ARG_BUTTON_POSITIVE)) {
            title.setPositiveButton(bundle.getString(ARG_BUTTON_POSITIVE), onClickListener);
        }
        if (bundle.containsKey(ARG_BUTTON_NEGATIVE)) {
            title.setNegativeButton(bundle.getString(ARG_BUTTON_NEGATIVE), onClickListener);
        }
        if (bundle.containsKey(ARG_BUTTON_NEUTRAL)) {
            title.setNeutralButton(bundle.getString(ARG_BUTTON_NEUTRAL), onClickListener);
        }
        if (bundle.containsKey(ARG_MESSAGE)) {
            title.setMessage(bundle.getString(ARG_MESSAGE));
        }
        if (bundle.containsKey(ARG_ITEMS)) {
            title.setItems(bundle.getCharSequenceArray(ARG_ITEMS), onClickListener);
        }
        return title.create();
    }

    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        DialogModule.AlertFragmentListener alertFragmentListener = this.mListener;
        if (alertFragmentListener != null) {
            alertFragmentListener.onClick(dialogInterface, i2);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return createDialog(getActivity(), getArguments(), this);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogModule.AlertFragmentListener alertFragmentListener = this.mListener;
        if (alertFragmentListener != null) {
            alertFragmentListener.onDismiss(dialogInterface);
        }
    }

    @SuppressLint({"ValidFragment"})
    public AlertFragment(DialogModule.AlertFragmentListener alertFragmentListener, Bundle bundle) {
        this.mListener = alertFragmentListener;
        setArguments(bundle);
    }
}
