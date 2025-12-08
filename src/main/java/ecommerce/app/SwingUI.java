package ecommerce.app;

import ecommerce.uiHelper.*;
import javax.swing.*;
import java.awt.*;
import ecommerce.uiHelper.ObjectType;

public class SwingUI extends JFrame{

    public SwingUI() {

        initGUI(); // Window Setup

        initLoginPanel(); // Login Panel setup

        setVisible(true); // End
    }

    public void initGUI() {
        setTitle("Ecommerce Store");
        setSize(1500, 800);
        getContentPane().setBackground(Theme.BACKGROUND);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
    }

    public void initLoginPanel() {

        // DATA FIELD
        RoundedControl user_name_field;
        RoundedControl user_id_field;
        RoundedControl auth_login_button;
        RoundedControl auth_register_button;

        // CREATE LOGIN PANEL
        RoundedControl loginPanel = UITools.createRoundPanel(Theme.PANEL,380, 480, 40);
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        // INIT REGION
        JPanel HEADER = UITools.createXContainer(Integer.MAX_VALUE, 25);
        JPanel FORM = UITools.createYContainer(Integer.MAX_VALUE, Integer.MAX_VALUE);

        // INIT SECTIONS
        JPanel FORMUser = UITools.createYContainer(Integer.MAX_VALUE,100);
        JPanel FORMPass = UITools.createYContainer(Integer.MAX_VALUE,100);
        JPanel FORMLogin = UITools.createYContainer(Integer.MAX_VALUE,40);
        JPanel FORMDivider = UITools.createXContainer(Integer.MAX_VALUE,50);
        JPanel FORMRegister = UITools.createXContainer(Integer.MAX_VALUE,50);

        // INIT BLOCKS
        JPanel USERLabel = UITools.createXContainer(Integer.MAX_VALUE,50);
        JPanel USERField = UITools.createYContainer(Integer.MAX_VALUE,50);
        JPanel PASSLabel = UITools.createXContainer(Integer.MAX_VALUE,50);
        JPanel PASSField = UITools.createYContainer(Integer.MAX_VALUE,50);
        JPanel DIVLeft = UITools.createXContainer((380-80-45)/2, 1);
        JPanel DIVText = UITools.createXContainer(45,50);
        JPanel DIVRight = UITools.createXContainer((380-80-45)/2, 1);
        JPanel REGText = UITools.createXContainer((int)((380-80)*.60), Integer.MAX_VALUE);
        JPanel REGButton = UITools.createXContainer((int)((380-80)*.40),Integer.MAX_VALUE);


        // CREATE HEADER REGION
        JLabel headerlabel = UITools.createLabel(HEADER,"LOGIN",25,true, Align.CENTER);

        // CREATE USER SECTION
        JLabel userlabel = UITools.createLabel(USERLabel, "Username",15,true, Align.LEFT);
        user_name_field = UITools.createRoundField(USERField, ObjectType.FIELD_TEXT, Integer.MAX_VALUE, 50);
        userlabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // CREATE PASSWORD SECTION
        JLabel passlabel = UITools.createLabel(PASSLabel, "Password",15,true, Align.LEFT);
        user_id_field = UITools.createRoundField(PASSField, ObjectType.FIELD_PASS, Integer.MAX_VALUE, 50);
        passlabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // CREATE LOGIN SECTION
        auth_login_button = UITools.createRoundButton(FORMLogin, ObjectType.BUTTON_BLOCK, Integer.MAX_VALUE, 40, "LOGIN", 15);

        // CREATE DIVIDER SECTION
        JLabel divider = UITools.createLabel(DIVText, "OR", 15, true, Align.CENTER);
        divider.setForeground(Theme.GRAYTEXT);

        // CREATE REGISTER SECTION
        JLabel register_text = UITools.createLabel(REGText,"Don't have an account?",13,false, Align.RIGHT);
        auth_register_button = UITools.createRoundButton(REGButton, ObjectType.BUTTON_BLOCK,60,18,"SIGNUP", 13);
        register_text.setForeground(Theme.GRAYTEXT);

        //uth_register_button.setBorderColor(new Color(0, 0, 0, 0));
        auth_register_button.setNormalTextColor(Theme.GRAYTEXT);
        auth_register_button.setHoverTextColor(new Color(50, 120, 255));
        auth_register_button.setNormalBackgroundColor(Color.WHITE);
        auth_register_button.setHoverBackgroundColor(Color.WHITE);


        // --- DEBUG AREA ---
        /*
        Debug.colorPanel(HEADER, Color.GREEN);
        Debug.colorPanel(FORM, Color.RED);
        Debug.colorPanel(USERFIELD, Color.BLUE);
        Debug.colorPanel(PASSFIELD, Color.ORANGE);
        Debug.colorPanel(REGISTER_TEXT, Color.GREEN);
        Debug.colorPanel(FORMRegister, Color.RED);
        Debug.colorPanel(REGISTER_BUTTON, Color.ORANGE);
         */
        //Debug.colorPanel(FORMPass, Color.ORANGE);

        Debug.colorPanel(DIVLeft, Theme.GRAYTEXT);
        Debug.colorPanel(DIVRight, Theme.GRAYTEXT);


        // SECTION ORGANIZER
        loginPanel.add(HEADER);
        loginPanel.add(FORM);

        // SEGMENT ORGANIZER
        FORM.add(FORMUser);
        FORM.add(FORMPass);
        FORM.add(Box.createVerticalStrut(40));
        FORM.add(FORMLogin);
        FORM.add(Box.createVerticalStrut(20));
        FORM.add(FORMDivider);
        FORM.add(FORMRegister);

        // AREA ORGANIZER
        FORMUser.add(USERLabel);
        FORMUser.add(USERField);

        FORMPass.add(PASSLabel);
        FORMPass.add(PASSField);

        FORMDivider.add(DIVLeft);
        FORMDivider.add(DIVText);
        FORMDivider.add(DIVRight);

        FORMRegister.add(REGText);
        FORMRegister.add(REGButton);


        REGButton.add(Box.createHorizontalStrut(5));
        REGButton.add(auth_register_button);

        // ADD TO SYSTEM
        add(loginPanel);
    }


}
