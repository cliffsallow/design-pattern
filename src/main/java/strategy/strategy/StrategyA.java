package strategy.strategy;

import strategy.StrategyFactory;
import strategy.StrategyType;

/**
 * @author tao.qiu
 * @description: TODO
 * @date 2024/1/2 18:09
 */
public class StrategyA implements AbstractStrategy {
    @Override
    public void process() {
        System.out.println("策略A");
    }

    @Override
    public void register() {
        StrategyFactory.registerStrategy(StrategyType.STRATEGY_A,this);
    }
}
