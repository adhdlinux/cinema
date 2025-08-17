package com.startapp;

import com.startapp.networkTest.data.RadioInfo;
import com.startapp.networkTest.results.speedtest.MeasurementPointLatency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class k2 {
    public static int a(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0).intValue();
        }
        long j2 = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            j2 += (long) list.get(i2).intValue();
        }
        return Math.round((float) (j2 / ((long) list.size())));
    }

    public static double b(List<Integer> list) {
        long j2 = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            j2 += (long) list.get(i2).intValue();
        }
        double size = ((double) j2) / ((double) list.size());
        double d2 = 0.0d;
        for (int i3 = 0; i3 < list.size(); i3++) {
            d2 += Math.pow(((double) list.get(i3).intValue()) - size, 2.0d);
        }
        double sqrt = Math.sqrt(d2 / ((double) list.size()));
        if (Double.isNaN(sqrt)) {
            return 0.0d;
        }
        return sqrt;
    }

    public static int c(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0).intValue();
        }
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).intValue() > i2) {
                i2 = list.get(i3).intValue();
            }
        }
        return i2;
    }

    public static int d(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0).intValue();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(list.get(i2));
        }
        Collections.sort(arrayList);
        if (arrayList.size() % 2 == 0) {
            return (int) Math.round((((double) ((Integer) arrayList.get(arrayList.size() / 2)).intValue()) + ((double) ((Integer) arrayList.get((arrayList.size() / 2) - 1)).intValue())) / 2.0d);
        }
        return ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
    }

    public static int e(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0).intValue();
        }
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).intValue() < i2) {
                i2 = list.get(i3).intValue();
            }
        }
        return i2;
    }

    public static int a(ArrayList<Integer> arrayList, int i2) {
        long round;
        int size = arrayList.size();
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return arrayList.get(0).intValue();
        }
        int i3 = size - 1;
        double d2 = (((double) i2) / 100.0d) * ((double) i3);
        int i4 = (int) d2;
        double intValue = (double) arrayList.get(i4).intValue();
        double d3 = d2 - ((double) i4);
        if (i4 == i3 || d3 == 0.0d) {
            round = Math.round(intValue);
        } else {
            round = Math.round(intValue + (d3 * (((double) arrayList.get(i4 + 1).intValue()) - intValue)));
        }
        return (int) round;
    }

    public static void b(ArrayList<?> arrayList, int i2) {
        arrayList.ensureCapacity(i2);
        while (arrayList.size() < i2) {
            arrayList.add((Object) null);
        }
    }

    public static MeasurementPointLatency a(long j2, RadioInfo radioInfo, long j3) {
        MeasurementPointLatency measurementPointLatency = new MeasurementPointLatency();
        measurementPointLatency.Rtt = (int) j2;
        measurementPointLatency.ConnectionType = radioInfo.ConnectionType;
        measurementPointLatency.NetworkType = radioInfo.NetworkType;
        measurementPointLatency.RxLev = radioInfo.RXLevel;
        measurementPointLatency.Delta = j3;
        return measurementPointLatency;
    }
}
