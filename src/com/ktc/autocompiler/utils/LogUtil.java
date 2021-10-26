package com.ktc.autocompiler.utils;

import javax.swing.*;

/**
 * @Author feizai
 * @Date 2021年10月26日 0026  下午 09:39:58
 * @Explain
 */
public class LogUtil {
    private StringBuilder sb;
    private JTextArea jTextArea;
    public static LogUtil instance;

    public static LogUtil getInstance(JTextArea jTextArea) {
        if (instance == null) {
            instance = new LogUtil(jTextArea);
        }
        return instance;
    }

    private LogUtil(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
        sb = new StringBuilder();
    }

    public void d(String tag, String message) {
        String s = "";
        if (tag.equals("")) {
            s = message;
        } else {
            s = tag + " " + message;
        }
        sb.append(s);
        sb.append("\n");
        jTextArea.setText(sb.toString());
    }

    public void e(String tag, String message) {
        String s = "ERROR: " + tag + " " + message;
        sb.append(s);
        sb.append("\n");
        jTextArea.setText(sb.toString());
    }

    public void clearData() {
        sb.setLength(0);
        jTextArea.setText("");
    }
}
