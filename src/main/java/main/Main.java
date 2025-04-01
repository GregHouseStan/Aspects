package main;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        var service = c.getBean(CommentService.class);
        Logger logger = Logger.getLogger(Main.class.getName());

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Natasha");
        String value = service.publishComment(comment);
       // System.out.println(service.getClass());
        logger.info(value);


    }




}