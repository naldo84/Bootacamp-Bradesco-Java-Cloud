package Desafios.Sudoku;

import Desafios.Sudoku.ui.custom.frame.MainFrame;
import Desafios.Sudoku.ui.custom.panel.MainPanel;
import Desafios.Sudoku.ui.custom.screen.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class MainUi {

    public static void main(String[] args) {
//        Dimension dimension = new Dimension(600, 600);
//        JPanel mainPanel = new MainPanel(dimension);
//        JFrame mainFrame = new MainFrame(dimension, mainPanel);
//        mainFrame.revalidate();
//        mainFrame.repaint();

        final var gameConfig = Stream.of(args)
                .collect(toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]
                ));
        var mainScreen = new MainScreen(gameConfig);
        mainScreen.buildMainScreen();

    }
}
