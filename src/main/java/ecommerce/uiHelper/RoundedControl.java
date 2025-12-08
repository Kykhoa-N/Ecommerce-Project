package ecommerce.uiHelper;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedControl extends JPanel {

    public enum Type {
        CONTAINER,
        TEXT_FIELD,
        PASSWORD_FIELD,
        BUTTON
    }

    private final int radius;
    private final Type type;

    private Color bgColor = Color.WHITE;
    private Color borderColor = new Color(200, 200, 200);
    private Color focusColor = new Color(80, 140, 255);
    private Color buttonColor = new Color(50, 120, 255);
    private Color buttonHoverColor = new Color(70, 140, 255);
    private int borderThickness = 1;


    private JComponent inner;      // JTextField, JPasswordField, or JLabel for button

    // --------- CONSTRUCTORS ---------

    // Generic container
    public RoundedControl(Type type, int radius) {
        this(type, radius, null);
    }

    // For TEXT_FIELD / PASSWORD_FIELD / BUTTON (with label text)
    public RoundedControl(Type type, int radius, String text) {
        this.radius = radius;
        this.type = type;

        setOpaque(false);
        initLayout(text);
    }

    // --------- INITIALIZE BY TYPE ---------
    private void initLayout(String text) {
        if (type == Type.CONTAINER) {
            // You can set any layout from outside
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            return;
        }

        setLayout(new BorderLayout());

        if (type == Type.TEXT_FIELD) {
            JTextField tf = new JTextField();
            styleTextComponent(tf);
            inner = tf;
            add(inner, BorderLayout.CENTER);
            fixHeight(45);

        } else if (type == Type.PASSWORD_FIELD) {
            JPasswordField pf = new JPasswordField();
            styleTextComponent(pf);
            inner = pf;
            add(inner, BorderLayout.CENTER);
            fixHeight(45);

        } else if (type == Type.BUTTON) {
            JLabel label = new JLabel(text != null ? text : "BUTTON", SwingConstants.CENTER);
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Segoe UI", Font.BOLD, 16));

            inner = label;
            add(inner, BorderLayout.CENTER);

            bgColor = buttonColor;
            borderColor = buttonColor;
            fixHeight(45);

            setupButtonHover();
        }

        // Focus highlight for text/password fields
        if (type == Type.TEXT_FIELD || type == Type.PASSWORD_FIELD) {
            inner.addFocusListener(new java.awt.event.FocusAdapter() {
                @Override
                public void focusGained(java.awt.event.FocusEvent e) {
                    borderColor = focusColor;
                    repaint();
                }

                @Override
                public void focusLost(java.awt.event.FocusEvent e) {
                    borderColor = new Color(200, 200, 200);
                    repaint();
                }
            });
        }
    }

    private void styleTextComponent(JTextComponent comp) {
        comp.setOpaque(false);
        comp.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        comp.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    }

    private void fixHeight(int h) {
        setPreferredSize(new Dimension(Integer.MAX_VALUE, h));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, h));
        setMinimumSize(new Dimension(Integer.MAX_VALUE, h));
    }

    private void setupButtonHover() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bgColor = buttonHoverColor;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bgColor = buttonColor;
                repaint();
            }
        });
    }

    public void setBorderThickness(int t) {
        this.borderThickness = t;
        repaint();
    }

    // --------- PAINT ---------
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Background
        g2.setColor(bgColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Border with thickness
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(borderThickness));
        g2.drawRoundRect(
                borderThickness / 2,
                borderThickness / 2,
                getWidth() - borderThickness,
                getHeight() - borderThickness,
                radius,
                radius
        );

        super.paintComponent(g);
    }

    // --------- PUBLIC HELPERS ---------

    // For TEXT_FIELD / PASSWORD_FIELD
    public String getText() {
        if (type == Type.TEXT_FIELD && inner instanceof JTextField tf) {
            return tf.getText();
        }
        if (type == Type.PASSWORD_FIELD && inner instanceof JPasswordField pf) {
            return new String(pf.getPassword());
        }
        return "";
    }

    // If you want direct access
    public JComponent getInner() {
        return inner;
    }

    public void setBackgroundColor(Color c) {
        this.bgColor = c;
        repaint();
    }

    public void setBorderColor(Color c) {
        this.borderColor = c;
        repaint();
    }

    public Type getType() {
        return type;
    }
}
