package lotto.model;

import java.text.NumberFormat;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    MISS(0, 0, "낙첨"); // 0, 1, 2개 일치

    private final int matchCount;
    private final int prizeMoney;
    private final String description;

    Rank(int matchCount, int prizeMoney, String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public void printRank(){
        NumberFormat formatter = NumberFormat.getInstance();
        System.out.print(description + " (" + formatter.format(prizeMoney) + "원)");
    }

    public int getAllPrizeMoney(int count) {
        return count * prizeMoney;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5) {
            return bonusMatch ? SECOND : THIRD; // 보너스 여부로 2등과 3등 구분
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return MISS; // 0, 1, 2개는 모두 MISS
    }
}
