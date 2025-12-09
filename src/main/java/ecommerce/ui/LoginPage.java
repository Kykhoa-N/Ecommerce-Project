package ecommerce.ui;

import ecommerce.uiHelper.*;
import ecommerce.app.SwingUI;
import javax.swing.*;
import java.awt.*;

public class LoginPage extends JPanel {

    private final SwingUI parent;

    public LoginPage(SwingUI parent) {
        this.parent = parent;
        setOpaque(false);
        setLayout(new GridBagLayout());
        buildUI();
    }


    private void buildUI() {

        // DATA FIELD
        RoundObject user_name_field;
        RoundObject user_id_field;
        RoundObject auth_login_button;
        RoundObject auth_register_button;

        // CREATE LOGIN PANEL
        RoundObject loginPanel = UITools.createRoundPanel(Theme.PANEL,380, 490, 40);
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
        JPanel DIVLeft = UITools.createXContainer((int) (300*(0.425)), 1);
        JPanel DIVText = UITools.createXContainer((int) (300*(0.15)),50);
        JPanel DIVRight = UITools.createXContainer((int) (300*(0.425)), 1);
        JPanel REGText = UITools.createXContainer((int) (300*(0.6)), Integer.MAX_VALUE);
        JPanel REGButton = UITools.createXContainer((int) (300*(0.4)),Integer.MAX_VALUE);


        // CREATE HEADER REGION
        JLabel headerlabel = UITools.createLabel(HEADER,"LOGIN",25,true, Align.CENTER);

        // CREATE USER SECTION
        JLabel userlabel = UITools.createLabel(USERLabel, "Username",15,true, Align.LEFT);
        user_name_field = UITools.createRoundField(USERField, ObjectType.TEXTFIELD, Integer.MAX_VALUE, 50);
        userlabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // CREATE PASSWORD SECTION
        JLabel passlabel = UITools.createLabel(PASSLabel, "Password",15,true, Align.LEFT);
        user_id_field = UITools.createRoundField(PASSField, ObjectType.PASSFIELD, Integer.MAX_VALUE, 50);
        passlabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // CREATE LOGIN SECTION
        auth_login_button = UITools.createRoundButton(FORMLogin, ObjectType.BUTTON, Integer.MAX_VALUE, 40, "LOGIN", 15);
        auth_login_button.setupButton(Theme.BLUE, Theme.HOVERBLUE, Theme.PANEL, Theme.PANEL);

        // CREATE DIVIDER SECTION
        JLabel divider = UITools.createLabel(DIVText, "OR", 15, true, Align.CENTER);
        divider.setForeground(Theme.GRAY);
        Debug.colorPanel(DIVLeft, Theme.GRAY);
        Debug.colorPanel(DIVRight, Theme.GRAY);

        // CREATE REGISTER SECTION
        JLabel register_text = UITools.createLabel(REGText,"Don't have an account?",13,false, Align.RIGHT);
        auth_register_button = UITools.createRoundButton(REGButton, ObjectType.BUTTON,60,18,"SIGNUP", 13);
        auth_register_button.setupButton(Theme.TRANSPARENT, Theme.TRANSPARENT, Theme.GRAY, Theme.BLUE);
        register_text.setForeground(Theme.GRAY);

        // -- DEBUG AREA --
        //Debug.colorPanel(HEADER, Color.ORANGE);

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

        // DATA MANAGER
        DataTool.routeButton(parent, auth_register_button, "REGISTER");

        // ADD TO SYSTEM
        add(loginPanel);
    }
}