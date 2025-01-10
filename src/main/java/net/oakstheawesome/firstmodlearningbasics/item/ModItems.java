package net.oakstheawesome.firstmodlearningbasics.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;


public class ModItems{
    public ModItems() {;
    }

    //Add items in similar fashion here
    public static final Item SUSPICIOUS_SUBSTANCE = register("suspicious_substance", Item::new, new Item.Settings()
            .maxCount(16)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)));
    public static final Item PEAR = register("pear", Item::new, new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(1)
            .build()));


    //Register Items as fuel source, referred to in ModInitializer in FirstModLearningBasics.java
    public static void registerFuels() {
        FuelRegistryEvents.BUILD.register(((builder, context) -> {
            builder.add(SUSPICIOUS_SUBSTANCE, 300);
        }));
    }

    //Register Items as Compostable, referred to in ModInitializer in FirstModLearningBasics.java
    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(ModItems.SUSPICIOUS_SUBSTANCE, 0.3f);
    }


    //This is the registration sequence for items
    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("firstmodlearningbasics", path));
        return Items.register(registryKey, factory, settings);
    }


    //Initialize items and add to a Creative Tab in FirstModLearningBasics.java
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((fabricItemGroupEntries ->
                        fabricItemGroupEntries.add(ModItems.SUSPICIOUS_SUBSTANCE)));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register(fabricItemGroupEntries ->
                        fabricItemGroupEntries.add(ModItems.PEAR));

    }
}

