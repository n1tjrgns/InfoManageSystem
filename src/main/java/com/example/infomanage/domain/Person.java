package com.example.infomanage.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString // exclude 인자 값을 사용하면 ToString 대상에서 제외됨
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

    private String bloodType;

    private String address;

    private LocalDate birthday;

    private String job;

    private String phoneNumber;

    public boolean equals(Object object){
        if(object == null){
            return false;
        }

        Person person = (Person) object;

        if(!person.getName().equals(this.getName())){
            return false;
        }

        if(person.getAge() != this.getAge()){
            return false;
        }

        return true;
    }
}
