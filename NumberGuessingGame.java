import java.util.Scanner;
class NumberGuessingGame { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5; 
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
            System.out.println("Guess a number between " + minRange + " and " + maxRange + ":");
            
            for (int attempts = 1; attempts <= attemptsLimit; attempts++) {
                int userGuess = scanner.nextInt();
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += attemptsLimit - attempts + 1; 
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == attemptsLimit) {
                    System.out.println("Sorry, you've reached the maximum number of attempts.");
                    System.out.println("The correct number was: " + randomNumber);
                }
            }

            System.out.println("Your current score: " + score);
            System.out.println("Do you want to play again? (yes/no)");
            String playChoice = scanner.next().toLowerCase();
            playAgain = playChoice.equals("yes");
        }

        System.out.println("Thanks for playing! Your final score: " + score);
        scanner.close();
    }
}
