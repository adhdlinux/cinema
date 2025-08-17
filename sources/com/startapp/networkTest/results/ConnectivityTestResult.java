package com.startapp.networkTest.results;

import com.startapp.f1;
import com.startapp.h1;
import com.startapp.i1;
import com.startapp.j0;
import com.startapp.k1;
import com.startapp.l1;
import com.startapp.networkTest.data.BatteryInfo;
import com.startapp.networkTest.data.IspInfo;
import com.startapp.networkTest.data.LocationInfo;
import com.startapp.networkTest.data.RadioInfo;
import com.startapp.networkTest.data.TimeInfo;
import com.startapp.networkTest.data.WifiInfo;
import com.startapp.networkTest.data.radio.ApnInfo;
import com.startapp.networkTest.data.radio.CellInfo;
import com.startapp.networkTest.data.radio.NetworkRegistrationInfo;
import com.startapp.networkTest.enums.CtTestTypes;
import com.startapp.networkTest.enums.FileTypes;
import com.startapp.networkTest.enums.IdleStates;
import com.startapp.networkTest.enums.NetworkTypes;
import com.startapp.networkTest.enums.ScreenStates;
import com.startapp.networkTest.enums.voice.CallStates;
import com.startapp.r1;
import com.startapp.z2;
import java.util.ArrayList;

public class ConnectivityTestResult extends BaseResult {
    public String AirportCode;
    public String AmazonId = "";
    @j0(type = ArrayList.class, value = ApnInfo.class)
    public ArrayList<ApnInfo> ApnInfo;
    @j0(complex = true)
    public BatteryInfo BatteryInfo;
    public long BytesRead = -1;
    public CallStates CallState;
    @j0(type = ArrayList.class, value = CellInfo.class)
    public ArrayList<CellInfo> CellInfo;
    public String CtId = "";
    @j0(complex = true)
    public f1 DeviceInfo;
    public long DurationDNS = -1;
    public long DurationHttpGetCommand = -1;
    public long DurationHttpReceive = -1;
    public long DurationOverall = -1;
    public long DurationOverallNoSleep = -1;
    public long DurationSSL = -1;
    public long DurationTcpConnect = -1;
    public String ErrorReason;
    public int HTTPStatus = -1;
    public long HeaderBytesRead = -1;
    public IdleStates IdleStateOnEnd;
    public IdleStates IdleStateOnStart;
    public int IsAppInForeground;
    public boolean IsKeepAlive = false;
    @j0(complex = true)
    public IspInfo IspInfo;
    public boolean LocalhostPingSuccess = false;
    @j0(complex = true)
    public LocationInfo LocationInfo;
    @j0(complex = true)
    public h1 MemoryInfo;
    @j0(type = ArrayList.class, value = i1.class)
    public ArrayList<i1> MultiCdnInfo;
    @j0(type = ArrayList.class, value = NetworkRegistrationInfo.class)
    public ArrayList<NetworkRegistrationInfo> NetworkRegistrationInfo;
    @j0(complex = true)
    public RadioInfo RadioInfo;
    @j0(complex = true)
    public RadioInfo RadioInfoOnEnd;
    public ScreenStates ScreenState = ScreenStates.Unknown;
    public String ServerFilename = "";
    public String ServerHostname = "";
    public String ServerIp = "";
    public long ServerMultiSuccess;
    @j0(complex = true)
    public r1 SimInfo;
    public String SslException;
    @j0(complex = true)
    public k1 StorageInfo;
    public boolean Success = false;
    public String TestTimestamp = "";
    public CtTestTypes TestType = CtTestTypes.Unknown;
    @j0(complex = true)
    public TimeInfo TimeInfo;
    @j0(complex = true)
    public l1 TrafficInfo;
    public long TruststoreTimestamp;
    public NetworkTypes VoiceNetworkType;
    @j0(complex = true)
    public WifiInfo WifiInfo;

    public ConnectivityTestResult(String str, String str2) {
        super(str, str2);
        IdleStates idleStates = IdleStates.Unknown;
        this.IdleStateOnStart = idleStates;
        this.IdleStateOnEnd = idleStates;
        this.ErrorReason = "";
        this.SslException = "";
        this.CallState = CallStates.Unknown;
        this.VoiceNetworkType = NetworkTypes.Unknown;
        this.ServerMultiSuccess = -1;
        this.AirportCode = "";
        this.IsAppInForeground = -1;
        this.BatteryInfo = new BatteryInfo();
        this.DeviceInfo = new f1();
        this.LocationInfo = new LocationInfo();
        this.MemoryInfo = new h1();
        this.RadioInfo = new RadioInfo();
        this.RadioInfoOnEnd = new RadioInfo();
        this.StorageInfo = new k1();
        this.TrafficInfo = new l1();
        this.WifiInfo = new WifiInfo();
        this.TimeInfo = new TimeInfo();
        this.IspInfo = new IspInfo();
        this.SimInfo = new r1();
        this.MultiCdnInfo = new ArrayList<>();
        this.CellInfo = new ArrayList<>();
        this.ApnInfo = new ArrayList<>();
        this.NetworkRegistrationInfo = new ArrayList<>();
    }

    public String toJson() {
        return z2.a(FileTypes.CT, (BaseResult) this);
    }
}
