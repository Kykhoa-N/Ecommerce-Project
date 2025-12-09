package ecommerce.ui;

import ecommerce.uiHelper.*;
import ecommerce.app.SwingUI;
import javax.swing.*;
import java.awt.*;


public class OrderPage extends JPanel {

    private final SwingUI parent;

    public OrderPage(SwingUI parent) {
        this.parent = parent;

        setOpaque(false);
        setLayout(new GridBagLayout());
        buildUI();
    }

    private void buildUI() {

        // CREATE PRODUCT PANEL
        RoundObject clientPanel = UITools.createRoundPanel(Theme.PANEL,500, 500, 40);
        clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.Y_AXIS));

        add(clientPanel);
    }
}
