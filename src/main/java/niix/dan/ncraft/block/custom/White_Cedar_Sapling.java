package niix.dan.ncraft.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import niix.dan.ncraft.block.ModBlocks;

public class White_Cedar_Sapling extends SaplingBlock {
    public White_Cedar_Sapling(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.OBLIVION_VOID);
    }
}
