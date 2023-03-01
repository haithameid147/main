package com.youtube.jwt.dao;

import com.youtube.jwt.entity.User;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDao extends CrudRepository<User, String> {

	User findByUserName(String name);

	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query(value = "update  users   set  user_first_name = :firstname,user_last_name = :lastname,mobile=:mobile where user_name = :username", nativeQuery = true)
	public void updateUserField(String username, String firstname, String lastname,String mobile);

	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query(value ="update users set user_password=:password where user_name = :username"
	,nativeQuery = true)
	public void updatePassword(String username,String password);
	public boolean existsByUserName(String name) ;
	
	@Transactional
    @Modifying
    @Query(value = "update users  set code = ? where user_name = ?", 
      nativeQuery = true)
    void setCodeForUser(int code, String user);
}
