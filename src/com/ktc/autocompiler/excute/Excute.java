package com.ktc.autocompiler.excute;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ktc.autocompiler.constants.Config;
import com.ktc.autocompiler.utils.ExcuteLinuxCmd;
import com.ktc.autocompiler.utils.LogUtil;
import com.ktc.autocompiler.utils.Tools;
import com.sun.swing.internal.plaf.metal.resources.metal;

import sun.java2d.d3d.D3DGraphicsDevice;

/**
 * @Author feizai
 * @Date 2021年10月26日 0026  下午 09:43:07
 * @Explain
 */
public class Excute {
    public static String LINUX_CMD_SED = "sed -i \"s/" + Config.mCustomer + " = 0/" + Config.mCustomer + " = 1/g\" ";
    public static String CMD = LINUX_CMD_SED + Config.COMMON_FEATURE_PATH;
    public static String DB_PATH = "D:\\db_temp\\db_" + Tools.getRandomString(4) + "\\";

    private ArrayList<File> allFiles;
    private LogUtil log;

    public Excute(LogUtil log) {
        this.log = log;
    }

    private String pq_name = "";

    public void execute() throws IOException, ClassNotFoundException, SQLException, FileNotFoundException {
        allFiles = new ArrayList<>();
        allFiles = getAllFileList(Config.mFilePath);
		/*
		 * PQ_PATH1 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\m7332_ktc\\rel\\misdk\\mi\\preinstall\\m7332\\linux\\config\\pq\\HSY.bin";
			PQ_PATH2 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\m7332_ktc\\rel\\misdk\\mi\\preinstall\\m7332\\linux\\config\\pq\\Main.bin";
			PQ_PATH3 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\m7332_ktc\\rel\\misdk\\mi\\preinstall\\m7332\\linux\\config\\pq\\Main_Ex.bin";
			PQ_PATH4 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\m7332_ktc\\rel\\misdk\\mi\\preinstall\\m7332\\linux\\config\\pq\\Main_Ex_Text.bin";
			PQ_PATH5 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\m7332_ktc\\rel\\misdk\\mi\\preinstall\\m7332\\linux\\config\\pq\\Main_Text.bin";
			PQ_PATH6 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\m7332_ktc\\rel\\misdk\\mi\\preinstall\\m7332\\linux\\config\\pq\\Main_TMO.bin";
			PQ_PATH7 = mCodePath + "\\vendor\\mediatek\\proprietary_tv\\apollo\\mtk_obj\\mediatek\\m7332_ktc\\rel\\misdk\\mi\\preinstall\\m7332\\linux\\config\\pq\\Main_TMO_Text.bin";
		 * RESET_SERVICE_TEMP
		 */

        for (File file : allFiles) {
            if (file.getName().equals("boot0.jpg")) {
                copyFile(file, Config.LOGO_PATH);
            } else if (file.getName().equals("ColorMatrix.ini")) {
                copyFile(file, Config.COLOR_MATRIX_PATH);
            } else if (file.getName().equals("DLC.ini")) {
                modifyDLCFile(file);
            } else if (file.getName().equals("HSY.bin")) {
                copyFile(file, Config.PQ_PATH1);
            } else if (file.getName().equals("Main.bin")) {
                copyFile(file, Config.PQ_PATH2);
            } else if (file.getName().equals("Main_Color.bin")) {
                copyFile(file, Config.PQ_PATH3);
            } else if (file.getName().equals("Main_Color_Text.bin")) {
                copyFile(file, Config.PQ_PATH4);
            } else if (file.getName().equals("Main_Ex.bin")) {
                copyFile(file, Config.PQ_PATH3);
            } else if (file.getName().equals("Main_Ex_Text.bin")) {
                copyFile(file, Config.PQ_PATH4);
            } else if (file.getName().equals("Main_Text.bin")) {
                copyFile(file, Config.PQ_PATH5);
            } else if (file.getName().equals("Main_TMO.bin")) {
                copyFile(file, Config.PQ_PATH6);
            } else if (file.getName().equals("Main_TMO_Text.bin")) {
                copyFile(file, Config.PQ_PATH7);
            }/* else if (file.getName().equals(Config.CH_DIRECTORY)) {
				copyCHFile(file);
			}*///屏参ini文件
            else if (file.getName().toUpperCase().startsWith("K")
                    && file.getName().toLowerCase().endsWith(".ini")) {
                pq_name = file.getName();
                copyFile(file, Config.PANEL_PATH + file.getName());
                copyFile(file, Config.PANEL_BACKUP_PATH + file.getName());
                System.out.println(Config.CUSTOMER_INI_PATH);
                modifyFile(file, Config.CUSTOMER_INI_PATH, Config.CUSTOMER_INI_TEMP);
                modifyFile(file, Config.RESET_SERVICE, Config.RESET_SERVICE_TEMP);
                //modifyFile(file, Config.PANEL_INDEX_PATH, Config.PANEL_INDEX_PATH_TEMP);
                if (Config.isNeedChangeOADPanel) {
                    modifyFile(file, Config.OAD_PATH, Config.OAD_PATH_TEMP);
                }
            }//OsdMapping.ini
            else if (file.getName().equals("OsdMapping.ini")) {
                copyFile(file, Config.OsdMapping_PATH);
                copyFile(file, Config.OsdMapping_backup_PATH);
            }//NLA.ini
            else if (file.getName().toUpperCase().startsWith("N")
                    && file.getName().toLowerCase().endsWith(".ini")) {
                copyFile(file, Config.NLA_PATH);
                copyFile(file, Config.NLA_backup_PATH);
            }
        }
        if (Config.DEVICE_PATH.length() != 0 && (Config.COUNTRY_CHECK || Config.LANGUAGE_CHECK || Config.BLUETOOTH_CHECK || Config.DVBS_CHECK || Config.HOTEL_CHECK)) {
            modifyDevice();
        }
        if (Config.ACFG_DVB_PATH.length() != 0 && Config.DVBCOUNTRY_CHECK) {
            modifyAcfgDvb();
        }
        if (Config.Config_PATH.length() != 0 && Config.BACKLIGHT_CHECK) {
            updateBackLight();
        }
        if (Config.HELPACTIVITY_PATH.length() != 0 && Config.HELP_CHECK) {
            removeHelpActivity();
        }
        if (Config.ARRAY_PATH.length() != 0 && Config.DVBC_CHECK) {
            removeDVBC();
        }
        if (Config.TvInput_PATH.length() != 0 && Config.VGA_CHECK) {
            addVga();
        }
        //客户宏修改
        //modifyCommonFeature();
        //数据库修改
        //initDBDirectory(DB_PATH); -----------cph
        //copyDBFileAndExecute(); ----------cph
        //ArrayList<File> dbFiles = getAllFileList(DB_PATH);
		/*for (File file : dbFiles) {
			if (file.getName().equals("factory.db")) {
				copyFile(file,Config.FACTORY_DB_PATH);
			} else if (file.getName().equals("user_setting.db")) {
				copyFile(file,Config.USER_DB_PATH);
			}
		}*/
    }

    /*
     * 获取某路径下所有文件
     */
    private ArrayList<File> getAllFileList(String path) {
        File file = new File(path);
        if(file.exists()) {
	        File[] files = file.listFiles();
	        ArrayList<File> fileArrayList = new ArrayList<>();
	        for (int i = 0; i < files.length; i++) {
	            fileArrayList.add(files[i]);
	            System.out.println("file name : " + files[i].getName());
	        }
	        return fileArrayList;
        }else{
        	return new ArrayList<>();
        }
    }

    /*
     * 复制文件
     */
    private void copyFile(File localFile, String codePath) throws IOException {
        log.d("", "正在复制 " + localFile.getName() + " 文件...");
        log.d("", localFile.getName() + " 文件路径：" + codePath);
        File codeFile = new File(codePath);
        Files.copy(localFile.toPath(), codeFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    /*
     * 复制.c .h文件 (新方案才需要)
     */
    private void copyCHFile(File localFile) throws IOException {
        if (localFile.isDirectory()) {
            File[] files = localFile.listFiles();
            for (File f : files) {
                if (f.getName().endsWith(".c") || f.getName().endsWith(".h")) {
                    System.out.println(f.getName());
                    copyFile(f, Config.CH_FILE + f.getName());
                }
            }
        }
    }

    /*
     * 修改文件内容，比如Customer_1.ini文件,需要修改Config里面的配置
     */
    private void modifyFile(File localFile, String path, String tempPath) throws IOException {
        String[] strs = path.split("\\\\");
        log.d("", "正在修改 " + strs[strs.length - 1] + " 文件...");
        log.d("", strs[strs.length - 1] + " 文件路径：" + path);
        boolean isHasOAD = false;
        BufferedReader bf = null;
        PrintWriter pw = null;
        File customer = new File(path);
        File temp = new File(tempPath);
        try {
            bf = new BufferedReader(new FileReader(customer));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(temp)));
            String line;
            while ((line = bf.readLine()) != null) {
                if (path.equals(Config.CUSTOMER_INI_PATH)) {
                    //Customer_1.ini文件
                    if (line.contains("PRODUCT_SDA_NO") && !Config.mSDA.equals("")) {
                        String str = "";
                        if (line.contains("\"")) {
                            str += "PRODUCT_SDA_NO = " + "\"" + Config.mSDA + "\"";
                        } else {
                            str += "PRODUCT_SDA_NO = " + Config.mSDA;
                        }
                        if (line.contains(";")) {
                            str += ";";
                        }
                        pw.print(str + "\n"); // 这里不用println是因为编码问题，linux下换行为\n，而不是\r\n
                    } else if (line.contains("m_pPanelName") && line.trim().startsWith("m")) {
                        String str;
                        if (Config.mTVProject == Config.TV848) {
                            str = "m_pPanelName = \"/tvconfig/config/panel/" + localFile.getName() + "\"" + ";";
                        } else {
                            str = "m_pPanelName = \"/config/panel/" + localFile.getName() + "\"" + ";";
                        }
                        pw.print(str + "\n");
                    } else if (line.contains("Manufacturer_Name") && !Config.mManufacturerName.equals("")) {
                        String str = "Manufacturer_Name	= \"" + Config.mManufacturerName + "\"";
                        pw.print(str + "\n");
                    } else if (line.contains("Product_Code") && !Config.mProductCode.equals("")) {
                        String str = "Product_Code		= 0x" + Config.mProductCode;
                        pw.print(str + "\n");
                    } else if (line.contains("Monitor_Name") && !Config.mMonitorName.equals("")) {
                        String str = "Monitor_Name		= \"" + Config.mMonitorName + "\"";
                        pw.print(str + "\n");
                    } else {
                        pw.print(line + "\n");
                    }
                } else if (path.equals(Config.RESET_SERVICE)) {
                    if (line.contains("#define PANELPATH") && !line.contains("backup")) {
                        String str;
                        str = "#define PANELPATH \"/vendor/tvconfig/config/panel/" + localFile.getName() + "\"";
                        pw.print(str + "\n");
                    } else if (line.contains("#define PANELPATHBPPATH") && line.contains("backup")) {
                        String str;
                        str = "#define PANELPATHBPPATH \"/vendor/tvconfig/config/panel/backup/" + localFile.getName() + "\"";
                        pw.print(str + "\n");
                    } else {
                        pw.print(line + "\n");
                    }
                } else if (path.equals(Config.PANEL_INDEX_PATH)) {
                    if (line.contains("K")) {
                        String name = pq_name.split("\\.")[0];
                        String str;
                        str = name + " = 0" + ";";
                        pw.print(str + "\n");
                    } else {
                        pw.print(line + "\n");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if(bf != null)
            		bf.close();
            	if(pw != null)
            		pw.close();
                if (customer.exists()) {
                    customer.delete();
                }
                temp.renameTo(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * 修改DLC.ini文件， DLC文件只复制DLC_0和DLC_1的八个数组
     */
    private void modifyDLCFile(File file) throws IOException {
        log.d("", "正在修改 DLC.ini 文件...");
        log.d("", "DLC.ini 文件路径：" + Config.DLC_PATH);
        File dlcFile = new File(Config.DLC_PATH + "DLC.ini");
        File tempFile = new File(Config.DLC_PATH + "DLC_TEMP.ini");
        BufferedReader source = null;
        BufferedReader bf = null;
        PrintWriter pw = null;
        String[] dlc1 = new String[2];
        String[] dlc2 = new String[2];
        String[] dlc3 = new String[2];
        String[] dlc4 = new String[2];
        try {
            source = new BufferedReader(new FileReader(file));
            String lineBefore = "";
            //int count = 0;
            int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
            boolean isNeedAdd1 = false, isNeedAdd2 = false, isNeedAdd3 = false, isNeedAdd4 = false;
            while ((lineBefore = source.readLine()) != null) {
                if (lineBefore.contains("tLumaCurve ") && !isNeedAdd1) {
                    dlc1[count1] = lineBefore;
                    count1++;
                    if (count1 >= 2) {
                        count1 = 0;
                        isNeedAdd1 = true;
                    }
                } else if (lineBefore.contains("tLumaCurve2_a ") && !isNeedAdd2) {
                    dlc2[count2] = lineBefore;
                    count2++;
                    if (count2 >= 2) {
                        count2 = 0;
                        isNeedAdd2 = true;
                    }
                } else if (lineBefore.contains("tLumaCurve2_b ") && !isNeedAdd3) {
                    dlc3[count3] = lineBefore;
                    count3++;
                    if (count3 >= 2) {
                        count3 = 0;
                        isNeedAdd3 = true;
                    }
                } else if (lineBefore.contains("tDlcHistogramLimitCurve ") && !isNeedAdd4) {
                    dlc4[count4] = lineBefore;
                    count4++;
                    if (count4 >= 2) {
                        count4 = 0;
                        isNeedAdd4 = true;
                    }
                } /*
                 * if (lineBefore.contains("tLumaCurve ") ||
                 * lineBefore.contains("tLumaCurve2_a ") ||
                 * lineBefore.contains("tLumaCurve2_b ") ||
                 * lineBefore.contains("tDlcHistogramLimitCurve ")) { dlcNeedChange[count] =
                 * lineBefore; count++; if (count >= 8) { count = 0; break; } }
                 */
            }
            bf = new BufferedReader(new FileReader(dlcFile));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)));
            String line;
            boolean isNeedCopy1 = true, isNeedCopy2 = true, isNeedCopy3 = true, isNeedCopy4 = true;
            while ((line = bf.readLine()) != null) {
                if (line.contains("tLumaCurve ") && isNeedCopy1) {
                    pw.print(dlc1[count1] + "\n");
                    count1++;
                    if (count1 >= 2) {
                        isNeedCopy1 = false;
                    }
                } else if (line.contains("tLumaCurve2_a ") && isNeedCopy2) {
                    pw.print(dlc2[count2] + "\n");
                    count2++;
                    if (count2 >= 2) {
                        isNeedCopy2 = false;
                    }
                } else if (line.contains("tLumaCurve2_b ") && isNeedCopy3) {
                    pw.print(dlc3[count3] + "\n");
                    count3++;
                    if (count3 >= 2) {
                        isNeedCopy3 = false;
                    }
                } else if (line.contains("tDlcHistogramLimitCurve ") && isNeedCopy4) {
                    pw.print(dlc4[count4] + "\n");
                    count4++;
                    if (count4 >= 2) {
                        isNeedCopy4 = false;
                    }
                } else {
                    pw.print(line + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                source.close();
                bf.close();
                pw.close();
                if (dlcFile.exists()) {
                    dlcFile.delete();
                }
                tempFile.renameTo(new File(Config.DLC_PATH + "DLC.ini"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * 打开客户宏
     */
    private void modifyCommonFeature() {
        boolean isAuthenticated = ExcuteLinuxCmd.connectLinuxServer(Config.mServerIP,
                Config.mUserID, Config.mUserPassword);

        if (isAuthenticated && !Config.mCustomer.equals(Config.CUSTOMER_VAL)) {
            log.d("", "正在开启客户宏...");
            String string = Config.mCustomer;
            if (string.contains(";")) {
                String[] strs = string.split(";");
                for (int i = 0; i < strs.length; i++) {
                    log.d("", "客户宏: " + strs[i]);
                    String cmd = "sed -i \"s/" + strs[i] + " = 0/" + strs[i] + " = 1/g\" "
                            + Config.COMMON_FEATURE_PATH;
                    ExcuteLinuxCmd.excuteCmd(isAuthenticated, cmd, log, "");
                }
            } else {
                log.d("", "客户宏: " + string);
                //log.d("","isAuthenticated: " + isAuthenticated + CMD);
                ExcuteLinuxCmd.excuteCmd(isAuthenticated, CMD, log, "");
            }
        } else if (isAuthenticated == false) {
            log.e("", "服务器连接失败，请重新配置！！！");
        }
    }

    private void modifyDevice() {
        String customerString = Config.mCustomer, cmdTimezone = "", cmdKgznTimezone = "", cmdLang = "", cmdLangCoun = "", cmdLanguageCountryString = "", cmdLocale = "", cmdBlueToothOn = "", cmdDvbsOff = "", cmdHotelOn = "", cmdHotelKgzn = "";
        String[] projectIdString = customerString.split("_", 2);
        String deviceNameString = "sed -i 's/kgzn.ota.customer=.*/kgzn.ota.customer=" + projectIdString[1] + " \\\\/g' " + "device.mk";
        System.out.println(projectIdString);
        boolean isAuthenticated = ExcuteLinuxCmd.connectLinuxServer(Config.mServerIP,
                Config.mUserID, Config.mUserPassword);
        String[] src = new String[2];
        String goDeviceSrc = "";
        if (isAuthenticated && Config.DEVICE_PATH.length() != 0) {
            if (Config.DEVICE_PATH.contains("share")) {
                src = Config.DEVICE_PATH.split("/share/");
                goDeviceSrc = "cd ../../other/" + src[1];
            } else {
                goDeviceSrc = "cd " + Config.DEVICE_PATH.replaceAll("/" + Config.mServerIP + "/", "");
            }
            System.out.println(goDeviceSrc);
            String[] countryStrings = Config.mCountry.split("/");
            String[] lang_coun = Config.mLanguage.split("_");

            //log.d("","isAuthenticated: " + isAuthenticated + CMD);
            if (countryStrings.length == 2 && lang_coun.length == 2) {
                if (Config.COUNTRY_CHECK == true) {
                    cmdTimezone = "sed -i 's/.*persist.sys.timezone=.*/	persist.sys.timezone=" + countryStrings[0] + "\\/" + countryStrings[1] + " \\\\/g' " + "device.mk";
                    cmdKgznTimezone = "sed -i 's/.*kgzn.ota.timezone=.*/	kgzn.ota.timezone=" + countryStrings[0] + "\\/" + countryStrings[1] + " \\\\/g' " + "device.mk";
                }
                if (Config.LANGUAGE_CHECK == true) {
                    cmdLang = "sed -i 's/.*persist.sys.language=.*/	persist.sys.language=" + lang_coun[0] + " \\\\/g' " + "device.mk";
                    cmdLangCoun = "sed -i 's/.*persist.sys.country=.*/	persist.sys.country=" + lang_coun[1] + " \\\\/g' " + "device.mk";
                    cmdLocale = "sed -i 's/.*kgzn.ota.locale=.*/	kgzn.ota.locale=" + Config.mLanguage + " \\\\/g' " + "device.mk";
                    cmdLanguageCountryString = "sed -i 's/ro.product.locale=.*/ro.product.locale=" + lang_coun[0] + "-" + lang_coun[1] + "/g' " + "device.mk";
                }
                if (Config.BLUETOOTH_CHECK == true) {
                    //persist.sys.bluetooth=true
                    cmdBlueToothOn = "sed -i 's/persist.sys.bluetooth=.*/persist.sys.bluetooth=true \\\\/g' " + "device.mk";

                }
                if (Config.DVBS_CHECK == true) {
                    //kgzn.has.dvbs=false
                    cmdDvbsOff = "sed -i 's/kgzn.has.dvbs=.*/kgzn.has.dvbs=false \\\\/g' " + "device.mk";
                }
                if (Config.HOTEL_CHECK == true) {
                    cmdHotelOn = "sed -i 's/persist.sys.hotel=.*/persist.sys.hotel=true \\\\/g' " + "device.mk";
                    cmdHotelKgzn = "sed -i 's/kgzn.hotel=.*/kgzn.hotel=true \\\\/g' " + "device.mk";
                }
                if (Config.COUNTRY_CHECK || Config.LANGUAGE_CHECK || Config.BLUETOOTH_CHECK || Config.DVBS_CHECK || Config.HOTEL_CHECK) {
                    log.d("", "正在修改device.mk...");
                    ExcuteLinuxCmd.excuteCmd(isAuthenticated, goDeviceSrc + "\n" + cmdTimezone + "\n" + cmdLang + "\n" + cmdLangCoun + "\n" + cmdLocale + "\n" + cmdKgznTimezone + "\n" + cmdBlueToothOn + "\n" + cmdDvbsOff + "\n" + cmdHotelOn + "\n" + cmdHotelKgzn + "\n" + deviceNameString + "\n" + "cd ../" + projectIdString[0] + "/" + "\n" + cmdLanguageCountryString, log, "device.mk");
                } else {
                    log.d("", "未勾选，不修改device.mk!");
                }
            } else {
                log.e("", "时区或默认语言配置错误，请重新配置！！！");
            }
        } else {
            log.e("", "服务器连接失败或路径不存在，请重新配置！！！");
        }
    }

    private void modifyAcfgDvb() {
        String cmdDvbCountry = "";
        boolean isAuthenticated = ExcuteLinuxCmd.connectLinuxServer(Config.mServerIP,
                Config.mUserID, Config.mUserPassword);
        String[] src = new String[2];
        String goAcfgDvbeSrc = "";
        if (isAuthenticated && Config.ACFG_DVB_PATH.length() != 0) {
            if (Config.ACFG_DVB_PATH.contains("share")) {
                src = Config.ACFG_DVB_PATH.split("/share/");
                goAcfgDvbeSrc = "cd ../../other/" + src[1];
            } else {
                goAcfgDvbeSrc = "cd " + Config.ACFG_DVB_PATH.replaceAll("/" + Config.mServerIP + "/", "");
            }
            System.out.println(goAcfgDvbeSrc);
            String dvbCountryString = Config.mDvbCountry.trim();
            //log.d("","isAuthenticated: " + isAuthenticated + CMD);
            if (Config.DVBCOUNTRY_CHECK == true) {
                if (Config.mTVProject == 19){
                    log.d("", "正在修改acfg_dvb.c...");
                    //sed -i '190,//s/s3166_app_cfg_count_.*/s3166_app_cfg_count_cfg/g' acfg_dvb.c
                    cmdDvbCountry = "sed -i '190,//s/s3166_app_cfg_count_.*/s3166_app_cfg_count_" + dvbCountryString + "/g' " + "acfg_dvb.c";
                    // System.out.println(cmdDvbCountry);
                    ExcuteLinuxCmd.excuteCmd(isAuthenticated, goAcfgDvbeSrc + "\n" + cmdDvbCountry, log, "默认搜台国家");
                }else if (Config.mTVProject == 20) {
                    log.d("", "正在修改acfg_dvb.c...");
                    //sed -i '186,//s/s3166_app_cfg_count_.*/s3166_app_cfg_count_cfg/g' acfg_dvb.c
                    cmdDvbCountry = "sed -i '186,//s/s3166_app_cfg_count_.*/s3166_app_cfg_count_" + dvbCountryString + "/g' " + "acfg_dvb.c";
                    // System.out.println(cmdDvbCountry);
                    ExcuteLinuxCmd.excuteCmd(isAuthenticated, goAcfgDvbeSrc + "\n" + cmdDvbCountry, log, "默认搜台国家");
                }

            } else {
                log.d("", "未勾选，不修改acfg_dvb.c!");
            }

        } else {
            log.e("", "服务器连接失败或路径不存在，请重新配置！！！");
        }
    }

    private void removeHelpActivity() {
        String cmdRemoveHelpActivity = "", cmdRun = "";
        String goApksSrc = "";
        boolean isAuthenticated = ExcuteLinuxCmd.connectLinuxServer(Config.mServerIP,
                Config.mUserID, Config.mUserPassword);
        if (isAuthenticated && Config.HELPACTIVITY_PATH.length() != 0) {
            String[] src = new String[2];
            if (Config.HELPACTIVITY_PATH.contains("share")) {
                src = Config.HELPACTIVITY_PATH.split("/share/");
                goApksSrc = "cd ../../other/" + src[1];
            } else {
                goApksSrc = "cd " + Config.HELPACTIVITY_PATH.replaceAll("/" + Config.mServerIP + "/", "");
            }
            System.out.println(goApksSrc);
            if (Config.HELP_CHECK == true) {
                cmdRemoveHelpActivity = "ls Help_*.apk | xargs rm -rf";
                ExcuteLinuxCmd.excuteCmd(isAuthenticated, goApksSrc + "\n" + cmdRemoveHelpActivity + "\n" + "cd ../../../" + "\n" + "./run_genAndroid.mk.sh", log, "删除说明书");
            }
        } else {
            log.e("", "服务器连接失败或路径不存在，请重新配置！！！");
        }
    }

    private void addVga() {
        String cmdAddVga = "";
        String goTvInputSrc = "";
        boolean isAuthenticated = ExcuteLinuxCmd.connectLinuxServer(Config.mServerIP,
                Config.mUserID, Config.mUserPassword);
        if (isAuthenticated && Config.TvInput_PATH.length() != 0) {
            String[] src = new String[2];
            if (Config.TvInput_PATH.contains("share")) {
                src = Config.TvInput_PATH.split("/share/");
                goTvInputSrc = "cd ../../other/" + src[1];
            } else {
                goTvInputSrc = "cd " + Config.TvInput_PATH.replaceAll("/" + Config.mServerIP + "/", "");
            }
            System.out.println(goTvInputSrc);
            if (Config.VGA_CHECK == true) {
                log.d("", "正在修改TvInput.json...");
                //sed -i '/\"sourceName\": \"VGA\"/,/VGA通道/s/\"isAllow\":.*/\"isAllow\": false/g'
                cmdAddVga = "sed -i '/\"sourceName\": \"VGA\",/,/\"desc\":\"VGA通道\"/s/\"isAllow\":.*/\"isAllow\": true,/g' " + "TvInput.json";
                ExcuteLinuxCmd.excuteCmd(isAuthenticated, goTvInputSrc + "\n" + cmdAddVga + "\n", log, "带VGA");
            }
        } else {
            log.e("", "服务器连接失败或路径不存在，请重新配置！！！");
        }
    }

    private void removeDVBC() {
        String cmdRemoveDVBC = "";
        String goTvInputSrc = "";
        boolean isAuthenticated = ExcuteLinuxCmd.connectLinuxServer(Config.mServerIP,
                Config.mUserID, Config.mUserPassword);
        if (isAuthenticated && Config.ARRAY_PATH.length() != 0) {
            String[] src = new String[2];
            if (Config.ARRAY_PATH.contains("share")) {
                src = Config.ARRAY_PATH.split("/share/");
                goTvInputSrc = "cd ../../other/" + src[1];
            } else {
                goTvInputSrc = "cd " + Config.ARRAY_PATH.replaceAll("/" + Config.mServerIP + "/", "");
            }
            System.out.println(goTvInputSrc);
            System.out.println("Config.DVBC_CHECK:" + Config.DVBC_CHECK);
            if (Config.DVBC_CHECK == true) {
                log.d("", "正在修改arrays.xml...");
                //sed -r '/root/d ' mypasswd
                cmdRemoveDVBC = "sed -i '/@string\\/str_tuning_Cable/d ' " + "arrays.xml";
                System.out.println(cmdRemoveDVBC);
                ExcuteLinuxCmd.excuteCmd(isAuthenticated, goTvInputSrc + "\n" + cmdRemoveDVBC + "\n", log, "去除DVB-C");
            }
        } else {
            log.e("", "服务器连接失败或路径不存在，请重新配置！！！");
        }
    }

    private void updateBackLight() {
        String cmdBackLight = "";
        String goConfigSrc = "";
        String backLightVal = Config.mBackLight.trim();
        boolean isAuthenticated = ExcuteLinuxCmd.connectLinuxServer(Config.mServerIP,
                Config.mUserID, Config.mUserPassword);
        if (isAuthenticated && Config.Config_PATH.length() != 0) {
            String[] src = new String[2];
            if (Config.Config_PATH.contains("share")) {
                src = Config.Config_PATH.split("/share/");
                goConfigSrc = "cd ../../other/" + src[1];
            } else {
                goConfigSrc = "cd " + Config.Config_PATH.replaceAll("/" + Config.mServerIP + "/", "");
            }
            System.out.println(goConfigSrc);
            if (Config.BACKLIGHT_CHECK == true) {
                log.d("", "正在修改背光值...");
                //cmdBackLight="sed -i '/[Backlight]/,/[Contrast]/s/.*,60,50,/"+backLightVal+",60,50,/g ' "+"ConfigDefaultValue.ini";
                cmdBackLight = "sed -i '/\\[Backlight\\]/,/\\[Contrast\\]/s/.*,60,50,/" + backLightVal + ",60,50,/g' " + " ConfigDefaultValue.ini";
                System.out.println(cmdBackLight);
                ExcuteLinuxCmd.excuteCmd(isAuthenticated, goConfigSrc + "\n" + cmdBackLight + "\n" + "cd backup/" + "\n" + cmdBackLight, log, "背光");
            }
        } else {
            log.e("", "服务器连接失败或路径不存在，请重新配置！！！");
        }
    }

    /*
     * 初始化数据库本地存放路径
     */
    private void initDBDirectory(String path) {
        File file = new File(path);
        //log.d("path: ", path);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                f.delete();
            }
        }
    }

    /*
     * 删除数据库本地临时文件
     */
    public void deleteFile() {
        ArrayList<File> arrayFilesList = getAllFileList("D:\\db_temp\\");
        for (File f : arrayFilesList) {
            if (f.getName().contains("db_")) {
                File file1 = new File("D:\\db_temp\\" + f.getName());
                if (!file1.exists()) {
                    return;
                }

                if (file1.isDirectory()) {
                    File[] files = file1.listFiles();
                    for (File file2 : files) {
                        file2.delete();
                    }
                }
                file1.delete();
                f.delete();
            }
        }
    }

    /*
     * 复制数据库等文件到本地(服务器速度较慢，放到本地执行快一点)，并执行UPDATE
     */
    private void copyDBFileAndExecute() throws IOException, ClassNotFoundException, SQLException {
        for (File file : allFiles) {
            if (file.getName().toLowerCase().contains("colortemp")) {
                copyFile(file, DB_PATH + file.getName());
            } else if (file.getName().toLowerCase().contains("nonlinear")) {
                copyFile(file, DB_PATH + file.getName());
            } else if (file.getName().toLowerCase().contains("pictemp")) {
                copyFile(file, DB_PATH + file.getName());
            } else if (file.getName().toLowerCase().contains("user")) {
                copyFile(file, DB_PATH + file.getName());
            } else if (file.getName().toLowerCase().contains("factory")) {
                copyFile(file, DB_PATH + file.getName());
            }
        }
        File facDB = new File(Config.FACTORY_DB_PATH);
        File userDB = new File(Config.USER_DB_PATH);
        File facDBTemp = new File(DB_PATH + facDB.getName());
        File userDBTemp = new File(DB_PATH + userDB.getName());
        Files.copy(facDB.toPath(), facDBTemp.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(userDB.toPath(), userDBTemp.toPath(), StandardCopyOption.REPLACE_EXISTING);

        SqliteExecute sqliteExecute = new SqliteExecute(log);
        sqliteExecute.executeSqliteAll();
    }

    /*
     * 保存界面输入数据到本地，写入txt文件中
     */
    public void saveAllData() {
        PrintWriter pw = null;
        File file = new File("D:\\db_temp\\data.txt");
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        try {
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));

            pw.println("mTVProject: " + Config.mTVProject);
            pw.println("mServerIP: " + Config.mServerIP);
            pw.println("mUserID: " + Config.mUserID);
            pw.println("mUserPassword: " + Config.mUserPassword);
            pw.println("mSDA: " + Config.mSDA);

            pw.println("mPanelType: " + Config.mPanelType);
            pw.println("mManufacturerName: " + Config.mManufacturerName);
            pw.println("mProductCode: " + Config.mProductCode);
            pw.println("mMonitorName: " + Config.mMonitorName);
            pw.println("mCustomer: " + Config.mCustomer);
            pw.println("mCountry: " + Config.mCountry);
            pw.println("mLanguage: " + Config.mLanguage);
            pw.println("mDvbCountry:" + Config.mDvbCountry);
            pw.println("mPhilipsAQVersion: " + Config.mPhilipsAQVersion);
            pw.println("mPhilipsPQVersion: " + Config.mPhilipsPQVersion);
            pw.println("mPhilipsSWVersion: " + Config.mPhilipsSWVersion);
            pw.println("mPhilipsOC: " + Config.mPhilipsOC);
            pw.println("isNeedChangeOADPanel: " + Config.isNeedChangeOADPanel);

            pw.println("mFilePath: " + Config.mFilePath);
            pw.println("mCodePath: " + Config.mCodePath);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}
