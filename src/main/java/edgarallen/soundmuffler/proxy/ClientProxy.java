package edgarallen.soundmuffler.proxy;

import edgarallen.soundmuffler.SuperSoundMuffler;
import edgarallen.soundmuffler.block.TileEntitySoundMuffler;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.WeakHashMap;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    private WeakHashMap<TileEntitySoundMuffler, WeakReference<TileEntitySoundMuffler>> soundMufflers = new WeakHashMap<>();

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        SuperSoundMuffler.blockSoundMuffler.registerModels();
        SuperSoundMuffler.itemSoundMufflerBauble.registerModels();
    }

    @Override
    public void cacheMuffler(TileEntitySoundMuffler tileEntity) {
        soundMufflers.put(tileEntity, new WeakReference<>(tileEntity));
    }

    @Override
    public Set<TileEntitySoundMuffler> getTileEntities() {
        return soundMufflers.keySet();
    }
}
