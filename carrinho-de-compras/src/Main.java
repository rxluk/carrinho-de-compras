import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean process = true;
        CarrinhoDeCompras meuCarrinho = new CarrinhoDeCompras();

        while (process) {
            System.out.println("""
                    Deseja:
                    1- Adicionar Item.
                    2- Remover Item.
                    3- Calcular valor total.
                    4- Exibir Itens.
                    0- Sair.""");

            try {
                int escolha = Integer.parseInt(scanner.nextLine());
                switch (escolha) {
                    case 1 -> meuCarrinho.adicionarItem(
                            new Item(
                                scannerMsg("Nome: "),
                                Double.parseDouble(scannerMsg("Preço: ")),
                                Integer.parseInt(scannerMsg("Quantidade: "))
                            )
                    );
                    case 2 -> meuCarrinho.removerItem(scannerMsg("Nome: "));
                    case 3 -> System.out.println("Valor total: " + meuCarrinho.calcularValorTotal());
                    case 4 -> meuCarrinho.exibirItens();
                    case 0 -> process = false;
                    default -> System.out.println("Escolha inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido.");
            }
        }
        scanner.close();
    }

    private static String scannerMsg(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}
