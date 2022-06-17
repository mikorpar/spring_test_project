package com.ibm.test.first_project.data.repositories;

import com.ibm.test.first_project.data.models.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

}
