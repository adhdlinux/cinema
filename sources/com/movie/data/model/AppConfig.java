package com.movie.data.model;

import java.util.List;
import java.util.Map;

public class AppConfig {
    private AdsBean ads;
    private List<String> blocks_package;
    private Map<String, String> cbflist;
    private String cleaf_download_url;
    private String donate_url;
    private String event_category;
    private String fanpage;
    private ForceBean force;
    private List<Integer> fringing_movie;
    private String github_js;
    private Map<String, String> hdlist;
    private NotificationBean notification2;
    private String opensubtitle_user_agent;
    private String os_type;
    private List<PaymentMethod> payments;
    private List<?> promotions;
    private ProviderBean provider;
    private RdConfigBean rd_config;
    private ResloverBean reslover;
    private String share_url;
    private String support_email;
    private SyncBean sync;
    private List<String> tmdb_api_keys;
    private UpdateBean update;
    private String user_agent;

    public static class AdsBean {
        private AdcolonyBean adcolony;
        private AdcolonyBean adcolony_amz;
        private AdmobBean admob;
        private ApplovinBean applovin;
        private ChartBoostBean chartBoost;
        private ChartBoostBean chartBoost_amz;
        private FacebookAdsBean facebookAds;
        private HouseAdsBean house_ads;
        private IronSrcBean ironsrc;
        private long limitAdsTime = 0;
        private boolean mute = true;
        private StartAppBean startApp;
        private UnityAdsBean unity_ads;
        private UnityAdsBean unity_ads_amz;
        private VungleBean vungle;
        private VungleBean vungle_amz;

        public static class AdcolonyBean {
            private String app_id;
            private String ecmp;
            private boolean enable;
            private String interstitial_id;
            private String zone_id;

            public String getApp_id() {
                return this.app_id;
            }

            public String getEcmp() {
                return this.ecmp;
            }

            public String getInterstitial_id() {
                return this.interstitial_id;
            }

            public String getZone_id() {
                return this.zone_id;
            }

            public boolean isEnable() {
                return this.enable;
            }

            public void setApp_id(String str) {
                this.app_id = str;
            }

            public void setEcmp(String str) {
                this.ecmp = str;
            }

            public void setEnable(boolean z2) {
                this.enable = z2;
            }

            public void setInterstitial_id(String str) {
                this.interstitial_id = str;
            }

            public void setZone_id(String str) {
                this.zone_id = str;
            }
        }

        public static class AdmobBean {
            private String app_id;
            private String banner;
            private String ecmp;
            private boolean enable;
            private String interstitial;
            private String nativeAdvance;
            private String nativeExpress;
            private String rewardVideo;
            private boolean showBanner;
            private int showIntertisialPercent;
            private boolean showNativeAdvance;
            private int showVideoAdPercent;

            public String getApp_id() {
                return this.app_id;
            }

            public String getBanner() {
                return this.banner;
            }

            public String getEcmp() {
                return this.ecmp;
            }

            public String getInterstitial() {
                return this.interstitial;
            }

            public String getNativeAdvance() {
                return this.nativeAdvance;
            }

            public String getNativeExpress() {
                return this.nativeExpress;
            }

            public String getRewardVideo() {
                return this.rewardVideo;
            }

            public int getShowIntertisialPercent() {
                return this.showIntertisialPercent;
            }

            public int getShowVideoAdPercent() {
                return this.showVideoAdPercent;
            }

            public boolean isEnable() {
                return this.enable;
            }

            public boolean isShowBanner() {
                return this.showBanner;
            }

            public boolean isShowNativeAdvance() {
                return this.showNativeAdvance;
            }

            public void setApp_id(String str) {
                this.app_id = str;
            }

            public void setBanner(String str) {
                this.banner = str;
            }

            public void setEcmp(String str) {
                this.ecmp = str;
            }

            public void setEnable(boolean z2) {
                this.enable = z2;
            }

            public void setInterstitial(String str) {
                this.interstitial = str;
            }

            public void setNativeAdvance(String str) {
                this.nativeAdvance = str;
            }

            public void setNativeExpress(String str) {
                this.nativeExpress = str;
            }

            public void setRewardVideo(String str) {
                this.rewardVideo = str;
            }

            public void setShowBanner(boolean z2) {
                this.showBanner = z2;
            }

            public void setShowIntertisialPercent(int i2) {
                this.showIntertisialPercent = i2;
            }

            public void setShowNativeAdvance(boolean z2) {
                this.showNativeAdvance = z2;
            }

            public void setShowVideoAdPercent(int i2) {
                this.showVideoAdPercent = i2;
            }
        }

        public static class ApplovinBean {
            private String ecmp;
            private boolean enable;

            public String getEcmp() {
                return this.ecmp;
            }

            public boolean isEnable() {
                return this.enable;
            }

            public void setEcmp(String str) {
                this.ecmp = str;
            }

            public void setEnable(boolean z2) {
                this.enable = z2;
            }
        }

        public static class ChartBoostBean {
            private String app_id;
            private String ecmp;
            private boolean enable;
            private String signature;

            public String getApp_id() {
                return this.app_id;
            }

            public String getEcmp() {
                return this.ecmp;
            }

            public String getSignature() {
                return this.signature;
            }

            public boolean isEnable() {
                return this.enable;
            }

            public void setApp_id(String str) {
                this.app_id = str;
            }

            public void setEcmp(String str) {
                this.ecmp = str;
            }

            public void setEnable(boolean z2) {
                this.enable = z2;
            }

            public void setSignature(String str) {
                this.signature = str;
            }
        }

        public static class FacebookAdsBean {
            private String app_id;
            private String banner;
            private String ecmp;
            private boolean enable;
            private String interstitial;
            private String nativeAdvance;

            public String getApp_id() {
                return this.app_id;
            }

            public String getBanner() {
                return this.banner;
            }

            public String getEcmp() {
                return this.ecmp;
            }

            public String getInterstitial() {
                return this.interstitial;
            }

            public String getNativeAdvance() {
                return this.nativeAdvance;
            }

            public boolean isEnable() {
                return this.enable;
            }

            public void setApp_id(String str) {
                this.app_id = str;
            }

            public void setBanner(String str) {
                this.banner = str;
            }

            public void setEcmp(String str) {
                this.ecmp = str;
            }

            public void setEnable(boolean z2) {
                this.enable = z2;
            }

            public void setInterstitial(String str) {
                this.interstitial = str;
            }

            public void setNativeAdvance(String str) {
                this.nativeAdvance = str;
            }
        }

        public static class HouseAdsBean {
            private String config;
            private String ecmp;
            private boolean enable;

            public String getConfig() {
                return this.config;
            }

            public String getEcmp() {
                return this.ecmp;
            }

            public boolean isEnable() {
                return this.enable;
            }

            public void setConfig(String str) {
                this.config = str;
            }

            public void setEcmp(String str) {
                this.ecmp = str;
            }

            public void setEnable(boolean z2) {
                this.enable = z2;
            }
        }

        public static class IronSrcBean {
            private String appkey;
            private String ecmp;
            private boolean enable;

            public String getAppkey() {
                return this.appkey;
            }

            public String getEcmp() {
                return this.ecmp;
            }

            public boolean isEnable() {
                return this.enable;
            }

            public void setAppkey(String str) {
                this.appkey = str;
            }

            public void setEcmp(String str) {
                this.ecmp = str;
            }

            public void setEnable(boolean z2) {
                this.enable = z2;
            }
        }

        public static class StartAppBean {
            private String app_id;
            private String ecmp;
            private boolean enable;
            private boolean enable_splash_ads;
            private int show_percent;

            public String getApp_id() {
                return this.app_id;
            }

            public String getEcmp() {
                return this.ecmp;
            }

            public int getShow_percent() {
                return this.show_percent;
            }

            public boolean isEnable() {
                return this.enable;
            }

            public boolean isEnable_splash_ads() {
                return this.enable_splash_ads;
            }

            public void setApp_id(String str) {
                this.app_id = str;
            }

            public void setEcmp(String str) {
                this.ecmp = str;
            }

            public void setEnable(boolean z2) {
                this.enable = z2;
            }

            public void setEnable_splash_ads(boolean z2) {
                this.enable_splash_ads = z2;
            }

            public void setShow_percent(int i2) {
                this.show_percent = i2;
            }
        }

        public static class UnityAdsBean {
            private String banner_id;
            private String ecmp;
            private boolean enable;
            private String game_id;
            private String interstitial_id;
            private String rewarded_id;

            public String getBanner_id() {
                return this.banner_id;
            }

            public String getEcmp() {
                return this.ecmp;
            }

            public String getGame_id() {
                return this.game_id;
            }

            public String getInterstitial_id() {
                return this.interstitial_id;
            }

            public String getRewarded_id() {
                return this.rewarded_id;
            }

            public boolean isEnable() {
                return this.enable;
            }

            public void setBanner_id(String str) {
                this.banner_id = str;
            }

            public void setEcmp(String str) {
                this.ecmp = str;
            }

            public void setEnable(boolean z2) {
                this.enable = z2;
            }

            public void setGame_id(String str) {
                this.game_id = str;
            }

            public void setInterstitial_id(String str) {
                this.interstitial_id = str;
            }

            public void setRewarded_id(String str) {
                this.rewarded_id = str;
            }
        }

        public static class VungleBean {
            private String app_id;
            private String ecmp;
            private boolean enable;
            private String placement_interstitial;
            private String placement_ref_banner_id;
            private String placement_ref_id;
            private String placement_ref_native_id;
            private String report_id;

            public String getApp_id() {
                return this.app_id;
            }

            public String getEcmp() {
                return this.ecmp;
            }

            public String getPlacement_interstitial() {
                return this.placement_interstitial;
            }

            public String getPlacement_ref_banner_id() {
                return this.placement_ref_banner_id;
            }

            public String getPlacement_ref_id() {
                return this.placement_ref_id;
            }

            public String getPlacement_ref_native_id() {
                return this.placement_ref_native_id;
            }

            public String getReport_id() {
                return this.report_id;
            }

            public boolean isEnable() {
                return this.enable;
            }

            public void setApp_id(String str) {
                this.app_id = str;
            }

            public void setEcmp(String str) {
                this.ecmp = str;
            }

            public void setEnable(boolean z2) {
                this.enable = z2;
            }

            public void setPlacement_interstitial(String str) {
                this.placement_interstitial = str;
            }

            public void setPlacement_ref_id(String str) {
                this.placement_ref_id = str;
            }

            public void setPlacement_ref_native_id(String str) {
                this.placement_ref_native_id = str;
            }

            public void setReport_id(String str) {
                this.report_id = str;
            }
        }

        public AdcolonyBean getAdcolony() {
            return this.adcolony;
        }

        public AdcolonyBean getAdcolony_amz() {
            return this.adcolony_amz;
        }

        public AdmobBean getAdmob() {
            return this.admob;
        }

        public ApplovinBean getApplovin() {
            return this.applovin;
        }

        public ChartBoostBean getChartBoost() {
            return this.chartBoost;
        }

        public ChartBoostBean getChartBoost_amz() {
            return this.chartBoost_amz;
        }

        public FacebookAdsBean getFacebookAds() {
            return this.facebookAds;
        }

        public HouseAdsBean getHouse_ads() {
            return this.house_ads;
        }

        public IronSrcBean getIronsrc() {
            return this.ironsrc;
        }

        public long getLimitAdsTime() {
            return this.limitAdsTime;
        }

        public StartAppBean getStartApp() {
            return this.startApp;
        }

        public UnityAdsBean getUnity_ads() {
            return this.unity_ads;
        }

        public UnityAdsBean getUnity_ads_amz() {
            return this.unity_ads_amz;
        }

        public VungleBean getVungle() {
            return this.vungle;
        }

        public VungleBean getVungle_amz() {
            return this.vungle_amz;
        }

        public boolean isMute() {
            return this.mute;
        }

        public void setAdcolony(AdcolonyBean adcolonyBean) {
            this.adcolony = adcolonyBean;
        }

        public void setAdcolony_amz(AdcolonyBean adcolonyBean) {
            this.adcolony_amz = adcolonyBean;
        }

        public void setAdmob(AdmobBean admobBean) {
            this.admob = admobBean;
        }

        public void setApplovin(ApplovinBean applovinBean) {
            this.applovin = applovinBean;
        }

        public void setChartBoost(ChartBoostBean chartBoostBean) {
            this.chartBoost = chartBoostBean;
        }

        public void setChartBoost_amz(ChartBoostBean chartBoostBean) {
            this.chartBoost_amz = chartBoostBean;
        }

        public void setFacebookAds(FacebookAdsBean facebookAdsBean) {
            this.facebookAds = facebookAdsBean;
        }

        public void setHouse_ads(HouseAdsBean houseAdsBean) {
            this.house_ads = houseAdsBean;
        }

        public void setIronsrc(IronSrcBean ironSrcBean) {
            this.ironsrc = ironSrcBean;
        }

        public void setLimitAdsTime(long j2) {
            this.limitAdsTime = j2;
        }

        public void setMute(boolean z2) {
            this.mute = z2;
        }

        public void setStartApp(StartAppBean startAppBean) {
            this.startApp = startAppBean;
        }

        public void setUnity_ads(UnityAdsBean unityAdsBean) {
            this.unity_ads = unityAdsBean;
        }

        public void setVungle(VungleBean vungleBean) {
            this.vungle = vungleBean;
        }

        public void setVungle_amz(VungleBean vungleBean) {
            this.vungle_amz = vungleBean;
        }
    }

    public static class ForceBean {
        private String description;
        private String external_link;
        private boolean keep_current_version;
        private String package_name;

        public String getDescription() {
            return this.description;
        }

        public String getExternal_link() {
            return this.external_link;
        }

        public String getPackage_name() {
            return this.package_name;
        }

        public boolean isKeep_current_version() {
            return this.keep_current_version;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setExternal_link(String str) {
            this.external_link = str;
        }

        public void setKeep_current_version(boolean z2) {
            this.keep_current_version = z2;
        }

        public void setPackage_name(String str) {
            this.package_name = str;
        }
    }

    public static class NotificationBean {
        private int id;
        private String msg;
        private String title;

        public int getId() {
            return this.id;
        }

        public String getMsg() {
            return this.msg;
        }

        public String getTitle() {
            return this.title;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public static class PaymentMethod {
        private String name;
        private String url;

        public String getName() {
            return this.name;
        }

        public String getUrl() {
            return this.url;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public static class ProviderBean {
        private String list;
        private boolean sendbackWhenPlayed;
        private boolean sendbackWhenReslover;

        public String getList() {
            return this.list;
        }

        public boolean isSendbackWhenPlayed() {
            return this.sendbackWhenPlayed;
        }

        public boolean isSendbackWhenReslover() {
            return this.sendbackWhenReslover;
        }

        public void setList(String str) {
            this.list = str;
        }

        public void setSendbackWhenPlayed(boolean z2) {
            this.sendbackWhenPlayed = z2;
        }

        public void setSendbackWhenReslover(boolean z2) {
            this.sendbackWhenReslover = z2;
        }
    }

    public static class RdConfigBean {
        private String list;
        private String rd_client_id;

        public String getList() {
            return this.list;
        }

        public String getRd_client_id() {
            return this.rd_client_id;
        }

        public void setList(String str) {
            this.list = str;
        }

        public void setRd_client_id(String str) {
            this.rd_client_id = str;
        }
    }

    public static class ResloverBean {
        private String list;

        public String getList() {
            return this.list;
        }

        public void setList(String str) {
            this.list = str;
        }
    }

    public static class SyncBean {
        private boolean for_member_only;
        private int sync_rate;

        public int getSync_rate() {
            return this.sync_rate;
        }

        public boolean isFor_member_only() {
            return this.for_member_only;
        }

        public void setFor_member_only(boolean z2) {
            this.for_member_only = z2;
        }

        public void setSync_rate(int i2) {
            this.sync_rate = i2;
        }
    }

    public static class UpdateBean {
        private String description;
        private boolean forceUpdate;
        private String link;
        private String packagename;
        private int size;
        private int versionCode;

        public String getDescription() {
            return this.description;
        }

        public String getLink() {
            return this.link;
        }

        public String getPackagename() {
            return this.packagename;
        }

        public int getSize() {
            return this.size;
        }

        public int getVersionCode() {
            return this.versionCode;
        }

        public boolean isForceUpdate() {
            return this.forceUpdate;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setForceUpdate(boolean z2) {
            this.forceUpdate = z2;
        }

        public void setLink(String str) {
            this.link = str;
        }

        public void setPackagename(String str) {
            this.packagename = str;
        }

        public void setSize(int i2) {
            this.size = i2;
        }

        public void setVersionCode(int i2) {
            this.versionCode = i2;
        }
    }

    public AdsBean getAds() {
        return this.ads;
    }

    public List<String> getBlocks_package() {
        return this.blocks_package;
    }

    public Map<String, String> getCbflist() {
        return this.cbflist;
    }

    public String getCleaf_download_url() {
        return this.cleaf_download_url;
    }

    public String getDonate_url() {
        return this.donate_url;
    }

    public String getEvent_category() {
        return this.event_category;
    }

    public String getFanpage() {
        return this.fanpage;
    }

    public ForceBean getForce() {
        return this.force;
    }

    public List<Integer> getFringing_movie() {
        return this.fringing_movie;
    }

    public String getGithub_js() {
        return this.github_js;
    }

    public Map<String, String> getHdlist() {
        return this.hdlist;
    }

    public NotificationBean getNotification() {
        return this.notification2;
    }

    public String getOpensubtitle_user_agent() {
        return this.opensubtitle_user_agent;
    }

    public String getOs_type() {
        return this.os_type;
    }

    public List<PaymentMethod> getPayments() {
        return this.payments;
    }

    public List<?> getPromotions() {
        return this.promotions;
    }

    public ProviderBean getProvider() {
        return this.provider;
    }

    public RdConfigBean getRd_config() {
        return this.rd_config;
    }

    public ResloverBean getReslover() {
        return this.reslover;
    }

    public String getShare_url() {
        return this.share_url;
    }

    public String getSupport_email() {
        return this.support_email;
    }

    public SyncBean getSync() {
        return this.sync;
    }

    public List<String> getTmdb_api_keys() {
        return this.tmdb_api_keys;
    }

    public UpdateBean getUpdate() {
        return this.update;
    }

    public String getUser_agent() {
        return this.user_agent;
    }

    public void setAds(AdsBean adsBean) {
        this.ads = adsBean;
    }

    public void setBlocks_package(List<String> list) {
        this.blocks_package = list;
    }

    public void setCbflist(Map<String, String> map) {
        this.cbflist = map;
    }

    public void setCleaf_download_url(String str) {
        this.cleaf_download_url = str;
    }

    public void setDonate_url(String str) {
        this.donate_url = str;
    }

    public void setEvent_category(String str) {
        this.event_category = str;
    }

    public void setFanpage(String str) {
        this.fanpage = str;
    }

    public void setForce(ForceBean forceBean) {
        this.force = forceBean;
    }

    public void setFringing_movie(List<Integer> list) {
        this.fringing_movie = list;
    }

    public void setGithub_js(String str) {
        this.github_js = str;
    }

    public void setHdlist(Map<String, String> map) {
        this.hdlist = map;
    }

    public void setNotification(NotificationBean notificationBean) {
        this.notification2 = notificationBean;
    }

    public void setOpensubtitle_user_agent(String str) {
        this.opensubtitle_user_agent = str;
    }

    public void setOs_type(String str) {
        this.os_type = str;
    }

    public void setPayments(List<PaymentMethod> list) {
        this.payments = list;
    }

    public void setPromotions(List<?> list) {
        this.promotions = list;
    }

    public void setProvider(ProviderBean providerBean) {
        this.provider = providerBean;
    }

    public void setRd_config(RdConfigBean rdConfigBean) {
        this.rd_config = rdConfigBean;
    }

    public void setReslover(ResloverBean resloverBean) {
        this.reslover = resloverBean;
    }

    public void setShare_url(String str) {
        this.share_url = str;
    }

    public void setSupport_email(String str) {
        this.support_email = str;
    }

    public void setSync(SyncBean syncBean) {
        this.sync = syncBean;
    }

    public void setTmdb_api_keys(List<String> list) {
        this.tmdb_api_keys = list;
    }

    public void setUpdate(UpdateBean updateBean) {
        this.update = updateBean;
    }

    public void setUser_agent(String str) {
        this.user_agent = str;
    }
}
