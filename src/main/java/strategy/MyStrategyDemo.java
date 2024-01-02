package strategy;

import strategy.strategy.AbstractStrategy;

/**
 * @author tao.qiu
 * @description: 使用策略模式
 * @date 2024/1/2 18:15
 */
public class MyStrategyDemo {

    public static void main(String[] args) {
        AbstractStrategy strategy = StrategyFactory.getStrategy(StrategyType.STRATEGY_A);
        strategy.process();

        AbstractStrategy strategyC = StrategyFactory.getStrategy(StrategyType.STRATEGY_C);
        strategyC.process();
    }
}
