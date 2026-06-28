package net.teamsolar.simplest_excavators.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.teamsolar.simplest_excavators.SimplestExcavators;
import net.teamsolar.simplest_excavators.item.ModItems;
import net.teamsolar.simplest_excavators.loot.ModLootModifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Pattern;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture, SimplestExcavators.MODID);
    }

    @Override
    protected void start() {

        for(String location: List.of("toolsmith", "armorer", "weaponsmith")) {
            add(
                    "excavator_smithing_template_in".concat(location).concat("_chests"),
                    toExistingLootPoolWithChance(
                            "chests/village/village_".concat(location),
                            0.80f,
                            ModItems.EXCAVATOR_SMITHING_TEMPLATE.get()
                    )
            );
        }

        // Add a 15% chance to find an Excavator Upgrade Smithing Template
        // in any village house chest (including houses, but not including butcher, temple, fletchery, etc)
        var myLootTables = BuiltInLootTables
                .all()
                .stream().filter((table ) -> {
                    var key = table.identifier().getPath();
                    return key.startsWith("chests/village") && key.matches("chests/village/(.+_house)");
                })
                .sorted()
                .toList();

        for(ResourceKey<LootTable> table: myLootTables) {
            var key = table.identifier().getPath();
            add(
                "excavator_smithing_template_in_".concat(matchHouseType(key)),
                toExistingLootPoolWithChance(
                        table.identifier(),
                        0.20f,
                        ModItems.EXCAVATOR_SMITHING_TEMPLATE.get()
                )
            );
        }
    }

    private String matchHouseType(String key) {
        Pattern nameMatcher = Pattern.compile("chests/village/(.+_house)");
        var results = nameMatcher.matcher(key);
        if(!results.find()) {
            throw new RuntimeException("No village chests matching %s".formatted(key));
        }
        return results.group(1);
        // SimplestExcavators.getLogger().info("%d".formatted(results.groupCount()));
        // SimplestExcavators.getLogger().info("%s".formatted(results.matches()));
    }

    private ModLootModifier toExistingLootPoolWithChance(Identifier location, float chance, Item item) {
        return new ModLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(location)
                                .and(
                                        LootItemRandomChanceCondition.randomChance(chance)
                                ).build()
                },
                1000,
                item
        );
    }
    private ModLootModifier toExistingLootPoolWithChance(String location, float chance, Item item) {
        return toExistingLootPoolWithChance(Identifier.withDefaultNamespace(location), chance, item);
    }
}
