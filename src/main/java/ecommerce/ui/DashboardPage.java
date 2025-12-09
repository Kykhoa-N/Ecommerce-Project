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
        setLayout(new BorderLayout());
        buildUI();
    }

    private void buildUI() {

        // DATA FIELD
        RoundObject Product_page_button;
        RoundObject order_page_button;
        RoundObject report_page_button;
        RoundObject logout_button;

        // CREATE SIDEBAR
        JPanel sidebar = UITools.createYContainer(220, Integer.MAX_VALUE);
        Debug.colorPanel(sidebar, Color.ORANGE);
        sidebar.setPreferredSize(new Dimension(220, 0));

        JPanel content = UITools.createYContainer(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Debug.colorPanel(content, Color.GREEN);

        // CREATE PRODUCT PANEL
        //RoundObject adminPanel = UITools.createRoundPanel(Theme.PANEL,500, 500, 40);
        //adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));

        add(sidebar, BorderLayout.WEST);
        add(content, BorderLayout.CENTER);
        //add(adminPanel);
    }
}
