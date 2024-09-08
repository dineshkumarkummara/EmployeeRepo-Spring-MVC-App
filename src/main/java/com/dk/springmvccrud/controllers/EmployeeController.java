package com.dk.springmvccrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dk.springmvccrud.Service.EmployeeService;
import com.dk.springmvccrud.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Display list of employees
    @GetMapping("/list")
    public String getEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "list-employees";
    }

    // Show form to add new employee
    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        Employee employee = new Employee();  // Empty employee object for form
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    // Save new employee
    @PostMapping("/save")
    public String saveEmployee(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    // Show form to update an employee
    @GetMapping("/update")
    public String showUpdateEmployeeForm(@RequestParam("id") int id, Model model) {
        Employee employee = employeeService.findById(id);  // Fetch employee from the database
        model.addAttribute("employee", employee);
        return "add-employee";  // Reusing the same form for updating
    }

    // Delete an employee
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
