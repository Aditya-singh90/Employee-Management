package net.javaguides.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeReposistory;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeReposistory employeeReposistory;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
         Employee savedEmployee = employeeReposistory.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee = employeeReposistory.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee is not exists with given id: " +employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
     List<Employee> employees =   employeeReposistory.findAll();
        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployees(Long employeesId, EmployeeDto updatedEmployees) {

       Employee employee = employeeReposistory.findById(employeesId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id:" +employeesId)
        );

       employee.setFirstName(updatedEmployees.getFirstName());
       employee.setLastName(updatedEmployees.getLastName());
       employee.setEmail(updatedEmployees.getEmail());

     Employee updateEmployeeObj =  employeeReposistory.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeReposistory.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id:" +employeeId)
        );

        employeeReposistory.deleteById(employeeId);


    }
}
