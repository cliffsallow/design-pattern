package strategy2;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import strategy2.annotation.RegisterStrategy;
import strategy2.strategy.AbstractStrategy;

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


    // 利用反射自动注册所有策略
    public static void autoRegisterAllStrategies(){
        // 找到所有 包含RegisterStrategy注解的 策略子类
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(AbstractStrategy.class.getPackage().getName()))
                .setScanners(new SubTypesScanner()));
        Set<Class<? extends AbstractStrategy>> strategyClassSet = reflections.getSubTypesOf(AbstractStrategy.class);

        for (Class<? extends AbstractStrategy> strategyClass : strategyClassSet) {
            if (strategyClass.isAnnotationPresent(RegisterStrategy.class)) {
                StrategyType strategyType = strategyClass.getAnnotation(RegisterStrategy.class).value();
                try {
                    strategyMap.put(strategyType, strategyClass.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
