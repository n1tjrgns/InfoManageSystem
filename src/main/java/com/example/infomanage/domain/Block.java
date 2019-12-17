package com.example.infomanage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Block {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String reason;

    private LocalDate startDate;

    private LocalDate endDate;
}
