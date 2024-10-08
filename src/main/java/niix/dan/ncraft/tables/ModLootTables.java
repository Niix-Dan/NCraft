package niix.dan.ncraft.tables;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import niix.dan.ncraft.item.ModItems;

public class ModLootTables {
    private static final Identifier RUINED_PORTAL_LOOT_TABLE_ID = new Identifier("minecraft", "chests/ruined_portal");


    public static void register() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            if (source.isBuiltin() && id.equals(RUINED_PORTAL_LOOT_TABLE_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 3))
                        .with(ItemEntry.builder(ModItems.SANITY_FRAGMENT).weight(40));

                tableBuilder.pool(poolBuilder.build());
            }

        });
    }
}
