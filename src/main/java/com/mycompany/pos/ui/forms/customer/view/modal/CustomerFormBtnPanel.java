package com.mycompany.pos.ui.forms.customer.view.modal;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
@Getter
public class CustomerFormBtnPanel extends JPanel {
    private JButton saveBtn;
    private JButton cancelBtn;

    public CustomerFormBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        saveBtn = new JButton("Add");
        add(saveBtn);

        cancelBtn = new JButton("Cancel");
        add(cancelBtn);
    }
}
