package com.ems.service;

import com.ems.entity.MyEmployeeList;
import com.ems.repository.MyEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyEmployeeListService {

    @Autowired
    private MyEmployeeRepository myemployee;

    public void saveMyEmployees(MyEmployeeList employee) {
        myemployee.save(employee);
    }
    public List<MyEmployeeList> getAllMyEmployees(){
        return myemployee.findAll();
    }
    public void deleteById(int id) {
        myemployee.deleteById(id);
    }
}
