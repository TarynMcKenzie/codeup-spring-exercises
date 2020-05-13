package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository< Post, Long > { // < What we are dealing with, How it will be identified >
    // We will extend this class and define the type of objects it will be manipulating, as well as the data type of the entity's id.

    List<Post> findAll();

    // The following method is equivalent to the built in `getOne` method, there's no need to create this example
//    @Query("from post a where a.id like ?1")
//    Post getAdById(long id);

    // The following method shows you how to use named params in a HQL custom query: HQL, or Hibernate Query Language.
//    @Query("from post a where a.title like %:term%")
//    List<Post> searchByTitleLike(@Param("term") String term);

}
