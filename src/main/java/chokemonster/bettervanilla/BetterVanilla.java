package chokemonster.bettervanilla;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Reference.MODID)

public class BetterVanilla {
    // Directly reference a log4j logger.
    public static final Logger BETTERVANILLALOGGER = LogManager.getLogger();

    public static void sendHiVisInfo(String message) {
        BETTERVANILLALOGGER.info("\n\n" + message + "\n");
    }

    public static void sendHiVisDebug(String message) {
        BETTERVANILLALOGGER.debug("\n\n" + message + "\n");
    }
}
