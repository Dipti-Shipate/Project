package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDeptDao;
import com.app.pojos.Department;

@Service
@Transactional
public class DeptServiceImpl implements IDeptService {

	@Autowired
	private IDeptDao deptdao;

	

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return deptdao.getAllDepartment();
	}
	
	
	
}
