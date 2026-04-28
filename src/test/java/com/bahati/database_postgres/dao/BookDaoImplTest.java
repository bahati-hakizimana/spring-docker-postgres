package com.bahati.database_postgres.dao;

import com.bahati.database_postgres.dao.impl.AuthorDaoImpl;
import com.bahati.database_postgres.dao.impl.BookDaoImpl;
import com.bahati.database_postgres.domain.Author;
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
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test

  public void testThatCreateBookGenerateCorrectSql () {
        Book book = Book.builder()
                .isbn("bkt5")
                .title("Main conf")
                .authorId(1l)
                .build();
        underTest.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("bkt5"), eq("Main conf"), eq(1l)
        );
    }
}
