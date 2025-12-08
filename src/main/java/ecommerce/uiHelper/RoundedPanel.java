package ecommerce.uiHelper;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {
    private final int cornerRadius;
    private int shadowSize = 10;
    private Color shadowColor = new Color(0, 0, 0, 50); // semi-transparent shadow

    public RoundedPanel(int radius) {
        this.cornerRadius = radius;
        setOpaque(false);
    }

    public void setShadow(int size, Color color) {
        this.shadowSize = size;
        this.shadowColor = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = shadowSize;
        int y = shadowSize;
        int width = getWidth() - shadowSize * 2;
        int height = getHeight() - shadowSize * 2;

        // Draw shadow
        g2.setColor(shadowColor);
        g2.fillRoundRect(x - shadowSize / 2, y - shadowSize / 2,
                width + shadowSize, height + shadowSize,
                cornerRadius, cornerRadius);

        // Draw panel body
        g2.setColor(getBackground());
        g2.fillRoundRect(x, y, width, height, cornerRadius, cornerRadius);

        super.paintComponent(g);
    }
}