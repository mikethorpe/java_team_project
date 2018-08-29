package controllers;

import db.DBArticle;
import db.DBHelper;
import models.Article;
import models.Author;
import models.Section;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

	public static void main(String[] args) {

        //location of static files - .css, images, etc
        staticFileLocation("/public");

		//setup
		setupEndPoints();

		// Controllers
		AuthorController authorController = new AuthorController();
		ArticleController articleController = new ArticleController();
		SectionsController sectionsController = new SectionsController();
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

		// Seeds
		// Set up sections
		Section section1 = new Section("Home");
		DBHelper.save(section1);

		Section section2 = new Section("Art");
		DBHelper.save(section2);

		Section section3 = new Section("Sport");
		DBHelper.save(section3);

        Section section4 = new Section("Cooking");
        DBHelper.save(section4);

        Section section5 = new Section("Environment");
        DBHelper.save(section5);


		List<Section> home = new ArrayList<>();
		home.add(section1);

		List<Section> artSections = new ArrayList<>();
		artSections.add(section2);

        List<Section> sportSections = new ArrayList<>();
        sportSections.add(section3);

        List<Section> cookingSections = new ArrayList<>();
        artSections.add(section4);

        List<Section> environmentSections = new ArrayList<>();
        artSections.add(section5);

		// Set up authors
		Author author1 = new Author("Mike");
		DBHelper.save(author1);

		Author author2 = new Author("Molly");
		DBHelper.save(author2);

		// Set up sections

		Article article2 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",
	"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rutrum, arcu nec auctor ullamcorper, est " +
			"dui hendrerit purus, sit amet ullamcorper felis erat sit amet ex. Quisque ac tristique tortor. " +
			"Duis vel nulla ut enim mollis hendrerit vitae nec sem. Vivamus at rutrum diam, id mattis velit. " +
			"Suspendisse a metus auctor, consectetur lorem sed, pellentesque lectus. Suspendisse potenti. Nam " +
			"nunc eros, tincidunt et lacinia vitae, vulputate id justo. Vestibulum laoreet rhoncus pharetra. " +
			"Integer vitae tortor et risus pretium porttitor at nec massa. Ut tempor lectus a luctus congue. " +
			"Quisque a nibh sit amet erat rhoncus posuere. Aliquam tincidunt nisl mattis tristique eleifend. " +
			"Nunc ac dolor quis velit imperdiet auctor. Proin gravida libero quis elit aliquet viverra.\n " +
			"Donec facilisis, dui at congue porttitor, est ligula pulvinar quam, id vestibulum sem neque sit " +
			"amet dolor. Pellentesque elementum in mauris sed luctus. Proin a laoreet orci. Etiam a tortor sit " +
			"amet lacus sagittis consequat sit amet quis est. Curabitur malesuada eros non sem hendrerit, " +
			"non maximus urna interdum. Sed ac tortor molestie, malesuada risus sed, venenatis eros. Fusce " +
			"vestibulum urna nulla, at rutrum purus blandit a. Etiam nec eleifend ex. Ut feugiat dolor sit " +
			"amet enim dignissim, sed dapibus ligula commodo. Pellentesque nec lectus posuere, ultrices purus " +
			"quis, aliquam tellus. Integer non lacus neque. Mauris sed egestas eros, at fermentum lorem. Maecenas " +
			"dignissim aliquam fringilla.\n Etiam ac lobortis dui, eget porttitor magna. Fusce lacus libero, " +
			"efficitur eu ultrices eu, feugiat id nisl. Mauris dapibus sollicitudin magna, ac sagittis mauris " +
			"viverra eu. Suspendisse mattis enim blandit venenatis ultrices. Etiam neque felis, placerat eget " +
			"laoreet et, euismod id nunc. Vivamus nec faucibus eros. Nam ultrices erat eu nisi commodo lobortis" +
			". Ut blandit tellus ut ligula mattis malesuada at ut purus. Interdum et malesuada fames ac ante " +
			"ipsum primis in faucibus. Sed blandit blandit placerat. Donec vitae elit nec nisl mollis vestibulum " +
			"tempor ut lectus.\n" + "\n" + "Duis ut pulvinar velit. Nam cursus ac lectus vitae gravida. Donec " +
			"in suscipit est. Pellentesque nec risus aliquam lectus rhoncus sagittis. Nam pulvinar dolor et " +
			"risus condimentum, eget mattis tellus fermentum. Vestibulum ante ipsum primis in faucibus orci " +
			"luctus et ultrices posuere cubilia Curae; Curabitur in vestibulum metus, at commodo erat. Nunc " +
			"quis magna nec felis ornare lobortis ac sed ipsum. In non est convallis, laoreet elit quis, " +
			"fringilla odio. Nam et eros eu mauris rhoncus finibus ut ac dolor. Aliquam ac lorem consectetur, " +
			"pharetra sapien quis, convallis leo. Donec porttitor justo ac urna pretium, ac consequat lectus " +
			"ultricies.\n" + "\n" + "Nullam ac hendrerit massa, at ornare quam. Etiam pulvinar ante non felis " +
			"tincidunt, non euismod lectus accumsan. Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
			"Donec et mollis dui. Aenean turpis felis, mattis id malesuada sit amet, venenatis ac mauris. " +
			"Suspendisse luctus cursus tellus. Vestibulum feugiat magna sed bibendum posuere. Phasellus vel " +
			"ullamcorper lacus. Fusce vitae vestibulum elit. Aenean facilisis tempor tellus. Nunc condimentum " +
			"nisi purus, non porttitor orci molestie a.\n" + "\n",
			author2
		);
		article2.addView();
		article2.addView();
		article2.setImageLink("https://www.thehappycatsite.com/wp-content/uploads/2017/10/best-treats-for-kittens.jpg");
		article2.updateArticleDate();
		DBHelper.save(article2);

		Article article3 = new Article("\"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, " +
                "consectetur, adipisci velit...\"\n" +
                "\"There is no one who loves pain itself, who seeks after it and wants to have it, simply because " +
                "it is pain...\"", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ornare" +
                " mauris a nunc vestibulum, eu cursus nisi luctus. Suspendisse mattis ornare velit, sit amet vulputate" +
                " justo finibus sit amet. Suspendisse malesuada et lectus quis sollicitudin. Cras et mattis ante. Cras" +
                " viverra hendrerit consequat. Duis ornare, nunc eget consequat pellentesque, enim eros hendrerit magna," +
                " laoreet eleifend purus mi tempor purus. Duis eget enim sit amet diam pretium porta vitae ac metus." +
                " Mauris ullamcorper est sed bibendum facilisis. Aliquam blandit lobortis odio at ultrices. Vestibulum" +
                " ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Curabitur lorem tortor, " +
                "maximus et interdum sed, pharetra ut metus. Cras magna velit, cursus quis elit nec, ultricies mollis " +
                "leo. Proin nec mi velit. Maecenas eu enim nulla. Fusce laoreet pretium turpis vitae iaculis. Aenean " +
                "mi velit, dignissim ut enim in, consequat blandit neque.\n" +
                "\n" +
                "Nam tristique purus sit amet bibendum ullamcorper. Etiam urna risus, porttitor at consectetur " +
                "vitae, sagittis at nibh. Proin eget pulvinar justo. Curabitur a orci eu turpis vulputate viverra." +
                " Nulla auctor volutpat risus, a condimentum dui dapibus et. Integer consequat quis ante et auctor." +
                " Integer lectus dui, malesuada posuere nisl a, tristique varius eros. In non consequat odio. In " +
                "iaculis pharetra orci vitae pellentesque. Curabitur nisl dui, pharetra at nisi vitae, mollis dapibus " +
                "ante. Proin ornare diam in massa tristique elementum. Ut id lorem augue. Nam at semper tortor. Cras" +
                " sed maximus ex. Ut eget turpis sed elit aliquet placerat.\n" +
                "\n" +
                "Suspendisse scelerisque fermentum diam ut feugiat. Nunc at tristique libero. Phasellus vestibulum" +
                " nulla nulla, ut vulputate felis iaculis sodales. Curabitur porttitor tristique ex, cursus tempor" +
                " lectus interdum scelerisque. Vestibulum vitae risus libero. Duis ac leo id tortor cursus molestie." +
                " Nullam ac nisi varius ligula congue convallis vel auctor ante. Aliquam consequat imperdiet " +
                "rhoncus.\n" +
                "\n" +
                "Mauris quis metus ipsum. Duis eget massa lectus. Interdum et malesuada fames ac ante ipsum primis" +
                " in faucibus. Vivamus et libero sed diam dapibus fermentum. Aliquam risus orci, tempus vitae " +
                "condimentum at, mattis eu libero. Aliquam elit risus, condimentum et ipsum nec, rhoncus ullamcorper " +
                "sem. Donec et magna non erat pharetra pretium id a arcu. Duis consectetur lectus quis mauris " +
                "tincidunt, nec volutpat leo ullamcorper. Aenean diam massa, commodo ac hendrerit sed, pulvinar" +
                " venenatis velit. Donec id est nec ipsum pulvinar placerat. Integer congue iaculis ante, at " +
                "mollis mauris pellentesque vel. Nam scelerisque placerat orci sit amet fringilla. Proin tincidunt " +
                "bibendum venenatis.\n" +
                "\n" +
                "Mauris quam urna, sagittis sed vehicula eu, eleifend commodo nibh. Vestibulum maximus consectetur" +
                " turpis. Fusce pellentesque mi eget neque semper bibendum. Etiam et diam leo. Nullam viverra, sapien " +
                "pretium malesuada bibendum, lorem sapien bibendum velit, non dapibus enim diam ut nisi. Nullam nec" +
                " pharetra arcu. In vel vehicula felis. Vestibulum ante ipsum primis in faucibus orci luctus et " +
                "ultrices posuere cubilia Curae; Sed dui lacus, dictum id auctor ac, tristique id tortor. Aliquam" +
                " sodales imperdiet semper. Curabitur in auctor leo, vitae aliquam turpis.", author2);
		article3.addView();
		article3.setImageLink("https://154013-475334-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads" +
                "/2018/06/cookingmatters_1080x1200-1024x640.jpg");
		article3.updateArticleDate();
		DBHelper.save(article3);


        Article article1 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet," +
                " consectetur, adipisci velit...", "Suspendisse posuere nunc eu massa " +
                "sodales faucibus. Vivamus placerat, justo vitae ultricies sodales, felis eros facilisis nisl, " +
                "at porta leo turpis ac massa. Suspendisse ut finibus purus. In dignissim lectus ac ornare feugiat. " +
                "Nam semper mauris at quam egestas euismod. Morbi sodales dolor sed orci feugiat sollicitudin. Vivamus " +
                "lacinia mi ligula, vitae sagittis tortor elementum et. Maecenas consectetur turpis nec porta " +
                "condimentum. Vestibulum non nisi dolor. Mauris auctor magna id tincidunt varius. Mauris a " +
                "sollicitudin arcu. Curabitur rutrum, turpis ut interdum maximus, mi dui scelerisque elit, id" +
                " tincidunt dolor dui sollicitudin dui. Pellentesque quis convallis orci.\n" +
                "\n" +
                "Nullam at turpis in leo consequat sodales nec a est. Vestibulum nisl nunc, scelerisque feugiat " +
                "tempor vitae, dapibus ut mauris. Curabitur ut tristique justo. Vestibulum ultrices interdum " +
                "ligula, in efficitur sem blandit ut. Mauris vel metus rutrum, tincidunt est at, efficitur sapien. " +
                "Proin sagittis semper congue. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc sit " +
                "amet varius magna. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per " +
                "inceptos himenaeos. Aenean dignissim laoreet congue.\n" +
                "\n" +
                "Pellentesque sit amet magna quis lectus iaculis sagittis scelerisque quis purus. Mauris aliquam" +
                " lectus mauris, at eleifend sapien blandit rutrum. Fusce lectus libero, facilisis a tortor non, " +
                "suscipit molestie neque. Nulla egestas non mauris lobortis dictum. Aliquam eu pharetra orci. Mauris " +
                "vulputate non libero ac imperdiet. Cras imperdiet nulla in dolor sagittis, vel egestas tortor " +
                "scelerisque. Maecenas auctor neque blandit dui elementum cursus. Duis et iaculis mi.", author1);
		article1.updateArticleDate();
		article1.addView();
		article1.addView();
		article1.addView();
        article1.setImageLink("https://www.incimages.com/uploaded_files/image/970x450/getty_517129164_279516.jpg");
		DBHelper.save(article1);

        DBArticle.updateArticlesSections(article2, home);
        DBArticle.updateArticlesSections(article3, cookingSections);
        DBArticle.updateArticlesSections(article1, environmentSections);





    }

}

