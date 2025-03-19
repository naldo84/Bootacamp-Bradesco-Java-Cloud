package Desafios.Sudoku;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.List;

import Desafios.Sudoku.Util.BoardTemplate;
import Desafios.Sudoku.model.Board;
import Desafios.Sudoku.model.Space;

public class Inicio {

    private final static Scanner scanner = new Scanner(System.in);
    private static Board board;
    private final static int BOARD_lIMIT = 9;

    public static void main(String[] args) {
        final var positions = Stream.of(args)
                .collect(toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]

                ));

        int option = -1;

        while (true) {
            System.out.println("Escolha uma das opções: ");
            System.out.println("1 - Novo Jogo");
            System.out.println("2 - Inserir número");
            System.out.println("3 - Remover número");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - Limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");

            System.out.print("Digite a opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    startGame(positions);
                    break;
                case 2:
                    inputNumber();                
                    break;
                case 3:
                    removeNumber();                  
                    break;
                case 4:
                    showCurrentGame();                  
                    break;
                case 5:
                    showGameStatus();                 
                    break;
                case 6:
                    cleanGame();                
                    break;
                case 7:
                    finishGame();                  
                    break;
                case 8:
                    System.exit(0);               
                    break;
            
                default:
                System.out.println("Opção inválida, seleciona uma das opções do menu");
                    break;
            }
        }
    }

    private static void startGame(Map<String, String> positions) {
        if (nonNull(board)) {
            System.out.println("O jogo já foi iniciado!");
            return;
        }

        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_lIMIT; i++){
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_lIMIT; j++) {
                var positionConfig = positions.get("%s,%s".formatted(i, j));
                var expected = Integer.parseInt(positionConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                var currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }
        }

        board = new Board(spaces);
        System.out.println("O jogo está pronto para começar!");
    }

    private static void inputNumber() {
        if (isNull(board)){
            System.out.println("O jogo não foi iniciado!");
            return;
        }

        System.out.println("Informe a coluna: ");
        var col = runUntilValidNumber(0, 8);

        System.out.println("Informe a linha: ");
        var row = runUntilValidNumber(0, 8);

        System.out.printf("Informe o número da posição [%s, %s]\n", col, row);
        var value = runUntilValidNumber(1, 9);

        if (!board.changeValue(col, row, value)){
            System.out.printf("A posição [%s, %s] tem um valor fixo\n", col, row);
        }
    }

    private static void removeNumber(){
        if (isNull(board)){
            System.out.println("O jogo não foi iniciado!");
            return;
        }

        System.out.println("Informe a coluna: ");
        var col = runUntilValidNumber(0, 8);

        System.out.println("Informe a linha: ");
        var row = runUntilValidNumber(0, 8);

        System.out.printf("Informe o número da posição [%s, %s]\n", col, row);

        if (!board.clearValue(col, row)){
            System.out.printf("A posição [%s, %s] tem um valor fixo\n", col, row);
        }
    }

    private static void showCurrentGame(){
        if (isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        var args = new Object[81];
        var argPos = 0;

        for (int i = 0; i < BOARD_lIMIT; i++){
            for (var col: board.getSpaces()){
                args[argPos ++] = " " + ((isNull(col.get(i).getActual())) ? " " : col.get(i).getActual());
            }
        }

        System.out.println("Seu jogo se encontra da seguinte forma: ");
        System.out.printf((BoardTemplate.BOARD_TEMPLATE) + "\n", args);
    }

    private static void showGameStatus(){
        if (isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

    System.out.printf("O jogo atualmente se encontra no status %s\n", board.getStatus().getLabel());

    if (board.hasErrors()){
        System.out.println("O jogo contém erro!");

    } else {
        System.out.println("O jogo não contém erro!");  
    }

    }

    private static void cleanGame(){
        if (isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        System.out.println("Tem certeza que deseja limpar o seu game? ");
        var confirm = scanner.next();
        while (!confirm.equalsIgnoreCase("sim") || !confirm.equalsIgnoreCase("não")) {
            System.out.println("Digite sim ou não: ");
            confirm = scanner.next();
        }

        if (confirm.equalsIgnoreCase("sim")) {
            board.reset();
        }
    }

    private static void finishGame(){
        if (isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        if (board.gameIsFinished()){
            System.out.println("Parabéns você concluiu o jogo!");
            showCurrentGame();
            board = null;
        } else if (board.hasErrors()){
            System.out.println("Seu jogo contém erro, verifique seu board e ajuste-o.");
        } else {
            System.out.println("Você ainda precisa preenhcer algum espaço!");
        }
    }

    private static int runUntilValidNumber(final int min, final int max){
        var current = scanner.nextInt();
        while (current < min || current > max) {
            System.out.printf("Informe um número entre %s e %s", min, max);
            current = scanner.nextInt();
        }

        return current;
    }
}
