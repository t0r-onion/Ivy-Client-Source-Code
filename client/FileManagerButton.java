/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 */
package client;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManagerButton {
    private static Gson gson = new Gson();
    private static File ROOT_DIR = new File("client");
    public static File TOGGLE_DIR = new File(ROOT_DIR, "Toggle");

    public static void init() {
        if (!ROOT_DIR.exists()) {
            ROOT_DIR.mkdirs();
        }
        if (!TOGGLE_DIR.exists()) {
            TOGGLE_DIR.mkdirs();
        }
    }

    public static Gson getGson() {
        return gson;
    }

    public static boolean writeJsonToFile(File file, Object obj) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(gson.toJson(obj).getBytes());
            outputStream.flush();
            outputStream.close();
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static <T> T readFromJson(File file, Class<T> c) {
        try {
            String line;
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder builder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
            return (T)gson.fromJson(builder.toString(), c);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

