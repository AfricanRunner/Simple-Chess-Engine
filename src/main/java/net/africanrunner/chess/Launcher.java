package net.africanrunner.chess;

import net.africanrunner.chess.AI.AISettings;
import net.africanrunner.chess.Board.Board;
import net.africanrunner.chess.Board.BoardController;
import net.africanrunner.chess.Board.Mode;
import net.africanrunner.chess.Player.ComputerPlayer;
import net.africanrunner.chess.Player.Player;
import net.africanrunner.position.Position;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class Launcher extends Application
{
    public BoardController b;
    private Stage launcherWindow;
    public static File filePath = new File((new File("")).getAbsolutePath() + "/Chess");

    private Player blackPlayer;
    private Player whitePlayer;

    @Override
    public void start(Stage launcherWindow)
    {
        System.out.println(filePath.getAbsolutePath());
        this.launcherWindow = launcherWindow;

        Label white = new Label("White Player");
        Label black = new Label("Black Player");

        HBox titles = new HBox(10);
        titles.getChildren().addAll(white, black);
        titles.setAlignment(Pos.CENTER);


        ChoiceBox<String> whitePlayers = new ChoiceBox<>();
        whitePlayers.getItems().addAll(Player.PLAYER_TYPES);
        whitePlayers.setOnAction(e -> {
            whitePlayer = Player.parsePlayer(whitePlayers.getValue(), true);
        });

        ChoiceBox<String> blackPlayers = new ChoiceBox<>();
        blackPlayers.getItems().addAll(Player.PLAYER_TYPES);
        blackPlayers.setOnAction(e -> {
            blackPlayer = Player.parsePlayer(blackPlayers.getValue(), false);
        });


        HBox playerSelectors = new HBox(10);
        playerSelectors.getChildren().addAll(whitePlayers, blackPlayers);
        playerSelectors.setAlignment(Pos.CENTER);

        Button button = new Button("Done");
        button.setOnAction(e -> {
            b = new BoardController(filePath.getAbsolutePath() + "/Boards/DefaultBoard.txt", whitePlayer, blackPlayer);
            launcherWindow.close();
            b.startDisplay();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(titles, playerSelectors, button);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        Scene scene = new Scene(layout);
        launcherWindow.setScene(scene);
        launcherWindow.setTitle("Chess Launcher");
        launcherWindow.show();


//        b = new BoardController("DefaultBoard.txt", Mode.PLAYER_VS_PLAYER, true);
//        System.out.println("STARTING BOARD CONTROLLER");
//        b.startDisplay();
    }

    public static void main(String[] args)
    {
        launch();
    }
}
