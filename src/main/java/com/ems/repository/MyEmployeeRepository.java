package com.ems.repository;

import com.ems.entity.MyEmployeeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEmployeeRepository extends JpaRepository<MyEmployeeList,Integer> {

}
