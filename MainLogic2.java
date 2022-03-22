package com.motivity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class MainLogic2 {
	public static void main(String[] args) {
		
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.xml").build();
		Metadata me=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=me.getSessionFactoryBuilder().build();
		Session se=sf.openSession();
		Transaction tx=se.beginTransaction();
		
		/*Employeer empr=new Employeer();
		empr.setEmployer_id(102);
		empr.setEmployer_name("Ram");
		empr.setDepartment("Technical");
		empr.setMobile(9390312100l);*/
		
		Query qr = se.createQuery("select e.employee_name, e.mobile, er.employer_name from Employeer er INNER JOIN Employee e ON er.employer_id = e.employer");
		List<Object[]> li = qr.list();
		Iterator i  = li.iterator();
		while(i.hasNext()) {
			Object o[] = (Object[])i.next();
			System.out.print(o[0]+" "+o[1]+" "+o[2]+"\n");
		}
		
		
		/*List<Employee> alst1 = new ArrayList<Employee>();
		alst1.add(emp);
		empr.setEmployee(alst1);*/
		
		//se.save(empr);
		//se.save(emp);
		tx.commit();
		se.close();
	}
}