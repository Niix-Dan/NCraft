package niix.dan.ncraft.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import niix.dan.ncraft.block.ModBlocks;

public class Void_Grass extends PlantBlock {
    public Void_Grass(FabricBlockSettings settings) {
        super(settings
                .breakInstantly()
                .noCollision()
                .nonOpaque()
                .luminance(5)
                .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
        );
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.OBLIVION_VOID);
    }
}
