package ecommerce.ui;

import ecommerce.uiHelper.*;
import ecommerce.app.SwingUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProductPage extends JPanel {

    private final SwingUI parent;

    public ProductPage(SwingUI parent) {
        this.parent = parent;

        setOpaque(false);
        setLayout(new GridBagLayout());
        buildUI();
    }

    private void buildUI() {

        // CREATE PRODUCT PANEL
        RoundObject productPanel = UITools.createRoundPanel(Theme.PANEL,380, 490, 40);
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));

        add(productPanel);
    }
}
