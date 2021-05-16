package com.hibernatedemo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Main {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		
		//Unit of Work Tasarim Deseni
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			////Select * from city
			//List<City> cities = session.createQuery("from City").getResultList();
			//List<City> cities = session.createQuery("from City c where c.countryCode='TUR'").getResultList();
			//List<City> cities = session.createQuery("from City c where c.countryCode='TUR' OR c.countryCode='USA'").getResultList();
			//List<City> cities = session.createQuery("from City c where c.countryCode='TUR' AND c.district='Ankara'").getResultList();
			//List<City> cities = session.createQuery("from City c where c.name LIKE '%kar%'").getResultList();
			//List<City> cities = session.createQuery("from City c ORDER BY c.name").getResultList();
			//List<City> cities = session.createQuery("from City c ORDER BY c.name").getResultList();
			
			/*for(City city:cities) {
			System.out.println(city.getCountryCode());
			}*/
			
			/* GROUP BY
			List<String> countryCodes = session.createQuery("select c.countryCode from City c GROUP BY c.countryCode").getResultList();
			
			for(String countryCode:countryCodes) {
				System.out.println(countryCode);
			}*/
			
			/* INSERT
			City city = new City();
			city.setName("Deneme123");
			city.setCountryCode("TUR");
			city.setDistrict("Deneme321");
			city.setPopulation(12345);
			session.save(city);
			*/
			
			/* //UPDATE
			City city = session.get(City.class, 4087);
			city.setPopulation(999912);
			session.save(city);
			
			
			*/
			
			/* //DELETE
			City city = session.get(City.class, 4087);
			session.delete(city);
			*/
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
		
		
		
	}
}
