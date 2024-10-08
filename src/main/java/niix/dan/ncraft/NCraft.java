package niix.dan.ncraft;


import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import niix.dan.ncraft.block.ModBlocks;
import niix.dan.ncraft.event.PlayerTickHandler;
import niix.dan.ncraft.item.ModItems;
import niix.dan.ncraft.networking.ModMessages;
import niix.dan.ncraft.particle.ModParticles;
import niix.dan.ncraft.tables.ModLootTables;
import niix.dan.ncraft.util.ModFlammableBlocks;
import niix.dan.ncraft.util.ModFuels;
import niix.dan.ncraft.util.ModStrippableBlocks;
import niix.dan.ncraft.world.dimension.ModBiomes;
import niix.dan.ncraft.world.dimension.ModDimensions;
import niix.dan.ncraft.world.dimension.ModFeatures;
import niix.dan.ncraft.world.dimension.ModStructures;
import niix.dan.ncraft.world.feature.ModConfiguredFeatures;
import niix.dan.ncraft.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NCraft implements ModInitializer {
    public static final String MOD_ID = "ncraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModConfiguredFeatures.register(); // Precisa ficar no topo;

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModMessages.registerC2SPackets();
        ModParticles.registerServerParticles();

        ModDimensions.register();
        ModBiomes.register();
        ModFeatures.register();
        ModStructures.register();
        ModWorldGen.generateWorldGen();

        ModStrippableBlocks.register();
        ModFlammableBlocks.register();
        ModFuels.register();

        ModLootTables.register();

        ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
    }
}
