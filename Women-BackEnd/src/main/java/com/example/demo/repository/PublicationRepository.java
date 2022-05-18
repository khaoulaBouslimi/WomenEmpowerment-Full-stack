package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
	
	
	/*@Query(value = "select publication_txt from publication p join user on user.user_id = p.user_id where user.user_id = ?1 )",nativeQuery =true)
	List<Publication> findByuser_id(int id);*/
	
	List<Publication> findByUser(int id);
	Optional<Publication> findByUserAndId(int id,int user_id);
	
	@Query(value ="SELECT * FROM `publication` JOIN comments on comments.pub_id_id=publication.id WHERE publication.id = 1",nativeQuery=true)
	List<Publication> findAllpub();
	
	@Query(value="select publication_txt from publication",nativeQuery=true)
	List<String> findpubtxt();
	
	@Query(value="select title from publication",nativeQuery=true)
	List<String> findpubtitle();
	
	@Modifying
	@Transactional
	@Query(value="delete p from publication p where p.publication_txt = :pub_txt",nativeQuery=true)
	void deleteSujetRedondant(@Param("pub_txt") String pub_txt);
	
	@Query(value="select count(*) from comments where pub_id_id =:pub_id",nativeQuery=true)
	int NbreCommentsBypub(@Param("pub_id") Publication pub);
	
	@Query(value="select count(*) from like_posts where pub_id =:pub",nativeQuery=true)	
	int NbreInteractionBypub(@Param("pub") Publication pub);
	
	@Transactional
	@Modifying
	@Query(value="delete from comments where pub_id_id=:pub",nativeQuery=true)
	void DeleteCommentsByPub(@Param("pub") Publication pub);
	
	@Transactional
	@Modifying
	@Query(value="delete from like_posts where pub_id=:pub",nativeQuery=true)
	void DeleteInteractionsByPub(@Param("pub") Publication pub);
	
	@Transactional
	@Modifying
	@Query(value="delete from like_comments where com_id in (select id from comments where pub_id_id=:pub)",nativeQuery=true)
	void DeleteInteractionsByCommentsByPuub(@Param("pub") Publication pub);
	void save(Optional<Publication> publication);
	
	

}
