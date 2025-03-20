package com.tuttasdoors.core.data;

import com.google.common.collect.Sets;
import com.tuttasdoors.TuttasDoors;
import com.tuttasdoors.registry.TDItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Credits to Vazkii and team for some references on mass-reading blocks to datagen!
 */
public class TDItemsModels extends ItemModelProvider
{
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";
    public static final ResourceLocation MUG = ResourceLocation.fromNamespaceAndPath(TuttasDoors.MODID, "item/mug");

    public TDItemsModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TuttasDoors.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Set<Item> items = BuiltInRegistries.ITEM.stream().filter(i -> TuttasDoors.MODID.equals(BuiltInRegistries.ITEM.getKey(i).getNamespace()))
                .collect(Collectors.toSet());

        Set<Item> spriteBlockItems = Sets.newHashSet(
                TDItems.OAK_DISCRETE_DOOR.get(),
                TDItems.OAK_INDISCRETE_DOOR.get(),
                TDItems.OAK_TRANSIT_DOOR.get(),
        ///        TDItems.OAK_TRANSIT_GATE.get(),
                TDItems.OAK_PET_DOOR.get(),

                TDItems.SPRUCE_DOOR.get(),
                TDItems.SPRUCE_INDISCRETE_DOOR.get(),
                TDItems.SPRUCE_TRANSIT_DOOR.get(),
        ///        TDItems.SPRUCE_TRANSIT_GATE.get(),
                TDItems.SPRUCE_PET_DOOR.get(),

                TDItems.BIRCH_DOOR.get(),
                TDItems.BIRCH_INDISCRETE_DOOR.get(),
                TDItems.BIRCH_TRANSIT_DOOR.get(),
        ///        TDItems.BIRCH_TRANSIT_GATE.get(),
                TDItems.BIRCH_PET_DOOR.get(),

                TDItems.JUNGLE_DISCRETE_DOOR.get(),
                TDItems.JUNGLE_INDISCRETE_DOOR.get(),
                TDItems.JUNGLE_TRANSIT_DOOR.get(),
        ///        TDItems.JUNGLE_TRANSIT_GATE.get(),
                TDItems.JUNGLE_PET_DOOR.get(),

                TDItems.ACACIA_DISCRETE_DOOR.get(),
                TDItems.ACACIA_DOOR.get(),
                TDItems.ACACIA_TRANSIT_DOOR.get(),
        ///        TDItems.ACACIA_TRANSIT_GATE.get(),
                TDItems.ACACIA_PET_DOOR.get(),

                TDItems.DARK_OAK_DOOR.get(),
                TDItems.DARK_OAK_INDISCRETE_DOOR.get(),
                TDItems.DARK_OAK_TRANSIT_DOOR.get(),
        ///         TDItems.DARK_OAK_TRANSIT_GATE.get(),
                TDItems.DARK_OAK_PET_DOOR.get(),

                TDItems.MANGROVE_DOOR.get(),
                TDItems.MANGROVE_INDISCRETE_DOOR.get(),
                TDItems.MANGROVE_TRANSIT_DOOR.get(),
        ///        TDItems.MANGROVE_TRANSIT_GATE.get(),
                TDItems.MANGROVE_PET_DOOR.get(),

                TDItems.CHERRY_DISCRETE_DOOR.get(),
                TDItems.CHERRY_INDISCRETE_DOOR.get(),
                TDItems.CHERRY_TRANSIT_DOOR.get(),
        ///        TDItems.CHERRY_TRANSIT_GATE.get(),
                TDItems.CHERRY_PET_DOOR.get(),

                TDItems.BAMBOO_DISCRETE_DOOR.get(),
                TDItems.BAMBOO_INDISCRETE_DOOR.get(),
                TDItems.BAMBOO_TRANSIT_DOOR.get(),
        ///        TDItems.BAMBOO_TRANSIT_GATE.get(),
                TDItems.BAMBOO_PET_DOOR.get(),

                TDItems.CRIMSON_DOOR.get(),
                TDItems.CRIMSON_INDISCRETE_DOOR.get(),
                TDItems.CRIMSON_TRANSIT_DOOR.get(),
        ///        TDItems.CRIMSON_TRANSIT_GATE.get(),
                TDItems.CRIMSON_PET_DOOR.get(),

                TDItems.WARPED_DOOR.get(),
                TDItems.WARPED_INDISCRETE_DOOR.get(),
                TDItems.WARPED_TRANSIT_DOOR.get(),
        ///        TDItems.WARPED_TRANSIT_GATE.get(),
                TDItems.WARPED_PET_DOOR.get()
        );
        takeAll(items, spriteBlockItems.toArray(new Item[0])).forEach(item -> withExistingParent(itemName(item), GENERATED).texture("layer0", resourceItem(itemName(item))));

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

    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <T> Collection<T> takeAll(Set<? extends T> src, T... items) {
        List<T> ret = Arrays.asList(items);
        for (T item : items) {
            if (!src.contains(item)) {
                TuttasDoors.LOGGER.warn("Item {} not found in set", item);
            }
        }
        if (!src.removeAll(ret)) {
            TuttasDoors.LOGGER.warn("takeAll array didn't yield anything ({})", Arrays.toString(items));
        }
        return ret;
    }

    public static <T> Collection<T> takeAll(Set<T> src, Predicate<T> pred) {
        List<T> ret = new ArrayList<>();

        Iterator<T> iter = src.iterator();
        while (iter.hasNext()) {
            T item = iter.next();
            if (pred.test(item)) {
                iter.remove();
                ret.add(item);
            }
        }

        if (ret.isEmpty()) {
            TuttasDoors.LOGGER.warn("takeAll predicate yielded nothing", new Throwable());
        }
        return ret;
    }
}