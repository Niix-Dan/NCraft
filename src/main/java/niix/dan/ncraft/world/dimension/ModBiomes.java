package niix.dan.ncraft.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import niix.dan.ncraft.NCraft;

public class ModBiomes {
    public static final RegistryKey<Biome> OBLIVION_DEPTHS_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(NCraft.MOD_ID, "oblivion_depths"));

    public static void register() {
        // Registra o bioma oblivion_depths
        NCraft.LOGGER.debug("Registering ModBiomes for " + NCraft.MOD_ID);
    }


}
