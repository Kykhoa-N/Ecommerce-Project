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
    private final ProductService productService;

    private  JPanel TOOLBAR;
    private  JPanel CONTENT;

    public InventoryPage(SwingUI parent, ProductService productService) {
        this.parent = parent;
        this.productService = productService;

        setOpaque(false);
        setLayout(new BorderLayout());
        buildUI();
    }

    private void buildUI() {

        // CREATE REGION
        TOOLBAR = UITools.createXContainer(Theme.SAGE, Integer.MAX_VALUE, 100);
        CONTENT = UITools.createYContainer(Theme.BACKGROUND, Integer.MAX_VALUE, Integer.MAX_VALUE);

        // ADD TO SYSTEM
        add(TOOLBAR, BorderLayout.NORTH);
        add(CONTENT, BorderLayout.CENTER);
    }
}
