package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;

@Repository
public class DeptDaoImpl implements IDeptDao{

	@Autowired
	private EntityManager entityManager;
	

	@Override
	public List<Department> getAllDepartment() {
		return entityManager.createQuery("select d from Department d",Department.class).getResultList();
	}

}
