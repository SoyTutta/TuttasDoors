package com.tuttasdoors.core.data;

import com.tuttasdoors.TuttasDoors;
import com.tuttasdoors.blocks.PetDoorBlock;
import com.tuttasdoors.blocks.SlidingDoorBlock;
import com.tuttasdoors.registry.TDBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Half;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class TDBlockStates extends BlockStateProvider {
    public TDBlockStates(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TuttasDoors.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerDoor(TDBlocks.OAK_DISCRETE_DOOR,   "discrete_door/oak_door");
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

        registerPetDoor(TDBlocks.OAK_PET_DOOR, "pet_door/oak_door");
        registerPetDoor(TDBlocks.SPRUCE_PET_DOOR, "pet_door/spruce_door");
        registerPetDoor(TDBlocks.BIRCH_PET_DOOR, "pet_door/birch_door");
        registerPetDoor(TDBlocks.JUNGLE_PET_DOOR, "pet_door/jungle_door");
        registerPetDoor(TDBlocks.ACACIA_PET_DOOR, "pet_door/acacia_door");
        registerPetDoor(TDBlocks.DARK_OAK_PET_DOOR, "pet_door/dark_oak_door");
        registerPetDoor(TDBlocks.MANGROVE_PET_DOOR, "pet_door/mangrove_door");
        registerPetDoor(TDBlocks.CHERRY_PET_DOOR, "pet_door/cherry_door");
        registerPetDoor(TDBlocks.BAMBOO_PET_DOOR, "pet_door/bamboo_door");
        registerPetDoor(TDBlocks.CRIMSON_PET_DOOR, "pet_door/crimson_door");
        registerPetDoor(TDBlocks.WARPED_PET_DOOR, "pet_door/warped_door");

        registerSlidingDoor(TDBlocks.IRON_BARS_SLIDING_DOOR, "sliding_door/iron_bars_door");
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
        return this.transitDoor(name, "transit_door_bottom_left", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorBottomLeftOpen(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.transitDoor(name, "transit_door_bottom_left_open", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorBottomRight(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.transitDoor(name, "transit_door_bottom_right", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorBottomRightOpen(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.transitDoor(name, "transit_door_bottom_right_open", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorTopLeft(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.transitDoor(name, "transit_door_top_left", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorTopLeftOpen(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.transitDoor(name, "transit_door_top_left_open", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorTopRight(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.transitDoor(name, "transit_door_top_right", bottom, top, extraBottom, extraTop);
    }

    public BlockModelBuilder transitDoorTopRightOpen(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        return this.transitDoor(name, "transit_door_top_right_open", bottom, top, extraBottom, extraTop);
    }

    private BlockModelBuilder transitDoor(String name, String model, ResourceLocation bottom, ResourceLocation top, ResourceLocation extraBottom, ResourceLocation extraTop) {
        boolean isTop = name.contains("top");

        return this.models().withExistingParent(name, ResourceLocation.fromNamespaceAndPath(TuttasDoors.MODID, "block/" + model))
                .texture("door", isTop ? top : bottom)
                .texture("extra", isTop ? extraTop : extraBottom);
    }

    private void registerSlidingDoor(Supplier<Block> blockSupplier, String texturePath) {
        slidingDoorBlockWithRenderType(
                (DoorBlock) blockSupplier.get(),
                resourceBlock(texturePath + "_bottom"),
                resourceBlock(texturePath + "_top"),
                "cutout"
        );
    }
    public void slidingDoorBlockWithRenderType(DoorBlock block, ResourceLocation bottom, ResourceLocation top, String renderType) {
        this.slidingDoorBlockInternalWithRenderType(block, this.key(block).toString(), bottom, top, ResourceLocation.tryParse(renderType));
    }

    private void slidingDoorBlockInternalWithRenderType(DoorBlock block, String baseName, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType) {
        ModelFile bottomLeft         = this.slidingDoorBottomLeft(baseName + "_bottom_left",               bottom, top).renderType(renderType);
        ModelFile bottomLeftOpen     = this.slidingDoorBottomLeftOpen(baseName + "_bottom_left_open",      bottom, top).renderType(renderType);
        ModelFile bottomLeftTrueOpen = this.slidingDoorBottomLeftTrueOpen(baseName + "_bottom_left_true_open", bottom, top).renderType(renderType);

        ModelFile bottomRight         = this.slidingDoorBottomRight(baseName + "_bottom_right",               bottom, top).renderType(renderType);
        ModelFile bottomRightOpen     = this.slidingDoorBottomRightOpen(baseName + "_bottom_right_open",      bottom, top).renderType(renderType);
        ModelFile bottomRightTrueOpen = this.slidingDoorBottomRightTrueOpen(baseName + "_bottom_right_true_open", bottom, top).renderType(renderType);

        ModelFile topLeft         = this.slidingDoorTopLeft(baseName + "_top_left",               bottom, top).renderType(renderType);
        ModelFile topLeftOpen     = this.slidingDoorTopLeftOpen(baseName + "_top_left_open",      bottom, top).renderType(renderType);
        ModelFile topLeftTrueOpen = this.slidingDoorTopLeftTrueOpen(baseName + "_top_left_true_open", bottom, top).renderType(renderType);

        ModelFile topRight         = this.slidingDoorTopRight(baseName + "_top_right",               bottom, top).renderType(renderType);
        ModelFile topRightOpen     = this.slidingDoorTopRightOpen(baseName + "_top_right_open",      bottom, top).renderType(renderType);
        ModelFile topRightTrueOpen = this.slidingDoorTopRightTrueOpen(baseName + "_top_right_true_open", bottom, top).renderType(renderType);

        this.slidingDoorBlock(block, bottomLeft, bottomLeftOpen, bottomLeftTrueOpen, bottomRight, bottomRightOpen, bottomRightTrueOpen, topLeft, topLeftOpen, topLeftTrueOpen, topRight, topRightOpen, topRightTrueOpen);
    }

    public BlockModelBuilder slidingDoorBottomLeft(String name, ResourceLocation bottom, ResourceLocation top) {
        return this.door(name, "sliding_door_bottom_left", bottom, top);
    }

    public BlockModelBuilder slidingDoorBottomLeftOpen(String name, ResourceLocation bottom, ResourceLocation top) {
        return this.door(name, "sliding_door_bottom_left_open", bottom, top);
    }

    public BlockModelBuilder slidingDoorBottomLeftTrueOpen(String name, ResourceLocation bottom, ResourceLocation top) {
        return this.door(name, "sliding_door_bottom_left_true_open", bottom, top);
    }

    public BlockModelBuilder slidingDoorBottomRight(String name, ResourceLocation bottom, ResourceLocation top) {
        return this.door(name, "sliding_door_bottom_right", bottom, top);
    }

    public BlockModelBuilder slidingDoorBottomRightOpen(String name, ResourceLocation bottom, ResourceLocation top) {
        return this.door(name, "sliding_door_bottom_right_open", bottom, top);
    }

    public BlockModelBuilder slidingDoorBottomRightTrueOpen(String name, ResourceLocation bottom, ResourceLocation top) {
        return this.door(name, "sliding_door_bottom_right_true_open", bottom, top);
    }

    public BlockModelBuilder slidingDoorTopLeft(String name, ResourceLocation bottom, ResourceLocation top) {
        return this.door(name, "sliding_door_top_left", bottom, top);
    }

    public BlockModelBuilder slidingDoorTopLeftOpen(String name, ResourceLocation bottom, ResourceLocation top) {
        return this.door(name, "sliding_door_top_left_open", bottom, top);
    }

    public BlockModelBuilder slidingDoorTopLeftTrueOpen(String name, ResourceLocation bottom, ResourceLocation top) {
        return this.door(name, "sliding_door_top_left_true_open", bottom, top);
    }

    public BlockModelBuilder slidingDoorTopRight(String name, ResourceLocation bottom, ResourceLocation top) {
        return this.door(name, "sliding_door_top_right", bottom, top);
    }

    public BlockModelBuilder slidingDoorTopRightOpen(String name, ResourceLocation bottom, ResourceLocation top) {
        return this.door(name, "sliding_door_top_right_open", bottom, top);
    }

    public BlockModelBuilder slidingDoorTopRightTrueOpen(String name, ResourceLocation bottom, ResourceLocation top) {
        return this.door(name, "sliding_door_top_right_true_open", bottom, top);
    }

    private BlockModelBuilder door(String name, String model, ResourceLocation bottom, ResourceLocation top) {
        boolean isTop = name.contains("top");
        return this.models().withExistingParent(name, ResourceLocation.fromNamespaceAndPath(TuttasDoors.MODID, "block/" + model))
                .texture("door", isTop ? top : bottom);
    }

    protected void slidingDoorBlock(DoorBlock block, ModelFile bottomLeftClosed, ModelFile bottomLeftOpen, ModelFile bottomLeftTrueOpen, ModelFile bottomRightClosed, ModelFile bottomRightOpen, ModelFile bottomRightTrueOpen, ModelFile topLeftClosed, ModelFile topLeftOpen, ModelFile topLeftTrueOpen, ModelFile topRightClosed, ModelFile topRightOpen, ModelFile topRightTrueOpen) {
        this.getVariantBuilder(block).forAllStates(state -> {
            Direction       facing   = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
            boolean         open     = state.getValue(BlockStateProperties.OPEN);
            boolean         inWall   = state.getValue(SlidingDoorBlock.IN_WALL);
            DoubleBlockHalf half     = state.getValue(DoorBlock.HALF);
            DoorHingeSide   hinge    = state.getValue(BlockStateProperties.DOOR_HINGE);
            int             yRot     = (int) facing.toYRot();

            ModelFile selectedModel = half == DoubleBlockHalf.LOWER
                    ? hinge == DoorHingeSide.LEFT
                    ? open
                    ? (inWall ? bottomLeftOpen  : bottomLeftTrueOpen)
                    : bottomLeftClosed
                    : open
                    ? (inWall ? bottomRightOpen : bottomRightTrueOpen)
                    : bottomRightClosed
                    : hinge == DoorHingeSide.LEFT
                    ? open
                    ? (inWall ? topLeftOpen     : topLeftTrueOpen)
                    : topLeftClosed
                    : open
                    ? (inWall ? topRightOpen    : topRightTrueOpen)
                    : topRightClosed;

            return ConfiguredModel.builder()
                    .modelFile(selectedModel)
                    .rotationY(yRot)
                    .uvLock(true)
                    .build();
        });
    }

    private void registerPetDoor(Supplier<Block> blockSupplier, String texturePath) {
        petDoorBlockWithRenderType(
                (PetDoorBlock) blockSupplier.get(),
                resourceBlock(texturePath),
                vanillaDoorTexture(texturePath),
                "cutout"
        );
    }

    private void petDoorBlockWithRenderType(PetDoorBlock block, ResourceLocation customTexture, ResourceLocation vanillaTexture, String renderType) {
        this.petDoorBlockInternalWithRenderType(block, this.key(block).toString(), customTexture, vanillaTexture, ResourceLocation.tryParse(renderType));
    }

    private void petDoorBlockInternalWithRenderType(PetDoorBlock block, String baseName, ResourceLocation customTexture, ResourceLocation vanillaTexture, ResourceLocation renderType) {
        ModelFile bottom = this.petDoorBottom(baseName + "_bottom", customTexture, vanillaTexture).renderType(renderType);
        ModelFile bottomOpen = this.petDoorBottomOpen(baseName + "_bottom_open", customTexture, vanillaTexture).renderType(renderType);
        ModelFile top = this.petDoorTop(baseName + "_top", customTexture, vanillaTexture).renderType(renderType);
        ModelFile topOpen = this.petDoorTopOpen(baseName + "_top_open", customTexture, vanillaTexture).renderType(renderType);

        this.petDoorBlock(block, bottom, bottomOpen, top, topOpen);
    }

    public BlockModelBuilder petDoorBottom(String name, ResourceLocation customTexture, ResourceLocation vanillaTexture) {
        return this.models().withExistingParent(name, "tuttasdoors:block/pet_door_bottom")
                .texture("door", customTexture)
                .texture("extra", vanillaTexture);
    }

    public BlockModelBuilder petDoorBottomOpen(String name, ResourceLocation customTexture, ResourceLocation vanillaTexture) {
        return this.models().withExistingParent(name, "tuttasdoors:block/pet_door_bottom_open")
                .texture("door", customTexture)
                .texture("extra", vanillaTexture);
    }

    public BlockModelBuilder petDoorTop(String name, ResourceLocation customTexture, ResourceLocation vanillaTexture) {
        return this.models().withExistingParent(name, "tuttasdoors:block/pet_door_top")
                .texture("door", customTexture)
                .texture("extra", vanillaTexture);
    }

    public BlockModelBuilder petDoorTopOpen(String name, ResourceLocation customTexture, ResourceLocation vanillaTexture) {
        return this.models().withExistingParent(name, "tuttasdoors:block/pet_door_top_open")
                .texture("door", customTexture)
                .texture("extra", vanillaTexture);
    }

    public void petDoorBlock(PetDoorBlock block, ModelFile bottom, ModelFile bottomOpen, ModelFile top, ModelFile topOpen) {
        this.getVariantBuilder(block).forAllStatesExcept(state -> {
            Direction facing = state.getValue(PetDoorBlock.FACING);
            boolean isOpen = state.getValue(PetDoorBlock.OPEN);
            Half half = state.getValue(PetDoorBlock.HALF);

            int yRot = (int) facing.toYRot();

            ModelFile selectedModel;

            if (half == Half.BOTTOM) {
                if (isOpen) {
                    selectedModel = bottomOpen;
                } else {
                    selectedModel = bottom;
                }
            } else {
                if (isOpen) {
                    selectedModel = topOpen;
                } else {
                    selectedModel = top;
                }
            }

            return ConfiguredModel.builder()
                    .modelFile(selectedModel)
                    .rotationY(yRot)
                    .build();
        }, TrapDoorBlock.POWERED, TrapDoorBlock.WATERLOGGED);
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}