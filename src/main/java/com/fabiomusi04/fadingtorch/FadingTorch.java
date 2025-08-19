package com.fabiomusi04.fadingtorch;

import com.fabiomusi04.fadingtorch.registry.ModBlocks;

import com.fabiomusi04.fadingtorch.registry.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(FadingTorch.MODID)
public class FadingTorch {
    public static final String MODID = "fadingtorch";

    public FadingTorch(IEventBus modEventBus) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.FADING_TORCH);
        }
    }
}
