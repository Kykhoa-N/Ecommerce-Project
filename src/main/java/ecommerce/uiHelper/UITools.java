package ecommerce.uiHelper;

import javax.swing.*;
import java.awt.*;

public class UITools {

    public static RoundedControl createRoundPanel(int radius, Color rgb, int width, int height) {
        RoundedControl panel = new RoundedControl(RoundedControl.Type.CONTAINER, radius);
        panel.setBackground(rgb);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setBorderColor(new Color(0,0,0,0));
        return panel;
    }

    public static RoundedControl createRoundField(RoundedControl.Type type, int radius, int width, int height) {
        RoundedControl field = new RoundedControl(type, radius);
        field.setMaximumSize(new Dimension(width, height));
        return field;
    }

    public static JPanel createXContainer(int width, int height) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setMaximumSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));
        return panel;
    }

    public static JPanel createYContainer(int width, int height) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setMaximumSize(new Dimension(width, height));


        return panel;
    }

    public static JLabel createLabel(String text, int size, boolean bold) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", bold ? Font.BOLD : Font.PLAIN, size));
        label.setForeground(Theme.TEXT);
        return label;
    }

    public static void orientLabel(JPanel panel, JLabel label, int align, int top, int left, int bottom, int right) {
        label.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));

        if(align == Align.LEFT) {
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(label);
            panel.add(Box.createHorizontalGlue());
        }
        else if(align == Align.RIGHT) {
            label.setAlignmentX(Component.RIGHT_ALIGNMENT);
            panel.add(Box.createHorizontalGlue());
            panel.add(label);
        }
        else {
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createHorizontalGlue());
            panel.add(label);
            panel.add(Box.createHorizontalGlue());
        }
    }

}
