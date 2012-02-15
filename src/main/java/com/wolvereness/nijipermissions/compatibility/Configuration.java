package com.wolvereness.nijipermissions.compatibility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.bukkit.util.config.ConfigurationNode;

/**
 * @author Wolfe
 * Licensed under GNU GPL v3
 */
public class Configuration {
	private YamlConfiguration config;
	private File file;

	/**
	 * @param file
	 */
	public Configuration(File file) {
		config = YamlConfiguration.loadConfiguration(file);
		this.file = file;
	}

	/**
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		return config.equals(obj);
	}

	/**
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getAll()
	 */
	public Map<String, Object> getAll() {
		return config.getValues(false);
	}

	/**
	 * @param path
	 * @param def
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getBoolean(java.lang.String, boolean)
	 */
	public boolean getBoolean(
								final String path,
								final boolean def) {
		return config.getBoolean(
			path,
			def);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getBooleanList(java.lang.String, java.util.List)
	 */
	public List<Boolean> getBooleanList(
										final String arg0,
										final List<Boolean> arg1) {
		final List<Boolean> list = config.getBooleanList(arg0);
		if(list == null) {
			if(arg1 == null) return new ArrayList<Boolean>();
			return arg1;
		}
		return list;
	}

	/**
	 * @param path
	 * @param def
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getDouble(java.lang.String, double)
	 */
	public double getDouble(
							final String path,
							final double def) {
		return config.getDouble(
			path,
			def);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getDoubleList(java.lang.String, java.util.List)
	 */
	public List<Double> getDoubleList(
										final String arg0,
										final List<Double> arg1) {
		final List<Double> list = config.getDoubleList(arg0);
		if(list == null) {
			if(arg1 == null) return new ArrayList<Double>();
			return arg1;
		}
		return list;
	}

	/**
	 * @return
	 * @see org.bukkit.util.config.Configuration#getHeader()
	 */
	public String getHeader() {
		return config.options().header();
	}

	/**
	 * @param path
	 * @param def
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getInt(java.lang.String, int)
	 */
	public int getInt(
						final String path,
						final int def) {
		return config.getInt(path, def);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getIntList(java.lang.String, java.util.List)
	 */
	public List<Integer> getIntList(
									final String arg0,
									final List<Integer> arg1) {
		final List<Integer> list = config.getIntegerList(arg0);
		if(list == null) {
			if(arg1 == null) return new ArrayList<Integer>();
			return arg1;
		}
		return list;
	}

	/**
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getKeys()
	 */
	public Collection<String> getKeys() {
		return config.getKeys(false);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getKeys(java.lang.String)
	 */
	public Collection<String> getKeys(
								final String path) {
		if(!config.isConfigurationSection(path)) return null;
		return config.getConfigurationSection(path).getKeys(false);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getList(java.lang.String)
	 */
	public List<Object> getList(
								final String path) {
		return config.getList(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getNode(java.lang.String)
	 */
	@Deprecated
	public ConfigurationNode getNode(
										final String path) {
		return null;
		//return config.getNode(path);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getNodeList(java.lang.String, java.util.List)
	 */
	@Deprecated
	public List<ConfigurationNode> getNodeList(
												final String arg0,
												final List<ConfigurationNode> arg1) {
		return null;
		//return config.getNodeList(
		//	arg0,
		//	arg1);
	}

	/**
	 * @param arg0
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getNodes(java.lang.String)
	 */
	@Deprecated
	public Map<String, ConfigurationNode> getNodes(
													final String arg0) {
		return null;
		//return config.getNodes(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getProperty(java.lang.String)
	 */
	public Object getProperty(
								final String arg0) {
		return config.get(arg0);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getString(java.lang.String)
	 */
	public String getString(final String path) {
		return config.getString(path);
	}

	/**
	 * @param path
	 * @param def
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getString(java.lang.String, java.lang.String)
	 */
	public String getString(
							final String path,
							final String def) {
		return config.getString(
			path,
			def);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see org.bukkit.util.config.ConfigurationNode#getStringList(java.lang.String, java.util.List)
	 */
	public List<String> getStringList(
										final String arg0,
										final List<String> arg1) {
		final List<String> list = config.getStringList(arg0);
		if(list == null) {
			if(arg1 == null) return new ArrayList<String>();
			return arg1;
		}
		return list;
	}

	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return config.hashCode();
	}

	/**
	 *
	 * @see org.bukkit.util.config.Configuration#load()
	 */
	public void load() {
		config = YamlConfiguration.loadConfiguration(file);
		//config.load();
	}

	/**
	 * @param arg0
	 * @see org.bukkit.util.config.ConfigurationNode#removeProperty(java.lang.String)
	 */
	public void removeProperty(
								final String arg0) {
		config.set(arg0, null);
	}

	/**
	 * @return
	 * @see org.bukkit.util.config.Configuration#save()
	 */
	public boolean save() {
		try {
			config.save(file);
			return true;
		} catch (final IOException e) {
			e.printStackTrace();
			return false;
		}
		//return config.save();
	}

	/**
	 * @param arg0
	 * @see org.bukkit.util.config.Configuration#setHeader(java.lang.String[])
	 */
	public void setHeader(
							final String... arg0) {
		int size = 0;
		for(final String l : arg0) {
			if(l != null) {
				size += l.length() + 1;
			} else {
				size++;
			}
		}
		final StringBuilder builder = new StringBuilder(size);
		for(final String l : arg0) {
			if(l != null) {
				builder.append(l);
			}
			builder.append('\n');
		}
		this.setHeader(builder.toString());
	}

	/**
	 * @param header
	 * @see org.bukkit.util.config.Configuration#setHeader(java.lang.String)
	 */
	public void setHeader(final String header) {
		config.options().header(header);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @see org.bukkit.util.config.ConfigurationNode#setProperty(java.lang.String, java.lang.Object)
	 */
	public void setProperty(
							final String arg0,
							final Object arg1) {
		config.set(arg0, arg1);
	}

	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return config.toString();
	}

	/**
	 * @param path
	 * @param value
	 * @see org.bukkit.configuration.MemoryConfiguration#addDefault(java.lang.String, java.lang.Object)
	 */
	public void addDefault(
							String path,
							Object value) {
		config.addDefault(path, value);
	}

	/**
	 * @param defaults
	 * @see org.bukkit.configuration.MemoryConfiguration#addDefaults(org.bukkit.configuration.Configuration)
	 */
	public void addDefaults(
							org.bukkit.configuration.Configuration defaults) {
		config.addDefaults(defaults);
	}

	/**
	 * @param defaults
	 * @see org.bukkit.configuration.MemoryConfiguration#addDefaults(java.util.Map)
	 */
	public void addDefaults(
							Map<String, Object> defaults) {
		config.addDefaults(defaults);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#contains(java.lang.String)
	 */
	public boolean contains(String path) {
		return config.contains(path);
	}

	/**
	 * @param path
	 * @param map
	 * @return
	 * @see org.bukkit.configuration.MemorySection#createSection(java.lang.String, java.util.Map)
	 */
	public ConfigurationSection createSection(
												String path,
												Map<String, Object> map) {
		return config.createSection(
			path,
			map);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#createSection(java.lang.String)
	 */
	public ConfigurationSection createSection(
												String path) {
		return config
			.createSection(path);
	}

	/**
	 * @param path
	 * @param def
	 * @return
	 * @see org.bukkit.configuration.MemorySection#get(java.lang.String, java.lang.Object)
	 */
	public Object get(
						String path,
						Object def) {
		return config.get(path, def);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#get(java.lang.String)
	 */
	public Object get(String path) {
		return config.get(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getBoolean(java.lang.String)
	 */
	public boolean getBoolean(
								String path) {
		return config.getBoolean(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getBooleanList(java.lang.String)
	 */
	public List<Boolean> getBooleanList(
										String path) {
		return config
			.getBooleanList(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getByteList(java.lang.String)
	 */
	public List<Byte> getByteList(
									String path) {
		return config.getByteList(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getCharacterList(java.lang.String)
	 */
	public List<Character> getCharacterList(
											String path) {
		return config
			.getCharacterList(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getConfigurationSection(java.lang.String)
	 */
	public ConfigurationSection getConfigurationSection(
														String path) {
		return config
			.getConfigurationSection(path);
	}

	/**
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getCurrentPath()
	 */
	public String getCurrentPath() {
		return config.getCurrentPath();
	}

	/**
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getDefaultSection()
	 */
	public ConfigurationSection getDefaultSection() {
		return config
			.getDefaultSection();
	}

	/**
	 * @return
	 * @see org.bukkit.configuration.MemoryConfiguration#getDefaults()
	 */
	public org.bukkit.configuration.Configuration getDefaults() {
		return config.getDefaults();
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getDouble(java.lang.String)
	 */
	public double getDouble(String path) {
		return config.getDouble(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getDoubleList(java.lang.String)
	 */
	public List<Double> getDoubleList(
										String path) {
		return config
			.getDoubleList(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getFloatList(java.lang.String)
	 */
	public List<Float> getFloatList(
									String path) {
		return config
			.getFloatList(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getInt(java.lang.String)
	 */
	public int getInt(String path) {
		return config.getInt(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getIntegerList(java.lang.String)
	 */
	public List<Integer> getIntegerList(
										String path) {
		return config
			.getIntegerList(path);
	}

	/**
	 * @param path
	 * @param def
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getItemStack(java.lang.String, org.bukkit.inventory.ItemStack)
	 */
	public ItemStack getItemStack(
									String path,
									ItemStack def) {
		return config.getItemStack(
			path,
			def);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getItemStack(java.lang.String)
	 */
	public ItemStack getItemStack(
									String path) {
		return config
			.getItemStack(path);
	}

	/**
	 * @param deep
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getKeys(boolean)
	 */
	public Set<String> getKeys(
								boolean deep) {
		return config.getKeys(deep);
	}

	/**
	 * @param path
	 * @param def
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getList(java.lang.String, java.util.List)
	 */
	public List<Object> getList(
								String path,
								List<?> def) {
		return config
			.getList(path, def);
	}

	/**
	 * @param path
	 * @param def
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getLong(java.lang.String, long)
	 */
	public long getLong(
						String path,
						long def) {
		return config
			.getLong(path, def);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getLong(java.lang.String)
	 */
	public long getLong(String path) {
		return config.getLong(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getLongList(java.lang.String)
	 */
	public List<Long> getLongList(
									String path) {
		return config.getLongList(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getMapList(java.lang.String)
	 */
	public List<Map<String, Object>> getMapList(
												String path) {
		return config.getMapList(path);
	}

	/**
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getName()
	 */
	public String getName() {
		return config.getName();
	}

	/**
	 * @param path
	 * @param def
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getOfflinePlayer(java.lang.String, org.bukkit.OfflinePlayer)
	 */
	public OfflinePlayer getOfflinePlayer(
											String path,
											OfflinePlayer def) {
		return config.getOfflinePlayer(
			path,
			def);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getOfflinePlayer(java.lang.String)
	 */
	public OfflinePlayer getOfflinePlayer(
											String path) {
		return config
			.getOfflinePlayer(path);
	}

	/**
	 * @return
	 * @see org.bukkit.configuration.MemoryConfiguration#getParent()
	 */
	public ConfigurationSection getParent() {
		return config.getParent();
	}

	/**
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getRoot()
	 */
	public org.bukkit.configuration.Configuration getRoot() {
		return config.getRoot();
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getShortList(java.lang.String)
	 */
	public List<Short> getShortList(
									String path) {
		return config
			.getShortList(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getStringList(java.lang.String)
	 */
	public List<String> getStringList(
										String path) {
		return config
			.getStringList(path);
	}

	/**
	 * @param deep
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getValues(boolean)
	 */
	public Map<String, Object> getValues(
											boolean deep) {
		return config.getValues(deep);
	}

	/**
	 * @param path
	 * @param def
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getVector(java.lang.String, org.bukkit.util.Vector)
	 */
	public Vector getVector(
							String path,
							Vector def) {
		return config.getVector(
			path,
			def);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#getVector(java.lang.String)
	 */
	public Vector getVector(String path) {
		return config.getVector(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#isBoolean(java.lang.String)
	 */
	public boolean isBoolean(String path) {
		return config.isBoolean(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#isConfigurationSection(java.lang.String)
	 */
	public boolean isConfigurationSection(
											String path) {
		return config
			.isConfigurationSection(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#isDouble(java.lang.String)
	 */
	public boolean isDouble(String path) {
		return config.isDouble(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#isInt(java.lang.String)
	 */
	public boolean isInt(String path) {
		return config.isInt(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#isItemStack(java.lang.String)
	 */
	public boolean isItemStack(
								String path) {
		return config.isItemStack(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#isList(java.lang.String)
	 */
	public boolean isList(String path) {
		return config.isList(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#isLong(java.lang.String)
	 */
	public boolean isLong(String path) {
		return config.isLong(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#isOfflinePlayer(java.lang.String)
	 */
	public boolean isOfflinePlayer(
									String path) {
		return config
			.isOfflinePlayer(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#isSet(java.lang.String)
	 */
	public boolean isSet(String path) {
		return config.isSet(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#isString(java.lang.String)
	 */
	public boolean isString(String path) {
		return config.isString(path);
	}

	/**
	 * @param path
	 * @return
	 * @see org.bukkit.configuration.MemorySection#isVector(java.lang.String)
	 */
	public boolean isVector(String path) {
		return config.isVector(path);
	}

	/**
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InvalidConfigurationException
	 * @see org.bukkit.configuration.file.FileConfiguration#load(java.io.File)
	 */
	public void load(File file)
								throws FileNotFoundException,
									IOException,
									InvalidConfigurationException {
		config.load(file);
	}

	/**
	 * @param arg0
	 * @throws IOException
	 * @throws InvalidConfigurationException
	 * @see org.bukkit.configuration.file.FileConfiguration#load(java.io.InputStream)
	 */
	public void load(InputStream arg0)
										throws IOException,
											InvalidConfigurationException {
		config.load(arg0);
	}

	/**
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InvalidConfigurationException
	 * @see org.bukkit.configuration.file.FileConfiguration#load(java.lang.String)
	 */
	public void load(String file)
									throws FileNotFoundException,
										IOException,
										InvalidConfigurationException {
		config.load(file);
	}

	/**
	 * @param contents
	 * @throws InvalidConfigurationException
	 * @see org.bukkit.configuration.file.YamlConfiguration#loadFromString(java.lang.String)
	 */
	public void loadFromString(
								String contents)
												throws InvalidConfigurationException {
		config.loadFromString(contents);
	}

	/**
	 * @return
	 * @see org.bukkit.configuration.file.YamlConfiguration#options()
	 */
	public YamlConfigurationOptions options() {
		return config.options();
	}

	/**
	 * @param file
	 * @throws IOException
	 * @see org.bukkit.configuration.file.FileConfiguration#save(java.io.File)
	 */
	public void save(File file)
								throws IOException {
		config.save(file);
	}

	/**
	 * @param file
	 * @throws IOException
	 * @see org.bukkit.configuration.file.FileConfiguration#save(java.lang.String)
	 */
	public void save(String file)
									throws IOException {
		config.save(file);
	}

	/**
	 * @return
	 * @see org.bukkit.configuration.file.YamlConfiguration#saveToString()
	 */
	public String saveToString() {
		return config.saveToString();
	}

	/**
	 * @param path
	 * @param value
	 * @see org.bukkit.configuration.MemorySection#set(java.lang.String, java.lang.Object)
	 */
	public void set(
					String path,
					Object value) {
		config.set(path, value);
	}

	/**
	 * @param defaults
	 * @see org.bukkit.configuration.MemoryConfiguration#setDefaults(org.bukkit.configuration.Configuration)
	 */
	public void setDefaults(
							org.bukkit.configuration.Configuration defaults) {
		config.setDefaults(defaults);
	}
}
