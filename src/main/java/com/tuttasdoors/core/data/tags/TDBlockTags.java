package com.tuttasdoors.core.data.tags;

import com.tuttasdoors.TuttasDoors;
import com.tuttasdoors.registry.TDBlocks;
import com.tuttasdoors.registry.TDTags;
import com.tuttasdoors.registry.compat.NMLContent;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class TDBlockTags extends BlockTagsProvider
{
    public TDBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TuttasDoors.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.registerModTags();
        this.registerMinecraftTags();
        this.registerBlockMineables();

    }

    protected void registerModTags() {
        tag(TDTags.POSSIBLE_SLIDING).add(Blocks.IRON_BARS);

        tag(TDTags.WOODEN_DISCRETE_DOORS).add(TDBlocks.OAK_DISCRETE_DOOR.get(),  Blocks.SPRUCE_DOOR, Blocks.BIRCH_DOOR,TDBlocks.JUNGLE_DISCRETE_DOOR.get(), TDBlocks.ACACIA_DISCRETE_DOOR.get(), Blocks.DARK_OAK_DOOR, Blocks.MANGROVE_DOOR, TDBlocks.CHERRY_DISCRETE_DOOR.get(), TDBlocks.BAMBOO_DISCRETE_DOOR.get(), Blocks.CRIMSON_DOOR, Blocks.WARPED_DOOR);
        tag(TDTags.WOODEN_CLASIC_DOORS).add(Blocks.OAK_DOOR,  TDBlocks.SPRUCE_DOOR.get(), TDBlocks.BIRCH_DOOR.get(),Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, TDBlocks.DARK_OAK_DOOR.get(), TDBlocks.MANGROVE_DOOR.get(), Blocks.CHERRY_DOOR, Blocks.BAMBOO_DOOR, TDBlocks.CRIMSON_DOOR.get(), TDBlocks.WARPED_DOOR.get());
        tag(TDTags.WOODEN_INDISCRETE_DOORS).add(TDBlocks.OAK_INDISCRETE_DOOR.get(), TDBlocks.SPRUCE_INDISCRETE_DOOR.get(), TDBlocks.BIRCH_INDISCRETE_DOOR.get(),TDBlocks.JUNGLE_INDISCRETE_DOOR.get(), Blocks.ACACIA_DOOR, TDBlocks.DARK_OAK_INDISCRETE_DOOR.get(), TDBlocks.MANGROVE_INDISCRETE_DOOR.get(), TDBlocks.CHERRY_INDISCRETE_DOOR.get(), TDBlocks.BAMBOO_INDISCRETE_DOOR.get(), TDBlocks.CRIMSON_INDISCRETE_DOOR.get(), TDBlocks.WARPED_INDISCRETE_DOOR.get());
        tag(TDTags.WOODEN_TRANSIT_DOORS).add(TDBlocks.OAK_TRANSIT_DOOR.get(), TDBlocks.SPRUCE_TRANSIT_DOOR.get(), TDBlocks.BIRCH_TRANSIT_DOOR.get(),TDBlocks.JUNGLE_TRANSIT_DOOR.get(), TDBlocks.ACACIA_TRANSIT_DOOR.get(), TDBlocks.DARK_OAK_TRANSIT_DOOR.get(), TDBlocks.MANGROVE_TRANSIT_DOOR.get(), TDBlocks.CHERRY_TRANSIT_DOOR.get(), TDBlocks.BAMBOO_TRANSIT_DOOR.get(), TDBlocks.CRIMSON_TRANSIT_DOOR.get(), TDBlocks.WARPED_TRANSIT_DOOR.get());
        tag(TDTags.WOODEN_PET_DOORS).add(TDBlocks.OAK_PET_DOOR.get(), TDBlocks.SPRUCE_PET_DOOR.get(), TDBlocks.BIRCH_PET_DOOR.get(),TDBlocks.JUNGLE_PET_DOOR.get(), TDBlocks.ACACIA_PET_DOOR.get(), TDBlocks.DARK_OAK_PET_DOOR.get(), TDBlocks.MANGROVE_PET_DOOR.get(), TDBlocks.CHERRY_PET_DOOR.get(), TDBlocks.BAMBOO_PET_DOOR.get(), TDBlocks.CRIMSON_PET_DOOR.get(), TDBlocks.WARPED_PET_DOOR.get());

        for (String wood : NMLContent.WOOD_NAMES) {
            if (!wood.equals("maple")) {
                tag(TDTags.WOODEN_DISCRETE_DOORS).add(NMLContent.BLOCKS_MAP.get(wood + "_discrete_door").get());
            }

            if (!(wood.equals("pine") || wood.equals("willow") || wood.equals("walnut"))) {
                tag(TDTags.WOODEN_CLASIC_DOORS).add(NMLContent.BLOCKS_MAP.get(wood + "_normal_door").get());
            }

            tag(TDTags.WOODEN_INDISCRETE_DOORS).add(NMLContent.BLOCKS_MAP.get(wood + "_indiscrete_door").get());
            tag(TDTags.WOODEN_TRANSIT_DOORS).add(NMLContent.BLOCKS_MAP.get(wood + "_transit_door").get());
            tag(TDTags.WOODEN_PET_DOORS).add(NMLContent.BLOCKS_MAP.get(wood + "_pet_door").get());
        }
    }
    protected void registerBlockMineables() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(TDBlocks.IRON_BARS_SLIDING_DOOR.get());
        tag(BlockTags.MINEABLE_WITH_AXE).addTag(TDTags.WOODEN_DISCRETE_DOORS).addTag(TDTags.WOODEN_CLASIC_DOORS).addTag(TDTags.WOODEN_INDISCRETE_DOORS).addTag(TDTags.WOODEN_TRANSIT_DOORS).addTag(TDTags.WOODEN_PET_DOORS);
    }

    protected void registerMinecraftTags() {
        tag(BlockTags.WOODEN_DOORS).addTag(TDTags.WOODEN_DISCRETE_DOORS).addTag(TDTags.WOODEN_CLASIC_DOORS).addTag(TDTags.WOODEN_INDISCRETE_DOORS).addTag(TDTags.WOODEN_TRANSIT_DOORS).addTag(TDTags.WOODEN_PET_DOORS);
        tag(BlockTags.WOODEN_TRAPDOORS).addTag(TDTags.WOODEN_PET_DOORS);
        tag(BlockTags.DOORS).add(TDBlocks.IRON_BARS_SLIDING_DOOR.get());
        tag(BlockTags.WALLS).add(TDBlocks.IRON_BARS_SLIDING_DOOR.get());
    }
}