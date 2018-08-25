package controllers;

import db.DBArticle;
import db.DBHelper;
import models.Article;
import models.Author;
import models.Section;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class ArticleController {


    public ArticleController(){
        setupEndPoints();
    }

    private static void setupEndPoints() {


        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/articles/new", (req, res) -> {
                    Map<String, Object> model = new HashMap<>();
                    model.put("template", "templates/articles/new.vtl");
                    List<Author> authors = DBHelper.findAll(Author.class);
                    model.put("authors", authors);
                    List<Section> sections = DBHelper.findAll(Section.class);
                    model.put("sections", sections);
                    return new ModelAndView(model, "templates/layout.vtl");
                }, velocityTemplateEngine
        );

        get("/articles", (req, res) ->{
                    Map<String, Object> model = new HashMap<>();
                    List<Article> articles = DBHelper.findAll(Article.class);
                    model.put("template", "templates/articles/index.vtl");
                    model.put("articles", articles);
                    return new ModelAndView(model, "templates/layout.vtl");
                }, velocityTemplateEngine
        );




        post("/articles", (req, res) -> {

         	// Create the article
        	String textContent = req.queryParams("text_content");
			String title = req.queryParams("title");
			int authorId = Integer.parseInt(req.queryParams("authorId"));
            Author author = DBHelper.findById(Author.class, authorId);
            Article article = new Article(title, textContent, author);
            DBHelper.save(article);

            // Add any sections from the form to the article
			addSectionsFromFormToArticle(req.queryParams(), article);

			res.redirect("/articles");
            return null;
        }, velocityTemplateEngine);


        post ("/articles/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Article article = DBHelper.findById(Article.class, id);
            DBHelper.delete(article);
            res.redirect("/articles");
            return null;
        }, new VelocityTemplateEngine());


		get("/articles/:id/edit", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("template", "templates/articles/edit.vtl");
			int articleId = Integer.parseInt(req.params(":id"));
			Article article = DBHelper.findById(Article.class, articleId);
			model.put("article", article);
			List<Author> authors = DBHelper.findAll(Author.class);
			model.put("authors", authors );
			List<Section> sections = DBHelper.findAll(Section.class);
			model.put("sections", sections);
			return new ModelAndView(model, "templates/layout.vtl");
		}, velocityTemplateEngine);

		post("/articles/:id/edit", (req, res) -> {
			int articleID = Integer.parseInt(req.params("id"));
			String title = req.queryParams("title");
			String textContent = req.queryParams("textContent");
			int authorId = Integer.parseInt(req.queryParams("authorId"));
			Author author = DBHelper.findById(Author.class, authorId);
			Article article= DBHelper.findById(Article.class, articleID);
			article.setTitle(title);
			article.setTextContent(textContent);
			article.setAuthor(author);
			DBHelper.save(article);

			addSectionsFromFormToArticle(req.queryParams(), article);

			res.redirect("/articles");
			return null;
		}, velocityTemplateEngine);
    }


    private static void addSectionsFromFormToArticle(Set queryParms, Article article){
		// Add a section if one is selected from the form
		List<Section> sections = getSectionsFromForm(queryParms);
		if (sections.size() != 0){
			for(Section section : sections){
				DBArticle.addArticleToSection(article, section);
			}
		}
	}

    private static List<Section> getSectionsFromForm(Set<String> queryParams){
		List<Integer> sectionIds = getSectionIdsFromQueryParams(queryParams);
		List<Section> sections = getSectionsFromSectionIds(sectionIds);
		return sections;
	}

	private static List<Section> getSectionsFromSectionIds(List<Integer> sectionIds){
		List<Section> sections = new ArrayList<>();

		for(Integer sectionId : sectionIds){
			Section section = DBHelper.findById(Section.class, sectionId);
			sections.add(section);
		}

		return sections;
	}

	private static List<Integer> getSectionIdsFromQueryParams(Set<String> queryParams){

		List<Integer> sectionIds = new ArrayList<>();

		for(String param : queryParams){
			if (param.contains("_section")){
				String[] parts = param.split("_");
				int sectionId = Integer.parseInt(parts[0]);
				sectionIds.add(sectionId);
			}
		}
		return sectionIds;
	}

}
