package com.kgisl.myprofiletask.repository;

import com.kgisl.myprofiletask.entity.Myprofile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("myprofileRepository")
public interface MyprofileRepository extends JpaRepository<Myprofile, Long>{

}
