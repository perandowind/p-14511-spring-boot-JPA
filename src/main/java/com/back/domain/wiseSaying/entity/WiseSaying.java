package com.back.domain.wiseSaying.entity;

import jakarta.persistence.*;

@Entity
public class WiseSaying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100 , nullable = false)
    private String content;

    @Column(length = 50 , nullable = false)
    private String author;

}
