package com.ktc.autocompiler.listener;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

/**
 * @Author feizai
 * @Date 2021年10月26日 0026  下午 09:45:40
 * @Explain
 */
public class JTextFieldHintListener implements FocusListener {

    private String mHintText;
    private JTextField mJTextField;

    public JTextFieldHintListener(JTextField mJTextField, String mHintText) {
        this.mJTextField = mJTextField;
        this.mHintText = mHintText;
        mJTextField.setText(mHintText);
        mJTextField.setForeground(Color.GRAY);
    }

    @Override
    public void focusGained(FocusEvent e) {
        // TODO Auto-generated method stub
        String temp = mJTextField.getText();
        if (temp.equals(mHintText)) {
            mJTextField.setText("");
            mJTextField.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        // TODO Auto-generated method stub
        String temp = mJTextField.getText();
        if (temp.equals("")) {
            mJTextField.setText(mHintText);
            mJTextField.setForeground(Color.GRAY);
        }
    }

}
