package com.tuttasdoors.core.data;

import com.tuttasdoors.TuttasDoors;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.*;
import java.util.stream.Collectors;

public class TDItemsModels extends ItemModelProvider
{
    public static final String GENERATED = "item/generated";

    public TDItemsModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TuttasDoors.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Set<Item> items = BuiltInRegistries.ITEM.stream().filter(i -> TuttasDoors.MODID.equals(BuiltInRegistries.ITEM.getKey(i).getNamespace()))
                .collect(Collectors.toSet());

        items.forEach(item -> itemGeneratedModel(item, resourceItem(itemName(item))));
    }

    public void itemGeneratedModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }


    private String itemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    public ResourceLocation resourceItem(String path) {
        return ResourceLocation.fromNamespaceAndPath(TuttasDoors.MODID, "item/" + path);
    }
}