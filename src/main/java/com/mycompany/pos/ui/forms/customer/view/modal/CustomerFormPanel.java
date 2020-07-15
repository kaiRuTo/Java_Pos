package com.mycompany.pos.ui.forms.customer.view.modal;

import com.mycompany.pos.entity.Customer;
import com.toedter.calendar.JDateChooser;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CustomerFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 5;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;
    private static final int WIDTH = 40;
    private static final int HEIGHT = 20;

    private JTextField firstNameTF;
    private JTextField lastNameTF;
    private JDateChooser birthdayTF;
    private JTextField phoneTF;

    public CustomerFormPanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(BorderFactory.createEmptyBorder(HEIGHT, WIDTH, HEIGHT, WIDTH));
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel firstNameLbl = new JLabel("First name");
        JLabel lastNameLbl = new JLabel("Last name");
        JLabel birthdayLbl = new JLabel("Date of Birth");
        JLabel phoneLbl = new JLabel("Phone number");

        firstNameTF = new JTextField(TEXT_FIELD_COLUMNS);
        lastNameTF = new JTextField(TEXT_FIELD_COLUMNS);
        birthdayTF = new JDateChooser();
        phoneTF = new JTextField(TEXT_FIELD_COLUMNS);

        add(firstNameLbl);
        add(firstNameTF);
        add(lastNameLbl);
        add(lastNameTF);
        add(birthdayLbl);
        add(birthdayTF);
        add(phoneLbl);
        add(phoneTF);
    }

    public Customer getEntityFromForm() {
        Customer customer = new Customer();
        customer.setFirstName(firstNameTF.getText());
        customer.setLastName(lastNameTF.getText());
        customer.setBirthday(birthdayTF.getDate());
        customer.setPhone(phoneTF.getText());

        return customer;
    }

    public void clearForm() {
        firstNameTF.setText("");
        lastNameTF.setText("");
        birthdayTF.setDate(null);
        phoneTF.setText("");
    }
}
