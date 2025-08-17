package com.startapp.networkTest.results;

import com.startapp.a1;
import com.startapp.f1;
import com.startapp.h1;
import com.startapp.j0;
import com.startapp.j1;
import com.startapp.l1;
import com.startapp.networkTest.data.BatteryInfo;
import com.startapp.networkTest.data.LocationInfo;
import com.startapp.networkTest.data.RadioInfo;
import com.startapp.networkTest.data.TimeInfo;
import com.startapp.networkTest.data.WifiInfo;
import com.startapp.networkTest.enums.ConnectionTypes;
import com.startapp.networkTest.enums.IpVersions;
import com.startapp.networkTest.enums.MeasurementTypes;
import com.startapp.networkTest.enums.NetworkGenerations;
import com.startapp.networkTest.enums.SpeedtestEndStates;
import com.startapp.networkTest.results.speedtest.MeasurementPointBase;
import com.startapp.networkTest.speedtest.SpeedtestEngineError;
import java.util.ArrayList;
import java.util.Iterator;

public class P3TestResult extends BaseResult {
    public int AvgValue;
    @j0(complex = true)
    public BatteryInfo BatteryInfoOnEnd = new BatteryInfo();
    @j0(complex = true)
    public BatteryInfo BatteryInfoOnStart = new BatteryInfo();
    public String CampaignId = "";
    public long ConnectingTimeControlServer = -1;
    public long ConnectingTimeTestServerControl = -1;
    public long ConnectingTimeTestServerSockets = -1;
    public String CustomerID = "";
    @j0(complex = true)
    public f1 DeviceInfo = new f1();
    public String IMEI = "";
    public String IMSI = "";
    public IpVersions IpVersion = IpVersions.Unknown;
    public int IsAppInForeground = -1;
    @j0(complex = true)
    public LocationInfo LocationInfoOnEnd = new LocationInfo();
    @j0(complex = true)
    public LocationInfo LocationInfoOnStart = new LocationInfo();
    public int MaxValue;
    public MeasurementTypes MeasurementType = MeasurementTypes.Unknown;
    public int MedValue;
    @j0(complex = true)
    public h1 MemoryInfoOnEnd = new h1();
    @j0(complex = true)
    public h1 MemoryInfoOnStart = new h1();
    public String Meta = "";
    public int MinValue;
    @j0(type = ArrayList.class, value = j1.class)
    public ArrayList<j1> QuestionAnswerList = new ArrayList<>();
    public String QuestionnaireName = "";
    @j0(complex = true)
    public RadioInfo RadioInfoOnEnd = new RadioInfo();
    @j0(complex = true)
    public RadioInfo RadioInfoOnStart = new RadioInfo();
    public double RatShare2G;
    public double RatShare3G;
    public double RatShare4G;
    public double RatShare5G;
    public double RatShareUnknown;
    public double RatShareWiFi;
    public String SequenceID = "";
    public String Server = "";
    public boolean Success;
    public SpeedtestEndStates TestEndState = SpeedtestEndStates.Unknown;
    public SpeedtestEngineError TestErrorReason = SpeedtestEngineError.OK;
    @j0(complex = true)
    public TimeInfo TimeInfoOnEnd = new TimeInfo();
    @j0(complex = true)
    public TimeInfo TimeInfoOnStart = new TimeInfo();
    @j0(complex = true)
    public l1 TrafficInfoOnEnd = new l1();
    @j0(complex = true)
    public l1 TrafficInfoOnStart = new l1();
    @j0(complex = true)
    public WifiInfo WifiInfoOnEnd = new WifiInfo();
    @j0(complex = true)
    public WifiInfo WifiInfoOnStart = new WifiInfo();

    public P3TestResult(String str, String str2) {
        super(str, str2);
    }

    public void calcRatShare(ArrayList<? extends MeasurementPointBase> arrayList) {
        Iterator<? extends MeasurementPointBase> it2 = arrayList.iterator();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (it2.hasNext()) {
            MeasurementPointBase measurementPointBase = (MeasurementPointBase) it2.next();
            ConnectionTypes connectionTypes = measurementPointBase.ConnectionType;
            if (connectionTypes != ConnectionTypes.Unknown) {
                if (connectionTypes == ConnectionTypes.Mobile) {
                    NetworkGenerations b2 = a1.b(measurementPointBase.NetworkType);
                    if (measurementPointBase.NrState.equals("CONNECTED")) {
                        b2 = NetworkGenerations.Gen5;
                    }
                    int ordinal = b2.ordinal();
                    if (ordinal == 0) {
                        i8++;
                    } else if (ordinal == 1) {
                        i7++;
                    } else if (ordinal == 2) {
                        i6++;
                    } else if (ordinal == 3) {
                        i5++;
                    }
                } else {
                    i4++;
                }
                i2++;
            }
            i3++;
            i2++;
        }
        if (i2 > 0) {
            double d2 = (double) i2;
            this.RatShare2G = ((double) i8) / d2;
            this.RatShare3G = ((double) i7) / d2;
            this.RatShare4G = ((double) i6) / d2;
            this.RatShare5G = ((double) i5) / d2;
            this.RatShareWiFi = ((double) i4) / d2;
            this.RatShareUnknown = ((double) i3) / d2;
        }
    }
}
