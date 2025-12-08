package ecommerce.uiHelper;

import javax.swing.*;
import java.awt.*;

public class UITools {

    public static RoundedPanel createRoundPanel(int radius, Color rgb, int width, int height) {
        RoundedPanel panel = new RoundedPanel(radius);
        panel.setBackground(rgb);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setShadow(15, new Color(0,0,0,1));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        return panel;
    }

    public static JPanel createXContainer(int height) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(Integer.MAX_VALUE, height));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));
        panel.setMinimumSize(new Dimension(Integer.MAX_VALUE, height));
        return panel;
    }

    public static JPanel createYContainer(int height) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));


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

    public static JTextField createField() {
        JTextField field = new JTextField();
        return field;
    }

}
