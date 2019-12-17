package com.example.infomanage.repository;

import com.example.infomanage.domain.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
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
    void allArgsConstructor() {
        Person person = new Person(1L, "santa", 100, "reading", "O", "서울", LocalDate.now(), "programmer", "010-1234-5678");

        List<Person> people = personRepository.findAll();

        System.out.println(people);
        Assertions.assertThat(people.get(0).getId()).isEqualTo(1L);
    }

    @Test
    void hashCodeEquals() {
        Person person1 = new Person("santa", 10,"O");
        Person person2 = new Person("santa", 10,"A");

        //해쉬코드 값 비교
        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        //이렇게 해쉬값이 다르게되면 HashMap 처럼 해쉬 값을 사용하는 컬렉션에서 문제가 생긴다.
        Map<Person, Integer> map = new HashMap<>();
        map.put(person1, person2.getAge());
        System.out.println(map);

        //null 값이 출력된다. -> Person에 hashcode를 동일하게 만들어주자
        //하지만 이는 소스가 추가될 때마다 추가해줘야 하므로 @EqualsAndHashCode로 대체가능
        System.out.println(map.get(person2));
    }
}