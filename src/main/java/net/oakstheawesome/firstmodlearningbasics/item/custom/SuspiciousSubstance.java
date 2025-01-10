package net.oakstheawesome.firstmodlearningbasics.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class SuspiciousSubstance extends Item {
    public SuspiciousSubstance(Settings settings) {
        super(settings);
    }

    //Should add a tooltip, but doesn't work.
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.firstmodlearningbasics.suspicious_substance.tooltip").formatted(Formatting.LIGHT_PURPLE));
    }

}


