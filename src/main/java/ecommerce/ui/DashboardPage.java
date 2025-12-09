package ecommerce.ui;

import ecommerce.model.*;
import ecommerce.uiHelper.*;
import ecommerce.app.SwingUI;
import javax.swing.*;
import java.awt.*;


public class DashboardPage extends JPanel {

    private final SwingUI parent;

    private JPanel SIDEBAR;
    private JPanel CONTENT;
    private JPanel SIDEProfile;
    private JPanel SIDEService;
    private JPanel SIDELogout;
    RoundObject logout_button;

    public DashboardPage(SwingUI parent) {
        this.parent = parent;

        setOpaque(false);
        setLayout(new BorderLayout());
        buildUI();
    }

    public void updateForUser(User current_user) {
        if (current_user == null) return;

        SIDEProfile.removeAll();

        JLabel name_label = UITools.createLabel(SIDEProfile, current_user.getName(), 17, true, Align.LEFT);
        JLabel id_label = UITools.createLabel(SIDEProfile, current_user.getId(), 17, true, Align.LEFT);
        JLabel role_label = UITools.createLabel(SIDEProfile, current_user.getRole().name(), 13, true, Align.LEFT);
        name_label.setBorder(BorderFactory.createEmptyBorder(40, 45, 0, 0));
        id_label.setBorder(BorderFactory.createEmptyBorder(0, 45, 0, 0));
        role_label.setBorder(BorderFactory.createEmptyBorder(5, 45, 0, 0));

        name_label.setForeground(Theme.PANEL);
        id_label.setForeground(Theme.PANEL);
        role_label.setForeground(Theme.GRAY);




        SIDEProfile.revalidate();
        SIDEProfile.repaint();


        // SERVReport.setVisible(current_user.getRole() == Role.ADMIN);
    }

    private void buildUI() {

        // DATA FIELD
        RoundObject Product_page_button;
        RoundObject order_page_button;
        RoundObject report_page_button;
        RoundObject logout_button;

        // CREATE REGION
        SIDEBAR = UITools.createYContainer(Theme.DARKNAVY, 240, Integer.MAX_VALUE);
        CONTENT = UITools.createYContainer(Theme.BACKGROUND, Integer.MAX_VALUE, Integer.MAX_VALUE);

        // CREATE SECTIONS
        SIDEProfile = UITools.createYContainer(Integer.MAX_VALUE, (int)(800*0.25));
        SIDEService = UITools.createYContainer(Theme.SAGE, Integer.MAX_VALUE, (int)(800*0.60));
        SIDELogout = UITools.createYContainer(Integer.MAX_VALUE, (int)(800*0.11));

        // CREATE BLOCKS
        //JPanel PROFName = UITools.createXContainer(Theme.SAGE, Integer.MAX_VALUE, 50);
        //JPanel PROFId = UITools.createXContainer(Theme.SAGE, Integer.MAX_VALUE, 50);
        JPanel SERVStock = UITools.createXContainer(Theme.SAGE, Integer.MAX_VALUE, 50);
        JPanel SERVOrders = UITools.createXContainer(Theme.SAGE, Integer.MAX_VALUE, 50);
        JPanel SERVReport = UITools.createXContainer(Theme.SAGE, Integer.MAX_VALUE, 50);

        // CREATE PROFILE SECTION
        //JLabel name_label = UITools.createLabel(SIDEProfile, current_user.getName(),15,true, Align.LEFT);
        //JLabel id_label = UITools.createLabel(SIDEProfile, current_user.getName(),15,true, Align.LEFT);
        //JLabel role_label = UITools.createLabel(SIDEProfile, current_user.getRole().name(),15,true, Align.LEFT);


        // CREATE LOGIN SECTION
        SIDELogout.add(Box.createVerticalStrut(20));
        logout_button = UITools.createRoundButton(SIDELogout, ObjectType.BUTTON, Integer.MAX_VALUE, 40, "LOGOUT", 15);
        logout_button.setupButton(Theme.BLUE, Theme.HOVERBLUE, Theme.PANEL, Theme.PANEL);

        // ORGANIZE SECTIONS
        SIDEBAR.setLayout(new BoxLayout(SIDEBAR, BoxLayout.Y_AXIS));
        SIDEBAR.add(SIDEProfile);
        SIDEBAR.add(SIDEService);
        SIDEBAR.add(SIDELogout);

        DataTool.routeButton(parent, logout_button, "LOGIN");

        // ADD TO SYSTEM
        add(SIDEBAR, BorderLayout.WEST);
        add(CONTENT, BorderLayout.CENTER);
    }
}
