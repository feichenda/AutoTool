package com.ktc.autocompiler.constants;

import com.ktc.autocompiler.utils.Tools;

/**
 * @Author feizai
 * @Date 2021年10月26日 0026  下午 09:37:22
 * @Explain
 */
public class Config {
    /*界面显示内容的变量*/
    public static int mTVProject = -1;                                //方案
    public static String mServerIP = "";                            //服务器IP
    public static String mUserID = "";                                //服务器用户账号
    public static String mUserPassword = "";                        //服务器用户密码
    public static String mSDA = "";                                    //软件SDA单号
    public static String mPanelType = "";                            //屏型号
    public static String mManufacturerName = "";                    //厂商代码
    public static String mProductCode = "";                            //产品代码
    public static String mMonitorName = "";                            //厂商代码
    public static String mSWVersion = "";                            //厂商代码
    public static String mCustomer = "";                            //device名称
    public static String mCountry = "";                               //时区国家
    public static String mLanguage = "";                              //默认语言
    public static String mDvbCountry = "";                            //默认搜台国家
    public static String mBackLight = "";                             //默认背光
    public static String mPhilipsAQVersion = "";                    //AQ版本
    public static String mPhilipsPQVersion = "";                    //PQ版本
    public static String mPhilipsSWVersion = "";                    //SW版本
    public static String mPhilipsOC = "";                            //OC型号
    public static String mFilePath = "";                            //复制的文件路径
    public static String mCodePath = "";                            //代码路径
    public static boolean isNeedChangeOADPanel = false;                //是否需要更改屏参列表
    public static int mBoardType = -1;
    
    /*界面显示的内容*/
    public static final String SERVER_IP = "你的服务器IP: ";
    public static final String SERVER_IP_VAL = "192.168.47.93";
    public static final String USER_ID = "你的服务器用户名: ";
    public static final String USER_ID_VAL = "laiyw";
    public static final String USER_PASSWORD = "你的服务器密码: ";
    public static final String USER_PASSWORD_VAL = "****";
    public static final String SDA = "你的SDA单号: ";
    public static final String SDA_VAL = "SDA00000000";
    public static final String PANEL_TYPE = "你的屏型号: ";
    public static final String PANEL_TYPE_VAL = "K490WDC1/C2_LT300A1";
    public static final String MANUFACTURE_NAME = "你的厂商代码(Manufacturer_Name): ";
    public static final String MANUFACTURE_NAME_VAL = "SKG";
    public static final String PRODUCT_CODE = "你的产品代码(Product_Code): ";
    public static final String PRODUCT_CODE_VAL = "4900";
    public static final String MONITOR_NAME = "你的显示器名称(Monitor_Name): ";
    public static final String MONITOR_NAME_VAL = "49'TV";
    public static final String SW_VERSION = "你的软件版本(SOFTWARE_VERSION): ";
    public static final String CUSTOMER = "选择你的device名称: ";
    public static final String COUNTRY_DEF = "时区国家(勾选修改)：";
    public static final String COUNTRY_DEF_VAL = "Europe/Berlin";
    public static final String LANGUAGE_DEF = "默认语言(勾选修改)：";
    public static final String DVBCOUNTRY_DEF = "搜台国家(勾选修改)：";
    public static final String BACKLIGHT_DEF = "背光能效(勾选修改)：";
    public static final String DVBCOUNTRY_DEF_VAL = "deu";
    public static final String LANGUAGE_DEF_VAL = "en_US";
    public static final String CUSTOMER_VAL = "m5621_kgzn";
    public static final String PHILIPS_AQ_VERSION = "你的飞利浦AQ版本(PHILIPS_AQ_VERSION): ";
    public static final String PHILIPS_AQ_VERSION_VAL = "638DT.0(选填)";
    public static final String PHILIPS_PQ_VERSION = "你的飞利浦PQ版本(PHILIPS_PQ_VERSION): ";
    public static final String PHILIPS_PQ_VERSION_VAL = "V.0(选填)";
    public static final String PHILIPS_SW_VERSION = "你的飞利浦SW版本(PHILIPS_PQ_VERSION): ";
    public static final String PHILIPS_SW_VERSION_VAL = "V1.0.0(选填)";
    public static final String PHILIPS_OC = "你的飞利浦OC(PHILIPS_OC): ";
    public static final String PHILIPS_OC_VAL = "LC550EQY-FJA2(选填)";
    public static final String[] TV_PROJECTS = {"338", "338_PHILIPS", "348_ISDB", "348_DTMB", "348_DVB",
            "358_ATSC", "358_DVB", "358_DTMB", "358_ISDB", "638_DVB", "638_DVB_TAIWAN_COLOMBIA", "638_DTMB",
            "648", "6586_ATSC", "6586_DVB", "6586_ISDB", "658_DVB", "838", "848", "9632", "6681"};
    public static final String[] TV_BOARDS = {"M2C1", "M3C1", "M6C1"};
    //各个方案代号需要新加的方案依次加在后面，并同时修改static代码块里面、加入switch判断
    public static final int TV338 = 0;
    public static final int TV338_PHILIPS = 1;
    public static final int TV348_ISDB = 2;
    public static final int TV348_DTMB = 3;
    public static final int TV348_DVB = 4;
    public static final int TV358_ATSC = 5;
    public static final int TV358_DVB = 6;
    public static final int TV358_DTMB = 7;
    public static final int TV358_ISDB = 8;
    public static final int TV638_DVB = 9;
    public static final int TV638_DVB_TAIWAN_COLOMBIA = 10;
    public static final int TV638_DTMB = 11;
    public static final int TV648 = 12;
    public static final int TV6586_ATSC = 13;
    public static final int TV6586_DVB = 14;
    public static final int TV6586_ISDB = 15;
    public static final int TV658_DVB = 16;
    public static final int TV838 = 17;
    public static final int TV848 = 18;
    public static final int TV9632 = 19;
    public static final int TV6681 = 20;

    //文件路径
    public static String PANEL_INDEX_PATH_TEMP = "";
    public static String PANEL_INDEX_PATH = "";
    public static String RESET_SERVICE = "";
    public static String RESET_SERVICE_TEMP = "";
    public static String NLA_backup_PATH = "";
    public static String NLA_PATH = "";
    public static String OsdMapping_backup_PATH = "";
    public static String OsdMapping_PATH = "";
    public static String CH_DIRECTORY = "";
    public static String PQ_BASE = "";
    public static String CH_FILE = "";
    public static String PQ_PATH1 = "";
    public static String PQ_PATH2 = "";
    public static String PQ_PATH3 = "";
    public static String PQ_PATH4 = "";
    public static String PQ_PATH5 = "";
    public static String PQ_PATH6 = "";
    public static String PQ_PATH7 = "";
    public static String CUSTOMER_INI_PATH = "";
    public static String CUSTOMER_INI_TEMP = "";
    public static String CUSTOMER_INI_M2C1_PATH = "";
    public static String CUSTOMER_INI_M2C1_TEMP = "";
    public static String CUSTOMER_INI_M3C1_PATH = "";
    public static String CUSTOMER_INI_M3C1_TEMP = "";
    public static String CUSTOMER_INI_M6C1_PATH = "";
    public static String CUSTOMER_INI_M6C1_TEMP = "";
    public static String PANEL_BACKUP_PATH = "";
    public static String LOGO_PATH = "";
    public static String PANEL_PATH = "";
    public static String COLOR_MATRIX_PATH = "";
    public static String DLC_PATH = "";
    public static String OAD_PATH = "";
    public static String OAD_PATH_TEMP = "";
    public static String COMMON_FEATURE_PATH = "";
    public static String FACTORY_DB_PATH = "";
    public static String USER_DB_PATH = "";
    public static String DEVICE_PATH = "";
    public static String ACFG_DVB_PATH = "";
    public static String HELPACTIVITY_PATH = "";
    public static String TvInput_PATH = "";
    public static String ARRAY_PATH = "";
    public static String Config_PATH = "";
    public static String[] sqlTestUSR = {""};        // 需要在user数据库执行的命令数组
    public static String[] sqlTestFAC = {""};        // 需要在factory数据库执行的命令数组 不需要时置为空
    public static boolean LANGUAGE_CHECK = false;
    public static boolean COUNTRY_CHECK = false;
    public static boolean DVBCOUNTRY_CHECK = false;
    public static boolean BACKLIGHT_CHECK = false;
    public static boolean BLUETOOTH_CHECK = false;
    public static boolean HELP_CHECK = false;
    public static boolean DVBC_CHECK = false;
    public static boolean DVBS_CHECK = false;
    public static boolean VGA_CHECK = false;
    public static boolean HOTEL_CHECK = false;

    // 初始化路径，必须执行
    public static void initPath() {
        DEVICE_PATH = "";
        ACFG_DVB_PATH = "";
        HELPACTIVITY_PATH = "";
        TvInput_PATH = "";
        ARRAY_PATH = "";
        Config_PATH = "";
        COLOR_MATRIX_PATH = mCodePath + "\\projects\\board\\INI\\ColorMatrix\\ColorMatrix.ini";
        DLC_PATH = mCodePath + "\\projects\\board\\INI\\DLC\\";
        LOGO_PATH = mCodePath + "\\projects\\board\\INI\\misc\\boot0.jpg";
        PANEL_PATH = mCodePath + "\\projects\\board\\INI\\panel\\";
        OAD_PATH = mCodePath + "\\projects\\systeminfo\\src\\SystemInfo.cpp";
        OAD_PATH_TEMP = mCodePath + "\\projects\\systeminfo\\src\\SystemInfo_temp.cpp";
        COMMON_FEATURE_PATH = Tools.parseString(mCodePath, "\\\\", "/")
                + "projects/config/sw_cfg/common_feature/common_feature.mk";
        FACTORY_DB_PATH = mCodePath + "\\projects\\board\\INI\\misc\\factory.db";
        USER_DB_PATH = mCodePath + "\\projects\\board\\INI\\misc\\user_setting.db";

        switch (mTVProject) {
            case TV338:
                CH_DIRECTORY = "Messi";
                PQ_BASE = "\\projects\\board\\messi\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\messi_sz\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\messi_sz\\Main_Text.bin";
                PQ_PATH3 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\messi_sz\\Main_Color.bin";
                PQ_PATH4 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\messi_sz\\Main_Color_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\messi\\MST091B_10ASXG_TVOS_DTMB\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\messi\\MST091B_10ASXG_TVOS_DTMB\\model\\Customer_1_temp.ini";
                break;
            case TV338_PHILIPS:
                CH_DIRECTORY = "Messi";
                PQ_BASE = "\\projects\\board\\messi\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\messi_sz\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\messi_sz\\Main_Text.bin";
                PQ_PATH3 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\messi_sz\\Main_Color.bin";
                PQ_PATH4 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\messi_sz\\Main_Color_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\messi\\MST091B_10ASXG_TVOS_DTMB\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\messi\\MST091B_10ASXG_TVOS_DTMB\\model\\Customer_1_temp.ini";
                break;
            case TV348_ISDB:
                CH_DIRECTORY = "Mainz";
                PQ_BASE = "\\projects\\board\\mainz\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\default\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST126B_10AXO_16395_TVOS_ISDB\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST126B_10AXO_16395_TVOS_ISDB\\model\\Customer_1_temp.ini";
                break;
            case TV348_DTMB:
                CH_DIRECTORY = "Mainz";
                PQ_BASE = "\\projects\\board\\mainz\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\default\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST125B_10AAT_16341_DTMB\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST125B_10AAT_16341_DTMB\\model\\Customer_1_temp.ini";
                break;
            case TV348_DVB:
                CH_DIRECTORY = "Mainz";
                PQ_BASE = "\\projects\\board\\mainz\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\default\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST126B_10AXO_16395_TVOS_DVB\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST126B_10AXO_16395_TVOS_DVB\\model\\Customer_1_temp.ini";
                break;
            case TV358_ATSC:
                CH_DIRECTORY = "Mainz";
                PQ_BASE = "\\projects\\board\\mainz\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\sz\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\sz\\Main_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST142B_10AATOG_17455_TVOS_ATSC_202\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST142B_10AATOG_17455_TVOS_ATSC_202\\model\\Customer_1_temp.ini";
                break;
            case TV358_DVB:
                CH_DIRECTORY = "Mainz";
                PQ_BASE = "\\projects\\board\\mainz\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\sz\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\sz\\Main_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST142B_10AATOG_17455_TVOS_DVB_202\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST142B_10AATOG_17455_TVOS_DVB_202\\model\\Customer_1_temp.ini";
                break;
            case TV358_DTMB:
                CH_DIRECTORY = "Mainz";
                PQ_BASE = "\\projects\\board\\mainz\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\sz\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\sz\\Main_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST142B_10AATOG_17455_TVOS_DTMB_202\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST142B_10AATOG_17455_TVOS_DTMB_202\\model\\Customer_1_temp.ini";
                break;
            case TV358_ISDB:
                CH_DIRECTORY = "Mainz";
                PQ_BASE = "\\projects\\board\\mainz\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\sz\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\sz\\Main_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST142B_10AATOG_17455_TVOS_ISDB_202\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\mainz\\serials\\MST142B_10AATOG_17455_TVOS_ISDB_202\\model\\Customer_1_temp.ini";
                break;
            case TV638_DVB:
                CH_DIRECTORY = "Monet";
                PQ_BASE = "\\projects\\board\\monet\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\monet_sz\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\monet_sz\\Main_Text.bin";
                PQ_PATH3 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\monet_sz\\Main_Color.bin";
                PQ_PATH4 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\monet_sz\\Main_Color_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\monet\\MST087B_10AJSM_15213_TVOS_ES_ASIA\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\monet\\MST087B_10AJSM_15213_TVOS_ES_ASIA\\model\\Customer_1_temp.ini";
                break;
            case TV638_DVB_TAIWAN_COLOMBIA:
                CH_DIRECTORY = "Monet";
                PQ_BASE = "\\projects\\board\\monet\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\monet_sz\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\monet_sz\\Main_Text.bin";
                PQ_PATH3 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\monet_sz\\Main_Color.bin";
                PQ_PATH4 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\monet_sz\\Main_Color_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\monet\\MST087B_10AJSM_15213_TVOS_ES_ASIA_NTSC_ATV\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\monet\\MST087B_10AJSM_15213_TVOS_ES_ASIA_NTSC_ATV\\model\\Customer_1_temp.ini";
                break;
            case TV638_DTMB:
                CH_DIRECTORY = "Monet";
                PQ_BASE = "\\projects\\board\\monet\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\monet_sz\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\monet_sz\\Main_Text.bin";
                PQ_PATH3 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\monet_sz\\Main_Color.bin";
                PQ_PATH4 = mCodePath + PQ_BASE + "PQ_BIN\\NONE_DEFAULT_PQ_BIN\\monet_sz\\Main_Color_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\monet\\MST087B_10AJSM_15213_TVOS\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\monet\\MST087B_10AJSM_15213_TVOS\\model\\Customer_1_temp.ini";
                break;
            case TV648:
                CH_DIRECTORY = "Mooney";
                PQ_BASE = "\\projects\\board\\mooney\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\default\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\mooney\\serials\\MST117B_10AWT_16323_TVOS_DTMB\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\mooney\\serials\\MST117B_10AWT_16323_TVOS_DTMB\\model\\Customer_1_temp.ini";
                break;
            case TV6586_ATSC:
                CH_DIRECTORY = "Macan";
                PQ_BASE = "\\projects\\board\\macan\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\default\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\macan\\serials\\MST104B_10APYE_16062_TVOS_ATSC\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\macan\\serials\\MST104B_10APYE_16062_TVOS_ATSC\\model\\Customer_1_temp.ini";
                break;
            case TV6586_DVB:
                CH_DIRECTORY = "Macan";
                PQ_BASE = "\\projects\\board\\macan\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\default\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\macan\\serials\\MST104B_10APYE_16062_TVOS_DVB\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\macan\\serials\\MST104B_10APYE_16062_TVOS_DVB\\model\\Customer_1_temp.ini";
                break;
            case TV6586_ISDB:
                CH_DIRECTORY = "Macan";
                PQ_BASE = "\\projects\\board\\macan\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\default\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\macan\\serials\\MST104B_10APYE_16062_TVOS_ISDB\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\macan\\serials\\MST104B_10APYE_16062_TVOS_ISDB\\model\\Customer_1_temp.ini";
                break;
            case TV658_DVB:
                CH_DIRECTORY = "mooney";
                PQ_BASE = "\\projects\\board\\mooney\\";
                CH_FILE = mCodePath + PQ_BASE + "pq\\lib_cus\\hal_sz\\include\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\default\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\mooney\\serials\\MST142B_10AATOG_17475_TVOS_DVBT\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\mooney\\serials\\MST142B_10AATOG_17475_TVOS_DVBT\\model\\Customer_1_temp.ini";
                break;
            case TV838:
                CH_DIRECTORY = "Maxim";
                PQ_BASE = "\\projects\\board\\maxim\\";
                CH_FILE = mCodePath + PQ_BASE + "pq\\lib_cus\\hal\\include\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\default\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_Text.bin";
                CUSTOMER_INI_PATH = mCodePath
                        + "\\projects\\board\\maxim\\serials\\MST107B_10AUVC_16142_TVOS_DTMB\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\maxim\\serials\\MST107B_10AUVC_16142_TVOS_DTMB\\model\\Customer_1_temp.ini";
                break;
            case TV848:
                CH_DIRECTORY = "m7221";
                PQ_BASE = "\\projects\\board\\m7221\\";
                CH_FILE = mCodePath + PQ_BASE + "pq\\lib_cus\\hal\\include\\";
                PQ_PATH1 = mCodePath + PQ_BASE + "pq_bin\\default\\Main.bin";
                PQ_PATH2 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_Text.bin";
                PQ_PATH3 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_Color.bin";
                PQ_PATH4 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_Color_Text.bin";
                PQ_PATH5 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_TMO.bin";
                PQ_PATH6 = mCodePath + PQ_BASE + "pq_bin\\default\\Main_TMO_Text.bin";
                PQ_PATH7 = mCodePath + PQ_BASE + "pq_bin\\default\\HSY.bin";
                //\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\m7332\\linux\\board_cfg\\BD_MT165B_10AT_19055_4K\\model\\Customer_1.ini
                CUSTOMER_INI_PATH = mCodePath
                        + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\m7332\\linux\\board_cfg\\BD_MT165B_10AT_19055_4K\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\projects\\board\\m7221\\serials\\MST140B_10ABQM_17425_DTMB\\model\\Customer_1_temp.ini";
                break;
            case TV9632:
			/*CH_DIRECTORY = "m7221";
			PQ_BASE = "\\projects\\board\\m7221\\";
			CH_FILE = mCodePath + PQ_BASE + "pq\\lib_cus\\hal\\include\\";*/
                //\vendor\mediatek\proprietary_tv\apollo\mtk_obj\mediatek\m7332_ktc\rel\misdk\mi\preinstall\m7332\linux\config\pq\
                //vendor\mediatek\proprietary_tv\apollo\linux_core\misdk\mi\mi\platform\common\ini\main\misc\boot0.jpg
                //vendor\mediatek\proprietary_tv\apollo\linux_core\misdk\mi\mi\platform\common\ini\main\panel\backup\
                //vendor\mediatek\proprietary_tv\apollo\sys_build\mediatek\common\m7332_eu\data\tvconfig\PQ_general\backup\OsdMapping.ini
                //vendor\mediatek\proprietary_tv\apollo\linux_core\misdk\mi\mi\platform\common\ini\main\PQ_general\backup\
                //\vendor\mediatek\proprietary_tv\apollo\linux_core\misdk\mi\mi\platform\common\ini\main\DLC\DLC.ini
                //\vendor\mediatek\proprietary_tv\apollo\linux_core\misdk\mi\mi\platform\common\ini\main\ColorMatrix\ColorMatrix.ini
                //\external\reset_service\reset_service.c
                //\external\reset_service\reset_service.c
                //\vendor\mediatek\proprietary_tv\apollo\linux_core\misdk\mi\mi\platform\common\ini\main\panel\Panel_index.ini
                PANEL_INDEX_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\panel\\Panel_index.ini";
                PANEL_INDEX_PATH_TEMP = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\panel\\Panel_index_temp.ini";
                RESET_SERVICE_TEMP = mCodePath + "\\external\\reset_service\\reset_service_temp.c";
                RESET_SERVICE = mCodePath + "\\external\\reset_service\\reset_service.c";
                COLOR_MATRIX_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\ColorMatrix\\ColorMatrix.ini";
                DLC_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\DLC\\DLC.ini";
                NLA_backup_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\PQ_general\\backup\\NLA.ini";
                NLA_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\PQ_general\\NLA.ini";
                OsdMapping_backup_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\sys_build\\mediatek\\common\\m7332_eu\\data\\tvconfig\\PQ_general\\backup\\OsdMapping.ini";
                OsdMapping_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\sys_build\\mediatek\\common\\m7332_eu\\data\\tvconfig\\PQ_general\\OsdMapping.ini";
                PANEL_BACKUP_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\panel\\backup\\";
                PANEL_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\panel\\";
                COLOR_MATRIX_PATH = mCodePath + "\\projects\\board\\INI\\ColorMatrix\\ColorMatrix.ini";
                DLC_PATH = mCodePath + "\\projects\\board\\INI\\DLC\\";
                LOGO_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\misc\\boot0.jpg";
                PQ_PATH2 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\m7332_ktc\\rel\\misdk\\mi\\preinstall\\m7332\\linux\\config\\pq\\Main.bin";
                PQ_PATH3 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\m7332_ktc\\rel\\misdk\\mi\\preinstall\\m7332\\linux\\config\\pq\\Main_Color.bin";
                PQ_PATH4 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\m7332_ktc\\rel\\misdk\\mi\\preinstall\\m7332\\linux\\config\\pq\\Main_Color_Text.bin";
                PQ_PATH5 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\m7332_ktc\\rel\\misdk\\mi\\preinstall\\m7332\\linux\\config\\pq\\Main_Text.bin";
                PQ_PATH6 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\m7332_ktc\\rel\\misdk\\mi\\preinstall\\m7332\\linux\\config\\pq\\Main_TMO.bin";
                PQ_PATH7 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\m7332_ktc\\rel\\misdk\\mi\\preinstall\\m7332\\linux\\config\\pq\\Main_TMO_Text.bin";
                //修改屏参ini文件
                CUSTOMER_INI_PATH = mCodePath
                        + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\m7332\\linux\\board_cfg\\BD_MT165B_10AT_19055_4K\\model\\Customer_1.ini";
                CUSTOMER_INI_TEMP = mCodePath
                        + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\m7332\\linux\\board_cfg\\BD_MT165B_10AT_19055_4K\\model\\Customer_1_temp.ini";
                break;

            case TV6681:
                PANEL_INDEX_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\panel\\Panel_index.ini";
                PANEL_INDEX_PATH_TEMP = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\panel\\Panel_index_temp.ini";
                RESET_SERVICE_TEMP = mCodePath + "\\external\\reset_service\\reset_service_temp.c";
                RESET_SERVICE = mCodePath + "\\external\\reset_service\\reset_service.c";
                COLOR_MATRIX_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\ColorMatrix\\ColorMatrix.ini";
                DLC_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\DLC\\DLC.ini";
                NLA_backup_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\PQ_general\\backup\\NLA.ini";
                NLA_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\PQ_general\\NLA.ini";
                OsdMapping_backup_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\sys_build\\mediatek\\common\\m5621\\data\\tvconfig\\PQ_general\\backup\\OsdMapping.ini";
                OsdMapping_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\sys_build\\mediatek\\common\\m5621\\data\\tvconfig\\PQ_general\\OsdMapping.ini";
                PANEL_BACKUP_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\panel\\backup\\";
                PANEL_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\panel\\";
                COLOR_MATRIX_PATH = mCodePath + "\\projects\\board\\INI\\ColorMatrix\\ColorMatrix.ini";
                DLC_PATH = mCodePath + "\\projects\\board\\INI\\DLC\\";
                LOGO_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\common\\ini\\main\\misc\\boot0.jpg";
                PQ_PATH1 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\" + mCustomer + "\\rel\\misdk\\mi\\preinstall\\m5621\\linux\\config\\pq\\HSY.bin";//pq 这个路径需要修改
                PQ_PATH2 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\" + mCustomer + "\\rel\\misdk\\mi\\preinstall\\m5621\\linux\\config\\pq\\Main.bin";
                PQ_PATH3 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\" + mCustomer + "\\rel\\misdk\\mi\\preinstall\\m5621\\linux\\config\\pq\\Main_Color.bin";
                PQ_PATH4 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\" + mCustomer + "\\rel\\misdk\\mi\\preinstall\\m5621\\linux\\config\\pq\\Main_Color_Text.bin";
                PQ_PATH5 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\" + mCustomer + "\\rel\\misdk\\mi\\preinstall\\m5621\\linux\\config\\pq\\Main_Text.bin";
                PQ_PATH6 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\" + mCustomer + "\\rel\\misdk\\mi\\preinstall\\m5621\\linux\\config\\pq\\Main_TMO.bin";
                PQ_PATH7 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\" + mCustomer + "\\rel\\misdk\\mi\\preinstall\\m5621\\linux\\config\\pq\\Main_TMO_Text.bin";
                //M2C1修改屏参ini文件
                CUSTOMER_INI_M2C1_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\m5621\\linux\\board_cfg\\BD_MST151B_10ABQHAT_18151\\model\\Customer_1.ini";
                CUSTOMER_INI_M2C1_TEMP = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\m5621\\linux\\board_cfg\\BD_MST151B_10ABQHAT_18151\\model\\Customer_1_temp.ini";
                //M3C1修改屏参ini文件
                CUSTOMER_INI_M3C1_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\m5621\\linux\\board_cfg\\BD_MST151B_10ABQHAT_18151_M3C1\\model\\Customer_1.ini";
                CUSTOMER_INI_M3C1_TEMP = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\m5621\\linux\\board_cfg\\BD_MST151B_10ABQHAT_18151_M3C1\\model\\Customer_1_temp.ini";
                //M6C1修改屏参ini文件
                CUSTOMER_INI_M6C1_TEMP = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\m5621\\linux\\board_cfg\\BD_MST151B_10ABQHAT_18151_M6C1\\model\\Customer_1_temp.ini";
                CUSTOMER_INI_M6C1_PATH = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\linux_core\\misdk\\mi\\mi\\platform\\m5621\\linux\\board_cfg\\BD_MST151B_10ABQHAT_18151_M6C1\\model\\Customer_1.ini";
                if (mBoardType == 0) {
                    Config.CUSTOMER_INI_PATH = Config.CUSTOMER_INI_M2C1_PATH;
                    Config.CUSTOMER_INI_TEMP = Config.CUSTOMER_INI_M2C1_TEMP;
                } else if (mBoardType == 1) {
                    Config.CUSTOMER_INI_PATH = Config.CUSTOMER_INI_M3C1_PATH;
                    Config.CUSTOMER_INI_TEMP = Config.CUSTOMER_INI_M3C1_TEMP;
                } else if (mBoardType == 2) {
                    Config.CUSTOMER_INI_PATH = Config.CUSTOMER_INI_M6C1_PATH;
                    Config.CUSTOMER_INI_TEMP = Config.CUSTOMER_INI_M6C1_TEMP;
                }
                DEVICE_PATH = Tools.parseString(mCodePath, "\\\\", "/") + "device/mediatek/" + mCustomer;
                ACFG_DVB_PATH = Tools.parseString(mCodePath, "\\\\", "/") + "vendor/mediatek/proprietary_tv/apollo/custom/dev/app_util/config/";
                HELPACTIVITY_PATH = Tools.parseString(mCodePath, "\\\\", "/") + "device/mediatek/" + mCustomer + "/common/apps/sys_app/need_signed/32";
                TvInput_PATH = Tools.parseString(mCodePath, "\\\\", "/") + "device/mediatek/" + mCustomer + "/KgznConfig/TvInputSource";
                ARRAY_PATH = Tools.parseString(mCodePath, "\\\\", "/") + "device/mediatek/" + mCustomer + "/common/apps/KgznTvplayer/res/values";
                Config_PATH = Tools.parseString(mCodePath, "\\\\", "/") + "vendor/mediatek/proprietary_tv/apollo/sys_build/mediatek/common/m5621/data/tvconfig";
                break;
            default:
                break;
        }
    }
}
