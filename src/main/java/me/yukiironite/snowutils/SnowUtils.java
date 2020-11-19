package me.yukiironite.snowutils;

import me.yukiironite.snowutils.entities.GoldSnowGolemEntity;
import me.yukiironite.snowutils.entities.IronSnowGolemEntity;
import me.yukiironite.snowutils.entities.DiamondSnowGolemEntity;
import me.yukiironite.snowutils.entities.NetheriteSnowGolemEntity;
import me.yukiironite.snowutils.init.ModEntityTypes;
import me.yukiironite.snowutils.util.RegistryHandler;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("snowutils")
public class SnowUtils {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "snowutils";
    public static final ItemGroup TAB = new ItemGroup("snowutilsTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.SNOWCONE.get());
        }
    };

    public SnowUtils() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.GOLD_SNOW_GOLEM.get(), GoldSnowGolemEntity.func_234226_m_().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.IRON_SNOW_GOLEM.get(), IronSnowGolemEntity.func_234226_m_().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.DIAMOND_SNOW_GOLEM.get(), DiamondSnowGolemEntity.func_234226_m_().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.NETHERITE_SNOW_GOLEM.get(), NetheriteSnowGolemEntity.func_234226_m_().create());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }
}
