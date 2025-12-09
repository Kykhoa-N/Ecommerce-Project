package ecommerce.app;

import ecommerce.ui.LoginPage;
import ecommerce.ui.RegisterPage;
import ecommerce.uiHelper.*;
import javax.swing.*;
import java.awt.*;
import ecommerce.uiHelper.ObjectType;

public class SwingUI extends JFrame{

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public SwingUI() {

        initGUI(); // Window Setup
        initScreens(); // Login Panel setup
        setVisible(true); // End
    }

    public void initGUI() {
        setTitle("Ecommerce Store");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the CardLayout + card panel
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(Theme.BACKGROUND);

        // Use the cardPanel as the main content of the frame
        setContentPane(cardPanel);
    }

    private void initScreens() {
        LoginPage login = new LoginPage(this);
        RegisterPage register = new RegisterPage(this);

        cardPanel.add(login, "LOGIN");
        cardPanel.add(register, "REGISTER");
    }

    public void showScreen(String name) {
        cardLayout.show(cardPanel, name);
    }
}
