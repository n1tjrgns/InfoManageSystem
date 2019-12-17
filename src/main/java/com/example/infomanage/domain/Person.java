package com.example.infomanage.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data // = @Getter + @Setter +@ToString(exclude 인자 값을 사용하면 ToString 대상에서 제외됨) + @EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull //필수 생성자 선언 @RequiredArgsConstructor랑 세트
    private String name;

    @NonNull
    private int age;

    private String hobby;

    @NonNull
    private String bloodType;

    private String address;

    private LocalDate birthday;

    private String job;

    private String phoneNumber;
}
