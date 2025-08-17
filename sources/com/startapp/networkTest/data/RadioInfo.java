package com.startapp.networkTest.data;

import com.startapp.j0;
import com.startapp.networkTest.data.radio.NeighboringCell;
import com.startapp.networkTest.enums.ConnectionTypes;
import com.startapp.networkTest.enums.DuplexMode;
import com.startapp.networkTest.enums.FlightModeStates;
import com.startapp.networkTest.enums.NetworkTypes;
import com.startapp.networkTest.enums.PreferredNetworkTypes;
import com.startapp.networkTest.enums.ServiceStates;
import com.startapp.networkTest.enums.ThreeState;
import com.startapp.networkTest.enums.ThreeStateShort;
import com.startapp.networkTest.enums.radio.DataConnectionStates;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class RadioInfo implements Cloneable, Serializable {
    public static final Integer INVALID = Integer.MAX_VALUE;
    private static final long serialVersionUID = 4817753379835440169L;
    public int ARFCN;
    public ThreeStateShort CarrierAggregation;
    public String CdmaBaseStationId = "";
    public String CdmaBaseStationLatitude = "";
    public String CdmaBaseStationLongitude = "";
    public int CdmaEcIo;
    public String CdmaNetworkId = "";
    public String CdmaSystemId = "";
    public ConnectionTypes ConnectionType;
    public DuplexMode DuplexMode;
    public int EcN0;
    public FlightModeStates FlightMode;
    public String GsmCellId = "";
    public int GsmCellIdAge = -1;
    public String GsmLAC = "";
    public transient boolean IsDefaultDataSim = true;
    public transient boolean IsDefaultVoiceSim = true;
    public ThreeStateShort IsMetered;
    public boolean IsRoaming;
    public int IsVpn;
    public int LteCqi;
    public int LteRsrp;
    public int LteRsrq;
    public int LteRssi;
    public int LteRssnr;
    public String MCC;
    public String MNC;
    public ThreeStateShort ManualSelection;
    public boolean MissingPermission;
    public DataConnectionStates MobileDataConnectionState;
    public ThreeState MobileDataEnabled;
    public int NativeDbm;
    @j0(type = ArrayList.class, value = NeighboringCell.class)
    public ArrayList<NeighboringCell> NeighboringCells;
    public NetworkTypes NetworkType = NetworkTypes.Unknown;
    public ThreeStateShort NrAvailable;
    public int NrCsiRsrp;
    public int NrCsiRsrq;
    public int NrCsiSinr;
    public int NrSsRsrp;
    public int NrSsRsrq;
    public int NrSsSinr;
    public String NrState;
    public String OperatorName;
    public PreferredNetworkTypes PreferredNetwork;
    public String PrimaryScramblingCode;
    public int RSCP;
    public int RXLevel;
    public int RXLevelAge;
    public ServiceStates ServiceState = ServiceStates.Unknown;
    public int ServiceStateAge;
    public int SubscriptionId;

    public RadioInfo() {
        Integer num = INVALID;
        this.CdmaEcIo = num.intValue();
        this.NativeDbm = num.intValue();
        this.RXLevelAge = -1;
        this.MCC = "";
        this.MNC = "";
        this.FlightMode = FlightModeStates.Unknown;
        this.ConnectionType = ConnectionTypes.Unknown;
        this.OperatorName = "";
        this.RSCP = num.intValue();
        this.ARFCN = -1;
        this.EcN0 = 0;
        this.PrimaryScramblingCode = "";
        this.LteCqi = num.intValue();
        this.LteRsrp = num.intValue();
        this.LteRsrq = num.intValue();
        this.LteRssnr = num.intValue();
        this.LteRssi = num.intValue();
        this.NrCsiRsrp = num.intValue();
        this.NrCsiRsrq = num.intValue();
        this.NrCsiSinr = num.intValue();
        this.NrSsRsrp = num.intValue();
        this.NrSsRsrq = num.intValue();
        this.NrSsSinr = num.intValue();
        this.NrState = "Unknown";
        ThreeStateShort threeStateShort = ThreeStateShort.Unknown;
        this.NrAvailable = threeStateShort;
        this.IsRoaming = false;
        this.IsMetered = threeStateShort;
        this.MobileDataEnabled = ThreeState.Unknown;
        this.MobileDataConnectionState = DataConnectionStates.Unknown;
        this.MissingPermission = false;
        this.SubscriptionId = -1;
        this.PreferredNetwork = PreferredNetworkTypes.Unknown;
        this.DuplexMode = DuplexMode.Unknown;
        this.ManualSelection = threeStateShort;
        this.CarrierAggregation = threeStateShort;
        this.ServiceStateAge = -1;
        this.IsVpn = -1;
        this.NeighboringCells = new ArrayList<>();
    }

    public Object clone() throws CloneNotSupportedException {
        RadioInfo radioInfo = (RadioInfo) super.clone();
        radioInfo.NeighboringCells = new ArrayList<>();
        Iterator<NeighboringCell> it2 = this.NeighboringCells.iterator();
        while (it2.hasNext()) {
            radioInfo.NeighboringCells.add((NeighboringCell) it2.next().clone());
        }
        return radioInfo;
    }
}
