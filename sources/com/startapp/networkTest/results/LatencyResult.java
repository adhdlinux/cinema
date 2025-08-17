package com.startapp.networkTest.results;

import com.startapp.j0;
import com.startapp.k2;
import com.startapp.networkTest.enums.ScreenStates;
import com.startapp.networkTest.results.speedtest.MeasurementPointLatency;
import java.util.ArrayList;

public class LatencyResult extends P3TestResult {
    public String AirportCode;
    public long DurationOverall = -1;
    public long DurationOverallNoSleep = -1;
    public double Jitter;
    public String LtrId = "";
    @j0(type = ArrayList.class, value = MeasurementPointLatency.class)
    public ArrayList<MeasurementPointLatency> MeasurementPoints;
    public int Pause;
    public int Pings;
    public ScreenStates ScreenStateOnEnd;
    public ScreenStates ScreenStateOnStart;
    public int SuccessfulPings;

    public LatencyResult(String str, String str2) {
        super(str, str2);
        ScreenStates screenStates = ScreenStates.Unknown;
        this.ScreenStateOnStart = screenStates;
        this.ScreenStateOnEnd = screenStates;
        this.AirportCode = "";
        this.MeasurementPoints = new ArrayList<>();
    }

    public void calculateStats(ArrayList<MeasurementPointLatency> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).Rtt != -1) {
                arrayList2.add(Integer.valueOf(arrayList.get(i2).Rtt));
            }
        }
        this.MinValue = k2.e(arrayList2);
        this.MaxValue = k2.c(arrayList2);
        this.AvgValue = k2.a(arrayList2);
        this.MedValue = k2.d(arrayList2);
        this.Jitter = k2.b(arrayList2);
        this.MeasurementPoints = arrayList;
    }
}
