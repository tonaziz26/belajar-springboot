package com.nostratech.belajar_springboot.repository;

import com.nostratech.belajar_springboot.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findOneByName(String name);

    List<Author> findByName(String name);

    @Query("select a from Author a where UPPER(a.name) like UPPER(:name)")
    List<Author> findByNameLikeQuery(String name);

    @Query(value = "select * from t_author where UPPER(name) like UPPER(:name)", nativeQuery = true)
    List<Author> findByNameLikeQueryNative(String name);
}
