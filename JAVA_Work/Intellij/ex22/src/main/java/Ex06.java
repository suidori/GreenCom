import java.util.Optional;

class ContInfo{
    String phone;
    String address;

    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    public ContInfo(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }
}

public class Ex06 {
    public static void main(String[] args) {
        Optional<ContInfo> contInfo = Optional.of(new ContInfo(null, "KOREA DAEGU"));

        String phone = contInfo.map(ContInfo::getPhone)
                .orElse("There is no Phone Number");
        String address = contInfo.map(ContInfo::getAddress)
                        .orElse("There is no Address");

        System.out.println(phone);
        System.out.println(address);
    }
}
