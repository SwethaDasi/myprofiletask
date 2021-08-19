package com.kgisl.myprofiletask.repository;

import com.kgisl.myprofiletask.entity.MyProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("myProfileRepository")
public interface MyProfileRepository extends JpaRepository<MyProfile, Long>{

}
