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
        RoundedPanel loginPanel = UITools.createRoundPanel(20,Theme.PANEL,380, 480);
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.PAGE_AXIS));

        JLabel title = UITools.createLabel("LOGIN",25,  Theme.TEXT, true);
        loginPanel.add(UITools.orientLabel(title, SwingConstants.RIGHT, 50,0,0,0));


        //JLabel name = UITools.createLabel("Name", 15, Theme.TEXT, false);
        //loginPanel.add(UITools.orientLabel(name, SwingConstants.CENTER, 0,0,0,0));



        add(loginPanel);
    }


}
