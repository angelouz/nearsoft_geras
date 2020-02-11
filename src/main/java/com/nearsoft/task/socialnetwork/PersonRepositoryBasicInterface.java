package com.nearsoft.task.socialnetwork;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoryBasicInterface extends JpaRepository<Person, String>, PersonRepositoryCustomInterface {

}
