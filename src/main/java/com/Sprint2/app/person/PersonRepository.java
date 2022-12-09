package com.Sprint2.app.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface PersonRepository<T extends Person> extends JpaRepository<T, Long> {
    T findByEmail(String email);
}
