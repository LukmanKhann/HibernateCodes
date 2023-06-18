package org.jsp.one2one.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.one2one.dto.Answer;
import org.jsp.one2one.dto.Question;

public class SaveQuestionAndAnser {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		Question q = new Question();
		q.setQuestion("what is hibernate");
		q.setQuestionBy("Satish sir");
		
		Answer a1 = new Answer();
		a1.setAnswer("Hibernate is ORM tool");
		a1.setAnswerBy("Abhisek");
		
		Answer a2 = new Answer();
		a2.setAnswer("hibernate is lighweight framework");
		a2.setAnswerBy("Ankit");
		
		Answer a3 = new Answer();
		a3.setAnswer("hibernate is non-invasive framework");
		a3.setAnswerBy("animesh");
		
		List<Answer> answers = new ArrayList<Answer>();
		answers.add(a1);
		answers.add(a2);
		answers.add(a3);
		
//		Assigning the answers for the question
		q.setAnswers(answers);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

		EntityTransaction transaction = manager.getTransaction();
		manager.persist(q);
		transaction.begin();
		transaction.commit();
		
        

		
	}

}
