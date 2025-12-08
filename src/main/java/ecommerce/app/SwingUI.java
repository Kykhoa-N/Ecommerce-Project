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
        RoundedPanel loginPanel = UITools.createRoundPanel(20,Theme.PANEL,350, 480);
        add(loginPanel);
    }


}
