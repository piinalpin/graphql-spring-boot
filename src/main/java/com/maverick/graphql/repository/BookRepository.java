package com.maverick.graphql.repository;

import com.maverick.graphql.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<BookModel, Long> {

    @Query(value = "SELECT mb.* FROM m_book mb JOIN m_person mp ON mb.author_id = mp.id " +
            "WHERE UPPER(mp.first_name) = UPPER(?1)", nativeQuery = true)
    List<BookModel> findAllByAuthor(String name);

    @Query(value = "UPDATE m_book SET deleted_at = CURRENT_DATE WHERE id = ?1", nativeQuery = true)
    @Modifying
    void softDelete(Long id);

}
