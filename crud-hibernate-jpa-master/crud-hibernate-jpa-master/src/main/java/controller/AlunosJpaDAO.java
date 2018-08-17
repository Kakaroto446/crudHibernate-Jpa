package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Alunos;
 
public class AlunosJpaDAO {
 
         private static AlunosJpaDAO instance;
         protected EntityManager entityManager;
         
         public static AlunosJpaDAO getInstance(){
                   if (instance == null){
                            instance = new AlunosJpaDAO();
                   }
                   
                   return instance;
         }
 
         private AlunosJpaDAO() {
                   entityManager = getEntityManager();
         }
 
         private EntityManager getEntityManager() {
                   EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
                   if (entityManager == null) {
                            entityManager = factory.createEntityManager();
                   }
 
                   return entityManager;
         }
 
         public Alunos getById(final int id) {
                   return entityManager.find(Alunos.class, id);
         }
 
         @SuppressWarnings("unchecked")
         public List<Alunos> findAll() {
                   return entityManager.createQuery("FROM " + Alunos.class.getName()).getResultList();
         }
 
         public void persist(Alunos aluno) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.persist(aluno);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void merge(Alunos aluno) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.merge(aluno);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void remove(Alunos aluno) {
                   try {
                            entityManager.getTransaction().begin();
                            aluno = entityManager.find(Alunos.class, aluno.getId_aluno());
                            entityManager.remove(aluno);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void removeById(final int id) {
                   try {
                            Alunos aluno = getById(id);
                            remove(aluno);
                   } catch (Exception ex) {
                            ex.printStackTrace();
                   }
         }
 
}