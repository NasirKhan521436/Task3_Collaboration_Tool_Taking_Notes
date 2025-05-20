package com.collabtool.realtimecollab.controller;

import com.collabtool.realtimecollab.model.Document;
import com.collabtool.realtimecollab.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CollaborationController {
    private final SimpMessagingTemplate messagingTemplate;
    private final DocumentService documentService;

    @MessageMapping("/document/{docId}/edit")
    public void handleDocumentEdit(@DestinationVariable String docId, @Payload String content) {
        Document doc = documentService.updateDocument(docId, content);
        messagingTemplate.convertAndSend("/topic/document/" + docId, doc.getContent());
    }
}
