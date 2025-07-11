package com.tuttasdoors.core.data;

import com.tuttasdoors.blocks.PetDoorBlock;
import com.tuttasdoors.registry.TDBlocks;
import com.tuttasdoors.registry.compat.NMLContent;
import net.minecraft.world.level.block.Block;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.core.HolderLookup;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BlockLootTables extends BlockLootSubProvider {
    public BlockLootTables(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        for (Block door : getKnownBlocks()) {
            if (door instanceof PetDoorBlock) {
                dropSelf(door);
            } else {
                add(door, this::createDoorTable);
            }
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> doors = new ArrayList<>();

        for (var sup : TDBlocks.BLOCKS.getEntries()) {
            doors.add(sup.get());
        }
        for (var sup : NMLContent.BLOCKS.getEntries()) {
            doors.add(sup.get());
        }

        return doors;
    }
}