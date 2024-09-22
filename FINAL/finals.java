import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class finals {
    public static void main(String[] args) {
        ImageIcon icon1 = new ImageIcon("controller.jpg");
        ImageIcon icon2 = new ImageIcon("NumberGuess.jpg");
        ImageIcon icon3 = new ImageIcon("RPS.jpg");
        ImageIcon icon4 = new ImageIcon("hangman.jpg");
        ImageIcon icon5 = new ImageIcon("IQ.jpg");
        ImageIcon icon6 = new ImageIcon("Decision.jpg");
        ImageIcon icon7 = new ImageIcon("Dice.jpg");
        ImageIcon icon8 = new ImageIcon("Flip.jpg");
        ImageIcon icon9 = new ImageIcon("User.jpg");
        ImageIcon icon10 = new ImageIcon("Computer.jpg");
        ImageIcon icon11 = new ImageIcon("Tie.jpg");
        String game_options[] = { "Number Guesser  ❔", "Rock Paper Scissors", "IQ test 🤔", "Decision", "HangmanGame",
                "Exit  ❌" };
        while (true) {
            int choose = JOptionPane.showOptionDialog(null, "Choose a game to PLAY!", "Minigame Mania 🎮", 0,
                    JOptionPane.INFORMATION_MESSAGE, icon1,
                    game_options, 0);
            if (choose == 1) {
                int exit;
                String options[] = { "Rock", "Paper", "Scissors" };
                String options2[] = { "Exit", "Play Again!" };
                while (true) {
                    int Uchoice = JOptionPane.showOptionDialog(null, "Enter your choice", "CHOOSE!",
                            JOptionPane.INFORMATION_MESSAGE,
                            JOptionPane.QUESTION_MESSAGE, icon3,
                            options, 0);
                    if (Uchoice == -1)
                        break;
                    double num = Math.random() * 3;
                    num = Math.floor(num);
                    int Cchoice = (int) num;
                    int[][] answers = { { 0, 1, 2 }, { 2, 0, 1 }, { 1, 2, 0 } }; // 1-Computer wins 2-User wins 0-Tie
                    if (answers[Uchoice][Cchoice] == 2) {
                        exit = JOptionPane.showOptionDialog(null,
                                "You choosed " + options[Uchoice]
                                        + "\n----------------------------------------------------\nComputer chooses "
                                        + options[Cchoice]
                                        + "\n----------------------------------------------------\n<----       YOU WON!       ---->",
                                "Congratulations 🥳",
                                Uchoice, JOptionPane.PLAIN_MESSAGE, icon9, options2, 0);
                        if ((exit == 0) || (exit == -1))
                            break;
                    } else if (answers[Uchoice][Cchoice] == 1) {
                        exit = JOptionPane.showOptionDialog(null,
                                "You choosed " + options[Uchoice]
                                        + "\n----------------------------------------------------\nComputer chooses "
                                        + options[Cchoice]
                                        + "\n----------------------------------------------------\n<----       Computer wins!       ---->",
                                "LOL! Get better 😆",
                                Uchoice, JOptionPane.PLAIN_MESSAGE, icon10, options2, 0);
                        if ((exit == 0) || (exit == -1))
                            break;
                    } else if (answers[Uchoice][Cchoice] == 0) {
                        exit = JOptionPane.showOptionDialog(null,
                                "You choosed " + options[Uchoice]
                                        + "\n----------------------------------------------------\nComputer chooses "
                                        + options[Cchoice]
                                        + "\n----------------------------------------------------\n<----       It's a Tie!       ---->",
                                "IT'S A TIE!!! 🤐",
                                Uchoice, JOptionPane.PLAIN_MESSAGE, icon11, options2, 0);
                        if ((exit == 0) || (exit == -1))
                            break;
                    }
                }
            } else if (choose == 0) {
                String options[] = { "Generate", "Exit" };
                String select[] = { "Give up 😞", "Continue 💪🏾" };
                while (true) {
                    int option = JOptionPane.showOptionDialog(null, "Generate a number between 1-100: ",
                            "Number Guessing", 0,
                            JOptionPane.QUESTION_MESSAGE, icon2, options,
                            0);
                    if (option == 0) {
                        double b = Math.random() * 100;
                        b += 1;
                        int guess_number = (int) b;
                        System.out.println(guess_number);
                        while (true) {
                            String x = JOptionPane.showInputDialog(null, "Guess the number: ", "GUESS",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (x == null) {
                                JOptionPane.showMessageDialog(null, "Game Terminated", "END",
                                        JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                            if (check(x)) {
                                int guessed = Integer.parseInt(x);
                                if (guess_number == guessed) {
                                    JOptionPane.showMessageDialog(null, "You guessed it right", "Congratulations",
                                            JOptionPane.CLOSED_OPTION);
                                    break;
                                } else {
                                    if (guess_number < guessed) {
                                        int new_option = JOptionPane.showOptionDialog(null, "Guess Lower!",
                                                "Wrong", 0,
                                                JOptionPane.QUESTION_MESSAGE, null, select, 0);

                                        if (new_option == 0) {
                                            JOptionPane.showMessageDialog(null, "You are weak",
                                                    "Never Back down never what",
                                                    JOptionPane.QUESTION_MESSAGE);
                                            break;
                                        } else if (new_option == 1) {
                                            continue;
                                        }
                                    } else {
                                        int new_option = JOptionPane.showOptionDialog(null, "Guess Higher!",
                                                "Wrong", 0,
                                                JOptionPane.QUESTION_MESSAGE, null, select, 0);

                                        if (new_option == 0) {
                                            JOptionPane.showMessageDialog(null, "You are weak",
                                                    "Never Back down never what",
                                                    JOptionPane.QUESTION_MESSAGE);
                                            break;
                                        } else if (new_option == 1) {
                                            continue;
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else if ((option == 1) || (option == -1))
                        break;
                }

            } else if ((choose == 5) || (choose == -1)) {
                JOptionPane.showMessageDialog(null, "Please come again. 😊", "Thanks!",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            } else if (choose == 4) {
                while (true) {
                    String hangman[] = { "\n / \\ ", "\n /|\\", "\n O", "\n  |", "\n  +---+---+" };
                    String playing[] = { "Generate Random Word", "Back to the menu" };
                    int user1 = JOptionPane.showOptionDialog(null, "Play the game!", "Start", 0,
                            JOptionPane.QUESTION_MESSAGE,
                            icon4,
                            playing, 0);
                    if (user1 == 0) {

                        String options[] = { "Yes!", "Back to the main menu" };
                        int guesses = 5;
                        String words[] = { "HELLO", "ALVISHBHAI", "CANCER", "PAJAMAS" };
                        int count = 0;
                        double x = Math.random() * 4;
                        int random = (int) x;
                        char[] ans = new char[words[random].length()];
                        for (int i = 0; i < ans.length; i++) {
                            ans[i] = '_';
                        }
                        while (count < words[random].length()) {
                            String hangy = "";
                            boolean check = true;
                            String answer = "";
                            String s = JOptionPane.showInputDialog(null, "Enter a character", "Guess!",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (s == null) {
                                JOptionPane.showMessageDialog(null, "Game Terminated", "END",
                                        JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                            if (s.length() == 1) {
                                char ch = s.charAt(0);
                                ch = Character.toUpperCase(ch);
                                if (Character.isDigit(ch)) {
                                    JOptionPane.showMessageDialog(null, "Please Enter an Alphabet", "Error!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                } else {
                                    for (int i = 0; i < words[random].length(); i++) {
                                        if (words[random].charAt(i) == ch) {
                                            ans[i] = ch;
                                            check = false;
                                        }
                                    }
                                    if (check)
                                        guesses--;
                                }
                                for (int i = 4; i >= guesses; i--) {
                                    hangy += hangman[i];
                                }
                                if (guesses == 0) {
                                    JOptionPane.showMessageDialog(null,
                                            "The word was " + words[random]
                                                    + "\n---------------------------------------------\nBetter luck next time!"
                                                    + "\n---------------------------------------------\n" + hangy,
                                            "Nice Try!", random);
                                    break;
                                }
                                for (int i = 0; i < ans.length; i++) {
                                    answer += ans[i];
                                    answer += " ";
                                }
                                boolean check2 = true;
                                for (int i = 0; i < ans.length; i++) {
                                    if (ans[i] == '_') {
                                        check2 = false;
                                    }
                                }
                                if (check2) {
                                    JOptionPane.showMessageDialog(null,
                                            "The word was " + words[random]
                                                    + "\n-------------------------------------------------------------------\nCongratulations! You won!",
                                            "Hooray!",
                                            JOptionPane.PLAIN_MESSAGE);
                                    break;
                                }
                                JOptionPane.showMessageDialog(null,
                                        "Current progress:   " + answer
                                                + "\n-----------------------------------------------------\nGuesses left: "
                                                + guesses + "\n" + hangy,
                                        "Fake it till you make it",
                                        JOptionPane.INFORMATION_MESSAGE);

                            } else {
                                JOptionPane.showMessageDialog(null, "Enter a single character", "Error!",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        int user = JOptionPane.showOptionDialog(null, "Want to play again?", "Had Fun?", 0,
                                JOptionPane.QUESTION_MESSAGE, icon1, options,
                                0);
                        if (user == 0)
                            continue;
                        else if ((user == -1) || (user == 1))
                            break;
                    } else
                        break;
                }
            } else if (choose == 2) {
                int correct[] = { 3, 2, 3, 1, 2 };
                String iQ[] = { "Seek HELP! ☠️", "Low IQ 💀", "Decent IQ 😐", "Average IQ 😒", "Above Average IQ 😏",
                        "High IQ 🤤" };
                int user_answers[] = new int[5];
                String exe[] = { "Yes", "No" };
                String[][] answers = {
                        { "A) Grandmother", "B) Mother", "C) GrandDaughter", "D) Daughter" },
                        { "A) 10", "B) 11", "C) 13", "D) 12" },
                        { "A) Brother-in-law", "B) Daughter", "C) Husband", "D) Sister-in-law" },
                        { " A) Mother: 40, Son: 20", "B) Mother: 50, Son: 25", "C) Mother: 60, Son: 30",
                                "D) Mother: 80, Son: 40" },
                        { "A) They lost one fish", " B) One fish is eaten", "C) One person is both a father and a son",
                                "D) One fish is released back" }
                };
                String riddles[] = { "If Teresa’s daughter is my daughter’s mother, what am I to Teresa?",
                        "Toby has 10 siblings (4 girls and 6 boys) and mother and father. How many people are in there in Toby’s family?",
                        "A is the father of C and D is the son of B. E is brother of A, If C is sister of D, How is B related to E?",
                        "A mother is twice as old as her son. 20 years ago, she was 10 times older than her son. How old are they now?",
                        "Two fathers and two sons go fishing. Each of them catches one fish. So why do they bring home only three fish?" };
                while (true) {
                    int count = 0;
                    int handle = 0;
                    for (int i = 0; i < riddles.length; i++) {
                        user_answers[i] = JOptionPane.showOptionDialog(null, riddles[i],
                                "Riddle no: " + (i + 1), 0, JOptionPane.QUESTION_MESSAGE, icon5, answers[i], 0);
                        if (user_answers[i] == -1)
                            break;
                        handle++;
                    }
                    if (handle == 5) {
                        for (int i = 0; i < correct.length; i++) {
                            if (correct[i] == user_answers[i])
                                count++;
                            else
                                continue;
                        }
                        JOptionPane.showMessageDialog(null,
                                "Correct answers were: " + count + "/5"
                                        + "\n---------------------------------------------\nYour IQ: "
                                        + iQ[count],
                                "Result",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Quiz Cancelled", "Terminated",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    int executing = JOptionPane.showOptionDialog(null, "Want to try again?", "Re-Try", 0,
                            JOptionPane.QUESTION_MESSAGE, null, exe, 0);
                    if (executing == 0)
                        continue;
                    else
                        break;
                }
            } else if (choose == 3) {
                while (true) {
                    String choice1[] = { "Roll a Dice (oﾟvﾟ)ノ", "Flip a Coin 🌍", "Go Back to the menu! \\^o^/" };
                    String choice2[] = { "ROLL!", "Go Back" };
                    String choice3[] = { "FLIP!", "Go Back" };
                    int option = JOptionPane.showOptionDialog(null, "Choose your pick!", "CHOOSE! 🤓",
                            0,
                            JOptionPane.QUESTION_MESSAGE, icon6, choice1, 0);
                    if (option == 0) {
                        while (true) {
                            int new_option = JOptionPane.showOptionDialog(null, "Roll the Dice", "Roll!", 0,
                                    JOptionPane.QUESTION_MESSAGE, icon7, choice2, 0);
                            if (new_option == 0) {
                                double random = Math.random() * 6;
                                random += 1;
                                int generated = (int) random;
                                JOptionPane.showMessageDialog(null, "Dice Rolled a " + generated + "!", "Result",
                                        JOptionPane.INFORMATION_MESSAGE);
                            } else if ((new_option == 1) || (new_option == -1)) {
                                break;
                            }
                        }
                    } else if (option == 1) {
                        while (true) {
                            int new_option = JOptionPane.showOptionDialog(null, "Flip the Coin", "FLIP! (✿◡‿◡)", 0,
                                    JOptionPane.ERROR_MESSAGE, icon8, choice3, 0);
                            if (new_option == 0) {
                                double random = Math.random() * 2;
                                int generated = (int) random;
                                String[] answer = { "HEADS", "TAILS" };
                                JOptionPane.showMessageDialog(null, "Coin flipped " + answer[generated] + "!", "Result",
                                        JOptionPane.INFORMATION_MESSAGE);
                            } else if ((new_option == 1) || (new_option == -1)) {
                                break;
                            }
                        }
                    } else if ((option == 2) || (option == -1)) {
                        break;
                    }
                }
            }
        }
    }

    static boolean check(String a) {
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (!Character.isDigit(ch))
                return false;
        }
        return true;
    }
}
