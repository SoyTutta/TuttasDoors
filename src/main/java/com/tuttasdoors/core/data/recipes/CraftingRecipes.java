package com.tuttasdoors.core.data.recipes;

import com.tuttasdoors.registry.TDItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public class CraftingRecipes {

    private enum DoorType {
        NORMAL, INDISCRETE, TRANSIT, PET
    }

    private record DoorWoodTypeData(String name, Object plank, Object normalDoor, Object indiscreteDoor, Object transitDoor, Object petDoor, Object discreteDoor, String modid) {}

    public static void register(RecipeOutput output) {
        List<DoorWoodTypeData> woodTypes = List.of(
                new DoorWoodTypeData("oak", Items.OAK_PLANKS, Items.OAK_DOOR, TDItems.OAK_INDISCRETE_DOOR.get(), TDItems.OAK_TRANSIT_DOOR.get(), TDItems.OAK_PET_DOOR.get(), TDItems.OAK_DISCRETE_DOOR.get(), "tuttasdoors"),
                new DoorWoodTypeData("spruce", Items.SPRUCE_PLANKS, TDItems.SPRUCE_DOOR.get(), TDItems.SPRUCE_INDISCRETE_DOOR.get(), TDItems.SPRUCE_TRANSIT_DOOR.get(), TDItems.SPRUCE_PET_DOOR.get(), Items.SPRUCE_DOOR, "tuttasdoors"),
                new DoorWoodTypeData("birch", Items.BIRCH_PLANKS, TDItems.BIRCH_DOOR.get(), TDItems.BIRCH_INDISCRETE_DOOR.get(), TDItems.BIRCH_TRANSIT_DOOR.get(), TDItems.BIRCH_PET_DOOR.get(), Items.BIRCH_DOOR, "tuttasdoors"),
                new DoorWoodTypeData("jungle", Items.JUNGLE_PLANKS, Items.JUNGLE_DOOR, TDItems.JUNGLE_INDISCRETE_DOOR.get(), TDItems.JUNGLE_TRANSIT_DOOR.get(), TDItems.JUNGLE_PET_DOOR.get(), TDItems.JUNGLE_DISCRETE_DOOR.get(), "tuttasdoors"),
                new DoorWoodTypeData("acacia", Items.ACACIA_PLANKS, TDItems.ACACIA_DOOR.get(), Items.ACACIA_DOOR, TDItems.ACACIA_TRANSIT_DOOR.get(), TDItems.ACACIA_PET_DOOR.get(), TDItems.ACACIA_DISCRETE_DOOR.get(), "tuttasdoors"),
                new DoorWoodTypeData("dark_oak", Items.DARK_OAK_PLANKS, TDItems.DARK_OAK_DOOR.get(), TDItems.DARK_OAK_INDISCRETE_DOOR.get(), TDItems.DARK_OAK_TRANSIT_DOOR.get(), TDItems.DARK_OAK_PET_DOOR.get(), Items.DARK_OAK_DOOR, "tuttasdoors"),
                new DoorWoodTypeData("mangrove", Items.MANGROVE_PLANKS, TDItems.MANGROVE_DOOR.get(), TDItems.MANGROVE_INDISCRETE_DOOR.get(), TDItems.MANGROVE_TRANSIT_DOOR.get(), TDItems.MANGROVE_PET_DOOR.get(), Items.MANGROVE_DOOR, "tuttasdoors"),
                new DoorWoodTypeData("cherry", Items.CHERRY_PLANKS, Items.CHERRY_DOOR, TDItems.CHERRY_INDISCRETE_DOOR.get(), TDItems.CHERRY_TRANSIT_DOOR.get(), TDItems.CHERRY_PET_DOOR.get(), TDItems.CHERRY_DISCRETE_DOOR.get(), "tuttasdoors"),
                new DoorWoodTypeData("bamboo", Items.BAMBOO_PLANKS, Items.BAMBOO_DOOR, TDItems.BAMBOO_INDISCRETE_DOOR.get(), TDItems.BAMBOO_TRANSIT_DOOR.get(), TDItems.BAMBOO_PET_DOOR.get(), TDItems.BAMBOO_DISCRETE_DOOR.get(), "tuttasdoors"),
                new DoorWoodTypeData("crimson", Items.CRIMSON_PLANKS, TDItems.CRIMSON_DOOR.get(), TDItems.CRIMSON_INDISCRETE_DOOR.get(), TDItems.CRIMSON_TRANSIT_DOOR.get(), TDItems.CRIMSON_PET_DOOR.get(), Items.CRIMSON_DOOR, "tuttasdoors"),
                new DoorWoodTypeData("warped", Items.WARPED_PLANKS, TDItems.WARPED_DOOR.get(), TDItems.WARPED_INDISCRETE_DOOR.get(), TDItems.WARPED_TRANSIT_DOOR.get(), TDItems.WARPED_PET_DOOR.get(), Items.WARPED_DOOR, "tuttasdoors") ,

                new DoorWoodTypeData("pine", "nomansland:pine_planks","nomansland:pine_door", "nomansland:pine_indiscrete_door", "nomansland:pine_transit_door", "nomansland:pine_pet_door", "nomansland:pine_discrete_door", "nomansland"),
                new DoorWoodTypeData("walnut", "nomansland:walnut_planks","nomansland:walnut_door", "nomansland:walnut_indiscrete_door", "nomansland:walnut_transit_door", "nomansland:walnut_pet_door", "nomansland:walnut_discrete_door", "nomansland"),
                new DoorWoodTypeData("willow", "nomansland:willow_planks","nomansland:willow_door", "nomansland:willow_indiscrete_door", "nomansland:willow_transit_door", "nomansland:willow_pet_door", "nomansland:willow_discrete_door", "nomansland"),
                new DoorWoodTypeData("maple", "nomansland:maple_planks","nomansland:maple_normal_door", "nomansland:maple_indiscrete_door", "nomansland:maple_transit_door", "nomansland:maple_pet_door", "nomansland:maple_door", "nomansland")
        );

        for (DoorWoodTypeData wood : woodTypes) {
            createDoorRecipe( output, DoorType.NORMAL, getItemLike(wood.normalDoor()), getItemLike(wood.plank()), wood.name() + "_door", 3, wood.modid()
            );
            createDoorRecipe( output, DoorType.INDISCRETE, getItemLike(wood.indiscreteDoor()), getItemLike(wood.plank()), wood.name() + "_indiscrete_door", 3, wood.modid()
            );
            createDoorRecipe( output, DoorType.TRANSIT, getItemLike(wood.transitDoor()), getItemLike(wood.plank()), wood.name() + "_transit_door", 3, wood.modid()
            );
            createDoorRecipe( output, DoorType.PET, getItemLike(wood.petDoor()), getItemLike(wood.plank()), wood.name() + "_pet_door", 2, wood.modid()
            );
        }

        for (DoorWoodTypeData wood : woodTypes) {
            registerConversionRecipes(output, wood);
        }

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, (getItemLike("nomansland:pine_discrete_door")), 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', (getItemLike("nomansland:pine_planks")))
                .unlockedBy("has_pine_planks", InventoryChangeTrigger.TriggerInstance.hasItems((getItemLike("nomansland:pine_planks"))))
                .group("wooden_discrete_doors")
                .save(output, "nomansland:wood/pine/pine_door");
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, (getItemLike("nomansland:willow_discrete_door")), 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', (getItemLike("nomansland:willow_planks")))
                .unlockedBy("has_willow_planks", InventoryChangeTrigger.TriggerInstance.hasItems((getItemLike("nomansland:willow_planks"))))
                .group("wooden_discrete_doors")
                .save(output, "nomansland:wood/willow/willow_door");
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, (getItemLike("nomansland:walnut_discrete_door")), 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', (getItemLike("nomansland:walnut_planks")))
                .unlockedBy("has_walnut_planks", InventoryChangeTrigger.TriggerInstance.hasItems((getItemLike("nomansland:walnut_planks"))))
                .group("wooden_discrete_doors")
                .save(output, "nomansland:wood/walnut/walnut_door");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, (TDItems.IRON_BARS_SLIDING_DOOR.get()), 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', (Items.IRON_BARS))
                .unlockedBy("has_iron_bars", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_BARS, Items.IRON_INGOT))
                .group("sliding_doors")
                .save(output, "tuttasdoors:crafting/iron_bars_sliding_door");
    }

    private static ItemLike getItemLike(Object obj) {
        if (obj instanceof String id) {
            ResourceLocation rl = ResourceLocation.tryParse(id);
            if (rl == null) {
                throw new IllegalArgumentException("Invalid resource ID: " + id);
            }
            return BuiltInRegistries.ITEM.get(rl);
        }
        else if (obj instanceof ItemLike item) {
            return item;
        }
        else {
            throw new IllegalArgumentException(
                    "Expected String or ItemLike, got " + obj.getClass().getSimpleName());
        }
    }

    private static void createDoorRecipe(RecipeOutput output, DoorType type, ItemLike result, ItemLike plank, String name, int count, String modid) {
        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, result, count);

        switch (type) {
            case NORMAL -> builder.pattern("s#").pattern("##").pattern("##")
                    .define('s', Items.STICK)
                    .define('#', plank)
                    .group("wooden_doors");
            case INDISCRETE -> builder.pattern("s#").pattern("s#").pattern("##")
                    .define('s', Items.STICK)
                    .define('#', plank)
                    .group("wooden_indiscrete_doors");
            case TRANSIT -> builder.pattern(" #").pattern("##").pattern("##")
                    .define('#', plank)
                    .group("wooden_transit_doors");
            case PET -> builder.pattern("ss").pattern("##").pattern("##")
                    .define('s', Items.STICK)
                    .define('#', plank)
                    .group("wooden_pet_doors");
        }

        builder.unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(plank.asItem()).getPath(),
                        InventoryChangeTrigger.TriggerInstance.hasItems(plank))
                .save(output, modid + ":crafting/" + name);
    }

    private static void registerConversionRecipes(RecipeOutput output, DoorWoodTypeData wood) {
        ItemLike plank = getItemLike(wood.plank());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, getItemLike(wood.discreteDoor()))
                .requires(plank)
                .requires(getItemLike(wood.normalDoor()))
                .unlockedBy("has_" + getItemLike(wood.normalDoor()).asItem(), InventoryChangeTrigger.TriggerInstance.hasItems(getItemLike(wood.normalDoor())))
                .group("alt_wooden_discrete_doors")
                .save(output, wood.modid() + ":crafting/discrete_from_normal_" + wood.name());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, getItemLike(wood.discreteDoor()))
                .requires(plank, 2)
                .requires(getItemLike(wood.indiscreteDoor()))
                .unlockedBy("has_" + getItemLike(wood.indiscreteDoor()).asItem(), InventoryChangeTrigger.TriggerInstance.hasItems(getItemLike(wood.indiscreteDoor())))
                .group("alt_wooden_discrete_doors")
                .save(output, wood.modid() + ":crafting/discrete_from_indiscrete_" + wood.name());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, getItemLike(wood.indiscreteDoor()))
                .requires(Items.STICK)
                .requires(getItemLike(wood.normalDoor()))
                .unlockedBy("has_" + getItemLike(wood.normalDoor()).asItem(), InventoryChangeTrigger.TriggerInstance.hasItems(getItemLike(wood.normalDoor())))
                .group("alt_wooden_indiscrete_doors")
                .save(output, wood.modid() + ":crafting/indiscrete_from_normal_" + wood.name());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, getItemLike(wood.indiscreteDoor()))
                .requires(Items.STICK, 2)
                .requires(getItemLike(wood.discreteDoor()))
                .unlockedBy("has_" + getItemLike(wood.discreteDoor()).asItem(), InventoryChangeTrigger.TriggerInstance.hasItems(getItemLike(wood.discreteDoor())))
                .group("alt_wooden_indiscrete_doors")
                .save(output, wood.modid() + ":crafting/indiscrete_from_discrete_" + wood.name());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, getItemLike(wood.normalDoor()))
                .requires(plank)
                .requires(getItemLike(wood.indiscreteDoor()))
                .unlockedBy("has_" + getItemLike(wood.indiscreteDoor()).asItem(), InventoryChangeTrigger.TriggerInstance.hasItems(getItemLike(wood.indiscreteDoor())))
                .group("alt_wooden_doors")
                .save(output, wood.modid() + ":crafting/normal_from_indiscrete_" + wood.name());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, getItemLike(wood.normalDoor()))
                .requires(Items.STICK)
                .requires(getItemLike(wood.discreteDoor()))
                .unlockedBy("has_" + getItemLike(wood.discreteDoor()).asItem(), InventoryChangeTrigger.TriggerInstance.hasItems(getItemLike(wood.discreteDoor())))
                .group("alt_wooden_doors")
                .save(output, wood.modid() + ":crafting/normal_from_discrete_" + wood.name());
    }
}