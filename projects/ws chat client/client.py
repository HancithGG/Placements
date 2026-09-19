"""
ws_chat/client.py — A tiny command-line chat client.

WHAT THIS DOES
--------------
Connects to the chat server (server.py), then loops:
  - you type a message and press Enter  -> it is sent to the server
  - any message from other clients      -> it is printed on your screen

RUN IT
------
    python client.py
(Start the server first! Open several terminals and run one client in
each to chat with yourself across windows.)

HOW IT WORKS
------------
Two tasks run at the same time:
  - `receive_loop()`  listens for incoming messages and prints them
  - the main loop     reads your keyboard input and sends it
`asyncio.gather(...)` keeps both running until you quit with Ctrl+C.
"""

import asyncio
from websockets.asyncio.client import connect
from websockets.exceptions import ConnectionClosed

SERVER_URL = "ws://localhost:8765"  # must match the server's HOST/PORT


async def receive_loop(websocket):
    """Prints every message the server sends us."""
    try:
        async for message in websocket:
            print(f"\r{message}")            # \r clears the "you: " prompt first
            print("you: ", end="", flush=True)
    except ConnectionClosed:
        print("\nDisconnected from the server.")

async def send_loop(websocket):
    """Reads your typing and sends each line to the server."""
    loop = asyncio.get_running_loop()
    while True:
        # run_in_executor lets us wait for keyboard input without
        # blocking the "listen for messages" task.
        message = await loop.run_in_executor(None, input)
        await websocket.send(message)

async def main():
    print("=" * 46)
    print(" WebSocket Chat Client")
    print("=" * 46)
    print(f"Connecting to {SERVER_URL} ...")

    try:
        async with connect(SERVER_URL) as websocket:
            print("Connected! Type a message and press Enter.")
            print("Press Ctrl+C to quit.\n")
            print("you: ", end="", flush=True)

            # Run "listen for messages" and "read your typing" together.
            await asyncio.gather(receive_loop(websocket), send_loop(websocket))
    except (ConnectionRefusedError, OSError):
        print("\nCould not connect. Is server.py running? Start it first!")



if __name__ == "__main__":
    try:
        asyncio.run(main())
    except KeyboardInterrupt:
        print("\nBye!")
