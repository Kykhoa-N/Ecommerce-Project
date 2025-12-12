package ecommerce.ui;

import ecommerce.model.*;
import ecommerce.service.*;
import ecommerce.uiHelper.*;
import ecommerce.app.SwingUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class InventoryPage extends JPanel {

    private final SwingUI parent;

    public InventoryPage(SwingUI parent) {
        this.parent = parent;

        setOpaque(false);
        setLayout(new GridBagLayout());
        buildUI();
    }

    private void buildUI() {

        // CREATE INVENTORY PANEL
        RoundObject inventoryPanel = UITools.createRoundPanel(Theme.BLUE,(int) (parent.getWidth()*0.8313), (int) (parent.getHeight()*.9549), 40);
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));

        add(inventoryPanel);
    }
}
