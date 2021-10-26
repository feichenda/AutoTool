package com.ktc.autocompiler.excute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ktc.autocompiler.constants.Config;
import com.ktc.autocompiler.utils.LogUtil;

/**
 * @Author feizai
 * @Date 2021年10月26日 0026  下午 09:43:49
 * @Explain
 */
public class SqliteExecute {
    private Connection factory;
    private Connection user;
    private Statement stmtFac;
    private Statement stmtUser;
    private BufferedReader bufferedReader;

    private LogUtil log;

    private String path = Excute.DB_PATH;            // 存放执行文件路径
    private static String FACTORY_URL = "jdbc:sqlite:" + Excute.DB_PATH + "factory.db";
    private static String USER_URL = "jdbc:sqlite:" + Excute.DB_PATH + "user_setting.db";

    public SqliteExecute(LogUtil log) {
        this.log = log;
    }

    public void executeSqliteAll() throws IOException, SQLException, ClassNotFoundException {
        ArrayList<File> sqlFiles;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        init();
        sqlFiles = getSqlFileList();
        log.d("", "start time : " + sdf.format(new Date()));
        log.d("", "正在导入数据库 : ");
        System.out.println("start time : " + sdf.format(new Date()));
        for (File f : sqlFiles) {
            if (f.getName().toLowerCase().contains("colortemp")) {
                executeSqlFile(f, stmtFac);
                //System.out.println("execute colortemp finish! time : " + sdf.format(new Date()));
            } else if (f.getName().toLowerCase().contains("nonlinear")) {
                executeSqlFile(f, stmtFac);
                //System.out.println("execute nonlinear finish! time : " + sdf.format(new Date()));
            } else if (f.getName().toLowerCase().contains("pictemp")) {
                executeSqlFile(f, stmtUser);
                //System.out.println("execute pictemp finish! time : " + sdf.format(new Date()));
            }
        }
        for (File f : sqlFiles) {
            if (f.getName().toLowerCase().contains("user")) {
                executeSqlFile(f, stmtUser);
                //System.out.println("execute user.txt");
            } else if (f.getName().toLowerCase().contains("factory")) {
                executeSqlFile(f, stmtFac);
                //System.out.println("execute factory.txt");
            }
        }
        executeSqlString(Config.sqlTestUSR, stmtUser); // 测试executeSqlString()方法
        executeSqlString(Config.sqlTestFAC, stmtFac);
        close();
        log.d("", "完成导入数据库!");
        log.d("", "end time : " + sdf.format(new Date()));
        System.out.println("execute finish!");
    }

    /*
     * JDBC初始化
     */
    private void init() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        factory = DriverManager.getConnection(FACTORY_URL);
        user = DriverManager.getConnection(USER_URL);
        System.out.println("Opened database successfully");
        stmtFac = factory.createStatement();
        stmtUser = user.createStatement();
    }

    /*
     * 获取需要执行的文件
     */
    private ArrayList<File> getSqlFileList() {
        File file = new File(path);
        File[] files = file.listFiles();
        ArrayList<File> fileArrayList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            if (!files[i].getName().contains(".txt")) {
                continue;
            }
            fileArrayList.add(files[i]);
            System.out.println("file name : " + files[i].getName());
        }
        return fileArrayList;
    }

    /*
     * 执行sql语句
     */
    private void executeSqlFile(File file, Statement statement) throws IOException, SQLException {
        log.d("", "time : " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        log.d("", "正在导入 " + file.getName() + " ...");
        bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //部分DVB制式方案user_setting.db无以下字段，执行时需要跳过，如638DVB、658DVB -start-
            if ((line.contains("u8EnergyEfficiencyBacklight")
                    || line.contains("u8EnergyEfficiencyBacklight_Max")
                    || line.contains("BackupEnergyBacklight")
                    || line.contains("BackupEnergyBacklightMax"))
                    && (Config.mTVProject == 9 || Config.mTVProject == 10
                    || Config.mTVProject == 16)) {
                continue;
            }
            //部分DVB制式方案user_setting.db无以下字段，执行时需要跳过，如638DVB、658DVB -end-
            if (line.toUpperCase().startsWith("UPDATE")) {
                String[] s = line.split(";");
                statement.executeUpdate(s[0]);
            }
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
    }

    /*
     * 执行多条sql命令,可以自定义
     */
    private void executeSqlString(String[] s, Statement statement) {
        try {
            for (String s1 : s) {
                statement.executeUpdate(s1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /*
     * 关闭连接
     */
    private void close() {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            stmtFac.close();
            stmtUser.close();
            factory.close();
            user.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
