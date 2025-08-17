package com.movie.ui.customdialog;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class w implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddMagnetDialog f33221b;

    public /* synthetic */ w(AddMagnetDialog addMagnetDialog) {
        this.f33221b = addMagnetDialog;
    }

    public final void accept(Object obj) {
        this.f33221b.E0((TorrentObject) obj);
    }
}
