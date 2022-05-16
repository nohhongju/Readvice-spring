package kr.readvice.api.common.streams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonStream {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Person {
        private String name, ssn;

        @Override // 123-parseInt(substring(0,2))
        public String toString(){
            String gender = ssn.substring(7).equals("1") || ssn.substring(7).equals("3")? "남자":"여자";
            int yy = Integer.parseInt(ssn.substring(0, 2));
            int age = (yy <= 20)? 23-yy:123-yy;
            return String.format(" %s, %s, %s", name, gender, age);
        }
    }
    //기능: 회원검색
    interface PersonService{
        Person search(List<Person> arr);
    }
    static class PersonServiceImpl implements PersonService{

        @Override
        public Person search(List<Person> arr) {
            return arr
                    .stream()
                    .filter(e -> e.getName().equals("유관순"))
                    .collect(Collectors.toList()).get(0);
        }
    }
    @Test
    void personStreamTest(){
        // "홍길동", "900120-1"
        // "김유신", "970620-1"
        // "유관순", "040920-4"
        // 남성, 여성, 나이 판단 로직
        List<Person> arr = Arrays.asList(
                Person.builder().name("홍길동").ssn("900120-1").build(),
                Person.builder().name("김유신").ssn("970620-1").build(),
                Person.builder().name("유관순").ssn("040920-4").build()
        );
        System.out.println(new PersonServiceImpl()
                .search(arr));
    }
}
