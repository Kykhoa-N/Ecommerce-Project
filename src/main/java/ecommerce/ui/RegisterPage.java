package ecommerce.ui;

import ecommerce.uiHelper.*;
import ecommerce.app.SwingUI;
import javax.swing.*;
import java.awt.*;


public class RegisterPage extends JPanel {

    private final SwingUI parent;

    public RegisterPage(SwingUI parent) {
        this.parent = parent;
        setOpaque(false);
        setLayout(new GridBagLayout());
        buildUI();
    }

    private void buildUI() {

        // DATA FIELD
        RoundObject user_name_field;
        RoundObject user_id_field;
        RoundObject user_role_field;
        RoundObject auth_register_button;
        RoundObject login_page_button;

        RoundObject registerPanel = UITools.createRoundPanel(Theme.PANEL,380, 480, 40);
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));

        // INIT REGION
        JPanel HEADER = UITools.createXContainer(Integer.MAX_VALUE, 25);
        JPanel FORM = UITools.createYContainer(Integer.MAX_VALUE, Integer.MAX_VALUE);

        // INIT SECTIONS
        JPanel FORMUser = UITools.createYContainer(Integer.MAX_VALUE,100);
        JPanel FORMPass = UITools.createYContainer(Integer.MAX_VALUE,100);
        JPanel FORMRole = UITools.createYContainer(Integer.MAX_VALUE,100);
        JPanel FORMRegister = UITools.createYContainer(Integer.MAX_VALUE,40);
        JPanel FORMDivider = UITools.createXContainer(Integer.MAX_VALUE,50);
        JPanel FORMLogin = UITools.createXContainer(Integer.MAX_VALUE,50);

        // INIT BLOCKS
        JPanel USERLabel = UITools.createXContainer(Integer.MAX_VALUE,50);
        JPanel USERField = UITools.createYContainer(Integer.MAX_VALUE,50);
        JPanel PASSLabel = UITools.createXContainer(Integer.MAX_VALUE,50);
        JPanel PASSField = UITools.createYContainer(Integer.MAX_VALUE,50);
        JPanel ROLELabel = UITools.createXContainer(Integer.MAX_VALUE,50);
        JPanel ROLEField = UITools.createYContainer(Integer.MAX_VALUE,50);
        JPanel DIVLeft = UITools.createXContainer(255/2, 1);
        JPanel DIVText = UITools.createXContainer(45,50);
        JPanel DIVRight = UITools.createXContainer(255/2, 1);
        JPanel LOGText = UITools.createXContainer(180, Integer.MAX_VALUE);
        JPanel LOGButton = UITools.createXContainer(120,Integer.MAX_VALUE);



        // -- DEBUG AREA --
        Debug.colorPanel(HEADER, Color.ORANGE);
        Debug.colorPanel(FORM, Color.BLUE);


        // SECTION ORGANIZER
        registerPanel.add(HEADER);
        registerPanel.add(FORM);

        // SEGMENT ORGANIZER
        FORM.add(FORMUser);
        FORM.add(FORMPass);
        FORM.add(Box.createVerticalStrut(40));
        FORM.add(FORMLogin);
        FORM.add(Box.createVerticalStrut(20));
        FORM.add(FORMDivider);
        FORM.add(FORMRegister);

        // AREA ORGANIZER
        FORMUser.add(USERLabel);
        FORMUser.add(USERField);

        FORMPass.add(PASSLabel);
        FORMPass.add(PASSField);

        FORMDivider.add(DIVLeft);
        FORMDivider.add(DIVText);
        FORMDivider.add(DIVRight);

        FORMRegister.add(LOGText);
        FORMRegister.add(LOGButton);

        LOGButton.add(Box.createHorizontalStrut(5));
        //LOGButton.add(login_page_button);

        // DATA MANAGER
        add(registerPanel);
    }
}
