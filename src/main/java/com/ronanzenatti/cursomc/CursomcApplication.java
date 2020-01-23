package com.ronanzenatti.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ronanzenatti.cursomc.domain.Categoria;
import com.ronanzenatti.cursomc.domain.Cidade;
import com.ronanzenatti.cursomc.domain.Cliente;
import com.ronanzenatti.cursomc.domain.Endereco;
import com.ronanzenatti.cursomc.domain.Estado;
import com.ronanzenatti.cursomc.domain.Produto;
import com.ronanzenatti.cursomc.domain.enums.TipoCliente;
import com.ronanzenatti.cursomc.repositories.CategoriaRepository;
import com.ronanzenatti.cursomc.repositories.CidadeRepository;
import com.ronanzenatti.cursomc.repositories.ClienteRepository;
import com.ronanzenatti.cursomc.repositories.EnderecoRepository;
import com.ronanzenatti.cursomc.repositories.EstadoRepository;
import com.ronanzenatti.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p1.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");

		Cidade cid1 = new Cidade(null, "Uberlândia", e1);
		Cidade cid2 = new Cidade(null, "São Paulo", e2);
		Cidade cid3 = new Cidade(null, "Campinas", e2);

		e1.getCidades().addAll(Arrays.asList(cid1));
		e2.getCidades().addAll(Arrays.asList(cid2, cid3));

		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		Cliente cli = new Cliente(null, "Maria Silva", "maria@silva.com", "363.789.123-77", TipoCliente.PESSOAFISICA);
		cli.getTelefones().addAll(Arrays.asList("2736-3323", "9383-8393"));

		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli, cid1);
		Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli, cid2);

		cli.enderecos.addAll(Arrays.asList(end1, end2));

		clienteRepository.save(cli);
		enderecoRepository.saveAll(Arrays.asList(end1, end2));

	}

}
