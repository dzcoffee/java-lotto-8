package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoWallet {
    private List<Lotto> lottoList;

    public LottoWallet() {
        lottoList = new ArrayList<>();
    }

    public void addLotto(int count) {
        for(int i=0; i<count; i++) {
            lottoList.add(new Lotto(randLottoNumbers()));
        }
    }

    public Map<Rank, Integer> checkAllLottos(List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> rankResult = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankResult.put(rank, 0);
        }

        for (Lotto lotto : lottoList) {
            Rank rank = lotto.calculateRank(winningNumbers, bonusNumber);
            rankResult.put(rank, rankResult.get(rank) + 1);
        }

        return rankResult;
    }



    private List<Integer> randLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
