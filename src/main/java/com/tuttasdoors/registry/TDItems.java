package com.tuttasdoors.registry;

import com.tuttasdoors.TuttasDoors;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TDItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, TuttasDoors.MODID);

    public static Item.Properties basicItem() {
        return (new Item.Properties());
    }

    public static final Supplier<Item> OAK_DISCRETE_DOOR = ITEMS.register("oak_discrete_door", ()  ->
            new BlockItem(TDBlocks.OAK_DISCRETE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> JUNGLE_DISCRETE_DOOR = ITEMS.register("jungle_discrete_door", ()  ->
            new BlockItem(TDBlocks.JUNGLE_DISCRETE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> ACACIA_DISCRETE_DOOR = ITEMS.register("acacia_discrete_door", ()  ->
            new BlockItem(TDBlocks.ACACIA_DISCRETE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> CHERRY_DISCRETE_DOOR = ITEMS.register("cherry_discrete_door", ()  ->
            new BlockItem(TDBlocks.CHERRY_DISCRETE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> BAMBOO_DISCRETE_DOOR = ITEMS.register("bamboo_discrete_door", ()  ->
            new BlockItem(TDBlocks.BAMBOO_DISCRETE_DOOR.get(), basicItem())
    );

    public static final Supplier<Item> SPRUCE_DOOR = ITEMS.register("spruce_door", ()  ->
            new BlockItem(TDBlocks.SPRUCE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> BIRCH_DOOR = ITEMS.register("birch_door", ()  ->
            new BlockItem(TDBlocks.BIRCH_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> ACACIA_DOOR = ITEMS.register("acacia_door", ()  ->
            new BlockItem(TDBlocks.ACACIA_DOOR.get(), basicItem())
    );

    public static final Supplier<Item> DARK_OAK_DOOR = ITEMS.register("dark_oak_door", ()  ->
            new BlockItem(TDBlocks.DARK_OAK_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> MANGROVE_DOOR = ITEMS.register("mangrove_door", ()  ->
            new BlockItem(TDBlocks.MANGROVE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> CRIMSON_DOOR = ITEMS.register("crimson_door", ()  ->
            new BlockItem(TDBlocks.CRIMSON_DOOR.get(), basicItem())
    );

    public static final Supplier<Item> WARPED_DOOR = ITEMS.register("warped_door", ()  ->
            new BlockItem(TDBlocks.WARPED_DOOR.get(), basicItem())
    );



    public static final Supplier<Item> OAK_INDISCRETE_DOOR = ITEMS.register("oak_indiscrete_door", ()  ->
            new BlockItem(TDBlocks.OAK_INDISCRETE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> SPRUCE_INDISCRETE_DOOR = ITEMS.register("spruce_indiscrete_door", ()  ->
            new BlockItem(TDBlocks.SPRUCE_INDISCRETE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> BIRCH_INDISCRETE_DOOR = ITEMS.register("birch_indiscrete_door", ()  ->
            new BlockItem(TDBlocks.BIRCH_INDISCRETE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> JUNGLE_INDISCRETE_DOOR = ITEMS.register("jungle_indiscrete_door", ()  ->
            new BlockItem(TDBlocks.JUNGLE_INDISCRETE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> DARK_OAK_INDISCRETE_DOOR = ITEMS.register("dark_oak_indiscrete_door", ()  ->
            new BlockItem(TDBlocks.DARK_OAK_INDISCRETE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> MANGROVE_INDISCRETE_DOOR = ITEMS.register("mangrove_indiscrete_door", ()  ->
            new BlockItem(TDBlocks.MANGROVE_INDISCRETE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> CHERRY_INDISCRETE_DOOR = ITEMS.register("cherry_indiscrete_door", ()  ->
            new BlockItem(TDBlocks.CHERRY_INDISCRETE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> BAMBOO_INDISCRETE_DOOR = ITEMS.register("bamboo_indiscrete_door", ()  ->
            new BlockItem(TDBlocks.BAMBOO_INDISCRETE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> CRIMSON_INDISCRETE_DOOR = ITEMS.register("crimson_indiscrete_door", ()  ->
            new BlockItem(TDBlocks.CRIMSON_INDISCRETE_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> WARPED_INDISCRETE_DOOR = ITEMS.register("warped_indiscrete_door", ()  ->
            new BlockItem(TDBlocks.WARPED_INDISCRETE_DOOR.get(), basicItem())
    );


    public static final Supplier<Item> OAK_TRANSIT_DOOR = ITEMS.register("oak_transit_door", ()  ->
            new BlockItem(TDBlocks.OAK_TRANSIT_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> SPRUCE_TRANSIT_DOOR = ITEMS.register("spruce_transit_door", ()  ->
            new BlockItem(TDBlocks.SPRUCE_TRANSIT_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> BIRCH_TRANSIT_DOOR = ITEMS.register("birch_transit_door", ()  ->
            new BlockItem(TDBlocks.BIRCH_TRANSIT_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> JUNGLE_TRANSIT_DOOR = ITEMS.register("jungle_transit_door", ()  ->
            new BlockItem(TDBlocks.JUNGLE_TRANSIT_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> ACACIA_TRANSIT_DOOR = ITEMS.register("acacia_transit_door", ()  ->
            new BlockItem(TDBlocks.ACACIA_TRANSIT_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> DARK_OAK_TRANSIT_DOOR = ITEMS.register("dark_oak_transit_door", ()  ->
            new BlockItem(TDBlocks.DARK_OAK_TRANSIT_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> MANGROVE_TRANSIT_DOOR = ITEMS.register("mangrove_transit_door", ()  ->
            new BlockItem(TDBlocks.MANGROVE_TRANSIT_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> CHERRY_TRANSIT_DOOR = ITEMS.register("cherry_transit_door", ()  ->
            new BlockItem(TDBlocks.CHERRY_TRANSIT_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> BAMBOO_TRANSIT_DOOR = ITEMS.register("bamboo_transit_door", ()  ->
            new BlockItem(TDBlocks.BAMBOO_TRANSIT_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> CRIMSON_TRANSIT_DOOR = ITEMS.register("crimson_transit_door", ()  ->
            new BlockItem(TDBlocks.CRIMSON_TRANSIT_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> WARPED_TRANSIT_DOOR = ITEMS.register("warped_transit_door", ()  ->
            new BlockItem(TDBlocks.WARPED_TRANSIT_DOOR.get(), basicItem())
    );


    public static final Supplier<Item> OAK_PET_DOOR = ITEMS.register("oak_pet_door", ()  ->
            new BlockItem(TDBlocks.OAK_PET_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> SPRUCE_PET_DOOR = ITEMS.register("spruce_pet_door", ()  ->
            new BlockItem(TDBlocks.SPRUCE_PET_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> BIRCH_PET_DOOR = ITEMS.register("birch_pet_door", ()  ->
            new BlockItem(TDBlocks.BIRCH_PET_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> JUNGLE_PET_DOOR = ITEMS.register("jungle_pet_door", ()  ->
            new BlockItem(TDBlocks.JUNGLE_PET_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> ACACIA_PET_DOOR = ITEMS.register("acacia_pet_door", ()  ->
            new BlockItem(TDBlocks.ACACIA_PET_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> DARK_OAK_PET_DOOR = ITEMS.register("dark_oak_pet_door", ()  ->
            new BlockItem(TDBlocks.DARK_OAK_PET_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> MANGROVE_PET_DOOR = ITEMS.register("mangrove_pet_door", ()  ->
            new BlockItem(TDBlocks.MANGROVE_PET_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> CHERRY_PET_DOOR = ITEMS.register("cherry_pet_door", ()  ->
            new BlockItem(TDBlocks.CHERRY_PET_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> BAMBOO_PET_DOOR = ITEMS.register("bamboo_pet_door", ()  ->
            new BlockItem(TDBlocks.BAMBOO_PET_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> CRIMSON_PET_DOOR = ITEMS.register("crimson_pet_door", ()  ->
            new BlockItem(TDBlocks.CRIMSON_PET_DOOR.get(), basicItem())
    );
    public static final Supplier<Item> WARPED_PET_DOOR = ITEMS.register("warped_pet_door", ()  ->
            new BlockItem(TDBlocks.WARPED_PET_DOOR.get(), basicItem())
    );

    public static final Supplier<Item> IRON_BARS_SLIDING_DOOR = ITEMS.register("iron_bars_sliding_door", ()  ->
            new BlockItem(TDBlocks.IRON_BARS_SLIDING_DOOR.get(), basicItem())
    );
}