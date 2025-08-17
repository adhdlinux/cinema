package com.movie.ui.customdialog;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Function;

public final /* synthetic */ class q implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddMagnetDialog f33213b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TorrentObject f33214c;

    public /* synthetic */ q(AddMagnetDialog addMagnetDialog, TorrentObject torrentObject) {
        this.f33213b = addMagnetDialog;
        this.f33214c = torrentObject;
    }

    public final Object apply(Object obj) {
        return this.f33213b.v0(this.f33214c, obj);
    }
}
