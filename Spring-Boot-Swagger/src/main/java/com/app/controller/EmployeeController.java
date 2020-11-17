package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.RecordNotFoundException;
import com.app.model.Employee3;
import com.app.response.Response;
import com.app.service.Employee3Service;

@RestController
@RequestMapping("/swagger/employee3")
public class EmployeeController {

	@Autowired
	private Employee3Service employee3service;

	@PostMapping("save")
	public Response saveEmployee(@Valid @RequestBody Employee3 employee3) {
		Response saveEmployee = employee3service.saveEmployee(employee3);
		return saveEmployee;
	}

	@GetMapping("getById/{id}")
	public ResponseEntity<Employee3> getEmployeeById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		Employee3 getById = employee3service.getById(id);
		if (getById != null)
			return new ResponseEntity<Employee3>(getById, HttpStatus.OK);
		else
			return new ResponseEntity<Employee3>(getById, HttpStatus.CONFLICT);
	}

	@PostMapping("/update")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee3 employee3) {
		Employee3 updateEmployee = employee3service.updateEmployee(employee3);
		if (updateEmployee != null)
			return new ResponseEntity<Object>(updateEmployee, HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Employee not updated", HttpStatus.CONFLICT);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Integer id) throws RecordNotFoundException {
		employee3service.deleteEmployee(id);
		return new ResponseEntity<Object>("record deleted", HttpStatus.OK);
	}

	@GetMapping("getAll/{pageNo}/{pageSize}")
	public ResponseEntity<List<Employee3>> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "empid") String sortBy) {
		List<Employee3> list = employee3service.getAllEmployees(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<Employee3>>(list, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/getByName") public ResponseEntity<Object>
	 * findByName(@RequestParam String name) { List<Employee3> findByName =
	 * employee3service.findByName(name); if (!findByName.isEmpty()) return new
	 * ResponseEntity<Object>(findByName, HttpStatus.OK); else return new
	 * ResponseEntity<Object>("Name Does Not Exist", HttpStatus.BAD_REQUEST); }
	 */
}