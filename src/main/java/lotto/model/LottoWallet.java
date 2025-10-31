package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoWallet {
    private List<Lotto> lottoList;
    private final static int LOTTO_MAX_NUM = 6;

    public LottoWallet() {
        lottoList = new ArrayList<>();
    }

    public void addLotto(int count) {
        for(int i=0; i<count; i++) {
            lottoList.add(new Lotto(randLottoNumbers()));
        }
    }

    private List<Integer> randLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
