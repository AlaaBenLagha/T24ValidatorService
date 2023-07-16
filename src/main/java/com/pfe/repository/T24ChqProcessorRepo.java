package com.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.model.T24ChequeProcessor;


@Repository
public interface T24ChqProcessorRepo extends JpaRepository<T24ChequeProcessor, Integer> {

}
