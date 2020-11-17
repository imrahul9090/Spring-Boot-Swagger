package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.exception.RecordNotFoundException;
import com.app.model.Employee3;
import com.app.repository.Employee3Repository;
import com.app.response.Response;

@Service
public class Employee3Service {

	@Autowired
	private Employee3Repository employeeRepository;

	public Response saveEmployee(Employee3 employee3) {
		try {
			Employee3 save = employeeRepository.save(employee3);
			if (save == null)
				return new Response(null, "Failed to create Employee data ", 409);
			else
				return new Response(save, "Data is created Successfully", 200);
		} catch (Exception e) {
			return new Response(null, "Please fill the employee details", 409);
		}
	}

	public Employee3 getById(Integer id) throws RecordNotFoundException {
		Optional<Employee3> findById = employeeRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			throw new RecordNotFoundException("No employee exist with given id");
		}
	}

	public Employee3 updateEmployee(Employee3 employee3) {
		Optional<Employee3> findById = employeeRepository.findById(employee3.getEmpid());
		Employee3 emp = findById.get();
		emp.setEmpid(employee3.getEmpid());
		emp.setEmpname(employee3.getEmpname());
		emp.setEmpsal(employee3.getEmpsal());
		emp = employeeRepository.save(emp);
		return emp;
	}

	public void deleteEmployee(Integer id) throws RecordNotFoundException {
		Optional<Employee3> findById = employeeRepository.findById(id);
		if (findById.isPresent()) {
			employeeRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No Employee Record Exist");
		}

	}

	public List<Employee3> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Employee3> pagedResult = employeeRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Employee3>();
		}
	}

	/*
	 * public List<Employee3> findByName(String name) { List<Employee3> findByName =
	 * employeeRepository.findByName(name); return findByName;
	 * 
	 * }
	 */
}