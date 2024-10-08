package niix.dan.ncraft.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;

public class Void_Soil extends Block {
    public Void_Soil(FabricBlockSettings settings) {
        super(settings
                .strength(1.0f)
                .sounds(BlockSoundGroup.SCULK)
        );
    }
}
