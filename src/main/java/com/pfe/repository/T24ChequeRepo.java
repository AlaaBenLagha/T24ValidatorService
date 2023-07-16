package com.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.common.T24Cheque;


@Repository
public interface T24ChequeRepo extends JpaRepository<T24Cheque, String>  {

}
