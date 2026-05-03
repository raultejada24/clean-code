# Clean Code Assisted by AI - Presentation Demo

This repository contains the code snippet used for the "Clean Code Assisted by AI" presentation (Software Quality subject, 2026).

## Overview

The goal of this demo is to analyze how AI tools (like GitHub Copilot, Cursor, or Gemini) handle legacy, poorly structured code. We evaluate whether the AI can successfully apply Clean Code principles (SRP, DRY, meaningful names) or if it introduces new technical debt (e.g., overengineering).

## Repository Structure

*   `prompt.txt`: The exact prompt used to guide the AI agent during the refactoring process.
*   `/BeforeRefactoring`: Contains `OrderManagerDirty.java`, the initial "Dirty Code" containing several classic Code Smells (God Method, Magic Numbers, High Coupling).
*   `/AfterRefactoring`: Contains the result proposed by the AI agent during the demo (`OrderManagerClean.java`) along with the extracted interfaces (`DiscountCalculator.java`, `NotificationService.java`, `OrderRepository.java`). It implements interface extraction, dependency injection, and intention-revealing names.

## Demo Video

You can watch the full refactoring process and our critical analysis here:
[Link to YouTube Video](https://youtu.be/c5FQo9acjZI)
