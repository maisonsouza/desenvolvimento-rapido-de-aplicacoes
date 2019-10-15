package jpa.basics.dao;

import jpa.basics.connectionfactory.ConnectionFactory;
import jpa.basics.model.Curso;

public class TesteCursoDAO {

    public static void main(String[] args) {
        
        CursoDAO dao = new CursoDAO(ConnectionFactory.getEntityManager());
        
        //inserindo
        Curso curso = new Curso("TECAMB", "Técnico em Meio Ambiente");
        dao.save(curso);
        
        long idCursoInserido = curso.getIdCurso();
        
        
        //atualizando
        curso = dao.findById(idCursoInserido);
        curso.setSigla("TECAMBNT");
        dao.update(curso);
        
        //recuperando
        curso = dao.findById(idCursoInserido);
        System.out.println("-" + curso.getSigla() + " : " + curso.getDescricao());
        
        ConnectionFactory.closeEntityFactory();
        
    }
    
}
