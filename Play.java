package blackj.blackjack;

import java.util.*;

public class Play {
    private int ScoreOfPlayer;
    private CardDeck deck = new CardDeck();
    private int ScoreOfDealer;
    List<String> DealerHistory = new ArrayList<String>();

    public void playGame(){
        drawPlayer();
        drawPlayer();
        drawDealer();
        drawDealerWithoutShowing();

        showYourScore();
        if(ScoreOfPlayer > 21 || ScoreOfDealer > 21){
         System.out.println("バースト");
         return;
        } else {
            while(isContinue());
        }
        if(ScoreOfPlayer > 21)return;

        System.out.println("ディーラーの手札の開示");
        System.out.println("相手の引いたカード：" + DealerHistory.get(0));
        while(ScoreOfDealer < 17){
            drawDealer();
        }
        System.out.println("あなたの得点は" + ScoreOfPlayer);
        System.out.println("ディーラーの得点は" + ScoreOfDealer);

        if(ScoreOfDealer > 21 ){
            System.out.println("バースト！ディーラーの負けです");
        }else if(ScoreOfPlayer > ScoreOfDealer){
            System.out.println("あなたの勝ちです！");
        }else{
            System.out.println("あなたの負けです");
        }
    }


    private boolean isContinue(){
        System.out.println("カードを引きますか？[y/n]");
        Scanner text = new Scanner(System.in); // 入力
        String gameStart = text.nextLine(); // 入力を変数に代入

        if (Objects.equals(gameStart, "y")) { // 引くか引かないか
            drawPlayer();
            if(showYourScore() > 21){
                System.out.println("バースト！あなたの負けです");
                return false;
            }
            return true;

        } else if (Objects.equals(gameStart, "n")) { // ゲーム終了
            System.out.println("結果発表");
            return false;

        } else { // 0か1以外が入力されたので終了
            System.out.println("yかnで入力してください");
            return isContinue();
        }

    }

    private void drawPlayer(){
        int Score = deck.drawCard();
        if(Score < 11) {
            ScoreOfPlayer += Score;
        }else{
            ScoreOfPlayer += 10;
        }
        System.out.print("あなたの引いたカード：");
        System.out.println(deck.printCard());
    }

    private void drawDealer(){
        int Score = deck.drawCard();
        if(Score < 11) {
            ScoreOfDealer += Score;
        }else{
            ScoreOfDealer += 10;
        }
        System.out.print("相手の引いたカード：");
        System.out.println(deck.printCard());
    }

    private void drawDealerWithoutShowing(){
        int Score = deck.drawCard();
        if(Score < 11) {
            ScoreOfDealer += Score;
        }else{
            ScoreOfDealer += 10;
        }
        System.out.println("相手の引いたカード：秘密");
        DealerHistory.add(deck.printCard());
    }

    private int showYourScore(){
        System.out.println("現在のあなたの得点:" + ScoreOfPlayer);
        return ScoreOfPlayer;
    }
}
