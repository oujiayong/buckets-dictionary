package buckets.framework.dictionary;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan("buckets.framework.dictionary.core.dao")
public class BucketsDictionaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BucketsDictionaryApplication.class, args);
    }

}
