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
                this.add(descriptionId, name);
            }
        });

        addCustomTranslations();
    }

    private void addCustomTranslations() {
        this.add("tuttasdoors.itemGroup.main", "Tutta's doors");
        this.add("block.minecraft.spruce_door", "Spruce Discrete Door");
        this.add("block.minecraft.birch_door", "Birch Discrete Door");
        this.add("block.minecraft.dark_oak_door", "Dark Oak Discrete Door");
        this.add("block.minecraft.mangrove_door", "Mangrove Discrete Door");
        this.add("block.minecraft.crimson_door", "Crimson Discrete Door");
        this.add("block.minecraft.warped_door", "Warped Discrete Door");
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