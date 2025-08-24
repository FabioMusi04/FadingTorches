package com.fabiomusi04.fadingtorch.registry;

import com.fabiomusi04.fadingtorch.FadingTorch;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FadingTorch.MODID);

    public static final DeferredBlock<TorchBlock> FADING_TORCH = registerBlock(
            "fading_torch",
            props -> new TorchBlock(
                    ParticleTypes.FLAME,
                    props
            ),
            BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH)
                    .lightLevel(state -> 15)
    );

    public static final DeferredBlock<Block> FADING_COAL_ORE = registerBlock(
            "fading_coal_ore",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)
    );

    private static <B extends Block> DeferredBlock<B> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends B> blockFactory, BlockBehaviour.Properties blockProperties) {
        DeferredBlock<B> block = BLOCKS.registerBlock(name, blockFactory, blockProperties);
        registerBlockItem(name, block);
        return block;
    }

    private static <B extends Block> void registerBlockItem(String name, DeferredBlock<B> block) {
        ModItems.ITEMS.registerSimpleBlockItem(name, block);
    }
}
