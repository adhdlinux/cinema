package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import com.utils.Getlink.Resolver.premium.PremiumResolver;
import com.utils.kotlin.KotlinHelper;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Gdriver extends PremiumResolver {

    /* renamed from: h  reason: collision with root package name */
    public static String f37522h = Deobfuscator$app$ProductionRelease.a(-179056899993796L);

    private static String q() {
        String str = f37522h;
        if (str == null || str.isEmpty()) {
            HttpHelper i2 = HttpHelper.i();
            f37522h = i2.m(Constants.E + Deobfuscator$app$ProductionRelease.a(-178300985749700L), new Map[0]);
        }
        return f37522h;
    }

    public String c() {
        return Deobfuscator$app$ProductionRelease.a(-178451309605060L);
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        List<ResolveResult> i2;
        String streamLink = mediaSource.getStreamLink();
        String m2 = HttpHelper.i().m(streamLink, new Map[0]);
        ArrayList arrayList = new ArrayList();
        if (JsUnpacker.m30920(m2)) {
            arrayList.addAll(JsUnpacker.m30918(m2));
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-178416949866692L), Constants.C);
        if (!arrayList.isEmpty()) {
            q();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                String a2 = Regex.a(str, Deobfuscator$app$ProductionRelease.a(-178610223395012L), 1);
                if (!a2.isEmpty()) {
                    KotlinHelper.Companion companion = KotlinHelper.f37692a;
                    String replace = ((Deobfuscator$app$ProductionRelease.a(-178185021632708L) + a2.replace(Deobfuscator$app$ProductionRelease.a(-178365410259140L), Deobfuscator$app$ProductionRelease.a(-178391180062916L)) + Deobfuscator$app$ProductionRelease.a(-178343935422660L)) + f37522h).replace(Deobfuscator$app$ProductionRelease.a(-178356820324548L), companion.j(str));
                    Duktape create = Duktape.create();
                    try {
                        Object evaluate = create.evaluate(replace);
                        if (evaluate != null) {
                            ArrayList arrayList2 = new ArrayList();
                            if (JsUnpacker.m30920(m2)) {
                                arrayList2.addAll(JsUnpacker.m30918(evaluate.toString()));
                            }
                            if (arrayList2.size() > 0 && ((i2 = companion.i(arrayList2.toString(), c(), streamLink)) != null || !i2.isEmpty())) {
                                for (ResolveResult next : i2) {
                                    next.setResolverName(c());
                                    next.setPlayHeader(hashMap);
                                    observableEmitter.onNext(BaseResolver.a(mediaSource, next));
                                }
                            }
                        }
                    } finally {
                        create.close();
                    }
                }
            }
        }
    }
}
