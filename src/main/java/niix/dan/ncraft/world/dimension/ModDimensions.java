package niix.dan.ncraft.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import niix.dan.ncraft.NCraft;

public class ModDimensions {

    public static final RegistryKey<World> OBLIVION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(NCraft.MOD_ID, "oblivion"));
    public static final RegistryKey<DimensionType> OBLIVION_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, OBLIVION_KEY.getValue());


    public static void register() {
        NCraft.LOGGER.debug("Registering ModDimensions for "+NCraft.MOD_ID);
    }



    public static boolean isOblivionDimension(World world) {
        return world != null && world.getRegistryKey().equals(OBLIVION_KEY);
    }

}
