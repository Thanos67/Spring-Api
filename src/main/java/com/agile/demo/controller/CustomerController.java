package com.agile.demo.controller;

import com.agile.demo.model.Customer;
import com.agile.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping( "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAll")
    public String  getAllCustomers(Model model){
        model.addAttribute("customers", customerService.getAllCustomers());
        return "index";
    }
    @GetMapping("/create")
    public String create(Customer customer) {
        return "add-customer";
    }
    @PostMapping("/add")
    public String create(@Valid Customer customer, Model model) {
        customerService.createCustomer(customer);
        return "redirect:/customer/getAll";
    }
    @GetMapping("/{id}")
    public String update(@PathVariable("id") long id,Model model) {
        Customer customer = customerService.getCustomerById(id);

        model.addAttribute("customer", customer);
        return "update-customer";

    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id,Model model) {
        Customer customer = customerService.getCustomerById(id);

        model.addAttribute("customer", customer);
        return "update-customer";

    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, Model model,@Valid Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/customer/getAll";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable long id) {
        Customer deleteCustomer = customerService.getCustomerById(id);
        customerService.deleteCustomer(deleteCustomer);
        return "redirect:/customer/getAll";
    }
}
