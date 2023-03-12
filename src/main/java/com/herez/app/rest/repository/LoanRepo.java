package com.herez.app.rest.repository;

import com.herez.app.rest.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepo extends JpaRepository<Loan, Long> {
}
