import java.util.Arrays;

public class ChangeCoinDp {

        public int coinChange(int[] coins, int amount) {
            // Создаем массив dp для хранения минимального количества монет для каждой суммы
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1); // Заполняем большим числом
            dp[0] = 0; // Для суммы 0 нужно 0 монет

            // Для каждой суммы от 1 до amount
            for (int i = 1; i <= amount; i++) {
                // Проходим по всем номиналам монет
                for (int coin : coins) {
                    // Если монета может быть использована для текущей суммы
                    if (i - coin >= 0) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }

            // Если dp[amount] осталось большим числом, значит сумму невозможно составить
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

