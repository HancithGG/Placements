"""
ws_chat/server.py — A tiny WebSocket chat server.

WHAT THIS DOES
--------------
Listens on port 8765. Every client that connects joins a "chat room":
whenever one client sends a message, the server forwards (broadcasts)
it to every other connected client.

HOW IT WORKS (the big picture)
------------------------------
1. `websockets.serve(...)` starts a server that waits for connections.
2. Each connection gets its own `handler()` task running in parallel.
3. The `connected` set keeps track of everyone currently online.
4. When a message arrives, the server loops over the other clients
   and sends them the same message.

RUN IT
------
    pip install websockets
    python server.py

Keep this terminal open while clients connect.
"""

import asyncio
from websockets.asyncio.server import serve
from websockets.exceptions import ConnectionClosed

HOST = "localhost"   # listen on your own machine
PORT = 8765          # any free port above 1024 works

connected = set()    # all clients currently in the chat room


async def handler(websocket):
    """Runs once per connected client, for as long as they stay online."""
    # 1. Remember this client so we can broadcast to them later.
    connected.add(websocket)
    print(f"Client connected  ({len(connected)} online)")

    try:
        # 2. Wait for messages, one at a time, forever.
        async for message in websocket:
            print(f"Received: {message}")
            # 3. Send the same message to everyone else.
            #    asyncio.gather(...) sends them all "at the same time".
            others = connected - {websocket}  # everyone except the sender
            if others:
                await asyncio.gather(*(client.send(message) for client in others))
    except ConnectionClosed:
        pass  # the client left — handled gracefully below
    finally:
        # 4. Forget the client when they disconnect.
        connected.discard(websocket)
        print(f"Client disconnected  ({len(connected)} online)")


async def main():
    async with serve(handler, HOST, PORT):
        print(f"Chat server running on ws://{HOST}:{PORT}")
        print("Press Ctrl+C to stop.")
        await asyncio.Future()  # run forever


if __name__ == "__main__":
    try:
        asyncio.run(main())
    except KeyboardInterrupt:
        print("\nServer stopped. Bye!")
