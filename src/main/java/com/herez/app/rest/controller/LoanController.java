package com.herez.app.rest.controller;

import com.herez.app.rest.models.Customer;
import com.herez.app.rest.models.Loan;
import com.herez.app.rest.repository.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/loans")
public class LoanController {

    @Autowired
    private LoanRepo loanRepo;

    @GetMapping(value = "")
    public List<Loan> getLoans() {
        return loanRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveLoan(@RequestBody Loan loan) {
        loanRepo.save(loan);
        return "Loan saved...";
    }

    @PutMapping(value = "/update/{id}")
    public String updateLoan(@PathVariable long id, @RequestBody Loan loan) {
        Loan updatedLoan = loanRepo.findById(id).get();

        updatedLoan.setLoanAmount(loan.getLoanAmount());
        updatedLoan.setBranch(loan.getBranch());
        updatedLoan.setCustomer(loan.getCustomer());

        loanRepo.save(updatedLoan);
        return "Loan updated...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteLoan(@PathVariable long id) {
        Loan deleteLoan = loanRepo.findById(id).get();
        loanRepo.delete(deleteLoan);
        return "Delete loan with the id: " + id;
    }


}
