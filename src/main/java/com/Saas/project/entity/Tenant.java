package com.Saas.project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Tenant {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(unique = true)
    private String slug;

    @Enumerated(EnumType.STRING)
    private Plan plan;

    public enum Plan {
        FREE,
        PRO
    }


}