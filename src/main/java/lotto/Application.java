package lotto;

import lotto.controller.LottoController;
import machine.controller.MachineController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoController lottoController = new LottoController();
        MachineController machineController = new MachineController();
        lottoController.start();
    }
}
