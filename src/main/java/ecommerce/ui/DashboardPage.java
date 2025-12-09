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

        // CREATE REGION
        JPanel SIDEBAR = UITools.createYContainer(Theme.DARKNAVY, 240, Integer.MAX_VALUE);
        JPanel CONTENT = UITools.createYContainer(Theme.BACKGROUND, Integer.MAX_VALUE, Integer.MAX_VALUE);

        // CREATE SECTIONS
        JPanel SIDEProfile = UITools.createYContainer(Theme.BLUE, Integer.MAX_VALUE, (int)(parent.getHeight()*0.25));
        JPanel SIDEService = UITools.createYContainer(Theme.NAVY, Integer.MAX_VALUE, (int)(parent.getHeight()*0.60));
        JPanel SIDELogout = UITools.createXContainer(Theme.SAGE, Integer.MAX_VALUE, (int)(parent.getHeight()*0.11));

        // CREATE BLOCKS
        JPanel PROFName = UITools.createXContainer(Theme.SAGE, Integer.MAX_VALUE, 50);
        JPanel PROFId = UITools.createXContainer(Theme.SAGE, Integer.MAX_VALUE, 50);
        JPanel SERVStock = UITools.createXContainer(Theme.SAGE, Integer.MAX_VALUE, 50);
        JPanel SERVOrders = UITools.createXContainer(Theme.SAGE, Integer.MAX_VALUE, 50);
        JPanel SERVReport = UITools.createXContainer(Theme.SAGE, Integer.MAX_VALUE, 50);


        // ORGANIZE SECTIONS
        SIDEBAR.add(SIDEProfile);
        SIDEBAR.add(SIDEService);
        SIDEBAR.add(SIDELogout);

        // ADD TO SYSTEM
        add(SIDEBAR, BorderLayout.WEST);
        add(CONTENT, BorderLayout.CENTER);
    }
}
