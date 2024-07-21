package cn.ksmcbrigade.mes.enchantments.advanced;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class AdvancedFireAspect extends Enchantment {
    public AdvancedFireAspect() {
        super(Rarity.UNCOMMON, Enchantments.FIRE_ASPECT.category, new EquipmentSlot[]{EquipmentSlot.OFFHAND,EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public int getMinCost(int p_44679_) {
        return 10 + 25 * (p_44679_ - 1);
    }

    @Override
    public int getMaxCost(int p_44679_) {
        return super.getMinCost(p_44679_) + 80;
    }
}
