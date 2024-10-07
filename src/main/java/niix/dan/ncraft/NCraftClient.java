package niix.dan.ncraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import niix.dan.ncraft.block.ModBlocks;
import niix.dan.ncraft.networking.ModMessages;
import niix.dan.ncraft.particle.ModParticles;

public class NCraftClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        ModMessages.registerS2CPackets();
        ModParticles.registerClientParticles();

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OBLIVION_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_CEDAR_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_CEDAR_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_CEDAR_DOOR, RenderLayer.getCutout());
    }
}
