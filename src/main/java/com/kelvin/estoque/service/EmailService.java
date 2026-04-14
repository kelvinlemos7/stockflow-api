package com.kelvin.estoque.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${estoque.alerta.email.destinatario}")
    private String destinatario;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarAlertaEstoqueBaixo(String nomeProduto, int quantidadeAtual) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(destinatario);
        mensagem.setSubject("⚠️ Alerta: Estoque baixo — " + nomeProduto);
        mensagem.setText(
                "Atenção!\n\n" +
                        "O produto \"" + nomeProduto + "\" está com estoque baixo.\n" +
                        "Quantidade atual: " + quantidadeAtual + " unidades.\n\n" +
                        "Providencie a reposição o quanto antes.\n\n" +
                        "— Sistema de Estoque"
        );
        mailSender.send(mensagem);
    }
}