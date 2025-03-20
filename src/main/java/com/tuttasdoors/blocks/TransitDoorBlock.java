package com.tuttasdoors.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TransitDoorBlock extends DoorBlock {

    protected static final VoxelShape SOUTH_AABB = Block.box(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 3.0F);
    protected static final VoxelShape NORTH_AABB = Block.box(0.0F, 0.0F, 13.0F, 16.0F, 16.0F, 16.0F);
    protected static final VoxelShape WEST_AABB = Block.box(13.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F);
    protected static final VoxelShape EAST_AABB = Block.box(0.0F, 0.0F, 0.0F, 3.0F, 16.0F, 16.0F);

    protected static final VoxelShape SOUTH_ENTITY_AABB = Block.box(0.0F, 0.0F, 0.1F, 16.0F, 16.0F, 3.0F);
    protected static final VoxelShape NORTH_ENTITY_AABB = Block.box(0.0F, 0.0F, 13.0F, 16.0F, 16.0F, 15.0F);
    protected static final VoxelShape WEST_ENTITY_AABB = Block.box(13.0F, 0.0F, 0.0F, 15.0F, 16.0F, 16.0F);
    protected static final VoxelShape EAST_ENTITY_AABB = Block.box(0.1F, 0.0F, 0.0F, 3.0F, 16.0F, 16.0F);

    public TransitDoorBlock(BlockSetType type, Properties properties) {
        super(type, properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        boolean flag = !(Boolean)state.getValue(OPEN);
        boolean flag1 = state.getValue(HINGE) == DoorHingeSide.RIGHT;
        VoxelShape var10000;
        switch (direction) {
            case SOUTH -> var10000 = flag ? SOUTH_AABB : (flag1 ? EAST_AABB : WEST_AABB);
            case WEST -> var10000 = flag ? WEST_AABB : (flag1 ? SOUTH_AABB : NORTH_AABB);
            case NORTH -> var10000 = flag ? NORTH_AABB : (flag1 ? WEST_AABB : EAST_AABB);
            default -> var10000 = flag ? EAST_AABB : (flag1 ? NORTH_AABB : SOUTH_AABB);
        }

        return var10000;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        boolean flag = !(Boolean)state.getValue(OPEN);
        boolean flag1 = state.getValue(HINGE) == DoorHingeSide.RIGHT;
        VoxelShape entityShape;
        switch (direction) {
            case SOUTH -> entityShape = flag ? SOUTH_ENTITY_AABB : (flag1 ? EAST_ENTITY_AABB : WEST_ENTITY_AABB);
            case WEST -> entityShape = flag ? WEST_ENTITY_AABB : (flag1 ? SOUTH_ENTITY_AABB : NORTH_ENTITY_AABB);
            case NORTH -> entityShape = flag ? NORTH_ENTITY_AABB : (flag1 ? WEST_ENTITY_AABB : EAST_ENTITY_AABB);
            default -> entityShape = flag ? EAST_ENTITY_AABB : (flag1 ? NORTH_ENTITY_AABB : SOUTH_ENTITY_AABB);
        }

        return entityShape;
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);

        if (!level.isClientSide) {
            if (level instanceof ServerLevel serverLevel) {Direction direction = state.getValue(FACING);
                Vec3 entityPos = entity.position();
                boolean shouldOpen = false;

                switch (direction) {
                    case NORTH -> shouldOpen = entityPos.z > pos.getZ() + 0.5;
                    case SOUTH -> shouldOpen = entityPos.z < pos.getZ() + 0.5;
                    case WEST -> shouldOpen = entityPos.x > pos.getX() + 0.5;
                    case EAST -> shouldOpen = entityPos.x < pos.getX() + 0.5;
                }

                if (!state.getValue(OPEN) && shouldOpen  && !entity.isCrouching()) {
                    this.setOpen(null, level, state, pos, true);
                }

                serverLevel.scheduleTick(pos, this, 20);
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.getEntitiesOfClass(Entity.class, getBoundingBox(pos)).isEmpty()) {
            level.scheduleTick(pos, this, 20);
            return;
        }
        this.setOpen(null, level, state, pos, false);
    }

    private static AABB getBoundingBox(BlockPos pos) {
        double offset = 0.05;
        return new AABB(
                pos.getX() - offset,
                pos.getY() - offset,
                pos.getZ() - offset,
                pos.getX() + 1 + offset,
                pos.getY() + 1 + offset,
                pos.getZ() + 1 + offset
        );
    }
}