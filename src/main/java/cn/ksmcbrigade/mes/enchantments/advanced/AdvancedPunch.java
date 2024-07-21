package cn.ksmcbrigade.mes.enchantments.advanced;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.ArrowKnockbackEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;

public class AdvancedPunch extends ArrowKnockbackEnchantment {
    public AdvancedPunch() {
        super(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND,EquipmentSlot.OFFHAND);
    }

    public int getMaxCost(int p_44600_) {
        return this.getMinCost(p_44600_) + 35;
    }
}
