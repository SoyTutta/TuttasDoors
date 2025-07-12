package com.tuttasdoors.registry;

import com.farcr.nomansland.common.registry.blocks.NMLBlocks;
import com.tuttasdoors.TDTextUtils;
import com.tuttasdoors.TuttasDoors;
import com.tuttasdoors.registry.compat.Mods;
import com.tuttasdoors.registry.compat.NMLContent;
import net.minecraft.core.registries.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TDCreativeTab {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TuttasDoors.MODID);

    public static final DeferredHolder<CreativeModeTab,
            CreativeModeTab> TUTTAS_DOORS = TABS.register("main",
            () -> CreativeModeTab.builder()
                    .title(TDTextUtils.getTranslation("itemGroup.main"))
                    .icon(TDItems.OAK_DISCRETE_DOOR.get()::getDefaultInstance)
                    .displayItems((parameters, output) -> {

                        output.accept(TDItems.OAK_DISCRETE_DOOR.get());
                        output.accept(Items.OAK_DOOR);
                        output.accept(TDItems.OAK_INDISCRETE_DOOR.get());
                        output.accept(TDItems.OAK_TRANSIT_DOOR.get());
                        output.accept(TDItems.OAK_PET_DOOR.get());

                        output.accept(Items.SPRUCE_DOOR);
                        output.accept(TDItems.SPRUCE_DOOR.get());
                        output.accept(TDItems.SPRUCE_INDISCRETE_DOOR.get());
                        output.accept(TDItems.SPRUCE_TRANSIT_DOOR.get());
                        output.accept(TDItems.SPRUCE_PET_DOOR.get());

                        output.accept(Items.BIRCH_DOOR);
                        output.accept(TDItems.BIRCH_DOOR.get());
                        output.accept(TDItems.BIRCH_INDISCRETE_DOOR.get());
                        output.accept(TDItems.BIRCH_TRANSIT_DOOR.get());
                        output.accept(TDItems.BIRCH_PET_DOOR.get());

                        output.accept(TDItems.JUNGLE_DISCRETE_DOOR.get());
                        output.accept(Items.JUNGLE_DOOR);
                        output.accept(TDItems.JUNGLE_INDISCRETE_DOOR.get());
                        output.accept(TDItems.JUNGLE_TRANSIT_DOOR.get());
                        output.accept(TDItems.JUNGLE_PET_DOOR.get());

                        output.accept(TDItems.ACACIA_DISCRETE_DOOR.get());
                        output.accept(TDItems.ACACIA_DOOR.get());
                        output.accept(Items.ACACIA_DOOR);
                        output.accept(TDItems.ACACIA_TRANSIT_DOOR.get());
                        output.accept(TDItems.ACACIA_PET_DOOR.get());

                        output.accept(Items.DARK_OAK_DOOR);
                        output.accept(TDItems.DARK_OAK_DOOR.get());
                        output.accept(TDItems.DARK_OAK_INDISCRETE_DOOR.get());
                        output.accept(TDItems.DARK_OAK_TRANSIT_DOOR.get());
                        output.accept(TDItems.DARK_OAK_PET_DOOR.get());

                        output.accept(Items.MANGROVE_DOOR);
                        output.accept(TDItems.MANGROVE_DOOR.get());
                        output.accept(TDItems.MANGROVE_INDISCRETE_DOOR.get());
                        output.accept(TDItems.MANGROVE_TRANSIT_DOOR.get());
                        output.accept(TDItems.MANGROVE_PET_DOOR.get());

                        output.accept(TDItems.CHERRY_DISCRETE_DOOR.get());
                        output.accept(Items.CHERRY_DOOR);
                        output.accept(TDItems.CHERRY_INDISCRETE_DOOR.get());
                        output.accept(TDItems.CHERRY_TRANSIT_DOOR.get());
                        output.accept(TDItems.CHERRY_PET_DOOR.get());

                        output.accept(TDItems.BAMBOO_DISCRETE_DOOR.get());
                        output.accept(Items.BAMBOO_DOOR);
                        output.accept(TDItems.BAMBOO_INDISCRETE_DOOR.get());
                        output.accept(TDItems.BAMBOO_TRANSIT_DOOR.get());
                        output.accept(TDItems.BAMBOO_PET_DOOR.get());

                        output.accept(Items.CRIMSON_DOOR);
                        output.accept(TDItems.CRIMSON_DOOR.get());
                        output.accept(TDItems.CRIMSON_INDISCRETE_DOOR.get());
                        output.accept(TDItems.CRIMSON_TRANSIT_DOOR.get());
                        output.accept(TDItems.CRIMSON_PET_DOOR.get());

                        output.accept(Items.WARPED_DOOR);
                        output.accept(TDItems.WARPED_DOOR.get());
                        output.accept(TDItems.WARPED_INDISCRETE_DOOR.get());
                        output.accept(TDItems.WARPED_TRANSIT_DOOR.get());
                        output.accept(TDItems.WARPED_PET_DOOR.get());

                        if (Mods.NOMANSLAND.isLoaded()) {
                            String[] woods = { "maple", "pine", "walnut", "willow" };
                            String[] types = {
                                    "discrete_door",
                                    "door",
                                    "normal_door",
                                    "indiscrete_door",
                                    "transit_door",
                                    "pet_door"
                            };

                            for (String wood : woods) {
                                for (String type : types) {
                                    if ("door".equals(type)) {
                                        for (NMLBlocks.Woodset ws : NMLBlocks.WOODSETS) {
                                            Block db = ws.door().get();
                                            Item  di = db.asItem();

                                            ResourceLocation key = BuiltInRegistries.ITEM.getKey(di);
                                            if (key != null && key.getPath().startsWith(wood + "_")) {
                                                output.accept(di);
                                                break;
                                            }
                                        }
                                    } else {
                                        Supplier<Item> sup = NMLContent.ITEMS_MAP.get(wood + "_" + type);
                                        if (sup != null) {
                                            output.accept(sup.get());
                                        }
                                    }
                                }
                            }
                        }

                        output.accept(TDItems.IRON_BARS_SLIDING_DOOR.get());
                    }
            ).build()
    );
}