package com.bookshelf;

import com.bookshelf.db.Db;
import com.bookshelf.models.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.mongodb.Block;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        Gson gson = new Gson();
        Boolean userColl = Db.createMongoCollection("user");

        post("/signup", (req, res) -> {
            res.type("application/json");
            User user = gson.fromJson(req.body(), User.class);
            Db.insertMongoDocument(user, "user");
            return user;
        }, gson::toJson);

        get("/users", (req, res) -> {
            res.type("application/json");
            MongoDatabase mongoDatabase = Db.getMongoDatabase();
            MongoCollection<Document> collection = mongoDatabase.getCollection("user");
            JsonArray jsonArray = new JsonArray();
            collection.find().forEach(new Block<Document>() {
                @Override
                public void apply(Document document) {
                    jsonArray.add(document.toJson());
                }
            });
            return jsonArray;
        }, gson::toJson);
    }

}
