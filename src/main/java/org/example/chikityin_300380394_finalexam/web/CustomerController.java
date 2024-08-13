package org.example.chikityin_300380394_finalexam.web;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.example.chikityin_300380394_finalexam.entities.Customer;
import org.example.chikityin_300380394_finalexam.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SessionAttributes({"a","e"})
@Controller
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    static int num = 0;
    private List<Customer> customer;
    static int remainingSeats=20;

    static boolean A1=false;
    static boolean A2=false;
    static boolean A3=false;
    static boolean A4=false;
    static boolean B1=false;
    static boolean B2=false;
    static boolean B3=false;
    static boolean B4=false;
    static boolean C1=false;
    static boolean C2=false;
    static boolean C3=false;
    static boolean C4=false;
    static boolean D1=false;
    static boolean D2=false;
    static boolean D3=false;
    static boolean D4=false;
    static boolean E1=false;
    static boolean E2=false;
    static boolean E3=false;
    static boolean E4=false;



    @GetMapping(path = "/index")
    public String getCustomers(Model model) {
        List<Customer> listCustomers = customerRepository.findAll();
        model.addAttribute("listCustomers",listCustomers);
        model.addAttribute("customer", new Customer());
        model.addAttribute("remainingSeats", remainingSeats);
        return "system";
    }

    @PostMapping(path="/save")
    public String save(Model model, Customer customer, BindingResult bindingResult, ModelMap mm, HttpSession session) {
        model.addAttribute("customer", new Customer());
        boolean isReserved=false;
        switch(customer.getSeatno()){
            case "1A":
                if(A1==false){
                    isReserved=false;
                    A1=true;
                }else{
                    isReserved=true;
                }
                break;
            case "2A":
                if(A2==false){
                    isReserved=false;
                    A2=true;
                }else{
                    isReserved=true;
                }
                break;
            case "3A":
                if(A3==false){
                    isReserved=false;
                    A3=true;
                }else{
                    isReserved=true;
                }
                break;
            case "4A":
                if(A4==false){
                    isReserved=false;
                    A4=true;
                }else{
                    isReserved=true;
                }
                break;
            case "1B":
                if(B1==false){
                    isReserved=false;
                    B1=true;
                }else{
                    isReserved=true;
                }
                break;
            case "2B":
                if(B2==false){
                    isReserved=false;
                    B2=true;
                }else{
                    isReserved=true;
                }
                break;
            case "3B":
                if(B3==false){
                    isReserved=false;
                    B3=true;
                }else{
                    isReserved=true;
                }
                break;
            case "4B":
                if(B4==false){
                    isReserved=false;
                    B4=true;
                }else{
                    isReserved=true;
                }
                break;
            case "1C":
                if(C1==false){
                    isReserved=false;
                    C1=true;
                }else{
                    isReserved=true;
                }
                break;
            case "2C":
                if(C2==false){
                    isReserved=false;
                    C2=true;
                }else{
                    isReserved=true;
                }
                break;
            case "3C":
                if(C3==false){
                    isReserved=false;
                    C3=true;
                }else{
                    isReserved=true;
                }
                break;
            case "4C":
                if(C4==false){
                    isReserved=false;
                    C4=true;
                }else{
                    isReserved=true;
                }
                break;
            case "1D":
                if(D1==false){
                    isReserved=false;
                    D1=true;
                }else{
                    isReserved=true;
                }
                break;
            case "2D":
                if(D2==false){
                    isReserved=false;
                    D2=true;
                }else{
                    isReserved=true;
                }
                break;
            case "3D":
                if(D3==false){
                    isReserved=false;
                    D3=true;
                }else{
                    isReserved=true;
                }
                break;
            case "1E":
                if(E1==false){
                    isReserved=false;
                    E1=true;
                }else{
                    isReserved=true;
                }
                break;
            case "2E":
                if(E2==false){
                    isReserved=false;
                    E2=true;
                }else{
                    isReserved=true;
                }
                break;
            case "3E":
                if(E3==false){
                    isReserved=false;
                    E3=true;
                }else{
                    isReserved=true;
                }
                break;
            case "4E":
                if(E4==false){
                    isReserved=false;
                    E4=true;
                }else{
                    isReserved=true;
                }
                break;
            case "4D":
                if(D4==false){
                    isReserved=false;
                    D4=true;
                }else{
                    isReserved=true;
                }
                break;
        }

        if(isReserved==false){
            customerRepository.save(customer);
            remainingSeats--;
            if (num == 2) {
                mm.put("e", 2);
                mm.put("a", 0);
            } else {
                mm.put("a", 1);
                mm.put("e", 0);
            }
        }else{
            model.addAttribute("errorMessage", "Your seat is reserved");
            return "system";
        }

        return "redirect:/index";

    }

    /*@PostMapping("/save")
    public String saveCustomer(@RequestParam("seatno") String seatno,
                               @RequestParam("name") String name,
                               @RequestParam("date") Date date,
                               Model model) {
        // Find the seat and replace it with the customer's name
        for (Customer customer : customer) {
            if (customer.getSeatno().equals(seatno)) {
                customer.setName(name);
                customer.setDate(date);
                break;
            }
        }

        // Add the updated list of customers to the model
        model.addAttribute("listCustomers", customer);

        // Return the updated view
        return "system"; // Ensure this matches the name of your Thymeleaf template
    }*/
    /*@PostMapping(path = "/reserveSeat")
    public String reserveSeat(@RequestBody Customer customer) {
        try {
            // Save customer details to the database
            customerRepository.save(customer);

            // Generate a transaction code or use any logic you prefer
            String transactionCode = UUID.randomUUID().toString();

            // Prepare the response
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("transactionCode", transactionCode);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("success", false, "message", e.getMessage()));
        }
    }*/

    @GetMapping("/delete")
    public String delete(Long id){
        customerRepository.deleteById(id);
        remainingSeats++;
        /*switch(customer.getSeatno()) {
            case "1A":
                A1 = false;
                break;
            case "2A":
                A2 = false;
                break;
            case "3A":
                A3 = false;
                break;
            case "4A":
                A4 = false;
                break;
            case "1B":
                B1 = false;
                break;
            case "2B":
                B2 = false;
                break;
            case "3B":
                B3 = false;
                break;
            case "4B":
                B4 = false;
                break;
            case "1C":
                C1 = false;
                break;
            case "2C":
                C2 = false;
                break;
            case "3C":
                C3 = false;
                break;
            case "4C":
                C4 = false;
                break;
            case "1D":
                D1 = false;
                break;
            case "2D":
                D2 = false;
                break;
            case "3D":
                D3 = false;
                break;
            case "4D":
                D4 = false;
                break;
            case "1E":
                E1 = false;
                break;
            case "2E":
                E2 = false;
                break;
            case "3E":
                E3 = false;
                break;
            case "4E":
                E4 = false;
                break;
        }*/
        return "redirect:/index";
    }
    @GetMapping(path = "/editCustomers")
    public String editCustomers(Model model, Long id, HttpSession session){
        num = 2;
        session.setAttribute("info", 0);
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer==null) throw new RuntimeException("Customer does not exist");
        model.addAttribute("customer", customer);
        return "editCustomers";
    }
    @PostMapping(path="/edit")
    public String edit(Model model, Customer customer, BindingResult bindingResult, ModelMap mm, HttpSession session) {
        //Optional<Customer> existingCustomer = customerRepository.findById(customer.getCustomerNumber());
        if (bindingResult.hasErrors()) {
            //model.addAttribute("errorMessage", "The record you are trying to add is already existing. Choose a different customer number.");
            return "formCustomers"; // Return the form with an error message
        } else {
            customerRepository.save(customer);
            if (num == 2) {
                mm.put("e", 2);
                mm.put("a", 0);
            } else {
                mm.put("a", 1);
                mm.put("e", 0);
            }
            return "redirect:/index"; // Redirect to the customer list page after saving
        }
    }
}
