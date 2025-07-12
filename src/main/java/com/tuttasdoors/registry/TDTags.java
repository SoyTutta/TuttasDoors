package com.tuttasdoors.registry;

import com.tuttasdoors.TuttasDoors;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TDTags
{
    public static final TagKey<Block> WOODEN_DISCRETE_DOORS = modBlockTag("wooden_doors/discrete");

    public static final TagKey<Block> WOODEN_CLASIC_DOORS = modBlockTag("wooden_doors/door");

    public static final TagKey<Block> WOODEN_INDISCRETE_DOORS = modBlockTag("wooden_doors/indiscrete");

    public static final TagKey<Block> WOODEN_TRANSIT_DOORS = modBlockTag("wooden_doors/transit");

    public static final TagKey<Block> WOODEN_PET_DOORS = modBlockTag("wooden_doors/pet");

    public static final TagKey<Item> WOODEN_DISCRETE_DOORS_ITEMS = modItemTag("wooden_doors/discrete");

    public static final TagKey<Item> WOODEN_CLASIC_DOORS_ITEMS = modItemTag("wooden_doors/door");

    public static final TagKey<Item> WOODEN_INDISCRETE_DOORS_ITEMS = modItemTag("wooden_doors/indiscrete");

    public static final TagKey<Item> WOODEN_TRANSIT_DOORS_ITEMS = modItemTag("wooden_doors/transit");

    public static final TagKey<Item> WOODEN_PET_DOORS_ITEMS = modItemTag("wooden_doors/pet");

    public static final TagKey<Block> POSSIBLE_SLIDING = modBlockTag("wooden_doors/possible_sliding");

    private static TagKey<Item> modItemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TuttasDoors.MODID, path));
    }

    private static TagKey<Block> modBlockTag(String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TuttasDoors.MODID, path));
    }
}