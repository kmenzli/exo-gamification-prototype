package org.exoplatform.gamification.prototype.drive;

import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;

public class NativeJavaDriveExample {


    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        DB database = mongoClient.getDB("myMongoDb");

        // print existing databases
        mongoClient.getDatabaseNames().forEach(System.out::println);

        database.createCollection("customers", null);



        // print all collections in customers database
        database.getCollectionNames().forEach(System.out::println);

        // Gamification Collection (Table)
        DBCollection gamification = database.getCollection("gamification");

        // Create a Document in Gamification Collection
        System.out.println("######## Insert Lifecycle ###########");
        insert(gamification);

        //--- find all document within a collection
        System.out.println("######## Find All Document in Collection ###########");
        findAll(gamification);

        /**************************************
         * Find Data
         *************************************/
        System.out.println("######################## Find document By Criteria###########################");
        search(gamification);


        // update data
        System.out.println("######################## Update Document ###########################");
        update(gamification);

        // read data
        System.out.println("######################## Read only one target Document ###########################");
        read(gamification);

        // delete data
        System.out.println("######################## Remove Data ###########################");
        delete(gamification);

        System.out.println("######################## List All Document ###########################");
        findAll(gamification);

    }


    //--- Insert a Document
    public static void insert(DBCollection gamification ) {

        // Gamification Global Value
        BasicDBObject gameValue = new BasicDBObject();
        gameValue.put("username", "kmenzli");
        gameValue.put("score", "150");
        gameValue.put("last_update", System.currentTimeMillis());

        // Manage Module
        List<BasicDBObject> modules = new ArrayList<>();
        // Module 1
        BasicDBObject mod1 = new BasicDBObject();
        mod1.put("module_name", "Knowledge");
        mod1.put("module_score", "70");

        // Manage Badges
        List<BasicDBObject> badges = new ArrayList<>();
        // Create BadgeA
        BasicDBObject badgeA = new BasicDBObject();
        badgeA.put("badge_name", "expert");
        badgeA.put("badge_score", "50");
        badgeA.put("badge_icon", "expert.png");
        badgeA.put("badge_acquired_date", System.currentTimeMillis());

        badges.add(badgeA);
        // Create BadgeA
        BasicDBObject badgeB = new BasicDBObject();
        badgeB.put("badge_name", "starter");
        badgeB.put("badge_score", "50");
        badgeB.put("badge_icon", "starter.png");
        badgeB.put("badge_acquired_date", System.currentTimeMillis());

        badges.add(badgeB);

        mod1.put("badges", badges);
        modules.add(mod1);

        // Create Module 2
        BasicDBObject mod2 = new BasicDBObject();
        mod2.put("module_name", "social");
        mod2.put("module_score", "110");
        // Manage Badges
        badges = new ArrayList<>();
        badgeA = new BasicDBObject();
        badgeA.put("badge_name", "star");
        badgeA.put("badge_score", "90");
        badgeA.put("badge_icon", "star.png");
        badgeA.put("badge_acquired_date", System.currentTimeMillis());

        badges.add(badgeA);

        badgeB = new BasicDBObject();
        badgeB.put("badge_name", "evan");
        badgeB.put("badge_score", "50");
        badgeB.put("badge_icon", "evan.png");
        badgeB.put("badge_acquired_date", System.currentTimeMillis());

        badges.add(badgeB);

        mod2.put("badges", badges);
        modules.add(mod2);

        gameValue.put("modules",modules);

        // Save the document
        gamification.insert(gameValue);

    }

    //--- Update a Document
    public static void update (DBCollection gamification) {
        BasicDBObject query = new BasicDBObject();
        query.put("username", "kmenzli");
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("username", "Joe Walker");
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);
        gamification.update(query, updateObject);

    }
    //--- Update a Document
    public static void findAll (DBCollection gamification) {
        List<DBObject> all = gamification.find().toArray();
        System.out.println(all.size());
        all.forEach(System.out::println);

    }
    public static void read (DBCollection gamification) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("username", "Joe Walker");
        DBCursor cursor = gamification.find(searchQuery);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    public static void search (DBCollection gamification) {
        DBObject query = new QueryBuilder()
                .start().put("modules.module_name").is("Knowledge").get();

        DBCursor cursor = gamification.find(query);

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

    }

    public static void delete (DBCollection gamification) {
        BasicDBObject deleteQuery = new BasicDBObject();
        deleteQuery.put("username", "Joe Walker");
        gamification.remove(deleteQuery);

    }


    public void fakeInsert(DB database) {
        // create data
        DBCollection collection = database.getCollection("artifactory");
        BasicDBObject document = new BasicDBObject();
        document.put("username", "kmenzli");
        document.put("company", "eXo");
        collection.insert(document);
    }
}
