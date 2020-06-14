package com.llnunes.cursomc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.llnunes.cursomc.domain.Categoria;
import com.llnunes.cursomc.domain.Cidade;
import com.llnunes.cursomc.domain.Cliente;
import com.llnunes.cursomc.domain.Endereco;
import com.llnunes.cursomc.domain.Estado;
import com.llnunes.cursomc.domain.ItemPedido;
import com.llnunes.cursomc.domain.Pagamento;
import com.llnunes.cursomc.domain.PagamentoBoleto;
import com.llnunes.cursomc.domain.PagamentoCartao;
import com.llnunes.cursomc.domain.Pedido;
import com.llnunes.cursomc.domain.Produto;
import com.llnunes.cursomc.domain.enums.EstadoPagamento;
import com.llnunes.cursomc.domain.enums.TipoCliente;
import com.llnunes.cursomc.repositories.CategoriaRepository;
import com.llnunes.cursomc.repositories.CidadeRepository;
import com.llnunes.cursomc.repositories.ClienteRepository;
import com.llnunes.cursomc.repositories.EnderecoRepository;
import com.llnunes.cursomc.repositories.EstadoRepository;
import com.llnunes.cursomc.repositories.ItemPedidoRepository;
import com.llnunes.cursomc.repositories.PagamentoRepository;
import com.llnunes.cursomc.repositories.PedidoRepository;
import com.llnunes.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		init();
	}

	private void init() throws ParseException {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Pet shop");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletronicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		Categoria cat8 = new Categoria(null, "Mercearia");
		Categoria cat9 = new Categoria(null, "Rotisseria");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 20.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().add(c1);
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);

		cli1.getTelefones().addAll(Arrays.asList("61991202101", "61991132110"));

		Endereco e1 = new Endereco(null, "Rua flores", "300", "Apto 303", "Jardim", "72001600", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "72001610", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		Pedido ped1 = new Pedido(null, sdf.parse("01/05/2020 10:00"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("01/05/2020 12:00"), cli1, e2);

		Pagamento pg1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pg1);

		Pagamento pg2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("06/06/2020 10:00"), null);
		ped2.setPagamento(pg2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pg1, pg2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 2000.0);
		ItemPedido ip2 = new ItemPedido(ped1, p2, 0.0, 2, 80.0);
		ItemPedido ip3 = new ItemPedido(ped1, p2, 100.0, 1, 800.0);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().add(ip1);
		p2.getItens().add(ip3);
		p3.getItens().add(ip2);

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
