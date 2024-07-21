package cn.ksmcbrigade.mes;

import cn.ksmcbrigade.mes.registry.MoreEnchantmentsRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreEnchantments.MOD_ID)
public class Events {

    @SubscribeEvent
    public static void onAttack(AttackEntityEvent event){
        if(event.getEntity().getMainHandItem().getEnchantmentLevel(MoreEnchantmentsRegistry.bloodlust)>0 || event.getEntity().getOffhandItem().getEnchantmentLevel(MoreEnchantmentsRegistry.bloodlust)>0){
            event.getEntity().heal(EnchantmentHelper.getEnchantmentLevel(MoreEnchantmentsRegistry.bloodlust,(LivingEntity) event.getTarget())*2);
        }
        if((event.getTarget() instanceof LivingEntity) && EnchantmentHelper.getEnchantmentLevel(MoreEnchantmentsRegistry.bloodlustMyself,(LivingEntity) event.getTarget())>0){
            ((LivingEntity) event.getTarget()).heal(EnchantmentHelper.getEnchantmentLevel(MoreEnchantmentsRegistry.bloodlustMyself,(LivingEntity) event.getTarget())*2);
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        Iterable<ItemStack> iterable = MoreEnchantmentsRegistry.clear.getSlotItems(event.player).values();
        for(ItemStack itemstack : iterable) {
            if(itemstack.getEnchantmentLevel(MoreEnchantmentsRegistry.clear)>0){
                itemstack.setDamageValue(itemstack.getMaxDamage());
                itemstack.setCount(0);
            }
        }
    }
}
