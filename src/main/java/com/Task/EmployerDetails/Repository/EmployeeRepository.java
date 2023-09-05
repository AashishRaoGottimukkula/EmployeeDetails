package com.Task.EmployerDetails.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Task.EmployerDetails.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query(value="select e.* from EmployeeDetails e", nativeQuery=true)
	List<Employee> getAllEmployees();
	
	@Query(value="select e.* from EmployeeDetails e where e.name like %?1%", nativeQuery=true)
	List<Employee> getAllEmployeeWithPrefix(String prefix);
	
	@Query(value="select e.* from EmployeeDetails e order by name", nativeQuery=true)
	List<Employee> getEmployeesOrderedByName();
	
	@Query(value="select e.* from EmployeeDetails e order by id", nativeQuery=true)
	List<Employee> getEmployeesOrderedById();
	
	@Query(value="select e.* from EmployeeDetails e where e.name like %?1% order by name", nativeQuery=true)
	List<Employee> getEmployeesWithPrefixOrderedByName(String prefix);
	
	@Query(value="select e.* from EmployeeDetails e where e.name like %?1% order by id", nativeQuery=true)
	List<Employee> getEmployeesWithPrefixOrderedById(String prefix);
	
}
