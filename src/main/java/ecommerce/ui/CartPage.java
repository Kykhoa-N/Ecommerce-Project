package ecommerce.ui;

import ecommerce.model.*;
import ecommerce.service.*;
import ecommerce.uiHelper.*;
import ecommerce.app.SwingUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CartPage extends JPanel {

    private final SwingUI parent;

    public CartPage(SwingUI parent) {
        this.parent = parent;

        setOpaque(false);
        setLayout(new GridBagLayout());
        buildUI();
    }

    private void buildUI() {

        // CREATE CART PANEL
        RoundObject cartPanel = UITools.createRoundPanel(Theme.SAGE,(int) (parent.getWidth()*0.8313), (int) (parent.getHeight()*.9549), 40);
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));

        add(cartPanel);
    }
}
