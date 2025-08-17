package com.startapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.startapp.sdk.adsbase.remoteconfig.TelephonyMetadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class od extends jd<nd> {

    /* renamed from: j  reason: collision with root package name */
    public final ua<TelephonyMetadata> f35571j;

    /* renamed from: k  reason: collision with root package name */
    public final TelephonyManager.CellInfoCallback f35572k;

    public class a extends TelephonyManager.CellInfoCallback {
        public a() {
        }

        public void onCellInfo(List<CellInfo> list) {
            od.this.b(false);
        }
    }

    public class b implements Comparator<CellInfo> {
        public b(od odVar) {
        }

        public int compare(Object obj, Object obj2) {
            CellInfo cellInfo = (CellInfo) obj;
            CellInfo cellInfo2 = (CellInfo) obj2;
            if (cellInfo.isRegistered() == cellInfo2.isRegistered()) {
                return od.a(cellInfo2) - od.a(cellInfo);
            }
            if (cellInfo.isRegistered()) {
                return -1;
            }
            if (cellInfo2.isRegistered()) {
                return 1;
            }
            return 0;
        }
    }

    public od(Context context, x6 x6Var, va vaVar, ua<TelephonyMetadata> uaVar) {
        super(context, x6Var, vaVar, "c9c194d3e01bcf14", "086ea3852ae4e475");
        this.f35571j = uaVar;
        if (Build.VERSION.SDK_INT >= 29) {
            this.f35572k = new a();
        } else {
            this.f35572k = null;
        }
    }

    public Object a(String str) {
        if (str != null) {
            try {
                return new nd(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public void b(boolean z2) {
        TelephonyMetadata call;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f34373a.getSystemService("phone");
            nd ndVar = new nd(new JSONObject());
            ndVar.a(7, Integer.valueOf(telephonyManager.getSimState()));
            ndVar.a(8, telephonyManager.getSimOperator());
            ndVar.a(9, telephonyManager.getSimOperatorName());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                ndVar.a(15, String.valueOf(telephonyManager.getSimCarrierId()));
                ndVar.a(16, String.valueOf(telephonyManager.getSimCarrierIdName()));
            }
            ndVar.a(10, Integer.valueOf(telephonyManager.getPhoneType()));
            ndVar.a(11, fc.b(telephonyManager.getNetworkOperator()));
            ndVar.a(12, fc.b(telephonyManager.getNetworkOperatorName()));
            if (hc.a(this.f34373a, "android.permission.ACCESS_FINE_LOCATION")) {
                if (i2 >= 29 && z2 && (call = this.f35571j.call()) != null && call.d()) {
                    telephonyManager.requestCellInfoUpdate(this.f34770f, this.f35572k);
                }
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    a(ndVar, allCellInfo);
                }
            }
            b(ndVar);
        } catch (Throwable th) {
            y8.a(this.f34373a, th);
        }
    }

    public String c(Object obj) {
        return ((nd) obj).f34972b.toString();
    }

    public long d() {
        return 60000;
    }

    public boolean f() {
        return true;
    }

    public void g() {
        b(true);
    }

    public final void a(nd ndVar, CellLocation cellLocation) {
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            ndVar.a(4, fc.b(String.valueOf(gsmCellLocation.getCid())));
            ndVar.a(3, fc.b(String.valueOf(gsmCellLocation.getLac())));
        } else if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            ndVar.a(1, fc.b(String.valueOf(cdmaCellLocation.getBaseStationLatitude())));
            ndVar.a(2, fc.b(String.valueOf(cdmaCellLocation.getBaseStationLongitude())));
        }
    }

    public Object c() {
        return nd.f34971a;
    }

    public static int a(CellInfo cellInfo) {
        CellSignalStrength cellSignalStrength;
        if (cellInfo instanceof CellInfoCdma) {
            cellSignalStrength = ((CellInfoCdma) cellInfo).getCellSignalStrength();
        } else if (cellInfo instanceof CellInfoGsm) {
            cellSignalStrength = ((CellInfoGsm) cellInfo).getCellSignalStrength();
        } else if (cellInfo instanceof CellInfoLte) {
            cellSignalStrength = ((CellInfoLte) cellInfo).getCellSignalStrength();
        } else {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29 && (cellInfo instanceof CellInfoNr)) {
                cellSignalStrength = ((CellInfoNr) cellInfo).getCellSignalStrength();
            } else if (i2 < 29 || !(cellInfo instanceof CellInfoTdscdma)) {
                cellSignalStrength = cellInfo instanceof CellInfoWcdma ? ((CellInfoWcdma) cellInfo).getCellSignalStrength() : null;
            } else {
                cellSignalStrength = ((CellInfoTdscdma) cellInfo).getCellSignalStrength();
            }
        }
        if (cellSignalStrength != null) {
            return cellSignalStrength.getLevel();
        }
        return 0;
    }

    public void a(nd ndVar, List<CellInfo> list) {
        CellIdentityWcdma cellIdentity;
        int a2;
        int timingAdvance;
        int tac;
        CellSignalStrengthGsm cellSignalStrength;
        int a3;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new b(this));
        ndVar.a(6, fc.b(arrayList.toString()));
        Iterator it2 = arrayList.iterator();
        boolean z2 = true;
        while (it2.hasNext()) {
            CellInfo cellInfo = (CellInfo) it2.next();
            if (z2) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                    if (cellIdentity2 != null) {
                        int latitude = cellIdentity2.getLatitude();
                        int longitude = cellIdentity2.getLongitude();
                        if (!(latitude == Integer.MAX_VALUE || longitude == Integer.MAX_VALUE)) {
                            ndVar.a(1, fc.b(String.valueOf(latitude)));
                            ndVar.a(2, fc.b(String.valueOf(longitude)));
                        }
                    }
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity3 = cellInfoGsm.getCellIdentity();
                    if (cellIdentity3 != null) {
                        int lac = cellIdentity3.getLac();
                        if (lac != Integer.MAX_VALUE) {
                            ndVar.a(3, fc.b(String.valueOf(lac)));
                        }
                        int cid = cellIdentity3.getCid();
                        if (cid != Integer.MAX_VALUE) {
                            ndVar.a(4, fc.b(String.valueOf(cid)));
                        }
                    }
                    if (!(Build.VERSION.SDK_INT < 26 || (cellSignalStrength = cellInfoGsm.getCellSignalStrength()) == null || (a3 = cellSignalStrength.getTimingAdvance()) == Integer.MAX_VALUE)) {
                        ndVar.a(13, String.valueOf(a3));
                    }
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                    if (!(cellIdentity4 == null || (tac = cellIdentity4.getTac()) == Integer.MAX_VALUE)) {
                        ndVar.a(5, fc.b(String.valueOf(tac)));
                    }
                    CellSignalStrengthLte cellSignalStrength2 = cellInfoLte.getCellSignalStrength();
                    if (!(cellSignalStrength2 == null || (timingAdvance = cellSignalStrength2.getTimingAdvance()) == Integer.MAX_VALUE)) {
                        ndVar.a(13, String.valueOf(timingAdvance));
                    }
                } else {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 29 && (cellInfo instanceof CellInfoNr)) {
                        CellIdentityNr cellIdentityNr = (CellIdentityNr) ((CellInfoNr) cellInfo).getCellIdentity();
                        if (!(cellIdentityNr == null || (a2 = cellIdentityNr.getTac()) == Integer.MAX_VALUE)) {
                            ndVar.a(5, fc.b(String.valueOf(a2)));
                        }
                    } else if (i2 >= 29 && (cellInfo instanceof CellInfoTdscdma)) {
                        CellIdentityTdscdma a4 = ((CellInfoTdscdma) cellInfo).getCellIdentity();
                        if (a4 != null) {
                            int a5 = a4.getLac();
                            if (a5 != Integer.MAX_VALUE) {
                                ndVar.a(3, fc.b(String.valueOf(a5)));
                            }
                            int a6 = a4.getCid();
                            if (a6 != Integer.MAX_VALUE) {
                                ndVar.a(4, fc.b(String.valueOf(a6)));
                            }
                        }
                    } else if ((cellInfo instanceof CellInfoWcdma) && (cellIdentity = ((CellInfoWcdma) cellInfo).getCellIdentity()) != null) {
                        int lac2 = cellIdentity.getLac();
                        if (lac2 != Integer.MAX_VALUE) {
                            ndVar.a(3, fc.b(String.valueOf(lac2)));
                        }
                        int cid2 = cellIdentity.getCid();
                        if (cid2 != Integer.MAX_VALUE) {
                            ndVar.a(4, fc.b(String.valueOf(cid2)));
                        }
                    }
                }
                z2 = false;
            }
            if (!cellInfo.isRegistered()) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
                ndVar.a(14, 1);
            }
        }
    }
}
