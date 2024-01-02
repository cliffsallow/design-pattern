package strategy2.strategy;

import strategy2.StrategyType;
import strategy2.annotation.RegisterStrategy;

/**
 * @author tao.qiu
 * @description: TODO
 * @date 2024/1/2 18:09
 */
@RegisterStrategy(StrategyType.STRATEGY_A)
public class StrategyA implements AbstractStrategy {
    @Override
    public void process() {
        System.out.println("策略A");
    }

}
