import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    List<Item> itensCarrinho;

    public CarrinhoDeCompras() {
        itensCarrinho = new ArrayList<>();
    }

    public void adicionarItem(Item produto) {
        itensCarrinho.add(produto);
    }
    public void removerItem(String nome) {
        List<Item> itensCarrinhoRemove = new ArrayList<>();
        for(Item i : itensCarrinho) if(i.getNome().equals(nome)) itensCarrinhoRemove.add(i);
        itensCarrinho.removeAll(itensCarrinhoRemove);
    }
    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for(Item i : itensCarrinho) valorTotal += i.getPreco();
        return valorTotal;
    }
    public void exibirItens() {
        if(itensCarrinho.isEmpty()){
            System.out.println("A lista está vazia!");
            return;
        }
        itensCarrinho.sort((o1, o2) -> {
            int nome = o1.getNome().compareTo(o2.getNome());
            if (nome != 0) return nome;
            int preco = Double.compare(o1.getPreco(), o2.getPreco());
            if (preco != 0) return preco;
            return Integer.compare(o1.getQuantidade(), o2.getQuantidade());
        });
        for (Item i : itensCarrinho)
            System.out.println("Nome: " + i.getNome() + " Preco: " + i.getPreco() +
                    "Quantidade: " + i.getQuantidade() + "\n");
    }
}