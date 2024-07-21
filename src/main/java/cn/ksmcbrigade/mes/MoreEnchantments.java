package cn.ksmcbrigade.mes;

import cn.ksmcbrigade.mes.registry.MoreEnchantmentsRegistry;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;

import java.util.List;

@Mod(MoreEnchantments.MOD_ID)
public class MoreEnchantments {

    public static final String MOD_ID = "mes";

    private static final Logger LOGGER = LogUtils.getLogger();

    public static final EquipmentSlot[] ARMOR_SLOTS = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    public MoreEnchantments() {
        MinecraftForge.EVENT_BUS.register(this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onRegisterEnchantments);
    }

    @SubscribeEvent
    public void onRegisterEnchantments(RegisterEvent event) {
        try {
            List.of(MoreEnchantmentsRegistry.class.getDeclaredFields()).forEach(f -> {
                        try {
                            f.setAccessible(true);
                            Enchantment enchantment = (Enchantment)f.get(null);
                            ResourceLocation name = getRegisterName(f.getType().getSimpleName());
                            event.register(ForgeRegistries.Keys.ENCHANTMENTS,name,()->enchantment);
                            LOGGER.info("Registered a enchantment {}",name.toString());
                        } catch (Exception e) {
                            LOGGER.error("Error in register a enchantment {}",f.getType().getSimpleName(),e);
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResourceLocation getRegisterName(String name){
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for(String c:name.split("")){
            if(Character.isUpperCase(c.charAt(0)) && !first){
                builder.append("_");
            }
            builder.append(c);
            if(first){
                first = false;
            }
        }
        return new ResourceLocation(MOD_ID,builder.toString().toLowerCase());
    }
}
