package strategy;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import strategy.strategy.AbstractStrategy;

import java.util.HashMap;
import java.util.Set;

/**
 * @author tao.qiu
 * @description: 自动注册 策略
 * @date 2024/1/2 18:14
 */
public class StrategyFactory {
    static HashMap<StrategyType, AbstractStrategy> strategyMap = new HashMap<>();

    static {
        autoRegisterAllStrategies();
    }

    public static AbstractStrategy getStrategy(StrategyType strategyType){
        if (strategyMap.containsKey(strategyType)){
            return strategyMap.get(strategyType);
        } else {
            throw new RuntimeException("未找到策略");
        }
    }

    public static void registerStrategy(StrategyType strategyType, AbstractStrategy strategy){
        strategyMap.put(strategyType, strategy);
    }

    // 利用反射自动注册所有策略
    public static void autoRegisterAllStrategies(){
        // 找到所有策略子类
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(AbstractStrategy.class.getPackage().getName()))
                .setScanners(new SubTypesScanner()));
        Set<Class<? extends AbstractStrategy>> strategyClassSet = reflections.getSubTypesOf(AbstractStrategy.class);
        for (Class<? extends AbstractStrategy> strategyClass : strategyClassSet) {
            try {
                AbstractStrategy strategy = strategyClass.newInstance();
                // 自注册
                strategy.register();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }


}
