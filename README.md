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

_Command: The command pattern encapsulates a players actions into standalone command objects. Located in ticktracktoe.command,
the MoveCommand supports a players move and supports the undo feature. 
Observer: The observer pattern decouples the core game from the user interface. The Board maintains 
a list of BoardObserver, whenever a mark is cleared or placed it broadcast a notification. This allows
the UI to react without knowing anything about the presentation layer.
State: The state pattern manages the game loop by transiton through different phases such as xTurnState or oTurnState.
Strategy: The strategy pattern isolates the win-check algorithm. The win condition implementation will evaluate rows, columns, etc
which will make it easier to swap evaluation rules._

## OO Principles

_(Abstractions: The game relies on interfaces rather than concrete implemenetations to define behaviors.
Polymorphism: The CommandHistory class is designed to execute and undo generic command objects. It will trigger execute or undo without needing
to know the specific concrete class its interacting with. 
Dependency injection: The HumanPlayer class doesn't hardcode inputs received, rather it receives a MoveSource interface through its constructor upon creation.)_
