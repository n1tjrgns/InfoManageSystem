package com.example.infomanage.repository;

import com.example.infomanage.domain.Block;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class BlockRepositoryTest {

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void crud(){
        Block block = new Block();
        block.setName("santa");
        block.setReason("스팸");
        block.setStartDate(LocalDate.now());
        block.setEndDate(LocalDate.now());

        blockRepository.save(block);

        List<Block> blocks = blockRepository.findAll();

        Assertions.assertThat(blocks.size()).isEqualTo(1);
        Assertions.assertThat(blocks.get(0).getName()).isEqualTo("santa");
    }
}