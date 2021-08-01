/*
 * Decompiled with CFR 0.150.
 */
package clientname;

import clientname.FileManager;
import java.io.File;

public class ModToggle {
    public static File getFolder(String mod) {
        File file = new File(FileManager.MODS_DIR, mod);
        file.mkdirs();
        return file;
    }

    public static void saveIsEnabledToFile(String mod, Boolean b) {
        FileManager.writeJsonToFile(new File(ModToggle.getFolder(mod), "Enabled.json"), b);
    }

    public static Boolean loadEnabledFromFile(String mod) {
        Boolean b = FileManager.readFromJson(new File(ModToggle.getFolder(mod), "Enabled.json"), Boolean.class);
        if (b == null) {
            b = false;
            ModToggle.saveIsEnabledToFile(mod, b);
        }
        return b;
    }
}

