package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        distinctValidate(numbers);
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

    private void distinctValidate(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 숫자가 존재합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
