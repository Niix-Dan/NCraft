package niix.dan.ncraft.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import niix.dan.ncraft.util.IEntityDataSaver;
import niix.dan.ncraft.util.SanityData;
import niix.dan.ncraft.world.dimension.ModDimensions;

public class PlayerTickHandler implements ServerTickEvents.StartTick {
    private double tickCount = -1;


    @Override
    public void onStartTick(MinecraftServer server) {

        tickCount++;
        if(tickCount % 20 == 0) {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                IEntityDataSaver dataPlayer = ((IEntityDataSaver) player);

                float sanity = dataPlayer.getPersistentData().getFloat("sanity");

                if(ModDimensions.isOblivionDimension(player.getWorld())) {
                    SanityData.removeSanity(dataPlayer, 0.1667f);
                } else {
                    SanityData.addSanity(dataPlayer, 0.5f);
                }
            }
        }
    }
}
