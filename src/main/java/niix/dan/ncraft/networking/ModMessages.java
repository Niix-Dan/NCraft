package niix.dan.ncraft.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;
import niix.dan.ncraft.NCraft;
import niix.dan.ncraft.networking.packet.SanityS2CPacket;

public class ModMessages {

    public static final Identifier SANITY_ID = new Identifier(NCraft.MOD_ID, "sanity");


    public static void registerC2SPackets() {

    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(SANITY_ID, SanityS2CPacket::receive);
    }

}
