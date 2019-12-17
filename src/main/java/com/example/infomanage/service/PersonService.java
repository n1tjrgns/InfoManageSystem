package com.example.infomanage.service;

import com.example.infomanage.domain.Block;
import com.example.infomanage.domain.Person;
import com.example.infomanage.repository.BlockRepository;
import com.example.infomanage.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlocks(){
        //일반적으로 findAll은 데이터를 전부 가져오므로 잘 사용하지 않음.
        List<Person> people = personRepository.findAll();
        List<Block> blocks = blockRepository.findAll();

        List<String> blockNames = blocks.stream().map(Block::getName).collect(Collectors.toList());

        //blocknames에 person이름이 없다면 제외
        return people.stream().filter(person -> !blockNames.contains(person.getName())).collect(Collectors.toList());
    }
}
