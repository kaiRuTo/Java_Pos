package com.mycompany.pos.ui.forms.customer.view;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
@Getter
public class CustomerTableFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 300;

    private CustomerTableBtnPanel tableBtnPanel;
    private CustomerTablePanel tablePanel;

    @Autowired
    public CustomerTableFrame(CustomerTableBtnPanel customerTableBtnPanel, CustomerTablePanel customerTablePanel) {
        this.tableBtnPanel = customerTableBtnPanel;
        this.tablePanel = customerTablePanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle("User list");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }
}
