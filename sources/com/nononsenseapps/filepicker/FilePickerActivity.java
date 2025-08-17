package com.nononsenseapps.filepicker;

import android.annotation.SuppressLint;
import android.os.Environment;
import java.io.File;

@SuppressLint({"Registered"})
public class FilePickerActivity extends AbstractFilePickerActivity<File> {
    /* access modifiers changed from: protected */
    public AbstractFilePickerFragment<File> z(String str, int i2, boolean z2, boolean z3, boolean z4, boolean z5) {
        FilePickerFragment filePickerFragment = new FilePickerFragment();
        if (str == null) {
            str = Environment.getExternalStorageDirectory().getPath();
        }
        filePickerFragment.b0(str, i2, z2, z3, z4, z5);
        return filePickerFragment;
    }
}
