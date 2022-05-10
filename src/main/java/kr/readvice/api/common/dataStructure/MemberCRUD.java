package kr.readvice.api.common.dataStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.*;


public class MemberCRUD {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        MemberService service = new MemberServiceImpl();
        while (true){
            System.out.println("0.exit 1.save 2.update 3.delete 4.findById 5.findByName 6.findAll 7.count 8.existsById");
            switch (s.next()){
                case "0":return;
                case "1":
                    Member hong = new Member.Builder("hong")
                            .email("hong.test.com")
                            .password("1")
                            .name("홍길동")
                            .phone("010-0000-0000")
                            .profileImg("hong.jpg")
                            .build();
                    service.save(hong);
                    Member kim = new Member.Builder("kim")
                            .email("kim@test.com")
                            .password("1")
                            .name("김유신")
                            .phone("010-0044-9944")
                            .profileImg("kim.jpg")
                            .build();
                    service.save(kim);
                    Member you = new Member.Builder("you")
                            .email("you@test.com")
                            .password("1")
                            .name("유관순")
                            .phone("010-0880-9889")
                            .profileImg("you.jpg")
                            .build();
                    service.save(you);
                    break;
                case "2":
                    Member noh = new Member.Builder("noh")
                            .email("noh@test.com")
                            .password("1")
                            .name("노노노")
                            .phone("010-0888-9888")
                            .profileImg("noh.jpg")
                            .build();
                    service.update(noh);
                    break;
                case "3":
                    Member temp = new Member();
                    temp.setUserid("kim");
                    service.delete(temp);
                    break;
                case "4":
                    System.out.println(service.existsById("kim") ? "찾는 회원이 여기 있습니다. 짜란~"+service.findById("kim") : "찾는 회원이 없습니다.");
                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":
                    System.out.println("총 회원수: "+service.count());
                    break;
                case "8":
                    System.out.println("회원 유무: "+service.existsById("kim"));
                    break;
                default:break;
            }
        }
    }
    @Data @NoArgsConstructor
    static class Member{
        protected String userid, name, password, profileImg, phone, email;

        public Member(Builder builder) {
            this.userid=builder.userid;
            this.name=builder.name;
            this.password=builder.password;
            this.profileImg=builder.profileImg;
            this.phone=builder.phone;
            this.email=builder.email;
        }

        static class Builder {
            private String userid, name, password, profileImg, phone, email;

            public Builder(String userid) {
                this.userid = userid;
            }

            public Builder name(String name) {
                this.name = name;
                return this;
            }

            public Builder password(String password) {
                this.password = password;
                return this;
            }

            public Builder profileImg(String profileImg) {
                this.profileImg = profileImg;
                return this;
            }

            public Builder phone(String phone) {
                this.phone = phone;
                return this;
            }

            public Builder email(String email) {
                this.email = email;
                return this;
            }

            Member build() {
                return new Member(this);
            }
        }
        @Override public String toString(){
            return String.format("[사용자 스펙] userid: %s, name: %s, password: %s, profileImg: %s, phone: %s, email: %s",
                    userid, name, password, profileImg, phone, email);
        }
    }
    interface MemberService{
        void save(Member member);
        void update(Member member);
        void delete(Member member);
        Member findById(String id);
        List<Member> findByName(String name);
        List<Member> findAll();
        int count();
        boolean existsById(String id);
    }

    static class MemberServiceImpl implements MemberService{
        private final Map<String, Member> map;
        MemberServiceImpl(){
            this.map = new HashMap<>();
        }
        @Override
        public void save(Member member){
            map.put(member.getUserid(), member);
        }

        @Override
        public void update(Member member) {
            map.replace(member.getUserid(), member);
        }

        @Override
        public void delete(Member member) {
            map.remove(member.getUserid(), member);
        }

        @Override
        public Member findById(String id) {
            return map.get(id);
        }

        @Override
        public List<Member> findByName(String name) {
            return (List<Member>) map.get(name);
        }

        @Override
        public List<Member> findAll() {
            return (List<Member>) map.values();
        }

        @Override
        public int count() {
            return map.size();
        }

        @Override
        public boolean existsById(String id) {
            return map.containsKey(id);
        }
    }

}
