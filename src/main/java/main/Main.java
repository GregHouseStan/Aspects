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
        service.publishComment(comment);
        service.deleteComment(comment);
        service.editComment(comment);
       // System.out.println(service.getClass());



    }




}