package com.bahati.database_postgres.dao.impl;

import com.bahati.database_postgres.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthotDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private AuthorDaoImpl underTest;
    @Test
    public void testThatCreateGenerateCorrectSql () {
        Author author = Author.builder()
                .id(1L)
                .name("Mukunzi")
                .age(36)
                .build();
      underTest.create(author);
      verify(jdbcTemplate).update(eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
              eq(1L), eq("Mukunzi"), eq(36)
              );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSql () {

        underTest.findOne(1L);
        verify(jdbcTemplate).query(eq("SELECT id, name, age FROM authors WHRE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(), eq(1L)
                );

    }
}
