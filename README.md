# N-Queens Problem Solver

### Overview:

This Java program implements a solution to the classic N-Queens problem using a hill climbing algorithm. The N-Queens problem involves placing N chess queens on an N×N chessboard so that no two queens threaten each other; thus, a solution requires that no two queens share the same row, column, or diagonal.

This program was created from the ground up, drawing inspiration from various sources.

### Examples of Program Output Screenshots

![Examples Of Program](/imgs/img_1a.PNG)
![Examples Of Program](/imgs/img_1b.PNG)

### Features:

- Hill Climbing Algorithm: The program employs a hill climbing algorithm to iteratively improve the placement of queens on the board until a solution is found.

- Random Restart: If the algorithm reaches a local maximum where no better moves are possible, it performs a random restart to escape from local optima.

- Heuristic Evaluation: The heuristic function evaluates the quality of a state based on the number of conflicts between queens, aiding in the decision-making process to select the best neighbor state.

### Components:

- Main Class: The entry point of the program. It orchestrates the solving process and prints the final solution.

- State Generation: The generateRandomState() method initializes a random state representing the initial placement of queens on the board.

- Goal State Check: The isGoalState() method determines whether a given state satisfies the conditions of a solution.

- Neighbor Selection: The getBestNeighbor() method identifies the best neighbor state with the lowest heuristic value.

- Heuristic Calculation: The calculateHeuristic() method computes the heuristic value for a given state based on the number of conflicts.

- Board Visualization: The printBoard() method displays the current state of the board, facilitating visualization of queen placements.

### Usage:

1. Compile: Compile the Java source code using javac Main.java.
2. Run: Execute the compiled program with java Main.
3. Output: The program will display the progress of the solution process, including the current state, heuristic values, and solution details.

### Developed Using:

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)

### Source:

[N-Queens Problem](https://rosettacode.org/wiki/N-queens_problem#Java)
[N-Queen Problem | Local Search using Hill climbing with random neighbour](https://www.geeksforgeeks.org/n-queen-problem-local-search-using-hill-climbing-with-random-neighbour/#)
