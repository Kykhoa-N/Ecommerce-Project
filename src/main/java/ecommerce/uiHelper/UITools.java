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

    public static JLabel createLabel(String text, int size, Color color, boolean bold) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", bold ? Font.BOLD : Font.PLAIN, size));
        label.setForeground(color);
        return label;
    }

    public static JLabel orientLabel(JLabel label, int alignment, int top, int left, int bottom, int right) {
        label.setHorizontalAlignment(alignment);
        label.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));

        /*
        // stretch so alignment + text alignment matter
        label.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, label.getPreferredSize().height)
        );

        // control TEXT alignment inside the label
        if (alignment == Component.CENTER_ALIGNMENT) {
            label.setHorizontalAlignment(SwingConstants.CENTER);
        } else if (alignment == Component.LEFT_ALIGNMENT) {
            label.setHorizontalAlignment(SwingConstants.LEFT);
        } else if (alignment == Component.RIGHT_ALIGNMENT) {
            label.setHorizontalAlignment(SwingConstants.RIGHT);
        }


         */
        return label;
    }

}
