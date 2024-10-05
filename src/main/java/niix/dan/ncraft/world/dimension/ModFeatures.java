package niix.dan.ncraft.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import niix.dan.ncraft.NCraft;

public class ModFeatures {
    public static RegistryKey<ConfiguredFeature<?, ?>> GRASS_CONFIGURED_FEATURE =  RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(NCraft.MOD_ID, "void_grass_feature"));
    public static RegistryKey<PlacedFeature> GRASS_PLACED_FEATURE =  RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(NCraft.MOD_ID, "void_grass_feature"));

    public static void register() {
        NCraft.LOGGER.debug("Registering ModFeatures for "+NCraft.MOD_ID);
    }
}
