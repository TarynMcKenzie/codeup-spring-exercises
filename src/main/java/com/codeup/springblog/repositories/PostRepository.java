package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository< Post, Long > { // < What we are dealing with, How it will be identified >
    // We will extend this class and define the type of objects it will be manipulating, as well as the data type of the entity's id.

    List<Post> findAll();

    Post getPostById(long id);

    Post deleteById(long id);


}
