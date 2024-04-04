package com.ems.controller;

import com.ems.entity.Employee;
import com.ems.entity.MyEmployeeList;
import com.ems.service.EmployeeService;
import com.ems.service.MyEmployeeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private MyEmployeeListService myEmployeeService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/aboutMe")
    public String aboutMe() {
        return "aboutMe";
    }

    @GetMapping("/employee_register")
    public String employeeRegister() {
        return "employeeRegister";
    }

    @GetMapping("/available_employees")
    public ModelAndView getAllBook() {
        List<Employee> list=service.getAllEmployee();
        return new ModelAndView("employeeList","employee",list);
    }

    @PostMapping("/save")
    public String addEmployee(@ModelAttribute Employee e) {
        service.save(e);
        return "redirect:/available_employees";
    }

    @GetMapping("/my_employees")
    public String getMyEmployees(Model model) {
        List<MyEmployeeList>list=myEmployeeService.getAllMyEmployees();
        model.addAttribute("employee",list);
        return "myEmployees";
    }

    @GetMapping("/mylist/{id}")
    public String getMyList(@PathVariable ("id") int id) {
        Employee e=service.getEmployeeById(id);
        MyEmployeeList mb=new MyEmployeeList(e.getId(),e.getName(),e.getEmail(),e.getDepartment());
        myEmployeeService.saveMyEmployees(mb);
        return  "redirect:/my_employees";
    }

    @RequestMapping("/editEmployee/{id}")
    public String editBook(@PathVariable("id") int id,Model model) {
        Employee e=service.getEmployeeById(id);
        model.addAttribute("employee",e);
        return "employeeEdit";
    }

    @RequestMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/available_employees";
    }
}
