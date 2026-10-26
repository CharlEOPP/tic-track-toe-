# Tic-Track-Toe

Two-player tic-tac-toe in Java that tracks wins and losses across sessions.

**Team:** Charlie Copp, Abdirahman Ebiso

## Build & Run

Requires JDK 17 or newer.

```bash
./gradlew run     # play
./gradlew test    # run tests
```

On Windows, use `gradlew.bat` instead of `./gradlew`.

## Project Layout

| Package | Purpose |
|---|---|
| `tictracktoe.model` | Board, Position, Mark, Player |
| `tictracktoe.command` | Command pattern: move and undo |
| `tictracktoe.state` | State pattern: turn handling |
| `tictracktoe.win` | Strategy pattern: win conditions |
| `tictracktoe.observer` | Observer pattern: board and game events |
| `tictracktoe.persistence` | Win/loss stats storage |
| `tictracktoe.ui` | Console view |

## Design Patterns

_(Command, Observer, State, Strategy: to be documented)_

## OO Principles

_(Abstractions, polymorphism, dependency injection: to be documented)_
