package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    protected long id;

    @NotNull
    @Column(name =  "gos_number", unique = true)
    protected long gosNumber;

    @NotNull
    @Column(length = 3, name = "auditory")
    protected int auditory;

    @Column(name =  "name", length = 255)
    protected String name;

    @Column(name =  "type" , length = 255)
    protected String type;

    @Column(name =  "simple_description", length = 255)
    protected String simpleDescription;


    public Item(@NotNull Long gosNumber, @NotNull int auditory) {
        this.gosNumber = gosNumber;
        this.auditory = auditory;
    }

    public Item(@NotNull Long gosNumber, @NotNull int auditory, String name) {
        this.gosNumber = gosNumber;
        this.auditory = auditory;
        this.name = name;
    }

    public Item(@NotNull Long gosNumber, @NotNull int auditory, String name, String type) {
        this.gosNumber = gosNumber;
        this.auditory = auditory;
        this.name = name;
        this.type = type;
    }

    public Item(@NotNull Long gosNumber, @NotNull int auditory, String name, String type, String simpleDescription) {
        this.gosNumber = gosNumber;
        this.auditory = auditory;
        this.name = name;
        this.type = type;
        this.simpleDescription = simpleDescription;
    }
}
