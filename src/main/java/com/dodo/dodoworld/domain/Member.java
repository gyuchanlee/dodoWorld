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
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String userId;
    private String password;
    private String username;
    private String email;
    private LocalDateTime birth;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.REMOVE)
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "writer")
    private List<Comment> comments = new ArrayList<>();

    private Boolean isDeleted = false;

    public Member(String userId, String password, String username, String email, LocalDateTime birth, List<Board> boards) {
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.email = email;
        this.birth = birth;
        if (boards != null) {
            this.boards = boards;
        }
    }
}
