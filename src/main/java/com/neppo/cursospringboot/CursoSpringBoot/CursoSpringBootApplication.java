package com.neppo.cursospringboot.CursoSpringBoot;

import com.neppo.cursospringboot.CursoSpringBoot.domain.Categoria;
import com.neppo.cursospringboot.CursoSpringBoot.domain.Cidade;
import com.neppo.cursospringboot.CursoSpringBoot.domain.Estado;
import com.neppo.cursospringboot.CursoSpringBoot.domain.Produto;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.CategoriaRepository;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.CidadeRepository;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.EstadoRepository;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class CursoSpringBootApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;


	public static void main(String[] args) {
		SpringApplication.run(CursoSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000);
		Produto p2 = new Produto(null, "Impressora", 800);
		Produto p3 = new Produto(null, "Mouse", 80);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));



		Estado eest1 = new Estado(null, "Minas Gerais");
		Estado eest2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", eest1);
		Cidade c2 = new Cidade(null, "São Paulo", eest2);
		Cidade c3 = new Cidade(null, "Campinas", eest2);

		eest1.getCidade().addAll(Arrays.asList(c1));
		eest2.getCidade().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(eest1, eest2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));









	}
}
