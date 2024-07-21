package cn.ksmcbrigade.mes.enchantments.basic;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.ArrowKnockbackEnchantment;

public class BasicPunch extends ArrowKnockbackEnchantment {
    public BasicPunch() {
        super(Rarity.RARE, EquipmentSlot.MAINHAND,EquipmentSlot.OFFHAND);
    }

    public int getMaxCost(int p_44600_) {
        return this.getMinCost(p_44600_) + 20;
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }
}
