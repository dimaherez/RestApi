package com.herez.app.rest.controller;

import com.herez.app.rest.models.Branch;
import com.herez.app.rest.models.Loan;
import com.herez.app.rest.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/branches")
public class BranchController {

    @Autowired
    private BranchRepo branchRepo;

    @GetMapping(value = "")
    public List<Branch> getBranches() {
        return branchRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveBranch(@RequestBody Branch branch) {
        branchRepo.save(branch);
        return "Branch saved...";
    }

    @PutMapping(value = "/update/{id}")
    public String updateBranch(@PathVariable long id, @RequestBody Branch branch) {
        Branch updatedBranch = branchRepo.findById(id).get();

        updatedBranch.setBname(branch.getBname());
        updatedBranch.setBcity(branch.getBcity());

        branchRepo.save(updatedBranch);
        return "Branch updated...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteBranch(@PathVariable long id) {
        Branch deleteBranch = branchRepo.findById(id).get();
        branchRepo.delete(deleteBranch);
        return "Delete branch with the id: " + id;
    }
}
