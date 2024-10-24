package com.lstdemo.springbootbatchdemo.batch;

import com.lstdemo.springbootbatchdemo.entity.User;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class UserItemReader extends FlatFileItemReader<User> {

    public UserItemReader() {
        setResource(new ClassPathResource("users.csv"));

        setLinesToSkip(1);  // Skip header
        setLineMapper(new DefaultLineMapper<User>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("name", "age", "email");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<User>() {{
                setTargetType(User.class);
            }});
        }});
        setRecordSeparatorPolicy(new DefaultRecordSeparatorPolicy());
    }
}