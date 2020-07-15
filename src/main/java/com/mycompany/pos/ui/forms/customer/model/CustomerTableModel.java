package com.mycompany.pos.ui.forms.customer.model;

import com.mycompany.pos.entity.Customer;
import com.mycompany.pos.ui.shared.model.DefaultTableModel;
import org.springframework.stereotype.Component;


@Component
public class CustomerTableModel extends DefaultTableModel<Customer> {

    @Override
    public String[] getColumnLabels() {
        return new String[] {
                "First name",
                "Last name",
                "Birthday",
                "Phone number"
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer c = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getFirstName();
            case 1:
                return c.getLastName();
            case 2:
                return c.getBirthday();
            case 3:
                return c.getPhone();
            default:
                return "";
        }
    }
}
