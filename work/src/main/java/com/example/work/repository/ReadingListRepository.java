package com.example.work.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.work.entity.Book;

public interface ReadingListRepository extends JpaRepository<Book,Long> {
	List<Book> findByReader(String reader);
}