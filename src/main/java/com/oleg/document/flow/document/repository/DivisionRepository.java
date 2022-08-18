package com.oleg.document.flow.document.repository;

import com.oleg.document.flow.document.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {
    List<Division> findAll();
}
