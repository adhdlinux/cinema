package com.movie.ui.fragment.premium;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public class FilesBottomSheetFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private FilesBottomSheetFragment f33494a;

    public FilesBottomSheetFragment_ViewBinding(FilesBottomSheetFragment filesBottomSheetFragment, View view) {
        this.f33494a = filesBottomSheetFragment;
        filesBottomSheetFragment.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rvList, "field 'rvList'", RecyclerView.class);
        filesBottomSheetFragment.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", ProgressBar.class);
        filesBottomSheetFragment.searchView = (SearchView) Utils.findRequiredViewAsType(view, R.id.searchView, "field 'searchView'", SearchView.class);
    }

    public void unbind() {
        FilesBottomSheetFragment filesBottomSheetFragment = this.f33494a;
        if (filesBottomSheetFragment != null) {
            this.f33494a = null;
            filesBottomSheetFragment.rvList = null;
            filesBottomSheetFragment.loading = null;
            filesBottomSheetFragment.searchView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
