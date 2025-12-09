package ecommerce.ui;

import ecommerce.uiHelper.*;
import ecommerce.app.SwingUI;
import javax.swing.*;
import java.awt.*;


public class RegisterPage extends JPanel {

    private final SwingUI parent;

    public RegisterPage(SwingUI parent) {
        this.parent = parent;
        setOpaque(false);
        setLayout(new GridBagLayout());
        buildUI();
    }

    private void buildUI() {

        // DATA FIELD
        RoundObject user_name_field;
        RoundObject user_id_field;
        RoundObject user_role_field;
        RoundObject auth_register_button;
        RoundObject login_page_button;

        RoundObject registerPanel = UITools.createRoundPanel(Theme.PANEL,380, 585, 40);
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));

        // INIT REGION
        JPanel HEADER = UITools.createXContainer(Integer.MAX_VALUE, 25);
        JPanel FORM = UITools.createYContainer(Integer.MAX_VALUE, Integer.MAX_VALUE);

        // INIT SECTIONS
        JPanel FORMUser = UITools.createYContainer(Integer.MAX_VALUE,100);
        JPanel FORMPass = UITools.createYContainer(Integer.MAX_VALUE,100);
        JPanel FORMRole = UITools.createYContainer(Integer.MAX_VALUE,100);
        JPanel FORMRegister = UITools.createYContainer(Integer.MAX_VALUE,40);
        JPanel FORMDivider = UITools.createXContainer(Integer.MAX_VALUE,50);
        JPanel FORMLogin = UITools.createXContainer(Integer.MAX_VALUE,50);

        // INIT BLOCKS
        JPanel USERLabel = UITools.createXContainer(Integer.MAX_VALUE,50);
        JPanel USERField = UITools.createYContainer(Integer.MAX_VALUE,50);
        JPanel PASSLabel = UITools.createXContainer(Integer.MAX_VALUE,50);
        JPanel PASSField = UITools.createYContainer(Integer.MAX_VALUE,50);
        JPanel ROLELabel = UITools.createXContainer(Integer.MAX_VALUE,50);
        JPanel ROLEField = UITools.createYContainer(Integer.MAX_VALUE,50);
        JPanel DIVLeft = UITools.createXContainer((int) (300*(0.425)), 1);
        JPanel DIVText = UITools.createXContainer((int) (300*(0.15)),50);
        JPanel DIVRight = UITools.createXContainer((int) (300*(0.425)), 1);
        JPanel LOGText = UITools.createXContainer((int) (300*(0.65)), Integer.MAX_VALUE);
        JPanel LOGButton = UITools.createXContainer((int) (300*(0.35)),Integer.MAX_VALUE);

        // CREATE HEADER REGION
        JLabel headerlabel = UITools.createLabel(HEADER,"REGISTER",25,true, Align.CENTER);

        // CREATE USER SECTION
        JLabel userlabel = UITools.createLabel(USERLabel, "Username",15,true, Align.LEFT);
        user_name_field = UITools.createRoundField(USERField, ObjectType.TEXTFIELD, Integer.MAX_VALUE, 50);
        userlabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // CREATE PASSWORD SECTION
        JLabel passlabel = UITools.createLabel(PASSLabel, "Password",15,true, Align.LEFT);
        user_id_field = UITools.createRoundField(PASSField, ObjectType.TEXTFIELD, Integer.MAX_VALUE, 50);
        passlabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // CREATE PASSWORD SECTION
        JLabel rolelabel = UITools.createLabel(ROLELabel, "Role",15,true, Align.LEFT);
        user_role_field = UITools.createRoundField(ROLEField, ObjectType.TEXTFIELD, Integer.MAX_VALUE, 50);
        rolelabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // CREATE REGISTER SECTION
        auth_register_button = UITools.createRoundButton(FORMRegister, ObjectType.BUTTON, Integer.MAX_VALUE, 40, "REGISTER", 15);
        auth_register_button.setupButton(Theme.BLUE, Theme.HOVERBLUE, Theme.PANEL, Theme.PANEL);

        // CREATE DIVIDER SECTION
        JLabel divider = UITools.createLabel(DIVText, "OR", 15, true, Align.CENTER);
        divider.setForeground(Theme.GRAY);
        Debug.colorPanel(DIVLeft, Theme.GRAY);
        Debug.colorPanel(DIVRight, Theme.GRAY);

        // CREATE LOGIN SECTION
        JLabel login_text = UITools.createLabel(LOGText,"Already have an account?",13,false, Align.RIGHT);
        login_page_button = UITools.createRoundButton(LOGButton, ObjectType.BUTTON,60,18,"LOGIN", 13);
        login_page_button.setupButton(Theme.TRANSPARENT, Theme.TRANSPARENT, Theme.GRAY, Theme.BLUE);
        login_text.setForeground(Theme.GRAY);

        // -- DEBUG AREA --
        //Debug.colorPanel(HEADER, Color.RED);


        // SECTION ORGANIZER
        registerPanel.add(HEADER);
        registerPanel.add(FORM);

        // SEGMENT ORGANIZER
        FORM.add(FORMUser);
        FORM.add(FORMPass);
        FORM.add(FORMRole);
        FORM.add(Box.createVerticalStrut(40));
        FORM.add(FORMRegister);
        FORM.add(Box.createVerticalStrut(20));
        FORM.add(FORMDivider);
        FORM.add(FORMLogin);

        // AREA ORGANIZER
        FORMUser.add(USERLabel);
        FORMUser.add(USERField);

        FORMPass.add(PASSLabel);
        FORMPass.add(PASSField);

        FORMRole.add(ROLELabel);
        FORMRole.add(ROLEField);

        FORMDivider.add(DIVLeft);
        FORMDivider.add(DIVText);
        FORMDivider.add(DIVRight);

        FORMLogin.add(LOGText);
        FORMLogin.add(LOGButton);

        // DATA MANAGER
        DataTool.routeButton(parent, login_page_button, "LOGIN");

        add(registerPanel);
    }
}
