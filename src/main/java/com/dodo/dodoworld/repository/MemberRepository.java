package com.dodo.dodoworld.repository;

import com.dodo.dodoworld.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUserIdAndIsDeletedIsFalse(String userId);

    @Query("update Member m set m.isDeleted = true where m.userId = :userId")
    void memberDelete(@Param("userId") String userId);
}
