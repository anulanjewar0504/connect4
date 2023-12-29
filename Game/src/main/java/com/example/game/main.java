package com.example.game;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class main extends Application {
    private  Controller controller;

    public void start(Stage primayStage) throws Exception{
        FXMLLoader fxmlLoader= new FXMLLoader(main.class.getResource("hello-view.fxml"));
        GridPane Gp= fxmlLoader.load();
        controller =fxmlLoader.getController();
        controller.Playground();
        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primayStage.widthProperty());
        Pane menupane = (Pane) Gp.getChildren().get(0);
        menupane.getChildren().add(menuBar);
        Scene scene = new Scene(Gp);

        primayStage.setScene(scene);
        primayStage.setTitle("Connect Four");
        primayStage.setResizable(false);
        primayStage.show();
    }
    private MenuBar createMenu() {
        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New game");
        newGame.setOnAction(actionEvent -> controller.resetGame());

        MenuItem Restart = new MenuItem("Restart");
        Restart.setOnAction(actionEvent -> controller.resetGame());

        SeparatorMenuItem s2 = new SeparatorMenuItem();

        MenuItem Quit = new MenuItem("Quit");
        Quit.setOnAction(actionEvent -> Exit());

        MenuBar menuBar = new MenuBar();
        fileMenu.getItems().addAll(newGame,Restart,s2,Quit);

        //help menu
        Menu helpMenu = new Menu("Help");

        MenuItem about =new MenuItem("About");
        about.setOnAction(actionEvent -> about());

        SeparatorMenuItem s3 = new SeparatorMenuItem();

        MenuItem me =new MenuItem("About Me");
        me.setOnAction(actionEvent -> me());

        helpMenu.getItems().addAll(about,s3,me);
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;

    }

    private void me() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About me");
        alert.setHeaderText("Hi");
        alert.setContentText("Meet Anurag Lanjewar, "+
                "a talented Java developer with a passion for creating engaging games. " +
                "With a keen eye for innovation and a knack for problem-solving, " +
                "Anurag has taken on the challenge of developing a captivating Connect 4 game. " +
                "Through his coding expertise and dedication, " +
                "he aims to bring joy and excitement to players of all ages. " +
                "Get ready to experience the thrill of Connect 4, " +
                "crafted by the skilled hands of Anurag Lanjewar.");
        alert.show();

    }

    private void about() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("How to play game?");
        alert.setContentText("Connect 4 is a two-player game played on a vertical grid." +
                "Players take turns dropping their colored discs into one of the seven columns." +
                "The objective is to be the first to connect four of your discs in a row," +
                "either horizontally, vertically, or diagonally. " +
                "Plan your moves to block your opponent while aiming for your own winning combination." +
                "The first player to connect four discs wins!");
        alert.show();

    }

    private void Exit() {
        Platform.exit();
        System.exit(0);

    }


    public static void main(String[] args) {
        launch(args);
    }

}