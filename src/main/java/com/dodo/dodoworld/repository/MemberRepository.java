package com.dodo.dodoworld.repository;

import com.dodo.dodoworld.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
