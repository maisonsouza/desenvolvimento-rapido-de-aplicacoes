/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import javax.validation.Valid;
import mvc.bean.Tarefa;
import mvc.dao.TarefaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TarefaController {
     
    private final TarefaDAO dao;
    
    @Autowired
    public TarefaController(TarefaDAO dao) {
        this.dao = dao;
    }
    
    @RequestMapping("/formAddTarefa")
    public String form(){
        return "tarefa/formAddTarefa";
    }
    
    @RequestMapping("/addTarefa")
    public String adiciona(Tarefa tarefa){
        dao.adicionaTarefa(tarefa);
        return "tarefa/tarefa-adicionada";
    } 
    
    @RequestMapping("/listaTarefas")
    public String lista(Model model){
        model.addAttribute("listaTarefas", dao.listarTarefas());
        return "tarefa/listagem-tarefas";
    }
    
    @RequestMapping("/removeTarefa")
    public String remove(Long id){
        dao.removerTarefa(id);
        return "redirect:/listaTarefas";
    }
    
    @RequestMapping("/exibeTarefa")
    public String exibe(Long id, Model model){
        model.addAttribute("tarefa", dao.buscarTarefaPorId(id));
        return "tarefa/exibe-tarefa";
    }
    
    @RequestMapping("/alteraTarefa")
    public String altera(Tarefa tarefa){
       dao.alterarTarefa(tarefa);
       return "redirect:/listaTarefas";
    }
    
    @RequestMapping("/finalizaTarefa")
    public String finaliza(Long id, Model model) {
        dao.finalizarTarefa(id);
        model.addAttribute("tarefa", dao.buscarTarefaPorId(id));
        return "tarefa/dataFinalizada";
    }
    
}