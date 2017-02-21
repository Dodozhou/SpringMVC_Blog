package com.star.repository;

import com.star.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by hp on 2017/2/20.
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
