package niix.dan.ncraft.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import niix.dan.ncraft.networking.ModMessages;

public class SanityData {
    public static float addSanity(IEntityDataSaver player, float amount) {

        NbtCompound nbt = player.getPersistentData();
        float sanity = nbt.getFloat("sanity");

        sanity = Math.min(100, sanity + amount);

        nbt.putFloat("sanity", sanity);

        syncSanity(sanity, (ServerPlayerEntity) player);
        return sanity;
    }

    public static float removeSanity(IEntityDataSaver player, float amount) {

        NbtCompound nbt = player.getPersistentData();
        float sanity = nbt.getFloat("sanity");

        sanity = Math.max(0, sanity - amount);

        nbt.putFloat("sanity", sanity);

        syncSanity(sanity, (ServerPlayerEntity) player);
        return sanity;
    }

    public static void syncSanity(float sanity, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeFloat(sanity);

        ServerPlayNetworking.send(player, ModMessages.SANITY_ID, buffer);
    }

}
