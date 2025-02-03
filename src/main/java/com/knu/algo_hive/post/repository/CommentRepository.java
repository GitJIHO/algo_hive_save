package com.knu.algo_hive.post.repository;

import com.knu.algo_hive.post.dto.CommentResponse;
import com.knu.algo_hive.post.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT new com.knu.algo_hive.post.dto.CommentResponse(c.id,c.content,c.createdAt,c.updatedAt,c.member.nickName ) " +
            "FROM Comment c " +
            "WHERE c.post.id = :postId ")
    Page<CommentResponse> findCommentsByPostIdPaged(@Param("postId") Long postId, Pageable pageable);
}
