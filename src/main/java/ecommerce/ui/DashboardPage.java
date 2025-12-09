package ecommerce.ui;

import ecommerce.uiHelper.*;
import ecommerce.app.SwingUI;
import javax.swing.*;
import java.awt.*;


public class DashboardPage extends JPanel {

    private final SwingUI parent;

    public DashboardPage(SwingUI parent) {
        this.parent = parent;

        setOpaque(false);
        setLayout(new GridBagLayout());
        buildUI();
    }

    private void buildUI() {

        // DATA FIELD
        RoundObject Product_page_button;
        RoundObject order_page_button;
        RoundObject report_page_button;
        RoundObject logout_button;


        // CREATE PRODUCT PANEL
        RoundObject adminPanel = UITools.createRoundPanel(Theme.PANEL,1000, 500, 40);
        adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));

        add(adminPanel);
    }
}
