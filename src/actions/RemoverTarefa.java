package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import model.Tarefa;

public class RemoverTarefa {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		Tarefa tarefa = manager.find(Tarefa.class, 2L);
		
		manager.getTransaction().begin();
		manager.remove(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa removida com sucesso!");
		
		manager.close();
		factory.close();
		
	}
}
