package actions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Tarefa;

public class BuscarTarefas {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
	
		
		Query consulta = manager.createQuery("select t from Tarefa t where status = :paramfinalizado");
		consulta.setParameter("paramfinalizado", true);
		
		List<Tarefa> tarefas = consulta.getResultList();

		for (Tarefa tarefa : tarefas) {

			System.out.println(tarefa.getDescricao());
		}

		manager.close();
		factory.close();
	}
}
