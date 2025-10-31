package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoWallet;
import lotto.view.LottoView;
import machine.controller.MachineController;

public class LottoController {
    private final LottoView lottoView;
    private final LottoWallet lottoWallet;
    private int LOTTO_WALLET_SIZE;
    private static final int LOTTO_PER_MONEY = 1000;
    private MachineController machineController;

    public LottoController() {
        lottoView = new LottoView();
        lottoWallet = new LottoWallet();
    }

    public void start(){
        lottoView.printPayMoney();
        buyLottoWallet();
    }

    private void buyLottoWallet(){
        try{
            int input = Integer.parseInt(Console.readLine());
            LOTTO_WALLET_SIZE = input/ LOTTO_PER_MONEY;
            lottoView.printBuyLotto(LOTTO_WALLET_SIZE);
            if(input % LOTTO_PER_MONEY != 0){
                lottoView.printExtraMoney(input % LOTTO_PER_MONEY);
            }
            lottoWallet.addLotto(LOTTO_WALLET_SIZE);

            machineController = new MachineController(LOTTO_WALLET_SIZE, lottoWallet);
            machineController.start();
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }


}
