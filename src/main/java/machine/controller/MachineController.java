package machine.controller;

import lotto.model.LottoWallet;
import machine.model.Machine;
import machine.view.MachineView;

public class MachineController {
    private final LottoWallet lottoWallet;
    private int LOTTO_WALLET_SIZE;
    private static final int LOTTO_PER_MONEY = 1000;
    private Machine machine;
    private MachineView machineView;

    public MachineController(int LOTTO_WALLET_SIZE, LottoWallet lottoWallet) {
        this.lottoWallet = lottoWallet;
        this.LOTTO_WALLET_SIZE = LOTTO_WALLET_SIZE;
        this.machine = new Machine();
        this.machineView = new MachineView();
    }

    public void start(){
        machineView.printInputCollectNumbers();
        machine.addCollectNumbers();
        machineView.printInputBonusNumber();
        machine.addBonusNumber();
        machineView.printBeforeResult();
        machine.printResult(lottoWallet);
        machine.printBenefits(LOTTO_WALLET_SIZE);
    }
}
