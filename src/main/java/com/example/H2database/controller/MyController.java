package com.example.H2database.controller;

import com.example.H2database.entity.Employee;
import com.example.H2database.service.EmployeeService;
import com.example.H2database.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
//ResponseBody
public class MyController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return employeeService.addEmployee(employee);
    }
    @GetMapping
    public List<Employee> getEmployee()
    {
        return employeeService.getAllEmployee();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return "Employee with ID " + id + " has been deleted.";
    }
}
