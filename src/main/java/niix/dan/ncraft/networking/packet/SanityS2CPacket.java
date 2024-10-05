package niix.dan.ncraft.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import niix.dan.ncraft.util.IEntityDataSaver;

public class SanityS2CPacket {


    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {

        // Tudo aqui acontece apenas no client;
        if(client.player != null) ((IEntityDataSaver) client.player).getPersistentData().putFloat("sanity", buf.readFloat());
        //float sanity = buf.readFloat();


    }

}
