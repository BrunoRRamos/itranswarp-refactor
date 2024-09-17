package com.itranswarp.service;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.itranswarp.model.Article;
import com.itranswarp.model.Wiki;
import com.itranswarp.model.WikiPage;
import com.itranswarp.warpdb.WarpDb;

@Component
public class ViewDbService {

    @Autowired
    WarpDb db;

    String sqlUpdateArticleView;
    String sqlUpdateWikiView;
    String sqlUpdateWikiPageView;

    @PostConstruct
    public void init() {
        this.sqlUpdateArticleView = "UPDATE " + db.getTable(Article.class) + " SET views = views + ? WHERE id = ?";
        this.sqlUpdateWikiView = "UPDATE " + db.getTable(Wiki.class) + " SET views = views + ? WHERE id = ?";
        this.sqlUpdateWikiPageView = "UPDATE " + db.getTable(WikiPage.class) + " SET views = views + ? WHERE id = ?";
    }


    private <T> long getViews(Class<T> entityType, long id) {
            T entity = db.fetch(entityType, id);
        if (entity == null) {
            return 0;
        }
        try {
            return (long) entity.getClass().getField("views").get(entity);
        } catch (NoSuchFieldException | IllegalAccessException e) {

            return 0;
        }
    }

    public long getArticleViews(long id) {
        return getViews(Article.class, id);
    }

    public long getWikiViews(long id) {
        return getViews(Wiki.class, id);
    }

    public long getWikiPageViews(long id) {
        return getViews(WikiPage.class, id);
    }

    @Transactional
    public void updateArticleViews(long id, long views) {
        this.db.updateSql(this.sqlUpdateArticleView, views, id);
    }

    @Transactional
    public void updateWikiViews(long id, long views) {
        this.db.updateSql(this.sqlUpdateWikiView, views, id);
    }

    @Transactional
    public void updateWikiPageViews(long id, long views) {
        this.db.updateSql(this.sqlUpdateWikiPageView, views, id);
    }

}
