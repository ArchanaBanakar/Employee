package Employee.Management.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Employee.Management.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}

