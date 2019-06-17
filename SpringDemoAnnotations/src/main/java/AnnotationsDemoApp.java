import com.anyrem.springdemo2.BowlingCoach;
import com.anyrem.springdemo2.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
        Coach bowlingCoach = context.getBean("bowlingCoach", BowlingCoach.class);

        System.out.println(bowlingCoach.getDailyWorkout());

        System.out.println(tennisCoach.getDailyWorkout());
        System.out.println(tennisCoach.getDailyFortune());

        context.close();

    }

}
