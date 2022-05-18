package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.LikeTs;

@Repository
public interface LikeTsRepository extends JpaRepository<LikeTs, Integer> {


	
	@Query(value="select count(*) from like_ts l where l.idts= :idts and l.id = :iduser and interaction_type = 'like' and is_liked=1",nativeQuery=true)
	int LikesTs(@Param("idts") int idts, @Param("iduser") int iduser);


	@Query(value="select count(*) from like_ts l where l.idts= :idts and l.id = :iduser and interaction_type = 'Dislike' and is_liked=0",nativeQuery=true)
	int DislikesTs(@Param("idts") int idts, @Param("iduser") int iduser);

	
	@Transactional
	@Modifying
	@Query(value="delete l from like_ts l where l.id= :iduser and l.id = :idts and l.is_liked=1 ",nativeQuery=true)
	//@Query(value = "DELETE ", nativeQuery = true)
	void DeleteLike(@Param("iduser") int idUser, @Param("idts") int idTs);

	@Query(value="select count(*) from like_ts l where l.id= :iduser and l.idts= :idts ",nativeQuery=true)
	int FindUserByIdFromLikes(@Param("iduser") int idUser, @Param("idts") int idTs);

	@Transactional
	@Modifying
	@Query(value="delete l from like_ts l where l.id= :iduser and l.id = :idts and l.is_liked=0 ",nativeQuery=true)
	void DeleteDisLike(@Param("iduser") int idUser, @Param("idts") int idTs);
	
	@Query(value="select count(*) from like_ts l where l.id= :iduser and l.idts= :idts and l.is_liked = 0",nativeQuery=true)
	int FindUserByIdFromDislikes(@Param("iduser") int idUser, @Param("idts") int idTs);


	
	

}
