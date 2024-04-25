package listaSete.src;

import java.util.Date;
import java.util.Scanner;

public class Pedido {
    public int id;
    public Loja loja = new Loja();
    public Vendedor vendedor = new Vendedor();
    public Date data = new Date();
    public Long diaEmMs = 86400000l;
    public Long dataCriacao = data.getTime(); // 86400000 é 1 dia em milissegundos
    public Long dataPagamento;
    public Long dataVencimentoReserva = (dataCriacao + (diaEmMs * 3)); // Já adiciono os 3 dias
    public Cliente cliente = new Cliente();
    public int clienteId = cliente.idCliente;
    public int lojaId = loja.id;
    public int vendedorId = vendedor.idVendedor;
    public int totalVenda;
    public Scanner option = new Scanner(System.in);
    public Scanner pedidoScanner = new Scanner(System.in);
    public Scanner itemScanner = new Scanner(System.in);
    public Scanner quantidade = new Scanner(System.in);

    public Item[] itens = new Item[99];

    public Pedido() {
        for (int i = 0; i < itens.length - 1; i++) {
            itens[i] = new Item(); // Construtor pra inicializar o array e todos os Objetos de Item entrem no array itens dessa classe
        }
    }

    public int calcularValorTotal() {
        for (int i = 0; i < itens.length - 1; i++) {
            totalVenda += itens[i].valor;
        }
        return totalVenda;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Pedido: " + id + "\nData da Criação: " + dataCriacao.toString());
    }

    public void criarPedido() {
        System.out.print("Pedido: ");
        pedidoScanner.nextInt();
        System.out.print("Id do Item: ");
        itemScanner.nextInt();
        System.out.print("Quantidade: ");
        quantidade.nextInt();
        gerarDescricaoVenda();
        calcularValorTotal();
    }
}