package com.dodo.dodoworld.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(of = {"region", "city", "street", "zipcode"})
public class Address {

    @Id @GeneratedValue
    @Column(name = "address_id")
    private Long id;

    private String region;
    private String city;
    private String street;
    private String zipcode;
}
