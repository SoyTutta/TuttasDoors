package com.tuttasdoors.registry.compat;

import com.tuttasdoors.blocks.PetDoorBlock;
import com.tuttasdoors.blocks.TransitDoorBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class NMLContent {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, "nomansland");
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, "nomansland");

    public static final BlockSetType PINE = BlockSetType.register(new BlockSetType("nomansland:pine"));
    public static final BlockSetType WILLOW = BlockSetType.register(new BlockSetType("nomansland:willow"));
    public static final BlockSetType WALNUT = BlockSetType.register(new BlockSetType("nomansland:walnut"));
    public static final BlockSetType MAPLE = BlockSetType.register(new BlockSetType("nomansland:maple"));

    private static final BlockSetType[] WOODS = { PINE, WILLOW, WALNUT, MAPLE };
    public static final String[] WOOD_NAMES = { "pine", "willow", "walnut", "maple" };

    private static final Map<String, Function<BlockSetType, Block>> DOOR_TYPES = new HashMap<>();
    static {
        DOOR_TYPES.put("discrete_door", wood -> new DoorBlock(wood, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
        DOOR_TYPES.put("normal_door", wood -> new DoorBlock(wood, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
        DOOR_TYPES.put("indiscrete_door", wood -> new DoorBlock(wood, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
        DOOR_TYPES.put("transit_door", wood -> new TransitDoorBlock(wood, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
        DOOR_TYPES.put("pet_door", wood -> new PetDoorBlock(wood, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    }

    public static final Map<String, Supplier<Block>> BLOCKS_MAP = new HashMap<>();
    public static final Map<String, Supplier<Item>> ITEMS_MAP = new HashMap<>();

    static {
        for (int i = 0; i < WOODS.length; i++) {
            BlockSetType wood = WOODS[i];
            String woodName = WOOD_NAMES[i];

            for (Map.Entry<String, Function<BlockSetType, Block>> entry : DOOR_TYPES.entrySet()) {
                String doorTypeName = entry.getKey();

                if (woodName.equals("maple") && doorTypeName.equals("discrete_door")) {
                    continue;
                }

                if ((woodName.equals("pine") || woodName.equals("willow") || woodName.equals("walnut"))
                        && doorTypeName.equals("normal_door")) {
                    continue;
                }

                String blockName = woodName + "_" + doorTypeName;

                Supplier<Block> blockSupplier = BLOCKS.register(blockName, () -> entry.getValue().apply(wood));
                BLOCKS_MAP.put(blockName, blockSupplier);

                Supplier<Item> itemSupplier = ITEMS.register(blockName, () -> new BlockItem(blockSupplier.get(), new Item.Properties()));
                ITEMS_MAP.put(blockName, itemSupplier);
            }
        }
    }
}