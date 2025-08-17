package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.helper.crypto.MD5Utils;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class XMovies8 extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37501e = Utils.getProvider(71);

    private String J(String str, String str2, String str3, String str4, boolean z2) {
        String valueOf = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        String a2 = MD5Utils.a(str.concat(Deobfuscator$app$ProductionRelease.a(-211136010727620L)).concat(str2).concat(Deobfuscator$app$ProductionRelease.a(-211127420793028L)).concat(str3).concat(Deobfuscator$app$ProductionRelease.a(-211359349027012L)).concat(str4).concat(Deobfuscator$app$ProductionRelease.a(-211350759092420L)).concat(valueOf).concat(Deobfuscator$app$ProductionRelease.a(-211376528896196L)));
        if (!z2) {
            String a3 = MD5Utils.a(str.concat(Deobfuscator$app$ProductionRelease.a(-211299219484868L)).concat(str3).concat(Deobfuscator$app$ProductionRelease.a(-211251974844612L)).concat(str4).concat(Deobfuscator$app$ProductionRelease.a(-211277744648388L)).concat(valueOf).concat(Deobfuscator$app$ProductionRelease.a(-211269154713796L)));
            return String.format(Deobfuscator$app$ProductionRelease.a(-211737306149060L), new Object[]{a3, str3, str4, com.original.tase.utils.Utils.c(str).replace(Deobfuscator$app$ProductionRelease.a(-211861860200644L), Deobfuscator$app$ProductionRelease.a(-211853270266052L)), valueOf});
        }
        return String.format(Deobfuscator$app$ProductionRelease.a(-211982119284932L), new Object[]{a2, str3, str4, com.original.tase.utils.Utils.k(str, new boolean[0]).replace(Deobfuscator$app$ProductionRelease.a(-211763075952836L), Deobfuscator$app$ProductionRelease.a(-211788845756612L)), str2, valueOf});
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-245650367918276L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String J = J(movieInfo.name, movieInfo.year, Deobfuscator$app$ProductionRelease.a(-211574097391812L), Deobfuscator$app$ProductionRelease.a(-211531147718852L), z2);
        K(observableEmitter, movieInfo, String.format(Deobfuscator$app$ProductionRelease.a(-211522557784260L), new Object[]{this.f37501e, J}));
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String J = J(movieInfo.name, movieInfo.year, movieInfo.session, movieInfo.eps, z2);
        K(observableEmitter, movieInfo, String.format(Deobfuscator$app$ProductionRelease.a(-211209025171652L), new Object[]{this.f37501e, J}));
    }

    public void K(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        String m2 = HttpHelper.i().m(str, new Map[0]);
        if (!m2.isEmpty()) {
            Iterator<String> it2 = Regex.g(m2, Deobfuscator$app$ProductionRelease.a(-211801730658500L), 1, false).iterator();
            while (it2.hasNext()) {
                String valueOf = String.valueOf(it2.next());
                String a2 = Regex.a(valueOf, Deobfuscator$app$ProductionRelease.a(-245491454128324L), 1);
                if (a2.isEmpty()) {
                    a2 = Deobfuscator$app$ProductionRelease.a(-245684727656644L);
                }
                if (!valueOf.isEmpty()) {
                    z(observableEmitter, valueOf.replace(Deobfuscator$app$ProductionRelease.a(-245706202493124L), Deobfuscator$app$ProductionRelease.a(-245693317591236L)), a2, new boolean[0]);
                }
            }
        }
    }
}
