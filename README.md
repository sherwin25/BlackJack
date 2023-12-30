# Object-Oriented Java Blackjack Game

## Table of Contents

- [Object-Oriented Java Blackjack Game](#object-oriented-java-blackjack-game)
  - [Table of Contents](#table-of-contents)
  - [Introduction](#introduction)
  - [Features](#features)
  - [Installation](#installation)
  - [Code Structure](#code-structure)
  - [Object-Oriented Design](#object-oriented-design)
  - [How to Contribute](#how-to-contribute)
  - [License](#license)

## Introduction

This Blackjack game is implemented in Java showcasing Object-Oriented Programming (OOP) principles. It features a console-based user interface and encapsulates the core functionalities of Blackjack, providing an engaging platform for playing the game against a computer dealer.

## Features

- Classic Blackjack gameplay with a standard deck of cards.
- Interactive console-based user interface for easy gameplay.
- Strategic game mechanics where players can hit, stand, and observe the dealer's play.
- Reusable and extendable code base applying OOP principles.

## Installation

To run this game, ensure you have Java Development Kit (JDK) installed on your machine.

1. Clone the repository to your local machine
2. Navigate to the cloned repository.
3. Compile the Java files.
4. Run the game

## Code Structure

- `BlackJack`: The main game engine that controls game flow and rules.
- `BlackJackGUI`: Manages the user interface and user interactions.
- `Card`: A simple class that represents a playing card with a suit and value.
- `Dealer`: Inherits from `GameParticipant` and implements dealer-specific logic.
- `Deck`: Encapsulates a collection of `Card` objects and provides shuffling and dealing functionalities.
- `GameParticipant`: An interface for participants (Player and Dealer) in the game.
- `Player`: Inherits from `GameParticipant` and represents the user playing the game.

## Object-Oriented Design

- **Encapsulation**: Each class has a specific set of responsibilities with private properties and public methods.
- **Inheritance**: `Player` and `Dealer` classes inherit from `GameParticipant`, demonstrating code reuse and behavior specialization.
- **Polymorphism**: The game utilizes polymorphic behavior, especially in handling `Player` and `Dealer` actions, which are both `GameParticipant` types.
- **Abstraction**: `GameParticipant` provides an abstract layer for the game participants, hiding the details of the implementation.

## How to Contribute

If you'd like to contribute to this project, please fork the repository and issue a pull request with your changes. Ensure your contributions adhere to the coding standards established in the project and include appropriate tests.

## License

This project is released under the MIT License. See the LICENSE file for more details.

---

This Blackjack game project is intended to serve as a demonstration of Object-Oriented Programming (OOP) principles in a real-world application for potential employers and collaborators. It's a showcase of clean, modular code, designed with scalability and maintenance in mind.
