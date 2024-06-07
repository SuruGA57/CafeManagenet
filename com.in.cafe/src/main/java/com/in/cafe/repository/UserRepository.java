package com.in.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in.cafe.POJO.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>  {
	//JPA-Java Persist API, used to access manage and persist the data between relational db and java object or class
	//having two types 1.JPARepository-used to perform more operation on functions we use like pagination sorting and etc
	//2.CrudRepository-only perform some CRUD operations then we goes with this.

	User findByEmail(@Param("email") String email);
}
