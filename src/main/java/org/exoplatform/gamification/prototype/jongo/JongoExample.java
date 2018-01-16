package org.exoplatform.gamification.prototype.jongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.exoplatform.gamification.prototype.jongo.DTO.Badge;
import org.exoplatform.gamification.prototype.jongo.DTO.GamificationEntry;
import org.exoplatform.gamification.prototype.jongo.DTO.Module;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JongoExample {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("jongo");
        Jongo jongo = new Jongo(db);

        MongoCollection game = jongo.getCollection("gameJongo");

        System.out.println("#### Insert new Document ####");
        insert(game);
        System.out.println("#### List Document ####");
        search(game);

    }

    public static void insert(MongoCollection game) {

        GamificationEntry g = new GamificationEntry();
        g.setScore(150);
        g.setUsername("kmenzli");
        g.setLastUpdate(new Date());

        List<Module> modules = new ArrayList<Module>();

        Module mod1 = new Module();
        mod1.setModule_score(70);
        mod1.setModule_name("Knowledge");
        List<Badge> badges = new ArrayList<Badge>();
        Badge b1 = new Badge();
        b1.setBadge_name("expert");
        b1.setBadge_score(50);
        b1.setBadge_icon("expert.png");
        b1.setBadge_acquired_date(new Date());
        badges.add(b1);

        b1 = new Badge();
        b1.setBadge_name("starter");
        b1.setBadge_score(50);
        b1.setBadge_icon("starter.png");
        b1.setBadge_acquired_date(new Date());
        badges.add(b1);

        mod1.setBadges(badges);
        modules.add(mod1);

        Module mod2 = new Module();
        mod2.setModule_score(110);
        mod2.setModule_name("social");
        badges = new ArrayList<Badge>();
        Badge b2 = new Badge();
        b2.setBadge_name("star");
        b2.setBadge_score(90);
        b2.setBadge_icon("start.png");
        b2.setBadge_acquired_date(new Date());
        badges.add(b2);

        b2 = new Badge();
        b2.setBadge_name("evan");
        b2.setBadge_score(50);
        b2.setBadge_icon("evan.png");
        b2.setBadge_acquired_date(new Date());
        badges.add(b2);

        mod1.setBadges(badges);
        modules.add(mod2);

        g.setModules(modules);

        game.insert(g);


    }

    public static void search (MongoCollection game) {
        MongoCursor<GamificationEntry> all = game.find("{username: 'kmenzli'}").as(GamificationEntry.class);

        all.forEach(a->{
            System.out.println("username :"+a.getUsername());
            System.out.println("score :"+a.getScore());

        });
    }
}
