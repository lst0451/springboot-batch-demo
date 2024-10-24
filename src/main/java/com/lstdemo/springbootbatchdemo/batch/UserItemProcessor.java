package com.lstdemo.springbootbatchdemo.batch;

import com.lstdemo.springbootbatchdemo.entity.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class UserItemProcessor implements ItemProcessor<User, User> {

    @Override
    public User process(User user) throws Exception {
        // 过滤未成年用户
        if (user.getAge() >= 18) {
            return user;
        } else {
            return null;  // 跳过未成年用户
        }
    }
}
