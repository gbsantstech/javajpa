package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Tarefa;

public class AtualizarTarefa {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		Tarefa tarefa = manager.find(Tarefa.class, 1L);
		
		manager.getTransaction().begin();
		
		tarefa.setDescricao("Estudar para a recuperação de Estrutura de dados");
		
		manager.getTransaction().commit();
		
		System.out.println("Atualizado com sucesso!");
		manager.close();
		factory.close();
	}

}
