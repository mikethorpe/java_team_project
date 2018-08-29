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
//		Section section1 = new Section("Home");
//		DBHelper.save(section1);
//
//		Section section2 = new Section("Art");
//		DBHelper.save(section2);
//
//		Section section3 = new Section("Sport");
//		DBHelper.save(section3);
//
//        Section section4 = new Section("Cooking");
//        DBHelper.save(section4);
//
//        Section section5 = new Section("Environment");
//        DBHelper.save(section5);
//
//
//		List<Section> home = new ArrayList<>();
//		home.add(section1);
//
//		List<Section> artSections = new ArrayList<>();
//		artSections.add(section2);
//
//        List<Section> sportSections = new ArrayList<>();
//        sportSections.add(section3);
//
//        List<Section> cookingSections = new ArrayList<>();
//        artSections.add(section4);
//
//        List<Section> environmentSections = new ArrayList<>();
//        artSections.add(section5);
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
//        Article article1 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet," +
//                " consectetur, adipisci velit...", "Suspendisse posuere nunc eu massa " +
//                "sodales faucibus. Vivamus placerat, justo vitae ultricies sodales, felis eros facilisis nisl, " +
//                "at porta leo turpis ac massa. Suspendisse ut finibus purus. In dignissim lectus ac ornare feugiat. " +
//                "Nam semper mauris at quam egestas euismod. Morbi sodales dolor sed orci feugiat sollicitudin. Vivamus " +
//                "lacinia mi ligula, vitae sagittis tortor elementum et. Maecenas consectetur turpis nec porta " +
//                "condimentum. Vestibulum non nisi dolor. Mauris auctor magna id tincidunt varius. Mauris a " +
//                "sollicitudin arcu. Curabitur rutrum, turpis ut interdum maximus, mi dui scelerisque elit, id" +
//                " tincidunt dolor dui sollicitudin dui. Pellentesque quis convallis orci.\n" +
//                "\n" +
//                "Nullam at turpis in leo consequat sodales nec a est. Vestibulum nisl nunc, scelerisque feugiat " +
//                "tempor vitae, dapibus ut mauris. Curabitur ut tristique justo. Vestibulum ultrices interdum " +
//                "ligula, in efficitur sem blandit ut. Mauris vel metus rutrum, tincidunt est at, efficitur sapien. " +
//                "Proin sagittis semper congue. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc sit " +
//                "amet varius magna. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per " +
//                "inceptos himenaeos. Aenean dignissim laoreet congue.\n" +
//                "\n" +
//                "Pellentesque sit amet magna quis lectus iaculis sagittis scelerisque quis purus. Mauris aliquam" +
//                " lectus mauris, at eleifend sapien blandit rutrum. Fusce lectus libero, facilisis a tortor non, " +
//                "suscipit molestie neque. Nulla egestas non mauris lobortis dictum. Aliquam eu pharetra orci. Mauris " +
//                "vulputate non libero ac imperdiet. Cras imperdiet nulla in dolor sagittis, vel egestas tortor " +
//                "scelerisque. Maecenas auctor neque blandit dui elementum cursus. Duis et iaculis mi.", author1);
//        article1.updateArticleDate();
//        article1.addView();
//        article1.addView();
//        article1.addView();
//        article1.setImageLink("https://www.incimages.com/uploaded_files/image/970x450/getty_517129164_279516.jpg");
//        DBHelper.save(article1);
//
//
//
//
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
//		Article article3 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, " +
//                "consectetur, adipisci velit..." +
//                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because " +
//                "it is pain...", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ornare" +
//                " mauris a nunc vestibulum, eu cursus nisi luctus. Suspendisse mattis ornare velit, sit amet vulputate" +
//                " justo finibus sit amet. Suspendisse malesuada et lectus quis sollicitudin. Cras et mattis ante. Cras" +
//                " viverra hendrerit consequat. Duis ornare, nunc eget consequat pellentesque, enim eros hendrerit magna," +
//                " laoreet eleifend purus mi tempor purus. Duis eget enim sit amet diam pretium porta vitae ac metus." +
//                " Mauris ullamcorper est sed bibendum facilisis. Aliquam blandit lobortis odio at ultrices. Vestibulum" +
//                " ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Curabitur lorem tortor, " +
//                "maximus et interdum sed, pharetra ut metus. Cras magna velit, cursus quis elit nec, ultricies mollis " +
//                "leo. Proin nec mi velit. Maecenas eu enim nulla. Fusce laoreet pretium turpis vitae iaculis. Aenean " +
//                "mi velit, dignissim ut enim in, consequat blandit neque.\n" +
//                "\n" +
//                "Nam tristique purus sit amet bibendum ullamcorper. Etiam urna risus, porttitor at consectetur " +
//                "vitae, sagittis at nibh. Proin eget pulvinar justo. Curabitur a orci eu turpis vulputate viverra." +
//                " Nulla auctor volutpat risus, a condimentum dui dapibus et. Integer consequat quis ante et auctor." +
//                " Integer lectus dui, malesuada posuere nisl a, tristique varius eros. In non consequat odio. In " +
//                "iaculis pharetra orci vitae pellentesque. Curabitur nisl dui, pharetra at nisi vitae, mollis dapibus " +
//                "ante. Proin ornare diam in massa tristique elementum. Ut id lorem augue. Nam at semper tortor. Cras" +
//                " sed maximus ex. Ut eget turpis sed elit aliquet placerat.\n" +
//                "\n" +
//                "Suspendisse scelerisque fermentum diam ut feugiat. Nunc at tristique libero. Phasellus vestibulum" +
//                " nulla nulla, ut vulputate felis iaculis sodales. Curabitur porttitor tristique ex, cursus tempor" +
//                " lectus interdum scelerisque. Vestibulum vitae risus libero. Duis ac leo id tortor cursus molestie." +
//                " Nullam ac nisi varius ligula congue convallis vel auctor ante. Aliquam consequat imperdiet " +
//                "rhoncus.\n" +
//                "\n" +
//                "Mauris quis metus ipsum. Duis eget massa lectus. Interdum et malesuada fames ac ante ipsum primis" +
//                " in faucibus. Vivamus et libero sed diam dapibus fermentum. Aliquam risus orci, tempus vitae " +
//                "condimentum at, mattis eu libero. Aliquam elit risus, condimentum et ipsum nec, rhoncus ullamcorper " +
//                "sem. Donec et magna non erat pharetra pretium id a arcu. Duis consectetur lectus quis mauris " +
//                "tincidunt, nec volutpat leo ullamcorper. Aenean diam massa, commodo ac hendrerit sed, pulvinar" +
//                " venenatis velit. Donec id est nec ipsum pulvinar placerat. Integer congue iaculis ante, at " +
//                "mollis mauris pellentesque vel. Nam scelerisque placerat orci sit amet fringilla. Proin tincidunt " +
//                "bibendum venenatis.\n" +
//                "\n" +
//                "Mauris quam urna, sagittis sed vehicula eu, eleifend commodo nibh. Vestibulum maximus consectetur" +
//                " turpis. Fusce pellentesque mi eget neque semper bibendum. Etiam et diam leo. Nullam viverra, sapien " +
//                "pretium malesuada bibendum, lorem sapien bibendum velit, non dapibus enim diam ut nisi. Nullam nec" +
//                " pharetra arcu. In vel vehicula felis. Vestibulum ante ipsum primis in faucibus orci luctus et " +
//                "ultrices posuere cubilia Curae; Sed dui lacus, dictum id auctor ac, tristique id tortor. Aliquam" +
//                " sodales imperdiet semper. Curabitur in auctor leo, vitae aliquam turpis.", author2);
//		article3.addView();
//		article3.setImageLink("https://154013-475334-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads" +
//                "/2018/06/cookingmatters_1080x1200-1024x640.jpg");
//		article3.updateArticleDate();
//		DBHelper.save(article3);
//
//        Article article4 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, " +
//                "consectetur, adipisci velit..." +
//                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because " +
//                "it is pain...", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ornare" +
//                " mauris a nunc vestibulum, eu cursus nisi luctus. Suspendisse mattis ornare velit, sit amet vulputate" +
//                " justo finibus sit amet. Suspendisse malesuada et lectus quis sollicitudin. Cras et mattis ante. Cras" +
//                " viverra hendrerit consequat. Duis ornare, nunc eget consequat pellentesque, enim eros hendrerit magna," +
//                " laoreet eleifend purus mi tempor purus. Duis eget enim sit amet diam pretium porta vitae ac metus." +
//                " Mauris ullamcorper est sed bibendum facilisis. Aliquam blandit lobortis odio at ultrices. Vestibulum" +
//                " ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Curabitur lorem tortor, " +
//                "maximus et interdum sed, pharetra ut metus. Cras magna velit, cursus quis elit nec, ultricies mollis " +
//                "leo. Proin nec mi velit. Maecenas eu enim nulla. Fusce laoreet pretium turpis vitae iaculis. Aenean " +
//                "mi velit, dignissim ut enim in, consequat blandit neque.\n" +
//                "\n" +
//                "Nam tristique purus sit amet bibendum ullamcorper. Etiam urna risus, porttitor at consectetur " +
//                "vitae, sagittis at nibh. Proin eget pulvinar justo. Curabitur a orci eu turpis vulputate viverra." +
//                " Nulla auctor volutpat risus, a condimentum dui dapibus et. Integer consequat quis ante et auctor." +
//                " Integer lectus dui, malesuada posuere nisl a, tristique varius eros. In non consequat odio. In " +
//                "iaculis pharetra orci vitae pellentesque. Curabitur nisl dui, pharetra at nisi vitae, mollis dapibus " +
//                "ante. Proin ornare diam in massa tristique elementum. Ut id lorem augue. Nam at semper tortor. Cras" +
//                " sed maximus ex. Ut eget turpis sed elit aliquet placerat.\n" +
//                "\n" +
//                "Suspendisse scelerisque fermentum diam ut feugiat. Nunc at tristique libero. Phasellus vestibulum" +
//                " nulla nulla, ut vulputate felis iaculis sodales. Curabitur porttitor tristique ex, cursus tempor" +
//                " lectus interdum scelerisque. Vestibulum vitae risus libero. Duis ac leo id tortor cursus molestie." +
//                " Nullam ac nisi varius ligula congue convallis vel auctor ante. Aliquam consequat imperdiet " +
//                "rhoncus.\n" +
//                "\n" +
//                "Mauris quis metus ipsum. Duis eget massa lectus. Interdum et malesuada fames ac ante ipsum primis" +
//                " in faucibus. Vivamus et libero sed diam dapibus fermentum. Aliquam risus orci, tempus vitae " +
//                "condimentum at, mattis eu libero. Aliquam elit risus, condimentum et ipsum nec, rhoncus ullamcorper " +
//                "sem. Donec et magna non erat pharetra pretium id a arcu. Duis consectetur lectus quis mauris " +
//                "tincidunt, nec volutpat leo ullamcorper. Aenean diam massa, commodo ac hendrerit sed, pulvinar" +
//                " venenatis velit. Donec id est nec ipsum pulvinar placerat. Integer congue iaculis ante, at " +
//                "mollis mauris pellentesque vel. Nam scelerisque placerat orci sit amet fringilla. Proin tincidunt " +
//                "bibendum venenatis.\n" +
//                "\n" +
//                "Mauris quam urna, sagittis sed vehicula eu, eleifend commodo nibh. Vestibulum maximus consectetur" +
//                " turpis. Fusce pellentesque mi eget neque semper bibendum. Etiam et diam leo. Nullam viverra, sapien " +
//                "pretium malesuada bibendum, lorem sapien bibendum velit, non dapibus enim diam ut nisi. Nullam nec" +
//                " pharetra arcu. In vel vehicula felis. Vestibulum ante ipsum primis in faucibus orci luctus et " +
//                "ultrices posuere cubilia Curae; Sed dui lacus, dictum id auctor ac, tristique id tortor. Aliquam" +
//                " sodales imperdiet semper. Curabitur in auctor leo, vitae aliquam turpis.", author2);
//        article4.addView();
//        article4.setImageLink("https://154013-475334-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads" +
//                "/2018/06/cookingmatters_1080x1200-1024x640.jpg");
//        article4.updateArticleDate();
//        DBHelper.save(article4);
//
//        Article article5 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, " +
//                "consectetur, adipisci velit..." +
//                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because " +
//                "it is pain...", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ornare" +
//                " mauris a nunc vestibulum, eu cursus nisi luctus. Suspendisse mattis ornare velit, sit amet vulputate" +
//                " justo finibus sit amet. Suspendisse malesuada et lectus quis sollicitudin. Cras et mattis ante. Cras" +
//                " viverra hendrerit consequat. Duis ornare, nunc eget consequat pellentesque, enim eros hendrerit magna," +
//                " laoreet eleifend purus mi tempor purus. Duis eget enim sit amet diam pretium porta vitae ac metus." +
//                " Mauris ullamcorper est sed bibendum facilisis. Aliquam blandit lobortis odio at ultrices. Vestibulum" +
//                " ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Curabitur lorem tortor, " +
//                "maximus et interdum sed, pharetra ut metus. Cras magna velit, cursus quis elit nec, ultricies mollis " +
//                "leo. Proin nec mi velit. Maecenas eu enim nulla. Fusce laoreet pretium turpis vitae iaculis. Aenean " +
//                "mi velit, dignissim ut enim in, consequat blandit neque.\n" +
//                "\n" +
//                "Nam tristique purus sit amet bibendum ullamcorper. Etiam urna risus, porttitor at consectetur " +
//                "vitae, sagittis at nibh. Proin eget pulvinar justo. Curabitur a orci eu turpis vulputate viverra." +
//                " Nulla auctor volutpat risus, a condimentum dui dapibus et. Integer consequat quis ante et auctor." +
//                " Integer lectus dui, malesuada posuere nisl a, tristique varius eros. In non consequat odio. In " +
//                "iaculis pharetra orci vitae pellentesque. Curabitur nisl dui, pharetra at nisi vitae, mollis dapibus " +
//                "ante. Proin ornare diam in massa tristique elementum. Ut id lorem augue. Nam at semper tortor. Cras" +
//                " sed maximus ex. Ut eget turpis sed elit aliquet placerat.\n" +
//                "\n" +
//                "Suspendisse scelerisque fermentum diam ut feugiat. Nunc at tristique libero. Phasellus vestibulum" +
//                " nulla nulla, ut vulputate felis iaculis sodales. Curabitur porttitor tristique ex, cursus tempor" +
//                " lectus interdum scelerisque. Vestibulum vitae risus libero. Duis ac leo id tortor cursus molestie." +
//                " Nullam ac nisi varius ligula congue convallis vel auctor ante. Aliquam consequat imperdiet " +
//                "rhoncus.\n" +
//                "\n" +
//                "Mauris quis metus ipsum. Duis eget massa lectus. Interdum et malesuada fames ac ante ipsum primis" +
//                " in faucibus. Vivamus et libero sed diam dapibus fermentum. Aliquam risus orci, tempus vitae " +
//                "condimentum at, mattis eu libero. Aliquam elit risus, condimentum et ipsum nec, rhoncus ullamcorper " +
//                "sem. Donec et magna non erat pharetra pretium id a arcu. Duis consectetur lectus quis mauris " +
//                "tincidunt, nec volutpat leo ullamcorper. Aenean diam massa, commodo ac hendrerit sed, pulvinar" +
//                " venenatis velit. Donec id est nec ipsum pulvinar placerat. Integer congue iaculis ante, at " +
//                "mollis mauris pellentesque vel. Nam scelerisque placerat orci sit amet fringilla. Proin tincidunt " +
//                "bibendum venenatis.\n" +
//                "\n" +
//                "Mauris quam urna, sagittis sed vehicula eu, eleifend commodo nibh. Vestibulum maximus consectetur" +
//                " turpis. Fusce pellentesque mi eget neque semper bibendum. Etiam et diam leo. Nullam viverra, sapien " +
//                "pretium malesuada bibendum, lorem sapien bibendum velit, non dapibus enim diam ut nisi. Nullam nec" +
//                " pharetra arcu. In vel vehicula felis. Vestibulum ante ipsum primis in faucibus orci luctus et " +
//                "ultrices posuere cubilia Curae; Sed dui lacus, dictum id auctor ac, tristique id tortor. Aliquam" +
//                " sodales imperdiet semper. Curabitur in auctor leo, vitae aliquam turpis.", author2);
//        article5.addView();
//        article5.setImageLink("https://154013-475334-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads" +
//                "/2018/06/cookingmatters_1080x1200-1024x640.jpg");
//        article5.updateArticleDate();
//        DBHelper.save(article5);
//
//        Article article6 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, " +
//                "consectetur, adipisci velit..." +
//                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because " +
//                "it is pain...", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ornare" +
//                " mauris a nunc vestibulum, eu cursus nisi luctus. Suspendisse mattis ornare velit, sit amet vulputate" +
//                " justo finibus sit amet. Suspendisse malesuada et lectus quis sollicitudin. Cras et mattis ante. Cras" +
//                " viverra hendrerit consequat. Duis ornare, nunc eget consequat pellentesque, enim eros hendrerit magna," +
//                " laoreet eleifend purus mi tempor purus. Duis eget enim sit amet diam pretium porta vitae ac metus." +
//                " Mauris ullamcorper est sed bibendum facilisis. Aliquam blandit lobortis odio at ultrices. Vestibulum" +
//                " ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Curabitur lorem tortor, " +
//                "maximus et interdum sed, pharetra ut metus. Cras magna velit, cursus quis elit nec, ultricies mollis " +
//                "leo. Proin nec mi velit. Maecenas eu enim nulla. Fusce laoreet pretium turpis vitae iaculis. Aenean " +
//                "mi velit, dignissim ut enim in, consequat blandit neque.\n" +
//                "\n" +
//                "Nam tristique purus sit amet bibendum ullamcorper. Etiam urna risus, porttitor at consectetur " +
//                "vitae, sagittis at nibh. Proin eget pulvinar justo. Curabitur a orci eu turpis vulputate viverra." +
//                " Nulla auctor volutpat risus, a condimentum dui dapibus et. Integer consequat quis ante et auctor." +
//                " Integer lectus dui, malesuada posuere nisl a, tristique varius eros. In non consequat odio. In " +
//                "iaculis pharetra orci vitae pellentesque. Curabitur nisl dui, pharetra at nisi vitae, mollis dapibus " +
//                "ante. Proin ornare diam in massa tristique elementum. Ut id lorem augue. Nam at semper tortor. Cras" +
//                " sed maximus ex. Ut eget turpis sed elit aliquet placerat.\n" +
//                "\n" +
//                "Suspendisse scelerisque fermentum diam ut feugiat. Nunc at tristique libero. Phasellus vestibulum" +
//                " nulla nulla, ut vulputate felis iaculis sodales. Curabitur porttitor tristique ex, cursus tempor" +
//                " lectus interdum scelerisque. Vestibulum vitae risus libero. Duis ac leo id tortor cursus molestie." +
//                " Nullam ac nisi varius ligula congue convallis vel auctor ante. Aliquam consequat imperdiet " +
//                "rhoncus.\n" +
//                "\n" +
//                "Mauris quis metus ipsum. Duis eget massa lectus. Interdum et malesuada fames ac ante ipsum primis" +
//                " in faucibus. Vivamus et libero sed diam dapibus fermentum. Aliquam risus orci, tempus vitae " +
//                "condimentum at, mattis eu libero. Aliquam elit risus, condimentum et ipsum nec, rhoncus ullamcorper " +
//                "sem. Donec et magna non erat pharetra pretium id a arcu. Duis consectetur lectus quis mauris " +
//                "tincidunt, nec volutpat leo ullamcorper. Aenean diam massa, commodo ac hendrerit sed, pulvinar" +
//                " venenatis velit. Donec id est nec ipsum pulvinar placerat. Integer congue iaculis ante, at " +
//                "mollis mauris pellentesque vel. Nam scelerisque placerat orci sit amet fringilla. Proin tincidunt " +
//                "bibendum venenatis.\n" +
//                "\n" +
//                "Mauris quam urna, sagittis sed vehicula eu, eleifend commodo nibh. Vestibulum maximus consectetur" +
//                " turpis. Fusce pellentesque mi eget neque semper bibendum. Etiam et diam leo. Nullam viverra, sapien " +
//                "pretium malesuada bibendum, lorem sapien bibendum velit, non dapibus enim diam ut nisi. Nullam nec" +
//                " pharetra arcu. In vel vehicula felis. Vestibulum ante ipsum primis in faucibus orci luctus et " +
//                "ultrices posuere cubilia Curae; Sed dui lacus, dictum id auctor ac, tristique id tortor. Aliquam" +
//                " sodales imperdiet semper. Curabitur in auctor leo, vitae aliquam turpis.", author2);
//        article6.addView();
//        article6.setImageLink("https://154013-475334-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads" +
//                "/2018/06/cookingmatters_1080x1200-1024x640.jpg");
//        article6.updateArticleDate();
//        DBHelper.save(article6);
//
//        Article article7 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, " +
//                "consectetur, adipisci velit..." +
//                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because " +
//                "it is pain...", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ornare" +
//                " mauris a nunc vestibulum, eu cursus nisi luctus. Suspendisse mattis ornare velit, sit amet vulputate" +
//                " justo finibus sit amet. Suspendisse malesuada et lectus quis sollicitudin. Cras et mattis ante. Cras" +
//                " viverra hendrerit consequat. Duis ornare, nunc eget consequat pellentesque, enim eros hendrerit magna," +
//                " laoreet eleifend purus mi tempor purus. Duis eget enim sit amet diam pretium porta vitae ac metus." +
//                " Mauris ullamcorper est sed bibendum facilisis. Aliquam blandit lobortis odio at ultrices. Vestibulum" +
//                " ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Curabitur lorem tortor, " +
//                "maximus et interdum sed, pharetra ut metus. Cras magna velit, cursus quis elit nec, ultricies mollis " +
//                "leo. Proin nec mi velit. Maecenas eu enim nulla. Fusce laoreet pretium turpis vitae iaculis. Aenean " +
//                "mi velit, dignissim ut enim in, consequat blandit neque.\n" +
//                "\n" +
//                "Nam tristique purus sit amet bibendum ullamcorper. Etiam urna risus, porttitor at consectetur " +
//                "vitae, sagittis at nibh. Proin eget pulvinar justo. Curabitur a orci eu turpis vulputate viverra." +
//                " Nulla auctor volutpat risus, a condimentum dui dapibus et. Integer consequat quis ante et auctor." +
//                " Integer lectus dui, malesuada posuere nisl a, tristique varius eros. In non consequat odio. In " +
//                "iaculis pharetra orci vitae pellentesque. Curabitur nisl dui, pharetra at nisi vitae, mollis dapibus " +
//                "ante. Proin ornare diam in massa tristique elementum. Ut id lorem augue. Nam at semper tortor. Cras" +
//                " sed maximus ex. Ut eget turpis sed elit aliquet placerat.\n" +
//                "\n" +
//                "Suspendisse scelerisque fermentum diam ut feugiat. Nunc at tristique libero. Phasellus vestibulum" +
//                " nulla nulla, ut vulputate felis iaculis sodales. Curabitur porttitor tristique ex, cursus tempor" +
//                " lectus interdum scelerisque. Vestibulum vitae risus libero. Duis ac leo id tortor cursus molestie." +
//                " Nullam ac nisi varius ligula congue convallis vel auctor ante. Aliquam consequat imperdiet " +
//                "rhoncus.\n" +
//                "\n" +
//                "Mauris quis metus ipsum. Duis eget massa lectus. Interdum et malesuada fames ac ante ipsum primis" +
//                " in faucibus. Vivamus et libero sed diam dapibus fermentum. Aliquam risus orci, tempus vitae " +
//                "condimentum at, mattis eu libero. Aliquam elit risus, condimentum et ipsum nec, rhoncus ullamcorper " +
//                "sem. Donec et magna non erat pharetra pretium id a arcu. Duis consectetur lectus quis mauris " +
//                "tincidunt, nec volutpat leo ullamcorper. Aenean diam massa, commodo ac hendrerit sed, pulvinar" +
//                " venenatis velit. Donec id est nec ipsum pulvinar placerat. Integer congue iaculis ante, at " +
//                "mollis mauris pellentesque vel. Nam scelerisque placerat orci sit amet fringilla. Proin tincidunt " +
//                "bibendum venenatis.\n" +
//                "\n" +
//                "Mauris quam urna, sagittis sed vehicula eu, eleifend commodo nibh. Vestibulum maximus consectetur" +
//                " turpis. Fusce pellentesque mi eget neque semper bibendum. Etiam et diam leo. Nullam viverra, sapien " +
//                "pretium malesuada bibendum, lorem sapien bibendum velit, non dapibus enim diam ut nisi. Nullam nec" +
//                " pharetra arcu. In vel vehicula felis. Vestibulum ante ipsum primis in faucibus orci luctus et " +
//                "ultrices posuere cubilia Curae; Sed dui lacus, dictum id auctor ac, tristique id tortor. Aliquam" +
//                " sodales imperdiet semper. Curabitur in auctor leo, vitae aliquam turpis.", author2);
//        article7.addView();
//        article7.setImageLink("https://154013-475334-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads" +
//                "/2018/06/cookingmatters_1080x1200-1024x640.jpg");
//        article7.updateArticleDate();
//        DBHelper.save(article7);
//
//        Article article8 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, " +
//                "consectetur, adipisci velit..." +
//                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because " +
//                "it is pain...", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ornare" +
//                " mauris a nunc vestibulum, eu cursus nisi luctus. Suspendisse mattis ornare velit, sit amet vulputate" +
//                " justo finibus sit amet. Suspendisse malesuada et lectus quis sollicitudin. Cras et mattis ante. Cras" +
//                " viverra hendrerit consequat. Duis ornare, nunc eget consequat pellentesque, enim eros hendrerit magna," +
//                " laoreet eleifend purus mi tempor purus. Duis eget enim sit amet diam pretium porta vitae ac metus." +
//                " Mauris ullamcorper est sed bibendum facilisis. Aliquam blandit lobortis odio at ultrices. Vestibulum" +
//                " ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Curabitur lorem tortor, " +
//                "maximus et interdum sed, pharetra ut metus. Cras magna velit, cursus quis elit nec, ultricies mollis " +
//                "leo. Proin nec mi velit. Maecenas eu enim nulla. Fusce laoreet pretium turpis vitae iaculis. Aenean " +
//                "mi velit, dignissim ut enim in, consequat blandit neque.\n" +
//                "\n" +
//                "Nam tristique purus sit amet bibendum ullamcorper. Etiam urna risus, porttitor at consectetur " +
//                "vitae, sagittis at nibh. Proin eget pulvinar justo. Curabitur a orci eu turpis vulputate viverra." +
//                " Nulla auctor volutpat risus, a condimentum dui dapibus et. Integer consequat quis ante et auctor." +
//                " Integer lectus dui, malesuada posuere nisl a, tristique varius eros. In non consequat odio. In " +
//                "iaculis pharetra orci vitae pellentesque. Curabitur nisl dui, pharetra at nisi vitae, mollis dapibus " +
//                "ante. Proin ornare diam in massa tristique elementum. Ut id lorem augue. Nam at semper tortor. Cras" +
//                " sed maximus ex. Ut eget turpis sed elit aliquet placerat.\n" +
//                "\n" +
//                "Suspendisse scelerisque fermentum diam ut feugiat. Nunc at tristique libero. Phasellus vestibulum" +
//                " nulla nulla, ut vulputate felis iaculis sodales. Curabitur porttitor tristique ex, cursus tempor" +
//                " lectus interdum scelerisque. Vestibulum vitae risus libero. Duis ac leo id tortor cursus molestie." +
//                " Nullam ac nisi varius ligula congue convallis vel auctor ante. Aliquam consequat imperdiet " +
//                "rhoncus.\n" +
//                "\n" +
//                "Mauris quis metus ipsum. Duis eget massa lectus. Interdum et malesuada fames ac ante ipsum primis" +
//                " in faucibus. Vivamus et libero sed diam dapibus fermentum. Aliquam risus orci, tempus vitae " +
//                "condimentum at, mattis eu libero. Aliquam elit risus, condimentum et ipsum nec, rhoncus ullamcorper " +
//                "sem. Donec et magna non erat pharetra pretium id a arcu. Duis consectetur lectus quis mauris " +
//                "tincidunt, nec volutpat leo ullamcorper. Aenean diam massa, commodo ac hendrerit sed, pulvinar" +
//                " venenatis velit. Donec id est nec ipsum pulvinar placerat. Integer congue iaculis ante, at " +
//                "mollis mauris pellentesque vel. Nam scelerisque placerat orci sit amet fringilla. Proin tincidunt " +
//                "bibendum venenatis.\n" +
//                "\n" +
//                "Mauris quam urna, sagittis sed vehicula eu, eleifend commodo nibh. Vestibulum maximus consectetur" +
//                " turpis. Fusce pellentesque mi eget neque semper bibendum. Etiam et diam leo. Nullam viverra, sapien " +
//                "pretium malesuada bibendum, lorem sapien bibendum velit, non dapibus enim diam ut nisi. Nullam nec" +
//                " pharetra arcu. In vel vehicula felis. Vestibulum ante ipsum primis in faucibus orci luctus et " +
//                "ultrices posuere cubilia Curae; Sed dui lacus, dictum id auctor ac, tristique id tortor. Aliquam" +
//                " sodales imperdiet semper. Curabitur in auctor leo, vitae aliquam turpis.", author2);
//        article8.addView();
//        article8.setImageLink("https://154013-475334-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads" +
//                "/2018/06/cookingmatters_1080x1200-1024x640.jpg");
//        article8.updateArticleDate();
//        DBHelper.save(article8);
//
//        Article article9 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, " +
//                "consectetur, adipisci velit..." +
//                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because " +
//                "it is pain...", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ornare" +
//                " mauris a nunc vestibulum, eu cursus nisi luctus. Suspendisse mattis ornare velit, sit amet vulputate" +
//                " justo finibus sit amet. Suspendisse malesuada et lectus quis sollicitudin. Cras et mattis ante. Cras" +
//                " viverra hendrerit consequat. Duis ornare, nunc eget consequat pellentesque, enim eros hendrerit magna," +
//                " laoreet eleifend purus mi tempor purus. Duis eget enim sit amet diam pretium porta vitae ac metus." +
//                " Mauris ullamcorper est sed bibendum facilisis. Aliquam blandit lobortis odio at ultrices. Vestibulum" +
//                " ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Curabitur lorem tortor, " +
//                "maximus et interdum sed, pharetra ut metus. Cras magna velit, cursus quis elit nec, ultricies mollis " +
//                "leo. Proin nec mi velit. Maecenas eu enim nulla. Fusce laoreet pretium turpis vitae iaculis. Aenean " +
//                "mi velit, dignissim ut enim in, consequat blandit neque.\n" +
//                "\n" +
//                "Nam tristique purus sit amet bibendum ullamcorper. Etiam urna risus, porttitor at consectetur " +
//                "vitae, sagittis at nibh. Proin eget pulvinar justo. Curabitur a orci eu turpis vulputate viverra." +
//                " Nulla auctor volutpat risus, a condimentum dui dapibus et. Integer consequat quis ante et auctor." +
//                " Integer lectus dui, malesuada posuere nisl a, tristique varius eros. In non consequat odio. In " +
//                "iaculis pharetra orci vitae pellentesque. Curabitur nisl dui, pharetra at nisi vitae, mollis dapibus " +
//                "ante. Proin ornare diam in massa tristique elementum. Ut id lorem augue. Nam at semper tortor. Cras" +
//                " sed maximus ex. Ut eget turpis sed elit aliquet placerat.\n" +
//                "\n" +
//                "Suspendisse scelerisque fermentum diam ut feugiat. Nunc at tristique libero. Phasellus vestibulum" +
//                " nulla nulla, ut vulputate felis iaculis sodales. Curabitur porttitor tristique ex, cursus tempor" +
//                " lectus interdum scelerisque. Vestibulum vitae risus libero. Duis ac leo id tortor cursus molestie." +
//                " Nullam ac nisi varius ligula congue convallis vel auctor ante. Aliquam consequat imperdiet " +
//                "rhoncus.\n" +
//                "\n" +
//                "Mauris quis metus ipsum. Duis eget massa lectus. Interdum et malesuada fames ac ante ipsum primis" +
//                " in faucibus. Vivamus et libero sed diam dapibus fermentum. Aliquam risus orci, tempus vitae " +
//                "condimentum at, mattis eu libero. Aliquam elit risus, condimentum et ipsum nec, rhoncus ullamcorper " +
//                "sem. Donec et magna non erat pharetra pretium id a arcu. Duis consectetur lectus quis mauris " +
//                "tincidunt, nec volutpat leo ullamcorper. Aenean diam massa, commodo ac hendrerit sed, pulvinar" +
//                " venenatis velit. Donec id est nec ipsum pulvinar placerat. Integer congue iaculis ante, at " +
//                "mollis mauris pellentesque vel. Nam scelerisque placerat orci sit amet fringilla. Proin tincidunt " +
//                "bibendum venenatis.\n" +
//                "\n" +
//                "Mauris quam urna, sagittis sed vehicula eu, eleifend commodo nibh. Vestibulum maximus consectetur" +
//                " turpis. Fusce pellentesque mi eget neque semper bibendum. Etiam et diam leo. Nullam viverra, sapien " +
//                "pretium malesuada bibendum, lorem sapien bibendum velit, non dapibus enim diam ut nisi. Nullam nec" +
//                " pharetra arcu. In vel vehicula felis. Vestibulum ante ipsum primis in faucibus orci luctus et " +
//                "ultrices posuere cubilia Curae; Sed dui lacus, dictum id auctor ac, tristique id tortor. Aliquam" +
//                " sodales imperdiet semper. Curabitur in auctor leo, vitae aliquam turpis.", author2);
//        article9.addView();
//        article9.setImageLink("https://154013-475334-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads" +
//                "/2018/06/cookingmatters_1080x1200-1024x640.jpg");
//        article9.updateArticleDate();
//        DBHelper.save(article9);
//
//        Article article10 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."
//                ,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ornare" +
//                " mauris a nunc vestibulum, eu cursus nisi luctus. Suspendisse mattis ornare velit, sit amet vulputate" +
//                " justo finibus sit amet. Suspendisse malesuada et lectus quis sollicitudin. Cras et mattis ante. Cras" +
//                " viverra hendrerit consequat. Duis ornare, nunc eget consequat pellentesque, enim eros hendrerit magna," +
//                " laoreet eleifend purus mi tempor purus. Duis eget enim sit amet diam pretium porta vitae ac metus." +
//                " Mauris ullamcorper est sed bibendum facilisis. Aliquam blandit lobortis odio at ultrices. Vestibulum" +
//                " ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Curabitur lorem tortor, " +
//                "maximus et interdum sed, pharetra ut metus. Cras magna velit, cursus quis elit nec, ultricies mollis " +
//                "leo. Proin nec mi velit. Maecenas eu enim nulla. Fusce laoreet pretium turpis vitae iaculis. Aenean " +
//                "mi velit, dignissim ut enim in, consequat blandit neque.\n" +
//                "\n" +
//                "Nam tristique purus sit amet bibendum ullamcorper. Etiam urna risus, porttitor at consectetur " +
//                "vitae, sagittis at nibh. Proin eget pulvinar justo. Curabitur a orci eu turpis vulputate viverra." +
//                " Nulla auctor volutpat risus, a condimentum dui dapibus et. Integer consequat quis ante et auctor." +
//                " Integer lectus dui, malesuada posuere nisl a, tristique varius eros. In non consequat odio. In " +
//                "iaculis pharetra orci vitae pellentesque. Curabitur nisl dui, pharetra at nisi vitae, mollis dapibus " +
//                "ante. Proin ornare diam in massa tristique elementum. Ut id lorem augue. Nam at semper tortor. Cras" +
//                " sed maximus ex. Ut eget turpis sed elit aliquet placerat.\n" +
//                "\n" +
//                "Suspendisse scelerisque fermentum diam ut feugiat. Nunc at tristique libero. Phasellus vestibulum" +
//                " nulla nulla, ut vulputate felis iaculis sodales. Curabitur porttitor tristique ex, cursus tempor" +
//                " lectus interdum scelerisque. Vestibulum vitae risus libero. Duis ac leo id tortor cursus molestie." +
//                " Nullam ac nisi varius ligula congue convallis vel auctor ante. Aliquam consequat imperdiet " +
//                "rhoncus.\n" +
//                "\n" +
//                "Mauris quis metus ipsum. Duis eget massa lectus. Interdum et malesuada fames ac ante ipsum primis" +
//                " in faucibus. Vivamus et libero sed diam dapibus fermentum. Aliquam risus orci, tempus vitae " +
//                "condimentum at, mattis eu libero. Aliquam elit risus, condimentum et ipsum nec, rhoncus ullamcorper " +
//                "sem. Donec et magna non erat pharetra pretium id a arcu. Duis consectetur lectus quis mauris " +
//                "tincidunt, nec volutpat leo ullamcorper. Aenean diam massa, commodo ac hendrerit sed, pulvinar" +
//                " venenatis velit. Donec id est nec ipsum pulvinar placerat. Integer congue iaculis ante, at " +
//                "mollis mauris pellentesque vel. Nam scelerisque placerat orci sit amet fringilla. Proin tincidunt " +
//                "bibendum venenatis.\n" +
//                "\n" +
//                "Mauris quam urna, sagittis sed vehicula eu, eleifend commodo nibh. Vestibulum maximus consectetur" +
//                " turpis. Fusce pellentesque mi eget neque semper bibendum. Etiam et diam leo. Nullam viverra, sapien " +
//                "pretium malesuada bibendum, lorem sapien bibendum velit, non dapibus enim diam ut nisi. Nullam nec" +
//                " pharetra arcu. In vel vehicula felis. Vestibulum ante ipsum primis in faucibus orci luctus et " +
//                "ultrices posuere cubilia Curae; Sed dui lacus, dictum id auctor ac, tristique id tortor. Aliquam" +
//                " sodales imperdiet semper. Curabitur in auctor leo, vitae aliquam turpis.", author2);
//        article10.addView();
//        article10.setImageLink("https://154013-475334-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads" +
//                "/2018/06/cookingmatters_1080x1200-1024x640.jpg");
//        article10.updateArticleDate();
//        DBHelper.save(article10);
//
//
//        Article article11 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rutrum, arcu nec auctor ullamcorper, est " +
//                        "dui hendrerit purus, sit amet ullamcorper felis erat sit amet ex. Quisque ac tristique tortor. " +
//                        "Duis vel nulla ut enim mollis hendrerit vitae nec sem. Vivamus at rutrum diam, id mattis velit. " +
//                        "Suspendisse a metus auctor, consectetur lorem sed, pellentesque lectus. Suspendisse potenti. Nam " +
//                        "nunc eros, tincidunt et lacinia vitae, vulputate id justo. Vestibulum laoreet rhoncus pharetra. " +
//                        "Integer vitae tortor et risus pretium porttitor at nec massa. Ut tempor lectus a luctus congue. " +
//                        "Quisque a nibh sit amet erat rhoncus posuere. Aliquam tincidunt nisl mattis tristique eleifend. " +
//                        "Nunc ac dolor quis velit imperdiet auctor. Proin gravida libero quis elit aliquet viverra.\n " +
//                        "Donec facilisis, dui at congue porttitor, est ligula pulvinar quam, id vestibulum sem neque sit " +
//                        "amet dolor. Pellentesque elementum in mauris sed luctus. Proin a laoreet orci. Etiam a tortor sit " +
//                        "amet lacus sagittis consequat sit amet quis est. Curabitur malesuada eros non sem hendrerit, " +
//                        "non maximus urna interdum. Sed ac tortor molestie, malesuada risus sed, venenatis eros. Fusce " +
//                        "vestibulum urna nulla, at rutrum purus blandit a. Etiam nec eleifend ex. Ut feugiat dolor sit " +
//                        "amet enim dignissim, sed dapibus ligula commodo. Pellentesque nec lectus posuere, ultrices purus " +
//                        "quis, aliquam tellus. Integer non lacus neque. Mauris sed egestas eros, at fermentum lorem. Maecenas " +
//                        "dignissim aliquam fringilla.\n Etiam ac lobortis dui, eget porttitor magna. Fusce lacus libero, " +
//                        "efficitur eu ultrices eu, feugiat id nisl. Mauris dapibus sollicitudin magna, ac sagittis mauris " +
//                        "viverra eu. Suspendisse mattis enim blandit venenatis ultrices. Etiam neque felis, placerat eget " +
//                        "laoreet et, euismod id nunc. Vivamus nec faucibus eros. Nam ultrices erat eu nisi commodo lobortis" +
//                        ". Ut blandit tellus ut ligula mattis malesuada at ut purus. Interdum et malesuada fames ac ante " +
//                        "ipsum primis in faucibus. Sed blandit blandit placerat. Donec vitae elit nec nisl mollis vestibulum " +
//                        "tempor ut lectus.\n" + "\n" + "Duis ut pulvinar velit. Nam cursus ac lectus vitae gravida. Donec " +
//                        "in suscipit est. Pellentesque nec risus aliquam lectus rhoncus sagittis. Nam pulvinar dolor et " +
//                        "risus condimentum, eget mattis tellus fermentum. Vestibulum ante ipsum primis in faucibus orci " +
//                        "luctus et ultrices posuere cubilia Curae; Curabitur in vestibulum metus, at commodo erat. Nunc " +
//                        "quis magna nec felis ornare lobortis ac sed ipsum. In non est convallis, laoreet elit quis, " +
//                        "fringilla odio. Nam et eros eu mauris rhoncus finibus ut ac dolor. Aliquam ac lorem consectetur, " +
//                        "pharetra sapien quis, convallis leo. Donec porttitor justo ac urna pretium, ac consequat lectus " +
//                        "ultricies.\n" + "\n" + "Nullam ac hendrerit massa, at ornare quam. Etiam pulvinar ante non felis " +
//                        "tincidunt, non euismod lectus accumsan. Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
//                        "Donec et mollis dui. Aenean turpis felis, mattis id malesuada sit amet, venenatis ac mauris. " +
//                        "Suspendisse luctus cursus tellus. Vestibulum feugiat magna sed bibendum posuere. Phasellus vel " +
//                        "ullamcorper lacus. Fusce vitae vestibulum elit. Aenean facilisis tempor tellus. Nunc condimentum " +
//                        "nisi purus, non porttitor orci molestie a.\n" + "\n",
//                author2
//        );
//        article11.addView();
//        article11.addView();
//        article11.setImageLink("https://www.thehappycatsite.com/wp-content/uploads/2017/10/best-treats-for-kittens.jpg");
//        article11.updateArticleDate();
//        DBHelper.save(article11);
//
//        Article article12 = new Article("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rutrum, arcu nec auctor ullamcorper, est " +
//                        "dui hendrerit purus, sit amet ullamcorper felis erat sit amet ex. Quisque ac tristique tortor. " +
//                        "Duis vel nulla ut enim mollis hendrerit vitae nec sem. Vivamus at rutrum diam, id mattis velit. " +
//                        "Suspendisse a metus auctor, consectetur lorem sed, pellentesque lectus. Suspendisse potenti. Nam " +
//                        "nunc eros, tincidunt et lacinia vitae, vulputate id justo. Vestibulum laoreet rhoncus pharetra. " +
//                        "Integer vitae tortor et risus pretium porttitor at nec massa. Ut tempor lectus a luctus congue. " +
//                        "Quisque a nibh sit amet erat rhoncus posuere. Aliquam tincidunt nisl mattis tristique eleifend. " +
//                        "Nunc ac dolor quis velit imperdiet auctor. Proin gravida libero quis elit aliquet viverra.\n " +
//                        "Donec facilisis, dui at congue porttitor, est ligula pulvinar quam, id vestibulum sem neque sit " +
//                        "amet dolor. Pellentesque elementum in mauris sed luctus. Proin a laoreet orci. Etiam a tortor sit " +
//                        "amet lacus sagittis consequat sit amet quis est. Curabitur malesuada eros non sem hendrerit, " +
//                        "non maximus urna interdum. Sed ac tortor molestie, malesuada risus sed, venenatis eros. Fusce " +
//                        "vestibulum urna nulla, at rutrum purus blandit a. Etiam nec eleifend ex. Ut feugiat dolor sit " +
//                        "amet enim dignissim, sed dapibus ligula commodo. Pellentesque nec lectus posuere, ultrices purus " +
//                        "quis, aliquam tellus. Integer non lacus neque. Mauris sed egestas eros, at fermentum lorem. Maecenas " +
//                        "dignissim aliquam fringilla.\n Etiam ac lobortis dui, eget porttitor magna. Fusce lacus libero, " +
//                        "efficitur eu ultrices eu, feugiat id nisl. Mauris dapibus sollicitudin magna, ac sagittis mauris " +
//                        "viverra eu. Suspendisse mattis enim blandit venenatis ultrices. Etiam neque felis, placerat eget " +
//                        "laoreet et, euismod id nunc. Vivamus nec faucibus eros. Nam ultrices erat eu nisi commodo lobortis" +
//                        ". Ut blandit tellus ut ligula mattis malesuada at ut purus. Interdum et malesuada fames ac ante " +
//                        "ipsum primis in faucibus. Sed blandit blandit placerat. Donec vitae elit nec nisl mollis vestibulum " +
//                        "tempor ut lectus.\n" + "\n" + "Duis ut pulvinar velit. Nam cursus ac lectus vitae gravida. Donec " +
//                        "in suscipit est. Pellentesque nec risus aliquam lectus rhoncus sagittis. Nam pulvinar dolor et " +
//                        "risus condimentum, eget mattis tellus fermentum. Vestibulum ante ipsum primis in faucibus orci " +
//                        "luctus et ultrices posuere cubilia Curae; Curabitur in vestibulum metus, at commodo erat. Nunc " +
//                        "quis magna nec felis ornare lobortis ac sed ipsum. In non est convallis, laoreet elit quis, " +
//                        "fringilla odio. Nam et eros eu mauris rhoncus finibus ut ac dolor. Aliquam ac lorem consectetur, " +
//                        "pharetra sapien quis, convallis leo. Donec porttitor justo ac urna pretium, ac consequat lectus " +
//                        "ultricies.\n" + "\n" + "Nullam ac hendrerit massa, at ornare quam. Etiam pulvinar ante non felis " +
//                        "tincidunt, non euismod lectus accumsan. Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
//                        "Donec et mollis dui. Aenean turpis felis, mattis id malesuada sit amet, venenatis ac mauris. " +
//                        "Suspendisse luctus cursus tellus. Vestibulum feugiat magna sed bibendum posuere. Phasellus vel " +
//                        "ullamcorper lacus. Fusce vitae vestibulum elit. Aenean facilisis tempor tellus. Nunc condimentum " +
//                        "nisi purus, non porttitor orci molestie a.\n" + "\n",
//                author2
//        );
//        article12.addView();
//        article12.addView();
//        article12.setImageLink("https://www.thehappycatsite.com/wp-content/uploads/2017/10/best-treats-for-kittens.jpg");
//        article12.updateArticleDate();
//        DBHelper.save(article12);
//
//        Article article13 = new Article("Wake up human for food at 4am i like big cats and i can not lie\n",
//                "Attack the child lick left leg for ninety minutes, still dirty. Chase laser " +
//                        "i'm going to lap some water out of my master's cup meow mice take a big fluffing crap" +
//                        " \uD83D\uDCA9 so hack, but roll over and sun my belly. Lick butt lounge in doorway for " +
//                        "i cry and cry and cry unless you pet me, and then maybe i cry just for fun yet stand in " +
//                        "doorway, unwilling to chose whether to stay in or go out. Paw at your fat belly meow to be" +
//                        " let out so groom forever, stretch tongue and leave it slightly out, blep. Hide from vacuum " +
//                        "cleaner who's the baby, but make meme, make cute face yet chase after silly colored fish toys" +
//                        " around the house poop in a handbag look delicious and drink the soapy mopping up water then " +
//                        "puke giant foamy fur-balls for knock dish off table head butt cant eat out of my own dish " +
//                        "ptracy. Chew the plant i like fish meoooow groom forever, stretch tongue and leave it " +
//                        "slightly out, blep headbutt owner's knee hunt anything that moves. Hiss at vacuum cleaner" +
//                        " you are a captive audience while sitting on the toilet, pet me. Scratch sleep lick arm " +
//                        "hair. Swat at dog sniff other cat's butt and hang jaw half open thereafter, yet lie on your" +
//                        " belly and purr when you are asleep and nap all day, but cat not kitten around . Nya nya nyan" +
//                        " under the bed. Ask to be pet then attack owners hand hiss and stare at nothing then run " +
//                        "suddenly away. Why must they do that destroy couch, or instantly break out into full" +
//                        " speed gallop across the house for no reason, but scream at teh bath. Hunt anything " +
//                        "that moves i'm bored inside, let me out i'm lonely outside, let me in i can't make up my " +
//                        "mind whether to go in or out, guess i'll just stand partway in and partway out, " +
//                        "contemplating the universe for half an hour how dare you nudge me with your foot?!?! " +
//                        "leap into the air in greatest offense! lick plastic bags. I like cats because they are " +
//                        "fat and fluffy poop in litter box, scratch the walls so lick the curtain just to be annoying" +
//                        " or fooled again thinking the dog likes me so damn that dog jump around on couch, meow " +
//                        "constantly until given food, so pet me pet me don't pet me. ", author2);
//        article13.addView();
//        article13.addView();
//        article13.setImageLink("http://www.cbc.ca/cbcdocspov/content/images/episodes/lohlala.jpg");
//        article13.updateArticleDate();
//        DBHelper.save(article13);
//
//        Article article14 = new Article("Wack the mini furry mouse",
//                "Stares at human while pushing stuff off a table chew iPad power cord, yet sit in " +
//                        "window and stare oooh, a bird, yum crash against wall but walk away like nothing happened." +
//                        " Get my claw stuck in the dog's ear sun bathe. Love you, then bite you flop over, and head " +
//                        "nudges yet eat plants, meow, and throw up because i ate plants that box? i can fit in that" +
//                        "box taco cat backwards spells taco cat. Ask to be pet then attack owners hand cough yet" +
//                        " find a way to fit in tiny box so hunt by meowing loudly at 5am next to human slave food " +
//                        "dispenser for lick the plastic bag, pose purrfectly to show my beauty, use lap as chair. " +
//                        "Get suspicious of own shadow then go play with toilette paper destroy house in 5 seconds. " +
//                        "Refuse to leave cardboard box meow in empty rooms or climb a tree, wait for a fireman jump" +
//                        " to fireman then scratch his face hack, for hit you unexpectedly or bring your owner a dead " +
//                        "bird. Kick up litter stand in front of the computer screen catasstrophe. Meowwww chase laser " +
//                        "but has closed eyes but still sees you. Cry louder at reflection decide to want nothing to do" +
//                        " with my owner today hide at bottom of staircase to trip human. Step on your keyboard while " +
//                        "you're gaming and then turn in a circle . Find empty spot in cupboard and sleep all day jump" +
//                        " on human and sleep on her all night long be long in the bed, purr in the morning and then" +
//                        " give a bite to every human around for not waking up request food, purr loud scratch the " +
//                        "walls, the floor, the windows, the humans curl into a furry donut. Floof tum, tickle bum," +
//                        " jellybean footies curly toes who's the baby all of a sudden cat goes crazy kitty power " +
//                        "for cat dog hate mouse eat string barf pillow no baths hate everything this cat happen now," +
//                        " it was too purr-fect!!!. Hunt by meowing loudly at 5am next to human slave food dispenser " +
//                        "intently stare at the same spot jump on human and sleep on her all night long be long in " +
//                        "the bed, purr in the morning and then give a bite to every human around for not waking up" +
//                        " request food, purr loud scratch the walls, the floor, the windows, the humans or sit in" +
//                        " box small kitty warm kitty little balls of fur but favor packaging over toy. Flee in " +
//                        "terror at cucumber discovered on floor i could pee on this if i had the energy so chase " +
//                        "red laser dot purr while eating suddenly go on wild-eyed crazy rampage for hiding behind" +
//                        " the couch until lured out by a feathery toy scratch at fleas, meow until belly rubs, hide " +
//                        "behind curtain when vacuum cleaner is on scratch strangers and poo on owners food. Steal " +
//                        "the warm chair right after you get up refuse to leave cardboard box and chase the pig" +
//                        "around the house or meow. Stare at imaginary bug eat grass, throw it back up cereal boxes" +
//                        " make for five star accommodation . The door is opening! how exciting oh, it's you, meh eat" +
//                        " too much then proceed to regurgitate all over living room carpet while humans eat dinner," +
//                        " sun bathe. Meow to be let out. Pelt around the house and up and down stairs chasing" +
//                        " phantoms mice pretend you want to go out but then don't i like cats because they are fat " +
//                        "and fluffy, for taco cat backwards spells taco cat. Disappear for four days and return" +
//                        " home with an expensive injury; bite the vet claws in your leg, so lick the curtain just" +
//                        " to be annoying, yet meowing chowing and wowing or ooh, are those your $250 dollar sandals? " +
//                        "lemme use that as my litter box, hunt anything that moves cat cat moo moo lick ears " +
//                        "lick paws. Put butt in owner's face playing with balls of wool so i can haz yet groom " +
//                        "yourself 4 hours - checked, have your beauty sleep 18 hours - checked, be fabulous for" +
//                        " the rest of the day - checked. Steal the warm chair right after you get up scratch the " +
//                        "box pet me pet me don't pet me woops poop hanging from butt must get rid run run around " +
//                        "house drag poop on floor maybe it comes off woops left brown marks on floor human slave " +
//                        "clean lick butt now. Reward the chosen human with a slow blink open the door, let me out," +
//                        " let me out, let me-out, let me-aow, let meaow, meaow! sleep in the bathroom sink wake up" +
//                        " human for food at 4am so get my claw stuck in the dog's ear or plan steps for world" +
//                        " domination yet knock over christmas tree. Spend six hours per day washing, but still" +
//                        " have a crusty butthole howl on top of tall thing so knock dish off table head butt cant" +
//                        " eat out of my own dish. Cat is love, cat is life scamper dream about hunting birds love," +
//                        " i just saw other cats inside the house and nobody ask me before using my litter box. \n" +
//                        "\n" +
//                        "Vommit food and eat it again. My slave human didn't give me any food so i pooped on" +
//                        " the floor cat mojo but cough hairball, eat toilet paper and that box? i can fit in " +
//                        "that box for sniff other cat's butt and hang jaw half open thereafter have secret plans. " +
//                        "Thug cat sniff other cat's butt and hang jaw half open thereafter yet purr as loud as" +
//                        " possible, be the most annoying cat that you can, and, knock everything off the table." +
//                        " Stare at ceiling light hiding behind the couch until lured out by a feathery toy stuff " +
//                        "and things howl uncontrollably for no reason or sit on the laptop yet lick butt stare at" +
//                        " ceiling light. Cough bring your owner a dead bird loved it, hated it, loved it, hated " +
//                        "it yet sleep nap, or stare at the wall, play with food and get confused by dust eat too " +
//                        "much then proceed to regurgitate all over living room carpet while humans eat dinner." +
//                        " Chew iPad power cord fooled again thinking the dog likes me or meow all night. ", author2);
//        article14.addView();
//        article14.addView();
//        article14.setImageLink("https://www.freegreatpicture.com/files/157/1562-cute-little-cat.jpg");
//        article14.updateArticleDate();
//        DBHelper.save(article14);
//
//
//        Article article15 = new Article("Give me attention or face the wrath of my claws sniff sniff kitty loves pigs",
//                "Jump five feet high and sideways when a shadow moves stare at ceiling light, but if it smells like " +
//                        "fish eat as much as you wish so eat plants, meow, and throw up because i ate plants so sniff" +
//                        " all the things and chase ball of string. Present belly, scratch hand when stroked run outside " +
//                        "as soon as door open mark territory. Leave dead animals as gifts hiding behind the couch until" +
//                        " lured out by a feathery toy wake up human for food at 4am so sleep everywhere, but not in my" +
//                        " bed jump five feet high and sideways when a shadow moves, or mewl for food at 4am. Instantly" +
//                        " break out into full speed gallop across the house for no reason hack, and tuxedo cats always " +
//                        "looking dapper push your water glass on the floor but when owners are asleep, cry for no " +
//                        "apparent reason, and open the door, let me out, let me out, let me-out, let me-aow, let " +
//                        "meaow, meaow! sit on the laptop. Dream about hunting birds grab pompom in mouth and put" +
//                        " in water dish the dog smells bad sniff sniff. Intently stare at the same spot chew foot " +
//                        "kitty scratches couch bad kitty, poop on grasses ooh, are those your $250 dollar sandals? " +
//                        "lemme use that as my litter box yet hit you unexpectedly. Swat at dog stick butt in face, " +
//                        "for love and scratch at the door then walk away so the door is opening! how exciting oh, " +
//                        "it's you, meh. Meow meow, i tell my human i like frogs and 0 gravity. Cats go for world " +
//                        "domination leave dead animals as gifts love blinks and purr purr purr purr yawn kitty " +
//                        "loves pigs open the door, let me out, let me out, let me-out, let me-aow, let meaow," +
//                        " meaow! eat from dog's food. Fooled again thinking the dog likes me nap all day, or" +
//                        " have a lot of grump in yourself because you can't forget to be grumpy and not be like " +
//                        "king grumpy cat. ", author2);
//
//        article15.addView();
//        article15.addView();
//        article15.setImageLink("https://i.ytimg.com/vi/YCaGYUIfdy4/maxresdefault.jpg");
//        article15.updateArticleDate();
//        DBHelper.save(article15);
//
//
//
//
//        DBArticle.updateArticlesSections(article2, home);
//        DBArticle.updateArticlesSections(article3, cookingSections);
//        DBArticle.updateArticlesSections(article1, environmentSections);
//
//



    }

}

