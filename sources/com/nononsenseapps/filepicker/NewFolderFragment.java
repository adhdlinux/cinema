package com.nononsenseapps.filepicker;

import androidx.fragment.app.FragmentManager;
import com.nononsenseapps.filepicker.NewItemFragment;

public class NewFolderFragment extends NewItemFragment {
    public static void I(FragmentManager fragmentManager, NewItemFragment.OnNewFolderListener onNewFolderListener) {
        NewFolderFragment newFolderFragment = new NewFolderFragment();
        newFolderFragment.G(onNewFolderListener);
        newFolderFragment.show(fragmentManager, "new_folder_fragment");
    }

    /* access modifiers changed from: protected */
    public boolean H(String str) {
        return Utils.c(str);
    }
}
