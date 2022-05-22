package Employee.Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Employee.Management.Controller.Exception.EmployeeNotFoundException;
import Employee.Management.Model.Employee;
import Employee.Management.Repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository EmployeeRepository;
	
	
	@GetMapping("/empmanagement")
	public List<Employee> getallEmployee(){
		return EmployeeRepository.findAll();
	}
	@PostMapping("/empmanagement")
	public Employee createEmployee(@Validated @RequestBody Employee Employee) {
	     return EmployeeRepository.save(Employee);	
	}
	@PutMapping("/empmanagement/{id}")
	public Employee updateEmployee(@PathVariable(value="id") Long id,
		@Validated @RequestBody Employee employeedetails)throws EmployeeNotFoundException{
		Employee Employee=EmployeeRepository.findById(id)
				 .orElseThrow(()->new EmployeeNotFoundException(id));
	Employee.setName(employeedetails.getName());
	           Employee.setDesgination(employeedetails.getDesgination());
	           Employee.setSalary(employeedetails.getSalary());
	           Employee updatedemployee=EmployeeRepository.save(Employee);
	           return updatedemployee;
		}

}
