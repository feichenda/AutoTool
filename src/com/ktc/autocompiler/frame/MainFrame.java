package com.ktc.autocompiler.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.sql.SQLException;

import javax.swing.*;

import com.ktc.autocompiler.constants.Config;
import com.ktc.autocompiler.excute.Excute;
import com.ktc.autocompiler.listener.JTextFieldHintListener;
import com.ktc.autocompiler.listener.OnExcuteClickListener;
import com.ktc.autocompiler.utils.LogUtil;

/**
 * @Author feizai
 * @Date 2021年10月26日 0026  下午 09:44:40
 * @Explain
 */
public class MainFrame extends JFrame implements OnExcuteClickListener {

    private JTextField mServerText, mUserIDText, mUserPasswordText, mSDAText, mPanelTypeText, mManufacturerNameText, mProductCodeText, mMonitorNameText, mSWVersionText, mPhilipsAQVersionText, mPhilipsPQVersionText, mPhilipsSWVersionText, mPhilipsOCText, mCustomerText, mTimezoneText, mLangText, mDvbCountryText, mBackLightText;
    private JCheckBox mOADPanelCheckBox, countryCheck, langCheck, dvbCountryCheck, btCheck, helpActCheck, dvbCCheck, dvbSCheck, vgaCheck, backLightCheck, hotelCheck;
    private JLabel mFilePathLable, mCodePathLable;
    private JButton mExcuteButton;
    public JTextArea logText;
    public static JComboBox<String> mTVProjectComboBox, mBoardTypeComboBox;
    public JPanel mCountryDefPanel, mLangPanel, mDvbCountryPanel, mcheckBoxsPanel, mBackLightPanel;
    private JPanel mainPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JScrollPane rightPanel = new JScrollPane();

    private OnExcuteClickListener onExcuteClickListener;

    private static final Font LEFT_PANLE_FONT_1 = new Font("宋体", Font.BOLD, 15);
    private static final Font LEFT_PANLE_FONT_2 = new Font("宋体", Font.PLAIN, 15);
    private static final Font RIGHT_PANLE_FONT = new Font("宋体", Font.PLAIN, 11);
    private static final Font MENU_BAR_FONT = new Font("宋体", Font.PLAIN, 12);

    public MainFrame() {
        /*设置操作窗口大小 start*/
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        if (width == 1920) {
            setSize(1000, 800);
        } else if (width == 1366) {
            setSize(1000, 800);
        } else {
            setSize(1000, 800);
        }
        setLocation(width / 4, height / 6);
        setTitle("KTC 生产软件数据导入工具 	V1.0");
        /*设置操作窗口大小 end*/
        /*设置操作窗口布局 start*/
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        //JScrollPane jScrollPane = new JScrollPane();
        leftPanel.setLayout(new GridLayout(24, 2));
        leftPanel.setPreferredSize(new Dimension(720, 700));
        //leftPanel.add(jScrollPane, BorderLayout.CENTER);
        mainPanel.add(leftPanel);

        rightPanel.setPreferredSize(new Dimension(240, 640));
        rightPanel.setBackground(Color.WHITE);
        mainPanel.add(rightPanel, BorderLayout.NORTH);
        add(mainPanel);
        /*设置操作窗口布局 end*/
        addMenuBar();
        addTVProject();
        addServerIP();
        addUserID();
        addUserPassword();
        addSDA();
        addPanelType();
        addBoardType();
        addManufacturerName();
        addProductCode();
        addMonitorName();
        addCountryDef();
        addLang();
        addDvbCountry();
        addBackLight();
        //addSWVersion();
        addCustomer();
        addPhilipsAQVersion();
        addPhilipsPQVersion();
        addPhilipsSWVersion();
        addPhilipsOC();
        addOADPanelCheckBox();
        addcheckBoxs();
        addFilePath();
        addCodePath();
        addExcuteButton();
        addLogTextPanel();

        restorePreData();
    }

    private void addMenuBar() {
        JMenuBar mMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("文件");
        JMenu clearMenu = new JMenu("清除");
        JMenu helpMenu = new JMenu("帮助");
        fileMenu.setFont(MENU_BAR_FONT);
        clearMenu.setFont(MENU_BAR_FONT);
        helpMenu.setFont(MENU_BAR_FONT);

        JMenuItem restorePreDataMenu = new JMenuItem("恢复上次数据");
        JMenuItem fileMenu2 = new JMenuItem("开发中...");
        JMenuItem clearDataMenu = new JMenuItem("恢复到初始状态");
        JMenuItem operationHelpMenu = new JMenuItem("操作说明");
        fileMenu.add(restorePreDataMenu);
        fileMenu.add(fileMenu2);
        clearMenu.add(clearDataMenu);
        helpMenu.add(operationHelpMenu);
        mMenuBar.add(fileMenu);
        mMenuBar.add(clearMenu);
        mMenuBar.add(helpMenu);
        setJMenuBar(mMenuBar);

        restorePreDataMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                restorePreData();
            }
        });

        operationHelpMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                LogUtil.getInstance(logText).d("", "请查阅 KTC生产软件数据导入工具使用说明.doc");
                try {
					/*String url = this.getClass().getResource("test.html").getFile();
					logText.setText(url);
					String userPath = System.getProperty("user.dir") + "\\test.html";
					String user = Tools.parsePath(userPath, "\\\\", "/");
					logText.setText(user);
					System.out.println("userPath: " + userPath);
					File mFile1 = new File(url);
					File mFile2 = new File(user);
					Files.copy(mFile1.toPath(), mFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);*/

                    String url = "U://test//html//OperationHelp.html";
                    URI uri = URI.create(url);
                    Desktop desktop = Desktop.getDesktop();
                    if (desktop.isSupported(Action.BROWSE)) {
                        desktop.browse(uri);
                    }
                } catch (NullPointerException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        });

        clearDataMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                mTVProjectComboBox.setSelectedIndex(-1);
                mServerText.addFocusListener(new JTextFieldHintListener(mServerText, "192.168.47.93"));
                mUserIDText.addFocusListener(new JTextFieldHintListener(mUserIDText, "laiyw"));
                mUserPasswordText.addFocusListener(new JTextFieldHintListener(mUserPasswordText, "****"));
                mSDAText.addFocusListener(new JTextFieldHintListener(mSDAText, "SDA00000000"));
                mPanelTypeText.addFocusListener(new JTextFieldHintListener(mPanelTypeText, "K490WDC1/C2_LT300A1"));
                mManufacturerNameText.addFocusListener(new JTextFieldHintListener(mManufacturerNameText, "kgzn"));
                mProductCodeText.addFocusListener(new JTextFieldHintListener(mProductCodeText, "4900"));
                mMonitorNameText.addFocusListener(new JTextFieldHintListener(mMonitorNameText, "49'TV"));
                mCustomerText.addFocusListener(new JTextFieldHintListener(mCustomerText, Config.CUSTOMER_VAL));
                mPhilipsAQVersionText.addFocusListener(new JTextFieldHintListener(mPhilipsAQVersionText, Config.PHILIPS_AQ_VERSION_VAL));
                mPhilipsPQVersionText.addFocusListener(new JTextFieldHintListener(mPhilipsPQVersionText, Config.PHILIPS_PQ_VERSION_VAL));
                mPhilipsSWVersionText.addFocusListener(new JTextFieldHintListener(mPhilipsSWVersionText, Config.PHILIPS_SW_VERSION_VAL));
                mPhilipsOCText.addFocusListener(new JTextFieldHintListener(mPhilipsOCText, Config.PHILIPS_OC_VAL));
                mOADPanelCheckBox.setSelected(false);
                ;
                mFilePathLable.setText("");
                mCodePathLable.setText("");
                LogUtil.getInstance(logText).clearData();
            }
        });
    }

    private void addTVProject() {
        JPanel mTVProjectPanel = new JPanel();
        mTVProjectPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel mTVProjectLable = new JLabel("请选择你的方案: ");
        mTVProjectLable.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
        mTVProjectComboBox = new JComboBox<String>(Config.TV_PROJECTS);
        mTVProjectComboBox.setSelectedIndex(-1);
        mTVProjectComboBox.setFont(LEFT_PANLE_FONT_1);
        mTVProjectComboBox.addItemListener(new ItemChangeListener());
        mTVProjectPanel.add(mTVProjectLable);
        mTVProjectPanel.add(mTVProjectComboBox);
        leftPanel.add(mTVProjectPanel);

    }

    private void addBoardType() {
        JPanel mBoardTypePanel = new JPanel();
        mBoardTypePanel.setLayout(new GridLayout(1, 2));
        JLabel mBoardTypeLable = new JLabel("请选择你的主板: ");
        mBoardTypeLable.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
        mBoardTypeComboBox = new JComboBox<String>(Config.TV_BOARDS);
        mBoardTypeComboBox.setSelectedIndex(-1);
        mBoardTypeComboBox.setFont(LEFT_PANLE_FONT_1);
        mBoardTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config.initPath();
                // TODO Auto-generated method stub
                if (mBoardTypeComboBox.getSelectedItem().equals("M2C1")) {
                    Config.CUSTOMER_INI_PATH = Config.CUSTOMER_INI_M2C1_PATH;
                    Config.CUSTOMER_INI_TEMP = Config.CUSTOMER_INI_M2C1_TEMP;
                } else if (mBoardTypeComboBox.getSelectedItem().equals("M3C1")) {
                    Config.CUSTOMER_INI_PATH = Config.CUSTOMER_INI_M3C1_PATH;
                    Config.CUSTOMER_INI_TEMP = Config.CUSTOMER_INI_M3C1_TEMP;
                } else if (mBoardTypeComboBox.getSelectedItem().equals("M6C1")) {
                    Config.CUSTOMER_INI_PATH = Config.CUSTOMER_INI_M6C1_PATH;
                    Config.CUSTOMER_INI_TEMP = Config.CUSTOMER_INI_M6C1_TEMP;
                }
            }
        });

        mBoardTypePanel.add(mBoardTypeLable);
        mBoardTypePanel.add(mBoardTypeComboBox);
        leftPanel.add(mBoardTypePanel);

    }

    private void addServerIP() {
        JPanel mServerPanel = new JPanel();
        mServerPanel.setLayout(new GridLayout(1, 2));
        JLabel mServerLable = new JLabel(Config.SERVER_IP);
        mServerLable.setFont(LEFT_PANLE_FONT_1);
        mServerText = new JTextField(25);
        mServerText.addFocusListener(new JTextFieldHintListener(mServerText, "192.168.47.93"));
        mServerText.setSize(16, 16);
        mServerPanel.add(mServerLable);
        mServerPanel.add(mServerText);
        leftPanel.add(mServerPanel);
    }

    private void addUserID() {
        JPanel mUserIDPanel = new JPanel();
        mUserIDPanel.setLayout(new GridLayout(1, 2));
        JLabel mUserIDLable = new JLabel(Config.USER_ID);
        mUserIDLable.setFont(LEFT_PANLE_FONT_1);
        mUserIDText = new JTextField(25);
        mUserIDText.addFocusListener(new JTextFieldHintListener(mUserIDText, "laiyw"));
        mUserIDText.setSize(16, 16);
        mUserIDPanel.add(mUserIDLable);
        mUserIDPanel.add(mUserIDText);
        leftPanel.add(mUserIDPanel);
    }

    private void addUserPassword() {
        JPanel mUserPasswordPanel = new JPanel();
        mUserPasswordPanel.setLayout(new GridLayout(1, 2));
        JLabel mUserPasswordLable = new JLabel(Config.USER_PASSWORD);
        mUserPasswordLable.setFont(LEFT_PANLE_FONT_1);
        mUserPasswordText = new JTextField(25);
        mUserPasswordText.addFocusListener(new JTextFieldHintListener(mUserPasswordText, "****"));
        mUserPasswordText.setSize(16, 16);
        mUserPasswordPanel.add(mUserPasswordLable);
        mUserPasswordPanel.add(mUserPasswordText);
        leftPanel.add(mUserPasswordPanel);
    }

    private void addSDA() {
        JPanel mSDAPanel = new JPanel();
        mSDAPanel.setLayout(new GridLayout(1, 2));
        JLabel mSDALable = new JLabel(Config.SDA);
        mSDALable.setFont(LEFT_PANLE_FONT_1);
        mSDAText = new JTextField(25);
        mSDAText.addFocusListener(new JTextFieldHintListener(mSDAText, "SDA00000000"));
        mSDAText.setSize(16, 16);
        mSDAPanel.add(mSDALable);
        mSDAPanel.add(mSDAText);
        leftPanel.add(mSDAPanel);
    }

    private void addPanelType() {
        JPanel mPanelTypePanel = new JPanel();
        mPanelTypePanel.setLayout(new GridLayout(1, 2));
        JLabel mPanelTypeLable = new JLabel(Config.PANEL_TYPE);
        mPanelTypeLable.setFont(LEFT_PANLE_FONT_1);
        mPanelTypeText = new JTextField(25);
        mPanelTypeText.addFocusListener(new JTextFieldHintListener(mPanelTypeText, "K490WDC1/C2_LT300A1"));
        mPanelTypePanel.add(mPanelTypeLable);
        mPanelTypePanel.add(mPanelTypeText);
        leftPanel.add(mPanelTypePanel);
    }

    private void addManufacturerName() {
        JPanel mManufacturerNamePanel = new JPanel();
        mManufacturerNamePanel.setLayout(new GridLayout(1, 2));
        JLabel mManufacturerNameLable = new JLabel(Config.MANUFACTURE_NAME);
        mManufacturerNameLable.setFont(LEFT_PANLE_FONT_1);
        mManufacturerNameText = new JTextField(25);
        mManufacturerNameText.addFocusListener(new JTextFieldHintListener(mManufacturerNameText, "SKG"));
        mManufacturerNamePanel.add(mManufacturerNameLable);
        mManufacturerNamePanel.add(mManufacturerNameText);
        leftPanel.add(mManufacturerNamePanel);
    }

    private void addProductCode() {
        JPanel mProductCodePanel = new JPanel();
        mProductCodePanel.setLayout(new GridLayout(1, 2));
        JLabel mProductCodeLable = new JLabel(Config.PRODUCT_CODE);
        mProductCodeLable.setFont(LEFT_PANLE_FONT_1);
        mProductCodeText = new JTextField(25);
        mProductCodeText.addFocusListener(new JTextFieldHintListener(mProductCodeText, "4900"));
        mProductCodePanel.add(mProductCodeLable);
        mProductCodePanel.add(mProductCodeText);
        leftPanel.add(mProductCodePanel);
    }

    private void addMonitorName() {
        JPanel mMonitorNamePanel = new JPanel();
        mMonitorNamePanel.setLayout(new GridLayout(1, 2));
        JLabel mMonitorNameLable = new JLabel(Config.MONITOR_NAME);
        mMonitorNameLable.setFont(LEFT_PANLE_FONT_1);
        mMonitorNameText = new JTextField(25);
        mMonitorNameText.addFocusListener(new JTextFieldHintListener(mMonitorNameText, "49'TV"));
        mMonitorNamePanel.add(mMonitorNameLable);
        mMonitorNamePanel.add(mMonitorNameText);
        leftPanel.add(mMonitorNamePanel);
    }

    private void addCountryDef() {
        mCountryDefPanel = new JPanel();
        JPanel mPanel = new JPanel();
        mPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 2));
        mCountryDefPanel.setLayout(new GridLayout(1, 2));
        JLabel mCountryDefLable = new JLabel(Config.COUNTRY_DEF);
        mCountryDefLable.setFont(LEFT_PANLE_FONT_1);
        mTimezoneText = new JTextField(25);
        mTimezoneText.addFocusListener(new JTextFieldHintListener(mTimezoneText, "Europe/Berlin"));
        mTimezoneText.setEnabled(false);
        countryCheck = new JCheckBox();
        countryCheck.addItemListener(itemListener);
        mPanel.add(mCountryDefLable);
        mPanel.add(countryCheck);
        mCountryDefPanel.add(mPanel);
        mCountryDefPanel.add(mTimezoneText);
        leftPanel.add(mCountryDefPanel);
    }

    private void addLang() {
        mLangPanel = new JPanel();
        JPanel mPanel = new JPanel();
        mPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 2));
        mLangPanel.setLayout(new GridLayout(1, 2));
        JLabel mLangLable = new JLabel(Config.LANGUAGE_DEF);
        mLangLable.setFont(LEFT_PANLE_FONT_1);
        mLangText = new JTextField(25);
        mLangText.addFocusListener(new JTextFieldHintListener(mLangText, "en_US"));
        mLangText.setEnabled(false);
        langCheck = new JCheckBox();
        langCheck.addItemListener(itemListener);
        mPanel.add(mLangLable);
        mPanel.add(langCheck);
        mLangPanel.add(mPanel);
        mLangPanel.add(mLangText);
        leftPanel.add(mLangPanel);
    }

    private void addBackLight() {
        mBackLightPanel = new JPanel();
        JPanel mPanel = new JPanel();
        mPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 2));
        mBackLightPanel.setLayout(new GridLayout(1, 2));
        JLabel mBackLightLable = new JLabel(Config.BACKLIGHT_DEF);
        mBackLightLable.setFont(LEFT_PANLE_FONT_1);
        mBackLightText = new JTextField(25);
        mBackLightText.addFocusListener(new JTextFieldHintListener(mBackLightText, "100"));
        mBackLightText.setEnabled(false);
        backLightCheck = new JCheckBox();
        backLightCheck.addItemListener(itemListener);
        mPanel.add(mBackLightLable);
        mPanel.add(backLightCheck);
        mBackLightPanel.add(mPanel);
        mBackLightPanel.add(mBackLightText);
        leftPanel.add(mBackLightPanel);
    }

    private void addDvbCountry() {
        mDvbCountryPanel = new JPanel();
        JPanel mPanel = new JPanel();
        mPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 2));
        mDvbCountryPanel.setLayout(new GridLayout(1, 2));
        JLabel mDvbCountryLable = new JLabel(Config.DVBCOUNTRY_DEF);
        mDvbCountryLable.setFont(LEFT_PANLE_FONT_1);
        mDvbCountryText = new JTextField(25);
        mDvbCountryText.addFocusListener(new JTextFieldHintListener(mDvbCountryText, "deu"));
        dvbCountryCheck = new JCheckBox();
        dvbCountryCheck.addItemListener(itemListener);
        mPanel.add(mDvbCountryLable);
        mPanel.add(dvbCountryCheck);
        mDvbCountryPanel.add(mPanel);
        mDvbCountryPanel.add(mDvbCountryText);
        leftPanel.add(mDvbCountryPanel);
    }

    private void addcheckBoxs() {
        mcheckBoxsPanel = new JPanel();
        mcheckBoxsPanel.setLayout(new GridLayout(1, 6));
        //蓝牙
        JPanel mPanel1 = new JPanel();
        mPanel1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JLabel btLabel = new JLabel("带蓝牙:");
        btLabel.setFont(LEFT_PANLE_FONT_1);
        btCheck = new JCheckBox();
        btCheck.addItemListener(itemListener);
        mPanel1.add(btLabel);
        mPanel1.add(btCheck);
        //说明书
        JPanel mPanel2 = new JPanel();
        mPanel2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JLabel helpActLabel = new JLabel("去说明书:");
        helpActLabel.setFont(LEFT_PANLE_FONT_1);
        helpActCheck = new JCheckBox();
        helpActCheck.addItemListener(itemListener);
        mPanel2.add(helpActLabel);
        mPanel2.add(helpActCheck);

        //dvb-c
        JPanel mPanel3 = new JPanel();
        mPanel3.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JLabel dvbCLabel = new JLabel("去DVB-C:");
        dvbCLabel.setFont(LEFT_PANLE_FONT_1);
        dvbCCheck = new JCheckBox();
        dvbCCheck.addItemListener(itemListener);
        mPanel3.add(dvbCLabel);
        mPanel3.add(dvbCCheck);

        //dvb-s
        JPanel mPanel4 = new JPanel();
        mPanel4.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JLabel dvbSLabel = new JLabel("去DVB-S:");
        dvbSLabel.setFont(LEFT_PANLE_FONT_1);
        dvbSCheck = new JCheckBox();
        dvbSCheck.addItemListener(itemListener);
        mPanel4.add(dvbSLabel);
        mPanel4.add(dvbSCheck);

        //vga
        JPanel mPanel5 = new JPanel();
        mPanel5.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JLabel vgaLabel = new JLabel("带VGA:");
        vgaLabel.setFont(LEFT_PANLE_FONT_1);
        vgaCheck = new JCheckBox();
        vgaCheck.addItemListener(itemListener);
        mPanel5.add(vgaLabel);
        mPanel5.add(vgaCheck);

        //酒店菜单
        JPanel mPanel6 = new JPanel();
        mPanel6.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JLabel hotelLabel = new JLabel("带酒店菜单:");
        hotelLabel.setFont(LEFT_PANLE_FONT_1);
        hotelCheck = new JCheckBox();
        hotelCheck.addItemListener(itemListener);
        mPanel6.add(hotelLabel);
        mPanel6.add(hotelCheck);


        mcheckBoxsPanel.add(mPanel2);
        mcheckBoxsPanel.add(mPanel3);
        mcheckBoxsPanel.add(mPanel4);
        mcheckBoxsPanel.add(mPanel1);
        mcheckBoxsPanel.add(mPanel5);
        mcheckBoxsPanel.add(mPanel6);
        leftPanel.add(mcheckBoxsPanel);


    }

    private void addSWVersion() {
        JPanel mSWVersionPanel = new JPanel();
        mSWVersionPanel.setLayout(new GridLayout(1, 2));
        JLabel mSWVersionLable = new JLabel(Config.SW_VERSION);
        mSWVersionLable.setFont(LEFT_PANLE_FONT_1);
        mSWVersionText = new JTextField(25);
        mSWVersionText.addFocusListener(new JTextFieldHintListener(mSWVersionText, "V1.0.0(选填)"));
        mSWVersionPanel.add(mSWVersionLable);
        mSWVersionPanel.add(mSWVersionText);
        leftPanel.add(mSWVersionPanel);
    }

    private void addCustomer() {
        JPanel mCustomerPanel = new JPanel();
        mCustomerPanel.setLayout(new GridLayout(1, 2));
        JLabel mCustomerLable = new JLabel(Config.CUSTOMER);
        mCustomerLable.setFont(LEFT_PANLE_FONT_1);
        mCustomerText = new JTextField(25);
        mCustomerText.addFocusListener(new JTextFieldHintListener(mCustomerText, Config.CUSTOMER_VAL));
        mCustomerPanel.add(mCustomerLable);
        mCustomerPanel.add(mCustomerText);
        leftPanel.add(mCustomerPanel);
    }

    private void addPhilipsAQVersion() {
        JPanel mPhilipsAQVersionPanel = new JPanel();
        mPhilipsAQVersionPanel.setLayout(new GridLayout(1, 2));
        JLabel mPhilipsAQVersionLable = new JLabel(Config.PHILIPS_AQ_VERSION);
        mPhilipsAQVersionLable.setFont(LEFT_PANLE_FONT_1);
        mPhilipsAQVersionText = new JTextField(25);
        mPhilipsAQVersionText.addFocusListener(new JTextFieldHintListener
                (mPhilipsAQVersionText, Config.PHILIPS_AQ_VERSION_VAL));
        mPhilipsAQVersionPanel.add(mPhilipsAQVersionLable);
        mPhilipsAQVersionPanel.add(mPhilipsAQVersionText);
        leftPanel.add(mPhilipsAQVersionPanel);
    }

    private void addPhilipsPQVersion() {
        JPanel mPhilipsPQVersionPanel = new JPanel();
        mPhilipsPQVersionPanel.setLayout(new GridLayout(1, 2));
        JLabel mPhilipsPQVersionLable = new JLabel(Config.PHILIPS_PQ_VERSION);
        mPhilipsPQVersionLable.setFont(LEFT_PANLE_FONT_1);
        mPhilipsPQVersionText = new JTextField(25);
        mPhilipsPQVersionText.addFocusListener(new JTextFieldHintListener
                (mPhilipsPQVersionText, Config.PHILIPS_PQ_VERSION_VAL));
        mPhilipsPQVersionPanel.add(mPhilipsPQVersionLable);
        mPhilipsPQVersionPanel.add(mPhilipsPQVersionText);
        leftPanel.add(mPhilipsPQVersionPanel);
    }

    private void addPhilipsSWVersion() {
        JPanel mPhilipsSWVersionPanel = new JPanel();
        mPhilipsSWVersionPanel.setLayout(new GridLayout(1, 2));
        JLabel mPhilipsSWVersionLable = new JLabel(Config.PHILIPS_SW_VERSION);
        mPhilipsSWVersionLable.setFont(LEFT_PANLE_FONT_1);
        mPhilipsSWVersionText = new JTextField(25);
        mPhilipsSWVersionText.addFocusListener(new JTextFieldHintListener
                (mPhilipsSWVersionText, Config.PHILIPS_SW_VERSION_VAL));
        mPhilipsSWVersionPanel.add(mPhilipsSWVersionLable);
        mPhilipsSWVersionPanel.add(mPhilipsSWVersionText);
        leftPanel.add(mPhilipsSWVersionPanel);
    }

    private void addPhilipsOC() {
        JPanel mPhilipsOCPanel = new JPanel();
        mPhilipsOCPanel.setLayout(new GridLayout(1, 2));
        JLabel mPhilipsOCLable = new JLabel(Config.PHILIPS_OC);
        mPhilipsOCLable.setFont(LEFT_PANLE_FONT_1);
        mPhilipsOCText = new JTextField(25);
        mPhilipsOCText.addFocusListener(new JTextFieldHintListener
                (mPhilipsOCText, Config.PHILIPS_OC_VAL));
        mPhilipsOCPanel.add(mPhilipsOCLable);
        mPhilipsOCPanel.add(mPhilipsOCText);
        leftPanel.add(mPhilipsOCPanel);
    }

    private void addOADPanelCheckBox() {
        JPanel mOADPanelCheckPanel = new JPanel();
        mOADPanelCheckPanel.setLayout(new BorderLayout(250, 0));
        JLabel mOADPanelCheckLabel = new JLabel("是否需要修改OAD屏参列表(DVB制式): ");
        mOADPanelCheckLabel.setFont(LEFT_PANLE_FONT_1);
        mOADPanelCheckBox = new JCheckBox();
        mOADPanelCheckPanel.add(mOADPanelCheckLabel, BorderLayout.WEST);
        mOADPanelCheckPanel.add(mOADPanelCheckBox, BorderLayout.CENTER);
        leftPanel.add(mOADPanelCheckPanel);
    }

    private void addFilePath() {
        JPanel mFilePathPanel = new JPanel();
        mFilePathPanel.setLayout(new GridLayout(1, 2));
        JButton mFilePathButton = new JButton("你需要复制的文件路径：");
        //mFilePathButton.setHorizontalAlignment(AbstractButton.LEFT);
        mFilePathButton.setFont(LEFT_PANLE_FONT_1);
        mFilePathLable = new JLabel("");
        mFilePathLable.setFont(LEFT_PANLE_FONT_2);
        mFilePathPanel.add(mFilePathButton);
        mFilePathPanel.add(mFilePathLable);
        leftPanel.add(mFilePathPanel);
        JFileChooser mFileChooser = new JFileChooser();
        mFileChooser.setCurrentDirectory(new File("D://"));
        mFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        mFilePathButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                mFileChooser.showDialog(new JLabel(), "选择文件夹");
                File result = mFileChooser.getSelectedFile();
                if (result != null) {
                    mFilePathLable.setText(result.getAbsolutePath());
                    Config.mFilePath = result.getAbsolutePath();
                }
            }
        });

    }

    private void addCodePath() {
        JPanel mCodePathPanel = new JPanel();
        mCodePathPanel.setLayout(new GridLayout(1, 2));
        JButton mCodePathButton = new JButton("你需要选择的Supernova路径：");
        //mFilePathButton.setHorizontalAlignment(AbstractButton.LEFT);
        mCodePathButton.setFont(LEFT_PANLE_FONT_1);
        mCodePathLable = new JLabel("");
        mCodePathLable.setFont(LEFT_PANLE_FONT_2);
        mCodePathPanel.add(mCodePathButton);
        mCodePathPanel.add(mCodePathLable);
        leftPanel.add(mCodePathPanel);
        JFileChooser mCodePathChooser = new JFileChooser();
        mCodePathChooser.setCurrentDirectory(new File("D://"));
        mCodePathChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        mCodePathButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                mCodePathChooser.showDialog(new JLabel(), "选择文件夹");
                File result = mCodePathChooser.getSelectedFile();
                if (result != null) {
                    mCodePathLable.setText(result.getAbsolutePath());
                    Config.mCodePath = result.getAbsolutePath();
                }
            }
        });

    }

    private void addExcuteButton() {
        JPanel mExcutePanel = new JPanel();
        mExcutePanel.setLayout(new GridLayout(1, 2));
        mExcuteButton = new JButton("开始执行");
        mExcuteButton.setFont(LEFT_PANLE_FONT_1);
        mExcutePanel.add(mExcuteButton);
        leftPanel.add(mExcutePanel);

        mExcuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //LogUtil.getInstance(logText).d("", logText.getLineCount() + "");
                if (mTVProjectComboBox.getSelectedIndex() == -1) {
                    LogUtil.getInstance(logText).d("", "请选择你的方案！");
                    return;
                } else {

                    if (onExcuteClickListener != null) {
                        onExcuteClickListener.onExcuteClick();
                    }
                }
            }
        });

    }

    private void addLogTextPanel() {
        logText = new JTextArea();
        logText.setLineWrap(true); //文本超过显示宽度换行
        logText.setSize(240, 540);
        logText.setFont(RIGHT_PANLE_FONT);
        logText.setEditable(false);
        rightPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        rightPanel.setViewportView(logText);
    }

    private void initConfig() {
        System.out.println("方案：" + mTVProjectComboBox.getSelectedIndex());
        Config.mTVProject = mTVProjectComboBox.getSelectedIndex();
        Config.mServerIP = mServerText.getText();
        Config.mUserID = mUserIDText.getText();
        Config.mUserPassword = mUserPasswordText.getText();
        Config.mSDA = mSDAText.getText();
        Config.mPanelType = mPanelTypeText.getText();
        Config.mManufacturerName = mManufacturerNameText.getText();
        Config.mProductCode = mProductCodeText.getText();
        Config.mMonitorName = mMonitorNameText.getText();
        Config.mCustomer = mCustomerText.getText();
        Config.mCountry = mTimezoneText.getText();
        Config.mLanguage = mLangText.getText();
        Config.mDvbCountry = mDvbCountryText.getText();
        Config.mBackLight = mBackLightText.getText();
        Config.mPhilipsAQVersion = mPhilipsAQVersionText.getText();
        Config.mPhilipsPQVersion = mPhilipsPQVersionText.getText();
        Config.mPhilipsSWVersion = mPhilipsSWVersionText.getText();
        Config.mPhilipsOC = mPhilipsOCText.getText();
        Config.mFilePath = mFilePathLable.getText();
        Config.mCodePath = mCodePathLable.getText();
        Config.COUNTRY_CHECK = countryCheck.isSelected();
        Config.LANGUAGE_CHECK = langCheck.isSelected();
        Config.DVBCOUNTRY_CHECK = dvbCountryCheck.isSelected();
        Config.BACKLIGHT_CHECK = backLightCheck.isSelected();
        Config.isNeedChangeOADPanel = mOADPanelCheckBox.isSelected();
        Config.BLUETOOTH_CHECK = btCheck.isSelected();
        Config.HELP_CHECK = helpActCheck.isSelected();
        Config.DVBC_CHECK = dvbCCheck.isSelected();
        Config.DVBS_CHECK = dvbSCheck.isSelected();
        Config.VGA_CHECK = vgaCheck.isSelected();
        Config.HOTEL_CHECK = hotelCheck.isSelected();
        System.out.println("版型：" + mBoardTypeComboBox.getSelectedIndex());
        if (mBoardTypeComboBox.getSelectedIndex() == 0) {
            Config.CUSTOMER_INI_PATH = Config.CUSTOMER_INI_M2C1_PATH;
            Config.CUSTOMER_INI_TEMP = Config.CUSTOMER_INI_M2C1_TEMP;
        } else if (mBoardTypeComboBox.getSelectedIndex() == 1) {
            Config.CUSTOMER_INI_PATH = Config.CUSTOMER_INI_M3C1_PATH;
            Config.CUSTOMER_INI_TEMP = Config.CUSTOMER_INI_M3C1_TEMP;
        } else if (mBoardTypeComboBox.getSelectedIndex() == 2) {
            Config.CUSTOMER_INI_PATH = Config.CUSTOMER_INI_M6C1_PATH;
            Config.CUSTOMER_INI_TEMP = Config.CUSTOMER_INI_M6C1_TEMP;
        }
        //System.out.println(mTVProjectComboBox.getSelectedItem());
        //System.out.println(mTVProjectComboBox.getSelectedIndex());
    }

    /**
     * 恢复上一次操作的数据
     */
    private void restorePreData() {
        File file = new File("D:\\db_temp\\data.txt");
        if (!file.exists()) {
            LogUtil.getInstance(logText).d("", "本地没有保存数据的文件，恢复上一次数据失败！");
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                BufferedReader bf = null;
                try {
                    bf = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                    String line;
                    String projectString = "";
                    while ((line = bf.readLine()) != null) {
                        String[] strs = line.split(":");
                        String string = strs[strs.length - 1].trim();
                        //System.out.println("string: " + string);
                        if (line.contains("mTVProject")) {
                            mTVProjectComboBox.setSelectedIndex(Integer.parseInt(string));
                            projectString = string;
                        } else if (line.contains("mServerIP")) {
                            mServerText.setText(string);
                            if (!string.equals(Config.SERVER_IP_VAL)) {
                                mServerText.setForeground(Color.BLACK);
                            }
                        } else if (line.contains("mUserID")) {
                            mUserIDText.setText(string);
                            if (!string.equals(Config.USER_ID_VAL)) {
                                mUserIDText.setForeground(Color.BLACK);
                            }
                        } else if (line.contains("mUserPassword")) {
                            mUserPasswordText.setText(string);
                            if (!string.equals(Config.USER_PASSWORD_VAL)) {
                                mUserPasswordText.setForeground(Color.BLACK);
                            }
                        } else if (line.contains("mSDA")) {
                            mSDAText.setText(string);
                            if (!string.equals(Config.SDA_VAL)) {
                                mSDAText.setForeground(Color.BLACK);
                            }
                        } else if (line.contains("mPanelType")) {
                            mPanelTypeText.setText(string);
                            if (!string.equals(Config.PANEL_TYPE_VAL)) {
                                mPanelTypeText.setForeground(Color.BLACK);
                            }
                        } else if (line.contains("mManufacturerName")) {
                            mManufacturerNameText.setText(string);
                            if (!string.equals(Config.MANUFACTURE_NAME_VAL)) {
                                mManufacturerNameText.setForeground(Color.BLACK);
                            }
                        } else if (line.contains("mProductCode")) {
                            mProductCodeText.setText(string);
                            if (!string.equals(Config.PRODUCT_CODE_VAL)) {
                                mProductCodeText.setForeground(Color.BLACK);
                            }
                        } else if (line.contains("mMonitorName")) {
                            mMonitorNameText.setText(string);
                            if (!string.equals(Config.MONITOR_NAME_VAL)) {
                                mMonitorNameText.setForeground(Color.BLACK);
                            }
                        } else if (line.contains("mCustomer")) {
                            mCustomerText.setText(string);
                            if (!string.equals(Config.CUSTOMER_VAL)) {
                                mCustomerText.setForeground(Color.BLACK);
                            }
                        } else if (getDevPathLen() != 0 && line.contains("mCountry")) {
                            mTimezoneText.setText(string);
                            if (!string.equals(Config.COUNTRY_DEF_VAL)) {
                                mTimezoneText.setForeground(Color.BLACK);
                            }
                        } else if (getDevPathLen() != 0 && line.contains("mLanguage")) {
                            mLangText.setText(string);
                            if (!string.equals(Config.LANGUAGE_DEF_VAL)) {
                                mLangText.setForeground(Color.BLACK);
                            }

                        } else if (getAcfgPathLen() != 0 && line.contains("mDvbCountry")) {
                            mDvbCountryText.setText(string);
                            if (!string.equals(Config.DVBCOUNTRY_DEF_VAL)) {
                                mDvbCountryText.setForeground(Color.BLACK);
                            }

                        } else if (line.contains("mPhilipsAQVersion")) {
                            mPhilipsAQVersionText.setText(string);
                            if (!string.equals(Config.PHILIPS_AQ_VERSION_VAL)) {
                                mPhilipsAQVersionText.setForeground(Color.BLACK);
                            }
                        } else if (line.contains("mPhilipsPQVersion")) {
                            mPhilipsPQVersionText.setText(string);
                            if (!string.equals(Config.PHILIPS_PQ_VERSION_VAL)) {
                                mPhilipsPQVersionText.setForeground(Color.BLACK);
                            }
                        } else if (line.contains("mPhilipsSWVersion")) {
                            mPhilipsSWVersionText.setText(string);
                            if (!string.equals(Config.PHILIPS_SW_VERSION_VAL)) {
                                mPhilipsSWVersionText.setForeground(Color.BLACK);
                            }
                        } else if (line.contains("mPhilipsOC")) {
                            mPhilipsOCText.setText(string);
                            if (!string.equals(Config.PHILIPS_OC_VAL)) {
                                mPhilipsOCText.setForeground(Color.BLACK);
                            }
                        } else if (line.contains("isNeedChangeOADPanel")) {
                            if (string.equals("true")) {
                                mOADPanelCheckBox.setSelected(true);
                            } else if (string.equals("false")) {
                                mOADPanelCheckBox.setSelected(false);
                            }
                        } else if (line.contains("mFilePath")) {
                            mFilePathLable.setText(strs[strs.length - 2].trim() + ":" + string);
                            Config.mFilePath = strs[strs.length - 2].trim() + ":" + string;
                        } else if (line.contains("mCodePath")) {
                            if (line.contains("\\share\\")) {
                                mCodePathLable.setText(string);
                                Config.mCodePath = string;
                                System.out.println(Config.mCodePath);
                            } else {
                                mCodePathLable.setText(strs[strs.length - 2].trim() + ":" + string);
                                Config.mCodePath = strs[strs.length - 2].trim() + ":" + string;
                                System.out.println(Config.mCodePath);
                            }
                        }
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    if (bf != null) {
                        try {
                            bf.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    @Override
    public void setOnExcuteClickListener(OnExcuteClickListener onExcuteClickListener) {
        // TODO Auto-generated method stub
        this.onExcuteClickListener = onExcuteClickListener;
    }

    public static int getDevPathLen() {
        return Config.DEVICE_PATH.length();
    }

    public static int getAcfgPathLen() {
        return Config.ACFG_DVB_PATH.length();
    }

    public static int getConfigPathLen() {
        return Config.Config_PATH.length();
    }

    @Override
    public void onExcuteClick() {
        // TODO Auto-generated method stub
        initConfig();                //获取界面上输入的值
        Config.initPath();            //根据获取的值初始化路径

        LogUtil log = LogUtil.getInstance(logText);
        Excute excute = new Excute(log);
        if (Config.mFilePath.equals("") || Config.mCodePath.equals("")) {
            log.d("", "文件路径和代码路径不能为空哦");
            return;
        }

        new Thread(new Runnable() {
            public void run() {
                try {
                    log.d("", "开始！");
                    mExcuteButton.setEnabled(false);
                    excute.saveAllData();
                    excute.execute();
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    log.e("ClassNotFoundException: ", e.getMessage());
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    log.e("FileNotFoundException: ", e.getMessage());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    log.e("IOException: ", e.getMessage());
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    log.e("SQLException: ", e.getMessage());
                } finally {
                    log.d("", "完成！");
                    excute.deleteFile();
                    mExcuteButton.setEnabled(true);
                }
            }
        }).start();
    }

    ItemListener itemListener = new ItemListener() {

        public void itemStateChanged(ItemEvent e) {

            Object obj = e.getItem();
            if (obj.equals(countryCheck)) {
                if (countryCheck.isSelected()) {
                    if (!(getDevPathLen() == 0)) {
                        Config.COUNTRY_CHECK = true;
                        mTimezoneText.setEnabled(true);
                        System.out.println("countryCheck ok");
                    } else {
                        Config.COUNTRY_CHECK = false;
                        mTimezoneText.setEnabled(false);
                        System.out.println("countryCheck no");
                    }

                } else {
                    Config.COUNTRY_CHECK = false;
                    mTimezoneText.setEnabled(false);
                    System.out.println("countryCheck no");
                }
            }
            if (obj.equals(langCheck)) {
                if (langCheck.isSelected()) {
                    if (!(getDevPathLen() == 0)) {
                        Config.LANGUAGE_CHECK = true;
                        mLangText.setEnabled(true);
                        System.out.println("langCheck ok");
                    } else {
                        Config.LANGUAGE_CHECK = false;
                        mLangText.setEnabled(false);
                        System.out.println("langCheck no");
                    }
                } else {
                    Config.LANGUAGE_CHECK = false;
                    mLangText.setEnabled(false);
                    System.out.println("langCheck no");
                }
            }
            if (obj.equals(dvbCountryCheck)) {
                if (dvbCountryCheck.isSelected()) {
                    if (!(getAcfgPathLen() == 0)) {
                        Config.DVBCOUNTRY_CHECK = true;
                        mDvbCountryText.setEnabled(true);
                        System.out.println("dvbCountryCheck ok");
                    } else {
                        Config.DVBCOUNTRY_CHECK = false;
                        mDvbCountryText.setEnabled(false);
                        System.out.println("dvbCountryCheck no1");
                    }
                } else {
                    Config.DVBCOUNTRY_CHECK = false;
                    mDvbCountryText.setEnabled(false);
                    System.out.println("dvbCountryCheck no2");
                }
            }
            if (obj.equals(backLightCheck)) {
                if (backLightCheck.isSelected()) {
                    if (!(getConfigPathLen() == 0)) {
                        Config.BACKLIGHT_CHECK = true;
                        mBackLightText.setEnabled(true);
                        System.out.println("backLightCheck ok");
                    } else {
                        Config.BACKLIGHT_CHECK = false;
                        mBackLightText.setEnabled(false);
                        System.out.println("backLightCheck no1");
                    }
                } else {
                    Config.BACKLIGHT_CHECK = false;
                    mBackLightText.setEnabled(false);
                    System.out.println("backLightCheck no2");
                }
            }
            leftPanel.validate();
            leftPanel.repaint();

        }

    };

    class ItemChangeListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            // TODO Auto-generated method stub
            if (e.getStateChange() == ItemEvent.SELECTED) {
                countryCheck.setSelected(false);
                langCheck.setSelected(false);
                dvbCountryCheck.setSelected(false);
                backLightCheck.setSelected(false);
                Config.COUNTRY_CHECK = false;
                Config.LANGUAGE_CHECK = false;
                Config.DVBCOUNTRY_CHECK = false;
                Config.BACKLIGHT_CHECK = false;
                initConfig();
                Config.initPath();
                if (getDevPathLen() == 0) {
                    countryCheck.setEnabled(false);
                    langCheck.setEnabled(false);
                    mTimezoneText.setEnabled(false);
                    mLangText.setEnabled(false);

                } else {
                    countryCheck.setEnabled(true);
                    langCheck.setEnabled(true);

		        	/*  if(Config.COUNTRY_CHECK==true) {
		        		  mTimezoneText.setEnabled(true);
		        	  }
		        	  if(Config.LANGUAGE_CHECK==true ) {
		        		  mLangText.setEnabled(true);
		        	  } */
                }
                if (getAcfgPathLen() == 0) {
                    dvbCountryCheck.setEnabled(false);
                    mDvbCountryText.setEnabled(false);
                } else {
                    dvbCountryCheck.setEnabled(true);
                    dvbCountryCheck.setSelected(true);
                    Config.DVBCOUNTRY_CHECK = true;
                }
                if (getConfigPathLen() == 0) {
                    backLightCheck.setEnabled(false);
                    mBackLightText.setEnabled(false);
                } else {
                    backLightCheck.setEnabled(true);
                }
                if (!e.getItem().equals("6681")) {
                    btCheck.setSelected(false);
                    helpActCheck.setSelected(false);
                    dvbCCheck.setSelected(false);
                    dvbSCheck.setSelected(false);
                    vgaCheck.setSelected(false);
                    hotelCheck.setSelected(false);
                    btCheck.setEnabled(false);
                    helpActCheck.setEnabled(false);
                    dvbCCheck.setEnabled(false);
                    dvbSCheck.setEnabled(false);
                    vgaCheck.setEnabled(false);
                    hotelCheck.setEnabled(false);
                    mBoardTypeComboBox.setEnabled(false);
                } else {
                    btCheck.setEnabled(true);
                    helpActCheck.setEnabled(true);
                    dvbCCheck.setEnabled(true);
                    dvbSCheck.setEnabled(true);
                    vgaCheck.setEnabled(true);
                    hotelCheck.setEnabled(true);
                    mBoardTypeComboBox.setEnabled(true);
                }
                leftPanel.validate();
                leftPanel.repaint();
            }

        }
    }
}
