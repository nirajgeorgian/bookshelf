package com.bookshelf.db;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.Objects;

public class Db {
    static final MongoCredential credential = MongoCredential.createCredential("root", "bookstore", "dodoN9".toCharArray());

    public static final MongoClient getMongoConnection() {
        MongoClient mongoClient = MongoClients.create(
          MongoClientSettings.builder()
            .applyToClusterSettings(builder ->
                builder.hosts(Arrays.asList(new ServerAddress("ds257752.mlab.com", 57752))))
            .credential(credential)
            .build());
        System.out.println("started mongo ...");
        return mongoClient;
    }

    public static final MongoDatabase getMongoDatabase() {
        MongoClient mongoClient = Db.getMongoConnection();
        final MongoDatabase mongoDatabase = mongoClient.getDatabase("bookstore");
        System.out.println("Get mongo Database connection ...");
        return mongoDatabase;
    }

    public static final boolean createMongoCollection(String collection) {
        MongoDatabase mongoDatabase = Db.getMongoDatabase();
        for (String collectionName: mongoDatabase.listCollectionNames()) {
            if (Objects.equals(new String(collectionName), collection)) {
                System.out.println("Mongo Collection already exists");
                return false;
            }
        }
        System.out.println("creating collection ...");
        mongoDatabase.createCollection(collection);
        return true;
    }

    public static final MongoCollection<Document> getMongoCollection(String collection) {
        MongoDatabase mongoDatabase = Db.getMongoDatabase();
        for (String collectionName: mongoDatabase.listCollectionNames()) {
            if(Objects.equals(new String(collectionName), collection)) {
                System.out.println("Fetching collection ...");
                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(collection);
                return mongoCollection;
            }
        }
        System.out.println("Mongo Collection does not exist. Please create collection.");
        return null;
    }

    public static final boolean insertMongoDocument(Object object, String collection) {
        MongoCollection<Document> mongoCollection = Db.getMongoCollection(collection);
        if(mongoCollection == null) {
            return false;
        }
        Gson gson = new Gson();
        Document document = Document.parse(gson.toJson(object));
        System.out.println("inserting document ...");
        mongoCollection.insertOne(document);
        return true;
    }
}
