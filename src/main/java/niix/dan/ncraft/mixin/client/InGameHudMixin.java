package niix.dan.ncraft.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;

import niix.dan.ncraft.networking.packet.SanityS2CPacket;
import niix.dan.ncraft.util.IEntityDataSaver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin extends DrawableHelper {

    private static final int BAR_WIDTH = 100;
    private static final int BAR_HEIGHT = 10;

    @Inject(method = "render", at = @At("HEAD"))
    public void renderSanityBar(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;

        if (player != null) {

            float sanity = ((IEntityDataSaver) player).getPersistentData().getFloat("sanity");

            if(sanity >= 100) return;

            int scaledWidth = client.getWindow().getScaledWidth();
            int scaledHeight = client.getWindow().getScaledHeight();

            // Configurações de posicionamento no canto superior esquerdo
            int barX = 25; // Distância do lado esquerdo
            int barY = 25; // Distância do topo

            // Fundo da barra de sanidade
            RenderSystem.disableBlend();
            fill(matrices, barX, barY, barX + BAR_WIDTH, barY + BAR_HEIGHT, 0xFF000000);

            // Barra de sanidade preenchida
            int filledWidth = (Math.round(sanity) * BAR_WIDTH) / 100;
            fill(matrices, barX, barY, barX + filledWidth, barY + BAR_HEIGHT, 0xFF00FF00); // Verde para a barra

            // Texto "Sanity: X%" em vermelho
            String sanityText = "Sanity: " + Math.round(sanity) + "%";
            int textX = barX; // Alinhado ao lado esquerdo da barra
            int textY = barY - 15; // Posicionado acima da barra
            client.textRenderer.draw(matrices, sanityText, textX, textY, 0xFFFF0000); // Texto em vermelho
        }
    }
}

