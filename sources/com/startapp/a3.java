package com.startapp;

import com.startapp.networkTest.data.radio.NetworkRegistrationInfo;
import com.startapp.networkTest.enums.ThreeStateShort;

public class a3 {
    private static NetworkRegistrationInfo a(String[] strArr) {
        NetworkRegistrationInfo networkRegistrationInfo = new NetworkRegistrationInfo();
        for (String str : strArr) {
            if (str.startsWith("transportType")) {
                networkRegistrationInfo.TransportType = e(d(str));
            } else if (str.startsWith("domain")) {
                networkRegistrationInfo.Domain = d(str);
            } else if (str.startsWith("regState")) {
                networkRegistrationInfo.RegState = d(str);
            } else if (str.startsWith("accessNetworkTechnology")) {
                networkRegistrationInfo.NetworkTechnology = d(str);
            } else if (str.startsWith("reasonForDenial")) {
                networkRegistrationInfo.ReasonForDenial = d(str);
            } else if (str.startsWith("emergencyEnabled")) {
                networkRegistrationInfo.EmergencyEnabled = d(str).equals("true");
            } else if (str.startsWith("mIsUsingCarrierAggregation")) {
                networkRegistrationInfo.CarrierAggregation = d(str).equals("true") ? ThreeStateShort.Yes : ThreeStateShort.No;
            } else {
                String str2 = "";
                if (str.startsWith("cellIdentity")) {
                    String d2 = d(str);
                    networkRegistrationInfo.CellTechnology = d2;
                    networkRegistrationInfo.CellTechnology = d2.replace("CellIdentity", str2);
                } else if (str.startsWith("mCid") || str.startsWith("mCi") || str.startsWith("mNetworkId") || str.startsWith("mNci")) {
                    networkRegistrationInfo.CellId = d(str);
                } else if (str.startsWith("mLac") || str.startsWith("mTac") || str.startsWith("mSystemId")) {
                    networkRegistrationInfo.Tac = d(str);
                } else if (str.startsWith("mBsic") || str.startsWith("mPsc") || str.startsWith("mPci") || str.startsWith("mBasestationId")) {
                    String d3 = d(str);
                    if (!d3.startsWith("0x") || d3.length() <= 2) {
                        str2 = d3;
                    } else {
                        try {
                            str2 = String.valueOf((int) Long.parseLong(d3.substring(2), 16));
                        } catch (Throwable th) {
                            l2.a(th);
                        }
                    }
                    networkRegistrationInfo.Pci = str2;
                } else if (str.startsWith("mArfcn") || str.startsWith("mUarfcn") || str.startsWith("mEarfcn") || str.startsWith("mNrArfcn")) {
                    try {
                        networkRegistrationInfo.Arfcn = Integer.parseInt(d(str));
                    } catch (Throwable th2) {
                        l2.a(th2);
                    }
                } else if (str.startsWith("mBandwidth")) {
                    try {
                        networkRegistrationInfo.Bandwidth = Integer.parseInt(d(str));
                    } catch (Throwable th3) {
                        l2.a(th3);
                    }
                } else if (str.startsWith("mMcc")) {
                    networkRegistrationInfo.Mcc = d(str);
                } else if (str.startsWith("mMnc")) {
                    networkRegistrationInfo.Mnc = d(str);
                } else if (str.startsWith("mAlphaLong")) {
                    networkRegistrationInfo.OperatorLong = d(str);
                } else if (str.startsWith("mAlphaShort")) {
                    networkRegistrationInfo.OperatorShort = d(str);
                } else if (str.startsWith("mMaxDataCalls")) {
                    try {
                        networkRegistrationInfo.MaxDataCalls = Integer.parseInt(d(str));
                    } catch (Throwable th4) {
                        l2.a(th4);
                    }
                } else if (str.startsWith("availableServices")) {
                    networkRegistrationInfo.AvailableServices = d(str);
                } else if (str.startsWith("nrState") || str.startsWith("nrStatus")) {
                    networkRegistrationInfo.NrState = d(str);
                } else if (str.startsWith("isDcNrRestricted")) {
                    networkRegistrationInfo.DcNrRestricted = d(str).equals("true") ? ThreeStateShort.Yes : ThreeStateShort.No;
                } else if (str.startsWith("isNrAvailable")) {
                    networkRegistrationInfo.NrAvailable = d(str).equals("true") ? ThreeStateShort.Yes : ThreeStateShort.No;
                } else if (str.startsWith("isEnDcAvailable")) {
                    networkRegistrationInfo.EnDcAvailable = d(str).equals("true") ? ThreeStateShort.Yes : ThreeStateShort.No;
                }
            }
        }
        return networkRegistrationInfo;
    }

    private static String[] b(String str) {
        return str.replace("NetworkRegistrationState", " ").replace("NetworkRegistrationInfo", " ").replace("}", " ").replace("{", " ").replace(":", "").replaceAll(" +", " ").trim().split(" ");
    }

    public static NetworkRegistrationInfo[] c(String str) {
        String str2 = "mNetworkRegistrationStates=";
        try {
            int indexOf = str.indexOf(str2);
            if (indexOf == -1) {
                str2 = "mNetworkRegistrationInfos=";
                indexOf = str.indexOf(str2);
            }
            if (indexOf == -1) {
                return new NetworkRegistrationInfo[0];
            }
            String replaceAll = str.substring(indexOf).substring(str2.length() + 1).replaceAll("\\[\\w@", "@");
            int indexOf2 = replaceAll.indexOf("]");
            int indexOf3 = replaceAll.indexOf("[");
            while (indexOf3 != -1 && indexOf2 > indexOf3) {
                replaceAll = replaceAll.replaceFirst("\\[", "").replaceFirst("]", "");
                indexOf3 = replaceAll.indexOf("[");
                indexOf2 = replaceAll.indexOf("]");
            }
            String[] split = replaceAll.substring(0, indexOf2).split(", ");
            NetworkRegistrationInfo[] networkRegistrationInfoArr = new NetworkRegistrationInfo[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                String a2 = a(split[i2]);
                split[i2] = a2;
                String trim = a2.trim();
                split[i2] = trim;
                networkRegistrationInfoArr[i2] = a(b(trim));
            }
            return networkRegistrationInfoArr;
        } catch (Throwable th) {
            l2.a(th);
            return new NetworkRegistrationInfo[0];
        }
    }

    private static String d(String str) {
        String[] split = str.split("=");
        if (split.length > 1) {
            return split[1];
        }
        return "";
    }

    private static String e(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt == 1) {
                return "WWAN";
            }
            if (parseInt != 2) {
                return Integer.toString(parseInt);
            }
            return "WLAN";
        } catch (Throwable th) {
            l2.b(th);
            return str;
        }
    }

    private static String a(String str) {
        return str.replace("isDcNrRestricted = false", "isDcNrRestricted=false").replace("isDcNrRestricted = true", "isDcNrRestricted=true").replace("isNrAvailable = false", "isNrAvailable=false").replace("isNrAvailable = true", "isNrAvailable=true").replace("isEnDcAvailable = false", "isEnDcAvailable=false").replace("isEnDcAvailable = true", "isEnDcAvailable=true").replace("mIsUsingCarrierAggregation = false", "mIsUsingCarrierAggregation=false").replace("mIsUsingCarrierAggregation = true", "mIsUsingCarrierAggregation=true");
    }
}
