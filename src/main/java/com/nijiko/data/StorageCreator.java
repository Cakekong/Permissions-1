package com.nijiko.data;

import com.wolvereness.nijipermissions.compatibility.Configuration;

public interface StorageCreator {
    public UserStorage getUserStorage(String world, int reload, boolean autosave, Configuration config) throws Exception;
    public GroupStorage getGroupStorage(String world, int reload, boolean autosave, Configuration config) throws Exception;
}
