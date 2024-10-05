package niix.dan.ncraft.particle;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import niix.dan.ncraft.NCraft;

public class ModParticles {
    public static final DefaultParticleType SPURS = FabricParticleTypes.simple();

    public static void registerServerParticles() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(NCraft.MOD_ID, "spurs"), SPURS);
    }

    public static void registerClientParticles() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier(NCraft.MOD_ID, "particle/spurs_particle"));
        }));
        ParticleFactoryRegistry.getInstance().register(SPURS, FlameParticle.Factory::new);
    }

}
