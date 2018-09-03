package com.sws.hdmshull.repository;

import com.sws.hdmshull.pojo.SwsUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SwsUserEntity,Long> {
    SwsUserEntity findByUsername(String username);
    SwsUserEntity findByWorkNumberCard(String workNumberCard);
}
