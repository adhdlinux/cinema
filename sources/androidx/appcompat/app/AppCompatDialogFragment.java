package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

public class AppCompatDialogFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        return new AppCompatDialog(getContext(), getTheme());
    }

    public void setupDialog(Dialog dialog, int i2) {
        if (dialog instanceof AppCompatDialog) {
            AppCompatDialog appCompatDialog = (AppCompatDialog) dialog;
            if (!(i2 == 1 || i2 == 2)) {
                if (i2 == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            appCompatDialog.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i2);
    }
}
