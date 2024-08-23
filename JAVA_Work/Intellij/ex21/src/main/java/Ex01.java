public class Ex01 {

    public static void main(String[] args) {

        MemberDto.MemberReqDto memberReqDto
                = new MemberDto.MemberReqDto("홍길동", 20);

        System.out.println(memberReqDto);

        MemberDto.MemberResDto memberResDto
                = new MemberDto.MemberResDto("박길동", 30);

        System.out.println(memberResDto);
    }
}
