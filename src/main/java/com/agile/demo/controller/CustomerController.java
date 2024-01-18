package com.agile.demo.controller;

import com.agile.demo.DTO.CustomerDTO;
import com.agile.demo.model.Customer;
import com.agile.demo.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private  CustomerService customerService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    public String getAllCustomers(Model model) {
        List<CustomerDTO> customerDTOs = customerService.getAllCustomers().stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
        model.addAttribute("customers", customerDTOs);
        return "index";
    }

    @GetMapping("/create")
    public String create(CustomerDTO customerDTO) {
        return "add-customer";
    }

    @PostMapping("/")
    public String create(@Valid CustomerDTO customerDTO, Model model) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerService.createCustomer(customer);
        return "redirect:/customers/";
    }

    @GetMapping("/{id}")
    public String getCustomer(@PathVariable("id") String id, Model model) {
        customerService.getCustomerById(id).ifPresent(customer -> {
            CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
            model.addAttribute("customer", customerDTO);
        });
        return "update-customer";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        customerService.getCustomerById(id).ifPresent(customer -> model.addAttribute("customer", customer));
        return "update-customer";
    }

    @PostMapping("/{id}")
    public String updateUser(@Valid CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerService.updateCustomer(customer);
        return "redirect:/customers/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers/";
    }
}
