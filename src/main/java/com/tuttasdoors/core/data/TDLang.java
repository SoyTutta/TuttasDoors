package com.tuttasdoors.core.data;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.tuttasdoors.registry.TDBlocks;
import com.tuttasdoors.registry.TDItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class TDLang extends LanguageProvider {
    private final Set<String> addedKeys = new HashSet<>();

    public TDLang(PackOutput output) {
        super(output, "tuttasdoors", "en_us");
    }

    @Override
    protected void addTranslations() {
        Set<Supplier<Block>> blocks = TDBlocks.BLOCKS.getEntries().stream()
                .map(entry -> (Supplier<Block>) entry::get)
                .collect(Collectors.toSet());
        Set<Supplier<Item>> items = TDItems.ITEMS.getEntries().stream()
                .map(entry -> (Supplier<Item>) entry::get)
                .collect(Collectors.toSet());

        blocks.forEach((b) -> {
            String descriptionId = b.get().getDescriptionId();
            if (addedKeys.add(descriptionId)) {
                String name = descriptionId.replaceFirst("block.tuttasdoors.", "");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("Of", "of");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("Discrete", "Discreet");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("Indiscrete", "Indiscreet");
                this.add(descriptionId, name);
            }
        });

        items.removeIf((i) -> i.get() instanceof BlockItem);
        items.forEach((i) -> {
            String descriptionId = i.get().getDescriptionId();
            if (addedKeys.add(descriptionId)) {
                String name = descriptionId.replaceFirst("item.tuttasdoors.", "");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("A", "a");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("On", "on");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("Of", "of");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("And", "and");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("With", "with");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("Discrete", "Discreet");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("Indiscrete", "Indiscreet");
                this.add(descriptionId, name);
            }
        });

        addCustomTranslations();
    }

    private void addCustomTranslations() {
        this.add("tuttasdoors.itemGroup.main", "Tutta's doors");
        this.add("block.minecraft.spruce_door", "Spruce Discreet Door");
        this.add("block.minecraft.birch_door", "Birch Discreet Door");
        this.add("block.minecraft.dark_oak_door", "Dark Oak Discreet Door");
        this.add("block.minecraft.mangrove_door", "Mangrove Discreet Door");
        this.add("block.minecraft.crimson_door", "Crimson Discreet Door");
        this.add("block.minecraft.warped_door", "Warped Discreet Door");
        this.add("block.minecraft.acacia_door", "Acacia Indiscreet Door");

        this.add("item.minecraft.spruce_door", "Spruce Discreet Door");
        this.add("item.minecraft.birch_door", "Birch Discreet Door");
        this.add("item.minecraft.dark_oak_door", "Dark Oak Discreet Door");
        this.add("item.minecraft.mangrove_door", "Mangrove Discreet Door");
        this.add("item.minecraft.crimson_door", "Crimson Discreet Door");
        this.add("item.minecraft.warped_door", "Warped Discreet Door");
        this.add("item.minecraft.acacia_door", "Acacia Indiscreet Door");

        // No Mans Lands
        this.add("block.nomansland.pine_discrete_door", "Pine Discreet Door");
        this.add("block.nomansland.pine_indiscrete_door", "Pine Indiscreet Door");
        this.add("block.nomansland.pine_transit_door", "Pine Transit Door");
        this.add("block.nomansland.pine_pet_door", "Pine Pet Door");

        this.add("block.nomansland.willow_discrete_door", "Willow Discreet Door");
        this.add("block.nomansland.willow_indiscrete_door", "Willow Indiscreet Door");
        this.add("block.nomansland.willow_transit_door", "Willow Transit Door");
        this.add("block.nomansland.willow_pet_door", "Willow Pet Door");

        this.add("block.nomansland.walnut_discrete_door", "Walnut Discreet Door");
        this.add("block.nomansland.walnut_indiscrete_door", "Walnut Indiscreet Door");
        this.add("block.nomansland.walnut_transit_door", "Walnut Transit Door");
        this.add("block.nomansland.walnut_pet_door", "Walnut Pet Door");

        this.add("block.nomansland.maple_normal_door", "Maple Door");
        this.add("block.nomansland.maple_indiscrete_door", "Maple Indiscreet Door");
        this.add("block.nomansland.maple_transit_door", "Maple Transit Door");
        this.add("block.nomansland.maple_pet_door", "Maple Pet Door");

        this.add("item.nomansland.pine_discrete_door", "Pine Discreet Door");
        this.add("item.nomansland.pine_indiscrete_door", "Pine Indiscreet Door");
        this.add("item.nomansland.pine_transit_door", "Pine Transit Door");
        this.add("item.nomansland.pine_pet_door", "Pine Pet Door");

        this.add("item.nomansland.willow_discrete_door", "Willow Discreet Door");
        this.add("item.nomansland.willow_indiscrete_door", "Willow Indiscreet Door");
        this.add("item.nomansland.willow_transit_door", "Willow Transit Door");
        this.add("item.nomansland.willow_pet_door", "Willow Pet Door");

        this.add("item.nomansland.walnut_discrete_door", "Walnut Discreet Door");
        this.add("item.nomansland.walnut_indiscrete_door", "Walnut Indiscreet Door");
        this.add("item.nomansland.walnut_transit_door", "Walnut Transit Door");
        this.add("item.nomansland.walnut_pet_door", "Walnut Pet Door");

        this.add("item.nomansland.maple_normal_door", "Maple Door");
        this.add("item.nomansland.maple_indiscrete_door", "Maple Indiscreet Door");
        this.add("item.nomansland.maple_transit_door", "Maple Transit Door");
        this.add("item.nomansland.maple_pet_door", "Maple Pet Door");
    }

    @Override
    public String getName() {
        return "Lang Entries";
    }

    public static String toTitleCase(String givenString, String regex) {
        String[] stringArray = givenString.split(regex);
        StringBuilder stringBuilder = new StringBuilder();
        String[] var4 = stringArray;
        int var5 = stringArray.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            String string = var4[var6];
            stringBuilder.append(Character.toUpperCase(string.charAt(0))).append(string.substring(1)).append(regex);
        }

        return stringBuilder.toString().trim().replaceAll(regex, " ").substring(0, stringBuilder.length() - 1);
    }

    public String correctBlockItemName(String name) {
        if (!name.endsWith("_bricks") && name.contains("bricks")) {
            name = name.replaceFirst("bricks", "brick");
        }

        if ((name.contains("_fence") || name.contains("_button")) && name.contains("planks")) {
            name = name.replaceFirst("_planks", "");
        }

        return name;
    }
}