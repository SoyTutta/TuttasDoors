package com.tuttasdoors.registry;

import com.tuttasdoors.TuttasDoors;
import com.tuttasdoors.blocks.PetDoorBlock;
import com.tuttasdoors.blocks.SlidingDoorBlock;
import com.tuttasdoors.blocks.TransitDoorBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy;

public class TDBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, TuttasDoors.MODID);

    public static final Supplier<Block> OAK_DISCRETE_DOOR = BLOCKS.register("oak_discrete_door",
            () -> new DoorBlock(BlockSetType.OAK, ofFullCopy(Blocks.OAK_DOOR)));
    public static final Supplier<Block> JUNGLE_DISCRETE_DOOR = BLOCKS.register("jungle_discrete_door",
            () -> new DoorBlock(BlockSetType.JUNGLE, ofFullCopy(Blocks.JUNGLE_DOOR)));
    public static final Supplier<Block> ACACIA_DISCRETE_DOOR = BLOCKS.register("acacia_discrete_door",
            () -> new DoorBlock(BlockSetType.ACACIA, ofFullCopy(Blocks.ACACIA_DOOR)));
    public static final Supplier<Block> CHERRY_DISCRETE_DOOR = BLOCKS.register("cherry_discrete_door",
            () -> new DoorBlock(BlockSetType.CHERRY, ofFullCopy(Blocks.CHERRY_DOOR)));
    public static final Supplier<Block> BAMBOO_DISCRETE_DOOR = BLOCKS.register("bamboo_discrete_door",
            () -> new DoorBlock(BlockSetType.BAMBOO, ofFullCopy(Blocks.BAMBOO_DOOR)));


    public static final Supplier<Block> SPRUCE_DOOR = BLOCKS.register("spruce_door",
            () -> new DoorBlock(BlockSetType.SPRUCE, ofFullCopy(Blocks.SPRUCE_DOOR)));
    public static final Supplier<Block> BIRCH_DOOR = BLOCKS.register("birch_door",
            () -> new DoorBlock(BlockSetType.BIRCH, ofFullCopy(Blocks.BIRCH_DOOR)));
    public static final Supplier<Block> ACACIA_DOOR = BLOCKS.register("acacia_door",
            () -> new DoorBlock(BlockSetType.ACACIA, ofFullCopy(Blocks.ACACIA_DOOR)));
    public static final Supplier<Block> DARK_OAK_DOOR = BLOCKS.register("dark_oak_door",
            () -> new DoorBlock(BlockSetType.DARK_OAK, ofFullCopy(Blocks.DARK_OAK_DOOR)));
    public static final Supplier<Block> MANGROVE_DOOR = BLOCKS.register("mangrove_door",
            () -> new DoorBlock(BlockSetType.MANGROVE, ofFullCopy(Blocks.MANGROVE_DOOR)));
    public static final Supplier<Block> CRIMSON_DOOR = BLOCKS.register("crimson_door",
            () -> new DoorBlock(BlockSetType.CRIMSON, ofFullCopy(Blocks.CRIMSON_DOOR)));
    public static final Supplier<Block> WARPED_DOOR = BLOCKS.register("warped_door",
            () -> new DoorBlock(BlockSetType.WARPED, ofFullCopy(Blocks.WARPED_DOOR)));

    public static final Supplier<Block> OAK_INDISCRETE_DOOR = BLOCKS.register("oak_indiscrete_door",
            () -> new DoorBlock(BlockSetType.OAK, ofFullCopy(Blocks.OAK_DOOR)));
    public static final Supplier<Block> SPRUCE_INDISCRETE_DOOR = BLOCKS.register("spruce_indiscrete_door",
            () -> new DoorBlock(BlockSetType.SPRUCE, ofFullCopy(Blocks.SPRUCE_DOOR)));
    public static final Supplier<Block> BIRCH_INDISCRETE_DOOR = BLOCKS.register("birch_indiscrete_door",
            () -> new DoorBlock(BlockSetType.BIRCH, ofFullCopy(Blocks.BIRCH_DOOR)));
    public static final Supplier<Block> JUNGLE_INDISCRETE_DOOR = BLOCKS.register("jungle_indiscrete_door",
            () -> new DoorBlock(BlockSetType.JUNGLE, ofFullCopy(Blocks.JUNGLE_DOOR)));
    public static final Supplier<Block> DARK_OAK_INDISCRETE_DOOR = BLOCKS.register("dark_oak_indiscrete_door",
            () -> new DoorBlock(BlockSetType.DARK_OAK, ofFullCopy(Blocks.DARK_OAK_DOOR)));
    public static final Supplier<Block> MANGROVE_INDISCRETE_DOOR = BLOCKS.register("mangrove_indiscrete_door",
            () -> new DoorBlock(BlockSetType.MANGROVE, ofFullCopy(Blocks.MANGROVE_DOOR)));
    public static final Supplier<Block> CHERRY_INDISCRETE_DOOR = BLOCKS.register("cherry_indiscrete_door",
            () -> new DoorBlock(BlockSetType.CHERRY, ofFullCopy(Blocks.CHERRY_DOOR)));
    public static final Supplier<Block> BAMBOO_INDISCRETE_DOOR = BLOCKS.register("bamboo_indiscrete_door",
            () -> new DoorBlock(BlockSetType.BAMBOO, ofFullCopy(Blocks.BAMBOO_DOOR)));
    public static final Supplier<Block> CRIMSON_INDISCRETE_DOOR = BLOCKS.register("crimson_indiscrete_door",
            () -> new DoorBlock(BlockSetType.CRIMSON, ofFullCopy(Blocks.CRIMSON_DOOR)));
    public static final Supplier<Block> WARPED_INDISCRETE_DOOR = BLOCKS.register("warped_indiscrete_door",
            () -> new DoorBlock(BlockSetType.WARPED, ofFullCopy(Blocks.WARPED_DOOR)));

    public static final Supplier<Block> OAK_TRANSIT_DOOR = BLOCKS.register("oak_transit_door",
            () -> new TransitDoorBlock(BlockSetType.OAK, ofFullCopy(Blocks.OAK_DOOR)));
    public static final Supplier<Block> SPRUCE_TRANSIT_DOOR = BLOCKS.register("spruce_transit_door",
            () -> new TransitDoorBlock(BlockSetType.SPRUCE, ofFullCopy(Blocks.SPRUCE_DOOR)));
    public static final Supplier<Block> BIRCH_TRANSIT_DOOR = BLOCKS.register("birch_transit_door",
            () -> new TransitDoorBlock(BlockSetType.BIRCH, ofFullCopy(Blocks.BIRCH_DOOR)));
    public static final Supplier<Block> JUNGLE_TRANSIT_DOOR = BLOCKS.register("jungle_transit_door",
            () -> new TransitDoorBlock(BlockSetType.JUNGLE, ofFullCopy(Blocks.JUNGLE_DOOR)));
    public static final Supplier<Block> ACACIA_TRANSIT_DOOR = BLOCKS.register("acacia_transit_door",
            () -> new TransitDoorBlock(BlockSetType.ACACIA, ofFullCopy(Blocks.ACACIA_DOOR)));
    public static final Supplier<Block> DARK_OAK_TRANSIT_DOOR = BLOCKS.register("dark_oak_transit_door",
            () -> new TransitDoorBlock(BlockSetType.DARK_OAK, ofFullCopy(Blocks.DARK_OAK_DOOR)));
    public static final Supplier<Block> MANGROVE_TRANSIT_DOOR = BLOCKS.register("mangrove_transit_door",
            () -> new TransitDoorBlock(BlockSetType.MANGROVE, ofFullCopy(Blocks.MANGROVE_DOOR)));
    public static final Supplier<Block> CHERRY_TRANSIT_DOOR = BLOCKS.register("cherry_transit_door",
            () -> new TransitDoorBlock(BlockSetType.CHERRY, ofFullCopy(Blocks.CHERRY_DOOR)));
    public static final Supplier<Block> BAMBOO_TRANSIT_DOOR = BLOCKS.register("bamboo_transit_door",
            () -> new TransitDoorBlock(BlockSetType.BAMBOO, ofFullCopy(Blocks.BAMBOO_DOOR)));
    public static final Supplier<Block> CRIMSON_TRANSIT_DOOR = BLOCKS.register("crimson_transit_door",
            () -> new TransitDoorBlock(BlockSetType.CRIMSON, ofFullCopy(Blocks.CRIMSON_DOOR)));
    public static final Supplier<Block> WARPED_TRANSIT_DOOR = BLOCKS.register("warped_transit_door",
            () -> new TransitDoorBlock(BlockSetType.WARPED, ofFullCopy(Blocks.WARPED_DOOR)));

    public static final Supplier<Block> OAK_PET_DOOR = BLOCKS.register("oak_pet_door",
            () -> new PetDoorBlock(BlockSetType.OAK, ofFullCopy(Blocks.OAK_DOOR)));
    public static final Supplier<Block> SPRUCE_PET_DOOR = BLOCKS.register("spruce_pet_door",
            () -> new PetDoorBlock(BlockSetType.SPRUCE, ofFullCopy(Blocks.SPRUCE_DOOR)));
    public static final Supplier<Block> BIRCH_PET_DOOR = BLOCKS.register("birch_pet_door",
            () -> new PetDoorBlock(BlockSetType.BIRCH, ofFullCopy(Blocks.BIRCH_DOOR)));
    public static final Supplier<Block> JUNGLE_PET_DOOR = BLOCKS.register("jungle_pet_door",
            () -> new PetDoorBlock(BlockSetType.JUNGLE, ofFullCopy(Blocks.JUNGLE_DOOR)));
    public static final Supplier<Block> ACACIA_PET_DOOR = BLOCKS.register("acacia_pet_door",
            () -> new PetDoorBlock(BlockSetType.ACACIA, ofFullCopy(Blocks.ACACIA_DOOR)));
    public static final Supplier<Block> DARK_OAK_PET_DOOR = BLOCKS.register("dark_oak_pet_door",
            () -> new PetDoorBlock(BlockSetType.DARK_OAK, ofFullCopy(Blocks.DARK_OAK_DOOR)));
    public static final Supplier<Block> MANGROVE_PET_DOOR = BLOCKS.register("mangrove_pet_door",
            () -> new PetDoorBlock(BlockSetType.MANGROVE, ofFullCopy(Blocks.MANGROVE_DOOR)));
    public static final Supplier<Block> CHERRY_PET_DOOR = BLOCKS.register("cherry_pet_door",
            () -> new PetDoorBlock(BlockSetType.CHERRY, ofFullCopy(Blocks.CHERRY_DOOR)));
    public static final Supplier<Block> BAMBOO_PET_DOOR = BLOCKS.register("bamboo_pet_door",
            () -> new PetDoorBlock(BlockSetType.BAMBOO, ofFullCopy(Blocks.BAMBOO_DOOR)));
    public static final Supplier<Block> CRIMSON_PET_DOOR = BLOCKS.register("crimson_pet_door",
            () -> new PetDoorBlock(BlockSetType.CRIMSON, ofFullCopy(Blocks.CRIMSON_DOOR)));
    public static final Supplier<Block> WARPED_PET_DOOR = BLOCKS.register("warped_pet_door",
            () -> new PetDoorBlock(BlockSetType.WARPED, ofFullCopy(Blocks.WARPED_DOOR)));

    public static final Supplier<Block> IRON_BARS_SLIDING_DOOR = BLOCKS.register("iron_bars_sliding_door",
            () -> new SlidingDoorBlock(BlockSetType.IRON, ofFullCopy(Blocks.IRON_BARS)));
}

