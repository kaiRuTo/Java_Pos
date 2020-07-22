package com.mycompany.pos;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.pos.Screens.Dialog.LoginDialog;
import com.mycompany.pos.Screens.MainUI;
import com.mycompany.pos.ui.forms.customer.controller.CustomerController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SwingApplication {
    private static ConfigurableApplicationContext _context;
    
    public static void main(String[] args) {
        FlatLightLaf.install();
        _context = new SpringApplicationBuilder(SwingApplication.class).headless(false).run(args);
        SwingUtilities.invokeLater(()-> {
            var ex = _context.getBean(LoginDialog.class);
            if (ex.checkUser())
                ex.setVisible(true);
            else 
                openMainScreen();
        });
    }
    
    public static void openMainScreen() {
        var exLogin = _context.getBean(LoginDialog.class);
        exLogin.dispose();
        var ex = _context.getBean(MainUI.class);
        ex.setVisible(true);
    }
}
