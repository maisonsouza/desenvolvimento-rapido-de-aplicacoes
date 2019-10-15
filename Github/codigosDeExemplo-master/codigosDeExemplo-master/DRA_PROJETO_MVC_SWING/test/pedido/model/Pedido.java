package pedido.model;

import java.util.List;

public class Pedido {
    
    private List<ItemPedido> itens;

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
    
    public void addItem(ItemPedido item){
        itens.add(item);
    }
    
    public double calcValorTotal(){
        double total = 0.0;
        for (ItemPedido item : itens) {
            total = total + item.calcValorItem();
        }
        return total;
    }
    
    
}
