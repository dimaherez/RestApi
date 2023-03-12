package com.herez.app.rest.repository;

import com.herez.app.rest.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch, Long> {
}
