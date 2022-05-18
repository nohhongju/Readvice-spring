package kr.readvice.api.common.streams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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
        private boolean getGenderChecker(String ssnG){
            return ssn.substring(7).equals(ssnG);
        }
        @Override
        public String toString(){
            String gender = getGenderChecker("1") || getGenderChecker("3")? "남자":"여자";
            LocalDate now = LocalDate.now();
            int year = now.getYear();
            int yy = Integer.parseInt(ssn.substring(0, 2));
            int age = getGenderChecker("1") || getGenderChecker("2")? year-(1900+yy)+1:year-(2000+yy)+1; // 1의 의미 - 한국나이로 태어나면 1살부터 시작
            return String.format(" %s, %s, %s", name, gender, age);
        }
    }
    //기능: 회원검색
    @FunctionalInterface interface PersonService{
        Person search(List<Person> arr);
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
        PersonService ps = persons -> persons
                .stream()
                .filter(e -> e.getName().equals("홍길동"))
                .collect(Collectors.toList()).get(0);
        System.out.println(ps.search(arr));
    }
}
