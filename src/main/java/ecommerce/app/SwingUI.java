package ecommerce.app;

import ecommerce.repo.*;
import ecommerce.service.*;
import ecommerce.ui.*;
import ecommerce.uiHelper.*;
import java.awt.*;
import javax.swing.*;

public class SwingUI extends JFrame{

    private CardLayout cardLayout;
    private JPanel cardPanel;

    // REPO FIELD
    private final CartRepo cartRepo = new CartRepo();
    private final OrderRepo orderRepo = new OrderRepo();
    private final ProductRepo productRepo = new ProductRepo();
    private final UserRepo userRepo = new UserRepo();

    // SERVICE FIELD
    private final AuthService authService = new AuthService(userRepo);
    private final CartService cartService = new CartService(cartRepo, productRepo);
    private final OrderService orderService = new OrderService(orderRepo);
    private final ProductService productService = new ProductService(productRepo, orderRepo, cartRepo);
    private final ReportService reportService = new ReportService(orderRepo, productRepo);

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
        RegisterPage register = new RegisterPage(this, authService);

        cardPanel.add(register, "REGISTER");
        cardPanel.add(login, "LOGIN");
    }

    public void showScreen(String name) {
        cardLayout.show(cardPanel, name);
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }
}
