package ecommerce.uiHelper;

import ecommerce.uiHelper.*;
import javax.swing.*;
import java.awt.*;

public class UITools {

    public static RoundedPanel createRoundPanel(int radius, Color rgb, int width, int height) {
        RoundedPanel panel = new RoundedPanel(radius);
        panel.setBackground(rgb);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setShadow(15, new Color(0,0,0,1));
        return panel;
    }

}
