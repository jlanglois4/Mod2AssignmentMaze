package edu.wctc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maze maze = new Maze(new Player());
        System.out.println("Enter \"help\" to see a list of commands.");
        char repeat = 0;

        do {
            maze.restartMaze();
            do {
                System.out.println("You are in " + maze.getCurrentRoomName());  // room name

                System.out.println(maze.getCurrentRoomDescription());  // room description

                System.out.println("You can go: " + maze.getCurrentRoomExits());   // what exits are available

                System.out.println("What do you do?");

                switch (scanner.nextLine().toLowerCase()) {
                    case "n": {
                        System.out.print("You head north...");
                        maze.move('n');
                        break;
                    }
                    case "s": {
                        System.out.print("You head south...");
                        maze.move('s');
                        break;
                    }
                    case "w": {
                        System.out.print("You head west...");
                        maze.move('w');
                        break;
                    }
                    case "e": {
                        System.out.print("You head east...");
                        maze.move('e');
                        break;
                    }
                    case "u": {
                        System.out.print("You head up...");
                        maze.move('u');
                        break;
                    }
                    case "d": {
                        System.out.print("You head down...");
                        maze.move('d');
                        break;
                    }
                    case "i": {
                        System.out.println(maze.interactWithCurrentRoom());
                        break;
                    }
                    case "l": {
                        System.out.println(maze.lootCurrentRoom());
                        break;
                    }
                    case "x": {
                        System.out.println(maze.exitCurrentRoom());
                        break;
                    }
                    case "v": {
                        System.out.println("You open up your inventory and find: " + maze.getPlayerInventory());
                        break;
                    }
                    case "help": {
                        System.out.println("Available commands are:\n" +
                                "N: To go north.\n" +
                                "S: To go south.\n" +
                                "W: To go west.\n" +
                                "E: To go east.\n" +
                                "U: To go up.\n" +
                                "D: To go down.\n" +
                                "I: To interact with current location.\n" +
                                "L: To loot something in the current location.\n" +
                                "X: To end the game, if applicable.\n" +
                                "V: To view inventory.");
                    }
                    default:{
                        System.out.println("Please pick a valid option.");
                    }

                }
            } while (!maze.isFinished());

            System.out.println("Final score: " + maze.getPlayerScore());

            boolean choice = false;
            do {
                    System.out.println("Would you like to play again? y/n");
                    repeat = scanner.nextLine().toLowerCase().charAt(0);
                    if (repeat == 'y' || repeat == 'n'){
                        choice = true;
                    }
            } while (!choice);

        } while (repeat != 'n');

    }


}