import java.util.Random;
//adding comments
// adding comments

public class Main {
    public static void main(String[] args) {
        int[] solution = solveQueensProblem();
        printBoard(solution);
    }

    /**
     * Solves the N-Queens problem using a hill climbing algorithm.
     * 
     * @return An array representing the solution state.
     */
    private static int[] solveQueensProblem() {
        int[] currentState = generateRandomState(); // Generate a random initial state

        int[] solution = currentState; // Set the initial solution as the current state

        // Initialize counters for state changes and restarts
        int stateChanges = 0;
        int restarts = 0;

        // Continue until a goal state is reached
        while (!isGoalState(currentState)) {
            int[] neighbor = getBestNeighbor(currentState); // Get the best neighbor of the current state
            int currentHeuristic = calculateHeuristic(currentState); // Calculate the heuristic value of the current
                                                                     // state

            // Print current state information
            System.out.println();
            System.out.println("Current h: " + currentHeuristic);
            printBoard(currentState);

            // Calculate the difference in heuristic between current state and its neighbor
            int lowerHeuristic = currentHeuristic - calculateHeuristic(neighbor);
            System.out.println("Neighbors found with lower h: " + lowerHeuristic);

            // If there are no neighbors with lower heuristic, perform a random restart
            if (lowerHeuristic == 0) {
                System.out.println("RESTART");
                currentState = generateRandomState();
                restarts++;
            } else {
                // Otherwise, set the neighbor as the new current state
                System.out.println("Setting new current state");
                currentState = neighbor;
                stateChanges++;
            }

            // Update the solution if the current state has a lower heuristic than the
            // previous solution
            if (calculateHeuristic(currentState) < calculateHeuristic(solution)) {
                solution = currentState;
            }
        }

        // Print solution information
        System.out.println();
        System.out.println("***Solution Found!***");
        System.out.println("Current State");
        System.out.println("State changes: " + stateChanges);
        System.out.println("Restarts: " + restarts);

        return solution;
    }

    /**
     * Generates a random initial state for the N-Queens problem.
     * 
     * @return An array representing the randomly generated state.
     */
    private static int[] generateRandomState() {
        int[] state = new int[8]; // Create an array to hold the state of each column
        Random random = new Random(); // Initialize a random number generator

        // Iterate over each column
        for (int i = 0; i < state.length; i++) {
            state[i] = random.nextInt(8); // Place a queen in a random row of the current column
        }

        return state; // Return the randomly generated state
    }

    /**
     * Checks if the given state represents a goal state in the N-Queens problem,
     * where no two queens can attack each other.
     * 
     * @param state The state to be checked.
     * @return True if the state is a goal state, false otherwise.
     */
    private static boolean isGoalState(int[] state) {
        // Iterate over each queen
        for (int i = 0; i < state.length; i++) {
            // Check against each other queen
            for (int j = i + 1; j < state.length; j++) {
                // Check if queens in the same column or diagonally attack each other
                if (state[i] == state[j] || Math.abs(state[i] - state[j]) == Math.abs(i - j)) {
                    return false; // Conflict found
                }
            }
        }
        return true; // No conflict found, it's a goal state
    }

    /**
     * Finds the neighbor state with the lowest heuristic value from the given
     * state.
     * 
     * @param state The current state.
     * @return The best neighbor state with the lowest heuristic value.
     */
    private static int[] getBestNeighbor(int[] state) {
        int[] bestNeighbor = state; // Initialize the best neighbor with the current state
        int currentHeuristic = calculateHeuristic(state); // Calculate the heuristic of the current state

        // Iterate over each column
        for (int i = 0; i < state.length; i++) {
            // Iterate over each row for the current column
            for (int j = 0; j < state.length; j++) {
                int[] neighbor = state.clone(); // Create a clone of the current state
                neighbor[i] = j; // Move the queen in the current column to the row 'j'
                int neighborHeuristic = calculateHeuristic(neighbor); // Calculate the heuristic of the neighbor state

                // If the neighbor has a lower heuristic, update the bestNeighbor and
                // currentHeuristic
                if (neighborHeuristic < currentHeuristic) {
                    bestNeighbor = neighbor;
                    currentHeuristic = neighborHeuristic;
                }
            }
        }

        return bestNeighbor; // Return the best neighbor found
    }

    /**
     * Calculates the heuristic value for the given state in the N-Queens problem.
     * The heuristic represents the number of conflicts among the queens on the
     * board.
     * 
     * @param state The state representing the positions of the queens on the board.
     * @return The heuristic value indicating the number of conflicts.
     */
    private static int calculateHeuristic(int[] state) {
        int heuristic = 0; // Initialize the heuristic value

        // Iterate over each queen's position
        for (int i = 0; i < state.length; i++) {
            // Compare the queen with other queens
            for (int j = i + 1; j < state.length; j++) {
                // Check for conflicts (same row or diagonal)
                if (state[i] == state[j] || Math.abs(state[i] - state[j]) == Math.abs(i - j)) {
                    heuristic++; // Increase the heuristic for each conflict found
                }
            }
        }

        return heuristic; // Return the calculated heuristic value
    }

    /**
     * Prints the current state of the N-Queens board.
     * The method receives a state array representing the positions of the queens on
     * the board,
     * where each element represents the row index of a queen in a column.
     * 
     * @param state The state array representing the positions of the queens on the
     *              board.
     */
    private static void printBoard(int[] state) {
        int[][] board = new int[8][8]; // Initialize a 2D array to represent the board

        // Mark the positions of the queens on the board
        for (int i = 0; i < state.length; i++) {
            board[state[i]][i] = 1; // Place a queen at the corresponding row and column
        }

        System.out.println("Current State"); // Print the header for the current state

        // Iterate over the board to print each cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + ","); // Print the value of each cell (0 or 1)
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

}