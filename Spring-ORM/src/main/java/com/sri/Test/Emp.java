package com.sri.Test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sri.entity.Emp1;
@Service
@Transactional
public class Emp {
	@Autowired
	private HibernateTemplate ht;
	@Autowired
	SessionFactory sessionFactory;
public void selectEmps()
{
	Emp1 l=ht.get(Emp1.class, 104);
	System.out.println(l);
	/*l.setSal(8000);
	ht.save(l);
	
	*/
	Criteria c=sessionFactory.openSession().createCriteria(Emp1.class);
	Projection p=Projections.property("empno");
	c.setProjection(p);
	List ll=c.list();
	
	System.out.println(ll);
	
}
}
