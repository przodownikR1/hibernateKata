package pl.java.scalatech.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.selfReference.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
