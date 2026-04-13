package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeReposistory extends JpaRepository<Employee, Long> {
}
