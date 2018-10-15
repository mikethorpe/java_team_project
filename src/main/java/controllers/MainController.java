package controllers;

import db.DBArticle;
import db.DBHelper;
import models.Article;
import models.Author;
import models.Section;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;
import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

	public static void main(String[] args) {

		port(getHerokuAssignedPort());

        //location of static files - .css, images, etc
        staticFileLocation("/public");

		//setup
		setupEndPoints();

		// Controllers
		AuthorController authorController = new AuthorController();
		ArticleController articleController = new ArticleController();
		SectionsController sectionsController = new SectionsController();
	}

	static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
	}

	private static void	setupEndPoints(){

		//Redirects to main section on frontend
		get("/", (req, res) -> {
			res.redirect("/sections/1");
			return null;
			}, new VelocityTemplateEngine()
		);

		//Redirects to articles on backend section
		get("/admin", (req, res) -> {
					res.redirect("/articles");
					return null;
				}, new VelocityTemplateEngine()
		);

//		// Seeds
//		// Set up sections
//		Section section1 = new Section("Home");
//		DBHelper.save(section1);
//
//		Section section2 = new Section("Art");
//		DBHelper.save(section2);
//
//		Section section3 = new Section("Environment");
//		DBHelper.save(section1);
//
//
//		List<Section> home = new ArrayList<>();
//		home.add(section1);
//
//		List<Section> artSections = new ArrayList<>();
//		artSections.add(section2);
//
//		// Set up authors
//		Author author1 = new Author("Mike");
//		DBHelper.save(author1);
//
//		Author author2 = new Author("Molly");
//		DBHelper.save(author2);
//
//		// Set up sections
//
//		Article article2 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",
//	"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rutrum, arcu nec auctor ullamcorper, est " +
//			"dui hendrerit purus, sit amet ullamcorper felis erat sit amet ex. Quisque ac tristique tortor. " +
//			"Duis vel nulla ut enim mollis hendrerit vitae nec sem. Vivamus at rutrum diam, id mattis velit. " +
//			"Suspendisse a metus auctor, consectetur lorem sed, pellentesque lectus. Suspendisse potenti. Nam " +
//			"nunc eros, tincidunt et lacinia vitae, vulputate id justo. Vestibulum laoreet rhoncus pharetra. " +
//			"Integer vitae tortor et risus pretium porttitor at nec massa. Ut tempor lectus a luctus congue. " +
//			"Quisque a nibh sit amet erat rhoncus posuere. Aliquam tincidunt nisl mattis tristique eleifend. " +
//			"Nunc ac dolor quis velit imperdiet auctor. Proin gravida libero quis elit aliquet viverra.\n " +
//			"Donec facilisis, dui at congue porttitor, est ligula pulvinar quam, id vestibulum sem neque sit " +
//			"amet dolor. Pellentesque elementum in mauris sed luctus. Proin a laoreet orci. Etiam a tortor sit " +
//			"amet lacus sagittis consequat sit amet quis est. Curabitur malesuada eros non sem hendrerit, " +
//			"non maximus urna interdum. Sed ac tortor molestie, malesuada risus sed, venenatis eros. Fusce " +
//			"vestibulum urna nulla, at rutrum purus blandit a. Etiam nec eleifend ex. Ut feugiat dolor sit " +
//			"amet enim dignissim, sed dapibus ligula commodo. Pellentesque nec lectus posuere, ultrices purus " +
//			"quis, aliquam tellus. Integer non lacus neque. Mauris sed egestas eros, at fermentum lorem. Maecenas " +
//			"dignissim aliquam fringilla.\n Etiam ac lobortis dui, eget porttitor magna. Fusce lacus libero, " +
//			"efficitur eu ultrices eu, feugiat id nisl. Mauris dapibus sollicitudin magna, ac sagittis mauris " +
//			"viverra eu. Suspendisse mattis enim blandit venenatis ultrices. Etiam neque felis, placerat eget " +
//			"laoreet et, euismod id nunc. Vivamus nec faucibus eros. Nam ultrices erat eu nisi commodo lobortis" +
//			". Ut blandit tellus ut ligula mattis malesuada at ut purus. Interdum et malesuada fames ac ante " +
//			"ipsum primis in faucibus. Sed blandit blandit placerat. Donec vitae elit nec nisl mollis vestibulum " +
//			"tempor ut lectus.\n" + "\n" + "Duis ut pulvinar velit. Nam cursus ac lectus vitae gravida. Donec " +
//			"in suscipit est. Pellentesque nec risus aliquam lectus rhoncus sagittis. Nam pulvinar dolor et " +
//			"risus condimentum, eget mattis tellus fermentum. Vestibulum ante ipsum primis in faucibus orci " +
//			"luctus et ultrices posuere cubilia Curae; Curabitur in vestibulum metus, at commodo erat. Nunc " +
//			"quis magna nec felis ornare lobortis ac sed ipsum. In non est convallis, laoreet elit quis, " +
//			"fringilla odio. Nam et eros eu mauris rhoncus finibus ut ac dolor. Aliquam ac lorem consectetur, " +
//			"pharetra sapien quis, convallis leo. Donec porttitor justo ac urna pretium, ac consequat lectus " +
//			"ultricies.\n" + "\n" + "Nullam ac hendrerit massa, at ornare quam. Etiam pulvinar ante non felis " +
//			"tincidunt, non euismod lectus accumsan. Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
//			"Donec et mollis dui. Aenean turpis felis, mattis id malesuada sit amet, venenatis ac mauris. " +
//			"Suspendisse luctus cursus tellus. Vestibulum feugiat magna sed bibendum posuere. Phasellus vel " +
//			"ullamcorper lacus. Fusce vitae vestibulum elit. Aenean facilisis tempor tellus. Nunc condimentum " +
//			"nisi purus, non porttitor orci molestie a.\n" + "\n",
//			author2
//		);
//		article2.addView();
//		article2.addView();
//		article2.setImageLink("https://www.thehappycatsite.com/wp-content/uploads/2017/10/best-treats-for-kittens.jpg");
//		article2.updateArticleDate();
//		DBHelper.save(article2);
//
//		Article article3 = new Article("Article3 title", "Article 3 content", author2);
//		article3.addView();
//		article3.updateArticleDate();
//		DBHelper.save(article3);
//
//		Article article1 = new Article("Article1 title", "Article 1 content", author1);
//		article1.updateArticleDate();
//		article1.addView();
//		article1.addView();
//		article1.addView();
//		DBHelper.save(article1);
//
//
//		DBArticle.updateArticlesSections(article1, home);
//		DBArticle.updateArticlesSections(article2, home);
//		DBArticle.updateArticlesSections(article3, artSections);
	}

}

