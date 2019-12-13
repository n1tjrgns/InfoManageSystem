package com.example.infomanage.repository;

import com.example.infomanage.domain.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud(){
        Person person = new Person();
        person.setName("santa");
        person.setAge(100);

        personRepository.save(person);

        List<Person> people = personRepository.findAll();

        Assertions.assertThat(people.size()).isEqualTo(1);
        Assertions.assertThat(people.get(0).getName()).isEqualTo("santa");
        Assertions.assertThat(people.get(0).getAge()).isEqualTo(100);

        //해당 엔티티가 잘 저장됐는지 확인
        //하지만 역시 의존성 가득한 테스트
        //System.out.println(personRepository.findAll());
    }

    @Test
    void allArgsConstructor(){
        Person person = new Person(1L,"santa",100,"reading","O","서울", LocalDate.now(),"programmer","010-1234-5678");

        List<Person> people = personRepository.findAll();

        Assertions.assertThat(people.get(0).getName()).isEqualTo("santa");
    }

    @Test
    void hashCodeEquals(){
        Person person1 = new Person("santa",10);
        Person person2 = new Person("santa",10);

        //해쉬코드 값 비교
        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
    }
}