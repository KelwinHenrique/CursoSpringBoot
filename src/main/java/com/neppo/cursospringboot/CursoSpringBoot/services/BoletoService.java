package com.neppo.cursospringboot.CursoSpringBoot.services;

import com.neppo.cursospringboot.CursoSpringBoot.domain.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class BoletoService {

    public void preencherPgamentoComBoleto(PagamentoComBoleto pagto, Date instatntePedido){
        Calendar cal = Calendar.getInstance();
        cal.setTime(instatntePedido);
        cal.add(Calendar.DAY_OF_MONTH,7);
        pagto.setDataVencimento(cal.getTime());

    }
}
