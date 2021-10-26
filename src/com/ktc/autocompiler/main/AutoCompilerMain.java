package com.ktc.autocompiler.main;

import com.ktc.autocompiler.frame.MainFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @Author feizai
 * @Date 2021年10月26日 0026  下午 09:47:22
 * @Explain
 */
public class AutoCompilerMain {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                MainFrame mainFrame = new MainFrame();
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setOnExcuteClickListener(mainFrame);
                mainFrame.setVisible(true);
            }
        });
    }
}
