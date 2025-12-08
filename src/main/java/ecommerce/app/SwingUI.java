package ecommerce.app;

import ecommerce.uiHelper.*;
import javax.swing.*;
import java.awt.*;

public class SwingUI extends JFrame{

    public SwingUI() {

        // Window Setup
        setTitle("Ecommerce Store");
        setSize(1500, 800);
        getContentPane().setBackground(Theme.BACKGROUND);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add new layout to window
        setLayout(new GridBagLayout());


        addLoginPanel();

        // end
        setVisible(true);
    }

    public void addLoginPanel() {

        // CREATE LOGIN PANEL
        RoundedControl loginPanel = UITools.createRoundPanel(20,Theme.PANEL,380, 480);
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        // CREATE SECTIONS
        JPanel HEADER = UITools.createXContainer(Integer.MAX_VALUE, 25);
        JPanel FORM = UITools.createYContainer(Integer.MAX_VALUE, Integer.MAX_VALUE);

        JPanel USERNAME_LABEL = UITools.createXContainer(Integer.MAX_VALUE ,50);
        JPanel PASSWORD_LABEL = UITools.createXContainer(Integer.MAX_VALUE,50);
        JPanel DIVIDER = UITools.createXContainer(Integer.MAX_VALUE,50);
        JPanel REGISTRATION = UITools.createXContainer(Integer.MAX_VALUE,50);

        JPanel LEFT_LINE = UITools.createXContainer((380-80-45)/2, 1);
        JPanel OR_LABEL = UITools.createXContainer(45,50);
        JPanel RIGHT_LINE = UITools.createXContainer((380-80-45)/2, 1);

        JPanel REGISTER_TEXT = UITools.createXContainer((int)((380-80)*.60), Integer.MAX_VALUE);
        JPanel REGISTER_BUTTON = UITools.createXContainer((int)((380-80)*.40),Integer.MAX_VALUE);






        // ADD TITLE TO HEADER
        JLabel title = UITools.createLabel( "LOGIN",25,true);
        UITools.orientLabel(HEADER, title, Align.CENTER, 0, 0, 0, 0);

        // ADD NAME FIELD TO FORM
        JLabel username = UITools.createLabel( "Username",15,true);
        UITools.orientLabel(USERNAME_LABEL, username, Align.LEFT, 20, 0, 0, 0);
        RoundedControl user_input = UITools.createRoundField(15, Integer.MAX_VALUE, 50);

        // ADD PASS FIELD TO FORM
        JLabel password = UITools.createLabel( "Password",15,true);
        UITools.orientLabel(PASSWORD_LABEL, password, Align.LEFT, 20, 0, 0, 0);
        RoundedControl pass_input = UITools.createRoundField(15, Integer.MAX_VALUE, 50);

        // ADD BUTTON
        RoundedControl button = new RoundedControl(RoundedControl.Type.BUTTON, 15, "LOGIN", 15);
        button.setControlSize(Integer.MAX_VALUE, 40);

        button.setNormalTextColor(Color.WHITE);
        button.setHoverTextColor(Color.WHITE);
        button.setNormalBackgroundColor(new Color(50, 120, 255));
        button.setHoverBackgroundColor(new Color(39, 104, 230));


        // ADD DIVIDER
        JLabel divider = UITools.createLabel("OR", 15, true);
        UITools.orientLabel(OR_LABEL, divider, Align.CENTER, 0, 0, 0, 0);
        divider.setForeground(Theme.GRAYTEXT);

        // REGISTRATION
        JLabel register_text = UITools.createLabel( "Don't have an account?",13,false);
        UITools.orientLabel(REGISTER_TEXT, register_text, Align.RIGHT, 0, 0, 0, 0);
        register_text.setForeground(Theme.GRAYTEXT);


        RoundedControl signup = new RoundedControl(RoundedControl.Type.BUTTON, 15, "SIGNUP", 13);
        signup.setControlSize((int)((380-80)*.40)-60, 18);
        signup.setBorderColor(new Color(0, 0, 0, 0));
        signup.setNormalTextColor(Theme.GRAYTEXT);
        signup.setHoverTextColor(new Color(50, 120, 255));
        signup.setNormalBackgroundColor(Color.WHITE);
        signup.setHoverBackgroundColor(Color.WHITE);


        // --- DEBUG AREA ---
        /*
        Debug.colorPanel(HEADER, Color.GREEN);
        Debug.colorPanel(FORM, Color.RED);
        Debug.colorPanel(USERFIELD, Color.BLUE);
        Debug.colorPanel(PASSFIELD, Color.ORANGE);
        Debug.colorPanel(REGISTER_TEXT, Color.GREEN);
        Debug.colorPanel(REGISTRATION, Color.RED);
        Debug.colorPanel(REGISTER_BUTTON, Color.ORANGE);


         */
        Debug.colorPanel(LEFT_LINE, Theme.GRAYTEXT);
        Debug.colorPanel(RIGHT_LINE, Theme.GRAYTEXT);


        // OBJECT ORGANIZER
        loginPanel.add(HEADER);
        loginPanel.add(FORM);

        FORM.add(USERNAME_LABEL);
        FORM.add(user_input);
        FORM.add(PASSWORD_LABEL);
        FORM.add(pass_input);
        FORM.add(Box.createVerticalStrut(40));
        FORM.add(button);
        FORM.add(Box.createVerticalStrut(20));
        FORM.add(DIVIDER);
        FORM.add(REGISTRATION);


        DIVIDER.add(LEFT_LINE);
        DIVIDER.add(OR_LABEL);
        DIVIDER.add(RIGHT_LINE);

        REGISTRATION.add(REGISTER_TEXT);
        REGISTRATION.add(REGISTER_BUTTON);

        REGISTER_BUTTON.add(Box.createHorizontalStrut(5));
        REGISTER_BUTTON.add(signup);

        // ADD TO SYSTEM
        add(loginPanel);
    }


}
