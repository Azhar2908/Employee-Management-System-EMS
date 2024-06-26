package com.ems.service;

import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository eRepo;

    public void save(Employee e) {
        eRepo.save(e);
    }
    public List<Employee> getAllEmployee(){
        return eRepo.findAll();
    }
    public Employee getEmployeeById(int id) {
        return eRepo.findById(id).get();
    }
    public void deleteById(int id) {
        eRepo.deleteById(id);
    }
}
