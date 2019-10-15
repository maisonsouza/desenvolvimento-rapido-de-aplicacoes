package pedido.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import pedido.model.ItemPedido;
import pedido.model.Pedido;
import pedido.view.PedidoView;

public class PedidoController {
    
    private PedidoView view;
    private Pedido pedido;
    
    public PedidoController(PedidoView view) {
        this.view = view;
       
        //associando uma lista de itens ao pedido
        pedido = new Pedido();
        pedido.setItens(new ArrayList());
        
        //adicionando acoes ao botao
        this.view.addActionBtnNovoPedido(new NovoPedidoAction());
        this.view.addActionBtnAddItem(new AdicionarItemAction());    
        this.view.addActionBtnExcluirItens(new ExcluirItensAction());  
        
        this.view.setVisible(true);
        
    }
    
    public class NovoPedidoAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //camada model
            pedido = new Pedido();
            pedido.setItens(new ArrayList());
            limparTodosCampos();
        }
    }
    
    public class AdicionarItemAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(todosCamposPreenchidos()){
                //recuperando dados da view
                String nome = view.getTxtNome();
                double valor = Double.parseDouble(view.getTxtValor());
                int quantidade = Integer.parseInt(view.getTxtQuantidade());

                //acessando a camada de modelo
                ItemPedido ip = new ItemPedido(nome, valor, quantidade);
                pedido.addItem(ip);

                //retornando resultados para a view
                String itens = "";
                for (ItemPedido item : pedido.getItens()) {
                    itens = itens + item.getNome() + " | " + item.getValor() + " | " + item.getQuantidade() + " = " + item.calcValorItem() + "\n";
                }
                view.setTxtItensPedido(itens);
                view.setLblTotal(Double.toString(pedido.calcValorTotal()));
                limparCamposItem();
            }else{
                view.setMsg("Preencha todos os campos para prosseguir!");
            }            
        }
    }
        
    public class ExcluirItensAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            pedido.getItens().clear();
            limparTodosCampos();
        }
    }
    
    
    public void limparCamposItem(){
        view.setTxtNome("");
        view.setTxtValor("");
        view.setTxtQuantidade("");
        view.getTxtNome("field").requestFocus();
    }
    
    public void limparTodosCampos(){
        limparCamposItem();
        view.setTxtItensPedido("");
        view.setLblTotal("0.00");
    }
    
    public boolean todosCamposPreenchidos(){
        if(!view.getTxtNome().equals("") 
                && !view.getTxtValor().equals("") 
                && !view.getTxtQuantidade().equals("") ){
            return true;
        }else{
            return false;
        }
    }
}
        
