package com.bahati.database_postgres.dao.impl;

import com.bahati.database_postgres.dao.BookDao;
import com.bahati.database_postgres.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (isbn, name, authorId) VALUES (?, ?, ?)",
                book.getIsbn(), book.getName(), book.getAuthorId()
                );
    }
}
