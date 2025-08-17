package com.startapp;

import com.startapp.networkTest.enums.MultiSimVariants;
import java.util.ArrayList;
import java.util.Iterator;

public class q1 implements Cloneable {
    public int ActiveSimCount = -1;
    public int ActiveSimCountMax = -1;
    public int DefaultDataSimId = -1;
    public int DefaultSimId = -1;
    public int DefaultSmsSimId = -1;
    public int DefaultVoiceSimId = -1;
    public MultiSimVariants MultiSimVariant = MultiSimVariants.Unknown;
    @j0(type = ArrayList.class, value = r1.class)
    public ArrayList<r1> SimInfos = new ArrayList<>();

    public r1 getDefaultDataSimInfo() {
        Iterator<r1> it2 = this.SimInfos.iterator();
        while (it2.hasNext()) {
            r1 next = it2.next();
            if (next.SubscriptionId == this.DefaultDataSimId) {
                return next;
            }
        }
        return new r1();
    }

    public r1 getDefaultSmsSimInfo() {
        Iterator<r1> it2 = this.SimInfos.iterator();
        while (it2.hasNext()) {
            r1 next = it2.next();
            if (next.SubscriptionId == this.DefaultSmsSimId) {
                return next;
            }
        }
        return new r1();
    }

    public r1 getDefaultVoiceSimInfo() {
        Iterator<r1> it2 = this.SimInfos.iterator();
        while (it2.hasNext()) {
            r1 next = it2.next();
            if (next.SubscriptionId == this.DefaultVoiceSimId) {
                return next;
            }
        }
        return new r1();
    }

    public r1 getSimInfoSubId(int i2) {
        Iterator<r1> it2 = this.SimInfos.iterator();
        while (it2.hasNext()) {
            r1 next = it2.next();
            if (next.SubscriptionId == i2) {
                return next;
            }
        }
        return new r1();
    }
}
