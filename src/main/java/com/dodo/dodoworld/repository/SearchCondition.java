package com.dodo.dodoworld.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchCondition {

    private String title;
    private String contentContains;
    private String writer;
    private Boolean isDeleted;
}
