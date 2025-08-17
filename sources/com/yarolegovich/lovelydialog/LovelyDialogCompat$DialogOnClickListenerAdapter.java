package com.yarolegovich.lovelydialog;

import android.content.DialogInterface;
import android.view.View;

class LovelyDialogCompat$DialogOnClickListenerAdapter implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnClickListener f37961b;

    public void a(DialogInterface dialogInterface, int i2) {
        DialogInterface.OnClickListener onClickListener = this.f37961b;
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i2);
        }
    }

    public void onClick(View view) {
    }
}
