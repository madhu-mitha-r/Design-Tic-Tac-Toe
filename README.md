# Design Tic-Tac-Toe

Low-level design of a Tic-Tac-Toe game in Java. Supports human and bot players, configurable board size, pluggable winning strategies (row, column, diagonal), bot difficulty levels, and undo.

## Run

`bin/` is gitignored — the first command below creates it and compiles into it.

```bash
javac -d bin $(find src -name "*.java")
java -cp bin App
```

## Structure

- `src/App.java` — entry point
- `src/Controllers/` — `TicTacToeController` orchestrates game lifecycle
- `src/models/` — `Board`, `Cell`, `Player` (`Human`, `Bot`), `Move`, `Symbol`, `GameState`, `TicTacToeGame`
- `src/stratergies/` — `WiningStrategy` (Row/Column/Diagonal) and `BotDifficultStrategy` (Easy/Medium/Hard)
- `src/factories/` — `BotDifficultlyStrategyFactory` builds bot strategy from difficulty level
- `src/Exceptions/` — `InvalidCellException`, `CellAlreadyFilledException`

## Features

- N x N board, 2+ players
- Human and Bot players with Easy / Medium / Hard difficulty
- Winning detection via composable strategies
- Undo last move
