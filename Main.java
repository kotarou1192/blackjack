package blackj.blackjack;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main playGame = new Main();
        System.out.println("ゲームをはじめますか：[y/n]");
        while (!playGame.start()) ;
    }

    public boolean start() {
        Scanner text = new Scanner(System.in); // 入力
        String gameStart = text.nextLine(); // 入力を変数に代入

        if (Objects.equals(gameStart, "y")) { // ゲーム開始
            Play game = new Play();
            game.playGame();
            return true;

        } else if (Objects.equals(gameStart, "n")) { // ゲーム終了
            System.out.println("end");
            return true;

        } else { // 0か1以外が入力されたので終了
            System.out.println("yかnで入力してください");
            return false;
        }
    }
}
