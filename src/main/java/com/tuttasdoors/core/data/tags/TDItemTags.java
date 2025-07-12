package com.tuttasdoors.core.data.tags;

import com.tuttasdoors.registry.TDItems;
import com.tuttasdoors.registry.TDTags;
import com.tuttasdoors.registry.compat.NMLContent;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;


public class TDItemTags extends ItemTagsProvider
{
    public TDItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        registerMinecraftTags();
        registerModTags();
    }

    private void registerModTags() {
        tag(TDTags.WOODEN_DISCRETE_DOORS_ITEMS).add(TDItems.OAK_DISCRETE_DOOR.get(),  Items.SPRUCE_DOOR, Items.BIRCH_DOOR,TDItems.JUNGLE_DISCRETE_DOOR.get(), TDItems.ACACIA_DISCRETE_DOOR.get(), Items.DARK_OAK_DOOR, Items.MANGROVE_DOOR, TDItems.CHERRY_DISCRETE_DOOR.get(), TDItems.BAMBOO_DISCRETE_DOOR.get(), Items.CRIMSON_DOOR, Items.WARPED_DOOR);
        tag(TDTags.WOODEN_CLASIC_DOORS_ITEMS).add(Items.OAK_DOOR,  TDItems.SPRUCE_DOOR.get(), TDItems.BIRCH_DOOR.get(),Items.JUNGLE_DOOR, Items.ACACIA_DOOR, TDItems.DARK_OAK_DOOR.get(), TDItems.MANGROVE_DOOR.get(), Items.CHERRY_DOOR, Items.BAMBOO_DOOR, TDItems.CRIMSON_DOOR.get(), TDItems.WARPED_DOOR.get());
        tag(TDTags.WOODEN_INDISCRETE_DOORS_ITEMS).add(TDItems.OAK_INDISCRETE_DOOR.get(), TDItems.SPRUCE_INDISCRETE_DOOR.get(), TDItems.BIRCH_INDISCRETE_DOOR.get(),TDItems.JUNGLE_INDISCRETE_DOOR.get(), Items.ACACIA_DOOR, TDItems.DARK_OAK_INDISCRETE_DOOR.get(), TDItems.MANGROVE_INDISCRETE_DOOR.get(), TDItems.CHERRY_INDISCRETE_DOOR.get(), TDItems.BAMBOO_INDISCRETE_DOOR.get(), TDItems.CRIMSON_INDISCRETE_DOOR.get(), TDItems.WARPED_INDISCRETE_DOOR.get());
        tag(TDTags.WOODEN_TRANSIT_DOORS_ITEMS).add(TDItems.OAK_TRANSIT_DOOR.get(), TDItems.SPRUCE_TRANSIT_DOOR.get(), TDItems.BIRCH_TRANSIT_DOOR.get(),TDItems.JUNGLE_TRANSIT_DOOR.get(), TDItems.ACACIA_TRANSIT_DOOR.get(), TDItems.DARK_OAK_TRANSIT_DOOR.get(), TDItems.MANGROVE_TRANSIT_DOOR.get(), TDItems.CHERRY_TRANSIT_DOOR.get(), TDItems.BAMBOO_TRANSIT_DOOR.get(), TDItems.CRIMSON_TRANSIT_DOOR.get(), TDItems.WARPED_TRANSIT_DOOR.get());
        tag(TDTags.WOODEN_PET_DOORS_ITEMS).add(TDItems.OAK_PET_DOOR.get(), TDItems.SPRUCE_PET_DOOR.get(), TDItems.BIRCH_PET_DOOR.get(),TDItems.JUNGLE_PET_DOOR.get(), TDItems.ACACIA_PET_DOOR.get(), TDItems.DARK_OAK_PET_DOOR.get(), TDItems.MANGROVE_PET_DOOR.get(), TDItems.CHERRY_PET_DOOR.get(), TDItems.BAMBOO_PET_DOOR.get(), TDItems.CRIMSON_PET_DOOR.get(), TDItems.WARPED_PET_DOOR.get());

        for (String wood : NMLContent.WOOD_NAMES) {
            if (!wood.equals("maple")) {
                tag(TDTags.WOODEN_DISCRETE_DOORS_ITEMS).add(NMLContent.ITEMS_MAP.get(wood + "_discrete_door").get());
            }

            if (!(wood.equals("pine") || wood.equals("willow") || wood.equals("walnut"))) {
                tag(TDTags.WOODEN_CLASIC_DOORS_ITEMS).add(NMLContent.ITEMS_MAP.get(wood + "_normal_door").get());
            }

            tag(TDTags.WOODEN_INDISCRETE_DOORS_ITEMS).add(NMLContent.ITEMS_MAP.get(wood + "_indiscrete_door").get());
            tag(TDTags.WOODEN_TRANSIT_DOORS_ITEMS).add(NMLContent.ITEMS_MAP.get(wood + "_transit_door").get());
            tag(TDTags.WOODEN_PET_DOORS_ITEMS).add(NMLContent.ITEMS_MAP.get(wood + "_pet_door").get());
        }
    }

    private void registerMinecraftTags() {
        tag(ItemTags.DOORS).add(TDItems.IRON_BARS_SLIDING_DOOR.get());
        tag(ItemTags.WOODEN_DOORS).addTag(TDTags.WOODEN_DISCRETE_DOORS_ITEMS).addTag(TDTags.WOODEN_CLASIC_DOORS_ITEMS).addTag(TDTags.WOODEN_INDISCRETE_DOORS_ITEMS).addTag(TDTags.WOODEN_TRANSIT_DOORS_ITEMS).addTag(TDTags.WOODEN_PET_DOORS_ITEMS);
        tag(ItemTags.WOODEN_TRAPDOORS).addTag(TDTags.WOODEN_PET_DOORS_ITEMS);
    }
}