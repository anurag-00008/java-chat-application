Chat Application using Java

Overview
This project is a real-time chat application built using Core Java. It follows a client-server architecture where multiple clients can connect to a central server and exchange messages concurrently.

Features
- Multi-client support
- Real-time message broadcasting
- Client-server architecture
- Multithreaded server
- Console-based interface

Technologies Used
- Java
- Socket Programming
- Multithreading
- I/O Streams

How It Works
1. Server listens for incoming client connections.
2. Each client is handled using a separate thread.
3. Messages sent by one client are broadcast to all connected clients.

How to Run
1. Compile the project:
javac src/server/.java src/client/.java src/Main.java
2. Start the server:
3. Run multiple clients in separate terminals.

Future Enhancements
- GUI using JavaFX
- User authentication
- Message persistence
- End-to-end encryption