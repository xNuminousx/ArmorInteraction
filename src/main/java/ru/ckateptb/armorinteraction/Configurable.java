package ru.ckateptb.armorinteraction;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Configurable {

    private String path;

    public Configurable() {
    }

    public Configurable(String path) {
        if (!path.endsWith(".yml"))
            path += ".yml";
        this.path = path.replaceAll("/", File.separator);
        this.loadConfig();
        this.saveConfig();
    }

    public void loadConfig() {
        loadConfig(this.path);
    }

    public void loadConfig(String path) {
        if (path == null || path.isEmpty())
            path = "config.yml";
        this.path = path;
        String strConfig = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = reader.readLine()) != null) {
                sb.append(s).append("\n");
            }
            reader.close();
            strConfig = Pattern.compile("\\r?\\n? *?#[^\\r\\n]*").matcher(sb.toString()).replaceAll("");
            while (strConfig.startsWith("\n"))
                strConfig = strConfig.substring(1);
            strConfig = strConfig.replaceAll("\n+", "\n");
        } catch (IOException ignored) {
        }
        YamlConfiguration config = new YamlConfiguration();
        try {
            config.loadFromString(strConfig);
        } catch (InvalidConfigurationException ignored) {
        }

        Class<? extends Configurable> cls = getClass();

        for (Field f : cls.getFields()) {
            if (f.isAnnotationPresent(ConfigField.class)) {
                String target;
                ConfigField cf = f.getAnnotation(ConfigField.class);
                target = cf.name();
                if (target.isEmpty())
                    target = f.getName();

                try {
                    f.set(this, config.get(target, f.get(this)));
                } catch (IllegalArgumentException | IllegalAccessException ignored) {
                }
            }
        }
    }

    public void saveConfig() {
        saveConfig(this.path);
    }

    public boolean saveConfig(String path) {
        if (path == null || path.isEmpty())
            path = "config.yml";
        this.path = path;

        YamlConfiguration config = new YamlConfiguration();

        HashMap<String, String> comments = new HashMap<>();

        Class<? extends Configurable> cls = getClass();

        for (Field f : cls.getFields()) {
            if (f.isAnnotationPresent(ConfigField.class)) {
                String target;
                ConfigField cf = f.getAnnotation(ConfigField.class);
                target = cf.name();
                if (target.isEmpty())
                    target = f.getName();
                try {
                    if (!cf.comment().isEmpty()) {
                        comments.put(target, cf.comment());
                        config.set(target + "_COMMENT", cf.comment());
                    }

                    config.set(target, f.get(this));
                } catch (IllegalArgumentException | IllegalAccessException ignored) {
                }
            }
        }

        try {
            String configString = config.saveToString();

            if (getClass().isAnnotationPresent(ConfigFile.class)) {
                String header = getClass().getAnnotation(ConfigFile.class).header();
                if (!header.isEmpty())
                    configString = "# " + header + "\n" + configString;
            }

            Matcher matcher = Pattern.compile("(?:[A-Za-z0-9А-Яа-я]*?)_COMMENT: ?(.*?)(\\n[^:\\n]*?:)", Pattern.DOTALL).matcher(configString);

            StringBuffer newConfig = new StringBuffer();

            while (matcher.find()) {
                String comm = matcher.group(1);
                comm = "# " + Pattern.compile("\n( *)").matcher(comm).replaceAll("\n$1# ");
                comm += matcher.group(2);
                matcher.appendReplacement(newConfig, Matcher.quoteReplacement(comm));
            }
            matcher.appendTail(newConfig);
            configString = newConfig.toString();

            File f = new File(path).getParentFile();

            if (f != null)
                f.mkdirs();

            Writer file = new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8);

            file.write(configString);

            file.close();
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ConfigField {
        String name() default "";

        String comment() default "";
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ConfigFile {
        String header() default "";
    }
}

