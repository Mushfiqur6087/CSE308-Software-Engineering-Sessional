package patterns.builderPattern.OfflineCreationalPatternProperWay.Builder;

import patterns.builderPattern.OfflineCreationalPatternLazyWay.Shake.Shake;

public interface ShakeBuilder {
        public void setShakeType(String type);

        public boolean makeLactoseFree();

        public boolean addCandyOnTop();

        public boolean addCookiesOnTop();
        public void buildShake();
        public void setPrice(double price);
    }
