package strategy2.annotation;

import strategy2.StrategyType;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface RegisterStrategy {
    StrategyType value(); // 策略类型
}
