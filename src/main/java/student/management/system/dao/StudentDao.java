package student.management.system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import student.management.system.dto.Admin;
import student.management.system.dto.Student;

public class StudentDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sigma");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void saveStudent(Student student)
	{
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	
	}
	public List<Student> getAllStudents(Admin admin)
	{
		Query query=entityManager.createQuery("select s from Student s where s.admin=?1");
		query.setParameter(1, admin);
		List students=query.getResultList();
		return students;
	}
	public Student getStudent(int id)
	{
		return entityManager.find(Student.class, id);
		
	}
	public void updateStudent(Student student)
	{
		
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		
	}
	public void deletStudent(int id)
	{
		
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Student.class, id));
		entityTransaction.commit();
	
	}
}
