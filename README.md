# N-Queens Problem Solver

### Overview:

This Java program implements a solution to the classic N-Queens problem using a hill climbing algorithm. The N-Queens problem involves placing N chess queens on an N×N chessboard so that no two queens threaten each other; thus, a solution requires that no two queens share the same row, column, or diagonal.

This program was created from the ground up, drawing inspiration from various sources.

### Examples of Program Output Screenshots

![Examples Of Program](/imgs/img_1a.PNG)
![Examples Of Program](/imgs/img_1b.PNG)

##### 'Current h' Meaning:

- <u>"Current h"</u> stands for "Current heuristic value." The heuristic value represents an estimation of how close a given state is to the goal state in the N-Queens problem. It's a measure of how many conflicts (queens attacking each other) exist in the current state

##### 'Neighbors found with lower h' Meaning:

- <u>"Neighbors found with lower h"</u> refers to the number of neighboring states (or configurations of the N-Queens board) where the heuristic value is lower than the heuristic value of the current state. In the context of the N-Queens problem solved by a hill climbing algorithm, "lower h" indicates states that are closer to the goal state, as they have fewer conflicts among the queens.

- When the program prints <u>"Neighbors found with lower h"</u> it's indicating how many neighboring states have been found where the heuristic value (h) is lower, suggesting potential moves that might lead to an improvement in the current state. This information helps in deciding whether to make a move to a neighbor or perform a random restart if no better neighbors are found.

##### 'State changes' and 'Restart' Meaning:

- When the solution is found in the context of the N-Queens problem solved by a hill climbing algorithm, <u>"state changes"</u> refers to the number of times the algorithm transitioned from one state to another during its search process. Each state change represents a move made by the algorithm, either to a neighboring state with a lower heuristic value or as a result of a random restart.

- <u>"Restarts"</u> indicates the number of times the algorithm performed a random restart. A random restart occurs when the algorithm gets stuck in a local minimum, meaning it cannot find any neighboring states with lower heuristic values. In such cases, the algorithm resets to a new random initial state and continues its search for a solution from there.

### Features:

- <u>Hill Climbing Algorithm</u>: The program employs a hill climbing algorithm to iteratively improve the placement of queens on the board until a solution is found.

- <u>Random Restart</u>: If the algorithm reaches a local maximum where no better moves are possible, it performs a random restart to escape from local optima.

- <u>Heuristic Evaluation</u>: The heuristic function evaluates the quality of a state based on the number of conflicts between queens, aiding in the decision-making process to select the best neighbor state.

### Components:

- <u>Main Class</u>: The entry point of the program. It orchestrates the solving process and prints the final solution.

- <u>State Generation</u>: The generateRandomState() method initializes a random state representing the initial placement of queens on the board.

- <u>Goal State Check</u>: The isGoalState() method determines whether a given state satisfies the conditions of a solution.

- <u>Neighbor Selection</u>: The getBestNeighbor() method identifies the best neighbor state with the lowest heuristic value.

- <u>Heuristic Calculation</u>: The calculateHeuristic() method computes the heuristic value for a given state based on the number of conflicts.

- <u>Board Visualization</u>: The printBoard() method displays the current state of the board, facilitating visualization of queen placements.

### Usage:

1. <u>Compile</u>: Compile the Java source code using `javac Main.java`.
2. <u>Run</u>: Execute the compiled program with `java Main`.
3. <u>Output</u>: The program will display the progress of the solution process, including the current state, heuristic values, and solution details.

### Developed Using:

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)

### Source:

[N-Queens Problem](https://rosettacode.org/wiki/N-queens_problem#Java)
[N-Queen Problem | Local Search using Hill climbing with random neighbour](https://www.geeksforgeeks.org/n-queen-problem-local-search-using-hill-climbing-with-random-neighbour/#)
