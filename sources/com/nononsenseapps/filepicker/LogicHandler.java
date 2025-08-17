package com.nononsenseapps.filepicker;

import android.net.Uri;
import android.view.ViewGroup;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

public interface LogicHandler<T> {
    int c(int i2, T t2);

    Uri d(T t2);

    String e(T t2);

    String f(T t2);

    void g(AbstractFilePickerFragment<T>.DirViewHolder dirViewHolder, int i2, T t2);

    T getRoot();

    Loader<SortedList<T>> j();

    RecyclerView.ViewHolder k(ViewGroup viewGroup, int i2);

    boolean t(T t2);

    void u(AbstractFilePickerFragment<T>.HeaderViewHolder headerViewHolder);

    T v(String str);

    T w(T t2);
}
