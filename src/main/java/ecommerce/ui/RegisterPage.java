package ecommerce.ui;

import ecommerce.uiHelper.*;
import ecommerce.app.SwingUI;
import javax.swing.*;
import java.awt.*;


public class RegisterPage extends JPanel {

    private final SwingUI parent;

    public RegisterPage(SwingUI parent) {
        this.parent = parent;
        setOpaque(false);
        setLayout(new GridBagLayout());
        buildUI();
    }

    private void buildUI() {
        RoundObject registerPanel = UITools.createRoundPanel(Theme.PANEL,380, 480, 40);
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));

        add(registerPanel);
    }
}
