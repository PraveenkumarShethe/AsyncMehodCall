package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableAsync
public class Application implements CommandLineRunner {

    @Autowired
    GitHubLookupService gitHubLookupService;

    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        System.out.println("<==============================Starting point===================================>");
        System.out.println("<==============================Starting point===================================>");
        System.out.println();
        System.out.println();
        System.out.println();
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        System.out.println("Current time 1     ================= >"+(System.currentTimeMillis() - start) +" ms");
        CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        System.out.println("Current time 2     ================= >"+(System.currentTimeMillis() - start) +" ms");
        CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");
        System.out.println("Current time 3     ================= >"+(System.currentTimeMillis() - start) +" ms");

        // Wait until they are all done
        //while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
          //  Thread.sleep(10); //10-millisecond pause between each check
        //}

        //wait until all they are completed.
        System.out.printf("this is here!!!");
        CompletableFuture.allOf(page1,page2,page3).join();
        System.out.println("execution completed!!!");
        //I could join as well if interested.

        // Print results, including elapsed time
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start) +" ms");
        System.out.println(page1.get());
        System.out.println(page2.get());
        System.out.println(page3.get());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("<==============================END point===================================>");
        System.out.println("<==============================END point===================================>");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
