package net.oakstheawesome.firstmodlearningbasics;

import net.fabricmc.api.ModInitializer;

import net.oakstheawesome.firstmodlearningbasics.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstModLearningBasics implements ModInitializer {
	public static final String MOD_ID = "firstmodlearningbasics";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		LOGGER.info("Beembus Boombus");
	}
}