package machine.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.model.LottoWallet;
import lotto.model.Rank;

public class Machine {
    private List<Integer> collectNumberList;
    private Integer bonusNumber;
    private Map<Rank, Integer> rankMap;
    private List<Rank> ranks;

    public Machine() {
        ranks = createRankList();
    }

    public void addCollectNumbers() {
        String input = Console.readLine();
        String[] numbers = input.split(",");
        if(numbers.length != 6){
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 6개여야 합니다.");
        }
        Set<Integer> distinctNumbers = new HashSet<>();

        collectNumberList = new ArrayList<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if(num < 1 || num > 45){
                throw new IllegalArgumentException("[ERROR] 로또 구매 번호는 1부터 45 사이의 숫자여야 합니다.");
            }

            if(distinctNumbers.contains(num)){
                throw new IllegalArgumentException("[ERROR] 추첨 숫자에 중복된 값이 존재합니다.");
            }
            collectNumberList.add(num);
            distinctNumbers.add(num);
        }
    }

    public void addBonusNumber() {
        bonusNumber = Integer.parseInt(Console.readLine());
    }

    public void printResult(LottoWallet wallet){
        resultStatics(wallet);

        for (Rank rank : ranks) {
            int count = rankMap.getOrDefault(rank, 0); // 해당 등수의 당첨 개수
            rank.printRank();
            System.out.print(" - ");
            System.out.print(count+"개\n");
        }

    }

    private void resultStatics(LottoWallet wallet) {
        // 계산 과정을 wallet에게 모두 위임하고, 결과(Map)만 받아서 저장합니다.
        this.rankMap = wallet.checkAllLottos(collectNumberList, bonusNumber);
    }

    private List<Rank> createRankList() {
        return List.of(
                Rank.FIFTH,
                Rank.FOURTH,
                Rank.THIRD,
                Rank.SECOND,
                Rank.FIRST
        );
    }

    public void printBenefits(int LOTTO_WALLET_SIZE){
        int sum = 0;
        for(Rank rank : ranks){
            sum += rank.getAllPrizeMoney(rankMap.get(rank));
        }
        double profitRate = ((double) sum / (LOTTO_WALLET_SIZE * 1000)) * 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
