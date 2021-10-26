package com.ktc.autocompiler.utils;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;

/**
 * @Author feizai
 * @Date 2021年10月26日 0026  下午 09:38:24
 * @Explain
 */
public class Tools {
    /**
     * 用于拆分一个字符串，组成新的一个字符串,这里用来拆分路径
     *
     * @param str   需要拆分的字符串
     * @param flag1 拆分字符串的标志
     * @param flag2 组合字符串的标志，可为空
     * @return 新组合的字符串
     */
    public static String parseString(String str, String flag1, String flag2) {
        String string = "";
        String[] strs = str.split(flag1);
        if (strs.length > 1) {
            for (int i = 1; i < strs.length; i++) {
                string += strs[i] + flag2;
                //System.out.println("string : " + string);
            }
            return string;
        } else {
            return "";
        }
    }

    /**
     * 生成一个字符串用于文件夹命名
     *
     * @param length 随机字符串的长度
     * @return 随机自字符串
     */
    public static String getRandomString(int length) { // 随机字符串的随机字符库
        String KeyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        int len = KeyString.length();
        for (int i = 0; i < length; i++) {
            sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sb.toString();
    }

    /*
     * 高亮字符串
     */
    public static void highlightString(JTextArea jTextArea, String keyWord) {
        Highlighter highlighter = jTextArea.getHighlighter();
        String text = jTextArea.getText();
        DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
        int pos = 0;
        while ((pos = text.indexOf(keyWord, pos)) >= 0) {
            try {
                highlighter.addHighlight(pos, pos + keyWord.length(), painter);
                pos += keyWord.length();
            } catch (BadLocationException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}
