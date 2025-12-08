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

        // CREATE SECTIONS
        JPanel HEADER = UITools.createXContainer(100);
        JPanel FORM = UITools.createYContainer(Integer.MAX_VALUE);

        // ADD TITLE TO HEADER
        JLabel title = UITools.createLabel( "LOGIN",25,true);
        UITools.orientLabel(HEADER, title, Align.CENTER, 0, 0, 0, 0);

        // ADD NAME FIELD TO FORM
        JLabel name = UITools.createLabel( "Name",15,true);
        UITools.orientLabel(FORM, name, Align.LEFT, 0, 15, 0, 50);

        Debug.colorPanel(HEADER, Color.GREEN);

        // ADD TO LOGIN PANEL
        loginPanel.add(HEADER);
        loginPanel.add(FORM);


        // ADD TO SYSTEM

        // ADD OUTER PANEL TO SCREEN
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;

        add(loginPanel, gbc);
    }


}
