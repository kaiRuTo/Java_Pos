package com.mycompany.pos.ui.forms.customer.controller;

import com.mycompany.pos.entity.Customer;
import com.mycompany.pos.service.CustomerService;
import com.mycompany.pos.ui.forms.customer.model.CustomerTableModel;
import com.mycompany.pos.ui.forms.customer.view.CustomerTableBtnPanel;
import com.mycompany.pos.ui.forms.customer.view.CustomerTableFrame;
import com.mycompany.pos.ui.forms.customer.view.modal.AddCustomerFrame;
import com.mycompany.pos.ui.forms.customer.view.modal.CustomerFormBtnPanel;
import com.mycompany.pos.ui.forms.customer.view.modal.CustomerFormPanel;
import com.mycompany.pos.ui.shared.controller.AbstractFrameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerController extends AbstractFrameController {

    private CustomerTableFrame tableFrame;
    private AddCustomerFrame addFrame;
    private CustomerTableModel tableModel;
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerTableFrame tableFrame, AddCustomerFrame addFrame, CustomerTableModel tableModel, CustomerService customerService) {
        this.tableFrame = tableFrame;
        this.addFrame = addFrame;
        this.tableModel = tableModel;
        this.customerService = customerService;
    }

    @PostConstruct
    private void prepareListeners() {
        CustomerTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        CustomerFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeEntity());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveEntity());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadEntities();
        showTableFrame();
    }

    private void loadEntities() {
        List<Customer> entities = customerService.findAll();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

    private void showAddModal() {
        addFrame.setVisible(true);
    }

    private void saveEntity() {
        CustomerFormPanel formPanel = addFrame.getFormPanel();
        Customer entity = formPanel.getEntityFromForm();
        customerService.save(entity);
        tableModel.addEntity(entity);
        closeModalWindow();
    }

    private void closeModalWindow() {
        addFrame.getFormPanel().clearForm();
        addFrame.dispose();
    }

    private void removeEntity() {
        try {
            JTable clientTable = tableFrame.getTablePanel().getTable();
            int selectedRow = clientTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        "You must select a row.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Customer entity = tableModel.getEntityByRow(selectedRow);
                customerService.delete(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {

        }
    }
}
