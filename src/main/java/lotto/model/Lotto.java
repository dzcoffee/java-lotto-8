package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Rank calculateRank(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) this.numbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean hasBonus = this.numbers.contains(bonusNumber);

        // 3. Rank Enum의 정적 메서드를 호출하여 등수 결정
        return Rank.valueOf(matchCount, hasBonus);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        System.out.println(numbers);
    }

    // TODO: 추가 기능 구현
}
