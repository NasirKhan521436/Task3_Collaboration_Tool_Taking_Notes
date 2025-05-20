package com.collabtool.realtimecollab.controller;

import com.collabtool.realtimecollab.dto.DocumentRequest;
import com.collabtool.realtimecollab.model.Document;
import com.collabtool.realtimecollab.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<Document> createDocument(@RequestBody DocumentRequest request) {
        return ResponseEntity.ok(documentService.createDocument(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable String id) {
        return ResponseEntity.ok(documentService.getDocument(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable String id, @RequestBody String content) {
        return ResponseEntity.ok(documentService.updateDocument(id, content));
    }

    @PostMapping("/{id}/collaborators/{username}")
    public ResponseEntity<Void> addCollaborator(@PathVariable String id, @PathVariable String username) {
        documentService.addCollaborator(id, username);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/collaborators/{username}")
    public ResponseEntity<Void> removeCollaborator(@PathVariable String id, @PathVariable String username) {
        documentService.removeCollaborator(id, username);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/owned/{username}")
    public ResponseEntity<Set<Document>> getDocumentsOwnedBy(@PathVariable String username) {
        return ResponseEntity.ok(documentService.getDocumentsOwnedBy(username));
    }

    @GetMapping("/collaborated/{username}")
    public ResponseEntity<Set<Document>> getDocumentsCollaboratedBy(@PathVariable String username) {
        return ResponseEntity.ok(documentService.getDocumentsCollaboratedBy(username));
    }
}
