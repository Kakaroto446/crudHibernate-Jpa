package view;

import javax.swing.JFrame;

import controller.AlunosJpaDAO;
import model.Alunos;

public class App
{
    public static void main( String[] args )
    {
    	 Alunos alunos = new Alunos();
    	 alunos.setEndereco("372.468.423-53");
         alunos.setId_aluno(1);
         alunos.setNome("Jeferson Roberto de Lima");
         AlunosJpaDAO.getInstance().merge(alunos);
         System.out.println("Objetos salvo com sucesso!!!");

    }
}
