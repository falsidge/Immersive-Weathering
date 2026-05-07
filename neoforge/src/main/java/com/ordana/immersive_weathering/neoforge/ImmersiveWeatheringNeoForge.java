package com.ordana.immersive_weathering.neoforge;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableBiMap;
import com.ordana.immersive_weathering.ImmersiveWeathering;
import com.ordana.immersive_weathering.reg.ModBlocks;
import com.ordana.immersive_weathering.reg.ModWaxables;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(ImmersiveWeathering.MOD_ID)
public final class ImmersiveWeatheringNeoForge {
    public ImmersiveWeatheringNeoForge() {
        // Run our common setup.
        ImmersiveWeathering.commonInit();
    }

    @SubscribeEvent
    public void registerOverrides(RegisterEvent event) {
        //override
            event.register(Registries.ITEM, registry -> {
                registry.register(ResourceLocation.withDefaultNamespace("hanging_roots"),
                        new CeilingAndWallBlockItem(Blocks.HANGING_ROOTS, ModBlocks.HANGING_ROOTS_WALL.get(),
                                new Item.Properties()));
            });


    }

//
    @SubscribeEvent(priority = EventPriority.LOW)
    public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        var ret = com.ordana.immersive_weathering.events.ModEvents.onBlockCLicked(event.getItemStack(),
                event.getEntity(), event.getLevel(), event.getHand(), event.getHitVec());
        if (ret != InteractionResult.PASS) {
            event.setCanceled(true);
            event.setCancellationResult(ret);
        }
    }

//
//    //TODO: add back on setup
//    private static void registerWaxables() {
//        try {
//            var oldWaxables = HoneycombItem.WAXABLES.get();
//            HoneycombItem.WAXABLES = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder()
//                    .putAll(oldWaxables)
//                    .putAll(ModWaxables.getValues()).build());
//
//            HoneycombItem.WAX_OFF_BY_BLOCK = Suppliers.memoize(() -> (HoneycombItem.WAXABLES.get()).inverse());
//
//        } catch (Exception e) {
//            ImmersiveWeathering.LOGGER.error("Failed to register Waxables: ", e);
//        }
//
//    }

}
