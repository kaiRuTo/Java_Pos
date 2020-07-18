package com.mycompany.pos;

import com.mycompany.pos.Screens.MainUI;
import com.mycompany.pos.ui.forms.customer.controller.CustomerController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class SwingApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SwingApplication.class).headless(false).run(args);
        SwingUtilities.invokeLater(()-> {
            var ex = context.getBean(CustomerController.class);
            ex.prepareAndOpenFrame();
        });
    }
}
