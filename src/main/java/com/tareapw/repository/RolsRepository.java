package com.tareapw.repository;


import com.tareapw.entity.RolsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolsRepository extends JpaRepository<RolsEntity, Long> {
}
