package com.tuttasdoors.core.data;

import com.tuttasdoors.TuttasDoors;
import com.tuttasdoors.registry.TDBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class TDBlockStates extends BlockStateProvider {
    public TDBlockStates(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TuttasDoors.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerDoor(TDBlocks.OAK_DISCRETE_DOOR, "discrete_door/oak_door");
        registerDoor(TDBlocks.JUNGLE_DISCRETE_DOOR, "discrete_door/jungle_door");
        registerDoor(TDBlocks.ACACIA_DISCRETE_DOOR, "discrete_door/acacia_door");
        registerDoor(TDBlocks.CHERRY_DISCRETE_DOOR, "discrete_door/cherry_door");
        registerDoor(TDBlocks.BAMBOO_DISCRETE_DOOR, "discrete_door/bamboo_door");

        registerDoor(TDBlocks.SPRUCE_DOOR, "door/spruce_door");
        registerDoor(TDBlocks.BIRCH_DOOR, "door/birch_door");
        registerDoor(TDBlocks.ACACIA_DOOR, "door/acacia_door");
        registerDoor(TDBlocks.DARK_OAK_DOOR, "door/dark_oak_door");
        registerDoor(TDBlocks.MANGROVE_DOOR, "door/mangrove_door");
        registerDoor(TDBlocks.CRIMSON_DOOR, "door/crimson_door");
        registerDoor(TDBlocks.WARPED_DOOR, "door/warped_door");

        registerDoor(TDBlocks.OAK_INDISCRETE_DOOR, "indiscrete_door/oak_door");
        registerDoor(TDBlocks.SPRUCE_INDISCRETE_DOOR, "indiscrete_door/spruce_door");
        registerDoor(TDBlocks.BIRCH_INDISCRETE_DOOR, "indiscrete_door/birch_door");
        registerDoor(TDBlocks.JUNGLE_INDISCRETE_DOOR, "indiscrete_door/jungle_door");
        registerDoor(TDBlocks.DARK_OAK_INDISCRETE_DOOR, "indiscrete_door/dark_oak_door");
        registerDoor(TDBlocks.MANGROVE_INDISCRETE_DOOR, "indiscrete_door/mangrove_door");
        registerDoor(TDBlocks.CHERRY_INDISCRETE_DOOR, "indiscrete_door/cherry_door");
        registerDoor(TDBlocks.BAMBOO_INDISCRETE_DOOR, "indiscrete_door/bamboo_door");
        registerDoor(TDBlocks.CRIMSON_INDISCRETE_DOOR, "indiscrete_door/crimson_door");
        registerDoor(TDBlocks.WARPED_INDISCRETE_DOOR, "indiscrete_door/warped_door");

        registerTransitDoor(TDBlocks.OAK_TRANSIT_DOOR, "transit_door/oak_door");
        registerTransitDoor(TDBlocks.SPRUCE_TRANSIT_DOOR, "transit_door/spruce_door");
        registerTransitDoor(TDBlocks.BIRCH_TRANSIT_DOOR, "transit_door/birch_door");
        registerTransitDoor(TDBlocks.JUNGLE_TRANSIT_DOOR, "transit_door/jungle_door");
        registerTransitDoor(TDBlocks.ACACIA_TRANSIT_DOOR, "transit_door/acacia_door");
        registerTransitDoor(TDBlocks.DARK_OAK_TRANSIT_DOOR, "transit_door/dark_oak_door");
        registerTransitDoor(TDBlocks.MANGROVE_TRANSIT_DOOR, "transit_door/mangrove_door");
        registerTransitDoor(TDBlocks.CHERRY_TRANSIT_DOOR, "transit_door/cherry_door");
        registerTransitDoor(TDBlocks.BAMBOO_TRANSIT_DOOR, "transit_door/bamboo_door");
        registerTransitDoor(TDBlocks.CRIMSON_TRANSIT_DOOR, "transit_door/crimson_door");
        registerTransitDoor(TDBlocks.WARPED_TRANSIT_DOOR, "transit_door/warped_door");
    }

    private void registerDoor(Supplier<Block> blockSupplier, String texturePath) {
        doorBlockWithRenderType(
                (DoorBlock) blockSupplier.get(),
                resourceBlock(texturePath + "_bottom"),
                resourceBlock(texturePath + "_top"),
                "cutout"
        );
    }

    private void registerTransitDoor(Supplier<Block> blockSupplier, String texturePath) {
        doorBlockWithRenderType(
                (DoorBlock) blockSupplier.get(),
                resourceBlock(texturePath + "_bottom"),
                resourceBlock(texturePath + "_top"),
                vanillaDoorTexture(texturePath + "_bottom"),
                vanillaDoorTexture(texturePath + "_top"),
                "cutout"
        );
    }

    private ResourceLocation vanillaDoorTexture(String texturePath) {
        String[] parts = texturePath.split("/");
        String woodType = parts[parts.length - 1].replace("_door_bottom", "").replace("_door_top", "").replace("_door", "");

        if (texturePath.endsWith("_bottom")) {
            return ResourceLocation.fromNamespaceAndPath("minecraft", "block/" + woodType + "_door_bottom");
        } else {
            return ResourceLocation.fromNamespaceAndPath("minecraft", "block/" + woodType + "_door_top");
        }
    }

    public static ResourceLocation resourceBlock(String name) {
        return ResourceLocation.fromNamespaceAndPath(TuttasDoors.MODID, ModelProvider.BLOCK_FOLDER + "/" + name);
    }

    public void doorBlockWithRenderType(DoorBlock block, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop, String renderType) {
        this.doorBlockInternalWithRenderType(block, this.key(block).toString(), bottom, top, extraBottom, extraTop, ResourceLocation.tryParse(renderType));
    }

    private void doorBlockInternalWithRenderType(DoorBlock block, String baseName, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop, ResourceLocation renderType) {
        ModelFile bottomLeft = this.transitDoorBottomLeft(baseName + "_bottom_left", bottom, top, extraBottom, extraTop).renderType(renderType);
        ModelFile bottomLeftOpen = this.transitDoorBottomLeftOpen(baseName + "_bottom_left_open", bottom, top, extraBottom, extraTop).renderType(renderType);
        ModelFile bottomRight = this.transitDoorBottomRight(baseName + "_bottom_right", bottom, top, extraBottom, extraTop).renderType(renderType);
        ModelFile bottomRightOpen = this.transitDoorBottomRightOpen(baseName + "_bottom_right_open", bottom, top, extraBottom, extraTop).renderType(renderType);
        ModelFile topLeft = this.transitDoorTopLeft(baseName + "_top_left", bottom, top, extraBottom, extraTop).renderType(renderType);
        ModelFile topLeftOpen = this.transitDoorTopLeftOpen(baseName + "_top_left_open", bottom, top, extraBottom, extraTop).renderType(renderType);
        ModelFile topRight = this.transitDoorTopRight(baseName + "_top_right", bottom, top, extraBottom, extraTop).renderType(renderType);
        ModelFile topRightOpen = this.transitDoorTopRightOpen(baseName + "_top_right_open", bottom, top, extraBottom, extraTop).renderType(renderType);

        this.doorBlock(block, bottomLeft, bottomLeftOpen, bottomRight, bottomRightOpen, topLeft, topLeftOpen, topRight, topRightOpen);
    }

    public BlockModelBuilder transitDoorBottomLeft(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.door(name, "transit_door_bottom_left", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorBottomLeftOpen(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.door(name, "transit_door_bottom_left_open", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorBottomRight(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.door(name, "transit_door_bottom_right", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorBottomRightOpen(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.door(name, "transit_door_bottom_right_open", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorTopLeft(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.door(name, "transit_door_top_left", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorTopLeftOpen(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.door(name, "transit_door_top_left_open", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorTopRight(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.door(name, "transit_door_top_right", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorTopRightOpen(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.door(name, "transit_door_top_right_open", bottom, top, extraBottom, extraTop);
    }

    private BlockModelBuilder door(String name, String model, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        boolean isTop = name.contains("top");

        return this.models().withExistingParent(name, ResourceLocation.fromNamespaceAndPath(TuttasDoors.MODID, "block/" + model))
                .texture("door", isTop ? top : bottom)
                .texture("extra", isTop ? extraTop : extraBottom);
    }
    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}