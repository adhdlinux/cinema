package com.startapp.sdk.ads.video.tracking;

import com.startapp.f6;
import com.startapp.g6;
import com.startapp.j0;
import com.startapp.l6;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VideoTrackingDetails implements Serializable {
    private static final long serialVersionUID = -1841622077369870410L;
    @j0(type = AbsoluteTrackingLink.class)
    private AbsoluteTrackingLink[] absoluteTrackingUrls;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] creativeViewUrls;
    @j0(type = FractionTrackingLink.class)
    private FractionTrackingLink[] fractionTrackingUrls;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] impressionUrls;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] inlineErrorTrackingUrls;
    private boolean isVAST;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] soundMuteUrls;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] soundUnmuteUrls;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoClickTrackingUrls;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoClosedUrls;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoPausedUrls;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoPostRollClickTrackingUrls;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoPostRollClosedUrls;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoPostRollImpressionUrls;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoResumedUrls;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoRewardedUrls;
    @j0(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoSkippedUrls;

    public VideoTrackingDetails() {
    }

    public AbsoluteTrackingLink[] a() {
        return this.absoluteTrackingUrls;
    }

    public ActionTrackingLink[] b() {
        return this.creativeViewUrls;
    }

    public FractionTrackingLink[] c() {
        return this.fractionTrackingUrls;
    }

    public ActionTrackingLink[] d() {
        return this.impressionUrls;
    }

    public ActionTrackingLink[] e() {
        return this.inlineErrorTrackingUrls;
    }

    public ActionTrackingLink[] f() {
        return this.soundMuteUrls;
    }

    public ActionTrackingLink[] g() {
        return this.soundUnmuteUrls;
    }

    public ActionTrackingLink[] h() {
        return this.videoClickTrackingUrls;
    }

    public ActionTrackingLink[] i() {
        return this.videoClosedUrls;
    }

    public ActionTrackingLink[] j() {
        return this.videoPausedUrls;
    }

    public ActionTrackingLink[] k() {
        return this.isVAST ? this.videoPostRollClickTrackingUrls : this.videoClickTrackingUrls;
    }

    public ActionTrackingLink[] l() {
        return this.videoPostRollClosedUrls;
    }

    public ActionTrackingLink[] m() {
        return this.videoPostRollImpressionUrls;
    }

    public ActionTrackingLink[] n() {
        return this.videoResumedUrls;
    }

    public ActionTrackingLink[] o() {
        return this.videoRewardedUrls;
    }

    public ActionTrackingLink[] p() {
        return this.videoSkippedUrls;
    }

    public String toString() {
        return super.toString();
    }

    public VideoTrackingDetails(g6 g6Var) {
        this.isVAST = true;
        this.impressionUrls = b(g6Var.j());
        this.soundMuteUrls = b(g6Var.l());
        this.soundUnmuteUrls = b(g6Var.q());
        this.videoPausedUrls = b(g6Var.m());
        this.videoResumedUrls = b(g6Var.n());
        this.videoSkippedUrls = b(g6Var.p());
        this.videoClosedUrls = b(g6Var.e());
        this.inlineErrorTrackingUrls = b(g6Var.h());
        this.videoClickTrackingUrls = b(g6Var.d());
        this.absoluteTrackingUrls = a(g6Var.a());
        this.fractionTrackingUrls = a(g6Var.i(), g6Var.g());
        f6 f2 = g6Var.f();
        if (f2 != null) {
            this.videoPostRollImpressionUrls = b(f2.d());
            this.videoPostRollClickTrackingUrls = b(f2.b());
        }
    }

    public static ActionTrackingLink[] b(List<String> list) {
        if (list == null) {
            return new ActionTrackingLink[0];
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String b2 : list) {
            ActionTrackingLink actionTrackingLink = new ActionTrackingLink();
            actionTrackingLink.b(b2);
            actionTrackingLink.a(true);
            actionTrackingLink.a("");
            arrayList.add(actionTrackingLink);
        }
        return (ActionTrackingLink[]) arrayList.toArray(new ActionTrackingLink[0]);
    }

    public final AbsoluteTrackingLink[] a(List<l6<Integer>> list) {
        if (list == null) {
            return new AbsoluteTrackingLink[0];
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (l6 next : list) {
            AbsoluteTrackingLink absoluteTrackingLink = new AbsoluteTrackingLink();
            absoluteTrackingLink.b(next.f34860c);
            if (((Integer) next.f34861d).intValue() != -1) {
                absoluteTrackingLink.a(((Integer) next.f34861d).intValue());
            }
            absoluteTrackingLink.a(true);
            absoluteTrackingLink.a("");
            arrayList.add(absoluteTrackingLink);
        }
        return (AbsoluteTrackingLink[]) arrayList.toArray(new AbsoluteTrackingLink[0]);
    }

    public final FractionTrackingLink[] a(List<l6<Float>> list, List<String> list2) {
        ArrayList arrayList = new ArrayList(list.size());
        for (l6 next : list) {
            FractionTrackingLink fractionTrackingLink = new FractionTrackingLink();
            fractionTrackingLink.b(next.f34860c);
            fractionTrackingLink.a((int) (((Float) next.f34861d).floatValue() * 100.0f));
            fractionTrackingLink.a(true);
            fractionTrackingLink.a("");
            arrayList.add(fractionTrackingLink);
        }
        for (String b2 : list2) {
            FractionTrackingLink fractionTrackingLink2 = new FractionTrackingLink();
            fractionTrackingLink2.b(b2);
            fractionTrackingLink2.a(100);
            fractionTrackingLink2.a(true);
            fractionTrackingLink2.a("");
            arrayList.add(fractionTrackingLink2);
        }
        return arrayList.size() > 0 ? (FractionTrackingLink[]) arrayList.toArray(new FractionTrackingLink[0]) : new FractionTrackingLink[0];
    }
}
