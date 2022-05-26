package kr.readvice.api.common.lambda;

import org.junit.Test;
import org.springframework.format.datetime.standard.DateTimeContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

public class LambdaLab {
    public static String solution(){
        Supplier<String> s = () -> new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return s.get();
    }
    @Test
    public void testSolution(){
        System.out.println(solution());
    }
}
