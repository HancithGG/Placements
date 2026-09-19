# WebSocket Chat (Python)

A tiny, beginner-friendly chat program built on WebSockets.
One terminal runs the **server** (the chat room); every other terminal runs a
**client** (a person chatting). Anything one client types appears in all the
others — in real time.

```
┌──────────┐         ┌─────────────────┐         ┌──────────┐
│ client 1 │ ◄─────► │  chat server    │ ◄─────► │ client 2 │
└──────────┘         │  (server.py)    │         └──────────┘
                     └────────┬────────┘
                              │ broadcast to
                              ▼ everyone
                        ┌──────────┐
                        │ client 3 │
                        └──────────┘
```

## What is a WebSocket?

A normal HTTP request is "ask once, get an answer, done." A **WebSocket** is a
connection that stays open, so both sides can send messages whenever they
want — exactly what a chat needs. The server never polls; messages just
arrive.

## 1. Install dependencies

You need Python 3.9+ and one very common library:

```bash
pip install websockets
```

## 2. Run the server

Open a terminal:

```bash
python server.py
```

You should see:

```
Chat server running on ws://localhost:8765
Press Ctrl+C to stop.
```

Keep this terminal open — it *is* the chat room.

## 3. Connect clients

Open **one new terminal per person** (yes, chat with yourself — it works!):

```bash
python client.py
```

Repeat in more terminals to add more people to the room.

## 4. Example chat session

Terminal 2 (Alice):

```
Connected! Type a message and press Enter.
Press Ctrl+C to quit.

you: Hi everyone!
```

Terminal 3 (Bob) sees Alice's message appear instantly:

```
Connected! Type a message and press Enter.
Press Ctrl+C to quit.

you: Hi everyone!
hello Alice!
you:
```

Terminal 2 sees Bob's reply:

```
you: Hi everyone!
hello Alice!
you:
```

The server terminal logs everything:

```
Chat server running on ws://localhost:8765
Client connected  (1 online)
Client connected  (2 online)
Received: Hi everyone!
Received: hello Alice!
Client disconnected  (1 online)
```

Quit any client with **Ctrl+C** — the others are not affected, and the
server keeps running.

## Files

| File        | Purpose                                            |
| ----------- | -------------------------------------------------- |
| `server.py` | Accepts clients and broadcasts messages to them.   |
| `client.py` | Connects to the server; sends and displays chats.  |

## How it works, in one paragraph

`server.py` keeps a `set` of connected clients. Each client gets its own
`handler()` coroutine; when a message arrives from one of them, the server
sends that same message to everyone else in the set. `client.py` runs two
tasks at once — one prints incoming messages, the other reads your keyboard —
so you can talk and listen simultaneously.

## Ideas to extend it

- **Usernames** — ask for a name at startup and send `json.dumps({"name": ..., "text": ...})` instead of plain text; decode it on the receiving side.
- **Timestamps** — prepend the time with `datetime.now().strftime("%H:%M")` when printing.
- **Online list** — announce "Alice joined the chat" by sending a system message inside `handler()` when someone connects or leaves.
- **Save history** — append every message to a `chat.log` file in the server.
- **Web UI** — browsers can speak WebSockets natively, so a simple HTML page with `new WebSocket("ws://localhost:8765")` plus a text box replaces the terminal client.
- **Rooms** — keep several sets (one per room) and let the first message choose which room to join.
