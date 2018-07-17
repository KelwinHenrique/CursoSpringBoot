package com.neppo.cursospringboot.CursoSpringBoot;

import com.neppo.cursospringboot.CursoSpringBoot.domain.*;
import com.neppo.cursospringboot.CursoSpringBoot.domain.enums.EstadoPagamento;
import com.neppo.cursospringboot.CursoSpringBoot.domain.enums.TipoCliente;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CursoSpringBootApplication implements CommandLineRunner{




	public static void main(String[] args) {
		SpringApplication.run(CursoSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
