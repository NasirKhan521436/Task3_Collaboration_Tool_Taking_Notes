
# Collaborative Note-Taking Tool (Google Docs Clone)

---
### **Company:** CODTECH IT SOLUTIONS

### **Intern Name:** Nasir Hussain Khan

### **Intern ID:** CT12WE82

### **Domain:** Software Development

### **Internship Duration:** 12 weeks

### **Mentor:** Neela Santosh

---

## Introduction

This project is a **real-time collaborative note-taking application** inspired by Google Docs, designed to enable multiple users to simultaneously create and edit notes from anywhere. Developed as part of my internship at **CODTECH IT SOLUTIONS**, this tool leverages **WebSocket technology** to provide instant updates to all connected users, making group collaboration efficient and seamless.

The purpose is to empower teams, students, or any groups to co-author notes, brainstorm ideas, and maintain synchronized documents without manual refresh or delays.

---

## Why This Project?

In today’s remote working and learning environments, collaborative tools have become essential. While Google Docs and similar platforms are widely used, building a lightweight custom note-taking app helps understand real-time communication technologies and collaborative system design — a valuable learning experience in software development.

This project demonstrates:

* Real-time data synchronization with WebSocket
* Handling multiple concurrent users
* Managing live document updates and conflict resolution
* Building responsive and user-friendly interfaces

---



---

## Technology Stack

* **Frontend:** HTML5, CSS3, Vanilla JavaScript (ES6+)
* **Backend:** Node.js with Express.js
* **Real-Time Protocol:** WebSocket (using `ws` or Socket.IO)
* **Version Control:** Git with GitHub repository
* **Development Tools:** Nodemon for live server reloads

---

## How It Works (In a Nutshell)

1. **User Connection:** A user opens the app, establishing a WebSocket connection with the server.
2. **Joining a Room:** The user joins or creates a collaborative session identified by a unique room ID.
3. **Editing Notes:** When a user types or modifies text, the client sends the changes to the server via WebSocket.
4. **Broadcasting Updates:** The server receives the update and broadcasts it to all other clients in the same room.
5. **Real-Time Sync:** Each client updates its view to reflect the latest changes, maintaining synchronization across all users.

This workflow eliminates latency, ensuring that all users see live changes instantaneously.

---

## Setup & Installation

### Prerequisites

* Node.js (v14 or newer)
* npm (Node package manager)

### Steps

1. Clone the repo:

```bash
git clone https://github.com/NasirKhan521436/Task3_Collaboration_Tool_Taking_Notes.git
cd Task3_Collaboration_Tool_Taking_Notes
```

2. Install dependencies:

```bash
npm install
```

3. Start the development server:

```bash
npm start
```

4. Open `http://localhost:3000` in your browser to begin collaborating.

Open multiple tabs or share the URL with collaborators to test real-time note syncing.

---

---

## Future Improvements

* User authentication and access control
* Persistent storage of notes (database integration)
* Rich text editing features (formatting, lists, links)
* Version history and undo/redo support
* Mobile-friendly responsive UI
* Presence indicators showing active collaborators

---

## Acknowledgments

Thanks to **CODTECH IT SOLUTIONS** for providing this internship opportunity and to my mentor **Neela Santosh** for continuous guidance and support throughout the project duration.

---



---

## Contact

**Nasir Hussain Khan**
GitHub: [https://github.com/NasirKhan521436](https://github.com/NasirKhan521436)
Email: *(please add your email)*

