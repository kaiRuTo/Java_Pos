package com.mycompany.pos;

import com.mycompany.pos.ui.forms.customer.controller.CustomerController;
import com.mycompany.pos.ui.forms.customer.view.CustomerTableFrame;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

@SpringBootApplication
@EnableJpaAuditing
public class SwingApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SwingApplication.class).headless(false).run(args);
        SwingUtilities.invokeLater(()-> {
            var ex = context.getBean(CustomerController.class);
            ex.prepareAndOpenFrame();
        });
    }
}
