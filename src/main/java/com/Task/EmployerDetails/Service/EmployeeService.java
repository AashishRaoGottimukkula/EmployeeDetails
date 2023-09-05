package com.Task.EmployerDetails.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Task.EmployerDetails.Employee;
import com.Task.EmployerDetails.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }
	
	 public List<Employee> getAllEmployees(){
		 return repository.getAllEmployees();
	 }
    
    public List<Employee> allEmployeesWithPrefix(String prefix){
    		return repository.getAllEmployeeWithPrefix(prefix);
    }
    
    public List<Employee> allEmployeesWithSortType(String sortType){
    	List<Employee> employees;
    	if(sortType.equals("id")) {
    		employees = repository.getEmployeesOrderedById();
    	}else {
    		employees = repository.getEmployeesOrderedByName();
    	}
    	return employees;
    }
    
    public List<Employee> allEmployeesWithPrefixAndSortType(String prefix, String sortType){
    	List<Employee> employees;
    	if(sortType.equals("id")) {
    		employees = repository.getEmployeesWithPrefixOrderedById(prefix);
    	}else {
    		employees = repository.getEmployeesWithPrefixOrderedByName(prefix);
    	}
    	return employees;
    }

	public List<Employee> getEmployeeDetails(String prefix, String sortType) {
		List<Employee> employees;
		
		if(prefix!=null && sortType!=null) {
			 employees = allEmployeesWithPrefixAndSortType(prefix, sortType);
		}else if(prefix==null && sortType!=null) {
			 employees = allEmployeesWithSortType(sortType);
		}else if(prefix!=null && sortType==null) {
			 employees = allEmployeesWithPrefix(prefix);
		}else{
			employees = getAllEmployees();
		}
		return employees;
	}
    
    
}
