package Controllers;

import Restaurant.Inventory;
import Restaurant.WorkForce;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("manager_options.fxml"));

        Scene scene = new Scene(root, 300, 275);

        primaryStage.setTitle("Restaurant Control");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    private void setPrimaryStage(Stage stage) {
        Main.primaryStage = stage;
    }

    static public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) throws IOException {

        launch(args);

        Inventory inventory = new Inventory();
        WorkForce workForce = new WorkForce();


        //grab this neat trick from geeks for geeks
        // check if length of args array is
        // greater than 0
        if (args.length > 0) {
            System.out.println("The command line" +
                    " arguments are:");

//             iterating the args array and printing
//             the command line arguments
            for (String val : args) {
                System.out.println(val + "\n\n");

                if (val.equals("manager")) {

            /*
            command line arguments work but i went a step further and made a trial login attempt
             */
                    Scanner keyboard = new Scanner(System.in);
                    System.out.println("Would you like to interact with the workforce or the inventory?\n" +
                            "1. Inventory." +
                            "2. Workforce.");
                    int pick = keyboard.nextInt();

                    if (pick == 1) {

                        System.out.println("How would you like to interact with the inventory?\n" +
                                "1. Add an item.\n" +
                                "2. Delete an item.\n" +
                                "3. Update an existing item.\n" +
                                "4. View an all existing items.\n");


                        int choice = keyboard.nextInt();


                        if (choice == 1) {
                            inventory.addItem();
                        } else if (choice == 2) {
                            inventory.deleteItem();
                        } else if (choice == 3) {
                            inventory.updateItem();
                        } else if (choice == 4) {
                            inventory.printItems();
                        }
                    } else if (pick == 2) {
                        System.out.println("How would you like to interact with the workforce?\n" +
                                "1. Add an employee.\n" +
                                "2. Delete an employee.\n" +
                                "3. Update an existing employee.\n" +
                                "4. View an all existing employees.\n");
                        int choice = keyboard.nextInt();

                        if (choice == 1) {
                            workForce.add();
                        } else if (choice == 2) {
                            workForce.delete();
                        } else if (choice == 3) {
                            workForce.update();
                        } else if (choice == 4) {
                            workForce.printEmployees();
                        }
                    } else if (val.equals("employee")) {
                        System.out.println("Welcome! here is our existing inventory.\n");
                        inventory.printItems();

                    }

                } else
                    System.out.println("No command line " +
                            "arguments found.");


            }
        }
    }
}



