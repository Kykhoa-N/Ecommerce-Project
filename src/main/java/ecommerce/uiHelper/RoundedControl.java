package ecommerce.uiHelper;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedControl extends JPanel {

    // FIELD
    private JComponent component;
    private JLabel label;

    private final ObjectType objectType;
    private int textHeight = 0;
    private int borderThickness = 1;

    private Color colorBackground = Color.WHITE;
    private Color colorBorder = Theme.LIGHTGRAY;

    // BUTTON FIELD
    private Color colorHoverButton = null;
    private Color colorHoverText = null;
    private Color colorNormalButton = null;
    private Color colorNormalText = null;




    // --------- CONSTRUCTORS ---------

    // CONSTRUCTOR TYPE
    public RoundedControl(ObjectType objectType) {
        this(objectType, null, 0);
    }

    // CONSTRUCTOR TYPE WITH TEXT
    public RoundedControl(ObjectType objectType,String text, int height) {
        this.objectType = objectType;
        this.textHeight = height;

        setOpaque(false);
        configureByType(text);
    }

    // INITIALIZE BY TYPE
    private void configureByType(String text) {

        if(objectType.equals(ObjectType.PANEL)) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
        else {
            setLayout(new BorderLayout());

            switch (objectType) {

                case FIELD_TEXT -> {
                    component = styleTextComponent(new JTextField());
                    lockHeight(45);
                }

                case FIELD_PASS -> {
                    component = styleTextComponent(new JPasswordField());
                    lockHeight(45);
                }

                case BUTTON_BLOCK -> {
                    component = new JLabel(text != null ? text : "BUTTON", SwingConstants.CENTER);
                    component.setFont(new Font("Segoe UI", Font.BOLD, textHeight));
                    component.setForeground(Color.WHITE);

                    colorBackground = Theme.BLUE;

                    colorBorder = Theme.BLUE;
                    lockHeight(45);

                    setupButtonHover();
                }

                case BUTTON_TEXT -> {
                    component = new JLabel(text != null ? text : "BUTTON", SwingConstants.CENTER);
                    component.setFont(new Font("Segoe UI", Font.BOLD, textHeight));


                    colorBackground = Theme.BLUE;
                    colorBorder = Theme.BLUE;
                    lockHeight(45);

                    setupButtonHover();

                }
            }

            add(component, BorderLayout.CENTER);
        }


        // Focus highlight for text/password fields
        if (objectType == ObjectType.FIELD_TEXT || objectType == ObjectType.FIELD_PASS) {
            component.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    colorBorder = Theme.BLUE;
                    repaint();
                }

                @Override
                public void focusLost(FocusEvent e) {
                    colorBorder = new Color(200, 200, 200);
                    repaint();
                }
            });
        }
    }


    public void setColorNormalText(Color c) {
        this.colorNormalText = c;
        setForeground(c);
    }

    public void setColorHoverText(Color c) {
        this.colorHoverText = c;
    }

    public void setNormalBackgroundColor(Color c) {
        this.colorNormalButton = c;
        this.colorBackground = c;
    }

    public void setHoverBackgroundColor(Color c) {
        this.colorHoverButton = c;
    }

    private JComponent styleTextComponent(JTextComponent comp) {
        comp.setOpaque(false);
        comp.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        comp.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        return comp;
    }

    private void lockHeight(int h) {
        setPreferredSize(new Dimension(Integer.MAX_VALUE, h));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, h));
        setMinimumSize(new Dimension(Integer.MAX_VALUE, h));
    }

    private void setupButtonHover() {
        // Apply defaults only if user didn’t customize them
        if (colorNormalText == null)
            colorNormalText = getForeground();

        if (colorNormalButton == null)
            colorNormalButton = colorBackground;

        if (colorHoverText == null)
            colorHoverText = getForeground();

        if (colorHoverButton == null)
            colorHoverButton = colorBackground;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Apply hover color changes
                setForeground(colorHoverText);
                colorBackground = colorHoverButton;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restore normal colors
                setForeground(colorNormalText);
                colorBackground = colorNormalButton;
                repaint();
            }
        });
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (label != null) {
            label.setForeground(fg);  // update the label color too
        }
    }

    public void setBorderThickness(int t) {
        this.borderThickness = t;
        repaint();
    }

    public void setControlSize(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        revalidate();
        repaint();
    }

    // --------- PAINT ---------
    @Override
    protected void paintComponent(Graphics g) {
        int border_roundness = 15;

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Background
        g2.setColor(colorBackground);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), border_roundness, border_roundness);

        // Border with thickness
        g2.setColor(colorBorder);
        g2.setStroke(new BasicStroke(borderThickness));
        g2.drawRoundRect(
                borderThickness / 2,
                borderThickness / 2,
                getWidth() - borderThickness,
                getHeight() - borderThickness,
                border_roundness,
                border_roundness
        );

        super.paintComponent(g);
    }

    // --------- PUBLIC HELPERS ---------

    // For TEXT_FIELD / PASSWORD
    public String getText() {
        if (objectType == ObjectType.FIELD_TEXT && component instanceof JTextField tf) {
            return tf.getText();
        }
        if (objectType == ObjectType.FIELD_PASS && component instanceof JPasswordField pf) {
            return new String(pf.getPassword());
        }
        return "";
    }

    // If you want direct access
    public JComponent getComponent() {
        return component;
    }

    public void setColorBackground(Color c) {
        this.colorBackground = c;
        repaint();
    }

    public void setColorBorder(Color c) {
        this.colorBorder = c;
        repaint();
    }

    public ObjectType getType() {
        return objectType;
    }
}
