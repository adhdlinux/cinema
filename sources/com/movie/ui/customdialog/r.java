package com.movie.ui.customdialog;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class r implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddMagnetDialog f33215b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TorrentObject f33216c;

    public /* synthetic */ r(AddMagnetDialog addMagnetDialog, TorrentObject torrentObject) {
        this.f33215b = addMagnetDialog;
        this.f33216c = torrentObject;
    }

    public final void accept(Object obj) {
        this.f33215b.t0(this.f33216c, obj);
    }
}
