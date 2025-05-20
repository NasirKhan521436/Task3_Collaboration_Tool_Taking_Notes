package com.collabtool.realtimecollab.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.collabtool.realtimecollab.model.Document;

public interface DocumentRepository extends JpaRepository<Document, String> {

    @Query("SELECT d FROM Document d WHERE d.owner.id = :userId")
    Set<Document> findByOwnerId(@Param("userId") Long userId);

    @Query("SELECT d FROM Document d JOIN d.collaborators c WHERE c.id = :userId")
    Set<Document> findByCollaboratorId(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO document_collaborators (document_id, user_id) VALUES (:documentId, :userId)", nativeQuery = true)
    void addCollaborator(@Param("documentId") String documentId, @Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM document_collaborators WHERE document_id = :documentId AND user_id = :userId", nativeQuery = true)
    void removeCollaborator(@Param("documentId") String documentId, @Param("userId") Long userId);
}
