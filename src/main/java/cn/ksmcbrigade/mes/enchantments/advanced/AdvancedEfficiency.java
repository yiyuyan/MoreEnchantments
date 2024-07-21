package cn.ksmcbrigade.mes.enchantments.advanced;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class AdvancedEfficiency extends Enchantment {
    public AdvancedEfficiency() {
        super(Rarity.UNCOMMON, Enchantments.BLOCK_EFFICIENCY.category, new EquipmentSlot[]{EquipmentSlot.OFFHAND,EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    public int getMinCost(int p_44679_) {
        return 2 + 15 * (p_44679_ - 1);
    }

    @Override
    public boolean canEnchant(ItemStack p_44668_) {
        return p_44668_.getItem() instanceof net.minecraft.world.item.ShearsItem || super.canEnchant(p_44668_);
    }
}
