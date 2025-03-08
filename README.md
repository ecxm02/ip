# User Guide

This guide provides an overview of the commands and features available in our todo list assistant, "Juke"

## Table of Contents
1. [Overview](#overview)
2. [Installation](#installation)
3. [Usage](#usage)
   - [Adding Tasks](#adding-tasks)
   - [Managing Tasks](#managing-tasks)
   - [Searching Tasks](#searching-tasks)
4. [Commands Reference](#commands-reference)

## Overview

This application is a task manager that supports adding, listing, marking, unmarking, deleting, and searching tasks. Tasks are of three types:
- Todo
- Deadline
- Event

## Installation

1. Ensure you have Java installed (Java 17 preferred).
2. Download the latest JAR file from the repository's release page
3. Open Powershell or Command Prompt in the same directory where the JAR file is saved
4. Run the program with the command `java -jar Juke.jar`'
5. You should see the following output `Hello! I'm Juke Excited to talk to you! :)`

## Usage

### Adding Tasks

- **Todo:**  
  `todo Buy groceries`  
  Adds a new todo task with the description "Buy groceries".

- **Deadline:**  
  `deadline Submit report /by 2023-12-31`  
  Adds a deadline task with the description "Submit report" and deadline "2023-12-31".

- **Event:**  
  `event Conference /from 2023-12-01 /to 2023-12-03`  
  Adds an event with the description "Conference" starting on "2023-12-01" and ending on "2023-12-03".

### Managing Tasks

- **Mark Task as Completed:**  
  `mark 1`  
  Marks task number 1 as completed.

- **Unmark Task:**  
  `unmark 1`  
  Marks task number 1 as incomplete.

- **Delete Task:**  
  `delete 1`  
  Deletes task number 1.

- **List Tasks:**  
  `list`  
  Displays all tasks in the task list.

- **Clear Task List:**  
  `clear`  
  Clears all tasks from the list.

- **Exit Application:**  
  `bye`  
  Exits the application.

### Searching Tasks

- **Search:**  
  `search keyword`  
  Searches for tasks containing the specified keyword in the description.

## Commands Reference

| Command            | Format                                           | Description                                      |
| ------------------ | ------------------------------------------------ | ------------------------------------------------ |
| **todo**           | `todo <task description>`                        | Adds a new todo task.                            |
| **deadline**       | `deadline <task description> /by <yyyy-MM-dd>`   | Adds a new deadline task.                        |
| **event**          | `event <task description> /from <yyyy-MM-dd> /to <yyyy-MM-dd>` | Adds a new event task.                   |
| **mark**           | `mark <task number>`                             | Marks a task as completed.                       |
| **unmark**         | `unmark <task number>`                           | Marks a task as incomplete.                      |
| **delete**         | `delete <task number>`                           | Deletes a task from the list.                    |
| **list**           | `list`                                           | Lists all tasks.                                 |
| **search**         | `search <keyword>`                               | Searches tasks by keyword.                       |
| **clear**          | `clear`                                          | Clears the task list.                            |
| **bye**            | `bye`                                            | Exits the application.                           |
| **help**           | `help`                                           | Displays help information.                       |

---

This user guide helps you understand the application's basic functionality and how to interact with it using the provided commands.
