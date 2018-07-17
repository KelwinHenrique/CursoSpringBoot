package com.neppo.cursospringboot.CursoSpringBoot.services;

import com.neppo.cursospringboot.CursoSpringBoot.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {


    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);
}
