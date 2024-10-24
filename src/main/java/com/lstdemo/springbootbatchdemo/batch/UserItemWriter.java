package com.lstdemo.springbootbatchdemo.batch;

import com.lstdemo.springbootbatchdemo.entity.User;
import com.lstdemo.springbootbatchdemo.repository.UserRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserItemWriter implements ItemWriter<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void write(Chunk<? extends User> chunk) throws Exception {
        userRepository.saveAll(chunk.getItems());
    }
}
