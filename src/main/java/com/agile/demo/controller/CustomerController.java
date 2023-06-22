package com.agile.demo.controller;

import com.agile.demo.DTO.CustomerDTO;
import com.agile.demo.model.Customer;
import com.agile.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/customers")
public class CustomerController {

    private final CustomerService customerService;
    private ModelMapper modelMapper;

    @GetMapping("/")
    public String  getAllCustomers(Model model){
        model.addAttribute("customers", customerService.getAllCustomers()
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/create")
    public String create(CustomerDTO customerDTO) {
        return "add-customer";
    }

    @PostMapping("/")
    public String create(@Valid CustomerDTO customerDTO, Model model) {
        Customer c = modelMapper.map(customerDTO, Customer.class);
        customerService.createCustomer(c);
        return "redirect:/customers/";
    }

    @GetMapping("/{id}")
    public String getCustomer(@PathVariable("id") long id,Model model) {

        Customer customer = customerService.getCustomerById(id);

        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

        model.addAttribute("customer", customerDTO);
        return "update-customer";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id,Model model) {
        Customer customer = customerService.getCustomerById(id);

        model.addAttribute("customer", customer);
        return "update-customer";

    }

    @PutMapping("/{id}")
    public String updateUser(@Valid CustomerDTO customerDTO) {
        Customer customer= modelMapper.map(customerDTO,Customer.class);
        customerService.createCustomer(customer);
        return "redirect:/customers/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Customer customer = customerService.getCustomerById(id);
        customerService.deleteCustomer(customer);
        return "redirect:/customers/";
    }
}
