package com.systemdesign.ticketstock.services;

import org.rocksdb.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.SerializationUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class RocksDBRepository {
    private final static String DB_PATH = "rockdb.db";
    private File dbFile;
    private RocksDB dbHandler;

    @PostConstruct
    public void initialize() throws RocksDBException {
        RocksDB.loadLibrary();
        dbFile = new File(DB_PATH);
        Options options = new Options();
        options.setCreateIfMissing(true);
        dbHandler = RocksDB.open(options, dbFile.getAbsolutePath());
    }

    public synchronized void save(String key, Object value) throws RocksDBException {
        dbHandler.put(key.getBytes(), SerializationUtils.serialize(value));
    }

    public synchronized void delete(String key) throws RocksDBException {
        dbHandler.delete(key.getBytes());
    }

    public synchronized Optional<Object> find(String key) throws RocksDBException {
        byte[] bytes = dbHandler.get(key.getBytes());
        if (bytes != null) {
            Object value = SerializationUtils.deserialize(bytes);
            Optional optionalValue = Optional.of(value);
            return optionalValue;
        }
        return Optional.empty();
    }

    public void createFamilyColumn() throws RocksDBException {
        final ColumnFamilyOptions cfOpts = new ColumnFamilyOptions().optimizeUniversalStyleCompaction();
        final List<ColumnFamilyDescriptor> cfDescriptors = List.of(
                new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY, cfOpts),
                new ColumnFamilyDescriptor("my-first-column-family".getBytes(), cfOpts));
        List<ColumnFamilyHandle> cfHandles = new ArrayList<>();
        final DBOptions options = new DBOptions()
                .setCreateIfMissing(true)
                .setCreateMissingColumnFamilies(true);
        final RocksDB db = RocksDB.open(options, "path/to/do", cfDescriptors, cfHandles);

    }

}
