package com.fabiomusi04.fadingtorch.registry;

import com.fabiomusi04.fadingtorch.FadingTorch;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FadingTorch.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
