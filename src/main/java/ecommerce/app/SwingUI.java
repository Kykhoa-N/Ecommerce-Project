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
        RoundedPanel loginPanel = UITools.createRoundPanel(20,Theme.PANEL,380, 480);
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(15+30, 15+30, 15+30, 15+30));

        // CREATE SECTIONS
        JPanel HEADER = UITools.createXContainer(70);
        JPanel FORM = UITools.createYContainer(Integer.MAX_VALUE);
        JPanel USERFIELD = UITools.createXContainer(50);
        JPanel PASSFIELD = UITools.createXContainer(50);

        // ADD TITLE TO HEADER
        JLabel title = UITools.createLabel( "LOGIN",25,true);
        UITools.orientLabel(HEADER, title, Align.CENTER, 0, 0, 0, 0);

        // ADD NAME FIELD TO FORM
        JLabel username = UITools.createLabel( "Username",15,true);
        UITools.orientLabel(USERFIELD, username, Align.LEFT, 20, 0, 0, 0);
        JTextField user_input = new JTextField();
        user_input.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        FORM.add(USERFIELD);
        FORM.add(user_input);

        // ADD NAME FIELD TO FORM
        JLabel password = UITools.createLabel( "Password",15,true);
        UITools.orientLabel(PASSFIELD, password, Align.LEFT, 20, 0, 0, 0);
        JTextField pass_input = new JTextField();
        pass_input.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        FORM.add(PASSFIELD);
        FORM.add(pass_input);

        // --- DEBUG AREA ---
        Debug.colorPanel(HEADER, Color.GREEN);
        Debug.colorPanel(FORM, Color.RED);
        Debug.colorPanel(USERFIELD, Color.BLUE);
        Debug.colorPanel(PASSFIELD, Color.ORANGE);

        // ADD TO LOGIN PANEL
        loginPanel.add(HEADER);
        loginPanel.add(FORM);

        // ADD TO SYSTEM
        add(loginPanel);
    }


}
