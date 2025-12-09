package ecommerce.uiHelper;

import ecommerce.app.SwingUI;
import ecommerce.model.Role;
import ecommerce.model.User;

import java.awt.*;



public class DataTool {

    public static void routeButton(SwingUI parent, RoundObject button, String route) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                parent.showScreen(route);  // Go to register page
            }
        });
    }

}
