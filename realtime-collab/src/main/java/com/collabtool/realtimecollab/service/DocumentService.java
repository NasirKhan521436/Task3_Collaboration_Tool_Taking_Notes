package com.collabtool.realtimecollab.service;

import com.collabtool.realtimecollab.dto.DocumentRequest;
import com.collabtool.realtimecollab.model.Document;
import com.collabtool.realtimecollab.model.User;
import com.collabtool.realtimecollab.repository.DocumentRepository;
import com.collabtool.realtimecollab.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;

    @Transactional
    public Document createDocument(DocumentRequest request) {
        User owner = userRepository.findByUsername(request.getOwnerUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Document document = new Document();
        document.setContent(request.getContent());
        document.setOwner(owner);
        document.getCollaborators().add(owner);

        return documentRepository.save(document);
    }

    public Document getDocument(String id) {
        return documentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Document not found"));
    }

    @Transactional
    public Document updateDocument(String id, String content) {
        Document document = getDocument(id);
        document.setContent(content);
        return documentRepository.save(document);
    }

    public Set<Document> getDocumentsOwnedBy(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return documentRepository.findByOwnerId(user.getId());
    }

    public Set<Document> getDocumentsCollaboratedBy(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return documentRepository.findByCollaboratorId(user.getId());
    }

    @Transactional
    public void addCollaborator(String docId, String username) {
        Document doc = getDocument(docId);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        doc.getCollaborators().add(user);
        documentRepository.save(doc);
    }

    @Transactional
    public void removeCollaborator(String docId, String username) {
        Document doc = getDocument(docId);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        doc.getCollaborators().remove(user);
        documentRepository.save(doc);
    }
}
