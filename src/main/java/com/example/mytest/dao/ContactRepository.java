package com.example.mytest.dao;

import com.example.mytest.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("SELECT c FROM Contact c WHERE c.nom like :x")
    Page<Contact> chercher(@Param("x")String mc, Pageable pageable);
}
