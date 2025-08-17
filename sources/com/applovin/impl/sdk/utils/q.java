package com.applovin.impl.sdk.utils;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class q {
    public static void a(final View view, long j2, final Runnable runnable) {
        view.setVisibility(4);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(j2);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        view.startAnimation(alphaAnimation);
    }

    public static boolean a(int i2) {
        return i2 == 0;
    }

    public static boolean a(int i2, int i3) {
        return a(i2) != a(i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        if ((r6 & 16) == 16) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0078, code lost:
        if ((r6 & 1) == 1) goto L_0x0044;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] a(int r6, int r7, int r8) {
        /*
            r0 = 2
            r1 = 0
            r2 = 1
            if (r6 != 0) goto L_0x000c
            int[] r6 = new int[r0]
            r6[r1] = r7
            r6[r2] = r8
            return r6
        L_0x000c:
            r3 = r6 & 119(0x77, float:1.67E-43)
            r4 = 119(0x77, float:1.67E-43)
            if (r3 != r4) goto L_0x0019
            int[] r6 = new int[r2]
            r7 = 13
            r6[r1] = r7
            return r6
        L_0x0019:
            r3 = r6 & 112(0x70, float:1.57E-43)
            r4 = 15
            r5 = 112(0x70, float:1.57E-43)
            if (r3 != r5) goto L_0x0024
        L_0x0021:
            r7 = 15
            goto L_0x003d
        L_0x0024:
            r3 = r6 & 48
            r5 = 48
            if (r3 != r5) goto L_0x002d
            r7 = 10
            goto L_0x003d
        L_0x002d:
            r3 = r6 & 80
            r5 = 80
            if (r3 != r5) goto L_0x0036
            r7 = 12
            goto L_0x003d
        L_0x0036:
            r3 = r6 & 16
            r5 = 16
            if (r3 != r5) goto L_0x003d
            goto L_0x0021
        L_0x003d:
            r3 = r6 & 7
            r4 = 14
            r5 = 7
            if (r3 != r5) goto L_0x0047
        L_0x0044:
            r8 = 14
            goto L_0x007b
        L_0x0047:
            boolean r3 = com.applovin.impl.sdk.utils.g.b()
            if (r3 == 0) goto L_0x0057
            r3 = 8388611(0x800003, float:1.1754948E-38)
            r5 = r6 & r3
            if (r5 != r3) goto L_0x0057
            r8 = 20
            goto L_0x007b
        L_0x0057:
            r3 = r6 & 3
            r5 = 3
            if (r3 != r5) goto L_0x005f
            r8 = 9
            goto L_0x007b
        L_0x005f:
            boolean r3 = com.applovin.impl.sdk.utils.g.b()
            if (r3 == 0) goto L_0x006f
            r3 = 8388613(0x800005, float:1.175495E-38)
            r5 = r6 & r3
            if (r5 != r3) goto L_0x006f
            r8 = 21
            goto L_0x007b
        L_0x006f:
            r3 = r6 & 5
            r5 = 5
            if (r3 != r5) goto L_0x0077
            r8 = 11
            goto L_0x007b
        L_0x0077:
            r6 = r6 & r2
            if (r6 != r2) goto L_0x007b
            goto L_0x0044
        L_0x007b:
            int[] r6 = new int[r0]
            r6[r1] = r8
            r6[r2] = r7
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.q.a(int, int, int):int[]");
    }

    public static String b(int i2) {
        return i2 == 0 ? "VISIBLE" : i2 == 4 ? "INVISIBLE" : i2 == 8 ? "GONE" : String.valueOf(i2);
    }

    public static void b(final View view, long j2, final Runnable runnable) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j2);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(4);
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        view.startAnimation(alphaAnimation);
    }
}
