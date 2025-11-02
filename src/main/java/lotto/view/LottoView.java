package lotto.view;

public class LottoView {

    public void printPayMoney(){
        System.out.println("구입금액을 입력해주세요.");
    }

    public void printBuyLotto(int count){
        System.out.println("\n"+count+"개를 구매했습니다.");
    }

    public void printExtraMoney(int extraMoney){
        System.out.println("[INFO] 남는 금액 " + extraMoney +"는 반환됩니다.");
    }
}
