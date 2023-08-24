package com.dodo.dodoworld.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString(of = {"id", "userId", "username", "email", "birth", "isDeleted"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String userId;

    private String password;
    private String username;
    private String email;
    private LocalDateTime birth;

    // 단방향
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    // 양방향
    @OneToMany(mappedBy = "writer", cascade = CascadeType.REMOVE)
    private List<Board> boards = new ArrayList<>();

    // 양방향
    @OneToMany(mappedBy = "writer")
    private List<Comment> comments = new ArrayList<>();

    private Boolean isDeleted = false;

    public Member(String userId, String password, String username, String email, LocalDateTime birth, Address address, List<Board> boards) {
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.email = email;
        this.birth = birth;
        this.address = address;
        if (boards != null) {
            this.boards = boards;
        }
    }
}
