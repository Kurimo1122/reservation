package com.yahoo.reservation.repository;

import com.yahoo.reservation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query(value = "SELECT * FROM user u WHERE u.user_id = :userId LIMIT 1", nativeQuery = true)
    User findByUserId(@Param("userId") String userId);
}
