package com.mycompany.pos.ui.forms.customer.view;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
@Getter
public class CustomerTableBtnPanel extends JPanel {
    private JButton addBtn;
    private JButton removeBtn;

    public CustomerTableBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        addBtn = new JButton("Add new user");
        add(addBtn);

        removeBtn = new JButton("Remove");
        add(removeBtn);
    }
}
