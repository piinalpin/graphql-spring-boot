package com.maverick.graphql.repository;

import com.maverick.graphql.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<PersonModel, Long> {

    @Query(value = "SELECT * FROM m_person WHERE identity_number = ?1", nativeQuery = true)
    PersonModel findByIdentityNumber(String identityNumber);

    @Query(value = "UPDATE m_person SET deleted_at = CURRENT_DATE WHERE id = ?1", nativeQuery = true)
    @Modifying
    void softDelete(Long id);

}
