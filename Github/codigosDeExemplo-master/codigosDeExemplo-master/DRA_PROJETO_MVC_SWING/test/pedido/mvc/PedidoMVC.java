package pedido.mvc;

import pedido.controller.PedidoController;
import pedido.view.PedidoView;

public class PedidoMVC {
    
    public static void main(String[] args) {
        PedidoView view = new PedidoView();
        PedidoController controller = new PedidoController(view);
        view.setVisible(true);
    }
    
}
