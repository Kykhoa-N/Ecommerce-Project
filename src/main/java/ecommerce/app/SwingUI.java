package ecommerce.app;

import ecommerce.model.*;
import ecommerce.repo.*;
import ecommerce.service.*;
import ecommerce.ui.*;
import ecommerce.uiHelper.*;
import java.awt.*;
import javax.swing.*;

public class SwingUI extends JFrame{

    private JPanel cardPanel;
    private CardLayout cardLayout;
    private User current_user;

    // DIMENSION
    private final int width = 1500;
    private final int height = 800;

    // PAGE FIELD
    DashboardPage dashboardPage;

    // REPO FIELD
    private final UserRepo userRepo = new UserRepo();

    // SERVICE FIELD
    private final AuthService authService = new AuthService(userRepo);

    public SwingUI() {

        /* Test Helper
        User user = new User("John", "Wick", Role.ADMIN);
        productService.add(user, "Banana", "Fruit", 2.17, 20);
        productService.add(user, "Apple", "Fruit", 1.56, 20);
        productService.add(user, "Milk", "Produce", 5.31, 20);
        productService.add(user, "Sausage", "Meat", 6.42, 20);
        productService.add(user, "Turkey", "Meat", 8.18, 20);
        productService.add(user, "Eggs", "Produce", 2.99, 20);
         */

        initGUI(); // Window Setup
        initScreens(); // Login Panel setup
        setVisible(true); // End
    }

    public void initGUI() {
        setTitle("Ecommerce Store");
        setSize(width, height);
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
        LoginPage loginPage = new LoginPage(this, authService);
        RegisterPage registerPage = new RegisterPage(this, authService);
        dashboardPage = new DashboardPage(this);

        cardPanel.add(dashboardPage, "DASHBOARD");
        cardPanel.add(loginPage, "LOGIN");
        cardPanel.add(registerPage, "REGISTER");
    }

    public void showScreen(String name) {
        cardLayout.show(cardPanel, name);
    }

    public User getCurrentUser() {
        return current_user;
    }

    public void setCurrentUser(User user) {
        this.current_user = user;
    }

    public DashboardPage getDashboard() {
        return dashboardPage;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
