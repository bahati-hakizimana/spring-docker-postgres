package com.bahati.database_postgres.dao.impl;

import com.bahati.database_postgres.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {
    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;
    @Test
    public void testThatCreateGenerateCorrectSql () {
        Book book = Book.builder()
                .isbn("khnb67")
                .name("My book")
                .authorId(1L)
                .build();
        underTest.create(book);
        verify(jdbcTemplate).update(eq("INSERT INTO books (isbn, name, authorId) VALUES (?, ?, ?)"),
                eq("khnb67"), eq("My book"), eq(1L)
        );
    }
}
