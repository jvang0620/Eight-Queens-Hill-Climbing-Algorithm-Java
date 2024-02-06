import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] solution = solveQueensProblem();
        printBoard(solution);
    }

    private static int[] solveQueensProblem() {
        int[] currentState = generateRandomState();
        int[] solution = currentState;
        int stateChanges = 0;
        int restarts = 0;

        while (!isGoalState(currentState)) {
            int[] neighbor = getBestNeighbor(currentState);
            int currentHeuristic = calculateHeuristic(currentState);

            System.out.println();
            System.out.println("Current h: " + currentHeuristic);
            printBoard(currentState);
            int lowerHeuristic = currentHeuristic - calculateHeuristic(neighbor);
            System.out.println("Neighbors found with lower h: " + lowerHeuristic);

            if (lowerHeuristic == 0) {
                System.out.println("RESTART");
                currentState = generateRandomState(); // Perform random restart
                restarts++;
            } else {
                System.out.println("Setting new current state");
                currentState = neighbor;
                stateChanges++;
            }

            if (calculateHeuristic(currentState) < calculateHeuristic(solution)) {
                solution = currentState;
            }
        }

        System.out.println();
        System.out.println("Solution Found!");
        System.out.println("State changes: " + stateChanges);
        System.out.println("Restarts: " + restarts);

        return solution;
    }

    private static int[] generateRandomState() {
        int[] state = new int[8];
        Random random = new Random();

        for (int i = 0; i < state.length; i++) {
            state[i] = random.nextInt(8); // Place a queen in a random row of each column
        }

        return state;
    }

    private static boolean isGoalState(int[] state) {
        for (int i = 0; i < state.length; i++) {
            for (int j = i + 1; j < state.length; j++) {
                if (state[i] == state[j] || Math.abs(state[i] - state[j]) == Math.abs(i - j)) {
                    return false; // Conflict found
                }
            }
        }
        return true; // No conflict found
    }

    private static int[] getBestNeighbor(int[] state) {
        int[] bestNeighbor = state;
        int currentHeuristic = calculateHeuristic(state);

        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state.length; j++) {
                int[] neighbor = state.clone();
                neighbor[i] = j;
                int neighborHeuristic = calculateHeuristic(neighbor);

                if (neighborHeuristic < currentHeuristic) {
                    bestNeighbor = neighbor;
                    currentHeuristic = neighborHeuristic;
                }
            }
        }

        return bestNeighbor;
    }

    private static int calculateHeuristic(int[] state) {
        int heuristic = 0;

        for (int i = 0; i < state.length; i++) {
            for (int j = i + 1; j < state.length; j++) {
                if (state[i] == state[j] || Math.abs(state[i] - state[j]) == Math.abs(i - j)) {
                    heuristic++; // Increase heuristic for each conflict found
                }
            }
        }

        return heuristic;
    }

    private static void printBoard(int[] state) {
        int[][] board = new int[8][8];

        for (int i = 0; i < state.length; i++) {
            board[state[i]][i] = 1;
        }

        System.out.println("Current State");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
        // System.out.println();
    }
}
