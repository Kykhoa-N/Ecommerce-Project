package ecommerce.uiHelper;

import javax.swing.*;
import java.awt.*;

public class UITools {

    public static RoundedControl createRoundPanel(Color rgb, int width, int height, int padding) {
        RoundedControl panel = new RoundedControl(ObjectType.PANEL);

        panel.setBackground(rgb);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        panel.setColorBorder(new Color(0,0,0,0));
        return panel;
    }

    public static RoundedControl createRoundField(JPanel panel, ObjectType objectType, int width, int height) {
        RoundedControl field = new RoundedControl(objectType);
        field.setMaximumSize(new Dimension(width, height));
        panel.setOpaque(true);
        panel.setBackground(new Color(255,225,255, 0));
        panel.add(field);
        return field;
    }

    public static RoundedControl createRoundButton(JPanel panel, ObjectType objectType, int width, int height, String text, int text_height) {
        RoundedControl button = new RoundedControl(objectType, text, text_height);
        button.setControlSize(width, height);

        button.setColorNormalText(Color.WHITE);
        button.setColorHoverText(Color.WHITE);
        button.setNormalBackgroundColor(Theme.BLUE);
        button.setHoverBackgroundColor(Theme.HOVERBLUE);
        panel.add(button);

        return button;
    }

    public static JLabel createLabel(JPanel panel, String text, int size, boolean bold, int align) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", bold ? Font.BOLD : Font.PLAIN, size));
        label.setForeground(Theme.TEXT);


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
        return label;
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
        panel.setMinimumSize(new Dimension(0, height));


        return panel;
    }

}
