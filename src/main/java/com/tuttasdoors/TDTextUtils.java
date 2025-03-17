package com.tuttasdoors;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class TDTextUtils {
    public TDTextUtils() {
    }
    public static MutableComponent getTranslation(String key, Object... args) {
        return Component.translatable("tuttasdoors." + key, args);
    }
}