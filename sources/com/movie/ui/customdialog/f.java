package com.movie.ui.customdialog;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddMagnetDialog f33202b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TorrentObject f33203c;

    public /* synthetic */ f(AddMagnetDialog addMagnetDialog, TorrentObject torrentObject) {
        this.f33202b = addMagnetDialog;
        this.f33203c = torrentObject;
    }

    public final void accept(Object obj) {
        this.f33202b.K0(this.f33203c, (List) obj);
    }
}
