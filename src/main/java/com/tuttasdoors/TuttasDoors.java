package com.tuttasdoors;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.tuttasdoors.registry.TDBlocks;
import com.tuttasdoors.registry.TDCreativeTab;
import com.tuttasdoors.registry.TDItems;

@Mod(TuttasDoors.MODID)
public class TuttasDoors {
    public static final String MODID = "tuttasdoors";
    public static final Logger LOGGER = LogManager.getLogger();

    public TuttasDoors(IEventBus modEventBus) {
        TDItems.ITEMS.register(modEventBus);
        TDBlocks.BLOCKS.register(modEventBus);
        TDCreativeTab.TABS.register(modEventBus);
    }
}